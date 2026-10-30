package bibliotecaClasse;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

	private String nome;
	private List <Livros> livrosAlugados;

	public Pessoa() {
		this.livrosAlugados = new ArrayList <Livros>();
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
		this.livrosAlugados = new ArrayList <Livros>(); 
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Livros> getlivrosAlugados(){
		return livrosAlugados;
	}
	
	public void setlivrosAlugados(List<Livros> livrosAlugados) {
		this.livrosAlugados = livrosAlugados;
	}
	
	
	
}	