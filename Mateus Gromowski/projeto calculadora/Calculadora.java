import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o primeiro numero: ");
        double primeiro = sc.nextDouble();
        sc.nextLine();
        System.out.print("Insira o segundo numero: ");
        double segundo = sc.nextDouble();
        sc.nextLine();
        System.out.println("=== MENU ===");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtracao");
        System.out.println("3 - Multiplicacao");
        System.out.println("4 - Divisao");
        System.out.print("Sua escolha: ");
        int escolha = sc.nextInt();
        sc.nextLine();
        if (escolha > 4 || escolha < 1) {
            System.out.println("Entrada inválida.");
        } else {
            if (escolha == 1) {
                System.out.printf("%.2f + %.2f = %.2f\n", primeiro, segundo, primeiro + segundo);
            } else if (escolha == 2) {
                System.out.printf("%.2f - %.2f = %.2f\n", primeiro, segundo, primeiro - segundo);
            } else if (escolha == 3) {
                System.out.printf("%.2f * %.2f = %.2f\n", primeiro, segundo, primeiro * segundo);
            } else {
                if (segundo == 0) {
                    System.out.println("Entrada invalida. Nao ha divisao por zero.");
                } else {
                    System.out.printf("%.2f / %.2f = %.2f\n", primeiro, segundo, primeiro / segundo);
                }
            }
        }
        sc.close();
    }
}