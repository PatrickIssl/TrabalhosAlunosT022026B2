package Cofrinho;

public class Main {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho("Patrick", 500.00);

        cofrinho.exibirSaldo();
        cofrinho.depositar(200);
        cofrinho.depositar(-50);    
        cofrinho.retirar(1000);     
        cofrinho.retirar(50);
        cofrinho.depositar(400);    
        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();
    }
}