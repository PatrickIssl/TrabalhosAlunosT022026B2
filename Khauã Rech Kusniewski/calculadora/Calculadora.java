
package aula1java;

import java.util.Scanner;

public class AtividadeAvaliativaOfc {

    static Scanner scan = new Scanner(System.in);
    static double saldo = 0;
    static String senha;

    public static void main(String[] args) {

        System.out.println("Crie sua senha:");
        senha = scan.nextLine();
        int tentativas = 0;
        boolean acesso = false;

        while (tentativas < 3 && acesso == false) {

            System.out.println("Digite sua senha:");
            String login = scan.nextLine();

            if (senha.equals(login)) {
                acesso = true;
                System.out.println("Senha correta");
            } else {
                tentativas++;
                System.out.println("Senha invalida");

                if (tentativas < 3) {
                    System.out.println("Tentativas restantes: "+ (3 - tentativas));
                }
            }
        }
        if (acesso == false) {
            System.out.println("Numero maximo de tentativas atingido.");
            System.out.println("Acesso bloqueado.");
        } else {
            int opcao = 0;
            while (opcao != 4) {
                System.out.println("1  Consultar saldo");
                System.out.println("2  Depositar dinheiro");
                System.out.println("3  Sacar dinheiro");
                System.out.println("4  Sair");
                System.out.println("Digite uma opcao:");
                opcao = scan.nextInt();
                
                if (opcao == 1) {
                    saldo();
                } else if (opcao == 2) {
                    deposito();
                } else if (opcao == 3) {
                    sacar();
                } else if (opcao == 4) {
                    System.out.println("Saindo do sistema...");
                } else {
                    System.out.println("Opcao invalida!");
                }
            }
        }
        scan.close();
    }
    public static double saldo() {
        System.out.printf("Seu saldo atual e: R$ %.2f%n", saldo);
        return saldo;
    }

    public static double deposito() {
        System.out.println("Digite o valor do deposito:");
        double valor = scan.nextDouble();
        
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);

        } else {
            System.out.println("Valor invalido");
            System.out.println("O deposito deve ser maior que zero.");
        }

        return saldo;
    }
    public static double sacar() {
        System.out.println("Digite o valor do saque:");
        double valor = scan.nextDouble();

        if (valor <= 0) {
            System.out.println("Valor invalido!");
            System.out.println("O saque deve ser maior que zero.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            saldo = saldo - valor;
            System.out.println("Saque realizado com sucesso!");
            System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        }
        return saldo;
    }
}