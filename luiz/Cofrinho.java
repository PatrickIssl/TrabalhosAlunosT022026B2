public class Cofrinho {

    String dono;
    double saldo;
    double metaEconomia;

    // Construtor
    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.saldo = 0;
        this.metaEconomia = metaEconomia;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Deposito de R$ " + valor + " realizado.");
        } else {
            System.out.println("Valor invalido! O deposito deve ser positivo.");
        }
    }

    public void retirar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
            System.out.println("Retirada de R$ " + valor + " realizada.");
        } else {
            System.out.println("Saldo insuficiente para retirar R$ " + valor + ".");
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Parabens! A meta de economia foi atingida!");
        } else {
            double falta = metaEconomia - saldo;
            System.out.println("A meta ainda nao foi atingida. Faltam R$ " + falta);
        }
    }

    public void exibirSaldo() {
        System.out.println("Dono: " + dono);
        System.out.println("Saldo atual: R$ " + saldo);
    }
}
