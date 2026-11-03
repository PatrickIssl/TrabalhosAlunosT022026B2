package Principal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class Livros {
	public Date dataLocação;
	public Livros(String nome) {
		super();
		this.nome = nome;
		
	}

	

	public Livros(Date dataLocação, String nome) {
		super();
		this.dataLocação = dataLocação;
		this.nome = nome;
	}

	public Date getDataLocação() {
		return dataLocação;
	}

	public void setDataLocação(Date dataLocação) {
		this.dataLocação = dataLocação;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	private String nome;

	
	
	public String validarDisponibilidade() {
		  String VERDE = "\u001B[32m";
		  String VERMELHO = "\u001B[31m";
		  String RESET = "\u001B[0m";
		  if(dataLocação==null) {
			  return VERDE+"Disponivel"+RESET; 
		  }else {
			  return VERMELHO+"Indisponivel"+RESET;
		  }
		
	}
	

}
