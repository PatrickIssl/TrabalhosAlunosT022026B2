
package projetoJogo;

import java.util.ArrayList;
import java.util.Scanner;

import projetoJogo.objeto.Jogo;

public class Principal {

    static ArrayList<Jogo> jogos = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int id = 1;

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {

        int op;

        do {

            System.out.println("\n==================================");
            System.out.println("         CATALOGO DE JOGOS");
            System.out.println("==================================");
            System.out.println("  1 - Cadastrar jogo");
            System.out.println("  2 - Listar jogos");
            System.out.println("  3 - Buscar por ID");
            System.out.println("  4 - Atualizar jogo");
            System.out.println("  5 - Deletar jogo");
            System.out.println("  6 - Filtrar por genero");
            System.out.println("  0 - Sair");
            System.out.println("==================================");
            System.out.print(" Escolha uma opcao: ");

            op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1:
                    cadastrarJogo();
                    break;
                case 2:
                    listarJogos();
                    break;
                case 3:
                    buscarId();
                    break;
                case 4:
                    atualizarJogo();
                    break;
                case 5:
                    deletar();
                    break;
                case 6:
                    filtrarGenero();
                    break;
                case 0:
                    System.out.println("\n==================================");
                    System.out.println("     Sistema encerrado!");
                    System.out.println("==================================");
                    break;
                default:
                    System.out.println("\nOpcao invalida! Tente novamente.");
                    break;
            }

        } while (op != 0);

    }

    public static void cadastrarJogo() {

        System.out.println("\n========== CADASTRAR JOGO ==========");

        System.out.print("Digite o nome do jogo: ");
        String nome = scan.nextLine();

        System.out.print("Digite o genero do jogo: ");
        String genero = scan.nextLine();

        Jogo jogo = new Jogo(id, nome, genero);
        jogos.add(jogo);

        System.out.println("\n------------------------------------");
        System.out.println("       JOGO CADASTRADO!");
        System.out.println("------------------------------------");
        System.out.println(" ID: " + id);
        System.out.println(" Nome: " + nome);
        System.out.println(" Genero: " + genero);
        System.out.println("------------------------------------");

        id++;
    }

    public static void listarJogos() {

        System.out.println("\n========== LISTA DE JOGOS ==========");

        if (jogos.isEmpty()) {
            System.out.println("\nNenhum jogo cadastrado.");
        }

        for (Jogo jogo : jogos) {
            System.out.println("\n------------------------------------");
            System.out.println(" ID: " + jogo.getId());
            System.out.println(" Nome: " + jogo.getNome());
            System.out.println(" Genero: " + jogo.getGenero());
        }

        System.out.println("\n====================================");
    }

    public static void buscarId() {

        System.out.println("\n========== BUSCAR JOGO ==========");

        System.out.print("Digite o ID do jogo: ");
        int idBusca = scan.nextInt();
        scan.nextLine();

        boolean encontrado = false;

        for (Jogo jogo : jogos) {
            if (jogo.getId() == idBusca) {

                System.out.println("\n------------------------------------");
                System.out.println("          JOGO ENCONTRADO!");
                System.out.println("------------------------------------");
                System.out.println(" ID: " + jogo.getId());
                System.out.println(" Nome: " + jogo.getNome());
                System.out.println(" Genero: " + jogo.getGenero());
                System.out.println("------------------------------------");

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nJogo nao encontrado!");
        }

    }

    public static void atualizarJogo() {

        System.out.println("\n========== ATUALIZAR JOGO ==========");

        System.out.print("Digite o ID do jogo: ");
        int idBusca = scan.nextInt();
        scan.nextLine();

        boolean encontrado = false;

        for (Jogo jogo : jogos) {
            if (jogo.getId() == idBusca) {

                System.out.print("Digite o novo nome: ");
                jogo.setNome(scan.nextLine());

                System.out.print("Digite o novo genero: ");
                jogo.setGenero(scan.nextLine());

                System.out.println("\nJogo atualizado com sucesso!");
                System.out.println("------------------------------------");

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nJogo nao encontrado!");
        }

    }

    public static void deletar() {

        System.out.println("\n========== DELETAR JOGO ==========");

        System.out.print("Digite o ID do jogo: ");
        int idBusca = scan.nextInt();
        scan.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < jogos.size(); i++) {
            Jogo jogo = jogos.get(i);

            if (jogo.getId() == idBusca) {

                jogos.remove(i);

                System.out.println("\nJogo deletado com sucesso!");
                System.out.println("------------------------------------");

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nJogo nao encontrado!");
        }

    }

    public static void filtrarGenero() {

        System.out.println("\n========== FILTRAR POR GENERO ==========");

        System.out.print("Digite o genero desejado: ");
        String generoBusca = scan.nextLine();

        boolean encontrado = false;

        for (Jogo jogo : jogos) {
            if (jogo.getGenero().equalsIgnoreCase(generoBusca)) {

                System.out.println("\n------------------------------------");
                System.out.println(" ID: " + jogo.getId());
                System.out.println(" Nome: " + jogo.getNome());
                System.out.println(" Genero: " + jogo.getGenero());

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nNenhum jogo encontrado com esse genero!");
        }

        System.out.println("------------------------------------");
    }

}
