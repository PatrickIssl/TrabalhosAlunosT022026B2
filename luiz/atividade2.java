package fag;

public class atividade2 {
	
	private String nome;
	private float salario;
	private long cpf;
	
	
	public atividade2() {}
	
	public atividade2(String nome, float salario, long cpf) {
		setNome(nome);
		setSalario(salario);
		setCpf(cpf);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.isBlank()) 
		{
			System.out.println("O nome nao pode estar em brnaco!!");
		}
		this.nome = nome;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		if(salario<=0) 
		{
			System.out.println("O salario nao poder ser zero");
		}this.salario = salario;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		if(cpf<=0) 
		{
			System.out.println("o cpf nao pode estar vazio");
		}this.cpf = cpf;
	}
	
	
	

}
