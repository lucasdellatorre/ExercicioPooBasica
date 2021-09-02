
/**
 * Escreva a descrição da classe AppAgencia aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

//Recupera um cliente pelo cpf
//Altera o endereco: logradouro e bairro
//Busca cliente pelo bairro

import java.util.Scanner;
public class AppAgencia
{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Agencia agencia1 = new Agencia("Tabajara Bank - PUC", 6);
        
        int op;
        do{
            System.out.println("\n\n\n----------MENU----------- ");
            System.out.println("01 - Criaçao conta");
            System.out.println("02 - Listagem de todas as contas");
            System.out.println("03 - Consulta conta");
            System.out.println("04 - Deposito em conta");
            System.out.println("05 - Saque na conta");
            System.out.println("06 - Transferencia entre contas");
            System.out.println("07 - Exclusao de conta");
            System.out.println("08 - Busca conta por cpf");
            System.out.println("09 - Busca cliente pelo cpf");
            System.out.println("10 - Recupera cliente pelo cpf");
            System.out.println("11 - Altera o endereco: logradouro e bairro");
            System.out.println("12 - Busca clientes pelo bairro");
            System.out.println("0 - Fim");
            System.out.print("Informe a opçao:");
            op = in.nextInt();
            switch(op){
                case 0: System.out.println("Fim"); break;
                case 1: //if(agencia1.insere() == true) System.out.println("Conta criada com sucesso");
                        //else System.out.println("Erro. Conta nao criada");
                        cadastra(agencia1);
                        break;
                        
                case 2: System.out.println(agencia1.toString());
                        break;
                        
                case 3: System.out.print("Informe o numero de conta a consultar: ");
                        int num = in.nextInt();
                        Conta temp = agencia1.busca(num);    //temp = 4567
                        if(temp==null) System.out.println("Numero de conta nao existe");
                        else System.out.println(temp.toString());
                        break;  
                        
                case 4: System.out.print("Informe o numero de conta para deposito: ");
                        num = in.nextInt();
                        temp = agencia1.busca(num);    //temp = 4567
                        if(temp==null) System.out.println("Numero de conta nao existe");
                        else {
                            System.out.print("Informe o valor a depositar:");
                            double valor = in.nextDouble();
                            if(temp.depositar(valor)==true){
                                System.out.println("Deposito realizado com sucesso.");
                            }
                            else{
                                System.out.println("Deposito nao realizado");
                            }
                        }
                        break;
                        
                case 5: System.out.print("Informe o numero de conta para saque: ");
                        num = in.nextInt();
                        temp = agencia1.busca(num);    //temp = 4567
                        if(temp==null) System.out.println("Numero de conta nao existe");
                        else {
                            System.out.print("Informe o valor a sacar:");
                            double valor = in.nextDouble();
                            if(temp.sacar(valor)==true){
                                System.out.println("Saque realizado com sucesso.");
                            }
                            else{
                                System.out.println("Saque nao realizado");
                            }
                        }
                        break;
                        
                case 6: System.out.print("Informe o numero de conta de origem: ");
                        num = in.nextInt();
                        Conta origem = agencia1.busca(num);   
                        if(origem==null) System.out.println("Numero de conta de origem nao existe");
                        else{
                            System.out.print("Informe o numero de conta de destino: ");
                            num = in.nextInt();
                            Conta destino = agencia1.busca(num); 
                            if(destino==null) System.out.println("Numero de conta de destino nao existe");
                            else{
                                if(origem==destino) System.out.println("Erro. Conta de origem e destino nao pode ser a mesma");
                                else{
                                        System.out.print("Informe o valor a transferir:");
                                        double valor = in.nextDouble();
                                        if(origem.transferir(valor,destino)==true)  System.out.println("Transferencia realizada com sucesso.");
                                        else System.out.println("Transferencia nao realizada");
                                }
                            }
                        }
                        break;
                        
                case 7: System.out.print("Informe o numero de conta a excluir: ");
                        num = in.nextInt();
                        if(agencia1.exclui(num)==true) System.out.println("Conta excluida com sucesso!");
                        else System.out.println("Numero de conta nao existe");
                        break;
                case 8 : 
                    buscaPorCpf(agencia1); 
                    break;
                case 9: 
                    buscaClienteCpf(agencia1); 
                    break;
                case 10:
                    break;
                case 11:
                    alterarEndereco(agencia1);
                    break;
                case 12:
                    buscarBairro(agencia1);
                    break;
                default: System.out.println("Opçao invalida");
            }
        }while(op!=0);
    }
    
    private static void cadastra(Agencia agencia1){
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o cpf:");
        String cpf = in.nextLine();
        System.out.print("Informe o nome: ");
        String nome = in.nextLine();
        if(agencia1.insere(cpf,nome)==true) System.out.println("Conta cadastrada com sucesso.");
        else System.out.println("Erro. Conta nao cadastrada");
    }
    
    private static void buscaPorCpf(Agencia agencia1){
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o cpf da conta a ser buscada:");
        String cpf = in.nextLine();
        Conta temp = agencia1.buscaPorCpf(cpf);    
        if(temp==null) System.out.println("Cpf nao existe");
        else System.out.println(temp.toString());        
    }
    
    private static void buscaClienteCpf(Agencia agencia1)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o cpf da conta a ser recuperada");
        String cpf = in.nextLine();
        Cliente temp = agencia1.buscaClientePorCpf(cpf);
        if(temp == null) System.out.println("Cpf nao existe");
        else System.out.println(temp.toString());
    }
    
    private static void alterarEndereco(Agencia agencia1)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Cpf da conta a ser alterada: ");
        String cpf = in.nextLine();
        System.out.println("Informe o logradouro: ");
        String logra = in.nextLine();
        System.out.println("Informe o bairro: ");
        String bairro = in.nextLine();
        //agencia1.setEndereco(logra, bairro, cpf);
        if(agencia1.setEndereco(logra, bairro, cpf)) System.out.println("Endereco alterado com sucesso");
        else System.out.println("Erro ao alterar endereco");
    }
    
    private static void buscarBairro(Agencia agencia1)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o bairro para procurar clientes: ");
        String bairro = in.nextLine();
        Cliente[] temp = agencia1.buscaBairro(bairro);
        if(temp == null) System.out.println("nao ha clientes nesse bairro");
        else 
        {
            for(int i = 0; i < temp.length; i++)
            {
                System.out.println(temp[i].toString());
            }
        }
    }
}











