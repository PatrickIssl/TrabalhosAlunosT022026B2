

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("1 - Pessoa");
        System.out.println("2 - Carro");
        System.out.println("3 - Aluno");
        System.out.println("4 - Produto");
        System.out.println("5 - Conta");
        System.out.println("6 - Livro");
        System.out.println("7 - Funcionario");
        System.out.println("8 - Retangulo");
        System.out.println("9 - Celular");
        System.out.println("10 - Cadastro de Pessoas");

        int opcao = scanner.nextInt();

        if (opcao == 1) {

            Pessoa pessoa = new Pessoa("Ana", 25);
            pessoa.apresentar();

        } else if (opcao == 2) {

            Carro carro = new Carro("Toyota", "Corolla", 2025);
            carro.exibirDados();

        } else if (opcao == 3) {

            Aluno aluno = new Aluno("Ana", 19, 7.0);
            aluno.verificarSituacao();

        } else if (opcao == 4) {

            Produto produto = new Produto("Arroz", 10, 7);
            produto.calcularTotal();

        } else if (opcao == 5) {

            Conta conta = new Conta("Ana", 1000);

            while (true) {

                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Consultar saldo");
                System.out.println("2 - Depositar");
                System.out.println("3 - Sacar");
                System.out.println("4 - Sair");

                int opcaoConta = scanner.nextInt();

                if (opcaoConta == 1) {

                    conta.consultar();

                } else if (opcaoConta == 2) {

                    System.out.println("Digite o valor para depositar:");
                    double valor = scanner.nextDouble();

                    conta.depositar(valor);

                } else if (opcaoConta == 3) {

                    System.out.println("Digite o valor para sacar:");
                    double valor = scanner.nextDouble();

                    conta.sacar(valor);

                } else if (opcaoConta == 4) {

                    System.out.println("Encerrando sistema...");
                    break;

                } else {

                    System.out.println("Opção inválida! Tente novamente.");

                }
            }

        } else if (opcao == 6) {

            Livro livro = new Livro("Dom Casmurro", "Machado de Assis", 256);

            while (true) {

                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Exibir informações");
                System.out.println("2 - Emprestar livro");
                System.out.println("3 - Devolver livro");
                System.out.println("4 - Sair");

                int opcaoLivro = scanner.nextInt();

                if (opcaoLivro == 1) {

                    livro.exibirInformacoes();

                } else if (opcaoLivro == 2) {

                    livro.emprestar();

                } else if (opcaoLivro == 3) {

                    livro.devolver();

                } else if (opcaoLivro == 4) {

                    System.out.println("Saindo do menu do livro...");
                    break;

                } else {

                    System.out.println("Opção inválida!");

                }
            }

        } else if (opcao == 7) {

            Funcionario funcionario = new Funcionario( "Ana", "Desempregada", 2000);

            funcionario.exibirInformacoes();

            System.out.println("\nDigite o percentual de aumento:");
            double percentual = scanner.nextDouble();

            funcionario.aumentarSalario(percentual);
            
            System.out.println("\nApós o aumento:");
            funcionario.exibirInformacoes();

        } else if (opcao == 8) {

            Retangulo retangulo = new Retangulo(5, 3);

            retangulo.exibirInformacoes();

        } else if (opcao == 9) {
        	
        	Celular celular = new Celular("Samsung", "J5", 100);
        	
        	   while (true) {

                   System.out.println("\nEscolha uma opção:");
                   System.out.println("1 - Usar Celular");
                   System.out.println("2 - Carregar Celular");
                   System.out.println("3 - Status da Bateria");
                   System.out.println("4 - Sair");

                   int op = scanner.nextInt();

                   if (op == 1) {
                	   celular.usarCelular();

                   } else if (op == 2) {
                	   celular.carregar();
                      
                   } else if (op == 3) {
                	   celular.exibirBateria();

                   } else if (op == 4) {
                       System.out.println("Saindo do menu do celular...");
                       break;

                   } else {
                       System.out.println("Opção inválida!");

                   }
               }
        	



        } else if (opcao == 10) {

            Cadastro pessoa1 = new Cadastro("Ana", 18, "Cascavel");

            Cadastro pessoa2 = new Cadastro("Beatriz", 13, "Curitiba");

            System.out.println("Pessoa 1:");
            pessoa1.apresentar();
            pessoa1.exibirDados();

            System.out.println("\nPessoa 2:");
            pessoa2.apresentar();
            pessoa2.exibirDados();

            System.out.println("\nApós o aniversário da Pessoa 1a:");

            pessoa1.fazerAniversario();

            pessoa1.exibirDados();
            pessoa2.exibirDados();

        } else {

            System.out.println("Opção inválida!");

        }

        scanner.close();
    }
}
