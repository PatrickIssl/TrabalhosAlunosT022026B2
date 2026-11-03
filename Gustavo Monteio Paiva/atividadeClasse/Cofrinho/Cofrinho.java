package Cofrinho;

public class Cofrinho {

    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho(String nomeDono, double meta) {
        dono = nomeDono;
        metaEconomia = meta;
        saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
            verificarMeta();
        } else {
            System.out.println("Erro: o valor do depósito deve ser positivo.");
        }
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor da retirada deve ser positivo.");
        } else if (valor > saldo) {
            System.out.printf("Erro: saldo insuficiente. Saldo atual: R$ %.2f.%n", saldo);
        } else {
            saldo -= valor;
            System.out.printf("Retirada de R$ %.2f realizada com sucesso.%n", valor);
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.printf("Parabéns, %s! Meta de R$ %.2f atingida!%n", dono, metaEconomia);
        } else {
            double falta = metaEconomia - saldo;
            System.out.printf("Ainda faltam R$ %.2f para atingir a meta.%n", falta);
        }
    }

    public void exibirSaldo() {
        System.out.printf("Cofrinho de %s | Saldo: R$ %.2f | Meta: R$ %.2f%n",
                dono, saldo, metaEconomia);
    }
}