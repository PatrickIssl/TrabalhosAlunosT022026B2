package Estacionamento;

import java.util.Scanner;

public class AtvdEstacionamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cont = 0;
		Scanner scanner = new Scanner(System.in);
		Estacionamento est = new Estacionamento();

		System.out.println("Informe o modelo de seu veiculo");
		est.modelo = scanner.nextLine();
		System.out.println("Informe a placa do veiculo:");
		est.placa = scanner.nextLine();
		
		while(cont != 5) {
			
			System.out.println("\n===== Menu =====");
			System.out.println("1 - Adicionar tempo");
			System.out.println("2 - Calcular valor a pagar");
			System.out.println("3 - Exibir status completo da vaga");
			System.out.println("5 - Sair");
			System.out.print("Escolha uma opção: ");
			
			cont = scanner.nextInt();
			
			if(cont == 1){
				est.adcionartempo(scanner.nextInt());
			}else if(cont == 2 ){
				est.calcularPagamemto();
			}else if(cont == 3) {
				est.calcularPagamemto();
				est.exibirResultado();
			}else if(cont == 5){
				cont = 5;
				System.out.println("finalizado");
				scanner.close();
			}else {
				System.out.println("Informe uma opção valida");
			}
		}

	}

}
