package business;

public abstract class Usuario {
	private String nome;
	private String email;
	private int cod_pessoa;
	private String senha;
	private String cpf;
		
	public Usuario(String nome, String email, String senha, int cod_pessoa, String cpf) {
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
		this.setCod_pessoa(cod_pessoa);
		this.setCpf(cpf);
	}
	
	public void fazerLogin(String email, String senha) {
		this.email.equals(email);
		this.senha.equals(senha);
	};
	
	public void recuperarSenha(String email, String novaSenha) {
		if(this.email.equals(email)) {
			this.setSenha(novaSenha);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCod_pessoa() {
		return cod_pessoa;
	}

	public void setCod_pessoa(int cod_pessoa) {
		this.cod_pessoa = cod_pessoa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	};
}
