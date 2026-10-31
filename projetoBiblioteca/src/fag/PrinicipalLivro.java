package fag;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Objetos.Livro;
import Objetos.Pessoa;

public class PrinicipalLivro {
	static Scanner scan = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();
	
	public static void main(String[] args) {
		popularTabela();
		System.out.println("------------Sistema iniciado!------------");
		mostrarMenu();

	}
	
	private static void popularTabela() {
		listaUsuarios.add(new Pessoa("Gustavo"));
		listaUsuarios.add(new Pessoa("Gabriel"));
		listaUsuarios.add(new Pessoa("Jonas"));
		listaUsuarios.add(new Pessoa("João"));
		listaUsuarios.add(new Pessoa("Julio"));
		listaUsuarios.add(new Pessoa("Ryan"));
		listaUsuarios.add(new Pessoa("Pedro"));
		listaLivros.add(new Livro("O Senhor dos Anéis ", "Fantasia Épica"));
		listaLivros.add(new Livro("Drácula", "Terror"));
		listaLivros.add(new Livro("Duna", "Ficção Científica"));
		listaLivros.add(new Livro("O Alquimista", "Ficção Filosófica "));
		listaLivros.add(new Livro("Orgulho e Preconceito", "Romance Romântico"));
		listaLivros.add(new Livro("Cem Anos de Solidão", "Realismo Mágico"));
		listaLivros.add(new Livro("O Diário de Anne Frank", "Biografia"));
		listaLivros.add(new Livro("A Divina Comédia", "Clássico"));
		listaLivros.add(new Livro("Os Miseráveis", "Drama"));
		listaLivros.add(new Livro("O Pequeno Príncipe", "Fábula"));
		listaLivros.add(new Livro("Hamlet ", "Drama "));
		listaLivros.add(new Livro("Dom Casmurro", "Realismo"));
		listaLivros.add(new Livro("O iluminado", "Terror Psicológico"));
		listaLivros.add(new Livro("Neuromancer ", "Ficção Científica"));
		listaLivros.add(new Livro("Frankenstein ", "Ficção Científica"));
		listaLivros.add(new Livro("Garota Exemplar", "Suspense"));
		listaLivros.add(new Livro("Metamorfose ", "Surrealismo"));
	}
	

	private static void mostrarMenu() {
		int escolhaUsuario = 0;
		do {
			 System.out.println("------------Escolha uma opção!------------");
			 System.out.println("1 - Listar livros");
			 System.out.println("2 - Cadastrar livros");
			 System.out.println("3 - Excluir livro");
			 System.out.println("4 - Locar livro");
			 System.out.println("5 - Devolver livro");
			 System.out.println("6 - Registrar usuario");
			 System.out.println("7 - listar usuarios");
			 System.out.println("0 - Saida");
			 escolhaUsuario = scan.nextInt();
			 scan.nextLine();
			 validarEscolha(escolhaUsuario);
		} while (escolhaUsuario!=0);
		
		 
	}

	private static void listarLivros() {
		System.out.println("------------Lista livros------------");
		for (int i = 0; i <listaLivros.size(); i++) {
			System.out.printf("%d) %s - %s / %s\n",i+1,listaLivros.get(i).getNome(),listaLivros.get(i).getGenero(),listaLivros.get(i).validarDisponibilidade());
		}
		System.out.println("");
	}
	
	private static void  validarEscolha(int escolhausuario) {
		switch (escolhausuario) {
		case 0:{
			System.out.println("Sistema encerrado. Obrigado por utilizar!");
			break;
		}
		case 1:{
			listarLivros();
			break;
		}
		case 2:{
			cadastrarLivro();
			break;
		}
		case 3:{
			excluirLivro();
			break;
		}
		case 4:{
			locarLivro();
			break;
		}
		case 5:{
			devolverLivro();
			break;
		}
		case 6:{
			cadastrarUsuario();
			break;
		}
		case 7:{
			listarUsuarios();
			break;
		}
		default:
			System.out.println("Insira um valor válido!");
	    }
	}

