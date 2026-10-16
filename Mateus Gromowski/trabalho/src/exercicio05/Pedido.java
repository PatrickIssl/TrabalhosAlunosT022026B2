package exercicio05;

public class Pedido {
	private String nomeCliente;
	private int quantidadeLanches;
	private double precoLanches;
	private double taxaEntrega = 7.0;
	private String status = "Pedido Aceito";
	 
	public Pedido(String nomeCliente) {
		super();
		this.nomeCliente = nomeCliente;
	}

	public void adicionarLanches(int quantidade) {
		if(status.equals("Finalizado")) {
			System.out.println("Pedidos finalizados não podem adicionar lanches.");
			return;
		}
		quantidadeLanches += quantidade;
		double desconto = 0;
		if(quantidade >= 3) {
			for(int i = 0; i < quantidade; i++) {
				desconto += 0.1;
			}
		}
		if(desconto > 0) {
			precoLanches += (quantidadeLanches * 18) * desconto;
		} else {
			precoLanches += (quantidadeLanches * 18);
		}
	}
	
	public double calcularTotal() {
		return precoLanches + taxaEntrega;
	}
	
	public void finalizarPedido() {
		status = "Finalizado";
	}
	
	public void exibirPedido() {
		System.out.println("Nome: " + nomeCliente + " Total à pagar = " + calcularTotal() + " Quantidade de lanches = " + quantidadeLanches + " Preço dos lanches = " + precoLanches + " Taxa de entrega = " + taxaEntrega);
	}
}
