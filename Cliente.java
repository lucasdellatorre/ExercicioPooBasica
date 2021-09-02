
/**
 * Escreva a descrição da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Cliente
{
    private String cpf, nome, logradouro, bairro;
    
    public Cliente(String cpf, String  nome){
        this.cpf = cpf;
        this.nome = nome.toUpperCase();
        logradouro = "nao informado";
        bairro = "nao informado";
    }
    
    public String getCpf(){ return cpf;}
    public String getNome(){ return nome;}
    public String getLogradouro(){ return logradouro;}
    public String getBairro(){ return bairro;}
    
    public void setNome(String nome){ this.nome = nome.toUpperCase();}
    public void setLogradouro (String logradouro) { this.logradouro = logradouro.toUpperCase();}
    public void setBairro(String bairro){ this.bairro = bairro.toUpperCase();}
    
    public String toString(){
        return "CPF: " + cpf + " NOME: " + nome + " RUA/AV. " + logradouro + " BAIRRO: " + bairro;
    }
}
