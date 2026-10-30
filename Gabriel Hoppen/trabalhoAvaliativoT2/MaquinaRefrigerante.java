import java.util.Scanner;

public class MaquinaRefrigerante {
    private static Scanner scanner = new Scanner(System.in);

    private int quantidadeEstoque = 5;
    private double preco = 4.50;
    private double dinheiroArrecadado;

    public void comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("Erro: a quantidade deve ser positiva.");
            return;
        }
        if (quantidade > quantidadeEstoque) {
            System.out.println("Erro: quantidade solicitada maior que o estoque disponível.");
            return;
        }
        if (valorPago < quantidade * preco) {
            System.out.println("Erro: valor pago insuficiente.");
            return;
        }
        if (valorPago > quantidade * preco) {
            double troco = valorPago - (quantidade * preco);
            System.out.printf("Compra realizada com sucesso! Troco: R$%.2f%n", troco);
        } else {
            System.out.println("Compra realizada com sucesso!");
        }
        quantidadeEstoque -= quantidade;
        dinheiroArrecadado += quantidade * preco;
    }

    public void reporEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: quantidade a ser reposta deve ser positiva.");
            return;
        }
        quantidadeEstoque += quantidade;
    }

    public void exibirEstado() {
        System.out.println("Preço do refrigerante: R$ " + preco);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
        System.out.printf("Dinheiro arrecadado: R$%.2f%n", dinheiroArrecadado);
    }

    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();

        maquina.comprar(2, 10.00);
        maquina.exibirEstado();

        maquina.comprar(-1, 4.00);
        maquina.exibirEstado();
    }
}