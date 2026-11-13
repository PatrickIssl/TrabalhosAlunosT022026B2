package Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<livros> listaLivros = new ArrayList<livros>();
	static int proximoId = 1;

	public static void main(String[] args) {
		int opcao;
		do {
			System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========\n");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar todos");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Excluir");
			System.out.println("0 - Sair");
			System.out.print("\nEscolha uma opcao: ");
			opcao = lerInteiro();

			switch (opcao) {
			case 1:
				cadastrar();
				break;
			case 2:
				listar();
				break;
			case 3:
				buscar();
				break;
			case 4:
				atualizar();
				break;
			case 5:
				excluir();
				break;
			case 0:
				System.out.println("Sistema encerrado.");
				break;
			default:
				System.out.println("Opcao invalida!");
			}
		} while (opcao != 0);
	}
	
	private static int lerInteiro() {
		if (scan.hasNextInt()) {
			int numero = scan.nextInt();
			scan.nextLine();
			return numero;
		}
		scan.nextLine();
		return -1;
	}

	private static livros buscarPorId(int id) {
		for (int i = 0; i < listaLivros.size(); i++) {
			if (listaLivros.get(i).getId() == id) {
				return listaLivros.get(i);
			}
		}
		return null;
	}

	private static void mostrarLivro(livros livros) {
		System.out.println("ID: " + livros.getId() + " | Titulo: " + livros.getTitulo() + " | Autor: " + livros.getAutor());
	}

	private static void cadastrar() {
		System.out.print("Titulo: ");
		String titulo = scan.nextLine();
		System.out.print("Autor: ");
		String autor = scan.nextLine();

		livros livros = new livros(proximoId, titulo, autor);
		listaLivros.add(livros);
		proximoId++;

		System.out.println("Livro cadastrado com o ID " + livros.getId() + "!");
	}

	private static void listar() {
		if (listaLivros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}
		for (int i = 0; i < listaLivros.size(); i++) {
			mostrarLivro(listaLivros.get(i));
		}
	}

	private static void buscar() {
		if (listaLivros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}
		System.out.print("Informe o ID: ");
	 livros livro = buscarPorId(lerInteiro());
		if (livro == null) {
			System.out.println("ID nao encontrado.");
			return;
		}
		mostrarLivro(livro);
	}

	private static void atualizar() {
		if (listaLivros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}
		System.out.print("Informe o ID do livro a atualizar: ");
		livros livros = buscarPorId(lerInteiro());
		if (livros == null) {
			System.out.println("ID nao encontrado.");
			return;
		}

		System.out.print("Novo titulo: ");
		livros.setTitulo(scan.nextLine());
		System.out.print("Novo autor: ");
		livros.setAutor(scan.nextLine());

		System.out.println("Livro atualizado com sucesso!");
	}

	private static void excluir() {
		if (listaLivros.isEmpty()) {
			System.out.println("Nenhum livro cadastrado.");
			return;
		}
		System.out.print("Informe o ID do livro a excluir: ");
		livros livros = buscarPorId(lerInteiro());
		if (livros == null) {
			System.out.println("ID nao encontrado.");
			return;
		}

		listaLivros.remove(livros);
		System.out.println("Livros excluido com sucesso!");
	}

}