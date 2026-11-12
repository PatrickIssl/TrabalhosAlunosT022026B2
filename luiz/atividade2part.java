package fag;
import fag.atividade2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class atividade2part {
	
	
	static List<atividade2> estoque = new ArrayList<atividade2>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		tabela();
		menu();
		
	}
	public static void tabela() 
	{
		estoque.add(new atividade2("joca",12123f,123487));
		estoque.add(new atividade2("eduardo",276372f,172873));
	}
	
	public static void menu() 
	{
		int escolha=0;
		
		do {
		System.out.println("--BEM VINDO--");
		System.out.println("-- 1) cadastrar --");
		System.out.println("-- 2) listar --");
		System.out.println("-- 3) buscar por cpf --");
		System.out.println("-- 4) atualizar --");
		System.out.println("-- 5) excluir --");
		System.out.println("-- 0) sair --");
		escolha=scan.nextInt();
		scan.nextLine();
		validarescolha(escolha);
		}while(escolha !=0);
	}
	
	private static void validarescolha(int escolha) 
	{
		if(escolha==1) 
		{	
			cadastro();
			return;
		}
		if(escolha == 2) 
		{	
			listar();
			return;
		}
		if(escolha ==3) 
		{
			buscar();
			return;
		}
		if(escolha == 4) 
		{
			atualizar();
			return;
		}
		if(escolha ==5) 
		{	
			excluir();
			return;
		}
		if (escolha == 0) 
		{
			System.out.println("obrigado por usar o sistema");
			return;
		}
		if(escolha <0 || escolha >5) 
		{
			System.out.println("--opção invalida");
			return;
		}
	}
	
	public static void cadastro()
	{
		atividade2 funcio = new atividade2();
		
		System.out.println("Digite o seu nome: ");
		funcio.setNome(scan.nextLine());
		
		System.out.println("Digite o seu CPF: ");
		funcio.setCpf(scan.nextLong());
		scan.nextLine();
		
		System.out.println("Digite o seu salario: ");
		funcio.setSalario(scan.nextFloat());
		scan.nextLine();
		
		estoque.add(funcio);
		System.out.println("Funcionario cadastrado com sucesso");
	}

	public static void listar() 
	{
		System.out.println("Lista de funcionarios");
		for(int i=0; i < estoque.size();i++) 
		{
			System.out.printf("%d) %s ---- %d --- %f\n",i+1,estoque.get(i).getNome(),estoque.get(i).getCpf(),estoque.get(i).getSalario());
		}
		System.out.println(" ");
	}
	
	public static void excluir() 
	{
		if(estoque.size() == 0) 
		{
		System.out.println("Nao possui funcionarios para excluir!!");
		return;
		}
		
		listar();
		System.out.println("qual funcionario deseja excluir? ");
		int escolha =scan.nextInt() -1;
		
		if(escolha > estoque.size()) 
		{
			System.out.println("valor invalido");
		}
				
		estoque.remove(escolha);
		System.out.println("funcionario excluido com sucesso");
	}
	
	public static void  buscar() {
		System.out.println("digite o cpf para localizar ");
		int busca=scan.nextInt();
		scan.nextLine();
		
		int posicao=-1;
		
		for(int i=0;i<estoque.size();i++) 
		{
			if (estoque.get(i).getCpf() == busca) {
				posicao= i;
				break;
		}
		}
		if (posicao == -1) {
				System.out.println("cpf nao encontrado");
			} 
		else {
				atividade2 f = estoque.get(posicao);
				System.out.printf("encontrado: %s ---- %d --- %.2f\n", f.getNome(), f.getCpf(), f.getSalario());
			}
	}
		
	public static void atualizar() 
		{
			listar();
			
			System.out.println("Digite o numero do funcionario que deseja atualizar:");
			int numero = scan.nextInt();
			scan.nextLine();
			
			if(numero >=1 && numero <= estoque.size()) 
			{
				atividade2 funcionario = estoque.get(numero - 1);
				
				System.out.println("Digite o novo nome: ");
				funcionario.setNome(scan.nextLine());
				
				System.out.println("Digite o novo cpf: ");
				funcionario.setCpf(scan.nextInt());
				scan.nextLine();
				
				System.out.println("Digite o novo salario: ");
				funcionario.setSalario(scan.nextFloat());
				scan.nextLine();
				
				System.out.println("Cadastro atualizado com sucesso");
			}
			else 
			{
				System.out.println("Cadastro nao encontrado");
			}
		}
}

