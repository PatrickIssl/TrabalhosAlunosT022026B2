package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Leitor> listaLeitores = new ArrayList<Leitor>();

	public static void main(String[] args) {
		System.out.println("Sistema da biblioteca iniciado!");
		mostrarMenu();
	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("\n--------------------Menu da Biblioteca--------------------");
			System.out.println("--- Registros ---");
			System.out.println("1 - Registrar leitor");
			System.out.println("2 - Cadastrar livro");
			System.out.println("--- Consultas ---");
			System.out.println("3 - Listar leitores");
			System.out.println("4 - Listar livros");
			System.out.println("--- Movimentações ---");
			System.out.println("5 - Emprestar livro");
			System.out.println("6 - Devolver livro");
			System.out.println("--- Exclusão ---");
			System.out.println("7 - Excluir livro");
			System.out.println("-----------------");
			System.out.println("0 - Sair");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}

	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0: {
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1: {
			cadastrarLeitor();
			break;
		}
		case 2: {
			cadastrarLivro();
			break;
		}
		case 3: {
			listarLeitores();
			break;
		}
		case 4: {
			listarLivros();
			break;
		}
		case 5: {
			emprestarLivro();
			break;
		}
		case 6: {
			devolverLivro();
			break;
		}
		case 7: {
			excluirLivro();
			break;
		}
		default:
			System.out.println("Insira um valor valido!");
		}
	}

	private static void devolverLivro() {
		if (listaLeitores.size() == 0) {
			System.out.println("Não existem leitores cadastrados!");
			return;
		}

		listarLeitores();
		System.out.println("Informe o leitor que vai devolver o livro");
		int leitor = scan.nextInt() - 1;
		scan.nextLine();

		if (leitor >= listaLeitores.size() || leitor < 0) {
			System.out.println("Informe um leitor valido!");
			return;
		}
		if (listaLeitores.get(leitor).getLivrosEmprestados().size() == 0) {
			System.out.println("Leitor não possui livros emprestados!");
			return;
		}

		System.out.println("Informe o livro que o leitor vai devolver (número da lista do leitor)");
		int livro = scan.nextInt() - 1;
		scan.nextLine();

		if (livro >= listaLeitores.get(leitor).getLivrosEmprestados().size() || livro < 0) {
			System.out.println("Informe um livro existente!");
			return;
		}

		listaLeitores.get(leitor).getLivrosEmprestados().get(livro).setDataEmprestimo(null);
		listaLeitores.get(leitor).getLivrosEmprestados().remove(livro);
		System.out.println("Livro devolvido com sucesso!");

	}

	private static void emprestarLivro() {
		if (listaLeitores.size() == 0) {
			System.out.println("Não existem leitores cadastrados!");
			return;
		}
		if (listaLivros.size() == 0) {
			System.out.println("Não existem livros cadastrados!");
			return;
		}

		listarLeitores();
		System.out.println("Informe o leitor que vai pegar o livro emprestado");
		int leitor = scan.nextInt() - 1;
		scan.nextLine();
		if (leitor >= listaLeitores.size() || leitor < 0) {
			System.out.println("Informe um leitor valido!");
			return;
		}

		if (listaLeitores.get(leitor).getLivrosEmprestados().size() == 2) {
			System.out.println("Leitor está com o maximo de livros possiveis! Devolva um para poder pegar outro!");
			return;
		}

		listarLivros();
		System.out.println("Informe o livro que será emprestado");
		int livro = scan.nextInt() - 1;
		scan.nextLine();
		if (livro >= listaLivros.size() || livro < 0) {
			System.out.println("Informe um livro valido!");
			return;
		}
		if (listaLivros.get(livro).getDataEmprestimo() != null) {
			System.out.println("Livro ja está emprestado!");
			return;
		}

		listaLeitores.get(leitor).getLivrosEmprestados().add(listaLivros.get(livro));
		listaLivros.get(livro).setDataEmprestimo(new Date());
		System.out.println("Livro emprestado com sucesso!");
	}

	private static void listarLeitores() {
		System.out.println("\n--------Lista Leitores--------");
		for (int i = 0; i < listaLeitores.size(); i++) {
			System.out.printf("%d) %s \n", i + 1, listaLeitores.get(i).getNome());
			if (listaLeitores.get(i).getLivrosEmprestados().size() != 0) {
				for (int j = 0; j < listaLeitores.get(i).getLivrosEmprestados().size(); j++) {
					System.out.printf("  %d) %s - %s\n", j + 1,
							listaLeitores.get(i).getLivrosEmprestados().get(j).getTitulo(),
							listaLeitores.get(i).getLivrosEmprestados().get(j).getAutor());
				}
			}
		}
		System.out.println("");
	}

	private static void cadastrarLeitor() {
		Leitor leitor = new Leitor();

		System.out.println("Informe o nome do leitor: ");
		leitor.setNome(scan.nextLine());

		listaLeitores.add(leitor);
		System.out.println("Leitor cadastrado com sucesso!");

	}

	private static void excluirLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Não existem livros para excluir!");
			return;
		}

		listarLivros();
		System.out.println("Informe o livro a ser excluido: ");
		int escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();

		if (escolhaUsuario >= listaLivros.size() || escolhaUsuario < 0) {
			System.out.println("Valor inválido!");
			return;
		}
		if (listaLivros.get(escolhaUsuario).getDataEmprestimo() != null) {
			System.out.println("O livro está emprestado, portanto não pode ser excluido!");
			return;
		}
		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso!");

	}

	private static void listarLivros() {
		System.out.println("\n--------Lista Livros--------");
		for (int i = 0; i < listaLivros.size(); i++) {
			System.out.printf("%d) %s - %s (%s) / %s\n", i + 1, listaLivros.get(i).getTitulo(),
					listaLivros.get(i).getAutor(), listaLivros.get(i).getCategoria(),
					listaLivros.get(i).validarDisponibilidade());
		}
		System.out.println("");

	}

	private static void cadastrarLivro() {
		Livro livro = new Livro();

		System.out.println("Informe o titulo do livro: ");
		livro.setTitulo(scan.nextLine());

		System.out.println("Informe o autor do livro: ");
		livro.setAutor(scan.nextLine());

		System.out.println("Informe a categoria do livro: ");
		livro.setCategoria(scan.nextLine());

		listaLivros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}

}