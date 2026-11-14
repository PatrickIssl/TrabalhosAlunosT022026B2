package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import objetos.Aluno;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Aluno> listaAlunos = new ArrayList<Aluno>();
    static int id = 1;

    public static void mostrarMenu() {
        int escolha = 0;
        do {
            System.out.println("====== SISTEMA DE GERENCIAMENTO ======");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            escolha = scanner.nextInt();
            scanner.nextLine();
            validarEscolha(escolha);
        } while (escolha != 0);
    }

    public static void validarEscolha(int escolha) {
        switch (escolha) {
            case 1:
                cadastrarAluno();
                break;
            case 2:
                listarAlunos();
                break;
            case 3:
                buscarAlunoPorId();
                break;
            case 4:
                atualizarAluno();
                break;
            case 5:
                excluirAluno();
                break;
            case 0:
                System.out.println("Sistema finalizado");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public static void cadastrarAluno() {
        Aluno aluno = new Aluno();
        System.out.println("====== Cadastrar aluno ======");

        System.out.println("Informe o nome do aluno");
        aluno.setNome(scanner.nextLine());

        System.out.println("Informe a nota do aluno");
        aluno.setNota(scanner.nextDouble());

        aluno.setId(id);
        id++;
        listaAlunos.add(aluno);
        System.out.println("Aluno cadastrado com ID " + aluno.getId());
    }

    public static void listarAlunos() {
        System.out.println("====== Lista de alunos ======");

        for (Aluno aluno : listaAlunos) {
            System.out.printf("%d) %s, nota: %.1f\n", aluno.getId(), aluno.getNome(), aluno.getNota());
        }
        System.out.println("");
    }

    public static Aluno buscarPorId(int id) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }

    public static void buscarAlunoPorId() {
        System.out.println("====== Buscar por ID ======");
        System.out.println("Informe o ID do aluno");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = buscarPorId(id);

        if (aluno == null) {
            System.out.println("Nenhum livro com esse ID");
            return;
        }
        System.out.printf("%d) %s, nota: %.1f\n", aluno.getId(), aluno.getNome(), aluno.getNota());
    }

    public static void atualizarAluno() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados");
            return;
        }

        System.out.println("====== Atualizar informações ======");
        listarAlunos();

        System.out.println("Informe o ID do aluno para atualizar");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = buscarPorId(id);

        if (aluno == null) {
            System.out.println("Nenhum livro com esse ID");
            return;
        }

        System.out.println("Novo nome (atual: " + aluno.getNome() + ")");
        aluno.setNome(scanner.nextLine());

        System.out.println("Nova nota (atual: " + aluno.getNota() + ")");
        aluno.setNota(scanner.nextDouble());

        System.out.println("Cadastro atualizado");
    }

    public static void excluirAluno() {
        if (listaAlunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados");
            return;
        }

        System.out.println("====== Excluir aluno ======");
        listarAlunos();

        System.out.println("Informe o ID do aluno que deseja excluir");
        int id = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = buscarPorId(id);

        if (aluno == null) {
            System.out.println("Nenhum aluno com esse ID");
            return;
        }

        listaAlunos.remove(aluno);
        System.out.println("aluno removido");
    }

    public static void main(String[] args) {
        mostrarMenu();
    }
}