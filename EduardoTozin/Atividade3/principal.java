package jogo.java;

	import java.util.ArrayList;
	import java.util.Scanner;
	 
	public class principal {
	 
	    static Scanner entrada = new Scanner(System.in);
	    static ArrayList<jogos> lista = new ArrayList<>();
	    static int proximoId = 1;
	 
	    public static void main(String[] args) {
	        int opcao;
	 
	        do {
	            System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========\n");
	            System.out.println("1 - Cadastrar");
	            System.out.println("2 - Listar todos");
	            System.out.println("3 - Buscar por ID");
	            System.out.println("4 - Atualizar");
	            System.out.println("5 - Excluir");
	            System.out.println("0 - Sair");
	            System.out.print("\nEscolha uma opcao: ");
	 
	            opcao = lerInteiro();
	 
	            switch (opcao) {
	                case 1:
	                    cadastrar();
	                    break;
	                case 2:
	                    listar();
	                    break;
	                case 3:
	                    buscar();
	                    break;
	                case 4:
	                    atualizar();
	                    break;
	                case 5:
	                    excluir();
	                    break;
	                case 0:
	                    System.out.println("Sistema encerrado");
	                    break;
	                default:
	                    System.out.println("Opcao invalida");
	            }
	 
	        } while (opcao != 0);
	 
	        entrada.close();
	    }
	
	    
	    public static int lerInteiro() {
	        while (true) {
	            try {
	                return Integer.parseInt(entrada.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.print("Digite um numero valido: ");
	            }
	        }
	    }
	 
	    public static double lerDecimal() {
	        while (true) {
	            try {
	                return Double.parseDouble(entrada.nextLine().replace(",", "."));
	            } catch (NumberFormatException e) {
	                System.out.print("Digite um numero valido: ");
	            }
	        }
	    }
	 
	    public static void cadastrar() {
	        System.out.print("Nome: ");
	        String nome = entrada.nextLine();
	 
	        System.out.print("Genero: ");
	        String genero = entrada.nextLine();
	 
	        jogos jogos = new jogos(proximoId, nome, genero);
	        lista.add(jogos);
	 
	        System.out.println("Cadastrado com sucesso! ID: " + proximoId);
	        proximoId++;
	    }
	 
	    public static void listar() {
	        if (lista.isEmpty()) {
	            System.out.println("Nenhum registro cadastrado");
	            return;
	        }
	 
	        for (jogos jogos : lista) {
	            jogos.exibirDados();
	        }
	    }
	 
	    public static void buscar() {
	        if (lista.isEmpty()) {
	            System.out.println("Nenhum registro cadastrado");
	            return;
	        }
	 
	        System.out.print("Digite o ID: ");
	        jogos jogos = encontrarPorId(lerInteiro());
	 
	        if (jogos != null) {
	            jogos.exibirDados();
	        } else {
	            System.out.println("ID nao encontrado");
	        }
	    }
	 
	    public static void atualizar() {
	        if (lista.isEmpty()) {
	            System.out.println("Nenhum registro cadastrado");
	            return;
	        }
	 
	        System.out.print("Digite o ID: ");
	        jogos jogos = encontrarPorId(lerInteiro());
	 
	        if (jogos != null) {
	            System.out.print("Novo nome: ");
	            jogos.setNome(entrada.nextLine());
	 
	            System.out.print("Novo genero: ");
	            jogos.setGenero(entrada.nextLine());
	 
	            System.out.println("Atualizado com sucesso");
	        } else {
	            System.out.println("ID nao encontrado");
	        }
	    }
	 
	    public static void excluir() {
	        if (lista.isEmpty()) {
	            System.out.println("Nenhum registro cadastrado");
	            return;
	        }
	 
	        System.out.print("Digite o ID: ");
	        jogos jogos = encontrarPorId(lerInteiro());
	 
	        if (jogos != null) {
	            lista.remove(jogos);
	            System.out.println("Excluido com sucesso");
	        } else {
	            System.out.println("ID nao encontrado");
	        }
	    }
	 
	    public static jogos encontrarPorId(int id) {
	        for (jogos jogos : lista) {
	            if (jogos.getId() == id) {
	                return jogos;
	            }
	        }
	        return null;
	    }
	}
