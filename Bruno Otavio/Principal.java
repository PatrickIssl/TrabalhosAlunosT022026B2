package Principal;

import java.util.Scanner;


public class Principal {
	

	public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
		  float nota=0; 
		  float soma=0;
		  float med=0;
		  String nome,status;
		  int i=1, qn=1;
		  for(i=1; i<=3; i++) {
			  
			  System.out.println("digite o nome do aluno");
			  nome = scan.next();
			  soma =0;
		  for(qn=1; qn<=3; qn++) {
			  System.out.println("digite a nota do aluno");
			  nota = scan.nextFloat();

			soma = soma + nota;
			
			  
			
			  }
		  med = soma / qn;
		  
		if(med >=7)
			status = "aprovado";
		else
			status = "reprovado";
		  System.out.println("sua media e: " + med+"!");
		  System.out.println("status:" + status+"!";
		  }
		  
		  
			  
		  
		  
		 }
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	}