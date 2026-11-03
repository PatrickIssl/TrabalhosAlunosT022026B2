package maquinaClasse;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();
        
        int opcao = 0;

        System.out.println("=== Bem-vindo à Máquina de Refrigerante ===");

        while (opcao != 4) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Comprar refrigerante");
            System.out.println("2 - Repor estoque");
            System.out.println("3 - Exibir estado da máquina");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Informe a quantidade de refrigerantes: ");
                int quantidadeCompra = scanner.nextInt();
                
                System.out.print("Informe o valor pago em dinheiro: R$ ");
                double valorPago = scanner.nextDouble();
                
                maquina.comprar(quantidadeCompra, valorPago);
                
            } else if (opcao == 2) {
                System.out.print("Informe a quantidade para repor no estoque: ");
                int quantidadeRepor = scanner.nextInt();
                
                maquina.reporEstoque(quantidadeRepor);
                
            } else if (opcao == 3) {
                maquina.exibirEstado();
                
            } else if (opcao == 4) {
                System.out.println("Saindo do sistema... Até logo!");
                
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
