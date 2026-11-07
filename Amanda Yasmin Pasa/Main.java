import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Livro> livros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro();
            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: buscarPorId(); break;
                case 4: atualizar(); break;
                case 5: excluir(); break;
                case 0: System.out.println("Encerrando o programa..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    static void exibirMenu() {
        System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar todos");
        System.out.println("3 - Buscar por ID");
        System.out.println("4 - Atualizar");
        System.out.println("5 - Excluir");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    static int lerInteiro() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void cadastrar() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        System.out.print("Ano de publicação: ");
        int ano = lerInteiro();

        Livro livro = new Livro(proximoId, titulo, autor, ano);
        livros.add(livro);
        proximoId++;
        System.out.println("Livro cadastrado com o ID " + livro.getId());
    }

    static void listar() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (Livro l : livros) {
            exibir(l);
        }
    }

    static void exibir(Livro l) {
        System.out.println("ID: " + l.getId() + " | Título: " + l.getTitulo()
                + " | Autor: " + l.getAutor() + " | Ano: " + l.getAno());
    }

    static void buscarPorId() {
        System.out.print("Digite o ID: ");
        Livro l = encontrarPorId(lerInteiro());
        if (l == null) {
            System.out.println("ID não encontrado.");
        } else {
            exibir(l);
        }
    }

    static Livro encontrarPorId(int id) {
        for (Livro l : livros) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }

    static void atualizar() {
        System.out.print("Digite o ID do livro a atualizar: ");
        Livro l = encontrarPorId(lerInteiro());
        if (l == null) {
            System.out.println("ID não encontrado.");
            return;
        }
        System.out.print("Novo título: ");
        l.setTitulo(sc.nextLine());
        System.out.print("Novo autor: ");
        l.setAutor(sc.nextLine());
        System.out.print("Novo ano: ");
        l.setAno(lerInteiro());
        System.out.println("Livro atualizado com sucesso!");
    }

    static void excluir() {
        System.out.print("Digite o ID do livro a excluir: ");
        Livro l = encontrarPorId(lerInteiro());
        if (l == null) {
            System.out.println("ID não encontrado.");
            return;
        }
        livros.remove(l);
        System.out.println("Livro excluído com sucesso!");
    }
}
