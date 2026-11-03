package Fag;

import java.util.Scanner;

import Fag.Objeto.Time;

public class Principal {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Time timeA = new Time();
		Time timeB = new Time();
		
		System.out.println("Entre com o nome do 1° time:");
		timeA.setNome(scan.nextLine());
		timeA.registrarVitoria();
		timeA.registrarEmpate();
		timeA.registrarDerrota();
		
		System.out.println();
		
		System.out.println("Entre com o nome do 2° time::");
		timeB.setNome(scan.nextLine());
		timeB.registrarVitoria();
		timeB.registrarEmpate();
		timeB.registrarDerrota();
		
		System.out.println("--- Estatisticas ---");
		timeA.exibirEstatisticas();
		System.out.println();
		timeB.exibirEstatisticas();
		System.out.println();
		
		if (timeA.getPontos() > timeB.getPontos()) {
			System.out.println(timeA.getNome() + " possui mais pontos!");
		}
		else if (timeB.getPontos() > timeA.getPontos()) {
			System.out.println(timeB.getNome() + " possui mais pontos!");
		}
		else {
			System.out.println("Houve empate entre os times!");
		}
		scan.close();
	}
}
