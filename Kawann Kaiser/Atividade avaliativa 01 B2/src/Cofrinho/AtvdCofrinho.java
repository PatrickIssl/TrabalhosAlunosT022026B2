
package Cofrinho;

import java.util.Scanner;

public class AtvdCofrinho {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        int opcao;
        double valor;

        System.out.println("Informe o nome do dono:");
        cofrinho.dono = scanner.nextLine();

        System.out.println("Informe a meta de economia:");
        cofrinho.metaEconomia = scanner.nextDouble();

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1 - Depositar dinheiro");
            System.out.println("2 - Retirar dinheiro");
            System.out.println("3 - Verificar meta");
            System.out.println("4 - Exibir saldo");
            System.out.println("5 - Sair");
            System.out.println("Informe a opcao desejada:");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Informe o valor do deposito:");
                    valor = scanner.nextDouble();

                    cofrinho.depositar(valor);
                    cofrinho.verificarMeta();
                    break;

                case 2:
                    System.out.println("Informe o valor da retirada:");
                    valor = scanner.nextDouble();

                    cofrinho.retirar(valor);
                    break;

                case 3:
                    cofrinho.verificarMeta();
                    break;

                case 4:
                    cofrinho.exibirSaldo();
                    break;

                case 5:
                    System.out.println("Finalizando programa...");
                    cofrinho.verificarMeta();
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}
