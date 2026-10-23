import java.util.Arrays;
import java.util.Scanner;

public class Aula0409 {

    public static void main(String[] args) {

        Double[] notas = notas();
        System.out.println("Notas inseridas: " + Arrays.toString(notas));


        Double media = media(notas);
        System.out.println("Média das notas: " + media);

        double maior = notas[0];
        double menor = notas[0];
        for (double nota: notas) {
            if (nota > maior ) maior = nota;
            if (nota < menor ) menor = nota;
        }
        System.out.println("Maior nota: " + maior);
        System.out.println("Menor nota: " + menor);
        System.out.println("Quantidade de notas acima da média: " + acimaMedia(notas, media));
    }

    public static Double[] notas() {
        Double[] notas = new Double[5];
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < notas.length; i++) {
                System.out.print("Digite a " + (i + 1) + " nota: ");
                notas[i] = scanner.nextDouble();
            }
        }
        return notas;
    }

    public static Double media(Double[] notas) {
        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public static int acimaMedia(Double[] notas, Double media){
        int acimaMedia = 0;
        for (Double nota : notas) {
            if (nota > media) {
                acimaMedia++;
            }
        }
        return acimaMedia;
    }

}