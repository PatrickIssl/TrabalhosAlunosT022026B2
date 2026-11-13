package trabalho1;

public class Jogo {
	private int id;
	private String nome;
	private String genero;
	
	public Jogo(int id, String nome, String genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void exibirDados() {
		System.out.println("===");
		System.out.println("ID: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Gênero: " + genero);
		System.out.println("===");
	}
}
