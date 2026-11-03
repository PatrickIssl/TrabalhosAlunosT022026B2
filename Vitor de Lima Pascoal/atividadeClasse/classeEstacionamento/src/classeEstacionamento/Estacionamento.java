package classeEstacionamento;

public class Estacionamento {
	String placa;
	String modelo;
	int minutosEstacionados;
	double valorPago;

	
	public void adicionarTempo(int minutos) {
		if(minutos >= 0) {
			minutosEstacionados += minutos;
		}
		else {
			System.out.println("Insira um valor positivo");
		}
	}
	
	 public void calcularValor() {
		if(minutosEstacionados <= 30 && minutosEstacionados >= 0) {
			valorPago = 5;
		}
		if(minutosEstacionados > 30) {
			valorPago = 5.00 + (minutosEstacionados - 30) * 0.10;
			
		}
		if(valorPago > 30) {
			valorPago = 30;	
		}
		else {
			System.out.println("Valor invalido");
		}
	
	}
	
	public void resumo() {
		System.out.printf("Placa :" + placa);
		System.out.printf("\nModelo: " + modelo);
		System.out.println("\nMinutos estacionados: " + minutosEstacionados);
		System.out.println("Valor a pagar:" + valorPago);
	}
	
}