	private static void cadastrarLivro() {
		Livro livro = new Livro();
		System.out.println("Informe o nome do livro: ");
		livro.setNome(scan.nextLine());
		
		System.out.println("Informe o genero o livro: ");
		livro.setGenero(scan.nextLine());
		
		listaLivros.add(livro);
		System.out.println("Livro cadastrado com sucesso!");
	}
	
	private static void excluirLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Não existe livro cadastrados!");
			return;
		}
		
		listarLivros();	
		System.out.println("Informe o livro que deve ser excluido!");
		int escolhaUsuario = scan.nextInt() - 1;
		
		if (escolhaUsuario > listaLivros.size()) {
			System.out.println("Valor invalido!");
			return;
		}
		
		if (listaLivros.get(escolhaUsuario).getDataLocacao()!=null) {
			System.out.println("O livro esta locado, não é possivel excluir!");
			return;
		}
		
		listaLivros.remove(escolhaUsuario);
		System.out.println("Livro excluido com sucesso!");
		
	}
	
	private static void locarLivro() {
		listarUsuarios();
		System.out.println("Informe a pessoa que vai locar o livro");
		int usuario = scan.nextInt()-1;
		scan.nextLine();
		
		if (usuario > listaUsuarios.size() && usuario<0) {
			System.out.println("Informe um usuario valido!");
			return;
		}
		
		if (listaUsuarios.get(usuario).getLivrosLocados().size() == 2) {
			System.out.println("Usuário está com o maximo de livros possiveis! Devolva um para poder locar outro!");
			return;
		}
		
		if (listaLivros.size()==0) {
			System.out.println("Não há nenhum livro registrado");
			return;
		}
		
		listarLivros();
		System.out.println("Infrome o livro que o usuario deseja locar:");
		int livro = scan.nextInt() - 1;
		scan.nextLine();
		if (livro > listaLivros.size() && livro < 0) {
			System.out.println("Informe um livro valido");
			return;
		}
		
		if (listaLivros.get(livro).getDataLocacao()!=null) {
			System.out.println("filme ja está locado!");
			return;
		}
		
		listaUsuarios.get(usuario).getLivrosLocados().add(listaLivros.get(livro));
		listaLivros.get(livro).setDataLocacao(new Date());
		System.out.println("Livro locado com sucesso!");
	}
	
	private static void devolverLivro() {
		listarUsuarios();
		System.out.println("Informe a pessoa que vai devolver o livro");
		int usuario = scan.nextInt()-1;
		scan.nextLine();
		
		if (usuario > listaUsuarios.size() && usuario<0) {
			System.out.println("Informe um usuario valido!");
			return;
		}
		
		if (listaUsuarios.get(usuario).getLivrosLocados().size() == 0) {
			System.out.println("Usuário não tem filmes locados!");
			return;
		}
		
		System.out.println("Infrome o livro que o usuario deseja devolver:");
		int livro = scan.nextInt() - 1;
		scan.nextLine();
		if (livro > listaLivros.size() && livro < 0) {
			System.out.println("Informe um livro valido");
			return;
		}
		
		listaUsuarios.get(usuario).getLivrosLocados().get(livro).setDataLocacao(null);
		listaUsuarios.get(usuario).getLivrosLocados().remove(livro);
		System.out.println("Livro devolvido com sucesso!");
	}
	
	private static void cadastrarUsuario() {
		Pessoa usuario = new Pessoa();
		
		System.out.println("Informe o nome do usuario:");
		usuario.setNome(scan.nextLine());
		
		listaUsuarios.add(usuario);
		System.out.println("Usario cadastrado com sucesso!");
	}
	
	private static void listarUsuarios() {
		System.out.println("------------Lista usuarios------------");
		for (int i = 0; i < listaUsuarios.size();i++) {
			System.out.printf("%d) %s\n",i+1, listaUsuarios.get(i).getNome());
			if (listaUsuarios.get(i).getLivrosLocados().size() != 0) {
				for (int j = 0; j < listaUsuarios.get(i).getLivrosLocados() .size();j++) {
					System.out.printf("%d) %s - %s\n",j+1,listaUsuarios.get(i).getLivrosLocados().get(j).getNome(),listaUsuarios.get(i).getLivrosLocados().get(j).getGenero());
				}
				
			}
		}
		System.out.println("");
	}
}
