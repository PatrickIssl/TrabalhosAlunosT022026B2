
package MaquinaRefri;

import java.util.Scanner;

public class AtvdMaquinaRefri {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MaquinaRefri maquina = new MaquinaRefri();

        int opcao;
        int quant;
        double valorPago;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1 - Comprar refrigerantes");
            System.out.println("2 - Consultar estoque");
            System.out.println("3 - Repor estoque (ADM)");
            System.out.println("4 - Exibir status (ADM)");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Quantidade desejada: ");
                    quant = scanner.nextInt();

                    System.out.print("Informe o valor pago: R$ ");
                    valorPago = scanner.nextDouble();

                    maquina.comprar(quant, valorPago);
                    break;

                case 2:
                    maquina.exibirStatusADM(false);
                    break;

                case 3:
                    System.out.print("Quantidade para repor: ");
                    quant = scanner.nextInt();

                    maquina.reporEstoque(quant);
                    break;

                case 4:
                    maquina.exibirStatusADM(true);
                    break;

                case 5:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}
