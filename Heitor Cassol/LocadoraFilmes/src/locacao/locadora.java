
package locacao;

import java.util.Scanner;

public class locadora {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Filmes[] filmes = {
            new Filmes("O Poderoso Chefão", 1972, "Francis Ford Coppola"),
            new Filmes("De Volta para o Futuro", 1985, "Robert Zemeckis"),
            new Filmes("Jurassic Park", 1993, "Steven Spielberg"),
            new Filmes("Rocky: Um Lutador", 1976, "John G. Avildsen"),
            new Filmes("Tubarão", 1975, "Steven Spielberg")
        };

        Cliente cliente = new Cliente("João", 1);
        Locacao locacao = new Locacao();

        int opcao;
        int escolha;

        do {
            System.out.println("\n=== LOCADORA DE FILMES ===");
            System.out.println("1 - Listar filmes");
            System.out.println("2 - Alugar filme");
            System.out.println("3 - Devolver filme");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = entrada.nextInt();

            switch (opcao) {

                case 1:
                    for (int i = 0; i < filmes.length; i++) {
                        System.out.println("\nFilme " + (i + 1));
                        filmes[i].exibirFilme();
                    }
                    break;

                case 2:
                    System.out.println("\nEscolha o filme para alugar:");

                    for (int i = 0; i < filmes.length; i++) {
                        System.out.println((i + 1) + " - " + filmes[i].nome);
                    }

                    escolha = entrada.nextInt();

                    if (escolha >= 1 && escolha <= filmes.length) {
                        locacao.alugar(filmes[escolha - 1], cliente);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 3:       
                	locacao.devolver(cliente);
                	break;


                case 0:
                    System.out.println("Encerrando locadora...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}
