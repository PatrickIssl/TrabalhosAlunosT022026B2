package fag;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import fag.biblioteca;

public class partbiblioteca {
	static Scanner scan = new Scanner(System.in);	
	static List<biblioteca> listalivros= new ArrayList<biblioteca>();
	
	
	
	public static void main(String[] args) {
		tabela();
		Menu();
		
		

	}
	
	public static void tabela() {
		listalivros.add(new biblioteca("tolkien","acao",120));
		listalivros.add(new biblioteca("star wars","ficcao",140));

	}
	
	
	public static void Menu() 
	{
		int escolha = 0;
		
		do {
			System.out.println("---MENU PRINCIPAL---");
			System.out.println(" 1 -- LISTA LIVROS --");
			System.out.println(" 2 -- CADASTRA LIVRO --");
			System.out.println(" 3 -- EXCLUIR LIVRO --");
			System.out.println(" 4 -- PEGAR LIVRO --");
			System.out.println(" 5 -- DEVOLVER LIVRO --");
			System.out.println(" 0 -- SAIR DO SISTEMA --");
			escolha =scan.nextInt();
			scan.nextLine();
			validarescolha(escolha);
		} while (escolha != 0);
	}
	
	
	public static void validarescolha(int escolha) 
	{
		switch (escolha) {
		case 0: {
			System.out.println("VOCE SAIU DO SISTEMA, OBRIGADO POR USA!!");
			
			break;
		}
		case 1:
		{	
			listar();
			
			break;
		}
		case 2:
		{
			
			cadastralivro();
			break;
		}
		case 3:
		{
			excluirlivro();
			break;
		}
		case 4:
		{
			locarlivro();
			break;
		}
		case 5:
		{
			devolver();
			break;
		}
		default:
			System.out.println("INSIRA UM VALOR VALIDO");
		}
	}
	
	public static void listar() 
	{
		System.out.println("Lista de livros");
		for(int i=0; i < listalivros.size();i++) 
		{
			System.out.printf("%d) %s -- %s -- %d\n",i+1,listalivros.get(i).getTitulo(),listalivros.get(i).getGenero(),listalivros.get(i).getQuantidadepaginas());
		}
		System.out.println("");
	}
	
	public static void cadastralivro() 
	{
		biblioteca livro = new biblioteca();	
		
		System.out.println("Digite o nome do livro:");
		livro.setTitulo(scan.nextLine());
		
		System.out.println("Digite o genero do filme: ");
		livro.setGenero(scan.nextLine());
		
		System.out.println("Digite a qauntidade de pagina: ");
		livro.setQuantidadepaginas(scan.nextInt());
		scan.nextLine();
		
		listalivros.add(livro);
		System.out.println("Livro cadastrado com sucesso");
	}
	
	public static void excluirlivro() 
	{
		if(listalivros.size() == 0) 
		{
		System.out.println("Nao possui livros para excluir!!");
		return;
		}
		
		listar();
		System.out.println("qual livro deseja excluir? ");
		int escolha =scan.nextInt() -1;
		
		if(escolha > listalivros.size()) 
		{
			System.out.println("valor invalido");
		}
		
		if(listalivros.get(escolha).isLocacao() == true) 
		{
			System.out.println("nao e possivel excluir esse livro, ele esta locado");
		}
		
		listalivros.remove(escolha);
		System.out.println("livro excluido com sucesso");
	}
	
	
	private static void locarlivro() 
	{	
		listar();
		System.out.println("qual livro deseja locar");
		int livro = scan.nextInt()-1;
		scan.nextLine();
		
		if(livro > listalivros.size() || livro < 0) 
		{	
			System.out.println("Informe um livro valido");
			return;
		}
		
		if(listalivros.get(livro).isLocacao()) 
		{
			System.out.println("esse livro ja esta locado");
			return;
		}
		
		listalivros.get(livro).setLocacao(true);
		System.out.println("livro locado com sucesso");
	}
	
	public static void devolver() 
	{
		listar();
		System.out.println("Informe que livro vai devolver");
		int livro=scan.nextInt()-1;
		scan.nextLine();
		
		if(livro > listalivros.size() && livro <0) 
		{
			System.out.println("informe um livro valido");
			return;
		}
		
		listalivros.get(livro).setLocacao(false);
		System.out.println("Filme devolvido com sucesso");
		
	}

}
