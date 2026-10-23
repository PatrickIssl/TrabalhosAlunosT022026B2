package Fag;

import java.util.Scanner;

import Fag.Objeto.Cofrinho;

public class Principal {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Digite seu nome: ");
		String dono = scan.nextLine();

		System.out.println("Digite sua meta: ");
		double meta = scan.nextDouble();

		Cofrinho cofrinho = new Cofrinho(dono, meta);

		int opcao = 0;

		while (opcao != 5) {

			System.out.println("\n1 - Depositar");
			System.out.println("2 - Retirar");
			System.out.println("3 - Exibir saldo");
			System.out.println("4 - Verificar meta");
			System.out.println("5 - Sair");
			System.out.println("Escolha uma opcao: ");

			opcao = scan.nextInt();

			if (opcao == 1) {

				System.out.println("Digite o valor do deposito: ");
				double valor = scan.nextDouble();

				cofrinho.depositar(valor);

			} else if (opcao == 2) {

				System.out.println("Digite o valor da retirada: ");
				double valor = scan.nextDouble();

				cofrinho.retirar(valor);

			} else if (opcao == 3) {

				cofrinho.exibirSaldo();

			} else if (opcao == 4) {

				cofrinho.verificarMeta();

			} else if (opcao == 5) {

				System.out.println("Volte sempre!");

			} else {

				System.out.println("Opcao invalida.");
			}
		}

		scan.close();
	}
}