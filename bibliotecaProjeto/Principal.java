package bibliotecaProjeto;
import java.util.ArrayList;
import java.util.Scanner;

import Ana.projetoBiblioteca.objetos.Livros;
import bibliotecaProjeto.objeto.Livro;

public class Principal {

    static ArrayList<Livro> livros = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int id = 1;

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){

        int opcao = 0;

        do{
            System.out.println("=== Biblioteca ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar livro");
            System.out.println("5 - Deletar livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch(opcao){
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    buscarId();
                    break;
                case 4:
                    atualizar();
                    break;
                 case 5:
                    deletar();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    
}

public static void cadastrarLivro(){
    System.out.print("Digite o título do livro: ");
	        String titulo = scan.nextLine();

	        System.out.print("Digite o autor: ");
	        String autor = scan.nextLine();

	        System.out.print("Digite o preco: ");
	        double preco = scan.nextDouble();
	        scan.nextLine();

	        Livro livro = new Livro(id, titulo, autor, preco , true);
	        livros.add(livro);

	        System.out.println("Livro cadastrado - ID = " + id);
	        id++;
	    }

public static void listarLivros(){
    System.out.println("=== Lista de Livros ===");
    for(Livro livro : livros){
        System.out.println("ID: " + livro.getId());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Preço: " + livro.getPreco());
            System.out.println("Disponível: " + livro.isDisponivel());
        }
    }

public static void buscarId(){
    System.out.print("Digite o ID do livro: ");
		    int idBusca = scan.nextInt();
		    scan.nextLine();

            for(Livro livro: livros){
    
            if(livro.getId() == idBusca){
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Preço: " + livro.getPreco());
            System.out.println("Disponível: " + livro.isDisponivel());
   }
}

}

public static void atualizar(){

        System.out.print("Digite o ID do livro: ");
		    int idBusca = scan.nextInt();
		    scan.nextLine();

            for(Livro livro: livros){
    
            if(livro.getId() == idBusca){
            System.out.print("Digite o título do livro: ");
	        livro.setTitulo(scan.nextLine());


	        System.out.print("Digite o autor: ");
	        livro.setAutor(scan.nextLine());

	        System.out.print("Digite o preco: ");
	        livro.setPreco(scan.nextDouble());

	        System.out.println("Livro atualizado com sucesso ");
   }
}
}

public static void deletar(){
    System.out.print("Digite o ID do livro:");
    int idBusca = scan.nextInt();
    scan.nextLine();

    for(Livro livro: livros){
        if(livro.getId() == idBusca){
            livros.remove(livro);
            System.out.print("Livro excluido com sucesso!");
        }
    }
}



}
