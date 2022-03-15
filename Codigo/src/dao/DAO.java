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

public class DAO implements IDAO {
	private File file;
	private FileOutputStream fos;
	private ObjectOutputStream outputFile;

	public DAO(String nomeArquivo) throws IOException {
		file = new File(nomeArquivo);
		fos = new FileOutputStream(file, true);
		outputFile = new ObjectOutputStream(fos);

	}

	@Override
	public void add(Pedido p) {
		try {
			outputFile.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}

	}

	@Override
	public void update(Pedido p) {
		List<Pedido> list = getAll();
		int pos = list.indexOf(p);
		if (pos != -1)
			list.set(pos, p);
		saveAll(list);
	}

	@Override
	public void delete(Pedido p) {
		List<Pedido> list = getAll();
		//list = list.stream().filter(pedido -> !pedido.equals(p)).toList();
		saveAll(list);

	}

	@Override
	public Pedido get(Pedido p) {
		Pedido resPedido = null;
		List<Pedido> list = getAll();
		for (Pedido pedido : list) {
			if (p.equals(pedido)) {
				resPedido = pedido;
			}
		}
		return resPedido;
	}

	@Override
	public List<Pedido> getAll() {
		List<Pedido> list = new ArrayList<>();
		try (ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(file))) {
			Pedido p;
			p = (Pedido) inputFile.readObject();
			while (p != null) {
				list.add(p);
				p = (Pedido) inputFile.readObject();
			}

		} catch (EOFException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace(System.err);
		}

		return list;
	}

	private void saveAll(List<Pedido> list) {

		try {
			close();

			fos = new FileOutputStream(file, true);
			outputFile = new ObjectOutputStream(fos);

			for (Pedido pedido : list) {
				outputFile.writeObject(pedido);
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
