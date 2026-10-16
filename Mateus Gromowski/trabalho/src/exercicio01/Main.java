package exercicio01;

public class Main {

	public static void main(String[] args) {
		Estacionamento e = new Estacionamento("ARW3998", "Wolkswagen Gol", 30);
		e.calcularValor();
		e.exibirResumo();
		System.out.println("------------");
		e.adicionarTempo(10);
		e.calcularValor();
		e.exibirResumo();
	}

}
