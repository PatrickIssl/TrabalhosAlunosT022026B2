package sistemagerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Produto>produtos = new ArrayList<>();
		//ArrayList<Usuario>usuarios = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		int proximoId = 1;
		int opcao;
		//int idade;

		do {
			System.out.println("=====SISTEMA=====");
			System.out.println("---------------------------------");
			System.out.println("1 - Cadastrar Produto");
			System.out.println("2 - Listar");
			System.out.println("3 - Alterar");
			System.out.println("4 - Excluir");
			System.out.println("0 - Sair");

			System.out.println("---------------------------------");
			System.out.println("Escolha uma opção: ");
			opcao = scan.nextInt();
			scan.nextLine();

			if(opcao == 1) {
				System.out.println("=====CADASTRAR=====");
				System.out.println("---------------------------------");

				System.out.println("Informe o nome do produto: ");
				String nome = scan.nextLine();
				System.out.println("Informe a categoria do produto: ");
				String categoria = scan.nextLine();
				System.out.println("Informe o preço do produto: R$");
				double preco = scan.nextDouble();

				Produto produto = new Produto(proximoId, nome, categoria, preco);
				produtos.add(produto);
				proximoId++;

				System.out.println("**PRODUTO CADASTRADO COM SUCESSO!**");

			}
			else if(opcao == 2) {
				System.out.println("=====LISTAR=====");
				System.out.println("---------------------------------");

				if(produtos.isEmpty()) {
					System.out.println("Nenhum produto cadastrado.");
				}
				else {
					for(Produto p : produtos) {
						System.out.println("=====PRODUTO ENCONTRADO!=====");
						System.out.println("*****************************");
						System.out.println("° ID: " + p.getId());
						System.out.println("° Nome: " + p.getNome());
						System.out.println("° Categoria: " + p.getCategoria());
						System.out.println("° Preço: R$" + p.getPreco());
						System.out.println("---------------------------------");
					}
				}

			}
			else if(opcao == 3) {
				System.out.println("=====ALTERAR=====");
				System.out.println("---------------------------------");

				System.out.println("Digite o ID do produto que deseja alterar: ");
				int idBusca = scan.nextInt();
				scan.nextLine();

				boolean encontrado = false;

				for(Produto p : produtos) {
					if(p.getId() == idBusca) {
						System.out.println("=====PRODUTO ENCONTRADO!=====");
						System.out.println("*****************************");
						System.out.println("° ID: " + p.getId());
						System.out.println("° Nome: " + p.getNome());
						System.out.println("° Categoria: " + p.getCategoria());
						System.out.println("° Preço: R$" + p.getPreco());
						System.out.println("---------------------------------");

						System.out.println("****PREENCHA OS CAMPOS ABAIXO****");
						System.out.println("NOVO NOME: ");
						String novoNome = scan.nextLine();
						System.out.println("NOVA CATEGORIA: ");
						String novaCategoria = scan.next();
						System.out.println("NOVO PRECO: ");
						double novoPreco = scan.nextDouble();

						p.setNome(novoNome);
						p.setCategoria(novaCategoria);
						p.setPreco(novoPreco);

						encontrado = true;
						break;
					}
					System.out.println("PRODUTO ATUALIZADO COM SUCESSO!");
				}

			}
			else if(opcao == 4) {
				System.out.println("=====EXCLUIR=====");
				System.out.println("Digite o ID do produto que deseja excluir: ");
				int idBusca = scan.nextInt();
				scan.nextLine();

				boolean encontrado = false;

				for(Produto p : produtos) {
					System.out.println("=====PRODUTO ENCONTRADO!=====");
					System.out.println("*****************************");
					System.out.println("° ID: " + p.getId());
					System.out.println("° Nome: " + p.getNome());
					System.out.println("° Categoria: " + p.getCategoria());
					System.out.println("° Preço: R$" + p.getPreco());
					System.out.println("---------------------------------");

					produtos.remove(p);

					encontrado = true;
					break;
				}
				System.out.println("****PRODUTO EXCLUÍDO COM SUCESSO*****");
			}
			/*else if(opcao == 5) {
				System.out.println("=====DISPONIBILIDADE=====");
				System.out.println("-------------------------");
				System.out.println("Digite o ID do produto que deseja verificar: ");
				int idBusca = scan.nextInt();
				scan.nextLine();

				boolean encontrado = false;

				for(Produto p : produtos) {
					if(p.getId() == idBusca) {
						System.out.println("=====PRODUTO ENCONTRADO!=====");
						System.out.println("*****************************");
						System.out.println("Produto: " + p.getNome());
						System.out.println("-----------------------------");
					}
					if(p.isDisponivel()) {
						System.out.println("Produto Disponível!");
					}
					else {
						System.out.println("Produto Indisponível!");
					}
					encontrado = true;
					break;
				}

			}*/
			/*if(opcao == 6) {
				System.out.println("=====CADASTRAR USUARIO=====");
				//System.out.println("---------------------------------");

				System.out.println("Informe o nome do usuário: ");
				String nome = scan.nextLine();
				System.out.println("Informe a idade do usuário: ");
				int Idade = scan.nextInt();
				scan.nextLine();

				Usuario usuario= new Usuario(proximoId, nome, Idade);
				usuarios.add(usuario);
				proximoId++;

				System.out.println("**Usuario cadastrado com sucesso!**");

			}
			else if(opcao == 7) {
				System.out.println("=====LISTAR USUARIO=====");
				System.out.println("---------------------------------");

				if(usuarios.isEmpty()) {
					System.out.println("Nenhum usuario cadastrado.");
				}
				else {
					for(Usuario u : usuarios) {
						System.out.println("=====USUARIO ENCONTRADO!=====");
						System.out.println("*****************************");
						System.out.println("° ID: " + u.getId());
						System.out.println("° Nome: " + u.getNome());
						System.out.println("° Idade: " + u.getIdade());
						System.out.println("---------------------------------");
					}
				}

			}*/
			else if(opcao == 0) {
				System.out.println("=====Obrigado por usar nosso sistema!=====");
			}
			else {
				System.out.println("*=====Opção inválida!=====*");
			}

		}while(opcao != 0);


	}

}
