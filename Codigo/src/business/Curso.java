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
	
	public Curso(String nome, int id) {
		setNome(nome);
		setId(id);
		disciplinas = new ArrayList<>();
		alunos = new ArrayList<>();
		turmas = new ArrayList<>();
	}

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
		this.disciplinas = disciplinas;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria() {
		this.cargaHoraria = this.disciplinas.stream().reduce(0, (subTotal, d) -> subTotal + d.getCredito(), Integer::sum);
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
		setCargaHoraria();
	}
	public void addTurma(Turma turma){
		this.turmas.add(turma);
	}
	public boolean removerAluno(Aluno aluno){
		return this.alunos.remove(aluno);
	}

	public boolean removerDisciplina(Disciplina disciplina){
		boolean removeu = this.disciplinas.remove(disciplina);
		setCargaHoraria();
		return removeu;

	}
	public boolean removerTurma(Turma turma){
		return this.turmas.remove(turma);
	}

	public List<Turma> getTurmas() {
		return turmas;
	};
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nome).append("\n");
		this.disciplinas.forEach(d -> sb.append(d.getNome()).append("\n"));
		return sb.toString();
		
	}
}
