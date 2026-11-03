package Fag.Objeto;

public class Cofrinho {

	private String dono;
	private double saldo;
	private double metaEconomia;

	public Cofrinho(String dono, double metaEconomia) {
		this.dono = dono;
		this.metaEconomia = metaEconomia;
		saldo = 0;
	}

	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.println("Deposito realizado.");
		} else {
			System.out.println("O valor deve ser positivo.");
		}
	}

	public void retirar(double valor) {
		if (valor > saldo) {
			System.out.println("Saldo insuficiente.");
		} else if (valor > 0) {
			saldo -= valor;
			System.out.println("Retirada realizada.");
		} else {
			System.out.println("O valor deve ser positivo.");
		}
	}

	public void verificarMeta() {
		if (saldo >= metaEconomia) {
			System.out.println("Meta atingida!");
		} else {
			double falta = metaEconomia - saldo;
			System.out.println("Faltam R$ " + falta + " para atingir a meta.");
		}
	}

	public void exibirSaldo() {
		System.out.println("Dono: " + dono);
		System.out.println("Saldo: R$ " + saldo);
		System.out.println("Meta: R$ " + metaEconomia);
	}
}