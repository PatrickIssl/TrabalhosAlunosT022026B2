
public class MaquinaRefrigerante {
    int quantidadeEstoque;
    double preco;
    double dinheiroArrecadado;

    public MaquinaRefrigerante(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = 4.50;
        this.dinheiroArrecadado = 0;
    }

    public void comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("Quantidade invalida!");
        } else if (quantidade > quantidadeEstoque) {
            System.out.println("Estoque insuficiente!");
        } else {
            double total = quantidade * preco;

            if (valorPago < total) {
                System.out.println("Dinheiro insuficiente!");
            } else {
                quantidadeEstoque -= quantidade;
                dinheiroArrecadado += total;

                double troco = valorPago - total;

                System.out.println("Compra realizada com sucesso!");
                System.out.printf("Troco: R$ %.2f%n", troco);
            }
        }
    }

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque += quantidade;
            System.out.println("Estoque reposto!");
        } else {
            System.out.println("Quantidade invalida!");
        }
    }

    public void exibirEstado() {
        System.out.println("\n--- ESTADO DA MAQUINA ---");
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.printf("Preco: R$ %.2f%n", preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n",
                dinheiroArrecadado);
    }
}
