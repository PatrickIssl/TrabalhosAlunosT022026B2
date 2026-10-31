package fag;

import fag.Estacionamentoo;
public class partEstacionamento {

	public static void main(String[] args) {
		
		Estacionamentoo e = new Estacionamentoo("afg3","honda");
		
		e.adicionartempo(45);
		e.adicionartempo(60);
		e.Valorpagar();
		e.exibirResumo();
	}

}
