import java.util.Scanner;

public class Main {
public static void main(String[]args){
Scanner entrada = new Scanner(System.in);
System.out.println("digite o primeiro valor: ");
double valor1=entrada.nextDouble();
System.out.println("digite o segundo valor: ");
double valor2=entrada.nextDouble();

System.out.println("1-soma(+)");
System.out.println("2-subtraçao(-)");
System.out.println("3-multiplicação (*)");
System.out.println("4- divisao (/)");
System.out.println("digite a opcao: ");
int opcao = entrada.nextInt();

if(opcao == 1){
double resultado = valor1 + valor2;
System.out.println("resultado: " + resultado);
}

else if (opcao == 2){
double resultado = valor1 - valor2;
System.out.println("resultado: " + resultado);
}

else if(opcao == 3){
double resultado = valor1 * valor2;
System.out.println("resultado: " + resultado);
}

else if(opcao == 4){
double resultado = valor1 / valor2;
System.out.println("resultado" + resultado);
}

else{
System.out.println("opcão invalida!");
}
}
}