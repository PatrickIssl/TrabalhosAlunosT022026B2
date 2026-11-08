import java.util.Scanner;

public class Calculadora{

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++){
            System.out.println("Aluno: ");
            String aluno = scan.nextLine();
            System.out.println("Insira nota 1: ");
            double nUm = scan.nextDouble();
            System.out.println("Insira nota 2: ");
            double nDois = scan.nextDouble();
            System.out.println("Insira nota 3: ");
            double nTres = scan.nextDouble();
            double resultado = calcularMedia(nUm, nDois, nTres);
            String situacao = verifAprov(resultado);
            exibirResultado(aluno, resultado, situacao);
            scan.nextLine();
        }
    }

public static double calcularMedia(double nUm, double nDois, double nTres){
    return (nUm+nDois+nTres)/3;
}

public static String verifAprov(double nota){
    if (nota >= 7){
     return "Aprovado";
    }
    else {
    return "Reprovado";
    }
}

public static void exibirResultado(String nome, double media, String status){
    System.out.println("Aluno: "+nome);
    System.out.println("Media: "+media);
    System.out.println("Situação: "+status);

}







}