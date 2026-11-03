package classeEstacionamento;

public class Principal {
	
	public static void main(String[] args) {
		Estacionamento carro = new Estacionamento();
		carro.placa = "12345";
		carro.modelo = "C3";
		carro.adicionarTempo(40);
		carro.calcularValor();
		carro.resumo();
		
	}

}
