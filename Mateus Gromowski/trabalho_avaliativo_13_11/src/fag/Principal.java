package fag;

import fag.objetos.Jogo;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Jogo> jogos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarJogo();
                    break;
                case 2:
                    listarJogos();
                    break;
                case 3:
                    buscarPorId();
                    break;
                case 4:
                    atualizarJogo();
                    break;
                case 5:
                    excluirJogo();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
        System.out.println("1- Cadastrar");
        System.out.println("2- Listar todos");
        System.out.println("3- Buscar por ID");
        System.out.println("4 - Atualizar");
        System.out.println("5 - Excluir");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarJogo() {
        System.out.println("\n--- CADASTRO DE JOGO ---");
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (buscarJogoPorId(id) != null) {
            System.out.println("Erro: Já existe um jogo com esse ID.");
            return;
        }

        System.out.print("Digite o nome do jogo: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o gênero do jogo: ");
        String genero = scanner.nextLine();

        System.out.print("Digite o preço: R$ ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        Jogo novoJogo = new Jogo(id, nome, genero, preco);
        jogos.add(novoJogo);
        System.out.println("Jogo cadastrado com sucesso!");
    }

    private static void listarJogos() {
        System.out.println("\n--- LISTA DE JOGOS ---");
        if (jogos.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
            return;
        }

        for (Jogo j : jogos) {
            System.out.printf("ID: %d | Nome: %s | Gênero: %s | Preço: R$ %.2f\n", j.getId(), j.getNome(),
                    j.getGenero(),
                    j.getPreco());
        }
    }

    private static void buscarPorId() {
        System.out.println("\n--- BUSCAR POR ID ---");
        if (jogos.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
            return;
        }

        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Jogo jogo = buscarJogoPorId(id);

        if (jogo != null) {
            System.out.println("Registro encontrado:");
            System.out.printf("ID: %d | Nome: %s | Gênero: %s | Preço: R$ %.2f\n", jogo.getId(), jogo.getNome(),
                    jogo.getGenero(),
                    jogo.getPreco());
        } else {
            System.out.println("Erro: ID " + id + " não encontrado.");
        }
    }

    private static void atualizarJogo() {
        System.out.println("\n--- ATUALIZAR JOGO ---");
        if (jogos.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
            return;
        }

        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Jogo jogo = buscarJogoPorId(id);

        if (jogo == null) {
            System.out.println("Erro: ID " + id + " não encontrado.");
            return;
        }

        System.out.printf("Registro atual: ID: %d | Nome: %s | Gênero: %s | Preço: R$ %.2f\n", jogo.getId(),
                jogo.getNome(),
                jogo.getGenero(),
                jogo.getPreco());

        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        jogo.setNome(novoNome);

        System.out.print("Novo gênero: ");
        String novoGenero = scanner.nextLine();
        jogo.setGenero(novoGenero);

        System.out.print("Novo preço: R$ ");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine();
        jogo.setPreco(novoPreco);

        System.out.println("Jogo atualizado com sucesso!");
    }

    private static void excluirJogo() {
        System.out.println("\n--- EXCLUIR JOGO ---");
        if (jogos.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
            return;
        }

        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Jogo jogo = buscarJogoPorId(id);

        if (jogo != null) {
            jogos.remove(jogo);
            System.out.println("Jogo com ID " + id + " excluído com sucesso!");
        } else {
            System.out.println("Erro: ID " + id + " não encontrado.");
        }
    }

    private static Jogo buscarJogoPorId(int id) {
        for (Jogo j : jogos) {
            if (j.getId() == id) {
                return j;
            }
        }
        return null;
    }
}