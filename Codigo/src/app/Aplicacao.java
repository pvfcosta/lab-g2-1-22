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
		System.out.println("1 - Adicionar curso");
		System.out.println("2 - Remover curso");
		System.out.println("3 - Adicionar disciplina no curso");
		System.out.println("4 - Remover disciplina no curso");
		System.out.println("5 - Matricular aluno");
		System.out.println("6 - Contratar professor");
		System.out.println("7 - Demitir professor");
		System.out.println("8 - Criar turma");
		System.out.println("9 - Gerar currículo");
		System.out.println("0 - Sair");

		opcao = escolheOpcao(0, 9, teclado, opcao);
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

	public static Aluno matricular(Scanner teclado) throws SecretariaException {
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
		
		for (Curso c1 : SecretariaSingleton.getInstancia().getCursos()) {
			if (curso.equals(c1.getNome())) {
				c = c1;
			}
		}
					
		Aluno a = new Aluno(nome, email, senha, cod, cpf, matricula, c);
		
		SecretariaSingleton.getInstancia().matricularAluno(a, c);
		
		return a;
	}

	public static Professor cadastrarProfessor(Scanner teclado) {

		System.out.println("Insira o nome do professor:");
		String nomeProf = teclado.nextLine();

		System.out.println("Insira o e-mail do professor:");
		String emailProf = teclado.nextLine();

		System.out.println("Insira a senha do professor:");
		String senhaProf = teclado.nextLine();

		System.out.println("Insira o código do professor:");
		int codProf = Integer.parseInt(teclado.nextLine());

		System.out.println("Insira o cpf do professor:");
		String cpfProf = teclado.nextLine();

		return new Professor(nomeProf, emailProf, senhaProf, codProf, cpfProf);
	}

	public static void removerProfessor(Scanner teclado) throws SecretariaException {
		Professor prof = null;

		System.out.println("\nEscolha o número do professor que deseja demitir? ");

		int i = 1;
		for (Professor p : SecretariaSingleton.getInstancia().getProfessores()) {
			System.out.println(i + "- " + p.getNome());
			i++;
		}

		int op = teclado.nextInt();
		i = 1;

		for (Professor p : SecretariaSingleton.getInstancia().getProfessores()) {
			if (i == op) {
				prof = p;
			}
			i++;
		}

		SecretariaSingleton.getInstancia().demitirProfessor(prof);

		teclado.nextLine();
	}

	public static Curso adicionarCurso(Scanner teclado) {

		System.out.print("Nome do curso: ");
		String nome = teclado.nextLine();
		System.out.println("Id do curso:");
		int id = Integer.parseInt(teclado.nextLine());
		
		return new Curso(nome, id);
	}

	public static void removerCurso(Scanner teclado) throws SecretariaException {
		Curso curso = null;

		System.out.println("\nEscolha o número do curso que deseja remover? ");

		int i = 1;
		for (Curso c : SecretariaSingleton.getInstancia().getCursos()) {
			System.out.println(i + " - " + c.getNome());
			i++;
		}

		int opcao = teclado.nextInt();
		i = 1;

		for (Curso c : SecretariaSingleton.getInstancia().getCursos()) {
			if (i == opcao) {
				curso = c;
			}
			i++;
		}

		SecretariaSingleton.getInstancia().removerCurso(curso);

		teclado.nextLine();
	}

	public static void matricularAluno(Scanner teclado, Curso c) throws SecretariaException {
		Aluno aluno = null;
		Turma turma = null;

		System.out.print("Digite sua matrícula: ");
		int mat = Integer.parseInt(teclado.nextLine());

		for (Aluno a : c.getAlunos()) {
			if (mat == a.getMatricula()) {
				aluno = a;
			}
		}

		System.out.print("Qual turma deseja se matricular? ");

		c.getTurmas().stream().forEach(f -> System.out.println(" - " + f.getCod_turma()));

		int cod = Integer.parseInt(teclado.nextLine());

		for (Turma t : c.getTurmas()) {
			if (cod == t.getCod_turma()) {
				turma = t;
			}
		}

		aluno.matricular(turma);
		turma.adicionarAluno(aluno);
	}

	public static void removerMatricula(Scanner teclado, Curso c) throws SecretariaException {
		Aluno aluno = null;
		Turma turma = null;

		System.out.print("Digite sua matrícula: ");
		int mat = Integer.parseInt(teclado.nextLine());

		for (Aluno a : c.getAlunos()) {
			if (mat == a.getMatricula()) {
				aluno = a;
			}
		}

		System.out.print("Qual o código da turma que deseja cancelar? ");

		c.getTurmas().stream().forEach(f -> System.out.println("\n - " + f.getCod_turma()));

		int codT = Integer.parseInt(teclado.nextLine());

		for (Turma t : c.getTurmas()) {
			if (codT == t.getCod_turma()) {
				turma = t;
			}
		}

		turma.removerAluno(aluno);
		aluno.cancelarMatricula(turma);
	}

	public static Disciplina adicionarDisciplina(Scanner teclado) {

		System.out.print("Nome da disciplina: ");
		String nome = teclado.nextLine();
		System.out.println("Código da disciplina:");
		int cod = Integer.parseInt(teclado.nextLine());
		System.out.println("Créditos da disciplina:");
		int credito = Integer.parseInt(teclado.nextLine());
		System.out.println("Período da disciplina:");
		int periodo = Integer.parseInt(teclado.nextLine());
		System.out.println("É obrigatória? true/false");
		boolean obrigatoria = teclado.nextBoolean();

		teclado.nextLine();

		return new Disciplina(cod, nome, credito, obrigatoria, periodo);
	}

	public static void removerDisciplina(Scanner teclado, Curso c) throws SecretariaException {
		Disciplina disciplina = null;

		System.out.println("\nQual disciplina deseja remover? ");

		int i = 1;
		for (Disciplina d : c.getDisciplinas()) {
			System.out.println(i + "-" + d.getNome());
			i++;
		}

		int disc = teclado.nextInt();
		i = 1;

		for (Disciplina d : c.getDisciplinas()) {
			if (i == disc) {
				disciplina = d;
			}
			i++;
		}

		c.removeDisciplina(disciplina);

		teclado.nextLine();
	}

	public static void criarTurma(Scanner teclado) {
		Curso curso = null;
		Disciplina disciplina = null;
		Professor professor = null;

		System.out.print("Semestre da turma: ");
		String semestre = teclado.nextLine();
		System.out.println("Código da turma: ");
		int cod = Integer.parseInt(teclado.nextLine());

		System.out.println("A turma pertence a qual curso? ");

		int i = 1;

		for (Curso c : SecretariaSingleton.getInstancia().getCursos()) {
			System.out.println(i + "-" + c.getNome());
			i++;
		}

		int op = teclado.nextInt();
		i = 1;

		for (Curso c : SecretariaSingleton.getInstancia().getCursos()) {
			if (i == op) {
				curso = c;
			}
			i++;
		}

		System.out.println("Defina a disciplina da turma: ");

		i = 1;
		for (Disciplina d : curso.getDisciplinas()) {
			System.out.println(i + "-" + d.getNome());
			i++;
		}

		int disc = teclado.nextInt();
		i = 1;

		for (Disciplina d : curso.getDisciplinas()) {
			if (i == disc) {
				disciplina = d;
			}
			i++;
		}

		System.out.println("Selecione o professor: ");

		i = 1;
		for (Professor p : SecretariaSingleton.getInstancia().getProfessores()) {
			System.out.println(i + "-" + p.getNome());
			i++;
		}

		int prof = teclado.nextInt();
		i = 1;

		for (Professor p : SecretariaSingleton.getInstancia().getProfessores()) {
			if (i == prof) {
				professor = p;
			}
			i++;
		}

		Turma t = new Turma(cod, semestre, disciplina);

		t.adicionarProfessor(professor);
		professor.addTurmas(t);
		curso.addTurma(t);
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
					c = adicionarCurso(teclado);
					secretaria.adicionarCurso(c);
					break;
				case 2:
					removerCurso(teclado);
					break;
				case 3:
					d = adicionarDisciplina(teclado);

					System.out.println("Insira o nome do curso: ");
					String nomeCurso = teclado.nextLine();
					
					for (Curso curso : secretaria.getCursos()) {
						if (nomeCurso.equals(curso.getNome())) {
							c = curso;
						}
					}

					secretaria.adicionarDisciplinaCurso(d, c);
					break;
				case 4:
					System.out.print("Qual o curso? ");
					String nomeCurso2 = teclado.nextLine();

					for (Curso curso : secretaria.getCursos()) {
						if (nomeCurso2.equals(curso.getNome())) {
							c = curso;
						}
					}
					removerDisciplina(teclado, c);
					break;
				case 5:
					matricular(teclado);
					break;
				case 6:
					p = cadastrarProfessor(teclado);
					secretaria.contratarProfessor(p);
					break;
				case 7:
					removerProfessor(teclado);
					break;
				case 8:
					criarTurma(teclado);
					break;
				case 9:
					System.out.print("Qual curso deseja gerar o currículo? ");
					String nomeCurso3 = teclado.nextLine();

					for (Curso curso : secretaria.getCursos()) {
						if (nomeCurso3.equals(curso.getNome())) {
							c = curso;
						} else {
							System.out.print("Curso não encontrado. Por favor, cadastre antes de gerar o currículo.");

						}
					}

					secretaria.gerarCurriculo(c);
					break;
				}
				pausa(teclado);
				break;
			case 2:
				op3 = menuALuno(teclado);
				switch (op3) {
				case 1:
					System.out.print("Qual o curso? ");
					String nomeCurso = teclado.nextLine();

					for (Curso curso : secretaria.getCursos()) {
						if (nomeCurso.equals(curso.getNome())) {
							c = curso;
						}
					}

					matricularAluno(teclado, c);
					break;
				case 2:
					System.out.print("Qual o curso? ");
					String nomeCurso2 = teclado.nextLine();

					for (Curso curso : secretaria.getCursos()) {
						if (nomeCurso2.equals(curso.getNome())) {
							c = curso;
						}
					}
					removerMatricula(teclado, c);
					break;
				case 3:
					System.out.print("Digite a matrícula: ");
					int mat = Integer.parseInt(teclado.nextLine());

					for (Aluno aluno : c.getAlunos())
						if (mat == aluno.getMatricula()) {
							aluno.visualizarMatricula();
						}
				}
				pausa(teclado);
				break;

			case 3:
				op4 = menuProfessor(teclado);
				switch (op4) {
				case 1:
					System.out.print("Digite o código do professor que deseja gerar o relatório? ");
					int cod = teclado.nextInt();

					for (Professor prof : secretaria.getProfessores())
						if (cod == prof.getCod_pessoa()) {
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
