package business;

import java.util.List;

public class Turma {
	private int cod_turma;
	private String semestre;
	private List<Professor> professores;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	private boolean matriculaAberta;
	
	public void adicionarProfessor(Professor prof) {
		this.getProfessores().add(prof);
	};
	
	public Professor removerProfessor(Professor prof) {
		int index = this.getProfessores().indexOf(prof);
		return this.getProfessores().remove(index);
		};
	
	public void adicionarAluno(Aluno aluno) {
		this.getAlunos().add(aluno);
	};
	
	public Aluno removerAluno(Aluno aluno) {
		int index = this.getAlunos().indexOf(aluno);
		return this.getAlunos().remove(index);
		}

	public int getCod_turma() {
		return cod_turma;
	}

	public void setCod_turma(int cod_turma) {
		this.cod_turma = cod_turma;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void abrirMatricula(boolean abrir) {
		matriculaAberta = abrir;
	}

	public boolean isMatriculaAberta() {
		return matriculaAberta;
	};
}
