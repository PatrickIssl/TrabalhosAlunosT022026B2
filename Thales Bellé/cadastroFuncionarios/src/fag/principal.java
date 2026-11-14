
package fag;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import fag.objetos.funcionarios;

public class principal {

    static Scanner scan = new Scanner(System.in);

    static List<funcionarios> ListaFuncionarios = new ArrayList<funcionarios>();

    public static void main(String[] args) {

        System.out.println("Sistema iniciado!");

        menuInicio();

    }

    public static void menuInicio() {

        int escolhaUsuario = 0;

        do {

            System.out.println("=====================================================");
            System.out.println("1 - Listar funcionários");
            System.out.println("2 - Cadastrar funcionário");
            System.out.println("3 - Buscar funcionário por ID");
            System.out.println("4 - Atualizar funcionário");
            System.out.println("5 - Excluir funcionário");
            System.out.println("0 - Sair");
            System.out.println("=====================================================");

            escolhaUsuario = scan.nextInt();
            scan.nextLine();

            validarEscolha(escolhaUsuario);

        } while (escolhaUsuario != 0);

    }

    public static void cadastrarFuncionario() {

        funcionarios funcionario = new funcionarios();

        System.out.println("Informe o ID do funcionário:");
        funcionario.setId(scan.nextInt());
        scan.nextLine();

        System.out.println("Informe o nome do funcionário:");
        funcionario.setNome(scan.nextLine());

        System.out.println("Informe a idade do funcionário:");
        funcionario.setIdade(scan.nextInt());
        scan.nextLine();

        System.out.println("Informe o cargo do funcionário:");
        funcionario.setCargo(scan.nextLine());

        System.out.println("Dados recebidos!");

        ListaFuncionarios.add(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");

    }

    public static void listarFuncionario() {

        System.out.println("\n =================== Lista funcionários ===================");

        for (int i = 0; i < ListaFuncionarios.size(); i++) {

            System.out.printf("%d) %d - %s, %d - %s\n",
                    i + 1,
                    ListaFuncionarios.get(i).getId(),
                    ListaFuncionarios.get(i).getNome(),
                    ListaFuncionarios.get(i).getIdade(),
                    ListaFuncionarios.get(i).getCargo());

        }

        System.out.println("");

    }

    public static void validarEscolha(int escolhaUsuario) {

        switch (escolhaUsuario) {

            case 0: {

                System.out.println("Obrigado por utilizar o sistema!");
                break;

            }

            case 1: {

                listarFuncionario();
                break;

            }

            case 2: {

                cadastrarFuncionario();
                break;

            }

            case 3: {

                buscarFuncionario();
                break;

            }

            case 4: {

                atualizarFuncionario();
                break;

            }

            case 5: {

                excluirFuncionario();
                break;

            }

            default:

                System.out.println("Escolha uma opção válida!");

        }

    }

    public static void buscarFuncionario() {

        System.out.println("Informe o ID que deseja buscar: ");

        int idBusca = scan.nextInt();

        for (int i = 0; i < ListaFuncionarios.size(); i++) {

            if (ListaFuncionarios.get(i).getId() == idBusca) {

                System.out.println("Funcionário encontrado!");

                System.out.println("ID: " + ListaFuncionarios.get(i).getId());
                System.out.println("Nome: " + ListaFuncionarios.get(i).getNome());
                System.out.println("Idade: " + ListaFuncionarios.get(i).getIdade());
                System.out.println("Cargo: " + ListaFuncionarios.get(i).getCargo());

                return;

            }

        }

        System.out.println("Funcionário não encontrado!");

    }

    public static void atualizarFuncionario() {

        System.out.println("Informe o ID que deseja buscar: ");

        int idBusca = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < ListaFuncionarios.size(); i++) {

            if (ListaFuncionarios.get(i).getId() == idBusca) {

                System.out.println("Funcionário encontrado!");

                System.out.println("ID: " + ListaFuncionarios.get(i).getId());
                System.out.println("Nome atual: " + ListaFuncionarios.get(i).getNome());
                System.out.println("Idade atual: " + ListaFuncionarios.get(i).getIdade());
                System.out.println("Cargo atual: " + ListaFuncionarios.get(i).getCargo());

                System.out.println("Informe o novo nome: ");
                ListaFuncionarios.get(i).setNome(scan.nextLine());

                System.out.println("Informe a nova idade: ");
                ListaFuncionarios.get(i).setIdade(scan.nextInt());
                scan.nextLine();

                System.out.println("Informe o novo cargo: ");
                ListaFuncionarios.get(i).setCargo(scan.nextLine());

                System.out.println("Funcionário atualizado com sucesso!");

                return;

            }

        }

        System.out.println("Funcionário não encontrado!");

    }

    public static void excluirFuncionario() {

        System.out.println("Informe o ID do funcionário que deseja excluir: ");

        int idBusca = scan.nextInt();

        for (int i = 0; i < ListaFuncionarios.size(); i++) {

            if (ListaFuncionarios.get(i).getId() == idBusca) {

                System.out.println("Funcionário encontrado!");

                System.out.println("Nome: " + ListaFuncionarios.get(i).getNome());

                ListaFuncionarios.remove(i);

                System.out.println("Funcionário excluído com sucesso!");

                return;

            }

        }

        System.out.println("Funcionário não encontrado!");

    }

}
