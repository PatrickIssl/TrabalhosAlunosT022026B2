import java.util.Scanner;

public class aula {

    public static void main(String[] args) {calculadora();}

    public static void calculadora() {

        Scanner entrada = new Scanner(System.in);

        String senha = "123";
        double opcao = 0;
        double saldo = 400;


        System.out.println("Digite a senha para acessar: ");
        String senhaUsuario = entrada.next();

        if (senhaUsuario.equals(senha)){
            while (opcao != 4) {

                System.out.println("---------------------------");
                System.out.println("1 - Consultar saldo: ");
                System.out.println("2 - Depositar dinheiro: ");
                System.out.println("3 - Sacar dinheiro: ");
                System.out.println("4 - Sair: ");
                System.out.println("---------------------------");


                opcao = entrada.nextInt();

                if (opcao == 1) {
                    System.out.println("Seu saldo é: R$"+ saldo);

                } else if (opcao == 2) {
                    System.out.println("Digite a quantidade que deseja depositar: R$");
                    double valor = entrada.nextDouble();
                    if (valor <= 0) {
                        System.out.println("Saldo digitado insuficiente! ");
                    } else {
                        System.out.println("Voce depositou R$" + valor);
                        saldo = saldo + valor;
                        System.out.println("O seu saldo atual é: R$" + saldo);
                    }

                } else if (opcao == 3) {
                    System.out.println("Digite o valor que deseja sacar: R$");
                    double sacar = entrada.nextDouble();
                    if (sacar > 500) {
                        System.out.println("Valor de saque diário ultrapassado! ");
                        System.out.println("Tente novamente! ");

                    } else {
                        if (sacar > saldo) {
                            System.out.println("Saldo para saque insuficiente! ");
                        } else if (sacar <= 0) {
                            System.out.println("Saldo para saque insuficiente!");
                        } else {
                            System.out.println("Voce sacou: R$" + sacar);
                            saldo = saldo - sacar;
                            System.out.println("Seu saldo final é: R$" + saldo);
                        }
                    }
                } else if (opcao == 4) {
                    System.out.println("Saindo...");
                } else {
                    System.out.println("Opcao inválida!");
                }

            }
        }else{
            System.out.println("Senha inválida! Tente novamente.");
        }
    }
}