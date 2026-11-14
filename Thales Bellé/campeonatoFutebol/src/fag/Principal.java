package fag;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import fag.objetos.Time;

public class Principal {
	
	static Scanner scan = new Scanner(System.in);
	static List<Time> listaTimes = new ArrayList<Time>();
	
	public static void main(String[] args) {
		menuCampeonato();
	}
	
	public static void menuCampeonato() {
		
		int escolhaUsuario = 0;
		
		do{
			System.out.println("======================= CAMPEONATO BRASILEIRO =======================");
			System.out.println("1 - Cadastrar time");
			System.out.println("2 - Listar times");
			System.out.println("3 - Registrar partida");
			System.out.println("4 - Ver classificação");
			System.out.println("0 - Sair");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			validarEscolha(escolhaUsuario);
		}while(escolhaUsuario != 0);
	}
	
	public static void validarEscolha(int escolhaUsuario) {
		
		switch(escolhaUsuario) {
		
		case 0:{
			System.out.println("Obrigado por usar nosso sistema!!!");
			break;
		}
		case 1:{
			cadastrarTime();
			return;
		}
		case 2:{
			listarTimes();
			return;
		}
		case 3:{
			registrarPartida();
			break;
		}
		case 4:{
			verClassificacao();
			break;
		}
		default:
			System.out.println("Insira uma opção válida!");
			break;
		}
	}
	
	public static void cadastrarTime() {
		
		Time time = new Time();
		
		
		System.out.println("Insira o ID do time que deseja criar: ");
		time.setId(scan.nextInt());
		scan.nextLine();
		
		System.out.println("Insira o nome do time que deseja criar: ");
		time.setNome(scan.nextLine());	
		
		System.out.println("Time cadastrado com sucesso!");
		listaTimes.add(time);
}
	
	
	public static void exibirDados() {
		
		listarTimes();
		
		System.out.println("Insira o ID do time que deseja consultar");
		int idBusca = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < listaTimes.size(); i ++) {
			if(listaTimes.get(i).getId() == idBusca) {
				System.out.println("Time encontrado!!");
				System.out.println("ID: " + listaTimes.get(i).getId());
				System.out.println("Nome: " + listaTimes.get(i).getNome());
				System.out.println("Quantidade de pontos: " + listaTimes.get(i).getQuantPontos());
				System.out.println("Vitorias: " + listaTimes.get(i).getVitorias());
				System.out.println("Derrotas: " + listaTimes.get(i).getEmpates());
				System.out.println("Derrotas: " + listaTimes.get(i).getDerrotas());
				System.out.println("Gols marcados: " + listaTimes.get(i).getGolsMarcados());
				System.out.println("Gols sofridos: " + listaTimes.get(i).getGolsSofridos());
			}
		}
	}
	
	public static void listarTimes() {
		
		System.out.println("================= TIMES DO CAMPEONATO =================");
		System.out.println("ID    NOME   VITÓRIAS   DERROTAS");
		
		for(int i = 0; i < listaTimes.size(); i ++) {
			System.out.printf("%d)    %s       %d          %d \n", listaTimes.get(i).getId(), listaTimes.get(i).getNome(), listaTimes.get(i).getVitorias(), listaTimes.get(i).getDerrotas());
		}
		
		System.out.println("");
	}
	
	public static void registrarPartida() {
		
		Time timeCasa = new Time();
		Time timeVisitante = new Time();
		
		
		listarTimes();
		
		System.out.println("Insira o ID do time da casa: ");
		int idBusca = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Insira o ID do time visitante: ");
		idBusca = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Insira a quantidade de gols do time da casa: ");
		timeCasa.setGolsMarcados(scan.nextInt());
		scan.nextLine();
		
		System.out.println("Insira a quantidade de gols do time visitante: ");
		timeCasa.setGolsSofridos(scan.nextInt());
		scan.nextLine();
		
		if(timeCasa.getGolsMarcados() == 3) {
			System.out.println("O time da casa venceu!!");
			timeCasa.registrarVitoria();
			timeVisitante.registrarDerrota();
		}else if((timeCasa.getGolsMarcados() == 1) && (timeVisitante.getGolsSofridos() == 1)) {
			System.out.println("O jogo terminou em empate");
			timeCasa.registrarEmpate();
			timeVisitante.registrarEmpate();
		}else if(timeCasa.getGolsMarcados() == 0) {
			System.out.println("O time visitante venceu!!");
			timeCasa.registrarDerrota();
		}
	}
	
	public static void verClassificacao() {
		
		System.out.println("POSIÇÃO   ID    NOME   VITÓRIAS   DERROTAS   EMPATES   MARCADOS   SOFRIDOS   PONTOS");
		for(int i = 0; i < listaTimes.size(); i ++) {
			System.out.printf("%d°       %d    %s       %d          %d         %d        %d         %d        %d",
					i + 1,
					listaTimes.get(i).getId(), 
					listaTimes.get(i).getNome(), 
					listaTimes.get(i).getVitorias(), 
					listaTimes.get(i).getDerrotas(),
					listaTimes.get(i).getEmpates(),
					listaTimes.get(i).getGolsMarcados(),
					listaTimes.get(i).getGolsSofridos(),
					listaTimes.get(i).getQuantPontos());
		}
		
		System.out.println("");
	}
}
