package fag;

import java.util.Scanner;

import objeto.MaquinaRefrigente;

public class PrincipalRefri {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MaquinaRefrigente refrigerante = new MaquinaRefrigente();
		System.out.println("Informe a quantidade no estoque");
		refrigerante.setQuantidadeEstoque(sc.nextInt());
		if (refrigerante.getQuantidadeEstoque() !=0) {
			refrigerante.setPreco(7);
			refrigerante.comprar(5, 8);
			refrigerante.exibirEstado();	
		}
		sc.close();
	}

}
