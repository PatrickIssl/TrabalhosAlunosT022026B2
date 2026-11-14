import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        double valor1 = scanner.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double valor2 = scanner.nextDouble();

        System.out.println("Escolha a operacao:");
        System.out.println("1 - Soma (+)");
        System.out.println("2 - Subtracao (-)");
        System.out.println("3 - Multiplicacao (*)");
        System.out.println("4 - Divisao (/)");
        System.out.print("Opcao: ");
        int opcao = scanner.nextInt();

        double resultado = 0;
        boolean opcaoValida = true;

        if (opcao == 1) {
            resultado = valor1 + valor2;
        } else if (opcao == 2) {
            resultado = valor1 - valor2;
        } else if (opcao == 3) {
            resultado = valor1 * valor2;
        } else if (opcao == 4) {
            if (valor2 == 0) {
                System.out.println("Erro: divisao por zero!");
                opcaoValida = false;
            } else {
                resultado = valor1 / valor2;
            }
        } else {
            System.out.println("Opcao invalida!");
            opcaoValida = false;
        }

        if (opcaoValida) {
            System.out.println("Resultado: " + resultado);
        }

        scanner.close();
    }
}