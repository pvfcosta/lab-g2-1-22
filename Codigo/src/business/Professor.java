package business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Professor extends Usuario {
	private List<Turma> turmas;
	
	public Professor(String nome, String email, String senha, int cod_pessoa, String cpf) {
		super(nome, email, senha, cod_pessoa, cpf);
		turmas = new ArrayList<Turma>();
	}
	
	public void gerarRelatorio() {
		System.out.print(this);
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
					.append("Nome: ")
					.append(getNome())
					.append("\nEmail: ")
					.append(getEmail())
					.append("\nDisciplinas: ")
					.append(turmas.stream().map(Turma::getDisciplina).collect(Collectors.toList()));			
		return sb.toString();
	}
}
