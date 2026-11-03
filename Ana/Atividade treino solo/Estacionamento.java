


public class Estacionamento {

    private String placa;
    private String modelo;
    private int minutos;
    private double valor;
    
    public Estacionamento() {
    
    }

    public Estacionamento(String placa, String modelo) {
    	setPlaca(placa);
    	setModelo(modelo);
    }

    public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void adicionarTempo(int min) {
        if (min < 0) {
            System.out.println("O tempo não pode ser negativo.");
            return;
        }

        minutos += min;
        calcularValor();
    }

    public void calcularValor() {
        if (minutos <= 30) {
            valor = 5.00;
        } else {
            valor = 5.00 + (minutos - 30) * 0.10;
        }

        if (valor > 30.00) {
            valor = 30.00;
        }
    }

    public void exibirResumo() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Minutos: " + minutos);
        System.out.printf("Valor a pagar: %.2f%n", valor);
        
    }
}
