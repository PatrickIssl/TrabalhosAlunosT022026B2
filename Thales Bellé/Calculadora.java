import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        double n1, n2;
        int opcao;

        System.out.print("Digite o primeiro numero: ");
        n1 = ler.nextDouble();

        System.out.print("Digite o segundo numero: ");
        n2 = ler.nextDouble();

        System.out.println("1 - Somar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");

        System.out.print("Escolha uma opcao: ");
        opcao = ler.nextInt();

        if (opcao == 1)
            System.out.print("Resultado: " + (n1 + n2));

        if (opcao == 2)
            System.out.print("Resultado: " + (n1 - n2));

        if (opcao == 3)
            System.out.print("Resultado: " + (n1 * n2));

        if (opcao == 4)
            System.out.print("Resultado: " + (n1 / n2));
    }
}