package fag;

import java.util.Random;
import java.util.Scanner;

public class Jogoaleatorio {
	
////	Jogo de Adivinhação Escreva um programa em que o usuário tenta adivinhar um número entre 1 e 10. O 
//	programa deve gerar um número aleatório e dar pistas ao usuário indicando se ele precisa chutar 
//	mais alto ou mais baixo.

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		int randomNumber = random.nextInt(11);
		boolean acertou = false;
		while (!acertou) {
			System.out.println("Informe um valor para testar (1 a 10");
			int n1 = scan.nextInt();
			if (n1 == randomNumber) {
				
				System.out.println("Parabens, acertou, o numero era :" + randomNumber);
				acertou = true;
				
			}else if (n1 >= randomNumber) {
				
				System.out.println("O numero digitado é maior");
				
			}else if (n1 <= randomNumber) {
				
				System.out.println("O valor digitado é menor ");
				
			}
			
		}
		
		scan.close();
	}
}
