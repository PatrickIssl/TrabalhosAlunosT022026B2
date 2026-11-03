package fag;
import java.util.Scanner;

import objeto.Estacionamento;

public class PrincipalEstacionamento {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Estacionamento carro = new Estacionamento();
		
		System.out.println("Informe a placa do veiculo:");
		carro.setPlaca(sc.nextLine());
		System.out.println("Informe o modelo:");
		carro.setModelo(sc.nextLine());
		System.out.println("Informe o tempo:");
		carro.adicionarTempo(sc.nextInt());  
		carro.calcularValor();
		carro.exibirResultado();
		
		sc.close();
		
	}

}
