package business;

import java.util.ArrayList;
import java.util.List;
import exception.SecretariaException;

public class Aluno extends Usuario {
	private int matricula;
	private List<Turma> turmas;
	private Curso curso;
	private String estado;
	private Observer observer;
	
	public Aluno(String nome, String email, String senha, int cod_pessoa, String cpf, int matricula, Curso curso) {
		super(nome, email, senha, cod_pessoa, cpf);
		this.observer = new ObserverConcrect(this);
		turmas = new ArrayList<Turma>();
		this.setCurso(curso);
		this.setMatricula(matricula);
	}
	
	public void matricular(Turma turma) throws SecretariaException {
		if (turma.getDisciplina().isEhObrigatoria()) {
			if (turmas.stream().filter(t -> t.getDisciplina().isEhObrigatoria()).count() <= 4) {
				turmas.add(turma);
			} else {
				throw new SecretariaException("Você só pode se matricular em 4 disciplinas obrigatórias");
			}
		} else {
			if (turmas.stream().filter(t -> !t.getDisciplina().isEhObrigatoria()).count() <= 2) {
				turmas.add(turma);
			} else {
				throw new SecretariaException("Você só pode se matricular em 2 disciplinas optativas");
			}
		}
	}
	
	public void cancelarMatricula(Turma turma) {
		 turmas.remove(turma);
	};
	
	public void visualizarMatricula() {
		System.out.print(this);
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
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
		
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
		notificarObserver();
	}
	
	public void setObserver(Observer observer) {
		this.observer = observer;
	}
	
	private void notificarObserver() {
		this.observer.update();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb
			        .append("\nInformações Aluno")
					.append("\nNome: ")
					.append(getNome())
					.append("\nMatrícula: ")
					.append(getMatricula())
					.append("\nCurso: ")
					.append(getCurso().getNome())
					.append("\nDisciplinas -> ");
			this.turmas.forEach(p -> sb.append(p.getDisciplina()).append(" "));
			sb.append("\n");
		return sb.toString();
	}
}