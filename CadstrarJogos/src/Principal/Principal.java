package Principal;
import java.util.Scanner;

import Objetos.Jogo;

import java.util.List;
import java.util.ArrayList;

public class Principal {
	static Scanner scan = new Scanner(System.in);
	static List<Jogo> listarjogos = new ArrayList<Jogo>();
	public static void main(String[] args) {
		mostrarMenu();
		
	}
	
	public static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Cadastrar jogo");
			System.out.println("2 - Listar jogos");
			System.out.println("4 - Atualizar Jogo");
			System.out.println("5 - Excluir Jogo");
			System.out.println("0 - Saida");
			escolhaUsuario = scan.nextInt();
			validarEscolha(escolhaUsuario);
		}while(escolhaUsuario!=0);
		
	}
	
	public static void validarEscolha(int escolhaUsuario) {
		
		
		scan.nextLine();
		switch(escolhaUsuario) {
		case 1:
			cadastrarjogo();
			break;
		case 2:
			listarJogos();
			break;
		case 3:
			atualizarDados();
			break;
		case 4:atualizarDados();
		case 5:
			buscarId();
		case 6:
		
			
			
		}
	}
	public static void cadastrarjogo() {
		System.out.println("Digite o nome do jogo:\n");
		String jogo = scan.nextLine();
		System.out.println("Digite o genero do jogo:\n");
		String genero = scan.nextLine();
		
		Jogo jogos = new Jogo(jogo,genero);
		
		listarjogos.add(jogos);
	}
	public static void listarJogos() {
		for (int i =0;i<listarjogos.size();i++) {
			System.out.printf("%d - %s / %s ",i, listarjogos.get(i).getNome(), listarjogos.get(i).getGenero());
		}
	}
	public static void atualizarDados() {
		listarJogos();
		System.out.println("Digite o id do jogo que queira atualizar");
		int id = scan.nextInt();
		scan.nextLine();
		if(id>=0&&id<listarjogos.size()) {
			System.out.println("Digite o novo nome");
			String novonome = scan.nextLine();
			System.out.println("Digite o novo genero");
			String novogenero = scan.nextLine();
			
			Jogo jogo = listarjogos.get(id);
			jogo.setNome(novonome);
			jogo.setGenero(novogenero);
			
			
			
		}
	}
		
	public static void deletarJogo() {
		listarJogos();
		System.out.println("Digite o id do jogo que deseja remover\n");
		int remove = scan.nextInt();
		listarjogos.remove(remove);
		
	}
	public static void buscarId() {
		System.out.println("Digite o id do jogo que busca:\n");
		int id = scan.nextInt();
		if (id<=listarjogos.size()) {
			System.out.println(listarjogos.get(id).getNome());
		}
	}
}