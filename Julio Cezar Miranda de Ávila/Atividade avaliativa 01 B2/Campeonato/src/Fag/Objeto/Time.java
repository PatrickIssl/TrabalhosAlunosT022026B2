package Fag.Objeto;

import java.util.Scanner;

public class Time {
	private String nome;
	private int vitorias, empates, derrotas, pontos;
	
	Scanner scan = new Scanner(System.in);
	
	public Time() {
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
	}
	
	public void registrarVitoria() {
		do {
			System.out.println("Entre com as vitorias:");
			vitorias = scan.nextInt();
		}while (vitorias < 0);
		pontos += (vitorias * 3);
	}
	
	public void registrarEmpate() {
		do {
			System.out.println("Entre com as empates:");
			empates = scan.nextInt();
		}while (empates < 0);
		pontos += empates;
	}
	
	public void registrarDerrota() {
		do {
			System.out.println("Entre com as derrotas:");
			derrotas = scan.nextInt();
		}while (derrotas < 0);
	}
	
	public void exibirEstatisticas() {
		System.out.println("Nome do time: " + nome);
		System.out.println("Vitorias: " + vitorias);
		System.out.println("Empates: " + empates);
		System.out.println("Derrotas: " + derrotas);
		System.out.println("Pontos: " + pontos);
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public String getNome() {
		return nome;
	}
}
