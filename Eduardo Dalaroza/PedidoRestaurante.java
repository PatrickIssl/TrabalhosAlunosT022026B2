class Pedido {
    String nomeCliente;
    int quantidadeLanches;
    double precoLanche;
    double taxaEntrega;
    String status;

    Pedido(String cliente) {
        nomeCliente = cliente;
        quantidadeLanches = 0;
        precoLanche = 18.0;
        taxaEntrega = 7.0;
        status = "aberto";
    }

    void adicionarLanches(int quantidade) {
        if (status.equals("finalizado")) {
            System.out.println("Nao foi possivel adicionar: o pedido ja foi finalizado.");
        } else {
            quantidadeLanches = quantidadeLanches + quantidade;
            System.out.println(quantidade + " lanche(s) adicionado(s).");
        }
    }

    double calcularTotal() {
        double valorLanches = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            double desconto = valorLanches * 0.10;
            valorLanches = valorLanches - desconto;
        }

        double total = valorLanches + taxaEntrega;
        return total;
    }

    void finalizarPedido() {
        status = "finalizado";
        System.out.println("Pedido finalizado!");
    }

    void exibirPedido() {
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Lanches: " + quantidadeLanches);
        System.out.println("Status: " + status);
        System.out.printf("Total: R$ %.2f\n", calcularTotal());
    }
}

public class PedidoRestaurante {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Maria");

        pedido.adicionarLanches(2);
        pedido.adicionarLanches(1);

        pedido.finalizarPedido();
        pedido.exibirPedido();

        pedido.adicionarLanches(1);
    }
}
