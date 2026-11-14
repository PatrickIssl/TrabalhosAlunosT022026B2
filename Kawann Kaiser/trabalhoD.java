import java.util.Scanner;
public class trabalhoD {
	
	static Scanner scan = new Scanner(System.in);
	static double limite = 500;
	static double  saldo = 0;
	
	public static void main(String[] args) {
		
		int senha = 4237;
		
		int cont = 3;
		
		 // Mantém o sistema funcionando enquanto ainda existirem tentativas
		while (cont != 0){
			
			System.out.println("(Para sair informe 0000) \ninforme sua senha de acesso: ");
			int senhaop = scan.nextInt();
			int operador = 0;
			if (senhaop == senha) {
				
			      // Exibe o menu até o usuário escolher a opção 4
				while(operador != 4) {
					
					System.out.printf("seu limite diário para saques atual é %.2f\n", limite);
					System.out.println("\n --Qual opção deseja realizar-- \n 1) para Consultar saldo. \n 2) para Depositar dinheiro. \n 3) para Sacar dinheiro. \n 4) para Sair. \n --(Informe o número da opção)--");
					operador = scan.nextInt();

					if (operador == 1) {
						// Opção de saldo
						consulta();

					}else if (operador == 2) {
						// opção de deposito
						deposito();

					}else if (operador == 3 ) {
						//opção de saque
						sacar();
		    
					}else if (operador == 4 ) {
						//opção de saque
						System.out.println("Sessão encerrada, tenha um ótimo dia!");
		    
					}else {
						System.out.println("Opção inválida. Tente novamente.");
					}
				}
				
			}else if (senhaop == 0000) {
				
				cont = 0;
				
			}else if(cont > 0 ) {
				cont -= 1;
				System.out.printf("Senha incorreta, ");
				
				if (cont == 0) {
					System.out.println("Conta bloqueada \n");
				}else {
					System.out.println("Tente novamente \n");
				}
				
			}
		}
	}

	   // Método responsável por realizar os saques
	public static void sacar() {
		System.out.println("Qual o valor para saque desejado?");
		double saque = scan.nextDouble();


		if (limite >= saque) {
			if (saque <= saldo && saque >= 0 ) {

				saldo = (saldo - saque);
				System.out.println("Saque aprovado, saldo suficente. ");
				consulta();
				limite -= saque;

			}else if (saque > 0) {
				System.out.println("Saldo insuficiente.");
			}
			else {
				System.out.println("Valor invalido.");		
				consulta();
			}


		}else {
			System.out.printf("limite diário ultrapassado, seu limite diário atual é %.2f\n", limite);
		}
	}
	
	
	public static void consulta() {
		System.out.printf("O valor atual do saldo é : R$ %.2f\n", saldo );
	}
	 // Método responsável por realizar os depositos
	public static void deposito() {
		System.out.println("Informe o valor do depósito:");
		double deposito = scan.nextDouble();

		if (deposito > 0 ) {

			System.out.println("Deposito aprovado. Valor transferido com sucesso.");
			saldo += deposito;

		} else {
			System.out.println("Valor inválido.");

		}

	}
}
