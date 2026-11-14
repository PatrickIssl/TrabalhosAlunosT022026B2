package Estacionamento;

public class Estacionamento {
	
	String placa;
	String modelo;
	int minutos = 0;
	double valorPago = 0;
	
	void adcionartempo(int valor) {
		if(valor > 0) {
			
			minutos = minutos + valor;
			System.out.println("O valor foi somado ao tempo estacionado");
			
		}else {
			
			System.out.println("Informe um valor valido");
			
		}
		
			
	}
	void calcularPagamemto() {
		if(minutos<=30) {
			
			valorPago = 5;
			
		}else {
			
			int temp = minutos - 30;
			valorPago = 5 + (temp * 0.10);
			
			if(valorPago > 30) {
				valorPago = 30.00;
			}
		}
		System.out.println("valor a pagar:" + valorPago);
	}
	
	void exibirResultado() {
		System.out.println("O veiculo:" + modelo);
		System.out.println("Com placa :"+ placa);
		System.out.println("Tempo estacionado " + minutos +" minutos");
		System.out.println("Valor a pagar: "+ valorPago+ "\n");
	}
	
	
}
