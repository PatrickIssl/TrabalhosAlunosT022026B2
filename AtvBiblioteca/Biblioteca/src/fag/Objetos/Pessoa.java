package fag.Objetos;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

	private String nome;
	private List<Livro> livrosLocados;
	
	public Pessoa() {
		this.livrosLocados = new ArrayList<Livro>();
	}

	public Pessoa(String nome) {
		this.nome = nome;
		this.livrosLocados = new ArrayList<Livro>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Livro> getLivrosLocados() {
		return livrosLocados;
	}
	public void setFilmesLocados(List<Livro> livrosLocados) {
		this.livrosLocados = livrosLocados;
	}
	
	
	
}