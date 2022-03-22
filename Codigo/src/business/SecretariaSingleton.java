package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.CursoDAO;
import exception.SecretariaException;

public class SecretariaSingleton {
	private List<Professor> professores;
	private List<Curso> cursos;
	private static final SecretariaSingleton INSTANCIA = new SecretariaSingleton();
	
	private SecretariaSingleton() {
		professores = new ArrayList<Professor>();
		cursos = new ArrayList<Curso>();
	}
	
	public static SecretariaSingleton getInstancia() {
		return INSTANCIA;
	}
	
	public void gerarCurriculo(Curso curso) throws IOException {
		CursoDAO file = new CursoDAO("curriculo.bin");
		file.add(curso);
	}

	public void matricularAluno(Aluno aluno, Curso curso) throws SecretariaException {
		if (aluno != null && curso != null) {
			cursos.stream().filter(current_curso -> current_curso.equals(curso)).forEach(current_curso -> curso.addAluno(aluno));
		} else if (aluno == null) {
			throw new SecretariaException("Não foi possível adicionar o aluno. (Aluno Nulo)");
		} else {
			throw new SecretariaException("Não foi possível adicionar o aluno. (Curso Nulo)");
		}
	}
	
	public void contratarProfessor(Professor prof) throws SecretariaException {
		if (prof != null) {
			professores.add(prof);
		} else {
			throw new SecretariaException("Não foi possível contratar o professor. (Professor Nulo)");
		}
	}
	
	public Professor demitirProfessor(Professor prof) throws SecretariaException {
		Iterator<Professor> iter= professores.iterator();
		boolean achou = false;
		while(iter.hasNext()){
		    Professor p = iter.next();
		    if(p.equals(prof)){
		        iter.remove();
		        achou = true;
		    }
		}
		if (!achou)
			throw new SecretariaException("Não foi possível demitir o professor. (Professor não contratado)");
		
		return prof;
		}
	
	public void adicionarCurso(Curso curso) throws SecretariaException {
		if (curso != null) {
			cursos.add(curso);
		} else {
			throw new SecretariaException("Não foi possível adicionar o curso. (Curso Nulo)");
		}
	}
	
	public Curso removerCurso(Curso curso) throws SecretariaException {
		Iterator<Curso> iter = cursos.iterator();
		boolean achou = false;
		while(iter.hasNext()){
			Curso p = iter.next();
		    if(p.equals(curso)){
		        iter.remove();
		        achou = true;
		    }
		}
		if (!achou)
			throw new SecretariaException("Não foi possível remover o curso. (Curso não adicionado)");
		
		return curso;
		}
		
		public void adicionarDisciplinaCurso(Disciplina disciplina, Curso curso) throws SecretariaException {
			if (curso != null) {
				curso.addDisciplina(disciplina);
			} else {
				throw new SecretariaException("Não foi possível adicionar o curso. (Curso Nulo)");
			}
		}

	
	public void adicionarDisciplina(Disciplina disciplina, Curso curso) throws SecretariaException {
		if (curso != null && disciplina != null) {
			cursos.stream().filter(current_curso -> current_curso.equals(curso)).forEach(current_curso -> curso.addDisciplina(disciplina));
		} else if (curso == null) {
			throw new SecretariaException("Não foi possível adicionar a disciplina. (Curso nulo)");
		} else {
			throw new SecretariaException("Não foi possível adicionar a disciplina. (Disciplina nula)");
		}
		
	}
	
	public Disciplina removerDisciplina(Disciplina disciplina, Curso curso) throws SecretariaException {
		Iterator<Curso> iter = cursos.iterator();
		boolean achou = false;
		while(iter.hasNext()){
			Curso p = iter.next();
		    if(p.equals(curso)){
		    	Iterator<Disciplina> iter_sec = curso.getDisciplinas().iterator();
		    	while(iter_sec.hasNext()){
		    		Disciplina d = iter_sec.next();
		    		if(d.equals(disciplina)){
		    			iter_sec.remove();
		    			achou = true;
		    		}
		    	}   
		    }
		}
		if (!achou)
			throw new SecretariaException("Não foi possível remover a disciplina. (Disciplina não adicionada)");
		
		return disciplina;
		}

	public void manusearMatriculaGeral(Curso curso, boolean abrir) throws SecretariaException {
		if (abrir)
			cursos.stream().filter(current_curso -> current_curso.equals(curso)).forEach(current_curso -> curso.getTurmas().forEach(turma -> turma.abrirMatricula(abrir)));
		else
			for(int i = 0; i < cursos.size(); i++) {
				if (cursos.get(i).equals(curso))
					for(int j = 0; j < cursos.get(i).getTurmas().size(); j++) {
						if (cursos.get(i).getTurmas().get(j).getAlunos().size() >= 3)
							cursos.get(i).getTurmas().get(j).abrirMatricula(false);
						else {
							cursos.get(i).getTurmas().remove(j);
							throw new SecretariaException("Não foi possível fechar a matricula para a turma "+ cursos.get(i).getTurmas().get(j).toString()+". Cancelando a turma... (Menos de 3 alunos matriculados)");
						}
					}
			}
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public List<Curso> getCursos() {
		return cursos;
	}
}
