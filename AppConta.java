
/**
 * Escreva a descrição da classe AppConta aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Scanner;
public class AppConta
{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        
        Conta conta1 = new Conta();
        //System.out.println("\fNumero da conta1: " + conta1.getNumero());
        //System.out.println("Saldo de conta1: " + conta1.getSaldo());
        System.out.println("\fDados da conta1: " + conta1.toString());
        System.out.println("Dados da conta1: " + conta1);
        
        System.out.print("\nInforme o novo numero da conta1: ");
        int num = in.nextInt();
        conta1.setNumero(num);
        System.out.println("Dados da conta1 apos novo numero: " + conta1);
        //System.out.println("Numero da conta1 apos o novo numero: " + conta1.getNumero());
        //System.out.println("Saldo de conta1: " + conta1.getSaldo());
        
        System.out.print("\nInforme o numero da conta: ");
        num = in.nextInt();
        Conta conta2 = new Conta(num);
        //System.out.println("Numero da conta2: " + conta2.getNumero());
        //System.out.println("Saldo de conta2: " + conta2.getSaldo());
        System.out.println("Dados da conta2: " + conta2);
        
        System.out.print("Informe o valor a depositar: ");
        double valor = in.nextDouble();
        if(conta2.depositar(valor)==true){
            System.out.println("Dados da conta2 apos o deposito: " + conta2);
        }
        else System.out.println("Erro. Deposito nao realizado");
        
        System.out.print("Informe o valor a sacar: ");
        valor = in.nextDouble();
        if(conta2.sacar(valor)==true){
            System.out.println("Dados da conta2 apos o saque: " + conta2);
        }
        else System.out.println("Erro. Saque nao realizado");
        
        System.out.print("Informe o valor a transferir: ");
        valor = in.nextDouble();
        if(conta2.transferir(valor,conta1)==true){
            System.out.println("Transferencia da conta2 para conta1");
            System.out.println("Dados da conta1: " + conta1);
            System.out.println("Dados da conta2: " + conta2);
        }
        else System.out.println("Erro. Transferencia nao realizada");
    }
    
}












