package Jogos;


import java.util.ArrayList;
import java.util.Scanner;

public class SistemaJogos {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Jogo> jogos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

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
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }

    // local das partes do codigo
    // cadastrar jogo
    public static void cadastrar() {

        System.out.println("\n=== CADASTRAR JOGO ===");

        System.out.print("Digite o ID: ");
        int id = lerInteiro();

        if (buscarJogo(id) != null) {
            System.out.println("Esse ID já está cadastrado!");
            return;
        }

        System.out.print("Digite o nome do jogo: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o gênero: ");
        String genero = entrada.nextLine();

        Jogo novoJogo = new Jogo(id, nome, genero);

        jogos.add(novoJogo);

        System.out.println("Jogo cadastrado com sucesso!");
    }

    // listar todos os jogos
    public static void listar() {

        System.out.println("\n=== LISTA DE JOGOS ===");

        if (jogos.isEmpty()) {
            System.out.println("Não existem jogos cadastrados!");
            return;
        }

        for (Jogo jogo : jogos) {
            System.out.println("----------------------");
            jogo.exibirJogo();
        }
    }

    // buscar jogo por ID
    public static void buscar() {

        System.out.println("\n=== BUSCAR JOGO ===");

        System.out.print("Digite o ID do jogo: ");
        int id = lerInteiro();

        Jogo jogo = buscarJogo(id);

        if (jogo != null) {
            jogo.exibirJogo();
        } else {
            System.out.println("Jogo não encontrado!");
        }
    }

    // atualizar jogo
    public static void atualizar() {

        System.out.println("\n=== ATUALIZAR JOGO ===");

        System.out.print("Digite o ID do jogo: ");
        int id = lerInteiro();

        Jogo jogo = buscarJogo(id);

        if (jogo != null) {

            System.out.print("Digite o novo nome: ");
            String nome = entrada.nextLine();

            System.out.print("Digite o novo gênero: ");
            String genero = entrada.nextLine();

            jogo.setNome(nome);
            jogo.setGenero(genero);

            System.out.println("Jogo atualizado com sucesso!");

        } else {
            System.out.println("Jogo não encontrado!");
        }
    }

    // excluir jogo
    public static void excluir() {

        System.out.println("\n=== EXCLUIR JOGO ===");

        System.out.print("Digite o ID do jogo: ");
        int id = lerInteiro();

        Jogo jogo = buscarJogo(id);

        if (jogo != null) {
            jogos.remove(jogo);
            System.out.println("Jogo excluído com sucesso!");
        } else {
            System.out.println("Jogo não encontrado!");
        }
    }

    // localizar jogo pelo ID
    public static Jogo buscarJogo(int id) {

        for (Jogo jogo : jogos) {

            if (jogo.getId() == id) {
                return jogo;
            }
        }

        return null;
    }

    // ler números inteiros
    public static int lerInteiro() {

        while (true) {
            try {
                return Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }
}
