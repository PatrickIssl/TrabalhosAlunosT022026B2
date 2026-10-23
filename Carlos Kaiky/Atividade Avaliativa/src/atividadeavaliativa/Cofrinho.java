package atividadeavaliativa;

public class Cofrinho {

    private String dono;
    private double saldo;
    private double metaEconomia;

    public Cofrinho(String dono, double metaEconomia) {
        this.dono = dono;
        this.metaEconomia = metaEconomia;
        this.saldo = 0; 
    }

    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Erro: o valor e invalido.");
        }
    }

    public void retirar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
            System.out.println("Retirada de " + valor + " realizada com sucesso!");
        } else {
            System.out.println("Erro: saldo insuficiente para retirar " + valor);
        }
    }

    public void verificarMeta() {
        if (saldo >= metaEconomia) {
            System.out.println("Parabéns, " + dono + " Você atingiu sua meta de economia!");
        } else {
            double falta = metaEconomia - saldo;
            System.out.println("Ainda faltam " + falta + " para atingir a meta de " + dono + ".");
        }
    }

    public void exibirSaldo() {
        System.out.println("----- Dados do Cofrinho -----");
        System.out.println("Dono: " + dono);
        System.out.println("Saldo atual: " + saldo);
        System.out.println("Meta de economia: " + metaEconomia);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {

        Cofrinho meuCofrinho = new Cofrinho("João", 500.0);

        meuCofrinho.depositar(200.0);
        meuCofrinho.depositar(150.0);

        meuCofrinho.retirar(500.0);

        meuCofrinho.exibirSaldo();

        meuCofrinho.verificarMeta();
    }
}
