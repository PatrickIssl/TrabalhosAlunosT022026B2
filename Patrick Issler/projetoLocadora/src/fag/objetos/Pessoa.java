package fag.objetos;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

	private String nome;
	private List<Filme> filmesLocados;
	
	public Pessoa() {
		this.filmesLocados = new ArrayList<Filme>();
	}

	public Pessoa(String nome) {
		this.nome = nome;
		this.filmesLocados = new ArrayList<Filme>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Filme> getFilmesLocados() {
		return filmesLocados;
	}
	public void setFilmesLocados(List<Filme> filmesLocados) {
		this.filmesLocados = filmesLocados;
	}
	
	
	
}
