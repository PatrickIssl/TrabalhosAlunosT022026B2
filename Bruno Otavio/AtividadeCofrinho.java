
package Principal;

import java.util.Scanner;

public class AtividadeCofrinho {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nomeDigitado = sc.nextLine();

        System.out.print("Digite sua senha: ");
        String senhaDigitada = sc.nextLine();

        if (nomeDigitado.equals("Bruno") && senhaDigitada.equals("123456789")) {

            System.out.println("\nAcesso permitido!");

            System.out.print("Digite sua meta de economia: R$ ");
            double meta = sc.nextDouble();

            while (meta <= 0) {
                System.out.println("A meta deve ser maior que zero.");
                System.out.print("Digite uma meta válida: R$ ");
                meta = sc.nextDouble();
            }

            Cofrinho c = new Cofrinho(meta);

            double valorDeposito;

            do {
                System.out.print("Quanto deseja depositar? R$ ");
                valorDeposito = sc.nextDouble();

                if (valorDeposito <= 0) {
                    System.out.println("O depósito deve ser maior que zero.");
                }

            } while (valorDeposito <= 0);

            c.depositar(valorDeposito);

            double valorRetirada;

            do {
                System.out.print(
                    "Quanto deseja retirar? R$ (Digite 0 se não quiser retirar): "
                );

                valorRetirada = sc.nextDouble();

                if (valorRetirada < 0) {
                    System.out.println("A retirada não pode ser negativa.");
                } else if (valorRetirada > c.saldo) {
                    System.out.println("Saldo insuficiente!");
                    System.out.printf("Seu saldo atual é: R$ %.2f%n", c.saldo);
                }

            } while (valorRetirada < 0 || valorRetirada > c.saldo);

            if (valorRetirada == 0) {
                System.out.println("Você optou por não retirar dinheiro.");
            } else {
                c.retirar(valorRetirada);
            }

            c.exibirSaldo();
            c.verificarMeta();

        } else {
            System.out.println("\nNome ou senha incorretos!");
        }

        sc.close();
    }
}

class Cofrinho {

    String dono = "Bruno";
    String senha = "123456789";
    double saldo = 0;
    double metaEconomia;

    public Cofrinho(double metaEconomia) {
        this.metaEconomia = metaEconomia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado!");
        } else {
            System.out.println("O valor deve ser positivo.");
        }
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor deve ser positivo.");
        } else if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada realizada!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta de economia atingida!");
        } else {
            System.out.printf(
                "Falta R$ %.2f para atingir a meta.%n",
                metaEconomia - saldo
            );
        }
    }
    public void exibirSaldo() {
        System.out.println("\n--- RESUMO DO COFRINHO ---");
        System.out.println("Dono: " + dono);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.printf("Meta: R$ %.2f%n", metaEconomia);
    }
}
