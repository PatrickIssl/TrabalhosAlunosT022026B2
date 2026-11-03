package Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Jogos.Jogos;

public class Main {

	static Scanner scan = new Scanner(System.in);
	static List<Jogos> listaJogo = new ArrayList<Jogos>();
	static int proximoId = 1; 

	public static void main(String[] args) {
		mostrarMenu();
	}

	public static void mostrarMenu() {
		int escolhaUsuario = -1;
		do {
			System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar todos");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Excluir");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");

			escolhaUsuario = lerInteiro();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}

	public static void validarEscolha(int escolhaUsuario) {
		if (escolhaUsuario == 1) {
			cadastrarJogo();
		} else if (escolhaUsuario == 2) {
			listarJogo();
		} else if (escolhaUsuario == 3) {
			buscarId();
		} else if (escolhaUsuario == 4) {
			atualizar();
		} else if (escolhaUsuario == 5) {
			excluirJogo();
		} else if (escolhaUsuario == 0) {
			System.out.println("Sistema encerrado.");
		} else {
			System.out.println("Opção inválida, tente novamente.");
		}
	}

	private static int lerInteiro() {
		try {
			return Integer.parseInt(scan.nextLine().trim());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	
	private static Jogos procurarPorId(int id) {
		for (Jogos jogo : listaJogo) {
			if (jogo.getId() == id) {
				return jogo;
			}
		}
		return null;
	}

	private static void cadastrarJogo() {
		Jogos jogo = new Jogos();

		jogo.setId(proximoId++);

		System.out.print("Informe o nome do jogo: ");
		jogo.setNome(scan.nextLine());

		System.out.print("Informe o gênero do jogo: ");
		jogo.setGenero(scan.nextLine());

		listaJogo.add(jogo);
		System.out.println("Jogo cadastrado com sucesso! ID: " + jogo.getId());
	}

	private static void listarJogo() {
		if (listaJogo.isEmpty()) {
			System.out.println("Não existem jogos cadastrados!");
			return;
		}

		System.out.println("\n-------- Lista de Jogos --------");
		for (Jogos jogo : listaJogo) {
			exibirJogo(jogo);
		}
	}

	private static void exibirJogo(Jogos jogo) {
		System.out.printf("ID: %d | Nome: %s | Gênero: %s\n", jogo.getId(), jogo.getNome(), jogo.getGenero());
	}

	private static void buscarId() {
		if (listaJogo.isEmpty()) {
			System.out.println("Não existem jogos cadastrados!");
			return;
		}

		System.out.print("Informe o ID do jogo: ");
		int id = lerInteiro();

		Jogos jogo = procurarPorId(id);
		if (jogo == null) {
			System.out.println("ID não encontrado!");
			return;
		}
		exibirJogo(jogo);
	}

	private static void atualizar() {
		if (listaJogo.isEmpty()) {
			System.out.println("Não existem jogos para atualizar!");
			return;
		}

		listarJogo();
		System.out.print("Informe o ID do jogo a ser atualizado: ");
		int id = lerInteiro();

		Jogos jogo = procurarPorId(id);
		if (jogo == null) {
			System.out.println("ID não encontrado!");
			return;
		}

		System.out.print("Novo nome (atual: " + jogo.getNome() + "): ");
		jogo.setNome(scan.nextLine());

		System.out.print("Novo gênero (atual: " + jogo.getGenero() + "): ");
		jogo.setGenero(scan.nextLine());

		System.out.println("Jogo atualizado com sucesso!");
	}

	private static void excluirJogo() {
		if (listaJogo.isEmpty()) {
			System.out.println("Não existem jogos para excluir!");
			return;
		}

		listarJogo();
		System.out.print("Informe o ID do jogo a ser excluído: ");
		int id = lerInteiro();

		Jogos jogo = procurarPorId(id);
		if (jogo == null) {
			System.out.println("ID não encontrado!");
			return;
		}

		listaJogo.remove(jogo);
		System.out.println("Jogo removido com sucesso!");
	}
}