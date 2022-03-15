package dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import business.Curso;

public class CursoDAO implements IDAO<Curso> {
	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public CursoDAO(String nomeArquivo) throws IOException {
		file = new File(nomeArquivo);
		fos = new FileOutputStream(file, true);
		outputFile = new ObjectOutputStream(fos);

	}

	@Override
	public void add(Curso c) {
		try {
			outputFile.writeObject(c);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}

	}

	@Override
	public void update(Curso c) {
		List<Curso> list = getAll();
		int pos = list.indexOf(c);
		if (pos != -1)
			list.set(pos, c);
		saveAll(list);
	}

	@Override
	public void delete(Curso c) {
		List<Curso> list = getAll();
		saveAll(list);

	}

	@Override
	public Curso get(Curso c) {
		Curso resPedido = null;
		List<Curso> list = getAll();
		for (Curso sec : list) {
			if (c.equals(sec)) {
				resPedido = sec;
			}
		}
		return resPedido;
	}

	@Override
	public List<Curso> getAll() {
		List<Curso> list = new ArrayList<>();
		try (ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(file))) {
			Curso c;
			c = (Curso) inputFile.readObject();
			while (c != null) {
				list.add(c);
				c = (Curso) inputFile.readObject();
			}

		} catch (EOFException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace(System.err);
		}

		return list;
	}

	private void saveAll(List<Curso> list) {

		try {
			close();

			fos = new FileOutputStream(file, true);
			outputFile = new ObjectOutputStream(fos);

			for (Curso c : list) {
				outputFile.writeObject(c);
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}

	}

	public void close() throws IOException {
		outputFile.close();
		fos.close();
	}

	@Override
	protected void finalize() throws Throwable {
		this.close();
	}
}
