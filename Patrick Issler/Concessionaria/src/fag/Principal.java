package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Veiculo;

public class Principal {
	
	static Scanner scan = new Scanner(System.in);
	static List<Veiculo> estoque = new ArrayList<Veiculo>();
	
	public static void main(String[] args) {
		inicializarEstoque();
		mostrarMenu();
	}

	//esse metodo mostra o menu
	private static void mostrarMenu() {
		int escolha = 0;
		do {
			System.out.println("-------------Concessionaria-------------");
			System.out.println("1 - Cadastrar veiculo.");
			System.out.println("2 - Listar estoque.");
			System.out.println("3 - Alterar dados de um veiculo.");
			System.out.println("4 - Vender veiculo.");
			System.out.println("0 - Sair.");
			escolha = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolha);
		} while (escolha != 0);
		System.out.println("Obrigado por utilizar o sistema!");
	}

	//esse metodo mostra a validacão de escolha
	private static void validarEscolha(int escolha) {
		if(escolha == 1) {
			cadastrarVeiculo();
			return;
		}
		if(escolha == 2) {
			listarEstoque();
			return;
		}
		if(escolha == 3) {
			alterarVeiculo();
			return;
		}
		if(escolha == 4) {
			venderVeiculo();
			return;
		}
	}

	private static void venderVeiculo() {
		listarEstoque();
		System.out.println("Informe o carro que deseja vender: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha < 0 || escolha > estoque.size()) {
			System.out.println("Informe um valor válido");
			return;
		}
		System.out.println("Venda realizada com sucesso");
		estoque.remove(escolha);
		
	}

	private static void alterarVeiculo() {
		listarEstoque();
		System.out.println("Informe o carro que deseja alterar: ");
		int escolha = scan.nextInt() - 1;
		scan.nextLine();
		if(escolha < 0 || escolha > estoque.size()) {
			System.out.println("Informe um valor válido");
			return;
		}
		Veiculo veiculo = estoque.get(escolha);
		System.out.println("Informe a cor do veiculo:");
		veiculo.setCor(scan.nextLine());
		System.out.println("Informe o modelo do veiculo:");
		veiculo.setModelo(scan.nextLine());
		System.out.println("Informe a placa do veiculo:");
		veiculo.setPlaca(scan.nextLine());
		System.out.println("Informe o ano do veiculo:");
		veiculo.setAno(scan.nextInt());
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

	private static void cadastrarVeiculo() {
		Veiculo veiculo = new Veiculo();
		System.out.println("Informe a cor do veiculo:");
		veiculo.setCor(scan.nextLine());
		System.out.println("Informe o modelo do veiculo:");
		veiculo.setModelo(scan.nextLine());
		System.out.println("Informe a placa do veiculo:");
		veiculo.setPlaca(scan.nextLine());
		System.out.println("Informe o ano do veiculo:");
		veiculo.setAno(scan.nextInt());
		scan.nextLine();
		if(veiculo.getAno() < 1850 || veiculo.getCor().isBlank() || veiculo.getModelo().isBlank() || veiculo.getPlaca().isBlank()) {
			System.out.println("Dados inválidos!");
			return;
		}
		estoque.add(veiculo);
	}

	private static void inicializarEstoque() {
		estoque.add(new Veiculo("Branco", "MLC-1G32", "Linea", 2013));
		estoque.add(new Veiculo("Preto", "CCC-6666", "Uno", 2001));
	}
	
	
	

}
