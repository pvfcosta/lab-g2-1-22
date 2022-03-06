package business;

import java.util.List;

public class SecretariaSingleton {
	private List<Professor> professores;
	private List<Curso> cursos;
	private static final SecretariaSingleton INSTANCIA = new SecretariaSingleton();
	private boolean matriculaAberta;
	
	public static SecretariaSingleton getInstancia() {
		return INSTANCIA;
	}
	
	public void gerarCurriculo(Disciplina disciplina) {};
	
	public void matricularAluno(Aluno aluno, Curso curso) {};
	
	public void contratarProfessor(Professor prof) {};
	
	public Professor demitirProfessor(Professor prof) {return prof;};
	
	public void adicionarCurso(Curso curso) {};
	
	public Curso removerCurso(Curso curso) {return curso;};
	
	public void adicionarDisciplina(Disciplina disciplina) {};
	
	public Disciplina removerDisciplina(Disciplina disciplina) {return disciplina;};
	
	public void manusearMatricula(boolean abrirMatricula) {}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public boolean isMatriculaAberta() {
		return matriculaAberta;
	}

	public void setMatriculaAberta(boolean matriculaAberta) {
		this.matriculaAberta = matriculaAberta;
	};
	
}
