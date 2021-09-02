
/**
 * Lucas Dellatorre e Davi Klaus
 */
public class ListaDePacientes
{
    private Paciente[] lista;
    private int indice, identificador;
    public ListaDePacientes(int quantidade)
    {
        if (quantidade < 5) quantidade = 5;
        lista = new Paciente[quantidade];
        identificador = 100;
    }
    public boolean inserePaciente(String nome, char sexo)
    {
        if (indice == lista.length) return false;
        Paciente novoP = new Paciente(nome, sexo, identificador);
        lista[indice] = novoP;
        indice++;
        identificador++;
        return true;
    }
    public int qtdAcimaP()
    {
        int cont = 0;
        for(int i = 0; i < indice ; i++)
        {
            if(lista[i].getPeso() > lista[i].pesoIdeal()) cont++;
        }
        return cont;
    }
    public Paciente[] listaRisco(String risco)
    {
        int cont = 0, j = 0;
        for(int i = 0; i < indice ; i++)
        {
            if(risco.equalsIgnoreCase(lista[i].risco())) cont++;
        }
        if(cont == 0) return null;
        Paciente[] listaR = new Paciente[cont];
        for(int i = 0; i < indice ; i++)
        {
            if(risco.equalsIgnoreCase(lista[i].risco()))
            {
                listaR[j] = lista[i];
                j++;
            }
        }
        return listaR;
    }
    public Paciente buscaPorCodigo(int codigo)
    {
        if(codigo<0) return null;
        for(int i = 0; i < indice ; i++)
        {
            if(lista[i].getCodigo() == codigo) return lista[i];
        }
        return null;
    }
    
    public Paciente buscaPorNome(String nome)
    {
        for(int i = 0; i < indice ; i++)
        {
            if(lista[i].getNome().equalsIgnoreCase(nome)) return lista[i];
        }
        return null;
    }
    public Paciente[] listaGenero(char sexo)
    {
        int cont = 0, j = 0;
        for(int i = 0; i < indice ; i++)
        {
            if(sexo == lista[i].getSexo()) cont++;
        }
        if(cont == 0) return null;
        Paciente[] listaG = new Paciente[cont];
        for(int i = 0; i < indice ; i++)
        {
            if(sexo == lista[i].getSexo())
            {
                listaG[j] = lista[i];
                j++;
            }
        }
        return listaG;
    }
    public boolean excluiPorCodigo(int codigo)
    {
       if(buscaPorCodigo(codigo) == null) return false;
        int pos = 0;
       for(int i=0; i<indice; i++)
       {
           if(lista[i].getCodigo() == codigo) {pos = i; break;}
       }
        for(int j=pos; j<indice-1; j++)
        {  
           lista[j] = lista[j+1];
       }
       indice--;
       lista[indice]=null;
       return true;
    }
    public String toString()
    {
        String msg = "Lista de Pacientes\n";
        Paciente aux;
        for(int i = 0; i < indice -1 ; i++)
        {
            for(int j = 0; j < indice -1 - i; j++)
            {   
                if(lista[j].getNome().compareToIgnoreCase(lista[j+1].getNome()) > 0)
                {
                    aux = lista[j];
                    lista[j] = lista[j+1];
                    lista[j+1] = aux;
                }
            }
        }
        for(int i = 0; i < indice ; i++)
        {
            msg = msg + lista[i].toString() + "\n";
        }
        return msg;
    }
}
