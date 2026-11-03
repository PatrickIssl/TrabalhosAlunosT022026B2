package pedidoRestaurante;

public class Pedido {
    private String nomeCliente;
    private int quantidadeLanches;
    private double precoLanche;
    private double taxaEntrega;
    private String status;

    public Pedido(String nome) {
        nomeCliente = nome;
        quantidadeLanches = 0;
        precoLanche = 18.00;
        taxaEntrega = 7.00;
        status = "Aberto";
    }

    public boolean adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Operação não permitida: o pedido já foi finalizado.");
            return false;
        }
        if (quantidade <= 0) {
            System.out.println("Operação não permitida: a quantidade deve ser maior que zero.");
            return false;
        }
        quantidadeLanches += quantidade;
        System.out.println(quantidade + " lanche(s) adicionado(s) com sucesso.");
        return true;
    }

    public double calcularTotal() {
        double valorLanches = quantidadeLanches * precoLanche;
        if (quantidadeLanches >= 3) {
            valorLanches *= 0.90; 
        }
        return valorLanches + taxaEntrega;
    }

    public void finalizarPedido() {
        if (status.equals("Finalizado")) {
            System.out.println("O pedido já estava finalizado.");
        } else {
            status = "Finalizado";
            System.out.println("Pedido finalizado com sucesso.");
        }
    }

    public void exibirPedido() {
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.printf("Preço do lanche: R$ %.2f%n", precoLanche);
        System.out.printf("Taxa de entrega: R$ %.2f%n", taxaEntrega);
        System.out.println("Status: " + status);
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
    }

}