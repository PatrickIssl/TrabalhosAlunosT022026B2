package Fag.Objeto;

import java.util.Scanner;

import Fag.MaquinaRefrigerante;

public class MaquinaRefrigerante {
	
	private int quantidadeEstoque = 0;
	private double preco = 4.5, dinheiroArrecadado;
	
	Scanner scan = new Scanner(System.in);
	
	public MaquinaRefrigerante() {
	}
	
	void conferenciaDeValores(double valorPago, double valorDaCompra) {
		while (valorPago < valorDaCompra) {
			System.out.println("Falta o valor de R$" + (valorDaCompra - valorPago));
			System.out.println("Entre com o valor faltante");
			valorPago += scan.nextDouble();
		}
		
		if (valorPago > valorDaCompra) {
			System.out.println("Troco: R$" + (valorPago - valorDaCompra));
		}
	}
	
	public void comprar(int quantidade, double valorPago) {
		double valorDaCompra = 0;
		int confirmacao = 0;
		
		if (quantidade > 0) {
			if (quantidadeEstoque < quantidade) {
				if (quantidadeEstoque > 0) {
					System.out.println("Não temos a quantidade desejada apenas " + quantidadeEstoque + " unidades, deseja essa quantidade (caso tenha entrado com mais do que valor saira o troco)");
					System.out.println("Precione 0 para NÃO, 1 para SIM:");
					confirmacao = scan.nextInt();
			
					if (confirmacao == 1) {
						valorDaCompra = quantidadeEstoque * preco;
				
						conferenciaDeValores(valorPago, valorDaCompra);
				
						dinheiroArrecadado += valorDaCompra;
						quantidadeEstoque = 0;	
					}
					else {
						System.out.println("Troco: R$" + valorPago);
					}
				}
				else {
					System.out.println("Estoque zerado tente novamente mais tarde");
					System.out.println("Troco: R$" + valorPago);
				}
			}
		
			else {
				valorDaCompra = quantidade * preco;
			
				conferenciaDeValores(valorPago, valorDaCompra);
			
				dinheiroArrecadado += valorDaCompra;
				quantidadeEstoque -= quantidade;
			}
			System.out.println("Atendimento finalizado!");
		}
		
		else {
			System.out.println("Informações incorretas, numeros negativos ou zerados");
			System.out.println("Troco: R$" + valorPago);
		}
	}
	
	public void reporEstoque(int quantidade) {
		if (quantidade > 0) {
			quantidadeEstoque += quantidade;
		}
	}
	
	public void exibirEstado() {
		System.out.println("--- Estado da Máquina ---");
		System.out.println("Quantidade em estoque: " + quantidadeEstoque);
		System.out.println("Preço: R$" + preco);
		System.out.println("Dinheiro arrecadado: R$" + dinheiroArrecadado);
	}
	
	public int menu() {
		int opcao;
		System.out.printf("\n--- Menu ---\n");
		System.out.println("1 - Comprar");
		System.out.println("2 - Repor Estoque");
		System.out.println("3 - Exibir Estado");
		System.out.println("4 - Sair");
		System.out.printf("\nEntre com o numero da opção desejada:\n");
		opcao = scan.nextInt();
		return opcao;
	}
}
