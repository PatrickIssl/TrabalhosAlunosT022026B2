
package Cofrinho;

public class Cofrinho {

    String dono;
    double saldo;
    double metaEconomia;

    void depositar(double valor) {

        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Deposito realizado no valor de R$ " + valor);
        }
        else {
            System.out.println("Informe um valor valido para deposito");
        }
    }

    void retirar(double valor) {

        if (valor > 0) {
            if (valor <= saldo) {
                saldo = saldo - valor;
                System.out.println("Retirada realizada no valor de R$ " + valor);
            }
            else {
                System.out.println("Saldo insuficiente para retirada");
            }
        }
        else {
            System.out.println("Informe um valor valido para retirada");
        }
    }

    void verificarMeta() {

        if (saldo >= metaEconomia) {
            System.out.println("Parabens! Meta de economia atingida!");
        }
        else {
            double falta = metaEconomia - saldo;
            System.out.printf("Faltam R$ %.2f para atingir sua meta%n", falta);
        }
    }

    void exibirSaldo() {

        System.out.println("\n===== STATUS DO COFRINHO =====");
        System.out.println("Dono: " + dono);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.printf("Meta de economia: R$ %.2f%n", metaEconomia);
    }
}
