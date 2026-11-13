package produtosClasse;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	static Scanner scan = new Scanner(System.in);
	static List <Produtos> listaprodutos = new ArrayList<Produtos>();
	
	
	public static void main(String[] args) {
		printMenu();
	}

	public static void printMenu() {
		int escolhaUsuario = 0;
		do {
		System.out.println("1- Cadastrar");
		System.out.println("2 - Listar todos");
		System.out.println("3 - Buscar por ID");
		System.out.println("4 - Atualizar");
		System.out.println("5 - Excluir");
		System.out.println("0 - Sair");
		escolhaUsuario = scan.nextInt();
		scan.nextLine();
		validarEscolha(escolhaUsuario);
		}while(escolhaUsuario != 0);
	}

	public static void validarEscolha(int escolhaUsuario) {
		switch(escolhaUsuario) {
		case 0:{
			System.out.println("Saindo do sistema");
			break;
		}
		case 1:{
			cadastrarProduto();
			break;
		}
		case 2:{
			listarProdutos();
			break;
		}
		case 3:{
			buscarId();
			break;
		}
		case 4:{
			atualizarProduto();
			break;
		}
		case 5:{
			excluirProduto();
			break;
		}
		}
	}
	
	private static void cadastrarProduto() {
		Produtos produto = new Produtos();
		
		System.out.println("Insira o ID do produto");
		produto.setId(scan.nextInt());
		scan.nextLine();
		
		System.out.println("Insira o nome do produto");
		produto.setNome(scan.nextLine());
		
		System.out.println("Insira o valor do produto");
		produto.setPreco(scan.nextDouble());
		listaprodutos.add(produto);
	}
	private static void listarProdutos() {
		if (listaprodutos.isEmpty()) {
			System.out.println("\n[Aviso] Nenhum produto cadastrado no momento.\n");
			return;
		}
		
		for(int i = 0; i < listaprodutos.size(); i++) {
			System.out.printf("%d - ID : %d | PRODUTO: %s | PRECO: %.2f \n" ,(i + 1), listaprodutos.get(i).getId(),listaprodutos.get(i).getNome(),listaprodutos.get(i).getPreco());
		}
	}
	private static void buscarId() {
		if (listaprodutos.isEmpty()) {
			System.out.println("\n[Aviso] Nenhum produto cadastrado no momento.\n");
			return;
		}
		
		int cont = 0;
		System.out.println("Insira o ID que deseja buscar");
		int buscaId = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < listaprodutos.size(); i ++) {
			if (buscaId == listaprodutos.get(i).getId()){
				System.out.println("Foi encontrado um produto com este ID");
				System.out.printf("%d - %d | %s | %f \n",i + 1, listaprodutos.get(i).getId(),listaprodutos.get(i).getNome(),listaprodutos.get(i).getPreco());
				cont++;
			}
		}	
		if (cont == 0) {
			System.out.println("Nao foi encontrado nenhum produto com este ID");
		}
	}
	private static void atualizarProduto() {
		if (listaprodutos.isEmpty()) {
			System.out.println("\n[Aviso] Nenhum produto cadastrado no momento.\n");
			return;
		}
		
		System.out.println("Insira o cadastro que quer atualizar");
		listarProdutos();
		int escolhaUsuario = scan.nextInt();
		
		if (escolhaUsuario < 1 || escolhaUsuario > listaprodutos.size()) {
			System.out.println("Número de cadastro inválido!");
			return;
		}
		Produtos produto = listaprodutos.get(escolhaUsuario - 1);
		
		System.out.println("Insira o novo ID do produto");
		produto.setId(scan.nextInt());
		scan.nextLine();
		
		System.out.println("Insira o novo nome do produto");
		produto.setNome(scan.nextLine());
		
		System.out.println("Insira o novo valor do produto");
		produto.setPreco(scan.nextDouble());
		scan.nextLine();
		System.out.println("Produto atualizado com sucesso");
	}
	private static void excluirProduto() {
		if(listaprodutos.isEmpty()) {
			System.out.println("\n[Aviso] Não existem produtos para excluir!\n");
			return;
		}	

		System.out.println("Insira o cadastro que quer excluir");
		listarProdutos();
		int escolhaUsuario = scan.nextInt() - 1;
		
		if(escolhaUsuario > listaprodutos.size()) {
			System.out.println("Valor inválido!");
			return;
		}
		listaprodutos.remove(escolhaUsuario);
		System.out.println("Cadastro excluido com sucesso");
		
	}
	
	
	
	
	
	
	
}
