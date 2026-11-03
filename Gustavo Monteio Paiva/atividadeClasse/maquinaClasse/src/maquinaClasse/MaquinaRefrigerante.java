package maquinaClasse;

public class MaquinaRefrigerante {
	int quantidadeEstoque;
	double produto;
	int quantidade;
	double saldo;
	public MaquinaRefrigerante(){
		quantidadeEstoque = 5;
		 produto = 4.50;
	}
	
	public void reporEstoque(int quantidade) {
		if(quantidade > 0) {
			quantidadeEstoque =+ quantidade;
		}
		else {
			System.out.println("Insira uma quantidade valida");
			
		}
	}
	public void comprar(int quantidade,double valorPago){
		if (quantidadeEstoque >= 0) {
			valorPago = produto * quantidade;
			saldo = saldo - valorPago;
		}
		if (valorPago > saldo) {
			System.out.println("Saldo invalido");
		}
	}
	
}
