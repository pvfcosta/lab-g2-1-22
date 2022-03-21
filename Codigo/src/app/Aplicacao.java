package app;

import java.io.IOException;
import java.util.Scanner;
import business.Aluno;
import business.Curso;
import business.Disciplina;
import business.Professor;
import business.SecretariaSingleton;
import business.Turma;
import exception.SecretariaException;

public class Aplicacao {

	public static void limparTela() {
		System.out.flush();
	}

	public static int menu(Scanner teclado) {
		int opcao = -1;
		limparTela();
		System.out.println("Sistema de Matrículas");
		System.out.println("==========================");
		System.out.println("1 - Secretaria");
		System.out.println("2 - Aluno");
		System.out.println("3 - Professor");
		System.out.println("0 - Sair");

		opcao = escolheOpcao(0, 3, teclado, opcao);
		return opcao;
	}

	public static int menuSecretaria(Scanner teclado) {
		int opcao = -1;
		limparTela();
		System.out.println("Secretaria");
		System.out.println("==========================");
		System.out.println("1 - Matricular aluno");
		System.out.println("2 - Contratar professor");
		System.out.println("3 - Demitir professor");
		System.out.println("4 - Adicionar curso");
		System.out.println("5 - Remover curso");
		System.out.println("6 - Adicionar disciplina");
		System.out.println("7 - Remover disciplina");
		System.out.println("8 - Gerar currículo");
		System.out.println("0 - Sair");

		opcao = escolheOpcao(0, 8, teclado, opcao);
		return opcao;
	}

	public static int menuALuno(Scanner teclado) {
		int opcao = -1;
		limparTela();
		System.out.println("Aluno");
		System.out.println("==========================");
		System.out.println("1 - Matricular");
		System.out.println("2 - Cancelar matrícula");
		System.out.println("3 - Visualizar matrícula");
		System.out.println("0 - Sair");

		opcao = escolheOpcao(0, 3, teclado, opcao);
		return opcao;
	}

	public static int menuProfessor(Scanner teclado) {
		int opcao = -1;
		limparTela();
		System.out.println("Professor");
		System.out.println("==========================");
		System.out.println("1 - Gerar relatório");
		System.out.println("0 - Sair");

		opcao = escolheOpcao(0, 1, teclado, opcao);
		return opcao;
	}
	
	public static int escolheOpcao(int min, int max, Scanner teclado, int opcao) {

		do {
			try {
				opcao = Integer.parseInt(teclado.nextLine());
				if (opcao < min || opcao > max) {
					System.out.println("Esta opção não está disponível - Digite novamente uma das opções acima");
				}
			} catch (NumberFormatException exception) {
				System.out.println("O valor inserido é inválido - Digite novamente");
				opcao = -1;
			}
		} while (opcao < min || opcao > max);

		return opcao;
	}

	static void pausa(Scanner teclado) {
		System.out.println("Enter para continuar.");
		teclado.nextLine();
	}
	
	public static Aluno matricular(Scanner teclado, SecretariaSingleton s) throws SecretariaException {
		Aluno a;
		Curso c = null;

		System.out.println("Insira o nome do aluno:");
		String nome = teclado.nextLine();

		System.out.println("Insira o e-mail do aluno:");
		String email = teclado.nextLine();

		System.out.println("Insira a senha do aluno:");
		String senha = teclado.nextLine();

		System.out.println("Insira o código do aluno:");
		int cod = Integer.parseInt(teclado.nextLine());

		System.out.println("Insira o cpf do aluno:");
		String cpf = teclado.nextLine();

		System.out.println("Insira a matrícula do aluno:");
		int matricula = Integer.parseInt(teclado.nextLine());

		System.out.println("Insira o curso do aluno:");
		String curso = teclado.nextLine();

		if (SecretariaSingleton.getInstancia().getCursos().contains(curso)) {
			c.setNome(curso);
		} else {
			System.out.print("Curso não encontrado. Por favor, cadastre antes de matricular o aluno.");
		}

		a = new Aluno(nome, email, senha, cod, cpf, matricula, c);

		SecretariaSingleton.getInstancia().matricularAluno(a, c);
		return a;
	}
	
