import java.util.Scanner;

public class Caixa{
    public static Scanner scanner = new Scanner (System.in);

    public static double saldo = 0;
    public static int opcao = 0;
    public static double somaSaque = 0;
    public static String senha = "1234";
    public static String senhaUsu;
    public static boolean logou = false;

    public static void main(String[] args) {
    login(senhaUsu,senha);
    if (logou == true){
    while (opcao != 4){
    mostrarMenu();
        if (opcao == 1) {
         mostrarSaldo();
        }
        else if (opcao == 2) {
          depositar();
        }
        else if (opcao == 3){
            
            sacar();
        }
        }
        System.out.println("Sessão encerrada.");
    }
    else {
        System.out.println("Você excedeu o limite de tentativas.");
    }
}
    public static void mostrarMenu(){
       
        System.out.println("Menu:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinheiro");
        System.out.println("3. Sacar dinheiro");
        System.out.println("4. Sair");
        opcao = scanner.nextInt();
        if (opcao <1 || opcao > 4 ) {
        System.out.println("Opção inválida, tente novamente.");
        mostrarMenu();
    }
    }

 public static void mostrarSaldo(){
    System.out.println("Saldo: R$: " + saldo);
 }

 public static void depositar(){
    System.out.println("Insira o valor a ser depositado: ");
    double valor = scanner.nextDouble();
    if(valor > 0 ){
        saldo+=valor;  
    }
    else{
    System.out.println("Valor invalido");  
    depositar();
    }
 }

  public static void sacar(){
    System.out.println("Insira o valor a ser sacado: ");
    double valor = scanner.nextDouble();

     if(valor < 1){
        System.out.println("Valor invalido"); 
        sacar();
        return;
    }
    else if(valor > saldo){
        System.out.println("Você não tem saldo suficiente.");  
        return;
    }
    if ((somaSaque + valor) <= 500){
        somaSaque+= valor;
        saldo-=valor;
    }
    else {
        System.out.println("Esse valor ultrapassa seu limite de saque diário.");
        System.out.println("Valor disponível: R$"+(500 - somaSaque));
    } 
 }

 public static void login(String senhaUsu, String senha){
    int i = 0;
    for (i = 0;i < 3;i++){
        System.out.println("Insira a senha: ");
        senhaUsu = scanner.nextLine();
        if (senhaUsu.equals(senha)){
            System.out.println("Senha correta.");
            logou = true;
        break;
        }
        else if (senhaUsu!=senha){
            System.out.println("Senha incorreta. Tente novamente.");
        }
       }
     }


}