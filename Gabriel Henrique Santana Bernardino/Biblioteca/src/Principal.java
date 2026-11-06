
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static ArrayList<Livro> livros = new ArrayList<>();
    static Scanner entrada = new Scanner(System.in);

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

            opcao = lerInteiro("Escolha uma opção: ");

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
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        entrada.close();
    }

    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);

        while (!entrada.hasNextInt()) {
            System.out.println("Digite um número inteiro válido.");
            entrada.nextLine();
            System.out.print(mensagem);
        }

        int numero = entrada.nextInt();
        entrada.nextLine();
        return numero;
    }

    public static Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public static void cadastrar() {
        int id = lerInteiro("ID do livro: ");

        if (buscarLivroPorId(id) != null) {
            System.out.println("Já existe um livro com esse ID!");
            return;
        }

        System.out.print("Título: ");
        String titulo = entrada.nextLine();

        System.out.print("Autor: ");
        String autor = entrada.nextLine();

        Livro livro = new Livro(id, titulo, autor);
        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    public static void listar() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println("ID: " + livro.getId()
                    + " | Título: " + livro.getTitulo()
                    + " | Autor: " + livro.getAutor());
        }
    }

    public static void buscar() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        int id = lerInteiro("ID para buscar: ");
        Livro livro = buscarLivroPorId(id);

        if (livro == null) {
            System.out.println("ID não encontrado.");
        } else {
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
        }
    }

    public static void atualizar() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        int id = lerInteiro("ID para atualizar: ");
        Livro livro = buscarLivroPorId(id);

        if (livro == null) {
            System.out.println("ID não encontrado.");
            return;
        }

        System.out.print("Novo título: ");
        livro.setTitulo(entrada.nextLine());

        System.out.print("Novo autor: ");
        livro.setAutor(entrada.nextLine());

        System.out.println("Livro atualizado com sucesso!");
    }

    public static void excluir() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        int id = lerInteiro("ID para excluir: ");
        Livro livro = buscarLivroPorId(id);

        if (livro == null) {
            System.out.println("ID não encontrado.");
        } else {
            livros.remove(livro);
            System.out.println("Livro excluído com sucesso!");
        }
    }
}
