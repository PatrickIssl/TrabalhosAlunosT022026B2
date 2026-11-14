package Atvd02B2ClasseMaquinaRefrigerantes;

public class MaquinaRefrigerante {

    int quantidadeEstoque;
    double preco = 4.50;
    double dinheiroArrecadado;

    void comprar(int quantidade, double valorPago) {

        double total;

        total = preco * quantidade;

        if (quantidadeEstoque < quantidade) {
            System.out.println("Não temos essa quantidade no estoque.");
            System.out.println("Temos um total de " + quantidadeEstoque + " refrigerantes.");
        } else if (valorPago < total) {
            System.out.println("Pagamento recusado! Faltam " + (total - valorPago) + " reais.");
        } else {
            System.out.println("Compra realizada com sucesso! ");
            if (valorPago > total) {
                System.out.println("Você vai receber " + (valorPago - total) + " reais.");
            }

            quantidadeEstoque -= quantidade;
            dinheiroArrecadado += total;
        }
    }


    void reporEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Essa quantidade está inválida.");
        } else {
            quantidadeEstoque += quantidade;
            System.out.println("Estoque reposto!");
        }
    }


    void exibirEstado() {
        System.out.println("ESTOQUE ATUAL: " + quantidadeEstoque);
        System.out.println("PREÇO UNITÁRIO: R$" + preco);
        System.out.println("DINHEIRO TOTAL ARRECADADO: R$" + dinheiroArrecadado);
    }

}