package atividadeavaliativa;

public class MaquinaRefrigerante {

    int quantidadeEstoque = 0;
    double preco = 4.50;
    double dinheiroArrecadado = 0.0;
    public void comprar(int quantidade, double valorPago) {
        double custoTotal = quantidade * preco;

        if (quantidade > quantidadeEstoque) {
            System.out.println(" Não há refrigerantes suficientes no estoque. ");
        } 
        else if (valorPago < custoTotal) {
            System.out.println(" Dinheiro insuficiente ");
        } 
        else {
            quantidadeEstoque -= quantidade;
            dinheiroArrecadado += custoTotal;
            
            System.out.println("Compra realizada com sucesso!");
            
            double troco = valorPago - custoTotal;
            if (troco > 0) {
                System.out.println("Seu troco: " + troco);
            }
        }
    }
    public void reporEstoque(int quantidade) {
        quantidadeEstoque += quantidade;
        System.out.println(quantidade + " refrigerantes adicionados ao estoque.");
    }
    public void exibirEstado() {
        System.out.println("-> Estoque atual: " + quantidadeEstoque);
        System.out.println("-> Caixa da máquina: " + dinheiroArrecadado);
    }
    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();

        System.out.println("=== LIGANDO A MÁQUINA ===");
        maquina.reporEstoque(5); 
        maquina.exibirEstado();

        System.out.println("\n=== COMPRA 1  ===");
        maquina.comprar(2, 10.00); 
        maquina.exibirEstado();

        System.out.println("\n=== COMPRA 2  ===");
        maquina.comprar(5, 30.00);

    }

}
