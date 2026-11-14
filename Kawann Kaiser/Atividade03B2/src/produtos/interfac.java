package produtos;
		
import java.util.Scanner;

import produtos.objetos.Produtos;

import java.util.ArrayList;
import java.util.List;

public class interfac {
	
	static Scanner scan = new Scanner(System.in);
	static List<Produtos> estoque = new ArrayList<Produtos>();
	static int cont = 0;
	
	
	
	
	public static void main(String[] args) {
		preencher();
		cont = estoque.size();
		mostrarMenu();
	}
	
	
	private static void mostrarMenu() {
		int escolha = 0;
		do {
			System.out.println("-------------Controle de estoque-------------");
			System.out.println("1 - Cadastrar produto.");
			System.out.println("2 - Listar estoque.");
			System.out.println("3 - Alterar dados de um produto.");
			System.out.println("4 - Vender um produto.");
			System.out.println("0 - Sair.");
			escolha = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolha);
		} while (escolha != 0);
		System.out.println("Obrigado por utilizar o sistema");
		
	}
	
    public static void preencher() {

        estoque.add(new Produtos("Teclado Mecânico", 159.90, 1));
        estoque.add(new Produtos("Mouse Gamer", 89.90, 2));
        estoque.add(new Produtos("Monitor 24 Polegadas", 799.90, 3));
        estoque.add(new Produtos("Memória RAM 16GB", 249.90, 4));
        estoque.add(new Produtos("SSD 500GB", 299.90, 5));
        estoque.add(new Produtos("Processador Ryzen 5", 899.90, 6));
        estoque.add(new Produtos("Placa de Vídeo RTX 4060", 2199.90, 7));
        estoque.add(new Produtos("Fonte 650W", 329.90, 8));
        estoque.add(new Produtos("Gabinete Gamer", 249.90, 9));
        estoque.add(new Produtos("Headset Gamer", 179.90, 10));

    }
	
	private static void validarEscolha(int escolha) {
		if(escolha == 1) {
			cadastrarProduto();
			return;
		}
		if(escolha == 2) {
			listarEstoque();
			return;
		}
		if(escolha == 3) {
			alterarDados();
			return;
		}
		if(escolha == 4) {
			venderProduto();
			return;
		}
	}
	private static void venderProduto() {
		listarEstoque();
		if(estoque.size() <= 0) {
			System.out.println("Retornando ao Menu");
			return;
		}
		System.out.println("Informe o produto que deseja vender: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha < 0 || escolha >= estoque.size()) {
			System.out.println("Informe um valor válido");
			return;
		}
		System.out.println("Venda realizada com sucesso");
		estoque.remove(escolha);
	}
	
	
	private static void alterarDados() {
		listarEstoque();
		System.out.println("Informe o produto que deseja alterar: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha < 0 || escolha > estoque.size()) {
			System.out.println("Informe um valor válido");
			return;
		}
		Produtos produtos = estoque.get(escolha);
		System.out.println("Informe a nome do produto:");
		produtos.setNome(scan.nextLine());
		System.out.println("Informe o valor do produto:");
		produtos.setValor(scan.nextDouble());
		scan.nextLine();
		System.out.println("Dados alterados com sucesso!");
		
			
		}
	
			
	
	
	private static void listarEstoque() {
		System.out.println("------------Estoque------------\n");
		if(estoque.size() < 1) {
			System.out.println("Estoque vazio! \n");
			return;
		}
		for (int i = 0; i < estoque.size(); i++) {
			estoque.get(i).mostrarDados(i+1);
		}
		System.out.println("");
	}
	
	
	private static void cadastrarProduto() {
		Produtos produto = new Produtos();
		System.out.println("informe o nome do produto");
		produto.setNome(scan.nextLine());
		System.out.println("informe o valor do produto");
		produto.setValor(scan.nextDouble());
		scan.nextLine();

		if (produto.getNome() == null || produto.getValor() <= 0) {
		    System.out.println("Cadastro cancelado! Dados inválidos.");
		    return;
		}
		produto.setId(cont += 1);
		estoque.add(produto);
		System.out.println("produto cadastrado com sucesso");
		
		
	}
	
	
}
