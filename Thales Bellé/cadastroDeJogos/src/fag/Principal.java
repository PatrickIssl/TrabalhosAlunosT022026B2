package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Jogos;

public class Principal {
	
	static Scanner scan = new Scanner(System.in);
	static List<Jogos> listaJogos = new ArrayList<Jogos>();
	
	public static void main(String[] args) {
		System.out.println("Sistema iniciado!");
		Menu();
	}

	
	public static void Menu() {
		
		int escolhaUsuario = 0;
		
		do {
			System.out.println("===================== Escolha a opção que deseja =====================");
			System.out.println("1 - Cadastrar um jogo");
			System.out.println("2 - Ver jogos cadastrados");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Atualizar Jogo");
			System.out.println("5 - Excluir");
			System.out.println("0 - Sair");
			System.out.println("======================================================================");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
			}while(escolhaUsuario != 0);
	}
	
	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0:{
			System.out.println("Obrigado por utilizar o sistema!");
			break;
		}
		case 1:{
			cadastrarJogo();
			break;
		}
		case 2:{
			listarJogos();
			break;
		}
		case 3:{
			buscarJogoId();
			break;
		}
		case 4:{
			atualizarJogo();
			break;
		}
		case 5:{
			excluirJogo();
			break;
		}
		default:
			System.out.println("Insira um valor valido!");
		}
	}

	public static void cadastrarJogo() {

	    Jogos jogo = new Jogos();

	    System.out.println("Informe o ID do jogo: ");
	    jogo.setId(scan.nextInt());
	    scan.nextLine();

	    System.out.println("Informe o nome do jogo: ");
	    jogo.setNome(scan.nextLine());

	    System.out.println("Informe o genero do jogo: ");
	    jogo.setGenero(scan.nextLine());

	    listaJogos.add(jogo);

	    System.out.println("Jogo cadastrado com sucesso!");

	}
	
	private static void listarJogos() {
		System.out.println("\n--------Lista Jogos--------");
		for (int i = 0; i < listaJogos.size(); i++) {
			System.out.printf("%d) %d - %s / %s\n", i+1, listaJogos.get(i).getId(), listaJogos.get(i).getNome(),listaJogos.get(i).getGenero());
		}
		System.out.println("");
	}
	

	private static void excluirJogo() {
	
	    if (listaJogos.size() == 0) {
	        System.out.println("Não existem jogos para excluir!");
	        return;
	    }
	
	    listarJogos();
	
	    System.out.println("Informe o ID do jogo a ser excluído: ");
	    int idBusca = scan.nextInt();
	
	    for (int i = 0; i < listaJogos.size(); i++) {
	
	        if (listaJogos.get(i).getId() == idBusca) {
	
	            listaJogos.remove(i);
	
	            System.out.println("Jogo removido com sucesso!");
	            return;
	        }
	    }
	
	    System.out.println("Não foi encontrado nenhum jogo com esse ID!");
	
	}

	
	public static void buscarJogoId() {

	    System.out.println("Informe o ID do jogo que deseja buscar: ");

	    int idBusca = scan.nextInt();

	    for (int i = 0; i < listaJogos.size(); i++) {

	        if (listaJogos.get(i).getId() == idBusca) {

	            System.out.println("Jogo encontrado!");
	            System.out.println("ID: " + listaJogos.get(i).getId());
	            System.out.println("Nome: " + listaJogos.get(i).getNome());
	            System.out.println("Genero: " + listaJogos.get(i).getGenero());

	            return;
	        }
	    }

	    System.out.println("Jogo não encontrado!");

	}	
	

public static void atualizarJogo() {

    System.out.println("Qual jogo você deseja atualizar? Informe o ID: ");
    int idBusca = scan.nextInt();
    scan.nextLine();

    for (int i = 0; i < listaJogos.size(); i++) {

        if (listaJogos.get(i).getId() == idBusca) {

            System.out.println("Jogo encontrado!");
            System.out.println("ID atual: " + listaJogos.get(i).getId());
            System.out.println("Nome atual: " + listaJogos.get(i).getNome());
            System.out.println("Gênero atual: " + listaJogos.get(i).getGenero());

            System.out.println("\nInforme o novo nome do jogo: ");
            listaJogos.get(i).setNome(scan.nextLine());

            System.out.println("Informe o novo gênero do jogo: ");
            listaJogos.get(i).setGenero(scan.nextLine());

            System.out.println("Jogo atualizado com sucesso!");

            return;
        }
    }

    System.out.println("Não foi encontrado nenhum jogo com esse ID!");

}

	
}

