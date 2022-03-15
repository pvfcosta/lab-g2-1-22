package business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aluno extends Usuario {
	private int matricula;
	private List<Disciplina> disciplinas;
	private Curso curso;
	private int limiteObri = 0; 
	private int limiteOpc= 0; 
	private String estado;
	private Observer observer;
	
	public Aluno(String nome, String email, String senha, int cod_pessoa, String cpf, int matricula, Curso curso) {
		super(nome, email, senha, cod_pessoa, cpf);
		disciplinas = new ArrayList<Disciplina>();
		this.setCurso(curso);
		this.setMatricula(matricula);
	}
	
	public void matricularObrigatoria(Turma turma) {
		if(this.getLimiteObri() >= 4) {
			System.out.println("Você só pode se matricular em 4 disciplinas obrigatórias");
		} else {
			turma.adicionarAluno(this);
			disciplinas.add(turma.getDisciplina());
			this.setLimiteObri(this.getLimiteObri() + 1);
		}
	};
	
	public void matricularOptativa(Turma turma) {
		if(this.getLimiteOpc() >= 2) {
			System.out.println("Você só pode se matricular em 2 disciplinas optativas");
		} else {
			turma.adicionarAluno(this);
			disciplinas.add(turma.getDisciplina());
			this.setLimiteOpc(this.getLimiteOpc() + 1);
		}
	};
	
	public Aluno cancelarMatricula(Turma turma) {
		return turma.removerAluno(this);
	};
	
	public void visualizarMatricula() {
		System.out.print(this);
	}

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
	
	public int getLimiteObri() {
		return limiteObri;
	}

	public void setLimiteObri(int limiteObri) {
		this.limiteObri = limiteObri;
	}
	
	public int getLimiteOpc() {
		return limiteOpc;
	}

	public void setLimiteOpc(int limiteOpc) {
		this.limiteOpc = limiteOpc;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setObserver(Observer observer) {
		this.observer = observer;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb
			        .append("\nInformações Aluno")
					.append("Nome: ")
					.append(getNome())
					.append("\nMatrícula: ")
					.append(getMatricula())
					.append("\nCurso: ")
					.append(getCurso())
					.append("\nDisciplinas: ")
					.append(this.disciplinas.stream().map(Disciplina::getNome).collect(Collectors.joining(", ")));
		return sb.toString();
	}
}