package Fag.Objeto;

public class MaquinaRefrigerante {

	private int quantidadeEstoque;
	private double preco;
	private double dinheiroArrecadado;

	public MaquinaRefrigerante() {
		quantidadeEstoque = 10;
		preco = 4.50;
		dinheiroArrecadado = 0;
	}

	public void comprar(int quantidade, double valorPago) {

		double valorCompra = quantidade * preco;

		if (quantidade <= 0) {
			System.out.println("Quantidade invalida.");
		} else if (quantidade > quantidadeEstoque) {
			System.out.println("Nao ha refrigerantes suficientes no estoque.");
		} else if (valorPago < valorCompra) {
			System.out.println("Dinheiro insuficiente.");
			System.out.println("Valor necessario: R$ " + valorCompra);
		} else {

			quantidadeEstoque -= quantidade;
			dinheiroArrecadado += valorCompra;

			double troco = valorPago - valorCompra;

			System.out.println("Compra realizada com sucesso!");
			System.out.println("Quantidade: " + quantidade);
			System.out.println("Valor da compra: R$ " + valorCompra);
			System.out.println("Troco: R$ " + troco);
		}
	}

	public void reporEstoque(int quantidade) {

		if (quantidade > 0) {
			quantidadeEstoque += quantidade;
			System.out.println("Estoque reposto com sucesso!");
		}
	}

	public void exibirEstado() {

		System.out.println("Quantidade em estoque: " + quantidadeEstoque);
		System.out.println("Preco do refrigerante: R$ " + preco);
		System.out.println("Dinheiro arrecadado: R$ " + dinheiroArrecadado);
	}
}