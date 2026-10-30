package Principal;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	static Scanner scan = new Scanner(System.in);
	static List<Livros> listarlivros = new ArrayList<Livros>();
	static List<Pessoa> Listarpessoa = new ArrayList<Pessoa>();

	public static void main(String[] args) {
		mostrarMenu();

	}

	public static void mostrarMenu() {
		int escolhaUsuario = 0;

		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Listar livros");
			System.out.println("2 - Cadastrar livro");
			System.out.println("3 - Excluir livro");
			System.out.println("4 - Locar livro");
			System.out.println("5 - Devolver livro");
			System.out.println("6-  Registrar usuario");
			System.out.println("7-  Listar usuarios");
			System.out.println("0 - Saida");

			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);

		} while (escolhaUsuario != 0);

	}

	public static void validarEscolha(int escolhausuario) {
		switch (escolhausuario) {
		case 1: {
			listarLivros();
			break;
		}
		case 2: {
			cadastrarLivros();
			break;
		}
		case 3: {
			excluirLivro();
			break;
		}
		case 4: {
			locarLivro();
			break;
		}
		case 5: {
			devolverLivro();
			break;
		}
		case 6: {
			registrarUsuario();
			break;
		}
		case 7: {
			listarUsuarios();
			break;
		}
		case 0: {
			break;
		}
		default :
			System.out.println("Insira um digito valido");
		}
	}

	public static void cadastrarLivros() {

		System.out.println("Digite o nome do livro que deseja adicionar");
		String nomeLivro = scan.nextLine();
		Livros livro = new Livros(nomeLivro);
		livro.setNome(nomeLivro);
		listarlivros.add(livro);
		System.out.println("Livros cadastrados: " + listarlivros.size());

	}

	public static void excluirLivro() {
		listarUsuarios();
		System.out.println("");
		listarLivros();
		System.out.println("\nDigite o indice do livro que deseja excluir");
		int indice = scan.nextInt();
		scan.nextLine();

		if (indice >= 0 && indice < listarlivros.size()) {
			listarlivros.remove(indice);
		}
	}

	public static void listarLivros() {
		if(listarlivros.size()>0) {
		String VERMELHO = "\u001B[31m";
		String RESET = "\u001B[0m";
		for (int i = 0; i < listarlivros.size(); i++) {
			System.out.printf("%d- %s - ", i, listarlivros.get(i).getNome());

			if (listarlivros.get(i).getDataLocação() == null) {
				System.out.println(listarlivros.get(i).validarDisponibilidade());
			} else {
				System.out.println(listarlivros.get(i).validarDisponibilidade());

			}

		}
		}else {
		System.out.println("Não há livros cadastrados");
	}
	}

	public static void locarLivro() {

		if (Listarpessoa.size() > 0) {

			listarUsuarios();

			System.out.println("Digite o indice do usuario que deseja locar o livro");
			int indice = scan.nextInt();
			scan.nextLine();

			if (indice >= 0 && indice < Listarpessoa.size()) {

				listarLivros();

				System.out.println("Digite o indice do livro que deseja locar");
				int indiceLivro = scan.nextInt();
				scan.nextLine();
				if (indiceLivro >= 0 && indiceLivro < listarlivros.size()) {
					if (listarlivros.get(indiceLivro).getDataLocação() == null) {
						listarlivros.get(indiceLivro).setDataLocação(new Date());
						Listarpessoa.get(indice).getLivroslocados().add(listarlivros.get(indiceLivro));
						System.out.println("Livro locado com sucesso!");
					} else {
						System.out.println("Livro ja Locado");
					}
				} else {
					System.out.println("Insira um indice valido");
				}
			} else {
				System.out.println("Insira um indice valido");
			}
		} else {
			System.out.println("Não existem usuarios cadastrados");
		}
	}


public static void devolverLivro() {

    if (Listarpessoa.size() > 0) {
        listarUsuarios();
        System.out.println("Digite o indice do usuario que deseja devolver o livro");
        int indice = scan.nextInt();
        scan.nextLine();

        if (indice >= 0 && indice < Listarpessoa.size()) {

           if (Listarpessoa.get(indice).getLivroslocados().size() > 0) {

               for (int i = 0; i < Listarpessoa.get(indice).getLivroslocados().size(); i++) {
                   System.out.println(i + "- " +
                        Listarpessoa.get(indice).getLivroslocados().get(i).getNome());
                }
               System.out.println("Digite o indice do livro que deseja devolver");
               int indiceLivro = scan.nextInt();
               scan.nextLine();
               if (indiceLivro >= 0 && indiceLivro < Listarpessoa.get(indice).getLivroslocados().size()) {
                   Listarpessoa.get(indice).getLivroslocados().get(indiceLivro).setDataLocação(null);
                   Listarpessoa.get(indice).getLivroslocados().remove(indiceLivro);
                   System.out.println("Livro devolvido com sucesso!");
               } else {
                   System.out.println("Indice não encontrado");
               }
           } else {
               System.out.println("Esse usuario não possui livros locados");
           }
        } else {
            System.out.println("Digite um indice valido");
        }
    } else {
        System.out.println("Não existem usuarios cadastrados");
    }
}

	public static void registrarUsuario() {
		System.out.println("Digite seu nome");
		String nome = scan.nextLine();
		Pessoa pessoa = new Pessoa(nome);
		pessoa.setNome(nome);

		Listarpessoa.add(pessoa);
		System.out.println("Usuario cadastrado com sucesso\n");

	}

	public static void listarUsuarios() {
		for (int i = 0; i < Listarpessoa.size(); i++) {
			System.out.printf("%d- %s%n", i, Listarpessoa.get(i).getNome());

		}
	}
}