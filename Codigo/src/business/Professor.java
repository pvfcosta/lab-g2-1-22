package business;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
	private List<Turma> turmas;
	
	public Professor(String nome, String email, String senha, int cod_pessoa, String cpf) {
		super(nome, email, senha, cod_pessoa, cpf);
		turmas = new ArrayList<Turma>();
	}
	
	public void gerarRelatorio() {
		System.out.print(this);
	}
	
	public void addTurmas(Turma turmas) {
		this.getTurmas().add(turmas);
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	};
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb
			        .append("\nInformações Professor")
					.append("\nNome: ")
					.append(getNome())
					.append("\nEmail: ")
					.append(getEmail())
					.append("\nDisciplinas ministradas -> ").append("\n");
			this.turmas.forEach(p -> sb.append(p.getDisciplina().getNome()).append(" "));
			sb.append("\n");
		return sb.toString();
	}
}
