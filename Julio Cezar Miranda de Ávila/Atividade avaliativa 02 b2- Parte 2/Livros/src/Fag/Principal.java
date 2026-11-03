package Fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Fag.objetos.Livro;

public class Principal {
	
	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static int contador = 0;
	
	public static void main(String[] args) {
		System.out.println("Sistema iniciado!");
		menu();
	}
	
	private static void menu() {
		int escolhaUsuario;
		do {
			System.out.println("-------- Escolha uma das opções --------");
			System.out.println("1 - Cadastrar livro");
			System.out.println("2 - Listar todos livros");
			System.out.println("3 - Buscar livro por ID");
			System.out.println("4 - Atualizar livro");
			System.out.println("5 - Excluir livro");
			System.out.println("0 - Sair");
			
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}

	private static void validarEscolha(int escolhaUsuario) {
		switch (escolhaUsuario) {
		case 0: {
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1: {
			cadastrarLivro();
			break;
		}
		case 2: {
			listarLivros();
			break;
		}
		case 3: {
			buscarLivro();
			break;
		}
		case 4: {
			atualizarLivro();
			break;
		}
		case 5: {
			excluirLivro();
			break;
		}
		default:
			System.out.println("Incira um valor valido!");
		}
		
	}

	private static void excluirLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Nâo existem livros para excluir!");
			return;
		}
		
		listarLivros();
		System.out.println("Informe o ID do livro que deseja excluir: ");
		int escolhaUsuario = scan.nextInt();
		scan.nextLine();
		
		if (escolhaUsuario > contador) {
			System.out.println("Valor inválido!");
			return;
		}
		
		for (int i = 0; i < listaLivros.size(); i++) {
			if (escolhaUsuario == listaLivros.get(i).getId()) {
				listaLivros.remove(i);
			}
		}
		
		//listaLivros.remove(escolhaUsuario);
		
		System.out.println("Livro excluido com sucesso!");
	}

	private static void atualizarLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Nâo existem livros para atualizar!");
			return;
		}
		
		listarLivros();
		System.out.println("Informe o ID do livro que deseja atualizar: ");
		int escolhaUsuario = scan.nextInt();
		scan.nextLine();
		
		if (escolhaUsuario > contador) {
			System.out.println("Valor inválido!");
			return;
		}
		
		for (int i = 0; i < listaLivros.size(); i++) {
			if (escolhaUsuario == listaLivros.get(i).getId()) {
				System.out.println("Informe o novo título do livro: ");
				listaLivros.get(i).setTitulo(scan.nextLine());
				
				System.out.println("Informe o novo autor do livro: ");
				listaLivros.get(i).setAltor(scan.nextLine());
			}
		}
		
		System.out.println("Livro atualizado com sucesso!");
		
	}

	private static void buscarLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Nâo existem livros para buscar!");
			return;
		}
		
		System.out.println("Informe o ID do livro que deseja buscar: ");
		int escolhaUsuario = scan.nextInt();
		
		if (escolhaUsuario > contador) {
			System.out.println("Valor inválido!");
			return;
		}
		
		for (int i = 0; i < listaLivros.size(); i++) {
			if (escolhaUsuario == listaLivros.get(i).getId()) {
				System.out.printf("%d) %s - %s \n", listaLivros.get(i).getId(), listaLivros.get(i).getTitulo(), listaLivros.get(i).getAltor());
			}
		}
	}

	private static void listarLivros() {
		System.out.println("\n-------- Lista de Livros --------");
		for (int i = 0; i < listaLivros.size(); i++) {
			System.out.printf("%d) %s - %s \n", listaLivros.get(i).getId(), listaLivros.get(i).getTitulo(), listaLivros.get(i).getAltor());
		}
		System.out.println();
	}
	

	private static void cadastrarLivro() {
		Livro livro = new Livro();
		
		System.out.println("Informe o título do livro: ");
		livro.setTitulo(scan.nextLine());
		
		System.out.println("Informe o autor do livro: ");
		livro.setAltor(scan.nextLine());
		
		contador++;
		livro.setId(contador);
		
		listaLivros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}
	
	
}
