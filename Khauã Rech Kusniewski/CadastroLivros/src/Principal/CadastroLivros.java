package Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroLivros {
	static Scanner scan = new Scanner(System.in);
	static List<Livros> listarlivros = new ArrayList<Livros>();
	public static void main(String[] args) {
		mostrarMenu();
	}
	public static void mostrarMenu() {
		int escolhaUsuario = 0;

		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Cadastrar livros");
			System.out.println("2 - Listar livros");
			System.out.println("3 - Buscar livro por ID");
			System.out.println("4 - Atualizar livro");
			System.out.println("5 - Excluir livro");
			System.out.println("0 - Saida");

			escolhaUsuario = scan.nextInt();
	
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		}while (escolhaUsuario != 0);

	}
	
	public static void validarEscolha(int escolhausuario) {
		
		switch (escolhausuario) {
		case 1: {
			cadastrarLivro();
			break;
		}
		case 2:{
			listarlivro();
			break;
		}
		case 3:{
			buscarId();
			break;
		}
		case 4:{
			Atualizar();
			break;
		}
		case 5:{
			Excluir();
			break;
		}
		case 6:{
			break;
		}
		default:
			System.out.println("Insira um digito valido");
		}
	}

public static void cadastrarLivro() {

	System.out.println("Digite o nome do livro que deseja adicionar");
	String nomeLivro = scan.nextLine();
	System.out.println("Digite o autor do livro\n");
	String autor = scan.nextLine();
	Livros livro = new Livros(nomeLivro,autor);
	listarlivros.add(livro);
	System.out.println("Livro adicionado com sucesso!!\nLivros cadastrados:\n "+listarlivros.size());

}
public static void listarlivro() {
	if (listarlivros.size()!=0) {
		for(int i=0;i<listarlivros.size();i++) {
			System.out.printf("ID %d- %s/%s \n", i, listarlivros.get(i).getNome(),listarlivros.get(i).getAutor());
			
		}
	}else {System.out.println("Não ha livros para listar");}

}
public static void buscarId() {
	
	System.out.println("Digite o ID do livro\n");
	int indice = scan.nextInt();
	scan.nextLine();
	if(indice<listarlivros.size()&&indice>=0) {
		System.out.printf("Livro encontrado: %s/%s", listarlivros.get(indice).getNome(), listarlivros.get(indice).getAutor());
		
	}else {
		System.out.println("ID não encontrado");
	}
}
public static void Atualizar() {
	listarlivro();
	System.out.println("Digite o ID do livro que deseja atualizar");
	int id = scan.nextInt();
	scan.nextLine();
	
	if(id <= 0 && id < listarlivros.size()) {
		System.out.println("------Atualizar dados------\n");
		System.out.println("Digite o novo nome do livro");
		String novoNome = scan.nextLine();
		System.out.println("Digite o novo nome do autor");
		String novoAutor = scan.nextLine();
		
		Livros livro = listarlivros.get(id);
		
		livro.setAutor(novoAutor);
		livro.setNome(novoNome);
		
	}else { System.out.println("Digite um id valido");
	
	}
	
}
public static void Excluir() {
	listarlivro();
	System.out.println("Digite o ID do livro que deseja ser excluido");
	int id = scan.nextInt();
	scan.nextLine();
	if(id>=0 && id <= listarlivros.size()) {
		listarlivros.remove(id);
	}else { System.out.println("Digite um id valido");
}
}}