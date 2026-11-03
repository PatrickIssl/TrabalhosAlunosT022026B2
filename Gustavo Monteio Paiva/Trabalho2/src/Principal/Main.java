package Principal;
import livro.Livro;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Livro> livros = new ArrayList<>();
    static List<Usuario> usuarios = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Listar usuários");
            System.out.println("5 - Emprestar livro");
            System.out.println("6 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = lerNumero();

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> listarLivros();
                case 3 -> cadastrarUsuario();
                case 4 -> listarUsuarios();
                case 5 -> emprestar();
                case 6 -> devolver();
                case 0 -> System.out.println("Até logo!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    static void cadastrarLivro() {
        System.out.print("Título: ");
        String titulo = in.nextLine();
        System.out.print("Autor: ");
        String autor = in.nextLine();
        livros.add(new Livro(livros.size() + 1, titulo, autor));
        System.out.println("Livro cadastrado!");
    }

    static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = in.nextLine();
        System.out.print("E-mail: ");
        String email = in.nextLine();
        usuarios.add(new Usuario(usuarios.size() + 1, nome, email));
        System.out.println("Usuário cadastrado!");
    }

    static void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (Livro l : livros) {
            String status;
            if (l.estaDisponivel()) {
                status = "disponível";
            } else {
                status = "emprestado para " + l.getEmprestadoPara().getNome();
            }
            System.out.println(l.getId() + " - " + l.getTitulo() + " (" + l.getAutor() + ") [" + status + "]");
        }
    }

    static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNome() + " <" + u.getEmail() + ">");
        }
    }

    static void emprestar() {
        Livro livro = buscarLivro();
        if (livro == null) return;
        if (!livro.estaDisponivel()) {
            System.out.println("Esse livro já está emprestado.");
            return;
        }
        Usuario usuario = buscarUsuario();
        if (usuario == null) return;
        livro.emprestar(usuario);
        System.out.println("Empréstimo realizado!");
    }

    static void devolver() {
        Livro livro = buscarLivro();
        if (livro == null) return;
        if (livro.estaDisponivel()) {
            System.out.println("Esse livro não está emprestado.");
            return;
        }
        livro.devolver();
        System.out.println("Livro devolvido!");
    }

    static Livro buscarLivro() {
        System.out.print("ID do livro: ");
        int id = lerNumero();
        for (Livro l : livros) {
            if (l.getId() == id) return l;
        }
        System.out.println("Livro não encontrado.");
        return null;
    }

    static Usuario buscarUsuario() {
        System.out.print("ID do usuário: ");
        int id = lerNumero();
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        System.out.println("Usuário não encontrado.");
        return null;
    }

    static int lerNumero() {
        try {
            return Integer.parseInt(in.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
