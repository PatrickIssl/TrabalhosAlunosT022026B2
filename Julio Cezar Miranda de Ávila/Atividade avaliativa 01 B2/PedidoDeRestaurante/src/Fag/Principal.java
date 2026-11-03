package Fag;

import java.util.Scanner;

import Fag.objeto.Pedido;

public class Principal {
	
	public static void main(String[] args) {
		int opcao;
		Scanner scan = new Scanner(System.in);
		Pedido pedido = new Pedido();
		
		do {
			pedido.menu();
			opcao = scan.nextInt();
			
			if (opcao == 1) {
				scan.nextLine();
				System.out.println("Entre com o nome do cliente:");
				pedido.setNomeCliente(scan.nextLine());
			}
			
			if (opcao == 2) {
				System.out.println("Entre com a quantidade que deseja adicionar:");
				pedido.adicionarLanches(scan.nextInt());
			}
			
			if (opcao == 3) {
				pedido.calcularTotal();
			}
			
			if (opcao == 4) {
				pedido.exibirPedido();
			}
			
			if (opcao == 5) {
				pedido.finalizarPedido();
			}
		} while (opcao != 0);
		scan.close();
	}
}
