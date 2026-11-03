
public class Aluno {

	private String nome;
	private int idade;
	private double nota;
	
	public Aluno() {
	}
	
	public Aluno(String nome, int idade, double nota) {
		setNome(nome);
		setIdade(idade);
		setNota(nota);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.isBlank()) {			
			this.nome = nome;
		}
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {		
			this.idade = idade;
	}
	
	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) {
		if(nota >= 0 && nota <=10) {
		this.nota = nota;
		}
	}
	
	public void verificarSituacao() {
		if(nota >= 6) {
			 System.out.println("Olá, meu nome é " + nome + ", tenho " + idade + " anos e fui aprovado");
		}else {
		 System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos e fui reprovado");
	}
	
	}
	
}
