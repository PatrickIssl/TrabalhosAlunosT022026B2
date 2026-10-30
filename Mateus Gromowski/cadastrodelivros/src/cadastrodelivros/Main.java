package cadastrodelivros;

import java.util.Scanner;
import modelo.Livro;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static List<Livro> livros = new ArrayList<>();
	public static void main(String[] args) {
		int escolha = 0;
		do {
			escolha = menu();
			menuEscolha(escolha);
		} while (escolha != 0);
		System.out.println("Obrigado por usar!");
	}

	private static int menu() {
		System.out.println("========== SISTEMA DE GERENCIAMENTO ==========");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar todos");
		System.out.println("3 - Buscar por ID");
		System.out.println("4 - Atualizar");
		System.out.println("5 - Excluir");
		System.out.println("0 - Sair");
		System.out.print("Escolha: ");
		int escolha = sc.nextInt();
		sc.nextLine();
		if(escolha > 5 || escolha < 0) {
			System.out.println("Entrada inválida.");
		}
		return escolha;
	}
	
	private static void menuEscolha(int escolha) {
		switch(escolha) {
			case 1:
				cadastraLivro();
				break;
			case 2:
				listarTodos();
				break;
			case 3:
				buscaPorId();
				break;
			case 4:
				atualizaLivro();
				break;
			case 5:
				excluiLivro();
				break;
			default:
				break;
		}
	}
	private static void listarTodos() {
		if(livros.size() == 0) {
			System.out.println("Não há livros para serem mostrados.");
			return;
		}
		for (Livro livro : livros) {
			System.out.println("----------");
			System.out.println("ID: " + livro.getID());
			System.out.println("Nome: " + livro.getNome());
			System.out.println("Autor: " + livro.getAutor());
		}
		System.out.println("----------");
	}
	private static void buscaPorId() {
		if(livros.size() == 0) {
			System.out.println("Não há livros para serem mostrados.");
			return;
		}
		System.out.print("Insira o ID do livro que você deseja buscar: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean flag = false;
		for (Livro livro : livros) {
			if(id == livro.getID()) {
				flag = true;
				System.out.println("----------");
				System.out.println("ID: " + livro.getID());
				System.out.println("Nome: " + livro.getNome());
				System.out.println("Autor: " + livro.getAutor());
				System.out.println("----------");
				break;
			}
		}
		if(!flag) {
			System.out.println("Livro não encontrado.");
		}
		
	}
	private static void cadastraLivro() {
		System.out.print("Insira o nome do livro: ");
		String nome = sc.nextLine();
		System.out.print("Insira o nome do autor do livro: ");
		String autor = sc.nextLine();
		livros.add(new Livro(nome, autor));
		Livro.incrementaID();
		System.out.println("Livro registrado com sucesso.");
	}
	private static void atualizaLivro() {
		if(livros.size() == 0) {
			System.out.println("Não há livros para serem atualizados.");
			return;
		}
		System.out.print("Qual é o ID do livro que você deseja atualizar?: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean flag = false;
		for (Livro livro : livros) {
			if(id == livro.getID()) {
				flag = true;
				System.out.print("Insira o novo nome do livro: ");
				String nome = sc.nextLine();
				System.out.print("Insira o novo nome do autor do livro: ");
				String autor = sc.nextLine();
				Livro livroEncontrado = livros.get(id);
				livroEncontrado.setNome(nome);
				livroEncontrado.setAutor(autor);
				System.out.println("Livro atualizado com sucesso.");
				break;
			}
		}
		if(!flag) {
			System.out.println("Livro não encontrado.");
		}
	}
	
	private static void excluiLivro() {
		if(livros.size() == 0) {
			System.out.println("Não há livros para serem excluídos.");
			return;
		}
		System.out.print("Qual é o ID do livro que você deseja excluir?: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean flag = false;
		for (Livro livro : livros) {
			if(id == livro.getID()) {
				flag = true;
				livros.remove(id);
				System.out.println("Livro deletado com sucesso.");
				break;
			}
		}
		if(!flag) {
			System.out.println("Livro não encontrado.");
		}
	}

}
