package business;

import java.util.List;

public class Aluno extends Usuario {
	private int matricula;
	private List<Disciplina> disciplinas;
	private Curso curso;
	
	public void matricular(Turma turma) {};
	
	public Turma cancelarMatricula(Turma turma) {return turma;};
	
	public void visualizarMatricula() {}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	};
}
