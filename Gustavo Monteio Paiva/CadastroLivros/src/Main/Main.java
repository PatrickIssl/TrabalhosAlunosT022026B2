package Main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import Livros.Livros;

public class Main {

	static Scanner scan = new Scanner(System.in); 
	static List<Livros> listaLivro = new ArrayList<Livros>();
	static int proximoId = 1;
	
	public static void main(String[] args) {
		mostrarMenu();
	}

	private static void mostrarMenu() {
		
		
		int escolhaUsuario = -1;
		
		do {			
		System.out.println("========== Sistema Livro ==========");
		System.out.println("1 - Cadastrar");		
		System.out.println("2 - Listar Todos");
		System.out.println("3 - Buscar por ID");
		System.out.println("4 - Atualizar");
		System.out.println("5 - Excluir");
		System.out.println("0 - Sair");
		
		escolhaUsuario = scan.nextInt();		
		validarEscolha(escolhaUsuario);
		
		}while(escolhaUsuario!=0);
		
	}

	private static void validarEscolha(int escolhaUsuario) {

		if(escolhaUsuario == 1) {
			cadastrarLivro();
		} else if(escolhaUsuario == 2) {
			listarTodos();
		} else if(escolhaUsuario == 3) {
			buscarId();
		} else if(escolhaUsuario == 4) {
			atualizar();
		} else if(escolhaUsuario == 5) {
			excluir();
		} else if(escolhaUsuario == 0) {
			System.out.println("Voce saiu do sistema");
		} else {
			System.out.println("Número invalido, tente novamente");
		}
		
	}

	

	private static void buscarId() {
		
		if(listaLivro.isEmpty()) {
			System.out.println("Nenhum livro cadastrado");
			return;
		}
		
		System.out.println("Qual ID esta procurando");
		int id = scan.nextInt();
		
		Livros livro = procurarId(id);
		if(livro == null) {
			System.out.println("Livro invalido");
			return;
		}
		System.out.printf("Id: %d - Titulo: %s - Autor: %s", livro.getId(), livro.getTitulo(), livro.getAutor());
		
	}

	private static void excluir() {

		if(listaLivro.isEmpty()) {
			System.out.println("nenhum livro cadastrado");
			return;
		}
		
		listarTodos();
		
		System.out.println("Insira o id do titulo que quer ezcluir");
		int id = scan.nextInt();		
		
		Livros livro = procurarId(id);
		if(livro == null) {
			System.out.println("Livro n encontrado");
			return;
		}
		listaLivro.remove(livro);
		System.out.println("Livro removido com sucesso");
		
		
	}

	private static Livros procurarId(int id) {

		for(Livros livro : listaLivro) {
			if(livro.getId() == id) {
				return livro;	
			}
			
		}
		
		return null;
	}

	private static void atualizar() {

		if(listaLivro.isEmpty()) {
			System.out.println("Nenhum jogo cadastrado");
			return;
		}
		
		listarTodos();
		System.out.println("Insira o id do livro");
		int id = scan.nextInt();
		
		Livros livro = procurarId(id);
		
		if(livro == null) {
			System.out.println("Id invalido");
			return;
		}
		
		scan.nextLine();
		
		System.out.println("Insira o titulo atualizado");
		livro.setTitulo(scan.nextLine());	
		
		System.out.println("Insira o autor atualizado");
		livro.setAutor(scan.nextLine());	
		
		System.out.println("Livro atualizado");
		
	}

	private static void listarTodos() {

		if(listaLivro.isEmpty()) {
			System.out.println("Nenhum jogo cadastrado");
			return;
		}
		
		System.out.println("===== Lista de livros =====");
		
		for (Livros livro : listaLivro) {
			System.out.printf("Id: %d - Titulo: %s - Autor: %s\n", livro.getId(), livro.getTitulo(), livro.getAutor());
		}	
	}

	private static void cadastrarLivro() {
		Livros livro = new Livros();
		
		livro.setId(proximoId++);
		
		scan.nextLine();
		
		System.out.println("Insira o titulo do livro");
		livro.setTitulo(scan.nextLine());
		
		System.out.println("Insira o autor");
		livro.setAutor(scan.nextLine());
		
		listaLivro.add(livro);
		System.out.println("Livro cadastrado!");
		
	}
	
	
	
	
	
	
	
	
	
	

}
