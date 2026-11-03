
public class Pedido {
    String nomeCliente;
    int quantidadeLanches;
    double precoLanche;
    double taxaEntrega;
    String status;

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.quantidadeLanches = 0;
        this.precoLanche = 18.00;
        this.taxaEntrega = 7.00;
        this.status = "Aberto";
    }

    public void adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Pedido finalizado! Nao e possivel adicionar lanches.");
        } else if (quantidade > 0) {
            quantidadeLanches += quantidade;
            System.out.println("Lanches adicionados com sucesso!");
        } else {
            System.out.println("A quantidade deve ser positiva!");
        }
    }

    public double calcularTotal() {
        double total = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            total = total - (total * 0.10);
        }

        return total + taxaEntrega;
    }

    public void finalizarPedido() {
        status = "Finalizado";
        System.out.println("Pedido finalizado!");
    }

    public void exibirPedido() {
        System.out.println("\n--- RESUMO DO PEDIDO ---");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
        System.out.println("Status: " + status);
    }
}
