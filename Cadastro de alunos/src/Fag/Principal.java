package Fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Fag.Objeto.Aluno;

public class Principal {

    static Scanner scan = new Scanner(System.in);
    static List<Aluno> listaAlunos = new ArrayList<Aluno>();

    public static void main(String[] args) {
        popularTabela();

        System.out.println("Sistema de Cadastro de Alunos iniciado!");
        mostrarMenu();
    }

    private static void popularTabela() {
        listaAlunos.add(new Aluno(1, "Lucas", 9.5));
        listaAlunos.add(new Aluno(2, "Rafael", 8.0));
        listaAlunos.add(new Aluno(3, "Henrique", 7.5));
        listaAlunos.add(new Aluno(4, "Joao", 9.0));
        listaAlunos.add(new Aluno(5, "Guilherme", 6.5));
    }

    public static void mostrarMenu() {
        int escolhaUsuario = 0;

        do {
            System.out.println("\n-------~ SISTEMA DE CADASTRO DE ALUNOS ~-------");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno por ID");
            System.out.println("4 - Atualizar aluno");
            System.out.println("5 - Excluir aluno");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opcao:");

            escolhaUsuario = scan.nextInt();
            scan.nextLine();

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 0: {
                System.out.println("Obrigado por utilizar nossos serviços... encerrando sistema...");
                break;
            }
            case 1: {
                cadastrarAluno();
                break;
            }
            case 2: {
                listarAlunos();
                break;
            }
            case 3: {
                buscarAluno();
                break;
            }
            case 4: {
                atualizarAluno();
                break;
            }
            case 5: {
                excluirAluno();
                break;
            }
            default:
                System.out.println("Insira um valor valido!");
        }
    }

    private static Aluno procurarAluno(int id) {
        for (int i = 0; i < listaAlunos.size(); i++) {
            if (listaAlunos.get(i).getId() == id) {
                return listaAlunos.get(i);
            }
        }

        return null;
    }

    private static void cadastrarAluno() {
        Aluno aluno = new Aluno();

        System.out.println("\n-------~ CADASTRAR ALUNO ~-------");

        System.out.println("Informe o ID do aluno:");
        int id = scan.nextInt();
        scan.nextLine();

        if (procurarAluno(id) != null) {
            System.out.println("Ja existe um aluno com esse ID!");
            return;
        }

        aluno.setId(id);

        System.out.println("Informe o nome do aluno:");
        aluno.setNome(scan.nextLine());

        System.out.println("Informe a nota do aluno:");
        aluno.setNota(scan.nextDouble());
        scan.nextLine();

        listaAlunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void listarAlunos() {
        System.out.println("\n-------~ LISTA DE ALUNOS ~-------");

        if (listaAlunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }

        for (int i = 0; i < listaAlunos.size(); i++) {
            System.out.printf("%d) ID: %d - Nome: %s - Nota: %.1f\n",
                    i + 1,
                    listaAlunos.get(i).getId(),
                    listaAlunos.get(i).getNome(),
                    listaAlunos.get(i).getNota());
        }

        System.out.println("");
    }

    private static void buscarAluno() {
        System.out.println("\n-------~ BUSCAR ALUNO ~-------");

        System.out.println("Informe o ID do aluno:");
        int id = scan.nextInt();
        scan.nextLine();

        Aluno aluno = procurarAluno(id);

        if (aluno == null) {
            System.out.println("Aluno nao encontrado!");
            return;
        }

        aluno.exibirDados();
    }

    private static void atualizarAluno() {
        System.out.println("\n-------~ ATUALIZAR ALUNO ~-------");

        System.out.println("Informe o ID do aluno:");
        int id = scan.nextInt();
        scan.nextLine();

        Aluno aluno = procurarAluno(id);

        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        System.out.println("Dados atuais:");
        aluno.exibirDados();

        System.out.println("Informe o novo nome:");
        aluno.setNome(scan.nextLine());

        System.out.println("Informe a nova nota:");
        aluno.setNota(scan.nextDouble());
        scan.nextLine();

        System.out.println("Aluno atualizado com sucesso!");
    }

    private static void excluirAluno() {
        System.out.println("\n-------~ EXCLUIR ALUNO ~-------");

        System.out.println("Informe o ID do aluno:");
        int id = scan.nextInt();
        scan.nextLine();

        Aluno aluno = procurarAluno(id);

        if (aluno == null) {
            System.out.println("Aluno nao encontrado!");
            return;
        }

        listaAlunos.remove(aluno);

        System.out.println("Aluno excluido com sucesso!");
    }
}

