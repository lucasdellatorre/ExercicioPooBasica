
/**
 * Escreva a descrição da classe Conta aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Conta
{
    //atributos: variaveis que representam as caracteristicas, as propriedades dos objetos da classe
    //modificadorDeAcesso tipo nomeDoAtributo
    private int numero;
    private double saldo;
    private Cliente donoDaConta;
    private boolean status;
    
    //Metodo construtor: tem o nome da classe, serve para instanciar os objetos e atribuir valores iniciais aos atributos
    public Conta(){
        numero = 1;
        saldo = 100;
        status = true;
    }
    
    
    public Conta(int numeroInicial){
        if(numeroInicial>0) numero = numeroInicial;
        else numero = 1;
        saldo = 0;
    }
    
    //Metodos de acesso: metodos de consulta: getters.   
    //assinatura (cabecalho): public  tipoDoAtributo getNomeDoAtributo()
    public void statusTrue()
    {
        status = true;
    }
    public void statusFalse()
    {
        status = false;
    }
    public boolean getStatus()
    {
        return status;
    }
    public int getNumero(){
        return numero;
    }
    public double getSaldo(){
        return saldo;
    }
    public Cliente getDonoDaConta(){
        return donoDaConta;
    }
    //Metodos modificadores: modificam, alteram os valores dos atributos : setters
    //Assinatura public void setNomeDoAtributo( tipoDoAtributo parametro)
    public void setNumero(int novoNumero){
        if(novoNumero>0) numero = novoNumero;
    }
    
    public void setDonoDaConta(Cliente donoDaConta){
        this.donoDaConta = donoDaConta;
    }
    
    //Metodo toString:  String com o estado atual do objeto: os valores atuais dos atributos
    public String toString(){
        String msg = "N.: " + numero + " Saldo: R$ " + saldo;
        if(donoDaConta!=null) msg = msg + " " + donoDaConta.toString();
        return msg;
    }
    
    //metodos especificos
    /*public void depositar(double valor){
        if(valor>0) saldo = saldo + valor;
    }*/
    
   /* public void sacar(double valor){
        if(valor>0 && valor<=saldo) saldo = saldo - valor;
    }*/
    public boolean depositar(double valor){
        if(valor>0) {
            saldo = saldo + valor;
            return true;
        }
        return false;
    }
    
    public boolean sacar(double valor){
        if(valor>0 && valor<=saldo) {
            saldo = saldo - valor;
            return true;
        }
        return false;
    }
    
    public boolean transferir(double valor, Conta destino){
        if(sacar(valor)==true){
            if(destino.depositar(valor)==true){
                return true;
            }
            else{
                depositar(valor);
            }
        }
        return false;
    }
}




























