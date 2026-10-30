import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import objetos.Livro;
import objetos.Pessoa;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Livro> livros = new ArrayList<>();
    static List<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        popularListas();
        mostrarMenu();
    }

    private static void popularListas() {
        livros.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski"));
        livros.add(new Livro("A Hora da Estrela", "Clarice Lispector"));
        livros.add(new Livro("Hamlet", "William Shakespeare"));
        livros.add(new Livro("O Hobbit", "J.R.R. Tolkien"));
        livros.add(new Livro("O Capital", "Karl Marx"));
        pessoas.add(new Pessoa("Michael Jackson"));
        pessoas.add(new Pessoa("Lulu Santos"));
        pessoas.add(new Pessoa("Carlos Marighella"));
        pessoas.add(new Pessoa("Lucas Silveira"));
        pessoas.add(new Pessoa("Edsger Dijkstra"));
    }

    public static void mostrarMenu() {
        int escolhaUsuario = 0;
        do {
            System.out.println("--- BIBLIOTECA ---");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Excluir livro");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6-  Registrar usuario");
            System.out.println("7-  Listar usuarios");
            System.out.println("0 - Saida");
            escolhaUsuario = sc.nextInt();
            sc.nextLine();
            validarEscolha(escolhaUsuario);
        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 0: {
                System.out.println("Obrigado por usar o sistema!");
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
                criarUsuario();
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
        System.out.println("--- LIVROS ---");
        for (int i = 0; i < livros.size(); i++) {
            System.out.printf("%d) %s - %s / %s\n", i + 1, livros.get(i).getNome(), livros.get(i).getAutor(),
                    livros.get(i).validaDisponibilidade());
        }
        System.out.println("");

    }

    private static void cadastrarLivro() {
        System.out.println("Informe o nome do livro: ");
        String nome = sc.nextLine();
        System.out.println("Informe o autor do livro: ");
        String autor = sc.nextLine();
        Livro l = new Livro(nome, autor);
        livros.add(l);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void excluirLivro() {
        if (livros.size() == 0) {
            System.out.println("Não há livros a serem excluídos");
            return;
        }

        listarLivros();
        System.out.println("Digite o livro a ser excluído: ");
        int escolhaUsuario = sc.nextInt() - 1;
        sc.nextLine();

        if (escolhaUsuario >= livros.size() || escolhaUsuario < 0) {
            System.out.println("Valor inválido!");
            return;
        }
        if (livros.get(escolhaUsuario).getDataEmprestimo() != null) {
            System.out.println("O livro foi emprestado e não pode ser excluído.");
            return;
        }
        livros.remove(escolhaUsuario);
        System.out.println("Livro removido com sucesso!");

    }

    private static void emprestarLivro() {
        listarUsuarios();
        System.out.println("Informe o usuário que vai pegar o livro emprestado");
        int usuario = sc.nextInt() - 1;
        sc.nextLine();
        if (usuario >= pessoas.size() || usuario < 0) {
            System.out.println("Usuário inválido.");
            return;
        }

        if (pessoas.get(usuario).getLivrosEmprestados().size() >= 2) {
            System.out.println("Usuário está com o maximo de livros possiveis.");
            return;
        }

        listarLivros();
        int idLivro = sc.nextInt() - 1;
        sc.nextLine();
        if (idLivro >= livros.size() || idLivro < 0) {
            System.out.println("Informe um livro valido!");
            return;
        }
        Livro livro = livros.get(idLivro);
        if (livro.getDataEmprestimo() != null) {
            System.out.println("Livro já emprestado");
            return;
        }

        pessoas.get(usuario).getLivrosEmprestados().add(livro);
        livro.setDataEmprestimo(new Date());
        System.out.println("Livro emprestado com sucesso!");
    }

    private static void devolverLivro() {
        listarUsuarios();
        System.out.println("Informe o usuário que vai devolver o livro");
        int IDUsuario = sc.nextInt() - 1;
        sc.nextLine();

        if (IDUsuario >= pessoas.size() || IDUsuario < 0) {
            System.out.println("Informe um usuário valido!");
            return;
        }
        Pessoa usuario = pessoas.get(IDUsuario);
        if (usuario.getLivrosEmprestados().size() == 0) {
            System.out.println("Usuário não possui livros emprestados");
            return;
        }

        System.out.println("Informe o livro que o usuário vai devolver");
        int livro = sc.nextInt() - 1;
        sc.nextLine();

        if (livro >= usuario.getLivrosEmprestados().size() || livro < 0) {
            System.out.println("Informe um livro existente");
            return;
        }

        usuario.getLivrosEmprestados().get(livro).setDataEmprestimo(null);
        usuario.getLivrosEmprestados().remove(livro);
        System.out.println("Livro devolvido com sucesso!");

    }

    private static void criarUsuario() {

        System.out.println("Informe o nome do Usuario: ");
        String nome = sc.nextLine();

        pessoas.add(new Pessoa(nome));
        System.out.println("Usuario cadastrado com sucesso!");

    }

    private static void listarUsuarios() {
        System.out.println("\n--- USUÁRIOS ---");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.printf("%d) %s \n", i + 1, pessoas.get(i).getNome());
            if (pessoas.get(i).getLivrosEmprestados().size() != 0) {
                for (int j = 0; j < pessoas.get(i).getLivrosEmprestados().size(); j++) {
                    System.out.printf("  %d) %s - %s\n", j + 1,
                            pessoas.get(i).getLivrosEmprestados().get(j).getNome(),
                            pessoas.get(i).getLivrosEmprestados().get(j).getAutor());
                }
            }
        }
        System.out.println("");
    }
}
