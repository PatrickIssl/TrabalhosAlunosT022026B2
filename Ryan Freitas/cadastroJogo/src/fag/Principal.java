package fag;

import objetos.Jogo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	static Scanner scan = new Scanner(System.in);
	
	static List<Jogo> listaJogos = new ArrayList<Jogo>();
	
	public static void main(String[] args) {
		tabelaInputs();

        System.out.println("Sistema de Gerenciamento Iniciado!");

        mostrarMenu();
	}

	private static void mostrarMenu() {
		int escolhaUsuario;

        do {
            System.out.println("\n------ SISTEMA DE GERENCIAMENTO ------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            escolhaUsuario = scan.nextInt();
            scan.nextLine();

            validarEscolha(escolhaUsuario);
        } while (escolhaUsuario != 0);
	}

	private static void validarEscolha(int escolhaUsuario) {
		switch(escolhaUsuario) {
		case 0: 
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
            break;
		case 1:
			cadastrarJogo();
			break;
		case 2:
			listarJogos();
			break;
		case 3:
			pesquisarId();
			break;
		case 4:
			atualizarJogo();
			break;
		case 5: 
			excluirJogo();
			break;
		default:
			System.out.println("Insira um valor válido.");
			break;
		}
	}

	private static void pesquisarId() {
		System.out.print("Informe o ID do jogo que deseja buscar: ");
        int id = scan.nextInt();
        scan.nextLine();

        Jogo jogo = buscarPorId(id);

        if (jogo != null) {
            System.out.println("\nJogo encontrado!");
            System.out.println("ID: " + jogo.getId());
            System.out.println("Nome: " + jogo.getNome());
            System.out.printf("Genero: %s\n", jogo.getGenero());

        } else {
            System.out.println("Jogo não encontrado!");
        }
	}

	private static void excluirJogo() {
		System.out.print("Informe o ID do jogo que deseja excluir: ");
        int id = scan.nextInt();
        scan.nextLine();

        Jogo jogo = buscarPorId(id);

        if (jogo != null) {
            listaJogos.remove(jogo);
            System.out.println("Jogo excluído com sucesso!");
        } else {
            System.out.println("Jogo não encontrado!");
        }
	}

	private static void atualizarJogo() {
		System.out.print("Informe o ID do jogo que deseja atualizar: ");
        int id = scan.nextInt();
        scan.nextLine();

        Jogo jogo = buscarPorId(id);

        if (jogo != null) {
            System.out.print("Informe o novo nome: ");
            jogo.setNome(scan.nextLine());

            System.out.print("Informe o novo genero: ");
            String genero = scan.nextLine();
            jogo.setGenero(genero);

            System.out.println("Jogo atualizado com sucesso!");
        } else {
            System.out.println("Jogo não encontrado!");
        }
	}

	private static Jogo buscarPorId(int id) {
        for (int i = 0; i < listaJogos.size(); i++) {
            Jogo jogo = listaJogos.get(i);
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null;
    }

	private static void listarJogos() {
		System.out.println("\n-------- LISTA DE JOGOS --------");
        if (listaJogos.isEmpty()) {
            System.out.println("Não existem jogos cadastrados!");
            return;
        }
        for (int i = 0; i < listaJogos.size(); i++) {
            Jogo jogo = listaJogos.get(i);
            System.out.printf("%d - %s - %s\n", jogo.getId(), jogo.getNome(), jogo.getGenero());
        }
        System.out.println();
	}

	private static void cadastrarJogo() {
		System.out.print("Informe o ID do jogo(Apenas numeros): ");
        int id = scan.nextInt();
        scan.nextLine();

        if (buscarPorId(id) != null) {
            System.out.println("Este ID já está cadastrado!");
            return;
        }
        
        if (id < 0) {
            System.out.println("Erro: o id não pode ser negativo!");
            return;
        }

        System.out.print("Informe o nome do jogo: ");
        String nome = scan.nextLine();

        System.out.print("Informe o genero do jogo: ");
        String genero = scan.nextLine();

        Jogo jogo = new Jogo(id, nome, genero);

        listaJogos.add(jogo);

        System.out.println("Jogo cadastrado com sucesso!");
	}

	private static void tabelaInputs() {
		listaJogos.add(new Jogo(1, "GTA 5", "Ação"));
		listaJogos.add(new Jogo(2, "Minecraft", "Sandbox"));
		listaJogos.add(new Jogo(3, "Street Fighter", "Luta"));
		listaJogos.add(new Jogo(4, "Fifa 26", "Esporte"));
		listaJogos.add(new Jogo(5, "Fortnite", "Battle Royale"));
	}
}