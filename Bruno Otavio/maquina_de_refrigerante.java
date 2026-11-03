package Principal;


import java.util.Scanner;

public class maquina_de_refrigerante {

    private static Scanner scanner = new Scanner(System.in);

    int quantidadeEstoque;
    double preco;
    double dinheiroArrecadado;

    public maquina_de_refrigerante() {
        quantidadeEstoque = 0;
        preco = 4.50;
        dinheiroArrecadado = 0;
    }

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            quantidadeEstoque = quantidadeEstoque + quantidade;
            System.out.println("Estoque atualizado: " + quantidadeEstoque);
        } else {
            System.out.println("Quantidade invalida!");
        }
    }

    public void comprar(int quantidade, double valorPago) {

        double total = quantidade * preco;

        if (quantidade <= 0) {
            System.out.println("Quantidade invalida");
        } else if (quantidade > quantidadeEstoque) {
            System.out.println("Quantidade indisponivel");
        } else if (valorPago < total) {
            System.out.println("Dinheiro insuficiente");
        } else {
            quantidadeEstoque = quantidadeEstoque - quantidade;
            dinheiroArrecadado = dinheiroArrecadado + total;

            double troco = valorPago - total;

            System.out.println("Compra feita com sucesso");

            if (troco > 0) {
                System.out.println("Troco: R$ " + troco);
            } else {
                System.out.println("Nao a troco.");
            }
        }
    }

    public void exibirEstado() {
        System.out.println("\n ESTADO DA MAQUINA ");
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("Preco: R$ " + preco);
        System.out.println("Dinheiro arrecadado: R$ " + dinheiroArrecadado);
    }

    public static void main(String[] args) {

        maquina_de_refrigerante maquina = new maquina_de_refrigerante();

        System.out.println("Digite a quantidade inicial de refrigerantes:");
        int quantidade = scanner.nextInt();

        maquina.reporEstoque(quantidade);

        System.out.println("\n PRIMEIRA COMPRA ");
        System.out.println("Quantos refrigerantes deseja comprar?");
        int quantidadeCompra = scanner.nextInt();

        System.out.println("Digite o valor pago:");
        double valorPago = scanner.nextDouble();

        maquina.comprar(quantidadeCompra, valorPago);

        System.out.println("\n SEGUNDA COMPRA");
        System.out.println("Quantos refrigerantes deseja comprar?");
        quantidadeCompra = scanner.nextInt();

        System.out.println("Digite o valor pago:");
        valorPago = scanner.nextDouble();

        maquina.comprar(quantidadeCompra, valorPago);

        maquina.exibirEstado();

        scanner.close();
    }
}