	public static Professor cadastrarProfessor(Scanner teclado) throws SecretariaException {			
		Professor p; 
		
		System.out.println("Insira o nome do professor:");
		String nomeProf = teclado.nextLine();
		
		System.out.println("Insira o e-mail do aluno:");
		String emailProf = teclado.nextLine();
		
		System.out.println("Insira a senha do aluno:");
		String senhaProf = teclado.nextLine();
		
		System.out.println("Insira o código do aluno:");
		int codProf = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Insira o cpf do aluno:");
		String cpfProf = teclado.nextLine();
		
		p = new Professor(nomeProf, emailProf, senhaProf, codProf, cpfProf);		

		return p; 
	}
	
	
	public static void removerProfessor(Scanner teclado, SecretariaSingleton s) throws SecretariaException {		
		System.out.println("\nQual professor deseja remover? ");
		
		int i = 1;
		for (Professor p : SecretariaSingleton.getInstancia().getProfessores()) {
			System.out.println(i + " -> " + p.getNome());
			i++;
		}
		
		int op = teclado.nextInt();
		i = 1;
		
		for (Professor p : SecretariaSingleton.getInstancia().getProfessores()) {
			if (i == op) {
				SecretariaSingleton.getInstancia().demitirProfessor(p);
			}
			i++;
		}
		teclado.nextLine();
	}
	
	public static Curso adicionarCurso(Scanner teclado) {		
		Curso c = new Curso();
		
		System.out.print("Nome: ");
		String nome = teclado.nextLine();
		System.out.println("Id:");
		int id = Integer.parseInt(teclado.nextLine());
		System.out.println("Carga horário");
		int carga = Integer.parseInt(teclado.nextLine());
		c.setNome(nome);
		c.setCargaHoraria(carga);
		c.setId(id);
		
		return c; 
	}
	
	public static void removerCurso(Scanner teclado, SecretariaSingleton s) throws SecretariaException {		
		System.out.println("\nQual curso deseja remover? ");
		
		int i = 1;
		for (Curso c : SecretariaSingleton.getInstancia().getCursos()){
			System.out.println(i + " -> " + c.getNome());
			i++;
		}
		
		int opcao = teclado.nextInt();
		i = 1;
		
		for (Curso c : SecretariaSingleton.getInstancia().getCursos()){
			if (i == opcao) {
				SecretariaSingleton.getInstancia().removerCurso(c);
			}
			i++;
		}
		teclado.nextLine();
	}
	
	public static void matricularAluno(Scanner teclado, Curso c) throws SecretariaException {
		Aluno aluno = null;
		Turma turma = null; 
		
		System.out.print("Digite sua matrícula");
		int mat = Integer.parseInt(teclado.nextLine());
		
		for(Aluno a : c.getAlunos()) {
			if(mat == a.getMatricula()) {
				aluno = a;
			}
		}
		
		c.getTurmas().stream().map(f -> f.getCod_turma()).forEach(System.out::print);
		
		System.out.print("Qual turma deseja se matricular?");
		int cod = Integer.parseInt(teclado.nextLine());

		for(Turma t : c.getTurmas()) {
			if(cod == t.getCod_turma()) {
				turma = t;
			}
		}
		
		aluno.matricular(turma);	
	}
	
	public static void removerMatricula(Scanner teclado, Curso c) throws SecretariaException {
		Aluno aluno = null;

		System.out.print("Digite sua matrícula");
		int mat = Integer.parseInt(teclado.nextLine());
		
		for(Aluno a : c.getAlunos()) {
			if(mat == a.getMatricula()) {
				aluno = a;
			}
		}
		
		System.out.print("Qual o código da turma que deseja cancelar?");
		int codT = Integer.parseInt(teclado.nextLine());
		
		for (Turma t : c.getTurmas()){
			if(codT == t.getCod_turma()) {
				aluno.cancelarMatricula(t);
			}
		}		
	}
	  
	public static Disciplina adicionarDisciplina(Scanner teclado){
		Disciplina d = null;
		
		System.out.print("Nome: ");
		String nome = teclado.nextLine();
		System.out.println("Código:");
		int cod = Integer.parseInt(teclado.nextLine());
		System.out.println("Créditos");
		int credito = Integer.parseInt(teclado.nextLine());
		System.out.println("Período");
		int periodo = Integer.parseInt(teclado.nextLine());
		System.out.println("É obrigatória? true/false");
		boolean obrigatoria = teclado.nextBoolean();

		d = new Disciplina(cod, nome, credito, obrigatoria, periodo);
		
		return d; 
	}
	
