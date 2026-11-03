import java.util.ArrayList;
import java.util.Scanner; 

public class notasTurma {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] nota = new double[5];
		int i;
		double media;
		double soma=0;

		for (i=0; i<nota.length ;i++) {
			System.out.println("Insira a nota " + (i+1) + ":");
			nota[i] = sc.nextDouble();

			soma = soma+nota[i];

			if (nota[i] >= 70) {
				System.out.println("Aluno " + (i+1) + ": " + "Aprovado");
			}
			else {
				System.out.println("Aluno Reprovado");
			}

		}

		media = soma/nota.length;

		System.out.println("Alunos que ficaram acima da média: " +nota[i]);
		System.out.println("Soma" + ":" +soma);
		System.out.println("Media" + ":" +media);
		

	}

}



