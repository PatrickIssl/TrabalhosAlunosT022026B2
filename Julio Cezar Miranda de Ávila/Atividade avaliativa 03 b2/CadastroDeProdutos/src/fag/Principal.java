package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objeto.Produto;

public class Principal {
	
	static Scanner scan = new Scanner(System.in);
	static List<Produto> estoque = new ArrayList<Produto>();
	
	public static void main(String[] args) {
		System.out.println("Sistema iniciado!");
		Menu();
	}

	private static void Menu() {
		int escolhaUsuario;
		do {
			System.out.printf("\n------- Escolha uma opção -------\n");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar todos os produtos");
			System.out.println("3 - Buscar produto por ID");
			System.out.println("4 - Atualizar produto");
			System.out.println("5 - Excluir produto");
			System.out.println("0 - Sair");
			
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			ValidarEscolha(escolhaUsuario);
			
		}while (escolhaUsuario != 0);
	}

	private static void ValidarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 1: {
			CadastrarProduto();
			break;
		}
		case 2: {
			ListarProdutos();
			break;
		}
		case 3: {
			BuscarProduto();
			break;
		}
		case 4: {
			AtualizarProduto();
			break;
		}
		case 5: {
			ExcluirProduto();
			break;
		}
		case 0: {
			System.out.println("Obrigado por usar o sistema!");
			System.out.println("Finalizado!");
			break;
		}
		default:
			System.out.println("Opção invalida!");
		}
	}

	private static void ExcluirProduto() {
		int escolhaUsuario;
		if (estoque.size() < 1) {
			System.out.println("Estoque vazio! Não a produto para ser excluido \n");
			return;
		}
		
		ListarProdutos();
		System.out.println("Entre com o ID do produto que deseja excluir:");
		escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();
		
		if(escolhaUsuario < 0 || escolhaUsuario > (estoque.size() - 1)) {
			System.out.println("ID invalidos!");
			return;
		}
		estoque.remove(escolhaUsuario);
		System.out.println("Produto excluido com sucesso!");
	}

	private static void AtualizarProduto() {
		int escolhaUsuario;
		if (estoque.size() < 1) {
			System.out.println("Estoque vazio! Não a produto para ser atualizado \n");
			return;
		}
		
		ListarProdutos();
		System.out.println("Entre com o ID do produto que deseja atualizar:");
		escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();
		
		if(escolhaUsuario < 0 || escolhaUsuario > (estoque.size() - 1)) {
			System.out.println("ID invalidos!");
			return;
		}
		
		Produto produto = estoque.get(escolhaUsuario);
		
		System.out.println("Entre com o novo nome do produto:");
		produto.setNome(scan.nextLine());
		System.out.println("Entre com o novo preço do produto:");
		produto.setPreço(scan.nextDouble());
		scan.nextLine();
		System.out.println("Produto atualizado com sucesso!");
	}

	private static void BuscarProduto() {
		int escolhaUsuario;
		if (estoque.size() < 1) {
			System.out.println("Estoque vazio! \n");
			return;
		}
		
		ListarProdutos();
		System.out.println("Entre com o ID do produto que deseja buscar:");
		escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();
		
		if(escolhaUsuario < 0 || escolhaUsuario > (estoque.size() - 1)) {
			System.out.println("ID invalidos!");
			return;
		}
		
		for (int i = 0; i < estoque.size(); i++) {
			if (i == escolhaUsuario) {
				estoque.get(i).MostrarDados(i+1);
			}
		}
		
	}

	private static void ListarProdutos() {
		System.out.println("------- Estoque de Produtos -------");
		if (estoque.size() < 1) {
			System.out.println("Estoque vazio! \n");
			return;
		}
		for (int i = 0; i < estoque.size(); i++) {
			estoque.get(i).MostrarDados(i+1);
		}
	}

	private static void CadastrarProduto() {
		Produto produto = new Produto();
		System.out.println("Entre com o nome do produto:");
		produto.setNome(scan.nextLine());
		System.out.println("Entre com o preço do produto:");
		produto.setPreço(scan.nextDouble());
		scan.nextLine();
		if (produto.getNome().isBlank() || produto.getPreço() <= 0) {
			System.out.println("Dados invalidos!");
			return;
		}
		estoque.add(produto);
	}

	
}
