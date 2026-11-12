package sistemagerenciamento;

public class Produto {
	private int Id;
	private String nome;
	private String categoria;
	private double preco;
	private boolean Disponivel;
	
	public Produto(int Id, String nome, String categoria, double preco) {
		this.Id = Id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.Disponivel = true;
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isDisponivel() {
		return Disponivel;
	}

	public void setDisponivel(boolean Disponivel) {
		this.Disponivel = Disponivel;
	}
	
	
}
