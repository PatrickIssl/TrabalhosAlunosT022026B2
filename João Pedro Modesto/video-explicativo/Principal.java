import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
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
            opcao = lerNumero("Escolha uma opcao: ");

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
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        entrada.close();
    }

    static int lerNumero(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException erro) {
                System.out.println("Digite um numero inteiro valido.");
            }
        }
    }

    static String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = entrada.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Este campo nao pode ficar vazio.");
        }
    }

    static Jogo procurarPorId(int id) {
        for (Jogo jogo : jogos) {
            if (jogo.getId() == id) {
                return jogo;
            }
        }
        return null;
    }

    static void mostrarJogo(Jogo jogo) {
        System.out.println("ID: " + jogo.getId()
                + " | Nome: " + jogo.getNome()
                + " | Genero: " + jogo.getGenero());
    }

    static void cadastrar() {
        int id = lerNumero("ID: ");
        if (procurarPorId(id) != null) {
            System.out.println("Este ID ja esta cadastrado.");
            return;
        }

        String nome = lerTexto("Nome: ");
        String genero = lerTexto("Genero: ");
        Jogo jogo = new Jogo(id, nome, genero);
        jogos.add(jogo);
        System.out.println("Jogo cadastrado com sucesso.");
    }

    static void listar() {
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        System.out.println("Jogos cadastrados:");
        for (Jogo jogo : jogos) {
            mostrarJogo(jogo);
        }
    }

    static void buscar() {
        int id = lerNumero("ID do jogo: ");
        Jogo jogo = procurarPorId(id);
        if (jogo == null) {
            System.out.println("Jogo nao encontrado.");
        } else {
            mostrarJogo(jogo);
        }
    }

    static void atualizar() {
        int id = lerNumero("ID do jogo que deseja atualizar: ");
        Jogo jogo = procurarPorId(id);
        if (jogo == null) {
            System.out.println("Jogo nao encontrado.");
            return;
        }

        String nome = lerTexto("Novo nome: ");
        String genero = lerTexto("Novo genero: ");
        jogo.setNome(nome);
        jogo.setGenero(genero);
        System.out.println("Jogo atualizado com sucesso.");
    }

    static void excluir() {
        int id = lerNumero("ID do jogo que deseja excluir: ");
        Jogo jogo = procurarPorId(id);
        if (jogo == null) {
            System.out.println("Jogo nao encontrado.");
            return;
        }

        jogos.remove(jogo);
        System.out.println("Jogo excluido com sucesso.");
    }
}