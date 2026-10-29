public class Conta {
    private final String titular;
    private double saldo;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        saldo = saldoInicial;
    }

    public void consultar() {
        System.out.printf("Titular: %s | Saldo: R$ %.2f%n", titular, saldo);
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("O valor do depósito deve ser maior que zero.");
            return;
        }
        saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            System.out.println("Valor inválido ou saldo insuficiente.");
            return;
        }
        saldo -= valor;
        System.out.println("Saque realizado com sucesso.");
    }
}
