package Ana.projetoBiblioteca.objetos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nome;
	private List<Livros> livrosLocados;
	
	public Usuario() {
		this.livrosLocados = new ArrayList<Livros>();
	}

	public Usuario(String nome) {
		this.nome = nome;
		this.livrosLocados = new ArrayList<Livros>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Livros> getLivrosLocados() {
		return livrosLocados;
	}
	public void setLivrosLocados(List<Livros> livrosLocados) {
		this.livrosLocados = livrosLocados;
	}
}

    

