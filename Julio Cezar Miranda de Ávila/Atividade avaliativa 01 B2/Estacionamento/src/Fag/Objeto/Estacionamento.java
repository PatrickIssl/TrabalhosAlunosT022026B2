package Fag.Objeto;

public class Estacionamento {
	
	private String placa, modelo;
	private double  valorPago;
	private int minutosEstacionado;
	
	public Estacionamento() {
	}
	
	public void setModelo(String modelo) {
		if(modelo != null && !modelo.isBlank()) {
			this.modelo = modelo;
		}
	}
	
	public void setPlaca(String placa) {
		if(placa != null && !placa.isBlank()) {
			this.placa = placa;
	    }
   }
	
	public void adicionarTempo(int minutosEstacionado) {
		if (minutosEstacionado >= 0) {
			this.minutosEstacionado += minutosEstacionado;
		}
	}
	
	public void calcularValor() {
		if (minutosEstacionado <= 30) {
			valorPago = 5; 
		} else {
			int temp = minutosEstacionado - 30;
		    valorPago = 5 + ( temp * 0.10 );
			
		    if (valorPago > 30) {
		    	valorPago = 30;
		    }
		}
	}
	
	public void exibirResumo() {
		System.out.println("Modelo: " + modelo);
		System.out.println("Placa: " + placa);
		System.out.println("Minutos estacionado: " + minutosEstacionado);
		System.out.println("Valor a pagar: " + valorPago);
	}
}
	

