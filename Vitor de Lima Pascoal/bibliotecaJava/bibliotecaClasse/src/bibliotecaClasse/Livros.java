package bibliotecaClasse;

import java.util.Date;

public class Livros {
	
	private String nome;
	private String autor;
	private Date dataLocacao;
	private int paginas;
	
	public Livros(){
		
	}
	
	public Livros(String nome, String autor, int paginas) {
		this.nome = nome;
		this.autor = autor;
		this.paginas = paginas;
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

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
}
