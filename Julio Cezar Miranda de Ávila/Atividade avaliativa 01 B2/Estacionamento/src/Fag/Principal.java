package Fag;

import java.util.Scanner;

import Fag.Objeto.Estacionamento;

public class Principal {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Estacionamento veiculo = new Estacionamento();
		System.out.println("Insira o modelo do veiculo: ");
		veiculo.setModelo(scan.nextLine());
		System.out.println("Insira a placa do veiculo: ");
		veiculo.setPlaca(scan.nextLine());
		int i = 1;
		while(i == 1) {
		System.out.println("Insira o tempo de estacionamento do veiculo(em minutos): ");
		veiculo.adicionarTempo(scan.nextInt());
		System.out.println("Deseja adicionar mais tempo?: (DIGITE 1 PARA SIM, 0 PARA NÃO)");
		i = scan.nextInt();
		}
		veiculo.calcularValor();
		veiculo.exibirResumo();
	}
}
