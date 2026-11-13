package trabalho1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Jogo> jogos = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	private static int proximoId = 1;

	public static void main(String[] args) {
		int opcao;

		do {
			exibirMenu();
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine();

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
				System.out.println("Encerrando sistema.");
				break;
			default:
				System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
		scanner.close();
	}

	private static void listar() {
		System.out.println("== Lista ==");
		if (jogos.isEmpty()) {
			System.out.println("Nenhum jogo cadastrado.");
			return;
		}

		for (Jogo jogo : jogos) {
			jogo.exibirDados();
		}
	}

	private static void buscar() {
		System.out.println("== Buscar ==");
		if (jogos.isEmpty()) {
			System.out.println("Nenhum jogo cadastrado.");
			return;
		}
		System.out.print("Digite o ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Jogo jogo = buscarJogo(id);

		if (jogo == null) {
			System.out.println("ID não encontrado.");
		} else {
			System.out.println("Jogo encontrado.");
			jogo.exibirDados();
		}

	}

	private static Jogo buscarJogo(int id) {
		for (Jogo jogo : jogos) {
			if (jogo.getId() == id) {
				return jogo;
			}
		}
		return null;
	}

	private static void atualizar() {
		System.out.println("== Atualizar ==");

		if (jogos.isEmpty()) {
			System.out.println("Nenhum jogo cadastrado.");
			return;
		}

		System.out.print("Digite o ID do jogo a atualizar: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Jogo jogo = buscarJogo(id);

		if (jogo == null) {
			System.out.println("ID não encontrado.");
			return;
		}

		System.out.println("\nDados atuais:");
		jogo.exibirDados();
		System.out.println("(deixe em branco para manter o valor atual)");

		System.out.print("Novo nome: ");
		String nome = scanner.nextLine();
		if (!nome.isEmpty()) {
			jogo.setNome(nome);
		}

		System.out.print("Novo gênero: ");
		String genero = scanner.nextLine();
		if (!genero.isEmpty()) {
			jogo.setGenero(genero);
		}

		System.out.println("\nJogo atualizado com sucesso.");
		jogo.exibirDados();

	}

	private static void excluir() {
		System.out.println("== Excluir ==");

		if (jogos.isEmpty()) {
			System.out.println("Nenhum jogo cadastrado.");
			return;
		}

		System.out.print("Digite o ID do jogo a excluir: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		Jogo jogo = buscarJogo(id);

		if (jogo == null) {
			System.out.println("ID não encontrado.");
			return;
		}

		jogos.remove(jogo);
		System.out.println("Jogo " + jogo.getNome() + " excluído com sucesso.");

	}

	private static void cadastrar() {
		System.out.println("== Cadastro ==");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();

		System.out.print("Gênero: ");
		String genero = scanner.nextLine();

		Jogo novo = new Jogo(proximoId, nome, genero);
		jogos.add(novo);

		System.out.println("\nJogo cadastrado com sucesso. ID: " + proximoId);
		proximoId++;
	}

	private static void exibirMenu() {
		System.out.println("\n=== MENU ===");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar todos");
		System.out.println("3 - Buscar por ID");
		System.out.println("4 - Atualizar");
		System.out.println("5 - Excluir");
		System.out.println("0 - Sair");
		System.out.println("============\n");

	}

}