	public static void removerDisciplina(Scanner teclado, Curso c) throws SecretariaException {		

		System.out.println("\nQual disciplina deseja remover? ");
		
		int i = 1;
		for (Disciplina d : c.getDisciplinas()){
			System.out.println(i + "-" + c.getNome());
			i++;
		}
		
		int disc = teclado.nextInt();
		i = 1;
		
		for (Disciplina d : c.getDisciplinas()){
			if (i == disc) {
				c.removeDisciplina(d);
			}
			i++;
		}
		teclado.nextLine();
	} 
	

	public static void main(String[] args) throws SecretariaException, IOException {
		Scanner teclado = new Scanner(System.in);
		SecretariaSingleton secretaria = SecretariaSingleton.getInstancia();
		Professor p = null;
		Curso c = null; 
		Disciplina d; 

		int opcao = -1;
		int op2 = -1;
		int op3 = -1;
		int op4 = -1;

		do {
			opcao = menu(teclado);
			limparTela();
			switch (opcao) {
			case 1:
				op2 = menuSecretaria(teclado);
				switch (op2) {
				case 1:
					matricular(teclado, secretaria);			
					pausa(teclado);
					break;
				case 2: 
					p = cadastrarProfessor(teclado);
					secretaria.contratarProfessor(p);
					pausa(teclado);
					break;
				case 3: 
					removerProfessor(teclado, secretaria);
					pausa(teclado);
					break;
				case 4: 
					c = adicionarCurso(teclado);
					secretaria.adicionarCurso(c);
					pausa(teclado);
					break;
				case 5: 
					removerCurso(teclado, secretaria);
					pausa(teclado);
					break;
				case 6: 
					d = adicionarDisciplina(teclado);
			    	System.out.println("Insira o nome do curso: ");
			        String nomeCurso = teclado.nextLine();
			        secretaria.adicionarDisciplinaCurso(d, nomeCurso);
					pausa(teclado);
					break;
				case 7: 
					System.out.print("Qual o curso?");
					String nomeCurso2 = teclado.nextLine();
					
					for(Curso curso : secretaria.getCursos()) {
						if(nomeCurso2.equals(curso.getNome())){
							c = curso;
						}
					}			
					removerDisciplina(teclado, c);
					pausa(teclado);
					break;
				case 8: 
					System.out.print("Qual curso deseja gerar o currículo?");
					String curso = teclado.nextLine();
					if (SecretariaSingleton.getInstancia().getCursos().contains(curso)) {
						c.setNome(curso);
					} else {
						System.out.print("Curso não encontrado. Por favor, cadastre antes de gerar o currículo.");
					}
					secretaria.gerarCurriculo(c);
					pausa(teclado);
					break;					
				}
				pausa(teclado);
				break;					
			case 2:
				op3 = menuALuno(teclado);
				switch (op3) {
				case 1:
					System.out.print("Qual o curso?");
					String nomeCurso = teclado.nextLine();
					
					for(Curso curso : secretaria.getCursos()) {
						if(nomeCurso.equals(curso.getNome())){
							c = curso;
						}
					}
																
					matricularAluno(teclado, c);
					pausa(teclado);
					break;	
				case 2: 
					System.out.print("Qual o curso?");
					String nomeCurso2 = teclado.nextLine();
					
					for(Curso curso : secretaria.getCursos()) {
						if(nomeCurso2.equals(curso.getNome())){
							c = curso;
						}
					}														
					removerMatricula(teclado, c);
					pausa(teclado);
					break;
				case 3: 
					System.out.print("Digite sua matrícula");
					int mat = Integer.parseInt(teclado.nextLine());
					
					c.getAlunos().stream().filter(k -> k.getCod_pessoa() == mat).forEach(y -> y.visualizarMatricula());				
				}
				pausa(teclado);
				break;

			case 3:
				op4 = menuProfessor(teclado);
				switch (op4) {
				case 1:
					System.out.print("Qual professor deseja gerar o relatório?");
					String nome = teclado.nextLine();
					
					for(Professor prof : secretaria.getProfessores())
						if(nome.equals(prof.getNome())) {
							prof.gerarRelatorio();
						}
				}
				pausa(teclado);
				break;
			}
		} while (opcao != 0);

		teclado.close();
}
}