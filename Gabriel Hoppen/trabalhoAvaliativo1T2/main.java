import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Aluno> listaAlunos = new ArrayList<Aluno>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int escolhaUsuario = 0;

        do {
            System.out.println("------- SISTEMA DE NOTAS -------");
            System.out.println("1- Cadastrar Aluno");
            System.out.println("2- Listar Alunos");
            System.out.println("3- Buscar por ID");
            System.out.println("4- Atualizar Aluno");
            System.out.println("5- Excluir Aluno");
            System.out.println("6- Sair");

            escolhaUsuario = scanner.nextInt();
            scanner.nextLine();

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 6);
    }

    public static void validarEscolha(int escolhaUsuario) {
        switch (escolhaUsuario) {

        case 1: {
            cadastrarAluno();
            break;
        }

        case 2: {
            listarAlunos();
            break;
        }

        case 3: {
            buscaID();
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

        case 6: {
            System.out.println("Sistema encerrado. Obrigado por utilizar!");
            break;
        }

        default:
            System.out.println("Insira um valor válido!");
        }
    }

    private static void cadastrarAluno() {

        System.out.println("Digite o ID do aluno:");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (idExiste(id)) {
            System.out.println("Já existe um aluno cadastrado com esse ID.");
            return;
        }

        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();

        System.out.println("Digite a nota do aluno:");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        Aluno aluno = new Aluno(nome, id, nota);
        listaAlunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static boolean idExiste(int id) {

        for (Aluno aluno : listaAlunos) {
            if (aluno.getId() == id) {
                return true;
            }
        }

        return false;
    }

    private static void listarAlunos() {

        if (listaAlunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado!");
            return;
        }

        System.out.println("\n-------- Lista de Alunos --------");

        for (int i = 0; i < listaAlunos.size(); i++) {
            System.out.println("ID: " + listaAlunos.get(i).getId()
                    + " Nome: " + listaAlunos.get(i).getNome()
                    + " Nota: " + listaAlunos.get(i).getNota());
        }
    }

    private static Aluno buscaID() {

        if (listaAlunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado!");
            return null;
        }

        System.out.println("Digite o ID do aluno:");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < listaAlunos.size(); i++) {

            if (listaAlunos.get(i).getId() == id) {

                System.out.println("ID: " + listaAlunos.get(i).getId()
                        + " Nome: " + listaAlunos.get(i).getNome()
                        + " Nota: " + listaAlunos.get(i).getNota());

                return listaAlunos.get(i);
            }
        }

        System.out.println("Aluno não encontrado!");
        return null;
    }

    private static void atualizarAluno() {

        Aluno aluno = buscaID();

        if (aluno == null) {
            return;
        }

        System.out.println("Digite o novo nome do aluno:");
        String nome = scanner.nextLine();

        System.out.println("Digite a nova nota do aluno:");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        int indice = listaAlunos.indexOf(aluno);
        listaAlunos.set(indice, new Aluno(nome, aluno.getId(), nota));

        System.out.println("Aluno atualizado com sucesso!");
    }

    private static void excluirAluno() {

        Aluno aluno = buscaID();

        if (aluno != null) {
            listaAlunos.remove(aluno);
            System.out.println("Aluno excluído com sucesso!");
        }
    }
}