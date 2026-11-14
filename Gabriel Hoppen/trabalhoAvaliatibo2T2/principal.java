import java.util.ArrayList;
import java.util.Scanner;

public class principal {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<funcionario> listaFuncionarios = new ArrayList<>();

    public static void main(String[] args) {
        int escolhaUsuario = 0;

        do {
            System.out.println("\n======SISTEMA DE GERENCIAMENTO DE FUNCIONARIOS======");
            System.out.println("1 - Cadastrar funcionario.");
            System.out.println("2 - Listar funcionarios.");
            System.out.println("3 - Buscar funcionarios por ID.");
            System.out.println("4 - Atualizar funcionario.");
            System.out.println("5 - Excluir funcionario.");
            System.out.println("0 - Sair do sistema.");
            System.out.print("Escolha uma opcao: ");

            escolhaUsuario = scanner.nextInt();
            scanner.nextLine();

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);
    }

    public static void validarEscolha(int opcao) {
        switch (opcao) {
            case 1:
                System.out.println("1: Cadastrar funcionario selecionada.");
                cadastrar();
                break;
            case 2:
                System.out.println("2: Listar funcionarios selecionada.");
                listar();
                break;
            case 3:
                System.out.println("3: Buscar funcionario por ID selecionada.");
                buscaID();
                break;
            case 4:
                System.out.println("4: Atualizar funcionario selecionada.");
                atualizar();
                break;
            case 5:
                System.out.println("5: Excluir funcionario selecionada.");
                remover();
                break;
            case 0:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opcao invalida! Tente novamente.");
                break;
        }
    }

    public static void cadastrar() {
        System.out.print("Digite o ID do funcionario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (funcionario f : listaFuncionarios) {
            if (f.id == id) {
                System.out.println("Esse ID ja esta sendo utilizado.");
                return;
            }
        }

        System.out.print("Digite o nome do funcionario: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do funcionario: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        funcionario novoFuncionario = new funcionario(id, nome, idade);
        listaFuncionarios.add(novoFuncionario);
        System.out.println("Funcionario cadastrado com sucesso!");
    }

    public static void listar() {
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Nao existem funcionarios cadastrados.");
            return;
        }

        System.out.println("Lista de funcionarios no momento:");
        for (funcionario f : listaFuncionarios) {
            System.out.println("ID: " + f.id + "  Nome: " + f.nome + "  Idade: " + f.idade);
        }
    }

    public static void buscaID() {
        System.out.print("Qual o ID que deseja buscar: ");
        int buscaID = scanner.nextInt();
        scanner.nextLine();

        for (funcionario f : listaFuncionarios) {
            if (f.id == buscaID) {
                System.out.println("ID: " + f.id + "  Nome: " + f.nome + " Idade: " + f.idade);
                return;
            }
        }

        System.out.println("Nao foi possivel encontrar esse ID.");
    }

    public static void atualizar() {
        System.out.print("Qual o ID do funcionario que deseja atualizar: ");
        int buscaID = scanner.nextInt();
        scanner.nextLine();

        for (funcionario f : listaFuncionarios) {
            if (f.id == buscaID) {
                System.out.print("Digite o novo nome do funcionario: ");
                f.nome = scanner.nextLine();

                System.out.print("Digite a nova idade do funcionario: ");
                f.idade = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Funcionario atualizado com sucesso!");
                return;
            }
        }

        System.out.println("ID nao encontrado.");
    }

    public static void remover() {
        System.out.print("Qual o ID do funcionario que deseja remover: ");
        int buscaID = scanner.nextInt();
        scanner.nextLine();

        funcionario usuarioEncontrado = null;

        for (funcionario f : listaFuncionarios) {
            if (f.id == buscaID) {
                usuarioEncontrado = f;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            listaFuncionarios.remove(usuarioEncontrado);
            System.out.println("Funcionario removido com sucesso!");
        } else {
            System.out.println("ID nao encontrado.");
        }
    }
}