package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Livro;
import fag.objetos.Pessoa;

public class Principal {

	static final int LIMITE_EMPRESTIMOS = 3;
	
	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();
		
	
	public static void main(String[] args) {
		popularTabela();
		
		System.out.println("Sistema iniciado!");
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
		listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));
		listaLivros.add(new Livro("O Cortiço", "Aluísio Azevedo", "Romance"));
		listaLivros.add(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "Romance"));
		listaLivros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Infantil"));
		listaLivros.add(new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowling", "Fantasia"));
		listaLivros.add(new Livro("O Senhor dos Anéis", "J. R. R. Tolkien", "Fantasia"));
		listaLivros.add(new Livro("O Hobbit", "J. R. R. Tolkien", "Fantasia"));
		listaLivros.add(new Livro("1984", "George Orwell", "Ficção"));
		listaLivros.add(new Livro("Fahrenheit 451", "Ray Bradbury", "Ficção"));
		listaLivros.add(new Livro("Duna", "Frank Herbert", "Ficção"));
		listaLivros.add(new Livro("Drácula", "Bram Stoker", "Terror"));
		listaLivros.add(new Livro("It - A Coisa", "Stephen King", "Terror"));
		listaLivros.add(new Livro("Frankenstein", "Mary Shelley", "Terror"));
		listaLivros.add(new Livro("Sherlock Holmes", "Arthur Conan Doyle", "Suspense"));
		listaLivros.add(new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", "Suspense"));
		listaLivros.add(new Livro("Clean Code", "Robert C. Martin", "Tecnologia"));
		listaLivros.add(new Livro("Java: Como Programar", "Paul Deitel", "Tecnologia"));
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
			System.out.println("6 - Registrar usuario");
			System.out.println("7 - Listar usuarios");
			System.out.println("0 - Saida");
			escolhaUsuario = lerInteiro();
			validarEscolha(escolhaUsuario);
		} while(escolhaUsuario != 0);
	}
	
	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0: {
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1:{
			listarLivros();
			break;
		}
		case 2:{
			cadastrarLivro();
			break;
		}
		case 3:{
			excluirLivro();
			break;
		}
		case 4:{
			emprestarLivro();
			break;
		}
		case 5:{
			devolverLivro();
			break;
		}
		case 6:{
			cadastrarUsuario();
			break;
		}
		case 7:{
			listarUsuarios();
			break;
		}
		default:
			System.out.println("Insira um valor valido!");
		}
	}

	// Le uma linha e converte para inteiro; retorna -1 se nao for numero
	private static int lerInteiro() {
		try {
			return Integer.parseInt(scan.nextLine().trim());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private static void devolverLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai devolver o livro");
		int usuario = lerInteiro() - 1;
		
		if(usuario >= listaUsuarios.size() || usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		if(listaUsuarios.get(usuario).getLivrosEmprestados().size() == 0) {
			System.out.println("Usuário não possui livros emprestados!");
			return;
		}
		
		System.out.println("Informe o livro que o usuário vai devolver");
		int livro = lerInteiro() - 1;
		
		if(livro >= listaUsuarios.get(usuario).getLivrosEmprestados().size() || livro < 0) {
			System.out.println("Informe um livro existente!");
			return;
		}
		
		listaUsuarios.get(usuario).getLivrosEmprestados().get(livro).setDataEmprestimo(null);
		listaUsuarios.get(usuario).getLivrosEmprestados().remove(livro);
		System.out.println("Livro devolvido com sucesso!");
		
	}

	private static void emprestarLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai pegar o livro emprestado");
		int usuario = lerInteiro() - 1;
		if(usuario >= listaUsuarios.size() || usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		
		if(listaUsuarios.get(usuario).getLivrosEmprestados().size() >= LIMITE_EMPRESTIMOS) {
			System.out.println("Usuário está com o maximo de livros possiveis! Devolva um para poder pegar outro!");
			return;
		}
		
		listarLivros();
		System.out.println("Informe o livro a ser emprestado");
		int livro = lerInteiro() - 1;
		if(livro >= listaLivros.size() || livro < 0) {
			System.out.println("Informe um livro valido!");
			return;
		}
		if(listaLivros.get(livro).getDataEmprestimo() != null) {
			System.out.println("Livro ja está emprestado!");
			return;
		}
		
		listaUsuarios.get(usuario).getLivrosEmprestados().add(listaLivros.get(livro));
		listaLivros.get(livro).setDataEmprestimo(new Date());
		System.out.println("Livro emprestado com sucesso!");
	}

	private static void listarUsuarios() {
		System.out.println("\n--------Lista Usuarios--------");
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.printf("%d) %s \n", i+1, listaUsuarios.get(i).getNome());
			if(listaUsuarios.get(i).getLivrosEmprestados().size() != 0) {
				for (int j = 0; j < listaUsuarios.get(i).getLivrosEmprestados().size(); j++) {
					System.out.printf("  %d) %s - %s\n", j+1, listaUsuarios.get(i).getLivrosEmprestados().get(j).getTitulo(), listaUsuarios.get(i).getLivrosEmprestados().get(j).getAutor());
				}
			}
		}
		System.out.println("");
	}

	private static void cadastrarUsuario() {
		Pessoa usuario = new Pessoa();
		
		System.out.println("Informe o nome do Usuario: ");
		usuario.setNome(scan.nextLine());

		listaUsuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
		
	}

	private static void excluirLivro() {
		if(listaLivros.size() == 0) {
			System.out.println("Não existem livros para excluir!");
			return;
		}
		
		listarLivros();
		System.out.println("Informe o livro a ser excluido: ");
		int escolhaUsuario = lerInteiro() - 1;
		
		if(escolhaUsuario >= listaLivros.size() || escolhaUsuario < 0) {
			System.out.println("Valor inválido!");
			return;
		}
		if(listaLivros.get(escolhaUsuario).getDataEmprestimo() != null) {
			System.out.println("O livro está emprestado, portanto não pode ser excluido!");
			return;
		}
		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso!");
		
	}

	private static void listarLivros() {
		System.out.println("\n--------Lista Livros--------");
		for (int i = 0; i < listaLivros.size(); i++) {
			System.out.printf("%d) %s - %s - %s / %s\n", i+1, listaLivros.get(i).getTitulo(), listaLivros.get(i).getAutor(), listaLivros.get(i).getGenero(), listaLivros.get(i).validarDisponibilidade());
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

}
