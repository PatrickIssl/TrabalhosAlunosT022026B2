package MaquinaRefri;

public class MaquinaRefri {

	int quantEstoque;
	int quantVendas;
	double preco = 4.50;
	double valorArrecadado;
	
	void comprar(int quant, double valorPago ) {
		if(quant > 0) {
			if(quant <= quantEstoque && valorPago >= (quant*preco)) {

				quantEstoque = quantEstoque-quant;
				double troco = valorPago - (preco * quant);
				valorArrecadado = valorArrecadado + (valorPago - troco);
				quantVendas = quantVendas+quant;
				System.out.println("Refrigerantes Liberados : "+quant+" \n Dinheiro Recebido");
				if (troco > 0) {
					System.out.printf("Seu troco é: R$ %.2f%n", troco);
				}

			}

			else {
				
				System.out.println("Confira o valor pago e quantidade desejada");

			}
		}
		else {
			
			System.out.println("Informe uma quantidade valida de refrigerantes");
		}

	}
		
	void reporEstoque(int quant) {
		if(quant > 0) {
			quantEstoque = quantEstoque+quant;
			System.out.println("Estoque abastecido com :"+ quant+" latas");
		}
		else {
			System.out.println("Informe uma quantidade valida para repor o estoque");
		}
	}
	
	void exibirStatusADM(boolean adm) {
		System.out.println("A maquina Possui : "+quantEstoque+" Latas");
		if(adm == true) {
			System.out.println("Foram vendidas : "+quantVendas+" Latas");
			System.out.printf("Valor arrecadado : R$ R$ %.2f%n", valorArrecadado);
		}
	}
	

}
