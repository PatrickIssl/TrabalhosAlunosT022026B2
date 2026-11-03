
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Jogo> jogos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n========== SISTEMA DE JOGOS ==========");
            System.out.println("1 - Cadastrar jogo");
            System.out.println("2 - Listar jogos");
            System.out.println("3 - Buscar jogo por ID");
            System.out.println("4 - Atualizar jogo");
            System.out.println("5 - Excluir jogo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

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
                    System.out.println("Sistema encerrado!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    // CADASTRAR JOGO
    public static void cadastrar() {

        System.out.println("\n--- CADASTRAR JOGO ---");

        System.out.print("Digite o ID do jogo: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                System.out.println("ID já cadastrado!");
                return;
            }
        }

        System.out.print("Digite o nome do jogo: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o gênero do jogo: ");
        String genero = entrada.nextLine();

        System.out.print("Digite o preço do jogo: ");
        double preco = entrada.nextDouble();
        entrada.nextLine();

        Jogo novoJogo = new Jogo(id, nome, genero, preco);

        jogos.add(novoJogo);

        System.out.println("Jogo cadastrado com sucesso!");
    }

    // LISTAR JOGOS
    public static void listar() {

        System.out.println("\n--- LISTA DE JOGOS ---");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado!");
            return;
        }

        for (Jogo jogo : jogos) {

            System.out.println("-------------------------");
            System.out.println("ID: " + jogo.getId());
            System.out.println("Nome: " + jogo.getNome());
            System.out.println("Gênero: " + jogo.getGenero());
            System.out.println("Preço: R$ " + jogo.getPreco());

        }
    }

    // BUSCAR JOGO POR ID
    public static void buscar() {

        System.out.println("\n--- BUSCAR JOGO ---");

        System.out.print("Digite o ID do jogo: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Jogo jogo : jogos) {

            if (jogo.getId() == id) {

                System.out.println("Jogo encontrado!");
                System.out.println("Nome: " + jogo.getNome());
                System.out.println("Gênero: " + jogo.getGenero());
                System.out.println("Preço: R$ " + jogo.getPreco());

                return;
            }
        }

        System.out.println("Jogo não encontrado!");
    }

    // ATUALIZAR JOGO
    public static void atualizar() {

        System.out.println("\n--- ATUALIZAR JOGO ---");

        System.out.print("Digite o ID do jogo: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Jogo jogo : jogos) {

            if (jogo.getId() == id) {

                System.out.print("Digite o novo nome: ");
                String nome = entrada.nextLine();

                System.out.print("Digite o novo gênero: ");
                String genero = entrada.nextLine();

                System.out.print("Digite o novo preço: ");
                double preco = entrada.nextDouble();
                entrada.nextLine();

                jogo.setNome(nome);
                jogo.setGenero(genero);
                jogo.setPreco(preco);

                System.out.println("Jogo atualizado com sucesso!");

                return;
            }
        }

        System.out.println("Jogo não encontrado!");
    }

    // EXCLUIR JOGO
    public static void excluir() {

        System.out.println("\n--- EXCLUIR JOGO ---");

        System.out.print("Digite o ID do jogo: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        for (Jogo jogo : jogos) {

            if (jogo.getId() == id) {

                jogos.remove(jogo);

                System.out.println("Jogo excluído com sucesso!");

                return;
            }
        }

        System.out.println("Jogo não encontrado!");
    }
}
