package business;

public class Disciplina {
	private int cod_disciplina;
	private String nome;
	private int credito;
	private boolean ehObrigatoria;
	private int periodo;

	public Disciplina(int cod, String nome, int credito, boolean ehObrigatoria, int periodo){
		setCod_disciplina(cod);
		setNome(nome);
		setCredito(credito);
		setEhObrigatoria(ehObrigatoria);
		setPeriodo(periodo);
	}

	public boolean isEhObrigatoria() {
		return ehObrigatoria;
	}

	public void setEhObrigatoria(boolean ehObrigatoria) {
		this.ehObrigatoria = ehObrigatoria;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

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
		.append("Cr�dito: ").append(this.credito).append("\n");
		
		return sb.toString();
		
	}
}
