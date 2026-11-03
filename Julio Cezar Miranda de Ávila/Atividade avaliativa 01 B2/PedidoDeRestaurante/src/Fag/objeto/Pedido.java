package Fag.objeto;

public class Pedido {
	private String nomeCliente;
	private int quantidadeLanches;
	private double precoLanche = 18, taxaEntrega = 7, total;
	private boolean finalizado = false; // igual a status
	
	public Pedido() {
	}
	
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public void adicionarLanches(int quantidade){
		if (quantidade > 0 && finalizado == false) {
			quantidadeLanches += quantidade;
		}
		if (quantidade <= 0) {
			System.out.println("Valor invalido");
		}
		if (finalizado == true) {
			System.out.println("Pedido já finalizado iposivel fazer alteração!");
		}
	}
	
	public void calcularTotal() {
		total = quantidadeLanches * precoLanche;
		if (quantidadeLanches >= 3) {
			total *= 0.9;
		}
		total += taxaEntrega;
		System.out.println("Total: R$" + total);
	}
	
	public void finalizarPedido() {
		finalizado = true;
		System.out.println("Pedido finalizado com sucesso!");
	}
	
	public void exibirPedido() {
		System.out.println("--- Pedido ---");
		System.out.println("Nome do cliente: " + nomeCliente);
		System.out.println("Quantidade de lanche: " + quantidadeLanches);
		System.out.println("Valor por lanche: R$" + precoLanche);
		System.out.println("Taxa de entrega: R$" + taxaEntrega);
		if (quantidadeLanches > 3) {
			System.out.println("Desconto de 10% aplicado!");
		}
		calcularTotal();
		if (finalizado == true) {
			System.out.println("Status: Finalizado");
		}
		else {
			System.out.println("Status: Em produção");
		}
	}
	
	public void menu() {
		System.out.printf("\n--- Menu ---\n");
		System.out.println("1 - Alterar nome do cliente");
		System.out.println("2 - Adicionar lanches");
		System.out.println("3 - Calcular total");
		System.out.println("4 - Exibir pedidol");
		System.out.println("5 - Finalizar pedido");
		System.out.println("0 - Sair");
		System.out.printf("\nEntre com o numero da opção desejada:\n");
	}
}
