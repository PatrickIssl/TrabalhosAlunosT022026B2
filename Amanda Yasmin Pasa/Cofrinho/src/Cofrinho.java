public class Cofrinho {
    String dono;
    double saldo;
    double metaEconomia;

    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito realizado!");
        } else {
            System.out.println("O valor deve ser positivo!");
        }
    }

    public void retirar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada realizada!");
        } else {
            System.out.println("Saldo insuficiente ou valor invalido!");
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Meta de economia atingida!");
        } else {
            System.out.printf("Faltam R$ %.2f para atingir a meta.%n",
                    metaEconomia - saldo);
        }
    }

    public void exibirSaldo() {
        System.out.println("Dono: " + dono);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.printf("Meta: R$ %.2f%n", metaEconomia);
    }
}
