import java.util.Scanner;

public class Um {
	
	static Scanner scan = new Scanner (System.in);
	static double saldo = 0;
	static int op=0;
	static double dp=0, sq=0;
	
	
	public static void main(String[] args) {
		
		int senha = 9999, ten = 0;
		boolean acesso = false;
		
		while (ten < 3) {
			Senha();
			int s = scan.nextInt();
			
			if (s == senha) {
				acesso = true;
				break;
			}
			else {
				ten++;
				System.out.println("Senha errada!");
			}
		}
		
		if(acesso == false) {
			System.out.println("Conta bloqueada!");
		}
		else {

		
		while (op != 4) {
		Menu();
		op = scan.nextInt();
		
			if (op == 1) {
				System.out.printf("Saldo: R$%.2f \n\n", saldo);
				
			}
			
			if (op == 2) {
				do {
				System.out.println("Entre com o valor para deposito: ");
				dp = scan.nextDouble();
				if (dp < 0) {
					System.out.println("O valor precisa ser positivo");
				}
				} while (dp < 0);
				saldo += dp;
				}
			
			
			
			if (op == 3) {
		
				saldo = Opicao3();
			}
			if (op == 4) {
				System.out.println("Saindo...");
			}
			if ((op < 1)||(op > 4)) {
				System.out.println("Opção invalido, entre com outra valida!");
				System.out.println();
			}
		}
		}
		
	}
	
	public static void Menu() {
		System.out.println("Menu de opçoes:");
		System.out.println("1 - Consultar saldo");
		System.out.println("2 - Depositar dinheiro");
		System.out.println("3 - Sacar dinheiro");
		System.out.println("4 - Sair");
		System.out.println("Digite o número da informação");
	}
	public static void Senha() {
		System.out.println("Entre com a senha: ");
	}
	public static double Opicao3(){
		do
		{
			System.out.println("Entre com o valor do deposito: ");
			sq = scan.nextInt();
			System.out.println();
		
		if (sq > saldo) {
			System.out.println("Valor em conta inferior");
			return saldo;
		}
		}while (sq > saldo);
		System.out.println();

		System.out.printf("Saque realizado com sucesso!!!\n\n");
		
		if (sq <= 0) {
			saldo += sq;
			return saldo;
		}
		else {
			
			saldo -= sq;
			return saldo;
		}
	}


}
