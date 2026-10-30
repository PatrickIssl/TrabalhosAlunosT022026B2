package Principal;

import java.util.List;
import java.util.ArrayList;


public class Pessoa {
	
	public Pessoa(String nome) {
		super();
		this.nome = nome;
		
	}

	private String nome;
	private List<Livros> livroslocados = new ArrayList<Livros>();
	
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Livros> getLivroslocados() {
		return livroslocados;
	}
	
	public void setLivroslocados(List<Livros> livroslocados) {
		this.livroslocados = livroslocados;
	}

}

