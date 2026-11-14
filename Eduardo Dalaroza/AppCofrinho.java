class Cofrinho {
    String dono;
    double saldo;
    double metaEconomia;

    Cofrinho(String nomeDono, double meta) {
        dono = nomeDono;
        metaEconomia = meta;
        saldo = 0;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Deposito de R$ " + valor + " realizado.");
        } else {
            System.out.println("Valor invalido! O deposito precisa ser positivo.");
        }
    }

    void retirar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
            System.out.println("Retirada de R$ " + valor + " realizada.");
        } else {
            System.out.println("Saldo insuficiente para retirar R$ " + valor);
        }
    }

    void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta atingida! Parabens!");
        } else {
            double falta = metaEconomia - saldo;
            System.out.println("Meta nao atingida. Faltam R$ " + falta);
        }
    }

    void exibirSaldo() {
        System.out.println("Dono: " + dono);
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Meta: R$ " + metaEconomia);
        System.out.println();
    }
}

public class AppCofrinho {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho("Eduardo", 200);

        cofrinho.depositar(100);
        cofrinho.depositar(50);
        cofrinho.exibirSaldo();

        cofrinho.retirar(300);
        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();
    }
}
