
package Pedidos;

import java.util.Scanner;

public class AtvdPedidos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pedidos pedido = new Pedidos();

        System.out.println("Informe o nome do cliente:");
        pedido.nomeCliente = scanner.nextLine();

        System.out.println("\n===== Menu =====");
        System.out.println("1 - Entrega em domicilio");
        System.out.println("2 - Retirada no local");
        System.out.println("Informe a opcao desejada:");

        int opcaoEntrega = scanner.nextInt();

        if (opcaoEntrega == 1) {
            pedido.entrega = true;
        }
        else {
            pedido.entrega = false;
        }

        System.out.println("Informe a primeira quantidade de lanches:");
        pedido.adicionarLanches(scanner.nextInt());

        System.out.println("Informe a segunda quantidade de lanches:");
        pedido.adicionarLanches(scanner.nextInt());

        pedido.calcularTotal();

        pedido.finalizarPedido();

        System.out.println("\nTentando adicionar mais um lanche...");
        pedido.adicionarLanches(1);

        pedido.exibirPedido();

        scanner.close();
    }
}
