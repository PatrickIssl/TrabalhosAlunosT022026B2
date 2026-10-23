package fag;

import java.util.Scanner;

import objeto.Time;

public class PrincipalTime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Time timeUm = new Time();
		Time timeDois = new Time();
		timeUm.setNome("Flamengo");
		timeDois.setNome("Palmeiras");
		timeUm.registrarVitoria();
		timeUm.registrarEmpate();
		timeUm.registrarEmpate();
		timeDois.registrarDerrota();
		timeDois.registrarEmpate();
		timeDois.registrarEmpate();
	    timeUm.exibirEstatisticas();
	    timeDois.exibirEstatisticas();
		if (timeUm.getPontos() > timeDois.getPontos()) {
	        System.out.println(timeUm.getNome() + " tem mais pontos!");
	    } else if (timeDois.getPontos() > timeUm.getPontos()) {
	        System.out.println(timeDois.getNome() + " tem mais pontos!");
	    } else {
	        System.out.println("Empate na classificação!");
	    }

	}
}
