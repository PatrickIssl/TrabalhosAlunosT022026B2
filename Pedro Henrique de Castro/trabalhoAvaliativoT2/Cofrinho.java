import java.util.Scanner;

public class Cofrinho {

    private static Scanner scanner = new Scanner(System.in);

    private String dono;
    private double saldo;
    private double metaEconomia = 0;

    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.saldo = 0;
        this.metaEconomia = metaEconomia;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor do depósito deve ser positivo.");
            return;
        }
        saldo += valor;
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor do saque deve ser positivo.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Erro: saldo insuficiente para o saque.");
            return;
        }
        saldo -= valor;
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Parabéns! Você atingiu sua meta de economia.");
        } else {
            System.out.printf("Faltam R$%.2f para atingir sua meta de economia.%n", (metaEconomia - saldo));
        }
    }

    public void exibirSaldo() {
        System.out.printf("Saldo atual: R$%.2f%n", saldo);
    }

    public static void main(String[] args) {
        System.out.println("Digite o nome do dono do cofrinho:");
        String dono = scanner.nextLine();

        System.out.println("Digite a meta de economia:");
        double metaEconomia = scanner.nextDouble();

        Cofrinho cofrinho = new Cofrinho(dono, metaEconomia);

        System.out.println("Digite o valor a ser depositado:");
        double deposito = scanner.nextDouble();
        cofrinho.depositar(deposito);

        System.out.println("Digite o valor a ser retirado:");
        double saque = scanner.nextDouble();
        cofrinho.retirar(saque);

        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();
    }
}