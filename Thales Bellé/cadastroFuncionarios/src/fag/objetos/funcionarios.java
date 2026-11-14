package fag.objetos;

public class funcionarios {
	
	private int id;
	private String nome;
	private int idade;
	private String cargo;
	
	public funcionarios() {
		
	}
	
	public funcionarios(int id, String nome, int idade, String cargo) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cargo = cargo;
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
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
