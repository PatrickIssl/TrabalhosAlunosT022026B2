package sistemajogo;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaJogo {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Jogo> jogos = new ArrayList<>();
    static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nMENU DE JOGOS");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

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
                    System.out.println("sistyema encerrado");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }

        } while (opcao != 0);

        entrada.close();
    }

    public static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Digite um numero valido: ");
            }
        }
    }

    public static void cadastrar() {
        System.out.print("Nome do jogo: ");
        String nome = entrada.nextLine();

        System.out.print("Genero do jogo: ");
        String genero = entrada.nextLine();

        Jogo jogo = new Jogo(proximoId, nome, genero);
        jogos.add(jogo);

        System.out.println("Jogo cadastrado com sucesso ID: " + proximoId);
        proximoId++;
    }

    public static void listar() {
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado");
            return;
        }

        for (Jogo jogo : jogos) {
            System.out.println("\nJogo");
            jogo.exibirDados();
        }
    }

    public static void buscar() {
        System.out.print("Digite o ID do jogo: ");
        int id = lerInteiro();

        Jogo jogo = encontrarJogo(id);

        if (jogo != null) {
            jogo.exibirDados();
        } else {
            System.out.println("Jogo nao encontrado");
        }
    }

    public static void atualizar() {
        System.out.print("Digite o ID do jogo: ");
        int id = lerInteiro();

        Jogo jogo = encontrarJogo(id);

        if (jogo != null) {
            System.out.print("Novo nome: ");
            jogo.setNome(entrada.nextLine());

            System.out.print("Novo genero: ");
            jogo.setGenero(entrada.nextLine());

            System.out.println("Jogo atualizado com sucesso");
        } else {
            System.out.println("Jogo nao encontrado");
        }
    }

    public static void excluir() {
        System.out.print("Digite o ID do jogo: ");
        int id = lerInteiro();

        Jogo jogo = encontrarJogo(id);

        if (jogo != null) {
            jogos.remove(jogo);
            System.out.println("Jogo excluido com sucesso");
        } else {
            System.out.println("Jogo nao encontrado");
        }
    }

    public static Jogo encontrarJogo(int id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }

        return null;
    }
}

