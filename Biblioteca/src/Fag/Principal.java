
package Fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Fag.Objeto.Livro;
import Fag.Objeto.Pessoa;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static List<Livro> listaLivros = new ArrayList<Livro>();
    static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();

    public static void main(String[] args) {
        popularTabela();

        System.out.println("Sistema da Biblioteca iniciado!");
        mostrarMenu();
    }

    private static void popularTabela() {
        listaUsuarios.add(new Pessoa("Patrick"));
        listaUsuarios.add(new Pessoa("Gabriel"));
        listaUsuarios.add(new Pessoa("Theo"));
        listaUsuarios.add(new Pessoa("Joao"));
        listaUsuarios.add(new Pessoa("Pedro"));

        listaLivros.add(new Livro("Dom Casmurro", "Machado de Assis", "Romance"));
        listaLivros.add(new Livro("O Cortico", "Aluisio Azevedo", "Romance"));
        listaLivros.add(new Livro("Harry Potter", "J.K. Rowling", "Fantasia"));
        listaLivros.add(new Livro("O Hobbit", "J.R.R. Tolkien", "Fantasia"));
        listaLivros.add(new Livro("1984", "George Orwell", "Ficcao"));
        listaLivros.add(new Livro("O Pequeno Principe", "Antoine de Saint-Exupery", "Fabula"));
        listaLivros.add(new Livro("A Revolucao dos Bichos", "George Orwell", "Ficcao"));
        listaLivros.add(new Livro("Senhor dos Aneis", "J.R.R. Tolkien", "Fantasia"));
        listaLivros.add(new Livro("A Culpa e das Estrelas", "John Green", "Romance"));
        listaLivros.add(new Livro("Percy Jackson", "Rick Riordan", "Aventura"));
    }

    public static void mostrarMenu() {
        int escolhaUsuario = 0;

        do {
            System.out.println("\n-------- SISTEMA BIBLIOTECA --------");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Excluir livro");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Registrar usuario");
            System.out.println("7 - Listar usuarios");
            System.out.println("0 - Sair");
            System.out.println("------------------------------------");
            System.out.println("Escolha uma opcao:");

            escolhaUsuario = scan.nextInt();
            scan.nextLine();

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 0: {
                System.out.println("Sistema encerrado!");
                break;
            }
            case 1: {
                listarLivros();
                break;
            }
            case 2: {
                cadastrarLivro();
                break;
            }
            case 3: {
                excluirLivro();
                break;
            }
            case 4: {
                emprestarLivro();
                break;
            }
            case 5: {
                devolverLivro();
                break;
            }
            case 6: {
                cadastrarUsuario();
                break;
            }
            case 7: {
                listarUsuarios();
                break;
            }
            default:
                System.out.println("Insira um valor valido!");
        }
    }

    private static void listarLivros() {
        System.out.println("\n-------- LISTA DE LIVROS --------");

        if (listaLivros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        for (int i = 0; i < listaLivros.size(); i++) {
            System.out.printf("%d) %s - %s - %s / %s\n",
                    i + 1,
                    listaLivros.get(i).getTitulo(),
                    listaLivros.get(i).getAutor(),
                    listaLivros.get(i).getGenero(),
                    listaLivros.get(i).validarDisponibilidade());
        }

        System.out.println("");
    }

    private static void cadastrarLivro() {
        Livro livro = new Livro();

        System.out.println("Informe o titulo do livro:");
        livro.setTitulo(scan.nextLine());

        System.out.println("Informe o autor do livro:");
        livro.setAutor(scan.nextLine());

        System.out.println("Informe o genero do livro:");
        livro.setGenero(scan.nextLine());

        listaLivros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void excluirLivro() {
        if (listaLivros.size() == 0) {
            System.out.println("Nao existem livros para excluir!");
            return;
        }

        listarLivros();

        System.out.println("Informe o livro a ser excluido:");
        int escolhaUsuario = scan.nextInt() - 1;
        scan.nextLine();

        if (escolhaUsuario < 0 || escolhaUsuario >= listaLivros.size()) {
            System.out.println("Valor invalido!");
            return;
        }

        if (listaLivros.get(escolhaUsuario).getDataEmprestimo() != null) {
            System.out.println("O livro esta emprestado e nao pode ser excluido!");
            return;
        }

        listaLivros.remove(escolhaUsuario);

        System.out.println("Livro removido com sucesso!");
    }

    private static void emprestarLivro() {
        if (listaUsuarios.size() == 0) {
            System.out.println("Nenhum usuario cadastrado!");
            return;
        }

        listarUsuarios();

        System.out.println("Informe o usuario que vai pegar o livro:");
        int usuario = scan.nextInt() - 1;
        scan.nextLine();

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Informe um usuario valido!");
            return;
        }

        if (listaUsuarios.get(usuario).getLivrosEmprestados().size() >= 2) {
            System.out.println("Usuario atingiu o limite de 2 livros!");
            return;
        }

        if (listaLivros.size() == 0) {
            System.out.println("Nenhum livro cadastrado!");
            return;
        }

        listarLivros();

        System.out.println("Informe o livro que deseja emprestar:");
        int livro = scan.nextInt() - 1;
        scan.nextLine();

        if (livro < 0 || livro >= listaLivros.size()) {
            System.out.println("Informe um livro valido!");
            return;
        }

        if (listaLivros.get(livro).getDataEmprestimo() != null) {
            System.out.println("Livro ja esta emprestado!");
            return;
        }

        listaUsuarios.get(usuario).getLivrosEmprestados().add(listaLivros.get(livro));
        listaLivros.get(livro).setDataEmprestimo(new Date());

        System.out.println("Livro emprestado com sucesso!");
    }

    private static void devolverLivro() {
        if (listaUsuarios.size() == 0) {
            System.out.println("Nenhum usuario cadastrado!");
            return;
        }

        listarUsuarios();

        System.out.println("Informe o usuario que vai devolver o livro:");
        int usuario = scan.nextInt() - 1;
        scan.nextLine();

        if (usuario < 0 || usuario >= listaUsuarios.size()) {
            System.out.println("Informe um usuario valido!");
            return;
        }

        if (listaUsuarios.get(usuario).getLivrosEmprestados().size() == 0) {
            System.out.println("Usuario nao possui livros emprestados!");
            return;
        }

        System.out.println("\n-------- LIVROS EMPRESTADOS --------");

        for (int i = 0; i < listaUsuarios.get(usuario).getLivrosEmprestados().size(); i++) {
            System.out.printf("%d) %s\n",
                    i + 1,
                    listaUsuarios.get(usuario).getLivrosEmprestados().get(i).getTitulo());
        }

        System.out.println("Informe o livro que deseja devolver:");
        int livro = scan.nextInt() - 1;
        scan.nextLine();

        if (livro < 0 || livro >= listaUsuarios.get(usuario).getLivrosEmprestados().size()) {
            System.out.println("Informe um livro valido!");
            return;
        }

        listaUsuarios.get(usuario).getLivrosEmprestados().get(livro).setDataEmprestimo(null);
        listaUsuarios.get(usuario).getLivrosEmprestados().remove(livro);

        System.out.println("Livro devolvido com sucesso!");
    }

    private static void cadastrarUsuario() {
        Pessoa usuario = new Pessoa();

        System.out.println("Informe o nome do usuario:");
        usuario.setNome(scan.nextLine());

        listaUsuarios.add(usuario);

        System.out.println("Usuario cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        System.out.println("\n-------- LISTA DE USUARIOS --------");

        if (listaUsuarios.size() == 0) {
            System.out.println("Nenhum usuario cadastrado!");
            return;
        }

        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.printf("%d) %s\n",
                    i + 1,
                    listaUsuarios.get(i).getNome());

            if (listaUsuarios.get(i).getLivrosEmprestados().size() != 0) {
                for (int j = 0; j < listaUsuarios.get(i).getLivrosEmprestados().size(); j++) {
                    System.out.printf("   %d) %s - %s\n",
                            j + 1,
                            listaUsuarios.get(i).getLivrosEmprestados().get(j).getTitulo(),
                            listaUsuarios.get(i).getLivrosEmprestados().get(j).getAutor());
                }
            }
        }

        System.out.println("");
    }
}
