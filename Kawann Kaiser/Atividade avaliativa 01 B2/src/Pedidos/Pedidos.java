
package Pedidos;

public class Pedidos {

    String nomeCliente;
    int quantidadeLanches;
    double precoLanche = 18.00;
    double taxaEntrega = 7.00;
    boolean status = true;
    boolean entrega = false;

    void adicionarLanches(int quantidade) {

        if (status == true) {
            if (quantidade > 0) {
                quantidadeLanches = quantidadeLanches + quantidade;
                System.out.println("Adicionados " + quantidade + " lanches");
            }
            else {
                System.out.println("Informe uma quantidade valida");
            }
        }
        else {
            System.out.println("Pedido finalizado! Nao e possivel adicionar lanches");
        }
    }

    void calcularTotal() {

        double total = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            total = total - (total * 0.10);
            System.out.println("Desconto de 10% aplicado!");
        }

        if (entrega == true) {
            total = total + taxaEntrega;
            System.out.println("Taxa de entrega aplicada: R$ 7,00");
        }
        else {
            System.out.println("Retirada no local, sem taxa de entrega");
        }

        System.out.printf("Valor total: R$ %.2f%n", total);
    }

    void finalizarPedido() {

        if (status == true) {
            if (quantidadeLanches > 0) {
                status = false;
                System.out.println("Pedido finalizado com sucesso!");
            }
            else {
                System.out.println("Adicione lanches antes de finalizar");
            }
        }
        else {
            System.out.println("Pedido ja finalizado!");
        }
    }

    void exibirPedido() {

        System.out.println("\n===== RESUMO DO PEDIDO =====");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);

        if (status == true) {
            System.out.println("Status: Aberto");
        }
        else {
            System.out.println("Status: Finalizado");
        }

        calcularTotal();
    }
}
