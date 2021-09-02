
/**
 * Escreva a descrição da classe Agencia aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
//Busca cliente por cpf
//Busca clientes por bairro

public class Agencia
{
   private Conta[] lista;                         //lista = null
   private int identificador, indice;
   private String nomeAgencia;
   public Agencia(String nomeAgencia, int quantidade){                //           0     1     2     3     4      5                   indice = 2      identificador = 103
       if(quantidade<5) quantidade = 5;                               //lista ->  1145  4567  null  null   null   null
       lista = new Conta[quantidade];
       identificador = 100;
       indice = 0;
       this.nomeAgencia = nomeAgencia;                               //      1145 (numero = 100, saldo=0,  donoDaConta=6789)            //umaConta = 1145   i=1
   }                                                                 //           
   public String getNomeAgencia(){                                                   //  2345 (numero=101,saldo=0)
       return nomeAgencia;                                                                        //     4567  (numero=102, saldo=0)
   }
                                                                        //6789 -nome : Pedro cpf: 222222222 logradouro = nf   bairo=nf               umCliente = 6789       
   public boolean exclui(int numero){   //101
       int pos = buscaPosicao(numero);  //pos=1
       if(pos==-1) return false;
       for(int j=pos; j<indice-1; j++){  //j=2   
           lista[j] = lista[j+1];
       }
       indice--;
       lista[indice]=null;
       return true;
   }
   public void desativaConta(int numero) //
   {
       int pos = buscaPosicao(numero);
       lista[pos].statusFalse();
   }
   public int buscaPosicao(int numero){     //numero = 101
       Conta umaConta;
       for(int i=0; i<indice; i++){
           umaConta = lista[i];
           if(umaConta.getNumero()==numero) return i;
       }
       return -1;
   }
   
   public Conta busca(int numero){     //numero = 102
       Conta umaConta;
       for(int i=0; i<indice; i++){
           umaConta = lista[i];
           if(umaConta.getNumero()==numero) return umaConta;
       }
       return null;
   }
   
   public Conta buscaPorCpf(String cpf){
       Conta umaConta;
       Cliente umCliente;
       for(int i=0; i<indice; i++){
           umaConta = lista[i];
           umCliente = umaConta.getDonoDaConta();
           if(umCliente!=null && umCliente.getCpf().equals(cpf)) return umaConta;
       }
       return null;
   }
   public Cliente buscaClientePorCpf(String cpf)
   {
       Conta umaConta;
       Cliente umCliente;
       for(int i = 0; i < indice; i++)
       {
           umaConta = lista[i];
           umCliente = umaConta.getDonoDaConta();
           if(umCliente!=null && umCliente.getCpf().equals(cpf)) return umCliente;
       }
       return null;
   }
   public boolean setEndereco(String logra, String bairro, String cpf)
   {
       Cliente umCliente = buscaClientePorCpf(cpf);
       if(umCliente == null) return false;
       umCliente.setLogradouro(logra);
       umCliente.setBairro(bairro);
       return true;
   }
   public Cliente[] buscaBairro(String bairro)
   {
       bairro.toUpperCase();
       int cont = 0, j = 0;
       Cliente umCliente;
       for(int i = 0; i < indice; i++)
       {
           umCliente = lista[i].getDonoDaConta();
           if (lista[i].getDonoDaConta() != null && umCliente.getBairro().equals(bairro)) cont++;
       }
       if(cont == 0) return null;
       Cliente[] temp = new Cliente[cont];
       for(int i = 0; i< indice; i++)
       {
           umCliente = lista[i].getDonoDaConta();
           if (lista[i].getDonoDaConta() != null && umCliente.getBairro().equals(bairro)) 
           {
               temp[j] = lista[i].getDonoDaConta();
               j++;
           }
       }
       return temp;
   }
   public boolean insere()
   {
       if(indice==lista.length) return false;
       Conta umaConta = new Conta(identificador);
       identificador++;
       lista[indice] = umaConta;
       indice++;
       return true;
   }
   public boolean insere(Cliente dono)
   {
       if(indice==lista.length) return false;
       Conta umaConta = new Conta(identificador);
       umaConta.setDonoDaConta(dono);
       identificador++;
       lista[indice] = umaConta;
       indice++;
       return true;
   }
   public boolean insere(String cpf, String nome)
   {
       if(indice==lista.length) return false;
       Conta umaConta = new Conta(identificador);
       Cliente dono = new Cliente(cpf,nome);
       umaConta.setDonoDaConta(dono);
       identificador++;
       lista[indice] = umaConta;
       indice++;
       return true;
   }
   public String toString()
   {
       String msg=" Lista de Contas\n";
       for(int i=0; i<indice; i++){
           msg = msg + lista[i].toString() + "\n";
       }
       return msg;
   }
}
