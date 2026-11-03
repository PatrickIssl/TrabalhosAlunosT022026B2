package Fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Fag.objeto.Livro;
import Fag.objeto.Pessoa;

public class Principal {
	
	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivro = new ArrayList<Livro>();
	static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();
	
	public static void main(String[] args) {
		popularTabela();
		
		System.out.println("Sistema iniciado!");
		menu();
	}

	private static void popularTabela() {
		listaUsuarios.add(new Pessoa("Patrick"));
		listaUsuarios.add(new Pessoa("Gabriel"));
		listaUsuarios.add(new Pessoa("Theo"));
		listaUsuarios.add(new Pessoa("João"));
		listaUsuarios.add(new Pessoa("Pedro"));
		listaUsuarios.add(new Pessoa("Alex"));
		listaUsuarios.add(new Pessoa("Paulo"));
		listaLivro.add(new Livro("Harry Potter", "Fantasia"));
		listaLivro.add(new Livro("O Pequeno Príncipe", "Infantil"));
		listaLivro.add(new Livro("Dom Casmurro", "Romance"));
		listaLivro.add(new Livro("Diário de um Banana", "Comédia"));
		listaLivro.add(new Livro("A Culpa é das Estrelas", "Romance"));
		listaLivro.add(new Livro("Percy Jackson", "Fantasia"));
		listaLivro.add(new Livro("It: A Coisa", "Terror"));
		listaLivro.add(new Livro("O Hobbit", "Fantasia"));
		listaLivro.add(new Livro("A Menina que Roubava Livros", "Drama"));
		listaLivro.add(new Livro("Jogos Vorazes", "Ficção"));
		listaLivro.add(new Livro("Crepúsculo", "Romance"));
		listaLivro.add(new Livro("O Código Da Vinci", "Suspense"));
		listaLivro.add(new Livro("O Diário de Anne Frank", "Biografia"));
		listaLivro.add(new Livro("A Revolução dos Bichos", "Fábula"));
		listaLivro.add(new Livro("Coraline", "Fantasia"));
		listaLivro.add(new Livro("O Alquimista", "Aventura"));
		listaLivro.add(new Livro("Extraordinário", "Drama"));
		
	}

	private static void menu() {
		int escolhaUsuario = 0;
		
		do {
			System.out.println("-------- Escolha uma das opções --------");
			System.out.println("1 - Lista de livros");
			System.out.println("2 - Cadastrar livro");
			System.out.println("3 - Excluir livro");
			System.out.println("4 - Emprestar livro");
			System.out.println("5 - Devolver livro");
			System.out.println("6 - Registrar usuario");
			System.out.println("7 - Listar usuarios");
			System.out.println("0 - Sair");
			
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
			
		} while (escolhaUsuario != 0);
		
	}

	private static void validarEscolha(int escolhaUsuario) {
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
			System.out.println("Incira um valor valido!");
		}
		
	}

	private static void listarLivros() {
		System.out.println("\n-------- Lista de Livros --------");
		for (int i = 0; i < listaLivro.size(); i++) {
			System.out.printf("%d) %s - %s / %s\n", i+1, listaLivro.get(i).getNome(), listaLivro.get(i).getGenero(), listaLivro.get(i).validarDisponibilidade());
		}
		System.out.println();
	}
	
	private static void cadastrarLivro() {
		Livro livro = new Livro();
		
		System.out.println("Informe o nome do livro: ");
		livro.setNome(scan.nextLine());
		
		System.out.println("Informe o genero do livro: ");
		livro.setGenero(scan.nextLine());
		
		listaLivro.add(livro);
		System.out.println("Filme cadastrado com sucesso!");
	}
	
	private static void excluirLivro() {
		if (listaLivro.size() == 0) {
			System.out.println("Nâo existem livros para excluir!");
			return;
		}
		
		listarLivros();
		System.out.println("Informe o livro a ser excluido: ");
		int escolhaUsuario = scan.nextInt() - 1;
		
		if (escolhaUsuario > listaLivro.size()) {
			System.out.println("Valor inválido!");
			return;
		}
		if (listaLivro.get(escolhaUsuario).getDataEmprestimo() != null) {
			System.out.println("O livro está locado, portanto não pode ser excluido!");
			return;
		}
		listaLivro.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso!");
	}
	
	private static void emprestarLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai emprestar o livro: ");
		int usuario = scan.nextInt() - 1;
		scan.nextLine();
		if (usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		
		if (listaUsuarios.get(usuario).getLivrosEmprestados().size() == 2) {
			System.out.println("Usuário está com o maximo de livro possiveis! Devolva um para poder locar outro!");
			return;
		}
		
		listarLivros();
		int livro = scan.nextInt() - 1;
		scan.nextLine();
		if (livro > listaLivro.size() && livro < 0) {
			System.out.println("Informe um livro valido!");
			return;
		}
		if (listaLivro.get(livro).getDataEmprestimo() != null) {
			System.out.println("Livro já está emprestado!");
			return;
		}
		
		listaUsuarios.get(usuario).getLivrosEmprestados().add(listaLivro.get(livro));
		listaLivro.get(livro).setDataEmprestimo(new Date());
		System.out.println("Livro locado com sucesso!");
	}
	
	private static void devolverLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai devolver o livro: ");
		int usuario = scan.nextInt() - 1;
		scan.nextLine();
		if (usuario > listaUsuarios.size() || usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		
		if (listaUsuarios.get(usuario).getLivrosEmprestados().size() == 0) {
			System.out.println("Usuário não possui livros emprestados");
			return;
		}
		
		System.out.println("Informe o livro que o usuário vai devolver: ");
		int livro = scan.nextInt() - 1;
		scan.nextLine();
		if (livro >= listaUsuarios.get(usuario).getLivrosEmprestados().size() || livro < 0) {
			System.out.println("Informe um livro existente!");
			return;
		}
		
		listaUsuarios.get(usuario).getLivrosEmprestados().get(livro).setDataEmprestimo(null);
		listaUsuarios.get(usuario).getLivrosEmprestados().remove(livro);
		System.out.println("Livro devolvido com sucesso!");
		
	}
	
	private static void cadastrarUsuario() {
		Pessoa usuario = new Pessoa();
		
		System.out.println("Informe o nome do usuario: ");
		usuario.setNome(scan.nextLine());
		
		listaUsuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
	}
	
	private static void listarUsuarios() {
		System.out.println("\n-------- Lista de Usuarios --------");
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.printf("%d) %s \n", i+1, listaUsuarios.get(i).getNome());
			if (listaUsuarios.get(i).getLivrosEmprestados().size() != 0) {
				for (int j = 0; j < listaUsuarios.get(i).getLivrosEmprestados().size(); j++) {
					System.out.printf("%d) %s - %s \n", j+1, listaUsuarios.get(i).getLivrosEmprestados().get(j).getNome(), listaLivro.get(j).getGenero(), listaUsuarios.get(i).getLivrosEmprestados().get(j).getGenero());
				}
			}
		}
		System.out.println();
	}
}
