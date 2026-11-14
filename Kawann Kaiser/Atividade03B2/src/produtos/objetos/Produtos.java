package produtos.objetos;

public class Produtos {
	
	private String nome;
	private double valor;
	private int id;
	
	public Produtos(String nome, double valor, int id) {
		setNome(nome);
		setValor(valor);
		setId(id);
	}
	
	public Produtos() {
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		
		return nome;
	}
	public void setNome(String nome) {
		if(nome.isBlank()) {
			System.out.println("nome inválido!");
			return;
		}
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if(valor <= 0) {
			System.out.println("valor inválido!");
			return;
		}
		this.valor = valor;
	}
	
	public int getId() {
		
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void mostrarDados(int posicao) {
	    System.out.printf("%d) ID: %d - %s / R$ %.2f%n",posicao, getId(), getNome(), getValor());
	}
	
	
	
}
