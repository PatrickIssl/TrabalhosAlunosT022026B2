package modelo;

public class Livro {
	private static int IDFixo = 0;
	private int ID;
	private String nome;
	private String autor;
	public Livro(String nome, String autor) {
		this.ID = IDFixo;
		this.nome = nome;
		this.autor = autor;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public static void incrementaID() {
		Livro.IDFixo++;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}
