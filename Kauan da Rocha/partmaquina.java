package fag;

import fag.MaquinaRefri;
public class partmaquina {

	public static void main(String[] args) {
		MaquinaRefri m = new MaquinaRefri(5);
		
		m.comprar(5, 50);
		
		m.exibirEstado();
		

	}

}
