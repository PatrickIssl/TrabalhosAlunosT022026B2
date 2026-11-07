import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Retangulo retangulo = new Retangulo();
        System.out.println("===== Calculadora de área e perímetro de um retângulo =====");
        System.out.print("Informe a largura: ");
        retangulo.setLargura(sc.nextDouble());

        System.out.print("Informe a altura: ");
        retangulo.setAltura(sc.nextDouble());

        System.out.println("Área: " + retangulo.calcularArea());

        System.out.println("Perímetro: " + retangulo.calcularPerimetro());

        sc.close();
    }
}