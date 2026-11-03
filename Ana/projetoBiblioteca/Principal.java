package Ana.projetoBiblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ana.projetoBiblioteca.objetos.Livros;
import Ana.projetoBiblioteca.objetos.Usuario;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static List<Livros> listaLivros = new ArrayList<Livros>();
    static List<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public static void main(String[] args) {
        tabelaTotal();

        System.out.println("Sistema iniciado!");
        mostrarMenu();
    }

    private static void tabelaTotal() {
        listaUsuarios.add(new Usuario("Ana"));
        listaUsuarios.add(new Usuario("Luiza"));
        listaUsuarios.add(new Usuario("Beatriz"));
        listaUsuarios.add(new Usuario("Maria"));
        listaUsuarios.add(new Usuario("Sara"));
        listaUsuarios.add(new Usuario("Isadora"));
        listaUsuarios.add(new Usuario("Ketlyn"));
        listaLivros.add(new Livros("O pequeno príncipe", "Antoine de Saint-Exupéry", "Ficção"));
        listaLivros.add(new Livros("O senhor dos anéis", "J.R.R. Tolkien", "Fantasia"));
        listaLivros.add(new Livros("Harry Potter e a pedra filosofal", "J.K. Rowling", "Fantasia"));
        listaLivros.add(new Livros("1984", "George Orwell", "Distopia"));
        listaLivros.add(new Livros("O Hobbit", "J.R.R. Tolkien", "Fantasia"));
        listaLivros.add(new Livros("A revolução dos bichos", "George Orwell", "Distopia"));
        listaLivros.add(new Livros("Jantar Secreto", "Raphael Montes", "Suspense"));
        listaLivros.add(new Livros("Os Sete Maridos de Evelyn Hugo", "Taylor Jenkins Reid", "Romance"));
    }
    

    public static void mostrarMenu() {
        int escolhaUsuario = 0;
        do {
            System.out.println("--------------------Selecione uma das opções--------------------");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Excluir livro");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
          
            escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);

        }while (escolhaUsuario != 6);

    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
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
            default:
                System.out.println("Insira um valor valido!");
        }
    }

    private static void devolverLivro() {
        listaUsuarios();
        System.out.println("Informe o usuário que vai devolver o livro");
		int usuario = scan.nextInt()-1;
		scan.nextLine();

        if(usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}

        if(listaUsuarios.get(usuario).getLivrosLocados().size() == 0) {
            System.out.println("O usuário não possui livros emprestados!");
            return;
        }


        System.out.println("Informe o livro que o usuário vai devolver");
		int livro= scan.nextInt()-1;
		scan.nextLine();
		
		if(livro >= listaUsuarios.get(usuario).getLivrosLocados().size() || livro < 0) {
			System.out.println("Informe um livro existente");
		}
		
		listaUsuarios.get(usuario).getLivrosLocados().get(livro).setDisponivel(true);
		listaUsuarios.get(usuario).getLivrosLocados().remove(livro);
		System.out.println("Livro devolvido com sucesso!");
		
	}


    private static void listaUsuarios() {
        System.out.println("Lista de usuários:");
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println((i + 1) + " - " + listaUsuarios.get(i).getNome());
        }
    }

    private static void cadastrarLivro() {
        System.out.println("Informe o título do livro:");
        String titulo = scan.nextLine();
        System.out.println("Informe o autor do livro:");
        String autor = scan.nextLine();
        System.out.println("Informe o gênero do livro:");
        String genero = scan.nextLine();
        listaLivros.add(new Livros(titulo, autor, genero));
        System.out.println("Livro cadastrado com sucesso!");
    }


    private static void listarLivros() {
        System.out.println("Lista de livros:");
        for (int i = 0; i < listaLivros.size(); i++) {
            System.out.println((i + 1) + " - " + listaLivros.get(i).getTitulo() + " - " + listaLivros.get(i).getAutor() + " - " + listaLivros.get(i).getGenero());
        }
    }

    private static void excluirLivro() {
       if(listaLivros.size() == 0) {
			System.out.println("Não existem livros para excluir!");
			return;
		}
		
		listarLivros();
		System.out.println("Informe o livro a ser excluido: ");
		int escolhaUsuario = scan.nextInt() - 1;

        if(escolhaUsuario >= listaLivros.size() || escolhaUsuario < 0) {
			System.out.println("Valor inválido!");
			return;
		}
		if(listaLivros.get(escolhaUsuario).isDisponivel() == false) {
			System.out.println("O livro está locado, portanto não pode ser excluido!");
			return;
		}
		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso!");

}

private static void emprestarLivro() {
        listaUsuarios();
        System.out.println("Informe o usuário que vai pegar o livro emprestado");
        int usuario = scan.nextInt()-1;
        scan.nextLine();

        if(usuario > listaUsuarios.size() && usuario < 0) {
            System.out.println("Informe um usuário valido!");
            return;
        }

        listarLivros();
        System.out.println("Informe o livro que o usuário vai pegar emprestado");
        int livro= scan.nextInt()-1;
        scan.nextLine();
        
        if(livro >= listaLivros.size() || livro < 0) {
            System.out.println("Informe um livro existente");
            return;
        }
        
        if(listaLivros.get(livro).isDisponivel() == false) {
            System.out.println("O livro não está disponível para empréstimo!");
            return;
        }
        
        listaLivros.get(livro).setDisponivel(false);
        listaUsuarios.get(usuario).getLivrosLocados().add(listaLivros.get(livro));
        System.out.println("Livro emprestado com sucesso!");
        
    }
}
