
public class Refrigerante {
	   private int quantidadeEs;
	   private double preco;
	    private double dinheiroArr;
	    public int getQuantidadeEs() {
		return quantidadeEs;
	}
	   public void setQuantidadeEs(int quantidadeEs) {
		   this.quantidadeEs = quantidadeEs;
	   }
	   public double getPreco() {
		   return preco;
	   }
	   public void setPreco(double preco) {
		   this.preco = preco;
	   }
	   public double getDinheiroArr() {
		   return dinheiroArr;
	   }
	   public void setDinheiroArr(double dinheiroArr) {
		   this.dinheiroArr = dinheiroArr;
	   }
		
	   public void comprar(int quantidade, double valorPago) {
	        double total = quantidade * preco;

	        if (quantidade <= 0)
	            System.out.println("Quantidade invalida!");
	        else if (quantidade > quantidadeEs)
	            System.out.println("Estoque insuficiente!");
	        else if (valorPago < total)
	            System.out.println("Dinheiro insuficiente!");
	        else {
	            quantidadeEs -= quantidade;
	            dinheiroArr += total;
	            System.out.printf("Compra realizada! Troco: R$ %.2f%n",
	                    valorPago - total);
	        }
	    }

	    public void reporEstoque(int quantidade) {
	        if (quantidade > 0)
	            quantidadeEs += quantidade;
	    }

	    public void exibirEstado() {
	        System.out.println("Estoque: " + quantidadeEs);
	        System.out.println("Preco: " + preco);
	        System.out.println("Arrecadado: " + dinheiroArr);
	    }
	}