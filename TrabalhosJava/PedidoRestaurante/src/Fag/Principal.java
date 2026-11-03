package Fag;

import java.util.Scanner;

import Fag.Objeto.Pedido;

public class Principal {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Digite o nome do cliente: ");
		String nome = scan.nextLine();

		Pedido pedido = new Pedido(nome);

		System.out.println("Digite a quantidade de lanches: ");
		int quantidade = scan.nextInt();

		pedido.adicionarLanches(quantidade);

		System.out.println("Digite outra quantidade de lanches: ");
		quantidade = scan.nextInt();

		pedido.adicionarLanches(quantidade);

		System.out.println();
		pedido.exibirPedido();

		System.out.println();
		System.out.println("Total do pedido: R$ " + pedido.calcularTotal());

		System.out.println();
		pedido.finalizarPedido();

		System.out.println();
		System.out.println("Tentando adicionar mais um lanche...");
		pedido.adicionarLanches(1);

		scan.close();
	}
}