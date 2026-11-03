package Fag;

import java.util.Scanner;
import Fag.Objeto.MaquinaRefrigerante;

public class Principal {
	
	public static void main(String[] args) {
		int quantidade, opcao = 0;
		
		Scanner scan = new Scanner(System.in);
		MaquinaRefrigerante maqRefri = new MaquinaRefrigerante();
		
		while (opcao != 4) {
			opcao = maqRefri.menu();
			if (opcao == 1) {
				System.out.println("Entre com quantidade de refrigerante");
				quantidade = scan.nextInt();
				System.out.println("Valor a pagar: R$" + (quantidade * 4.5));
				System.out.println("Entre  com o valor pago");
				maqRefri.comprar(quantidade, scan.nextDouble());
			}
			
			if (opcao == 2) {
				System.out.println("Entre com a quantidade que deseja repor no estoque:");
				quantidade = scan.nextInt();
				maqRefri.reporEstoque(quantidade);
			}
			
			if (opcao == 3) {
				maqRefri.exibirEstado();
			}
			
			quantidade = 0;
		}
		scan.close();
	}
}