package business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.SecretariaException;

public class Turma {
	private int cod_turma;
	private String semestre;
	private List<Professor> professores;
	private Disciplina disciplina;
	private List<Aluno> alunos;
	private boolean matriculaAberta;

	public Turma (int cod, String semestre, Disciplina disciplina){
		setCod_turma(cod);
		setSemestre(semestre);
		setDisciplina(disciplina);
		this.professores = new ArrayList<>();
		this.alunos = new ArrayList<>();
		abrirMatricula(false);
	}
	
	public void adicionarProfessor(Professor prof) {
		this.getProfessores().add(prof);
	}
	
	public Professor removerProfessor(Professor prof) {
		int index = this.getProfessores().indexOf(prof);
		return this.getProfessores().remove(index);
		}
	
	public void adicionarAluno(Aluno aluno) throws SecretariaException{
		if(alunos.size()<60) {
			this.getAlunos().add(aluno);
		} else
			throw new SecretariaException ("A turma já atingiu o seu limite de alunos");
	}
	
	public Aluno removerAluno(Aluno aluno) throws SecretariaException {
		Iterator<Aluno> iter = alunos.iterator();
		boolean achou = false;
		while(iter.hasNext()){
			Aluno a = iter.next();
		    if(a.equals(aluno)){
		        iter.remove();
		        achou = true;
		    }
		}	
		if (!achou)
			throw new SecretariaException("Não foi possível remover o aluno.");
		
		return aluno;
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
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Semetre: ").append(this.semestre).append("\n")
		.append("Disciplina -> ").append(this.disciplina).append("\n")
		.append("Professores: ");
		this.professores.forEach(p -> sb.append(p.getNome()).append(" "));
		
		return sb.toString();
	}
}
