package bibliotecaClasse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {
	static Scanner scan = new Scanner(System.in);
	static List <Livros> listaLivros = new ArrayList <Livros>(); 
	static List <Pessoa> listaUsuarios = new ArrayList <Pessoa>();

	public static void main(String[] args) {
		printMenu();
	}

	public static void printMenu() {
		int escolhaUsuario = 0;
		System.out.println("1 - Todos os livros ");
		System.out.println("2 - Adicionar um livro ");
		System.out.println("3 - Excluir livro ");
		System.out.println("4 - Alugar Livro ");
		System.out.println("5 - Devolver Livro ");
		System.out.println("6 - Sair ");
		escolhaUsuario = scan.nextInt();
		validarEscolha(escolhaUsuario);

	}
	
	
	public static void listaGeral() {
		listaUsuarios.add(new Pessoa("Vitor"));
		listaUsuarios.add(new Pessoa("Willian"));
	    listaLivros.add(new Livros("O Senhor dos Anéis", "J.R.R. Tolkien", 1200));
	    listaLivros.add(new Livros("Dom Casmurro", "Machado de Assis", 250));
	    listaLivros.add(new Livros("Clean Code", "Robert C. Martin", 464));
	}
	
	public static void validarEscolha (int escolhaUsuario) {
		switch (escolhaUsuario) {
		
		case 6: {
			System.out.println("Saindo do sistema");
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
		
		}
		
		
		
	}
	public static void cadastrarLivro() {
		Livros livros = new Livros();
		System.out.println("Insira o nome do livro");
		livros.setNome(scan.nextLine());
		
		System.out.println("Insira o autor do livro");
		livros.setAutor(scan.nextLine());
		
		System.out.println("Insira o numero de paginas do livro");
		livros.setPaginas(scan.nextInt());
		listaLivros.add(livros);
		
		System.out.println("Livro cadastrado com sucesso");
	}
	
	private static void listarLivros() {
		for(int i = 0; i < listaLivros.size(); i++) {
			System.out.println(" " + listaLivros.get(i).getNome().);
			
		}
	}

}
