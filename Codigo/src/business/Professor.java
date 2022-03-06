package business;

import java.util.List;

public class Professor extends Usuario {
	private List<Turma> turmas;
	
	public void gerarRelatorio() {}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	};
}
