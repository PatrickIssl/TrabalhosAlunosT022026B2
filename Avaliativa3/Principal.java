
package Avaliativa3;

import java.util.ArrayList;
import java.util.Scanner;

import Avaliativa3.objeto.Funcionario;

public class Principal {

    static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static int id = 1;

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {

        System.out.println("Digite uma opção");
        int op = 0;

        do {

            System.out.println("");
            System.out.println("=== Funcionarios ===");
            System.out.println("1 - Cadastrar funcionario");
            System.out.println("2 - Listar funcionarios");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar funcionario");
            System.out.println("5 - Deletar funcionario");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            op = scan.nextInt();
            scan.nextLine();

            switch (op) {

                case 1:
                    cadastrarFuncionario();
                    break;

                case 2:
                    listarFuncionarios();
                    break;

                case 3:
                    buscarId();
                    break;

                case 4:
                    atualizarFuncionario();
                    break;

                case 5:
                    deletar();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção invalida!");
                    break;
            }

        } while (op != 0);
    }

    public static void deletar() {

        System.out.println("Digite o ID do funcionario que deseja deletar");
        int idBusca = scan.nextInt();
        scan.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < funcionarios.size(); i++) {

            if (funcionarios.get(i).getId() == idBusca) {

                funcionarios.remove(i);
                System.out.println("Funcionario deletado com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionario não encontrado!");
        }
    }

    public static void atualizarFuncionario() {

        System.out.println("Digite o ID do funcionario que deseja atualizar");
        int idBusca = scan.nextInt();
        scan.nextLine();

        boolean encontrado = false;

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getId() == idBusca) {

                System.out.println("Digite o nome do funcionario");
                funcionario.setNome(scan.nextLine());

                System.out.println("Digite o cargo do funcionario");
                funcionario.setCargo(scan.nextLine());

                System.out.println("Digite o email do funcionario");
                funcionario.setEmail(scan.nextLine());

                System.out.println("Digite o salario do funcionario");
                funcionario.setSalario(scan.nextDouble());
                scan.nextLine();

                System.out.println("Funcionario atualizado com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionario não encontrado!");
        }
    }

    public static void buscarId() {

        System.out.println("Digite o ID do funcionario que deseja buscar");
        int idBusca = scan.nextInt();
        scan.nextLine();

        boolean encontrado = false;

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getId() == idBusca) {

                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Email: " + funcionario.getEmail());
                System.out.println("Salario: " + funcionario.getSalario());
                System.out.println("ID: " + funcionario.getId());

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionario não encontrado!");
        }
    }

    public static void listarFuncionarios() {

        System.out.println("Lista de Funcionarios");

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado!");
        } else {

            for (Funcionario funcionario : funcionarios) {

                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Email: " + funcionario.getEmail());
                System.out.println("Salario: " + funcionario.getSalario());
                System.out.println("ID: " + funcionario.getId());

                System.out.println("");
            }
        }
    }

    public static void cadastrarFuncionario() {

        System.out.println("Digite o nome do funcionario");
        String nome = scan.nextLine();

        System.out.println("Digite o cargo do funcionario");
        String cargo = scan.nextLine();

        System.out.println("Digite o email do funcionario");
        String email = scan.nextLine();

        System.out.println("Digite o salario do funcionario");
        double salario = scan.nextDouble();
        scan.nextLine();

        Funcionario funcionario = new Funcionario(id, nome, cargo, email, salario);
        funcionarios.add(funcionario);

        System.out.println("Funcionario cadastrado - ID = " + id);
        id++;
    }
}
