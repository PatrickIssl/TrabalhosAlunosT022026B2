package pedidoRestaurante;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Maria Souza");

        pedido.adicionarLanches(2);   
        pedido.adicionarLanches(1);   

        System.out.printf("Total calculado: R$ %.2f%n", pedido.calcularTotal());

        pedido.finalizarPedido();
        pedido.exibirPedido();

        System.out.println("Tentando adicionar mais um lanche após a finalização...");
        boolean permitido = pedido.adicionarLanches(1);
        System.out.println("Operação permitida? " + (permitido ? "Sim" : "Não"));
    }
}