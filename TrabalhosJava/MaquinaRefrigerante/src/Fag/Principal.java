package Fag;

import java.util.Scanner;

import Fag.Objeto.MaquinaRefrigerante;

public class Principal {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		MaquinaRefrigerante maquina = new MaquinaRefrigerante();
		maquina.exibirEstado();
		System.out.println("\n PRIMEIRA COMPRA");
		System.out.println("Insira a quantidade de refrigerantes: ");
		int quantidade = scan.nextInt();
		System.out.println("Insira o valor pago: ");
		double valorPago = scan.nextDouble();
		maquina.comprar(quantidade, valorPago);
		System.out.println("\n SEGUNDA COMPRA");
		System.out.println("Insira a quantidade de refrigerantes: ");
		quantidade = scan.nextInt();
		System.out.println("Insira o valor pago: ");
		valorPago = scan.nextDouble();
     	maquina.comprar(quantidade, valorPago);
		maquina.exibirEstado();
		scan.close();
	}
}