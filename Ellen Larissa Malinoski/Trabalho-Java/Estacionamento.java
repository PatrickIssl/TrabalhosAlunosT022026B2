
public class Estacionamento {
String placa;
String modelo;
int minutosEstacionados;
double valor;
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
public int getMinutosEstacionados() {
	return minutosEstacionados;
}
public void setMinutosEstacionados(int minutosEstacionados) {
	this.minutosEstacionados = minutosEstacionados;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}
public void adicionarTempo(int minutos) {
	if(minutos >= 0) {
	minutosEstacionados += minutos;
	} else {
		System.out.print("tempo invalido");
	}
}
	public void calcularValor() {
	    if (minutosEstacionados <= 30) {
	        valor = 5.00;
	    } else {
	        valor = 5.00 + (minutosEstacionados - 30) * 0.10;
	    }

	    if (valor > 30.00) {
	        valor = 30.00;
	    }
	}

	public void exibirResumo() {
	    calcularValor();
	    System.out.println("Placa: " + placa);
	    System.out.println("Modelo: " + modelo);
	    System.out.println("Minutos: " + minutosEstacionados);
	    System.out.printf("Valor: R$ %.2f%n", valor);
	}
}

