
package Principal;

import java.util.Scanner;

public class atividadeRestaurante {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();

        Pedido pedido = new Pedido(nomeCliente);

        System.out.println("\nNovo pedido");

        int quantidade;

        do {
            System.out.print("Quantos lanches voce vai querer? ");
            quantidade = sc.nextInt();

            if (quantidade <= 0) {
                System.out.println("A quantidade deve ser maior que zero.");
            }

        } while (quantidade <= 0);

        pedido.adicionarLanches(quantidade);

        int opcao;

        do {
            System.out.println("\nDeseja adicionar mais alguma coisa?");
            System.out.println("1 - Sim");
            System.out.println("0 - Nao");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            while (opcao != 0 && opcao != 1) {
                System.out.println("Opcao invalida! Digite 1 ou 0.");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
            }

            if (opcao == 1) {

                do {
                    System.out.print("Quantos lanches deseja adicionar? ");
                    quantidade = sc.nextInt();

                    if (quantidade <= 0) {
                        System.out.println(
                            "A quantidade deve ser maior que zero."
                        );
                    }

                } while (quantidade <= 0);

                pedido.adicionarLanches(quantidade);
            }

        } while (opcao == 1);

        System.out.println("\nResumo do pedido");
        pedido.exibirPedido();

        System.out.println("\nFinalizando o pedido...");
        pedido.finalizarPedido();

        System.out.println("\nTentando adicionar mais um lanche...");
        pedido.adicionarLanches(1);

        System.out.println("\nPedido final");
        pedido.exibirPedido();

        sc.close();
    }
}

class Pedido {

    String nomeCliente;
    int quantidadeLanches = 0;
    double precoLanche = 18.00;
    double taxaEntrega = 7.00;
    String status = "Em aberto";

    public Pedido(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void adicionarLanches(int quantidade) {

        if (status.equals("Finalizado")) {
            System.out.println(
                "Nao e possivel adicionar lanches. Pedido finalizado!"
            );

        } else if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");

        } else {
            quantidadeLanches += quantidade;
            System.out.println("Lanches adicionados com sucesso!");
        }
    }

    public double calcularTotal() {

        double totalLanches = quantidadeLanches * precoLanche;

        if (quantidadeLanches >= 3) {
            totalLanches = totalLanches * 0.90;
        }

        return totalLanches + taxaEntrega;
    }

    public void finalizarPedido() {

        if (quantidadeLanches > 0) {
            status = "Finalizado";
            System.out.println("Pedido finalizado com sucesso!");

        } else {
            System.out.println(
                "Nao e possivel finalizar um pedido sem lanches."
            );
        }
    }

    public void exibirPedido() {

        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Quantidade de lanches: " + quantidadeLanches);

        System.out.printf("Preco por lanche: R$ %.2f%n", precoLanche);
        System.out.printf("Taxa de entrega: R$ %.2f%n", taxaEntrega);

        if (quantidadeLanches >= 3) {
            System.out.println("Desconto aplicado: 10%");
        } else {
            System.out.println("Desconto aplicado: 0%");
        }

        System.out.printf("Total do pedido: R$ %.2f%n", calcularTotal());
        System.out.println("Status: " + status);
    }
}