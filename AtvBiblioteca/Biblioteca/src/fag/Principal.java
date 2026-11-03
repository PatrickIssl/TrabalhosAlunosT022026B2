package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fag.Objetos.Livro;
import fag.Objetos.Pessoa;


public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();

	public static void main(String[] args) {
		popularTabela();
		System.out.println("Sistema iniciado");
		mostrarMenu();
	}

	private static void popularTabela() {
		listaUsuarios.add(new Pessoa("Gustavo"));
		listaUsuarios.add(new Pessoa("Gabriel"));
		listaUsuarios.add(new Pessoa("Pedro"));
		listaUsuarios.add(new Pessoa("Joao"));
		listaUsuarios.add(new Pessoa("Julio"));
		listaUsuarios.add(new Pessoa("Fabio"));
		listaUsuarios.add(new Pessoa("Delcio"));
		listaLivros.add(new Livro("Diario de um banana", "Comédia"));
		listaLivros.add(new Livro("Diario de um banana 1", "Comédia"));
		listaLivros.add(new Livro("Diario de um banana 2", ""));
		listaLivros.add(new Livro("Harry Potter", "fantasia e aventura"));
		listaLivros.add(new Livro("Batmam", "ação, suspense e aventura"));
		listaLivros.add(new Livro("Homem Aranha", "ação, aventura"));
		listaLivros.add(new Livro("Flash", "ação"));
		listaLivros.add(new Livro("Liga da Justiça", "ficção científica/aventura"));
	}

	private static void mostrarMenu() {
		int escolhaUsuario = 0;

		do {
			System.out.println("------------Selecione uma das opções-----------------");
			System.out.println("1- Consultar livros");
			System.out.println("2- Cadastrar livros");
			System.out.println("3- Excluir livros");
			System.out.println("4- Locar Livro");
			System.out.println("5- Devolver Livro");
			System.out.println("6- Registrar usúario");
			System.out.println("7- Consultar usuários");
			System.out.println("0- Saída");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		}while (escolhaUsuario != 0);

	}

	private static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0: {
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1: {
			consultarLivro();
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
			locarLivro();
			break;
		}
		case 5: {
			devolverLivro();
			break;
		}
		case 6: {
			registrarUsuario();
			break;
		}
		case 7: {
			consultarUsuarios();
			break;
		}
		default:
			System.out.println("Insira um valor válido!");
		}

	}

	private static void consultarUsuarios() {
    System.out.println("-------Lista de usuários-------");
    for (int i = 0; i < listaUsuarios.size(); i++) {
		System.out.printf("%d) %s \n", i+1, listaUsuarios.get(i).getNome());
		if(listaUsuarios.get(i).getLivrosLocados().size() != 0) {
			for (int j = 0; j < listaUsuarios.get(i).getLivrosLocados().size(); j++) {
				System.out.printf("  %d) %s - %s\n", j+1, listaUsuarios.get(i).getLivrosLocados().get(j).getNome(),listaUsuarios.get(i).getLivrosLocados().get(j).getGenero());
			}
		}
	}
	System.out.println("");
}
  

	private static void registrarUsuario() {
		Pessoa usuario = new Pessoa();

		System.out.println("Informe o nome do Usuario: ");
		usuario.setNome(scan.nextLine());

		listaUsuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");

	}

	private static void devolverLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai devolver o livrop");
		int usuario = scan.nextInt()-1;
		scan.nextLine();

		if(usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		if(listaUsuarios.get(usuario).getLivrosLocados().size() == 0) {
			System.out.println("Usuário não possui livro locados!");
			return;
		}

		System.out.println("Informe o livro que o usuário vai devolver");
		int filme= scan.nextInt()-1;
		scan.nextLine();

		if(filme >= listaUsuarios.get(usuario).getLivrosLocados().size() || filme < 0) {
			System.out.println("Informe um livro existente");
		}

		listaUsuarios.get(usuario).getLivrosLocados().get(filme).setDataLocacao(null);
		listaUsuarios.get(usuario).getLivrosLocados().remove(filme);
		System.out.println("Livro devolvido com sucesso!");


	}

	private static void locarLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai locar o livro");
		int usuario = scan.nextInt()-1;
		scan.nextLine();
		if(usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		
		if(listaUsuarios.get(usuario).getLivrosLocados().size() == 2) {
			System.out.println("Usuário está com o maximo de livros possiveis! Devolva um para poder locar outro!");
			return;
		}
		
		consultarLivro();
		int filme = scan.nextInt()-1;
		scan.nextLine();
		if(filme > listaLivros.size() && filme < 0) {
			System.out.println("Informe um livro valido!");
			return;
		}
		if(listaLivros.get(filme).getDataLocacao() != null) {
			System.out.println("Livro ja está locado!");
			return;
		}
		
		
		listaUsuarios.get(usuario).getLivrosLocados().add(listaLivros.get(filme));
		listaLivros.get(filme).setDataLocacao(new Date());	
		System.out.println("Livro locado com sucesso!");

	}

	private static void listarUsuarios() {
		System.out.println("\n--------Lista Usuarios--------");
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.printf("%d) %s \n", i+1, listaUsuarios.get(i).getNome());
			if(listaUsuarios.get(i).getLivrosLocados().size() != 0) {
				for (int j = 0; j < listaUsuarios.get(i).getLivrosLocados().size(); j++) {
					System.out.printf("  %d) %s - %s\n", j+1, listaUsuarios.get(i).getLivrosLocados().get(j).getNome(),listaUsuarios.get(i).getLivrosLocados().get(j).getGenero());
				}
			}
		}
		System.out.println("");

	}

	private static void excluirLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Não existe livros para excluir!");
			return;
		}

		consultarLivro();
		System.out.println("Informe o livro a ser excluido: ");
		int escolhaUsuario = scan.nextInt() - 1;

		if(escolhaUsuario > listaLivros.size()) {
			System.out.println("Valor inválido!");
			return;
		}
		if(listaLivros.get(escolhaUsuario).getDataLocacao() != null) {
			System.out.println("O livro está locado, portanto não pode ser excluido!");
			return;
		}
		listaLivros.remove(escolhaUsuario);
		System.out.println("livro removido com sucesso!");
	}

	private static void cadastrarLivro() {
		Livro livro = new Livro();
		System.out.println("Informe o nome do livro para o cadastro: ");
		livro.setNome(scan.nextLine());
		System.out.println("informe o gênero do livro para o cadastro: ");
		livro.setGenero(scan.nextLine());
		listaLivros.add(livro);
		System.out.println("Livro cadastrado com suscesso!");

	}

	private static void consultarLivro() {
		System.out.println("----------Lista de livros----------");
		for (int i = 0; i < listaLivros.size(); i++) {
			System.out.printf("%d) %s - %s / %s\n", i+1, listaLivros.get(i).getNome(),listaLivros.get(i).getGenero(), listaLivros.get(i).validarDisponibilidade());
		}


	}


}
