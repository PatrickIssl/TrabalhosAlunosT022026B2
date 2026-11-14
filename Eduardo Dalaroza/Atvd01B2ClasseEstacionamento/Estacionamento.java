package Atvd01B2ClasseEstacionamento;
import java.util.Scanner;

public class Estacionamento {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        Veiculo veiculo = new Veiculo();

        System.out.println("Qual o modelo do carro? ");
        veiculo.modelo = entrada.nextLine();

        System.out.println("Qual a placa do carro? ");
        veiculo.placa = entrada.nextLine();

        System.out.println("Quantos minutos ele ficou estacionado? ");
        int minutos = entrada.nextInt();

        veiculo.adicionarTempo(minutos);
        veiculo.calcularValor();
        veiculo.exibirResumo();

        entrada.close();

    }

}
