import java.util.Scanner;

public class Calculadora {
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		System.out.println("Entre com o primeiro valor: ");
		double x = sc.nextDouble();
		System.out.println("Entre com o segundo valor: ");
		double y = sc.nextDouble();
		System.out.println("Informe 1 para adicao.");
		System.out.println("Informe 2 para subtracao.");
		System.out.println("Informe 3 para multiplicacao.");
		System.out.println("Informe 4 para divisao.");
		int op = sc.nextInt();
		double res = 0;
		if (op==1){
		    res = x + y;
		}
			else if (op==2){
			 	 res = x - y;
		        }
				 else if (op==3){
					  res = x * y;
		        	 }
					 else{
					 	 res = x / y;
					 }
			 
		System.out.printf("Resultado: %.2f", res);
	}
}

