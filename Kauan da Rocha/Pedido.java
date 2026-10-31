public class Pedido {

    // atributos
    String nomeCliente;
    int quantidadeLanches;
    double precoLanche;
    double taxaEntrega;
    String status;

    // construtor
    Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        quantidadeLanches = 0;
        precoLanche = 18.0;
        taxaEntrega = 7.0;
        status = "Aberto";
    }

    // retorna true se deu certo e false se nao pode adicionar
    boolean adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            return false;
        }
        if (quantidade <= 0) {
            return false;
        }
        quantidadeLanches = quantidadeLanches + quantidade;
        return true;
    }

    double calcularTotal() {
        double lanches = quantidadeLanches * precoLanche;

        // 3 ou mais lanches tem 10% de desconto
        if (quantidadeLanches >= 3) {
            lanches = lanches * 0.9;
        }

        double total = lanches + taxaEntrega;
        return total;
    }

    void finalizarPedido() {
        status = "Finalizado";
        System.out.println("Pedido finalizado!");
    }

    void exibirPedido() {
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Lanches: " + quantidadeLanches);
        System.out.println("Preco de cada lanche: R$ " + precoLanche);
        System.out.println("Taxa de entrega: R$ " + taxaEntrega);
        System.out.println("Status: " + status);
        System.out.println("Total: R$ " + calcularTotal());
        System.out.println("-------------------");
    }
}
