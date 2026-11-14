package Jogos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Jogos.objetos.Jogos;

public class Catalogo {

	static Scanner scan = new Scanner(System.in);
	static int cont = 0;
	static List<Jogos> listaJogos = new ArrayList<Jogos>();
	public static void main(String[] args) {
		popularJogos();
		cont = listaJogos.size();
		System.out.println("Sistema de catalogo iniciado!");
		mostrarMenu();
		scan.close();
		

	}
	
	public static void popularJogos() {
		
	    listaJogos.add(new Jogos("Minecraft", 1, "Sandbox"));
	    listaJogos.add(new Jogos("Red Dead Redemption 2", 2, "Ação/Aventura"));
	    listaJogos.add(new Jogos("The Witcher 3", 3, "RPG"));
	    listaJogos.add(new Jogos("Grand Theft Auto V", 4, "Ação"));
	    listaJogos.add(new Jogos("Cyberpunk 2077", 5, "RPG"));
	    listaJogos.add(new Jogos("Elden Ring", 6, "RPG"));
	    listaJogos.add(new Jogos("God of War", 7, "Ação/Aventura"));
	    listaJogos.add(new Jogos("Hollow Knight", 8, "Metroidvania"));
	    listaJogos.add(new Jogos("Stardew Valley", 9, "Simulação"));
	    listaJogos.add(new Jogos("Terraria", 10, "Sandbox"));
	    
	}
	
	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Listar Jogos");
			System.out.println("2 - Cadastrar Jogos");
			System.out.println("3 - Busca por ID");
			System.out.println("4 - Atualizar registro");
			System.out.println("5 - Excluir Jogo");
			System.out.println("0 - Sair");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}
	
	
	
	public static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0: {
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1: {
			listar();
			break;
		}
		case 2: {
			cadastrar();
			break;
		}
		case 3: {
			buscaID();
			break;
		}
		case 4: {
			atualizar();
			break;
		}
		case 5: {
			excluir();
			break;
		}
		default:
			System.out.println("Insira uma opção válida!");
		}
	}

	private static void atualizar() {
		if (listaJogos.size() == 0) {
			System.out.println("Não existem Jogos cadastrados!");
		}
		listar();
		System.out.println("Informe o ID para atualizar: ");
		int escolha = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < listaJogos.size(); i++) {
			if(listaJogos.get(i).getID() == escolha) {
				System.out.println("\n--------ID encontrado--------");
				System.out.println("Informe o Novo nome para o jogo: ");
				listaJogos.get(i).setNome(scan.nextLine());
				System.out.println("Informe o Novo Genero para o jogo: ");
				listaJogos.get(i).setGenero(scan.nextLine());
				return;
				
			}
			
		}
		System.out.println("\n--------ID não encontrado --------");
		
		
	}

	private static void buscaID() {
		
		if (listaJogos.size() == 0) {
			System.out.println("Não existem Jogos cadastrados!");
		}
		
		System.out.println("Informe o ID para busca: ");
		int escolha = scan.nextInt();
		
		for (int i = 0; i < listaJogos.size(); i++) {
			if(listaJogos.get(i).getID() == escolha) {
				System.out.println("\n--------ID encontrado--------");
				System.out.printf("[ ID - %d ] %s - %s \n", listaJogos.get(i).getID(),listaJogos.get(i).getNome(), listaJogos.get(i).getGenero());
				return;
				
			}
			
		}
		System.out.println("\n--------ID não encontrado --------");
		
		
	}

	private static void cadastrar() {
		Jogos jogo = new Jogos();

		System.out.println("Informe o nome do Jogo: ");
		jogo.setNome(scan.nextLine());
		System.out.println("Informe o gênero do Jogo: ");
		jogo.setGenero(scan.nextLine());
		jogo.setID(cont+1);

		if (jogo.getNome().isEmpty() || jogo.getGenero().isEmpty()) {
			System.out.println("Preencha o nome e o gênero do jogo");
			return;
		}

		listaJogos.add(jogo);
		cont += 1;
		System.out.println("Jogo cadastrado com sucesso");
	}

	private static void listar() {
		System.out.println("\n--------Lista de Jogos--------");
		if (listaJogos.size() == 0) {
			System.out.println("Não existem Jogos cadastrados!");
		}
		for (int i = 0; i < listaJogos.size(); i++) {
			System.out.printf("[ ID - %d ] %s - %s \n", listaJogos.get(i).getID(),listaJogos.get(i).getNome(), listaJogos.get(i).getGenero());
		}
		System.out.println("");
	}
	
	private static void excluir() {
		if (listaJogos.size() == 0) {
			System.out.println("Não existem jogos para excluir");
			return;
		}

		listar();
		System.out.println("Informe o ID do jogo a ser excluído: ");
		int escolhaUsuario = scan.nextInt();
		scan.nextLine();

		if (escolhaUsuario < 0 || escolhaUsuario >= listaJogos.size() + 1) {
			System.out.println("Informe um jogo válido!");
			return;
		}
		for (int i = 0; i <= listaJogos.size(); i++) {
			if(listaJogos.get(i).getID() == escolhaUsuario) {
				System.out.println("\n--------ID encontrado e excluído--------");
				listaJogos.remove(i);
				return;
				
			}
		}
		
	}

}
