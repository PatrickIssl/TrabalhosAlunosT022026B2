package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Livro;
import fag.objetos.Pessoa;

public class Principal {

	private static final Scanner scan = new Scanner(System.in);
	private static final List<Livro> listaLivros = new ArrayList<Livro>();
	private static final List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();

	public static void main(String[] args) {
		popularTabela();

		System.out.println("Sistema da biblioteca iniciado!");
		mostrarMenu();
	}

	private static void popularTabela() {
		listaUsuarios.add(new Pessoa("Patrick"));
		listaUsuarios.add(new Pessoa("Gabriel"));
		listaUsuarios.add(new Pessoa("Theo"));
		listaUsuarios.add(new Pessoa("João"));
		listaUsuarios.add(new Pessoa("Pedro"));
		listaUsuarios.add(new Pessoa("Alex"));
		listaUsuarios.add(new Pessoa("Paulo"));

		listaLivros.add(new Livro("O Hobbit", "J. R. R. Tolkien", "Fantasia"));
		listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));
		listaLivros.add(new Livro("A Revolução dos Bichos", "George Orwell", "Ficção"));
		listaLivros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Fábula"));
		listaLivros.add(new Livro("It: A Coisa", "Stephen King", "Terror"));
		listaLivros.add(new Livro("As Crônicas de Nárnia", "C. S. Lewis", "Fantasia"));
	}

	public static void mostrarMenu() {
		int escolhaUsuario;
		do {
			System.out.println("-------------------- Biblioteca --------------------");
			System.out.println("1 - Listar livros");
			System.out.println("2 - Cadastrar livro");
			System.out.println("3 - Excluir livro");
			System.out.println("4 - Emprestar livro");
			System.out.println("5 - Registrar devolução");
			System.out.println("6 - Cadastrar usuário");
			System.out.println("7 - Listar usuários");
			System.out.println("0 - Sair");
			escolhaUsuario = lerInteiro("Escolha uma opção: ");
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
			cadastrarUsuario();
			break;
		case 7:
			listarUsuarios();
			break;
		default:
			System.out.println("Insira uma opção válida!");
		}
	}

	private static int lerInteiro(String mensagem) {
		while (true) {
			System.out.print(mensagem);
			String entrada = scan.nextLine();
			try {
				return Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				System.out.println("Digite um número válido.");
			}
		}
	}

	private static void devolverLivro() {
		if (listaUsuarios.isEmpty()) {
			System.out.println("Não existem usuários cadastrados.");
			return;
		}

		listarUsuarios();
		int usuario = lerInteiro("Informe o número do usuário que vai devolver o livro: ") - 1;
		if (usuario < 0 || usuario >= listaUsuarios.size()) {
			System.out.println("Usuário inválido!");
			return;
		}

		List<Livro> livrosEmprestados = listaUsuarios.get(usuario).getLivrosEmprestados();
		if (livrosEmprestados.isEmpty()) {
			System.out.println("Este usuário não possui livros emprestados.");
			return;
		}

		listarLivrosEmprestados(livrosEmprestados);
		int livro = lerInteiro("Informe o número do livro que será devolvido: ") - 1;
		if (livro < 0 || livro >= livrosEmprestados.size()) {
			System.out.println("Livro inválido!");
			return;
		}

		Livro livroDevolvido = livrosEmprestados.remove(livro);
		livroDevolvido.setDataEmprestimo(null);
		System.out.println("Livro devolvido com sucesso!");
	}

	private static void emprestarLivro() {
		if (listaUsuarios.isEmpty()) {
			System.out.println("Não existem usuários cadastrados.");
			return;
		}
		if (listaLivros.isEmpty()) {
			System.out.println("Não existem livros cadastrados.");
			return;
		}

		listarUsuarios();
		int usuario = lerInteiro("Informe o número do usuário que vai pegar o livro: ") - 1;
		if (usuario < 0 || usuario >= listaUsuarios.size()) {
			System.out.println("Usuário inválido!");
			return;
		}
		if (listaUsuarios.get(usuario).getLivrosEmprestados().size() >= 2) {
			System.out.println("Este usuário já atingiu o limite de dois livros emprestados.");
			return;
		}

		listarLivros();
		int livro = lerInteiro("Informe o número do livro que deseja emprestar: ") - 1;
		if (livro < 0 || livro >= listaLivros.size()) {
			System.out.println("Livro inválido!");
			return;
		}
		Livro livroSelecionado = listaLivros.get(livro);
		if (livroSelecionado.getDataEmprestimo() != null) {
			System.out.println("Este livro já está emprestado.");
			return;
		}

		listaUsuarios.get(usuario).getLivrosEmprestados().add(livroSelecionado);
		livroSelecionado.setDataEmprestimo(new Date());
		System.out.println("Livro emprestado com sucesso!");
	}

	private static void listarUsuarios() {
		System.out.println("\n-------- Usuários da biblioteca --------");
		if (listaUsuarios.isEmpty()) {
			System.out.println("Não existem usuários cadastrados.");
			return;
		}

		for (int i = 0; i < listaUsuarios.size(); i++) {
			Pessoa usuario = listaUsuarios.get(i);
			System.out.printf("%d) %s%n", i + 1, usuario.getNome());
			if (!usuario.getLivrosEmprestados().isEmpty()) {
				listarLivrosEmprestados(usuario.getLivrosEmprestados());
			}
		}
		System.out.println();
	}

	private static void listarLivrosEmprestados(List<Livro> livros) {
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			System.out.printf("  %d) %s - %s%n", i + 1, livro.getTitulo(), livro.getAutor());
		}
	}

	private static void cadastrarUsuario() {
		System.out.print("Informe o nome do usuário: ");
		String nome = scan.nextLine().trim();
		if (nome.isEmpty()) {
			System.out.println("O nome não pode ficar vazio.");
			return;
		}

		listaUsuarios.add(new Pessoa(nome));
		System.out.println("Usuário cadastrado com sucesso!");
	}

	private static void excluirLivro() {
		if (listaLivros.isEmpty()) {
			System.out.println("Não existem livros para excluir.");
			return;
		}

		listarLivros();
		int escolhaUsuario = lerInteiro("Informe o número do livro a ser excluído: ") - 1;
		if (escolhaUsuario < 0 || escolhaUsuario >= listaLivros.size()) {
			System.out.println("Livro inválido!");
			return;
		}
		if (listaLivros.get(escolhaUsuario).getDataEmprestimo() != null) {
			System.out.println("O livro está emprestado e não pode ser excluído.");
			return;
		}

		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso!");
	}

	private static void listarLivros() {
		System.out.println("\n-------- Acervo de livros --------");
		if (listaLivros.isEmpty()) {
			System.out.println("Não existem livros cadastrados.");
			return;
		}

		for (int i = 0; i < listaLivros.size(); i++) {
			Livro livro = listaLivros.get(i);
			System.out.printf("%d) %s - %s / %s%n", i + 1, livro.getTitulo(), livro.getAutor(),
					livro.getGenero());
			System.out.println("   " + livro.validarDisponibilidade());
		}
		System.out.println();
	}

	private static void cadastrarLivro() {
		System.out.print("Informe o título do livro: ");
		String titulo = scan.nextLine().trim();
		System.out.print("Informe o autor do livro: ");
		String autor = scan.nextLine().trim();
		System.out.print("Informe o gênero do livro: ");
		String genero = scan.nextLine().trim();

		if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty()) {
			System.out.println("Título, autor e gênero são obrigatórios.");
			return;
		}

		listaLivros.add(new Livro(titulo, autor, genero));
		System.out.println("Livro cadastrado com sucesso!");
	}
}
