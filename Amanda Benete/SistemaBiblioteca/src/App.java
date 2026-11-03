import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class App {

    static Scanner scan = new Scanner(System.in);
    static List<Livro> listaLivros = new ArrayList<Livro>();
    static List<Leitor> listaLeitores = new ArrayList<Leitor>();

    public static void main(String[] args) {
        popularTabela();

        System.out.println("Sistema de biblioteca iniciado!");
        mostrarMenu();

        scan.close();
    }

    private static void popularTabela() {
        listaLeitores.add(new Leitor("Amanda"));
        listaLeitores.add(new Leitor("Gabriel"));
        listaLeitores.add(new Leitor("Pedro"));

        listaLivros.add(new Livro("Dom Casmurro",
                "Machado de Assis", "Romance"));
        listaLivros.add(new Livro("O Pequeno Príncipe",
                "Antoine de Saint-Exupéry", "Fantasia"));
        listaLivros.add(new Livro("Harry Potter",
                "J. K. Rowling", "Fantasia"));
        listaLivros.add(new Livro("O Hobbit",
                "J. R. R. Tolkien", "Aventura"));
        listaLivros.add(new Livro("A Culpa é das Estrelas",
                "John Green", "Romance"));
    }

    public static void mostrarMenu() {
        int escolhaUsuario;

        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Excluir livro");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Cadastrar leitor");
            System.out.println("7 - Listar leitores");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            escolhaUsuario = scan.nextInt();
            scan.nextLine();

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 0:
                System.out.println("Sistema encerrado!");
                break;

            case 1:
                listarLivros();
                break;

            case 2:
                cadastrarLivro();
                break;

            case 3:
                excluirLivro();
                break;

            case 4:
                emprestarLivro();
                break;

            case 5:
                devolverLivro();
                break;

            case 6:
                cadastrarLeitor();
                break;

            case 7:
                listarLeitores();
                break;

            default:
                System.out.println("Insira uma opção válida!");
        }
    }

    private static void listarLivros() {
        System.out.println("\n-------- LISTA DE LIVROS --------");

        if (listaLivros.isEmpty()) {
            System.out.println("Não existem livros cadastrados.");
            return;
        }

        for (int i = 0; i < listaLivros.size(); i++) {
            Livro livro = listaLivros.get(i);

            System.out.printf("%d) %s - %s - %s / %s\n",
                    i + 1,
                    livro.getNome(),
                    livro.getAutor(),
                    livro.getGenero(),
                    livro.validarDisponibilidade());
        }
    }

    private static void cadastrarLivro() {
        Livro livro = new Livro();

        System.out.print("Informe o título do livro: ");
        livro.setNome(scan.nextLine());

        System.out.print("Informe o autor: ");
        livro.setAutor(scan.nextLine());

        System.out.print("Informe o gênero: ");
        livro.setGenero(scan.nextLine());

        listaLivros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void excluirLivro() {
        if (listaLivros.isEmpty()) {
            System.out.println("Não existem livros para excluir!");
            return;
        }

        listarLivros();

        System.out.print("Informe o número do livro que deseja excluir: ");
        int escolha = scan.nextInt();
        scan.nextLine();

        if (escolha < 1 || escolha > listaLivros.size()) {
            System.out.println("Número inválido!");
            return;
        }

        Livro livro = listaLivros.get(escolha - 1);

        if (livro.getDataEmprestimo() != null) {
            System.out.println("O livro está emprestado e não pode ser excluído!");
            return;
        }

        listaLivros.remove(escolha - 1);
        System.out.println("Livro excluído com sucesso!");
    }

    private static void cadastrarLeitor() {
        Leitor leitor = new Leitor();

        System.out.print("Informe o nome do leitor: ");
        leitor.setNome(scan.nextLine());

        listaLeitores.add(leitor);

        System.out.println("Leitor cadastrado com sucesso!");
    }

    private static void listarLeitores() {
        System.out.println("\n-------- LISTA DE LEITORES --------");

        if (listaLeitores.isEmpty()) {
            System.out.println("Não existem leitores cadastrados.");
            return;
        }

        for (int i = 0; i < listaLeitores.size(); i++) {
            Leitor leitor = listaLeitores.get(i);

            System.out.printf("%d) %s\n",
                    i + 1, leitor.getNome());

            if (!leitor.getLivrosEmprestados().isEmpty()) {
                for (int j = 0;
                     j < leitor.getLivrosEmprestados().size(); j++) {

                    Livro livro = leitor.getLivrosEmprestados().get(j);

                    System.out.printf("   %d) %s - %s\n",
                            j + 1, livro.getNome(), livro.getAutor());
                }
            }
        }
    }

    private static void emprestarLivro() {
        if (listaLeitores.isEmpty()) {
            System.out.println("Cadastre um leitor primeiro!");
            return;
        }

        if (listaLivros.isEmpty()) {
            System.out.println("Não existem livros cadastrados!");
            return;
        }

        listarLeitores();

        System.out.print("Informe o número do leitor: ");
        int usuario = scan.nextInt();
        scan.nextLine();

        if (usuario < 1 || usuario > listaLeitores.size()) {
            System.out.println("Leitor inválido!");
            return;
        }

        Leitor leitor = listaLeitores.get(usuario - 1);

        if (leitor.getLivrosEmprestados().size() >= 2) {
            System.out.println("O leitor já possui dois livros emprestados!");
            return;
        }

        listarLivros();

        System.out.print("Informe o número do livro: ");
        int escolhaLivro = scan.nextInt();
        scan.nextLine();

        if (escolhaLivro < 1 || escolhaLivro > listaLivros.size()) {
            System.out.println("Livro inválido!");
            return;
        }

        Livro livro = listaLivros.get(escolhaLivro - 1);

        if (livro.getDataEmprestimo() != null) {
            System.out.println("Este livro já está emprestado!");
            return;
        }

        leitor.getLivrosEmprestados().add(livro);
        livro.setDataEmprestimo(new Date());

        System.out.println("Empréstimo realizado com sucesso!");
    }

    private static void devolverLivro() {
        if (listaLeitores.isEmpty()) {
            System.out.println("Não existem leitores cadastrados!");
            return;
        }

        listarLeitores();

        System.out.print("Informe o número do leitor: ");
        int usuario = scan.nextInt();
        scan.nextLine();

        if (usuario < 1 || usuario > listaLeitores.size()) {
            System.out.println("Leitor inválido!");
            return;
        }

        Leitor leitor = listaLeitores.get(usuario - 1);

        if (leitor.getLivrosEmprestados().isEmpty()) {
            System.out.println("Este leitor não possui livros emprestados!");
            return;
        }

        System.out.println("\nLivros emprestados por "
                + leitor.getNome() + ":");

        for (int i = 0; i < leitor.getLivrosEmprestados().size(); i++) {
            System.out.printf("%d) %s\n",
                    i + 1,
                    leitor.getLivrosEmprestados().get(i).getNome());
        }

        System.out.print("Informe o número do livro que será devolvido: ");
        int escolhaLivro = scan.nextInt();
        scan.nextLine();

        if (escolhaLivro < 1
                || escolhaLivro > leitor.getLivrosEmprestados().size()) {
            System.out.println("Livro inválido!");
            return;
        }

        Livro livro = leitor.getLivrosEmprestados().get(escolhaLivro - 1);

        livro.setDataEmprestimo(null);
        leitor.getLivrosEmprestados().remove(escolhaLivro - 1);

        System.out.println("Livro devolvido com sucesso!");
    }
}
