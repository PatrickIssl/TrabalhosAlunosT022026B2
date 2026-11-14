package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import objetos.Livro;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Livro> listaLivros = new ArrayList<Livro>();
    static int proximoId = 1;

    public static void mostrarMenu() {
        int escolha = 0;
        do {
            System.out.println("====== SISTEMA DE GERENCIAMENTO ======");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            escolha = scanner.nextInt();
            scanner.nextLine();
            validarEscolha(escolha);
        } while (escolha != 0);
    }

    public static void validarEscolha(int escolha) {
        switch (escolha) {
            case 1:
                cadastrarLivro();
                break;
            case 2:
                listarLivros();
                break;
            case 3:
                buscarLivroPorId();
                break;
            case 4:
                atualizarLivro();
                break;
            case 5:
                excluirLivro();
                break;
            case 0:
                System.out.println("Sistema finalizado");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public static void cadastrarLivro() {
        Livro livro = new Livro();
        System.out.println("====== Cadastrar livro ======");

        System.out.println("Informe o título do livro");
        livro.setTitulo(scanner.nextLine());

        System.out.println("Informe o autor do livro");
        livro.setAutor(scanner.nextLine());

        livro.setId(proximoId);
        proximoId++;
        listaLivros.add(livro);
        System.out.println("Livro cadastrado com ID " + livro.getId());
    }

    public static void listarLivros() {
        System.out.println("====== Lista de livros ======");

        for (Livro livro : listaLivros) {
            System.out.printf("%d) %s - %s%n", livro.getId(), livro.getTitulo(), livro.getAutor());
        }
        System.out.println("");
    }

    public static Livro buscarPorId(int id) {
        for (Livro livro : listaLivros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public static void buscarLivroPorId() {
        System.out.println("====== Buscar por ID ======");
        System.out.println("Informe o ID do livro");
        int id = scanner.nextInt();
        scanner.nextLine();

        Livro livro = buscarPorId(id);

        if (livro == null) {
            System.out.println("Nenhum livro com esse ID");
            return;
        }
        System.out.printf("%d) %s - %s%n", livro.getId(), livro.getTitulo(), livro.getAutor());
    }

    public static void atualizarLivro() {
        if (listaLivros.isEmpty()) {
            System.out.println("Não há livros cadastrados");
            return;
        }

        System.out.println("====== Atualizar informações ======");
        listarLivros();

        System.out.println("Informe o ID do livro para atualizar");
        int id = scanner.nextInt();
        scanner.nextLine();

        Livro livro = buscarPorId(id);

        if (livro == null) {
            System.out.println("Nenhum livro com esse ID");
            return;
        }

        System.out.println("Novo título (atual: " + livro.getTitulo() + ")");
        livro.setTitulo(scanner.nextLine());

        System.out.println("Novo autor (atual: " + livro.getAutor() + ")");
        livro.setAutor(scanner.nextLine());

        System.out.println("Livro atualizado");
    }

    public static void excluirLivro() {
        if (listaLivros.isEmpty()) {
            System.out.println("Não há livros cadastrados");
            return;
        }

        System.out.println("====== Excluir livro ======");
        listarLivros();

        System.out.println("Informe o ID do livro que deseja excluir");
        int id = scanner.nextInt();
        scanner.nextLine();

        Livro livro = buscarPorId(id);

        if (livro == null) {
            System.out.println("Nenhum livro com esse ID");
            return;
        }

        listaLivros.remove(livro);
        System.out.println("Livro removido");
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}