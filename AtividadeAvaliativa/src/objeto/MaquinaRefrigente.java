package objeto;

public class MaquinaRefrigente {

	private int quantidadeEstoque;
	private double preco;
	private double dinheiroArrecadado;
	
	public MaquinaRefrigente() {
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		if (quantidadeEstoque >= 0) {
			this.quantidadeEstoque = quantidadeEstoque;
		}else {
			System.out.println("O estoque nao pode ser negativo!");
		}
		
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco >= 4.5) {
			this.preco = preco;
		}else {		
			System.out.println("O valor tem que cobrir o preco do produto!");
		}
	}

	public double getDineirooArrecadado() {
		return dinheiroArrecadado;
	}

	public void setDinehrioArrecadado(double dinehrioArrecadado) {
		this.dinheiroArrecadado = dinehrioArrecadado;
	}
	
	public void comprar(int quantidade, double valorPago) {
		double troco=0; 
	    if(getPreco() != 0 ) {
	    	if (this.quantidadeEstoque - quantidade>=0) {
	    		if(valorPago == getPreco()) {
	    			this.dinheiroArrecadado +=valorPago-4.50;
	    			this.quantidadeEstoque -= quantidade;
	    		}else if (valorPago>getPreco()) {
	    			this.quantidadeEstoque -= quantidade;
	    			troco = valorPago - getPreco();
	    			this.dinheiroArrecadado = getPreco() - 4.5;
	    			System.out.println("Troco: "+troco);
	    		} else {
	    			System.out.println("O valor pago deve ser maio que o preço");
	    		}
				
	    	}else {
	    		System.out.println("O estoque nao pode ficar negativo");
	    	}
	    }
	}
	public void reporEstoque() {
		
	}
	public void exibirEstado() {
		if (getPreco() != 0) {
			System.out.println("Estoque: "+this.quantidadeEstoque+" Preco: "+this.preco+" Dinheiro arrecadado: "+this.dinheiroArrecadado);
		}	
	}
	
	
}
