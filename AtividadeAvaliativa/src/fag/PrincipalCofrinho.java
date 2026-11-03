package fag;

import objeto.Cofrinho;

public class PrincipalCofrinho {

	public static void main(String[] args) {
		Cofrinho cofre = new Cofrinho();
		cofre.setDono("Pedro");
		cofre.setMetaEconomia(500);
		cofre.depositar(250);
		cofre.retirar(300);
		cofre.exibirSaldo();
		cofre.verificarMeta();
	}

}
