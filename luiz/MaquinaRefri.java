package fag;

public class MaquinaRefri {
	
	int quantidadeEstoque;
	float preco;
	float dinheiroarrecadado;
	
	
	
	public MaquinaRefri(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque=100	;
		this.preco = 4.50f;
		this.dinheiroarrecadado = 0.0f;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getDinheiroarrecadado() {
		return dinheiroarrecadado;
	}
	public void setDinheiroarrecadado(float dinheiroarrecadado) {
		this.dinheiroarrecadado = dinheiroarrecadado;
	}
	
	public void comprar(int quantidade, double valorPago) {
        if (quantidade <= 0) {
            System.out.println("Compra recusada: quantidade inválida.");
            return;
        }

        if (quantidade > quantidadeEstoque) {
            System.out.printf("Compra recusada: estoque insuficiente (disponível: %d).%n",
                    quantidadeEstoque);
            return;
        }

        double total = quantidade * preco;

        if (valorPago < total) {
            System.out.printf("Compra recusada: dinheiro insuficiente. Total: R$ %.2f, pago: R$ %.2f.%n",
                    total, valorPago);
            return;
        }

        quantidadeEstoque -= quantidade;
        dinheiroarrecadado += total;
        System.out.printf("Compra realizada: %d refrigerante(s) por R$ %.2f.%n", quantidade, total);

        double troco = valorPago - total;
        if (troco > 0) {
            System.out.printf("Troco: R$ %.2f%n", troco);
        }
    }

	public void reporestoque(int quantidade) 
	{
		if(quantidade < 0) 
		{
			System.out.println(" nao e possivel reabastercer o valor precisa ser maior que 0");
		}
		else 
		{
			quantidadeEstoque+=quantidade;
			System.out.println("estoque repostp com sucesso	");
		}
		
	}
	
	public void exibirEstado() {
        System.out.println("Estoque: " + this.quantidadeEstoque + " unidade(s)");
        System.out.printf("Preço unitário: R$ %.2f%n", this.preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n", this.dinheiroarrecadado);
    }
	}


