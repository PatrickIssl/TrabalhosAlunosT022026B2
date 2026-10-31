package fag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Produto;

public class Principal {
	static Scanner scan = new Scanner(System.in);
	static List<Produto> listaProdutos = new ArrayList<Produto>();
	public static void main(String[] args) {
		System.out.println("----------Sistema iniciado----------");
		mostrarMenu();

	}
	
	private static void mostrarMenu() {
		int escolhaUsuario;
		do {
		System.out.println("----------Escolha uma opção!----------");
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Listar produtos");
		System.out.println("3 - Buscar por ID");
		System.out.println("4 - Atualizar Cadastro");
		System.out.println("5 - Excluir produto");
		System.out.println("0 - Sair");
		escolhaUsuario = scan.nextInt();
		scan.nextLine();
		validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}
	
	private static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0:{
			System.out.println("Sistema encerrado, obrigado por utilizar!");
			scan.close();
			break;
		}
		case 1:{
			cadastrarProduto();
			break;
		}
		case 2:{
			listarProduto();
			break;
		}
		case 3:{
			buscarId();
			break;
		}
		case 4:{
			atualizarCadastro();
			break;
		}
		case 5:{
			excluirProduto();
			break;
		}

		default:
			System.out.println("Insira um valor válido");
		}
	}
	
	private static void cadastrarProduto() {
		Produto produto = new Produto();
		produto.setId(listaProdutos.size()+1);
		
		System.out.println("Informe o nome do produto:");
		produto.setNome(scan.nextLine());
		
		System.out.println("Informe o preço do produto:");
		produto.setPreco(scan.nextDouble());
		
		listaProdutos.add(produto);
		System.out.printf("Produto cadastrado com sucesso! Id: %d\n",produto.getId());
	}
	
	private static void listarProduto() {
		for (int i = 0; i < listaProdutos.size(); i++) {
			System.out.printf("%d) %s - R$%.2f \n",listaProdutos.get(i).getId(),listaProdutos.get(i).getNome(),listaProdutos.get(i).getPreco());
		}
	}

	private static void buscarId() {
		int escolha;
		System.out.println("Informe o id:");
		escolha = scan.nextInt(); 
		scan.nextLine();
		if (escolha < 0) {
			System.out.println("Id não encontrado!");
			return;
		}
		for (int i = 0; i < listaProdutos.size(); i++) {
			if(escolha == listaProdutos.get(i).getId()) {
				System.out.printf("%d) %s - %.2f \n",listaProdutos.get(i).getId(),listaProdutos.get(i).getNome(),listaProdutos.get(i).getPreco());
				return;
			}
		}
		System.out.println("Id não encontrado!");
	}
	
	private static void atualizarCadastro() {
		listarProduto();
		System.out.println("Informe o id do produto que deseja atualizar:");
		int escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();
		System.out.println("Informe o que deseja atualizar!");
		System.out.println("1 - Nome");
		System.out.println("2 - Preço");
		System.out.println("3 - Nome e preço");
		int escolhaAtualizacao = scan.nextInt();
		scan.nextLine();
		switch (escolhaAtualizacao) {
		case 1:{
			System.out.println("Informe o novo nome:");
			String nome = scan.nextLine();
			listaProdutos.get(escolhaUsuario).setNome(nome);
			break;
		}
		case 2:{
			System.out.println("Informe o novo preço:");
			double preco = scan.nextDouble();
			listaProdutos.get(escolhaUsuario).setPreco(preco);
			break;
		}
		case 3:{
			System.out.println("Informe o novo nome:");
			String nome = scan.nextLine();
			listaProdutos.get(escolhaUsuario).setNome(nome);
			
			System.out.println("Informe o novo preço:");
			double preco = scan.nextDouble();
			listaProdutos.get(escolhaUsuario).setPreco(preco);
			break;
		}

		default:
			System.out.println("Insira um valor válido!");
		}
	}
	
	private static void excluirProduto() {
		listarProduto();
		System.out.println("Informe o id do produto que deseja excluir:");
		int escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();
		
		if (escolhaUsuario >= listaProdutos.size() || escolhaUsuario < 0) {
			System.out.println("Informe uma opção valida!");
			return;
		}
		
		listaProdutos.remove(escolhaUsuario);
		System.out.println("Produto excluído com sucesso!");
		
	}
}
