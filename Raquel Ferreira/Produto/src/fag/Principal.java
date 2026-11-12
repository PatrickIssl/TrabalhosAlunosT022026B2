package fag;

import java.util.ArrayList;
import java.util.Scanner;
import objeto.Produto;

public class Principal {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Produto>estoque=new ArrayList<Produto>();
	
	public static void main(String[] args) {
		iniciarEstoque();
		mostrarMenu();

	}
	private static void iniciarEstoque() {
		estoque.add(new Produto(1, "Mouse", 50));
	    estoque.add(new Produto(2, "Teclado", 100));
	    estoque.add(new Produto(3, "Monitor", 800));
	}
	private static void mostrarMenu() {
		int opcao = 0;
		do {
			System.out.println("========== SISTEMA DE GERENCIAMENTO ==========");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar todos");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Excluir");
			System.out.println("0 - Sair");
			opcao = sc.nextInt();
			sc.nextLine();
			confirmarEscolha(opcao);
				
		}while (opcao != 0);
	}
	private static void confirmarEscolha(int opcao) {
		switch (opcao) {
		case 1: {
			cadastrarProduto();
			break;
		}
		case 2: {
			listarTodos();
			break;
		}
		case 3: {
			buscarPorId();
			break;
		}
		case 4: {
			atualizarProduto();
			break;
		}
		case 5: {
			excluirProduto();
			break;
		}
		case 0: {
			System.out.println("Encerrando o sitema...");
		}
		default: {
			System.out.println("Opção inválida. Tente novamente.");
		}
		}
	}
	private static void cadastrarProduto() {
		System.out.println("Digite o Id do produto: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o nome do produto: ");
		String nome= sc.nextLine();
		System.out.println("Digite o preço do produto: ");
		double preco = sc.nextDouble();
		
		Produto novoProduto = new Produto (id, nome, preco);
		estoque.add(novoProduto);		
	}
	
	private static void listarTodos() {
		if (estoque.size() == 0) {
			System.out.println("Não há produtos registrados ainda...");
			return;
		}
		
		System.out.println("===============SISTEMA DE PRODUTOS===============");
		for (int i=0; i<estoque.size(); i++) {
			System.out.printf("%d	-	%s	-	%.2f%n", estoque.get(i). getId(), estoque.get(i). getNome(), estoque.get(i). getPreco());
		}
		
	}
	
	private static void buscarPorId() {
		
		System.out.println("Digite o Id que deseja buscar: ");
		int id = sc.nextInt();
		sc.nextLine();
		Produto produto = encontrarId(id);
		System.out.printf("ID: %d%n", produto.getId());
		System.out.printf("Produto: %s%n", produto.getNome());
		System.out.printf("Preço: %.2f%n", produto.getPreco());
		
	}
	private static void atualizarProduto() {
		
		System.out.println("Digite o ID do produto que deseja atualizar: ");
		int id = sc.nextInt();
		sc.nextLine();
		Produto novoProduto = encontrarId(id);
		if (novoProduto == null) {
			System.out.println("O ID não corresponde a nenhum produto.");
			return;
		}
		System.out.println("Digite o novo nome do produto: ");
		novoProduto.setNome(sc.nextLine());
		System.out.println("Digite o novo preço do produto: ");
		novoProduto.setPreco(sc.nextDouble());
		sc.nextLine();
		
	}
	
	private static void excluirProduto() {
		
		System.out.println("Digite o id do produto que deseja excluir: ");
		int id = sc.nextInt();
		sc.nextLine();
		Produto produto = encontrarId(id);
		if (produto == null) {
			System.out.println("Produto não encontrado.");
			return;
		}
		estoque.remove(produto);
		System.out.println("Produto removido!");
		
	}
	private static Produto encontrarId(int id) {
		for (int i=0; i<estoque.size(); i++) {
			if (estoque.get(i).getId()==id) {
				return estoque.get(i);
			}
		}
		return null;
	}
	}
