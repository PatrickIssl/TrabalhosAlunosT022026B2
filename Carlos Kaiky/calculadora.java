import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double valor1, valor2, resultado;
        int opcao;

        System.out.print("Digite o primeiro valor: ");
        valor1 = entrada.nextDouble();

        System.out.print("Digite o segundo valor: ");
        valor2 = entrada.nextDouble();

        System.out.println("\n===== MENU =====");
        System.out.println("1 - Soma (+)");
        System.out.println("2 - Subtracao (-)");
        System.out.println("3 - Multiplicacao (*)");
        System.out.println("4 - Divisao (/)");
        System.out.print("Escolha uma opcao: ");
        opcao = entrada.nextInt();

        if (opcao == 1) {
            resultado = valor1 + valor2;
            System.out.println("Resultado: " + resultado);
        }

        if (opcao == 2) {
            resultado = valor1 - valor2;
            System.out.println("Resultado: " + resultado);
        }

        if (opcao == 3) {
            resultado = valor1 * valor2;
            System.out.println("Resultado: " + resultado);
        }

        if (opcao == 4) {
            if (valor2 != 0) {
                resultado = valor1 / valor2;
                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Erro: divisao por zero nao e permitida.");
            }
        }

        if (opcao < 1 || opcao > 4) {
            System.out.println("Opcao invalida.");
        }

        entrada.close();
    }
}