package Fag;

import java.util.Scanner;

import Fag.Objeto.Cofrinho;

public class Principal {
	
	public static void main(String[] args) {
		int opcao;
		Scanner scan = new Scanner(System.in);
		Cofrinho cofrinho = new Cofrinho();
		
		do {
			cofrinho.menu();
			opcao = scan.nextInt();
			
			if (opcao == 1) {
				scan.nextLine();
				System.out.println("Entre com o nome do dono do cofrinho:");
				cofrinho.setDono(scan.nextLine());
			}
			
			if (opcao == 2) {
				System.out.println("Entre com a meta economica:");
				cofrinho.setMetaEconomia(scan.nextDouble());
			}
			
			if (opcao == 3) {
				System.out.println("Entre com o valor que deseja depositar:");
				cofrinho.depositar(scan.nextDouble());
			}
			
			if (opcao == 4) {
				System.out.println("Entre com o valor que deseja retirar:");
				cofrinho.retirar(scan.nextDouble());
			}
			
			if (opcao == 5) {
				cofrinho.exibirSaldo();
			}
			
			if (opcao == 6) {
				cofrinho.verificarMeta();
			}
		} while (opcao != 0);
		scan.close();
	}
}
