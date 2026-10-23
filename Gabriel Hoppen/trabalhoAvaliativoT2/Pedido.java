import java.util.Scanner;

public class Pedido {
    private static Scanner scanner = new Scanner(System.in);

    private String nomeCliente;
    private int quantidadeLanches;
    private double precoLanche = 18.00;
    private double taxaEntrega = 7.00;
    private String status = "Em andamento";

    public void adicionarLanches(int quantidade) {
        if (status.equals("Finalizado")) {
            System.out.println("Operação não permitida: pedido já finalizado.");
            return;
        }
        quantidadeLanches += quantidade;
    }

    public double calcularTotal() {
        double total = 0;
        if (quantidadeLanches >= 3) {
            total = (quantidadeLanches - (quantidadeLanches * 0.1)) * precoLanche + taxaEntrega;
        } else {
            total = quantidadeLanches * precoLanche + taxaEntrega;
        }
        return total;
    }

    public void finalizarPedido() {
        status = "Finalizado";
        exibirPedido();
        System.out.println("Pedido finalizado.");
    }

    public void exibirPedido() {
        System.out.println("Nome do cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);
        System.out.println("Preço do lanche: R$ " + precoLanche);
        System.out.println("Taxa de entrega: R$ " + taxaEntrega);
        System.out.println("Status do pedido: " + status);
    }

    public static void main(String[] args) {
        Pedido pedido = new Pedido();

        System.out.println("Digite o nome do cliente:");
        pedido.nomeCliente = scanner.nextLine();

        System.out.println("Quantos lanches deseja pedir?");
        pedido.adicionarLanches(scanner.nextInt());

        System.out.println("Deseja adicionar mais algum lanche? (Digite 1 para sim ou 0 para não)");
        int adicionarMais = scanner.nextInt();
        while (adicionarMais == 1) {
            System.out.println("Quantos lanches deseja adicionar?");
            pedido.adicionarLanches(scanner.nextInt());
            System.out.println("Deseja adicionar mais algum lanche? (Digite 1 para sim ou 0 para não)");
            adicionarMais = scanner.nextInt();
        }

        System.out.printf("O preço final do pedido é: R$ %.2f%n", pedido.calcularTotal());

        pedido.finalizarPedido();

        System.out.println("Tentando adicionar mais um lanche...");
        pedido.adicionarLanches(1);
    }
}