import java.util.Scanner;
public class Atividade{
	
	public static void main(String[] args){
	Scanner scanner = new Scanner(System.in);
	
	double RF = 0;
	
	System.out.println("digite o primeiro numero");
	double PM = scanner.nextDouble();

	System.out.println("digite o segundo numero");
	double SM = scanner.nextDouble();

	char OP;

	while (true) {
	System.out.println("Digite x para multiplicar, / para divisao, + para contas de mais, - para contas de menos.");
	OP = scanner.next().charAt(0);
	if (OP != 'x' && OP != '/' && OP != '+' && OP != '-')
	{
	System.out.println("insira uma operacao valida.");
	}
	else {
	break;
	}
	}
	if ( OP == 'x' )
	{
	RF = PM * SM;
	}
	if ( OP == '/')
	{
	RF = PM / SM;
	}
	if ( OP == '+' )
	{
	RF = PM + SM;
	}
	if ( OP == '-' )
	{
	RF = PM - SM;
	}
	System.out.println("o resultado e: "+ RF +".");
	}
	}