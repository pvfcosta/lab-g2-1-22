package business;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	private String nome;
	private int id;
	private List<Disciplina> disciplinas;
	private List<Aluno> alunos;
	private List<Turma> turmas;
	private int cargaHoraria;
	
	public void calcularCargaHoraria() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = this.disciplinas.stream().reduce(0, (subTotal, d) -> subTotal + d.getCredito(), Integer::sum);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = new ArrayList<Aluno>();
	}

	public void addAluno(Aluno aluno) {
		
	}

	public Object addDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Turma> getTurmas() {
		return turmas;
	};
}
