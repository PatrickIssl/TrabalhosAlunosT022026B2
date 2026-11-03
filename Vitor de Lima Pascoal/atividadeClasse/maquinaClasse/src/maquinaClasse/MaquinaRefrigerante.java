package maquinaClasse;

public class MaquinaRefrigerante {
	int quantidadeEstoque;
	double produto;
	double saldo;
	
	public MaquinaRefrigerante(){
		quantidadeEstoque = 5;
		produto = 4.50;
	}
	
	public void reporEstoque(int quantidadeRepor) {
		if(quantidadeRepor > 0) {
			quantidadeEstoque = quantidadeEstoque + quantidadeRepor;
		}
		else {
			System.out.println("Insira uma quantidade valida");
			
		}
	}
	public void comprar(int quantidadeCompra,double valorPago){
		double valorTotal = produto * quantidadeCompra;
		if (quantidadeEstoque >= 0 && quantidadeEstoque >= quantidadeCompra) {
				if (valorPago >= valorTotal) {
					double troco =+(valorPago - valorTotal);
					quantidadeEstoque = (quantidadeEstoque - quantidadeCompra);
					saldo = saldo + valorTotal;
					System.out.println("Troco: " + troco);
				}
				else {
					System.out.println("Saldo invalido");
				}
	
		}
		else {
			System.out.println("Estoque insuficiente");
		}
}
	
	public void exibirEstado() {
		System.out.println("Estoque:" + quantidadeEstoque);
		System.out.println("Saldo: " + saldo);
	}
	
	
	
	
	
	
	
}	
