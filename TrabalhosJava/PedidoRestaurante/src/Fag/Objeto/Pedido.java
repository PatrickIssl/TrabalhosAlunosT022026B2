package Fag.Objeto;

public class Pedido {

	private String nomeCliente;
	private int quantidadeLanches;
	private double precoLanche;
	private double taxaEntrega;
	private String status;

	public Pedido(String nomeCliente) {
		this.nomeCliente = nomeCliente;
		precoLanche = 18.00;
		taxaEntrega = 7.00;
		quantidadeLanches = 0;
		status = "Aberto";
	}

	public void adicionarLanches(int quantidade) {
		if (status.equals("Finalizado")) {
			System.out.println("O pedido ja foi finalizado.");
		} else if (quantidade > 0) {
			quantidadeLanches += quantidade;
			System.out.println("Lanches adicionados.");
		} else {
			System.out.println("A quantidade deve ser positiva.");
		}
	}

	public double calcularTotal() {
		double valorLanches = quantidadeLanches * precoLanche;

		if (quantidadeLanches >= 3) {
			valorLanches = valorLanches * 0.90;
		}

		return valorLanches + taxaEntrega;
	}

	public void finalizarPedido() {
		if (status.equals("Finalizado")) {
			System.out.println("O pedido ja esta finalizado.");
		} else {
			status = "Finalizado";
			System.out.println("Pedido finalizado.");
		}
	}

	public void exibirPedido() {
		System.out.println("Cliente: " + nomeCliente);
		System.out.println("Quantidade de lanches: " + quantidadeLanches);
		System.out.println("Taxa de entrega: R$ " + taxaEntrega);
		System.out.println("Total: R$ " + calcularTotal());
		System.out.println("Status: " + status);
	}
}