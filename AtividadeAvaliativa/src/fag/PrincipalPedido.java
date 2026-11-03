package fag;

import objeto.Pedido;

public class PrincipalPedido {

	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		pedido.setNomeCliente("Gustavo");
		pedido.setPrecoLanches(18);
		pedido.setTaxaEntrega(7);
		pedido.adicionarLanches(5);
		pedido.calcularTotal();
		pedido.finalizarPedido();
		pedido.exibirPedido();
		pedido.adicionarLanches(5);

	}

}
