package cadastro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Livro> livros = new ArrayList<>();
	static int proximoId = 1;
	
	public static void main(String[] args) {

		int opt;
		
		do {
			System.out.println("\n========== SISTEMA DE GERENCIAMENTO DE LIVROS ==========");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opt = scanner.nextInt();
            scanner.nextLine();
            
            switch (opt) {
            case 1:
            	cadastrar();
            	break;
            	
            case 2:
            	listar();
            	break;
            	
            case 3:
            	buscar();
            	break;
            	
            case 4:
            	atualizar();
            	break;
            	
            case 5: 
            	excluir();
            	break;
            	
            case 0:
            	System.out.println("Sistema encerrado.");
            	break;
            	
            default:
            	System.out.println("Opção inválida.");
      
            }
			
		} while (opt != 0);

		scanner.close();
	}

	private static void excluir() {
		
		System.out.println("=== Excluir livro ===");
		if (livros.isEmpty()) {
		    System.out.println("Não existem livros cadastrados.");
		    return;
		}
		System.out.println("Digite o ID do livro: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		for(Livro livro : livros) {
			if(livro.getId() == id) {
				livros.remove(livro);
				System.out.println("Livro removido com sucesso.");
				return;
			}
		}
		
	}

	private static void atualizar() {
	    System.out.println("=== Atualizar livro ===");
	    System.out.println("Digite o ID do livro: ");

	    int id = scanner.nextInt();
	    scanner.nextLine();

	    for (Livro livro : livros) {

	        if (livro.getId() == id) {

	            System.out.println("\nLivro encontrado.");
	            livro.exibirDados();

	            System.out.println("Digite o novo título: ");
	            livro.setTitulo(scanner.nextLine());

	            System.out.println("Digite o novo autor: ");
	            livro.setAutor(scanner.nextLine());

	            System.out.println("Digite o novo ISBN: ");
	            livro.setIsbn(scanner.nextLine());

	            System.out.println("Digite o novo ano de publicação: ");
	            livro.setAnoP(scanner.nextInt());
	            scanner.nextLine();

	            System.out.println("Digite a nova quantidade de páginas: ");
	            livro.setQntPag(scanner.nextInt());
	            scanner.nextLine();

	            System.out.println("Digite o novo valor: ");
	            livro.setValor(scanner.nextDouble());
	            scanner.nextLine();

	            System.out.println("Livro atualizado com sucesso.");
	            return;
	        }
	    }

	    System.out.println("Livro não encontrado.");
	}

	private static void buscar() {
		System.out.println("\n=== Buscar livro ===");
		
		System.out.println("Digite o ID do livro: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		
		for(Livro livro : livros) {
			if(livro.getId() == id) {
				System.out.println("\nLivro encontrado.");
				livro.exibirDados();
				return;
			}
		}
		
		System.out.println("Livro não encontrado.");
		
	}

	private static void listar() {
		System.out.println("\n=== Lista de livros ===");
		
		if(livros.isEmpty()) {
			System.out.println("Não existem livros cadastrados");
			return;
		}
		
		for(Livro livro : livros) {
			livro.exibirDados();
		}
		
	}

	private static void cadastrar() {
		System.out.println("\n=== Cadastrar livro ===");
		
		 System.out.println("Digite o título: ");
		 String titulo = scanner.nextLine();
		 
		 System.out.println("Digite o autor: ");
		 String autor = scanner.nextLine();
		 
		 System.out.println("Digite o ISBN: ");
		 String isbn = scanner.nextLine();
		 
		 System.out.println("Digite o ano de publicação: ");
		 int anoP = scanner.nextInt();
		 scanner.nextLine();
		 
		 System.out.println("Digite a quantidade de páginas: ");
		 int qntPag = scanner.nextInt();
		 scanner.nextLine();
		 
		 System.out.println("Digite o valor do livro: R$");
		 double valor = scanner.nextDouble();
		 
		 Livro livro = new Livro(proximoId, titulo, autor, isbn, anoP, qntPag, valor);
		 livros.add(livro);
		 
		 System.out.println("\nLivro cadastrado com sucesso.");
		 System.out.println("ID do livro: " + proximoId);
		 
		 proximoId++;
		 
	}

}
