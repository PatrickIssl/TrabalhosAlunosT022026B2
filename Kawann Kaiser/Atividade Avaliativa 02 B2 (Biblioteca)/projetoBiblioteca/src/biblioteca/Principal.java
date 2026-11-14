package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import biblioteca.objetos.Livro;
import biblioteca.objetos.Pessoa;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();

	public static void main(String[] args) {
		popularTabela();
		System.out.println("Sistema de biblioteca iniciado!");
		mostrarMenu();
		scan.close();
	}

	private static void popularTabela() {
		listaUsuarios.add(new Pessoa("Kawann"));
		listaUsuarios.add(new Pessoa("Gabriel"));
		listaUsuarios.add(new Pessoa("Theo"));
		listaUsuarios.add(new Pessoa("João"));
		listaUsuarios.add(new Pessoa("Pedro"));
		listaUsuarios.add(new Pessoa("Alex"));
		listaUsuarios.add(new Pessoa("Paulo"));

		listaLivros.add(new Livro("O pequeno príncipe", "Antoine de Saint-Exupéry", "Fantasia"));
		listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));
		listaLivros.add(new Livro("O cortiço", "Aluísio Azevedo", "Romance"));
		listaLivros.add(new Livro("A hora da estrela", "Clarice Lispector", "Romance"));
		listaLivros.add(new Livro("O hobbit", "J. R. R. Tolkien", "Fantasia"));
		listaLivros.add(new Livro("Harry Potter e a pedra filosofal", "J. K. Rowling", "Fantasia"));
		listaLivros.add(new Livro("1984", "George Orwell", "Ficção"));
		listaLivros.add(new Livro("A revolução dos bichos", "George Orwell", "Fábula"));
		listaLivros.add(new Livro("Capitães da areia", "Jorge Amado", "Romance"));
		listaLivros.add(new Livro("O alienista", "Machado de Assis", "Novela"));
	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Listar livros");
			System.out.println("2 - Cadastrar livro");
			System.out.println("3 - Excluir livro");
			System.out.println("4 - Emprestar livro");
			System.out.println("5 - Devolver livro");
			System.out.println("6 - Registrar usuário");
			System.out.println("7 - Listar usuários");
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
			listarLivros();
			break;
		}
		case 2: {
			cadastrarLivro();
			break;
		}
		case 3: {
			excluirLivro();
			break;
		}
		case 4: {
			emprestarLivro();
			break;
		}
		case 5: {
			devolverLivro();
			break;
		}
		case 6: {
			cadastrarUsuario();
			break;
		}
		case 7: {
			listarUsuarios();
			break;
		}
		default:
			System.out.println("Insira uma opção válida!");
		}
	}

	private static void listarLivros() {
		System.out.println("\n--------Lista de livros--------");
		if (listaLivros.size() == 0) {
			System.out.println("Não existem livros cadastrados!");
		}
		for (int i = 0; i < listaLivros.size(); i++) {
			System.out.printf("%d) %s - %s - %s / %s\n", i + 1,
					listaLivros.get(i).getNome(), listaLivros.get(i).getAutor(),
					listaLivros.get(i).getGenero(), listaLivros.get(i).validarDisponibilidade());
		}
		System.out.println("");
	}

	private static void cadastrarLivro() {
		Livro livro = new Livro();

		System.out.println("Informe o nome do livro: ");
		livro.setNome(scan.nextLine());
		System.out.println("Informe o autor do livro: ");
		livro.setAutor(scan.nextLine());
		System.out.println("Informe o gênero do livro: ");
		livro.setGenero(scan.nextLine());

		if (livro.getNome().isEmpty() || livro.getAutor().isEmpty() || livro.getGenero().isEmpty()) {
			System.out.println("Preencha o nome, o autor e o gênero do livro");
			return;
		}

		listaLivros.add(livro);
		System.out.println("Livro cadastrado com sucesso");
	}

	private static void excluirLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Não existem livros para excluir");
			return;
		}

		listarLivros();
		System.out.println("Informe o livro a ser excluído: ");
		int escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();

		if (escolhaUsuario < 0 || escolhaUsuario >= listaLivros.size()) {
			System.out.println("Informe um livro válido!");
			return;
		}
		if (listaLivros.get(escolhaUsuario).getDataEmprestimo() != null) {
			System.out.println("O livro está emprestado, portanto não pode ser excluído");
			return;
		}

		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso");
	}

	private static void emprestarLivro() {
		if (listaUsuarios.size() == 0) {
			System.out.println("Cadastre um usuário antes de emprestar um livro");
			return;
		}
		if (listaLivros.size() == 0) {
			System.out.println("Não existem livros para emprestar");
			return;
		}

		listarUsuarios();
		System.out.println("Informe o usuário que vai pegar o livro emprestado: ");
		int usuario = scan.nextInt() - 1;
		scan.nextLine();

		if (usuario < 0 || usuario >= listaUsuarios.size()) {
			System.out.println("Informe um usuário válido!");
			return;
		}
		if (listaUsuarios.get(usuario).getLivrosEmprestados().size() >= 2) {
			System.out.println("Usuário está com o máximo de 2 livros! Devolva um para pegar outro");
			return;
		}

		listarLivros();
		System.out.println("Informe o livro que deseja pegar emprestado: ");
		int livro = scan.nextInt() - 1;
		scan.nextLine();

		if (livro < 0 || livro >= listaLivros.size()) {
			System.out.println("Informe um livro válido");
			return;
		}
		if (listaLivros.get(livro).getDataEmprestimo() != null) {
			System.out.println("Livro já está emprestado");
			return;
		}

		listaUsuarios.get(usuario).getLivrosEmprestados().add(listaLivros.get(livro));
		listaLivros.get(livro).setDataEmprestimo(new Date());
		System.out.println("Livro emprestado com sucesso");
	}

	private static void devolverLivro() {
		if (listaUsuarios.size() == 0) {
			System.out.println("Não existem usuários cadastrados");
			return;
		}

		listarUsuarios();
		System.out.println("Informe o usuário que vai devolver o livro: ");
		int usuario = scan.nextInt() - 1;
		scan.nextLine();

		if (usuario < 0 || usuario >= listaUsuarios.size()) {
			System.out.println("Informe um usuário válido");
			return;
		}
		if (listaUsuarios.get(usuario).getLivrosEmprestados().size() == 0) {
			System.out.println("Usuário não possui livros emprestados");
			return;
		}

		System.out.println("\n--------Livros emprestados para " + listaUsuarios.get(usuario).getNome() + "--------");
		for (int i = 0; i < listaUsuarios.get(usuario).getLivrosEmprestados().size(); i++) {
			System.out.printf("%d) %s - %s\n", i + 1,
					listaUsuarios.get(usuario).getLivrosEmprestados().get(i).getNome(),
					listaUsuarios.get(usuario).getLivrosEmprestados().get(i).getAutor());
		}
		System.out.println("Informe o livro que o usuário vai devolver: ");
		int livro = scan.nextInt() - 1;
		scan.nextLine();

		if (livro < 0 || livro >= listaUsuarios.get(usuario).getLivrosEmprestados().size()) {
			System.out.println("Informe um livro válido!");
			return;
		}

		listaUsuarios.get(usuario).getLivrosEmprestados().get(livro).setDataEmprestimo(null);
		listaUsuarios.get(usuario).getLivrosEmprestados().remove(livro);
		System.out.println("Livro devolvido com sucesso");
	}

	private static void cadastrarUsuario() {
		Pessoa usuario = new Pessoa();

		System.out.println("Informe o nome do usuário: ");
		usuario.setNome(scan.nextLine());

		if (usuario.getNome().isEmpty()) {
			System.out.println("Informe um nome válido");
			return;
		}

		listaUsuarios.add(usuario);
		System.out.println("Usuário cadastrado com sucesso");
	}

	private static void listarUsuarios() {
		System.out.println("\n--------Lista de usuários--------");
		if (listaUsuarios.size() == 0) {
			System.out.println("Não existem usuários cadastrados");
		}
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.printf("%d) %s\n", i + 1, listaUsuarios.get(i).getNome());
			for (int j = 0; j < listaUsuarios.get(i).getLivrosEmprestados().size(); j++) {
				System.out.printf("  %d) %s - %s\n", j + 1,
						listaUsuarios.get(i).getLivrosEmprestados().get(j).getNome(),
						listaUsuarios.get(i).getLivrosEmprestados().get(j).getAutor());
			}
		}
		System.out.println("");
	}

}
