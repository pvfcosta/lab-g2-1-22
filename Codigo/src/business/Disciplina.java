package business;

public class Disciplina {
	private int cod_disciplina;
	private String nome;
	private int credito;
	public int getCod_disciplina() {
		return cod_disciplina;
	}
	public void setCod_disciplina(int cod_disciplina) {
		this.cod_disciplina = cod_disciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCredito() {
		return credito;
	}
	public void setCredito(int credito) {
		this.credito = credito;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(this.nome).append("\n")
		.append("Crédito: ").append(this.credito).append("\n");
		
		return sb.toString();
		
	}
}
