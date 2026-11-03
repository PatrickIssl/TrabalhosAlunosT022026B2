package timeClasse;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		int opcao = 0;
		Scanner scan = new Scanner(System.in);
		Time timeA = new Time ("JumentosFC");
		Time timeB = new Time ("Operarios");
		while(opcao != 4) {
			printMenu(timeA, timeB);
			opcao = scan.nextInt();
			if(opcao == 1) {
				System.out.println("1 - Registrar vitoria: " + timeA.nome);
				System.out.println("2 - Registrar derrota: " + timeA.nome);
				System.out.println("3 - Registrar empate: " + timeA.nome);
				int opcaoResultado = scan.nextInt();
				if (opcaoResultado == 1) {
					timeA.registrarVitoria();
				}
				else if(opcaoResultado == 2) {
					timeA.registrarDerrota();
				}
				else if(opcaoResultado == 3) {
					timeA.registrarEmpate();
				}
			}
			else if(opcao == 2) {
				System.out.println("1 - Registrar vitoria: " + timeB.nome);
				System.out.println("2 - Registrar derrota: " + timeB.nome);
				System.out.println("3 - Registrar empate: " + timeB.nome);
				int opcaoResultado = scan.nextInt();
				if (opcaoResultado == 1) {
					timeB.registrarVitoria();
				}
				else if(opcaoResultado == 2) {
					timeB.registrarDerrota();
				}
				else if(opcaoResultado == 3) {
					timeB.registrarEmpate();
				}
			}
			else if(opcao == 3) {
				timeA.exibirEstatisticas();
				timeB.exibirEstatisticas();
			}
			else if(opcao == 4) {
				System.out.println("Time " + timeA.nome +" Esta com " +timeA.pontos +" pontos ");
				System.out.println("Time " + timeB.nome +" Esta com " +timeB.pontos +" pontos" );
				if (timeA.pontos > timeB.pontos) {
					System.out.println("Time" + timeA.nome + " Foi campeao do campeonato");
				}
				else if(timeB.pontos > timeA.pontos) {
					System.out.println("Time" + timeB.nome + " Foi campeao do campeonato");
				}
				else {
					System.out.println("Os dois times empataram");
				}
			}
			
			else {
				System.out.println("Opcao invalida");
			}
		}		
		scan.close();
	}
	
	public static void printMenu(Time timeA, Time timeB) {
		System.out.println("1 - Registrar resultado para " + timeA.nome);
        System.out.println("2 - Registrar resultado para " + timeB.nome);
        System.out.println("3 - Exibir estatísticas");
        System.out.println("4 - Sair e ver classificação");
        System.out.print("Escolha uma opção: ");
		
	}
}
		

