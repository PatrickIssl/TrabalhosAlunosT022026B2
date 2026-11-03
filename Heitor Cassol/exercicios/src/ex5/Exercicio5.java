package ex5;
public class Exercicio5 {

    String nomeCliente;
    int quantidadeLanches;
    double precoLanche;
    double taxaEntrega;
    String status;

    public Exercicio5(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.quantidadeLanches = 0;
        this.precoLanche = 18.00;
        this.taxaEntrega = 7.00;
        this.status = "Em andamento";
    }

    public void adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("O pedido já foi finalizado!");
        } else if (quantidade > 0) {
            quantidadeLanches += quantidade;
            System.out.println("Lanches adicionados com sucesso!");
        } else {
            System.out.println("Quantidade inválida!");
        }
    }

    public double calcularTotal() {
        double total = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            total = total - (total * 0.10);
        }

        total += taxaEntrega;

        return total;
    }

    public void finalizarPedido() {
        status = "Finalizado";
        System.out.println("Pedido finalizado!");
    }

    public void exibirPedido() {
        System.out.println("\n--- DADOS DO PEDIDO ---");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.println("Preço por lanche: R$ " + precoLanche);
        System.out.println("Taxa de entrega: R$ " + taxaEntrega);
        System.out.printf("Total do pedido: R$ %.2f%n", calcularTotal());
        System.out.println("Status: " + status);
    }

    public static void main(String[] args) {
        Exercicio5 pedido = new Exercicio5("João");

        pedido.adicionarLanches(3);
        pedido.exibirPedido();

        pedido.finalizarPedido();

        pedido.adicionarLanches(1);
        pedido.exibirPedido();
    }
}