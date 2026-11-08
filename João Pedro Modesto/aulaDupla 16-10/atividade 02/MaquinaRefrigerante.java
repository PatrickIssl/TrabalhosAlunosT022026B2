public class MaquinaRefrigerante{
    private int quantidadeEstoque = 0;
    private double preço = 4.5;
    private double dinheiroArrecadado = 0;

    public void Comprar (int quantidade, double valorPago){
        double total = preço*quantidade;
        if(quantidadeEstoque >= quantidade && valorPago >= total){
           quantidadeEstoque-=quantidade;
           dinheiroArrecadado+=total;
        if (valorPago == total){
            System.out.println("Valor gasto: "+total);
        }
        else {
            System.out.println("Seu troco: "+(valorPago-total));
        }
           }
        else if (quantidade > quantidadeEstoque){
            System.out.println("Estoque insuficiente");
        }
        else {
            System.out.println("Valor insuficiente");
        }
        }

    public void reporEstoque(int quant){
        if (quant > 0){
            quantidadeEstoque+=quant;
        }
    }

    public void exibirEstado(){
        System.out.println("Estoque: "+quantidadeEstoque);
        System.out.println("Dinheiro arrecadado: "+dinheiroArrecadado);
    }

    }

