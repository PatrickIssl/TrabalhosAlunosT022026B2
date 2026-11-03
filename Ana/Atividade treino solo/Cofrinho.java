public class Cofrinho {

    private String dono;
    private double saldo;
    private double meta;

    public Cofrinho() {
    }

    public Cofrinho(String dono, double saldo, double meta) {
        setDono(dono);
        setSaldo(saldo);
        setMeta(meta);
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }

    public void depositar(double valor){

        if(valor > 0){
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        }  
    }

    public void retirar(double valor){
        
        if(valor > 0 && valor <= saldo){
            saldo -= valor;
            System.out.println("Retirada realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para retirada.");
        }
    }

    public void verificarMeta() {
        if (saldo >= meta) {
            System.out.println("Parabéns! Você atingiu sua meta");
        } else {
            double restante = meta - saldo;
            System.out.println("Faltam R$ " + restante + " para atingir sua meta");
        }
    }

    public void exibirSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }
    
}
