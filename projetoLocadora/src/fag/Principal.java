package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Filme;
import fag.objetos.Pessoa;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Filme> listaFilmes = new ArrayList<Filme>();
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
		listaFilmes.add(new Filme("Bob esponja", "Animação"));
		listaFilmes.add(new Filme("Interestelar", "Ficção"));
		listaFilmes.add(new Filme("Shrek", "Animação"));
		listaFilmes.add(new Filme("Minecraft", "Animação"));
		listaFilmes.add(new Filme("Ratatuille", "Animação"));
		listaFilmes.add(new Filme("MR bean", "Comedia"));
		listaFilmes.add(new Filme("A culpa é das estrela", "romance"));
		listaFilmes.add(new Filme("Carros", "Animação"));
		listaFilmes.add(new Filme("Gato de botas", "Animação"));
		listaFilmes.add(new Filme("A era do gelo", "Animação"));
		listaFilmes.add(new Filme("A freira", "Terror"));
		listaFilmes.add(new Filme("Invocação do mal", "Terror"));
		listaFilmes.add(new Filme("Gente grande", "Comedia"));
		listaFilmes.add(new Filme("As branquelas", "Comedia"));
		listaFilmes.add(new Filme("American pie", "Comedia"));
		listaFilmes.add(new Filme("Scooby doo", "Animação"));
		listaFilmes.add(new Filme("Dora aventureira", "Animação"));
	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Listar filmes");
			System.out.println("2 - Cadastrar filme");
			System.out.println("3 - Excluir filme");
			System.out.println("4 - Locar filme");
			System.out.println("5 - Devolver filme");
			System.out.println("6-  Registrar usuario");
			System.out.println("7-  Listar usuarios");
			System.out.println("0 - Saida");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
			}while(escolhaUsuario != 0);
	}
	
	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0: {
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1:{
			listarFilmes();
			break;
		}
		case 2:{
			cadastrarFilme();
			break;
		}
		case 3:{
			excluirFilme();
			break;
		}
		case 4:{
			locarFilme();
			break;
		}
		case 5:{
			devolverFilme();
			break;
		}
		case 6:{
			CadastrarUsuario();
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

	private static void devolverFilme() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai devolver o filme");
		int usuario = scan.nextInt()-1;
		scan.nextLine();
		
		if(usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		if(listaUsuarios.get(usuario).getFilmesLocados().size() == 0) {
			System.out.println("Usuário não possui filmes locados!");
			return;
		}
		
		System.out.println("Informe o filme que o usuário vai devolver");
		int filme= scan.nextInt()-1;
		scan.nextLine();
		
		if(filme >= listaUsuarios.get(usuario).getFilmesLocados().size() || filme < 0) {
			System.out.println("Informe um filme existente");
		}
		
		listaUsuarios.get(usuario).getFilmesLocados().get(filme).setDataLocacao(null);
		listaUsuarios.get(usuario).getFilmesLocados().remove(filme);
		System.out.println("Filme devolvido com sucesso!");
		
	}

	private static void locarFilme() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai locar o filme");
		int usuario = scan.nextInt()-1;
		scan.nextLine();
		if(usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		
		if(listaUsuarios.get(usuario).getFilmesLocados().size() == 2) {
			System.out.println("Usuário está com o maximo de filmes possiveis! Devolva um para poder locar outro!");
			return;
		}
		
		listarFilmes();
		int filme = scan.nextInt()-1;
		scan.nextLine();
		if(filme > listaFilmes.size() && filme < 0) {
			System.out.println("Informe um filme valido!");
			return;
		}
		if(listaFilmes.get(filme).getDataLocacao() != null) {
			System.out.println("Filme ja está locado!");
			return;
		}
		
		
		listaUsuarios.get(usuario).getFilmesLocados().add(listaFilmes.get(filme));
		listaFilmes.get(filme).setDataLocacao(new Date());
		System.out.println("Filme locado com sucesso!");
	}

	private static void listarUsuarios() {
		System.out.println("\n--------Lista Usuarios--------");
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.printf("%d) %s \n", i+1, listaUsuarios.get(i).getNome());
			if(listaUsuarios.get(i).getFilmesLocados().size() != 0) {
				for (int j = 0; j < listaUsuarios.get(i).getFilmesLocados().size(); j++) {
					System.out.printf("  %d) %s - %s\n", j+1, listaUsuarios.get(i).getFilmesLocados().get(j).getNome(),listaUsuarios.get(i).getFilmesLocados().get(j).getGenero());
				}
			}
		}
		System.out.println("");
	}

	private static void CadastrarUsuario() {
		Pessoa usuario = new Pessoa();
		
		System.out.println("Informe o nome do Usuario: ");
		usuario.setNome(scan.nextLine());

		listaUsuarios.add(usuario);
		System.out.println("Usuario cadastrado com sucesso!");
		
	}

	private static void excluirFilme() {
		if(listaFilmes.size() == 0) {
			System.out.println("Não existem filmes para excluir!");
			return;
		}
		
		listarFilmes();
		System.out.println("Informe o filme a ser excluido: ");
		int escolhaUsuario = scan.nextInt() - 1;
		
		if(escolhaUsuario > listaFilmes.size()) {
			System.out.println("Valor inválido!");
			return;
		}
		if(listaFilmes.get(escolhaUsuario).getDataLocacao() != null) {
			System.out.println("O filme está locado, portanto não pode ser excluido!");
			return;
		}
		listaFilmes.remove(escolhaUsuario);
		System.out.println("Filme removido com sucesso!");
		
		
	}

	private static void listarFilmes() {
		System.out.println("\n--------Lista Filmes--------");
		for (int i = 0; i < listaFilmes.size(); i++) {
			System.out.printf("%d) %s - %s / %s\n", i+1, listaFilmes.get(i).getNome(),listaFilmes.get(i).getGenero(), listaFilmes.get(i).validarDisponibilidade());
		}
		System.out.println("");
		
	}

	private static void cadastrarFilme() {
		Filme filme = new Filme();
		
		System.out.println("Informe o nome do filme: ");
		filme.setNome(scan.nextLine());

		System.out.println("Informe o genero do filme: ");
		filme.setGenero(scan.nextLine());
		
		listaFilmes.add(filme);
		System.out.println("Filme cadastrado com sucesso!");
	}
	
	

}
