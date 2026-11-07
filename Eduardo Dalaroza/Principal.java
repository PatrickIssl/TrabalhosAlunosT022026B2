import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static ArrayList<Livro> listaLivros = new ArrayList<Livro>();
    static int proximoId = 1;

    public static void main(String[] args) {
        int opcao = 0;

        do {
            System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========\n");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscarPorId();
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

    // procura um livro pelo id; se não achar, devolve null
    public static Livro procurarLivro(int id) {
        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).getId() == id) {
                return listaLivros.get(i);
            }
        }
        return null;
    }

    public static void cadastrar() {
        System.out.print("Informe o título: ");
        String titulo = scan.nextLine();

        System.out.print("Informe o autor: ");
        String autor = scan.nextLine();

        Livro livro = new Livro(proximoId, titulo, autor);
        listaLivros.add(livro);
        proximoId++;

        System.out.println("Livro cadastrado com sucesso! ID: " + livro.getId());
    }

    public static void listar() {
        if (listaLivros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        System.out.println("\n--------- Lista de Livros ---------");
        for (int i = 0; i < listaLivros.size(); i++) {
            Livro livro = listaLivros.get(i);
            System.out.println("ID: " + livro.getId() + " | Título: " + livro.getTitulo() + " | Autor: " + livro.getAutor());
        }
    }

    public static void buscarPorId() {
        if (listaLivros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        System.out.print("Informe o ID do livro: ");
        int id = scan.nextInt();
        scan.nextLine();

        Livro livro = procurarLivro(id);

        if (livro == null) {
            System.out.println("ID não encontrado!");
        } else {
            System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
        }
    }

    public static void atualizar() {
        if (listaLivros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        System.out.print("Informe o ID do livro que deseja atualizar: ");
        int id = scan.nextInt();
        scan.nextLine();

        Livro livro = procurarLivro(id);

        if (livro == null) {
            System.out.println("ID não encontrado!");
            return;
        }

        System.out.print("Novo título: ");
        livro.setTitulo(scan.nextLine());

        System.out.print("Novo autor: ");
        livro.setAutor(scan.nextLine());

        System.out.println("Livro atualizado com sucesso!");
    }

    public static void excluir() {
        if (listaLivros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        System.out.print("Informe o ID do livro que deseja excluir: ");
        int id = scan.nextInt();
        scan.nextLine();

        Livro livro = procurarLivro(id);

        if (livro == null) {
            System.out.println("ID não encontrado!");
            return;
        }

        listaLivros.remove(livro);
        System.out.println("Livro excluído com sucesso!");
    }

}
