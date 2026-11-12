package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fag.objetos.Jogo;

public class Principal {
	static List<Jogo> estoqueJogos = new ArrayList<Jogo>(); 
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("---------Sistema iniciado!---------");
		mostrarMenu();
		scan.close();

	}

	private static void mostrarMenu() {
		int escolha;
		do {
			System.out.println("---------Escolha uma opção!---------");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar jogos");
			System.out.println("3 - Atualizar cadastro");
			System.out.println("4 - Excluir jogo");
			System.out.println("0 - Sair");
			escolha = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolha);
		} while (escolha !=0);
		
	}

	private static void validarEscolha(int escolha) {
		switch (escolha) {
		case 0:{
			System.out.println("Obrigado por utilizar!");
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
			atualizarCadastro();
			break;
		}
		case 4:{
			excluirCadastro();
			break;
		}

		default:
			System.out.println("Informe uma opção valida!");
			break;
		}
	
		
	}

	private static void excluirCadastro() {
		listarJogos();
		System.out.println("Informe o jogo que deseja excluir");
		int escolha = scan.nextInt() - 1;
		
		if (escolha >= estoqueJogos.size() || escolha <0) {
			System.out.println("Informe um Jogo valido");
			return;
		}
		
		estoqueJogos.remove(escolha);
		System.out.println("Jogo excluido com sucesso");
		
	}

	private static void atualizarCadastro() {
		int escolha;
		listarJogos();
		System.out.println("Informe o jogo que deseja atualizar o cadastro");
		escolha = scan.nextInt()-1;
		if (escolha >= estoqueJogos.size() || escolha <0) {
			System.out.println("Informe um jogo valido");
			return;
		}
		scan.nextLine();
		
		System.out.println("Informe o que deseja atualizar");
		System.out.println("1 - Nome");
		System.out.println("2 - Genêro");
		System.out.println("3 - Nome e genêro");
		int escolhaAtributo = scan.nextInt();
		scan.nextLine();
		switch (escolhaAtributo) {
		case 1:{
			System.out.println("Informe o novo nome");
			estoqueJogos.get(escolha).setNome(scan.nextLine());
			System.out.println("Cadastro atualizado com sucesso!");
			break;
		}
		case 2:{
			System.out.println("Informe o novo Genero");
			estoqueJogos.get(escolha).setGenero(scan.nextLine());
			System.out.println("Cadastro atualizado com sucesso!");
			break;
		}
		case 3:{
			System.out.println("Informe o novo nome");
			estoqueJogos.get(escolha).setNome(scan.nextLine());
			
			System.out.println("Informe o novo Genero");
			estoqueJogos.get(escolha).setGenero(scan.nextLine());
			System.out.println("Cadastro atualizado com sucesso!");
			break;
		}

		default:
			System.out.println("Insira um valor válido");
			break;
		}
		
		
		
	}

	private static void listarJogos() {
		for (int i = 0; i < estoqueJogos.size(); i++) {
				System.out.printf("%d) %s - %s \n",i+1,estoqueJogos.get(i).getNome(),estoqueJogos.get(i).getGenero());
		}
		System.out.println("");
		
	}

	private static void cadastrarJogo() {
		Jogo jogo = new Jogo();
		System.out.println("Informe o nome do jogo");
		jogo.setNome(scan.nextLine());
		
		System.out.println("Informe o genero do jogo");
		jogo.setGenero(scan.nextLine());
		
		estoqueJogos.add(jogo); 
		System.out.println("Jogo cadastrado com sucesso!");
	}

	
}
