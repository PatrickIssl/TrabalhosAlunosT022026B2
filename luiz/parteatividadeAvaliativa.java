package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class parteatividadeAvaliativa {
	
	static Scanner scan = new Scanner(System.in);
	static List<atividadeLivro> listalivro= new ArrayList<atividadeLivro>();
	
	
	public static void main(String[] args) {
		tabela();
		menu();

	}
	public static void tabela() 
	{
		listalivro.add(new atividadeLivro("senhor dos aneis","tolkien"));
		listalivro.add(new atividadeLivro("starwras","George lucas"));
		
	}
	
	public static void menu() 
	{
		int escolha =0;
		do {
		System.out.println("--BEM VINDO--");
		System.out.println("1 --CADASTRAR-- ");
		System.out.println("2 --LISTAR--");
		System.out.println("3--BUSCAR--");
		System.out.println("4--ATUALIZAR DADOS--");
		System.out.println("5--EXCLUIR--");
		System.out.println("6--SAIR--");
		escolha =scan.nextInt();
		scan.nextLine();
		validar(escolha);
	} while (escolha != 6);
	}
	
	public static void validar(int escolha) 
	{
		switch (escolha) {
		case 1: {
			cadastrar();
			break;
		}
		case 2:
		{	
			listar();
			
			break;
		}
		case 3:
		{
			buscar();
			
			break;
		}
		case 4:
		{
			atualizar();
			break;
		}
		case 5:
		{
			excluir();
			break;
		}
		case 6:
		{
			System.out.println("VOCE SAIU DO SISTEMA, OBRIGADO POR USA!!");
			break;
		}
		default:
			System.out.println("INSIRA UM VALOR VALIDO");
		}
	}
	
	
	public static void cadastrar() 
	{
		atividadeLivro livro = new atividadeLivro();
		
		System.out.println("Digite o titulo do livro:");
		livro.setTitulo(scan.nextLine());
		
		System.out.println("Digite o autor do livro:");
		livro.setAutor(scan.nextLine());
		
		listalivro.add(livro);
		System.out.println("Livro cadastrado com sucesso");	
	}
	
	public static void listar() 
	{
		System.out.println("Lista de livros");
		for(int i=0; i < listalivro.size();i++) 
		{
			System.out.printf("%d) %s -- %s\n",i+1,listalivro.get(i).getTitulo(),listalivro.get(i).getAutor());
		}
		System.out.println("");
	}
	
	public static void buscar() 
	{
		System.out.println("Digite o titulo do livro:");
		String busca = scan.nextLine();
		
		int posicao =-1;
		
		for(int i=0 ; i < listalivro.size();i++) 
		{
			if(listalivro.get(i).getTitulo().equalsIgnoreCase(busca)) 
			{
				posicao=i;
				break;
			}
		}
			
			if(posicao ==-1) 
			{
				System.out.println("Livro nao encontrado");
			}
			
			else 
			{
				System.out.printf("Titulo: %s\n ",listalivro.get(posicao).getTitulo());
				System.out.printf("Autor: %s\n",listalivro.get(posicao).getAutor());
			}
		
		
	}
	
	
	public static void atualizar() 
	{
		listar();
		
		System.out.println("Digite o numero do livro que deseja atualizar:");
		int numero = scan.nextInt();
		scan.nextLine();
		
		if(numero >=1 && numero <= listalivro.size()) 
		{
			atividadeLivro livro = listalivro.get(numero - 1);
			
			System.out.println("Digite o novo titulo:");
			livro.setTitulo(scan.nextLine());
			
			System.out.println("Digite o novo autor:");
			livro.setAutor(scan.nextLine());
			
			System.out.println("Livro atualizado com sucesso");
		}
		else {
			System.out.println("Livro nao encontrado");
		}
	}
	
	public static void excluir() 
	{
		if(listalivro.size() == 0) 
		{
			System.out.println("Nao possui livros para excluir!!");
			return;
		}
		
		listar();
		System.out.println("Qual livro deseja excluir? ");
		int escolha =scan.nextInt() -1;
		
		if(escolha > listalivro.size()) 
		{
			System.out.println("Valor invalido");
		}
		
		listalivro.remove(escolha);
		System.out.println("Livro excluido com sucesso");
	}

}
