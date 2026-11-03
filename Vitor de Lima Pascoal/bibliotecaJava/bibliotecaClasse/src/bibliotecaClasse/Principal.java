package bibliotecaClasse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {
	static Scanner scan = new Scanner(System.in);
	static List <Livros> listaLivros = new ArrayList <Livros>(); 
	static List <Pessoa> listaUsuarios = new ArrayList <Pessoa>();

	public static void main(String[] args) {
		listaGeral();
		printMenu();
	}

	public static void printMenu() {
		int escolhaUsuario = 0;
		do{
			System.out.println("1 - Todos os livros ");
			System.out.println("2 - Adicionar um livro ");
			System.out.println("3 - Excluir livro ");
			System.out.println("4 - Alugar Livro ");
			System.out.println("5 - Devolver Livro ");
			System.out.println("6 - Listar Usuarios ");
			System.out.println("7 - Cadastrar Usuario");
			System.out.println("8 - Sair ");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		
		}while (escolhaUsuario != 8);
	}
	
	
	public static void listaGeral() {
		listaUsuarios.add(new Pessoa("Vitor"));
		listaUsuarios.add(new Pessoa("Willian"));
	    listaLivros.add(new Livros("O Senhor dos Anéis", "J.R.R. Tolkien", 1200));
	    listaLivros.add(new Livros("Dom Casmurro", "Machado de Assis", 250));
	    listaLivros.add(new Livros("Clean Code", "Robert C. Martin", 464));
	}
	
	public static void validarEscolha (int escolhaUsuario) {
		switch (escolhaUsuario) {
		
		case 8: {
			System.out.println("Saindo do sistema");
			break;
		}
		case 1: {
			listarLivros();
			break;
		}
		case 2: {
			cadastrarLivro();
			break;
		}
		case 3: {
			excluirLivro();
		}
		case 4: {
			alugarLivro();
			break;
		}
		case 5: {
			devolverLivro();
			break;
		}
		case 6: {
			listarUsuarios();
			break;
		}
		
		case 7: {
			cadastrarUsuario();
			break;
		}
		
		}		
	}
	private static void alugarLivro() {
		listarUsuarios();
		System.out.println("Qual usuario gostaria de alugar um livro");
		int usuario = scan.nextInt();
		scan.nextLine();
		
		if(usuario > listaUsuarios.size() || usuario < 0) {
			System.out.println("Usuario invalido");
			return;
		}
		
		listarLivros();
		int livros = scan.nextInt()-1;
		scan.nextLine();
		if(livros > listaLivros.size() && livros < 0) {
			System.out.println("Informe um livro valido!");
			return;
		}
		if(listaLivros.get(livros).getDataLocacao() != null) {
			System.out.println("livro ja está locado!");
			return;
		}
		
		
		listaUsuarios.get(usuario).getlivrosAlugados().add(listaLivros.get(livros));
		listaLivros.get(livros).setDataLocacao(new Date());
		System.out.println("Livro alugado com sucesso!");
	}
		
	private static void devolverLivro() {
		listarUsuarios();
		System.out.println("Informe o usuário que vai devolver o livro");
		int usuario = scan.nextInt()-1;
		scan.nextLine();
		
		if(usuario > listaUsuarios.size() && usuario < 0) {
			System.out.println("Informe um usuário valido!");
			return;
		}
		if(listaUsuarios.get(usuario).getlivrosAlugados().size() == 0) {
			System.out.println("Usuário não possui livros alugados");
			return;
		}
		
		System.out.println("Informe o livro que o usuário vai devolver");
		int livros= scan.nextInt()-1;
		scan.nextLine();
		
		if(livros >= listaUsuarios.get(usuario).getlivrosAlugados().size() || livros < 0) {
			System.out.println("Informe um livro existente");
		}
		
		listaUsuarios.get(usuario).getlivrosAlugados().get(livros).setDataLocacao(null);
		listaUsuarios.get(usuario).getlivrosAlugados().remove(livros);
		System.out.println("Livro devolvido com sucesso!");
		
	}	
		

	
	private static void cadastrarLivro() {
		Livros livros = new Livros();
		System.out.println("Insira o nome do livro");
		livros.setNome(scan.nextLine());
		
		System.out.println("Insira o autor do livro");
		livros.setAutor(scan.nextLine());
		
		System.out.println("Insira o numero de paginas do livro");
		livros.setPaginas(scan.nextInt());
		scan.nextLine();
		listaLivros.add(livros);
		
		System.out.println("Livro cadastrado com sucesso");
	}
	
	private static void excluirLivro() {
		if(listaLivros.size() == 0) {
			System.out.println("Não existem livros para excluir!");
			return;
		}
		
		listarLivros();
		System.out.println("Informe um livro para excluir: ");
		int escolhaUsuario = scan.nextInt() - 1;
		
		if(escolhaUsuario > listaLivros.size()) {
			System.out.println("Valor inválido!");
			return;
		}
		if(listaLivros.get(escolhaUsuario).getDataLocacao() != null) {
			System.out.println("O livro está alugado, portanto não pode ser excluido!");
			return;
		}
		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro removido com sucesso!");
		
	}
	
	private static void listarLivros() {
		for(int i = 0; i < listaLivros.size(); i++) {
			System.out.printf(" %d - %s | %s | %d \n", i+1 ,listaLivros.get(i).getNome() , listaLivros.get(i).getAutor() , listaLivros.get(i).getPaginas());
			
		}
	}
	private static void cadastrarUsuario() {
		Pessoa pessoa = new Pessoa();
		System.out.println("Insira o nome do usario");
		pessoa.setNome(scan.nextLine());
		
		listaUsuarios.add(pessoa);
		System.out.println("Cadastro feito com sucesso");
	}
	
	private static void listarUsuarios() {
		for(int i = 0; i <listaUsuarios.size(); i ++) {
			System.out.printf("%d - %s \n",i+1, listaUsuarios.get(i).getNome());
		}
	}
}
