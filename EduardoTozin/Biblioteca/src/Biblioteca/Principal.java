package Biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Leitor> listaLeitores = new ArrayList<Leitor>();
	static final int MAXIMO_LIVROS = 3;

	public static void main(String[] args) {
		popularTabela();

		System.out.println("Sistema da biblioteca iniciado!");
		mostrarMenu();
	}

	private static void popularTabela() {
		listaLeitores.add(new Leitor("Patrick"));
		listaLeitores.add(new Leitor("Gabriel"));
		listaLeitores.add(new Leitor("Theo"));
		listaLeitores.add(new Leitor("Ana"));
		listaLeitores.add(new Leitor("Julia"));
		listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));
		listaLivros.add(new Livro("O Pequeno Principe", "Antoine de Saint-Exupery", "Infantil"));
		listaLivros.add(new Livro("1984", "George Orwell", "Ficcao"));
		listaLivros.add(new Livro("Harry Potter", "J. K. Rowling", "Fantasia"));
		listaLivros.add(new Livro("O Hobbit", "J. R. R. Tolkien", "Fantasia"));
		listaLivros.add(new Livro("Capitaes da Areia", "Jorge Amado", "Romance"));
		listaLivros.add(new Livro("Codigo Limpo", "Robert C. Martin", "Tecnologia"));
		listaLivros.add(new Livro("O Alquimista", "Paulo Coelho", "Ficcao"));
	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("--------------------Selecione uma das opcoes--------------------");
			System.out.println("1 - Listar livros");
			System.out.println("2 - Cadastrar livro");
			System.out.println("3 - Excluir livro");
			System.out.println("4 - Emprestar livro");
			System.out.println("5 - Devolver livro");
			System.out.println("6 - Cadastrar leitor");
			System.out.println("7 - Listar leitores");
			System.out.println("0 - Sair");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}

	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0:
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		case 1:
			listarLivros();
			break;
		case 2:
			cadastrarLivro();
			break;
		case 3:
			excluirLivro();
			break;
		case 4:
			emprestarLivro();
			break;
		case 5:
			devolverLivro();
			break;
		case 6:
			cadastrarLeitor();
			break;
		case 7:
			listarLeitores();
			break;
		default:
			System.out.println("Insira um valor valido!");
		}
	}

	private static void listarLivros() {
		System.out.println("\n--------Lista de Livros--------");
		for (int i = 0; i < listaLivros.size(); i++) {
			Livro livro = listaLivros.get(i);
			System.out.printf("%d) %s - %s (%s) / %s\n", i + 1, livro.getTitulo(), livro.getAutor(),
					livro.getGenero(), livro.validarDisponibilidade());
		}
		System.out.println("");
	}

	private static void cadastrarLivro() {
		Livro livro = new Livro();

		System.out.println("Informe o titulo do livro: ");
		livro.setTitulo(scan.nextLine());

		System.out.println("Informe o autor do livro: ");
		livro.setAutor(scan.nextLine());

		System.out.println("Informe o genero do livro: ");
		livro.setGenero(scan.nextLine());

		listaLivros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}

	private static void excluirLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Nao existem livros para excluir!");
			return;
		}

		listarLivros();
		System.out.println("Informe o livro a ser excluido: ");
		int livro = scan.nextInt() - 1;
		scan.nextLine();

		if (livro < 0 || livro >= listaLivros.size()) {
			System.out.println("Valor invalido!");
			return;
		}
		if (listaLivros.get(livro).getDataEmprestimo() != null) {
			System.out.println("O livro esta emprestado, portanto nao pode ser excluido!");
			return;
		}

		listaLivros.remove(livro);
		System.out.println("Livro removido com sucesso!");
	}

	private static void emprestarLivro() {
		listarLeitores();
		System.out.println("Informe o leitor que vai pegar o livro: ");
		int leitor = scan.nextInt() - 1;
		scan.nextLine();

		if (leitor < 0 || leitor >= listaLeitores.size()) {
			System.out.println("Informe um leitor valido!");
			return;
		}

		Leitor leitorEscolhido = listaLeitores.get(leitor);
		if (leitorEscolhido.getLivrosEmprestados().size() == MAXIMO_LIVROS) {
			System.out.println("Leitor ja esta com o maximo de " + MAXIMO_LIVROS + " livros! Devolva um para pegar outro.");
			return;
		}

		listarLivros();
		System.out.println("Informe o livro que vai ser emprestado: ");
		int livro = scan.nextInt() - 1;
		scan.nextLine();

		if (livro < 0 || livro >= listaLivros.size()) {
			System.out.println("Informe um livro valido!");
			return;
		}

		Livro livroEscolhido = listaLivros.get(livro);
		if (livroEscolhido.getDataEmprestimo() != null) {
			System.out.println("Livro ja esta emprestado!");
			return;
		}

		leitorEscolhido.getLivrosEmprestados().add(livroEscolhido);
		livroEscolhido.setDataEmprestimo(new Date());
		System.out.println("Livro emprestado com sucesso!");
	}

	private static void devolverLivro() {
		listarLeitores();
		System.out.println("Informe o leitor que vai devolver o livro: ");
		int leitor = scan.nextInt() - 1;
		scan.nextLine();

		if (leitor < 0 || leitor >= listaLeitores.size()) {
			System.out.println("Informe um leitor valido!");
			return;
		}

		Leitor leitorEscolhido = listaLeitores.get(leitor);
		if (leitorEscolhido.getLivrosEmprestados().size() == 0) {
			System.out.println("Leitor nao possui livros emprestados!");
			return;
		}

		System.out.println("Informe o livro que o leitor vai devolver: ");
		int livro = scan.nextInt() - 1;
		scan.nextLine();

		if (livro < 0 || livro >= leitorEscolhido.getLivrosEmprestados().size()) {
			System.out.println("Informe um livro existente!");
			return;
		}

		leitorEscolhido.getLivrosEmprestados().get(livro).setDataEmprestimo(null);
		leitorEscolhido.getLivrosEmprestados().remove(livro);
		System.out.println("Livro devolvido com sucesso!");
	}

	private static void cadastrarLeitor() {
		Leitor leitor = new Leitor();

		System.out.println("Informe o nome do leitor: ");
		leitor.setNome(scan.nextLine());

		listaLeitores.add(leitor);
		System.out.println("Leitor cadastrado com sucesso!");
	}

	private static void listarLeitores() {
		System.out.println("\n--------Lista de Leitores--------");
		for (int i = 0; i < listaLeitores.size(); i++) {
			Leitor leitor = listaLeitores.get(i);
			System.out.printf("%d) %s\n", i + 1, leitor.getNome());
			for (int j = 0; j < leitor.getLivrosEmprestados().size(); j++) {
				Livro livro = leitor.getLivrosEmprestados().get(j);
				System.out.printf("   %d) %s - %s\n", j + 1, livro.getTitulo(), livro.getAutor());
			}
		}
		System.out.println("");
	}

}