package exercicio05;

public class Main {

	public static void main(String[] args) {
		Pedido p = new Pedido("Mateus Planowski");
		
		p.adicionarLanches(2);
		p.adicionarLanches(2);
		p.finalizarPedido();
		p.exibirPedido();
		p.adicionarLanches(1);
		
	}

}
