package principal;

import java.util.ArrayList;
import java.util.Scanner;
import objetos.Livro;
import objetos.Pessoa;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Pessoa> listaUsuarios = new ArrayList<>();
    static ArrayList<Livro> listaLivros = new ArrayList<>();

    public static void popularTabela() {
        listaLivros.add(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", null));
        listaLivros.add(new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", null));
        listaLivros.add(new Livro("1984", "George Orwell", null));
        listaLivros.add(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", null));
        listaLivros.add(new Livro("A Menina que Roubava Livros", "Markus Zusak", null));

        listaUsuarios.add(new Pessoa("João"));
        listaUsuarios.add(new Pessoa("Maria"));
        listaUsuarios.add(new Pessoa("Pedro"));
        listaUsuarios.add(new Pessoa("Gabrieli"));
    }

    public static void mostrarMenu() {
        int escolha = 0;
        do {
        System.out.println("----- Selecione uma opção -----");
        System.out.println("1 - Listar livros");
        System.out.println("2 - Adicionar livro");
        System.out.println("3 - Locar livro");
        System.out.println("4 - Excluir livro");
        System.out.println("5 - Devolver livro");
        System.out.println("6 - Registrar usuário");
        System.out.println("7 - Listar usuários");
        System.out.println("8 - Sair");
        escolha = scanner.nextInt();
        validarEscolha(escolha);
        } while(escolha != 8);
    }

    public static void validarEscolha(int escolha) {
        if (escolha < 1 || escolha > 8) {
            System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            return;
        }
        if (escolha == 1) {
            listarLivros();
        } else if (escolha == 2) {
            adicionarLivro();
        } else if (escolha == 3) {
            locarLivro();
        } else if (escolha == 4) {
            excluirLivro();
        } else if (escolha == 5) {
            devolverLivro();
        } else if (escolha == 6) {
            registrarUsuario();
        } else if (escolha == 7) {
            listarUsuarios();
        } else if (escolha == 8) {
            System.out.println("Saindo do programa...");
        }
    }

    public static void listarLivros() {
        System.out.println("----- Lista de Livros -----");
        for (int i = 0; i < listaLivros.size(); i++) {
            System.out.printf("%d) %s - %s / %s\n",
                i + 1,
                listaLivros.get(i).getTitulo(),
                listaLivros.get(i).getAutor(),
                listaLivros.get(i).validarDisponibilidade());
        }
        System.out.printf("\n");
    }

    public static void adicionarLivro() {
        Livro livro = new Livro();
        System.out.println("----- Adicionar Livro -----");

        System.out.print("Digite o título do livro: ");
        livro.setTitulo(scanner.nextLine());

        System.out.print("Digite o autor do livro: ");
        livro.setAutor(scanner.nextLine());

        listaLivros.add(livro);
        System.out.println("Livro adicionado com sucesso!");

        System.out.printf("\n");
    }

    public static void locarLivro() {
        listarUsuarios();
        System.out.println("Informe o número do usuário que deseja locar o livro:");
        int usuario = scanner.nextInt() - 1;
        scanner.nextLine();

        if (usuario > listaUsuarios.size() || usuario < 0) {
            System.out.println("Opção inválida.");
            return;
        }

        if (ListaUsuarios.get(usuario).getLivrosLocados().size() >= 3) {
            System.out.println("Este usuário já possui 3 livros locados. Não é possível locar mais livros.");
            return;
        }

        listarLivros();
        System.out.println("Informe o número do livro que deseja locar:");
        int livro = scanner.nextInt() - 1;
        scanner.nextLine();

        if (livro > listaLivros.size() || livro < 0) {
            System.out.println("Opção inválida.");
            return;
        }

        if (listaLivros.get(livro).validarDisponibilidade().equals("\u001B[31mIndisponivel\u001B[0m")) {
            System.out.println("Este livro já está locado. Não é possível locar.");
            return;
        }
        
        listaUsuarios.get(usuario).getLivrosLocados().add(listaLivros.get(livro));
        listaLivros.get(livro).setDataLocacao(new java.util.Date());
        System.out.println("Livro locado com sucesso!");
    }

    public static void excluirLivro() {
        if (listaLivros.size() == 0) {
            System.out.println("Não há livros cadastrados.");
            return;
        }

        listarLivros();
        System.out.print("Digite o número do livro que deseja excluir: ");
        int escolha = scanner.nextInt() - 1;

        if (escolha < 0 || escolha >= listaLivros.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        if (listaLivros.get(escolha).validarDisponibilidade().equals("\u001B[31mIndisponivel\u001B[0m")) {
            System.out.println("Não é possível excluir um livro que está locado.");
            return;
        }

        listaLivros.remove(escolha);
        System.out.println("Livro excluído com sucesso!");

        System.out.printf("\n");
    }

    public static void devolverLivro() {
        listarUsuarios();
        System.out.print("Informe o número do usuário que deseja devolver o livro: ");
        int usuario = scanner.nextInt() - 1;

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        if (listaUsuarios.get(usuario).getLivrosLocados() == null) {
            System.out.println("Este usuário não possui nenhum livro locado.");
            return;
        }

        System.out.println("Informe o número do livro que deseja devolver: ");
        int livro = scanner.nextInt() - 1;

        listaUsuarios.get(usuario).getLivrosLocados().remove(livro);
        System.out.println("Livro devolvido com sucesso!");

        System.out.printf("\n");
    }

    public static void registrarUsuario() {
        Pessoa usuario = new Pessoa();

        System.out.println("----- Registrar Usuário -----");
        System.out.println("Digite o nome do usuário: ");
        usuario.setNome(scanner.nextLine());

        listaUsuarios.add(usuario);
        System.out.println("Usuário registrado com sucesso!");

        System.out.printf("\n");
    }

    public static void listarUsuarios() {
        System.out.println("----- Lista de usuários -----");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, listaUsuarios.get(i).getNome());
            for (int j = 0; j < listaUsuarios.get(i).getLivrosLocados().size(); j++) {
                System.out.printf("   %d) %s - %s / %s\n", j + 1, listaUsuarios.get(i).getLivrosLocados().get(j).getTitulo(), listaUsuarios.get(i).getLivrosLocados().get(j).getAutor(), listaUsuarios.get(i).getLivrosLocados().get(j).validarDisponibilidade());
            }
        }

        System.out.printf("\n");
    }

    public static void main(String[] args) {
        popularTabela();
        mostrarMenu();
    }
}