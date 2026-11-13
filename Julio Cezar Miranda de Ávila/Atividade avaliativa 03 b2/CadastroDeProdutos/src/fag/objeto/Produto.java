package fag.objeto;

public class Produto {
	
	private String nome;
	private Double preço;
	
	public Produto() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome.isBlank()) {
			System.out.println("Nome invalido!");
			return;
		}
		this.nome = nome;
	}
	public Double getPreço() {
		return preço;
	}
	public void setPreço(Double preço) {
		if (preço <= 0) {
			System.out.println("Preço invalido!");
			return;
		}
		this.preço = preço;
	}

	public void MostrarDados(int posicao) {
		System.out.printf("%d) %s - R$%.2f\n", posicao, getNome(), getPreço());
	}
}
