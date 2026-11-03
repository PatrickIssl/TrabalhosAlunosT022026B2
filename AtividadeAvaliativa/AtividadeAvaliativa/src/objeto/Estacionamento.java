package objeto;

public class Estacionamento {
	private String placa;
	private String modelo;
	private int minutosEstacionado;
	private double valorPago;

	public Estacionamento() {
	}

	public String getPlaca() {

		return placa;
	}

	public void setPlaca(String placa) {
		if (placa != null&& ! placa.isBlank()) {
			this.placa = placa;
		}else {
			System.out.println("Informe o valor valido!");
		}

	}

	public String getModelo(){
		return this.modelo;
	}

	public void setModelo(String modelo) {
		if (modelo != null&& ! modelo.isBlank()) {
			this.modelo = modelo;
		}else {
			System.out.println("Informe um modelo valido!");
		}
	}

	public int getMinutosEstacionado() {
		return minutosEstacionado;
	}

	public void setMinutosEstacionado(int minutosEstacionado) {
		if (minutosEstacionado > 0 ) {
			this.minutosEstacionado = minutosEstacionado;
		}else {
			System.out.println("O valor nao pode ser zero nem negativo");
		}

	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		if (valorPago > 0 ) {
			this.valorPago = valorPago;
		}
	}
	
	public void adicionarTempo(int minutos){
		this.minutosEstacionado = minutos;
	}
	public void calcularValor() {
		int minutos= this.minutosEstacionado;
		if (minutos <= 30) {
			this.valorPago = 05;
		}else if (minutos>30) {
			minutos = minutos-30;
			this.valorPago= 5+(minutos * 0.10);
			if(this.valorPago > 30) {
				this.valorPago = 30;
			}

		}
	}
	public void exibirResultado() {
		System.out.println("Placa: "+this.placa+" Modelo: "+this.modelo+" Tempo: "+this.minutosEstacionado+" Valor a pagar:"+this.valorPago);
	}
}
