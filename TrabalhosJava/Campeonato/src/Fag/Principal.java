package Fag;

import Fag.Objeto.Time;

public class Principal {

	public static void main(String[] args) {

		Time time1 = new Time("Atlético Mineiro");
		Time time2 = new Time("Palmeiras");

		time1.registrarVitoria();
		time1.registrarVitoria();
		time1.registrarEmpate();
		time1.registrarDerrota();

		time2.registrarVitoria();
		time2.registrarEmpate();
		time2.registrarEmpate();
		time2.registrarDerrota();

		System.out.println("Resultados do campeonato");
		System.out.println();

		time1.exibirEstatisticas();
		System.out.println();

		time2.exibirEstatisticas();
		System.out.println();

		if (time1.getPontos() > time2.getPontos()) {
			System.out.println("O time " + time1.getNome() + " ganhou.");
		} else if (time2.getPontos() > time1.getPontos()) {
			System.out.println("O colossal " + time2.getNome() + " ganhou.");
		} else {
			System.out.println("Houve um empate na classificaçao.");
		}
	}
}