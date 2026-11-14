package Jogos.objetos;




public class Jogos {
	private Integer id;
	private String nome;
	private String genero;


	public Jogos() {
	}

	public Jogos(String nome, Integer id, String genero) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	
}
