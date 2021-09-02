/**
 * Lucas Dellatorre e Davi Klaus
 */
public class Paciente
{
   private String nome;
   private int idade;
   private double altura, peso;
   private char sexo;
   private int codigo;
   public Paciente(String nome, char sexo, int codigo)
   {
       if(codigo > 0) this.codigo = codigo;
       else codigo = 1;
       this.nome = nome.toUpperCase();
       this.sexo = sexo;
       altura = 1;
       peso = 1;
       idade = 1;
   }
   public Paciente(int codigo)
   {
       if(codigo > 0) this.codigo = codigo;
       else codigo = 1;
       sexo = 'X';
       nome = "Nao informado";
       peso = 1;
       altura = 1;
       idade = 1;
   }
   public void setCodigo(int codigo)
   {
       this.codigo = codigo;
   }
   public int getCodigo()
   {
       return codigo;
   }
   public void setNome(String nome)
   {
       this.nome = nome;
   }
   public String getNome()
   {
       return nome;
   }
   public char getSexo()
   {
       return sexo;
   }
   public void setSexo(char sexo)
   {
       this.sexo = sexo;
   }
   public void setPeso(double peso)
   {
       this.peso = peso;
   }
   public double getPeso()
   {
       return peso;
   }
   public void setAltura(double altura)
   {
       this.altura = altura;
   }
   public double getAltura()
   {
       return altura;
   }
   public void setIdade(int idade)
   {
       this.idade = idade;
   }
   public int getIdade()
   {
       return idade;
   }
   public boolean validaIdade(int idade)
   {
       return true;
   }
   public double imc() // (a)
   {
       return peso/Math.pow(altura,2);
   }
   public double pesoIdeal() //(b)
   {
       double pesoIdeal;
       if(sexo == 'M')
       {
           pesoIdeal = 72.7 * altura - 58;
           if(pesoIdeal<0) return 0;
           return pesoIdeal;
       }
       else 
       {
           pesoIdeal = 62.1 * altura - 44.7;
           if(pesoIdeal<0) return 0;
           return pesoIdeal;
       }
   }
   public String risco() // (c)
   {
       if(imc() < 20) return "abaixo do normal";
       else if (imc() < 25) return "normal";
       else if (imc() < 30) return "excesso de peso";
       else if (imc() < 35) return "obesidade";
       else return "obesidade morbida";
   }
   public String toString()
   {
       return  "\nNome: "     + getNome() + " | Sexo: " + getSexo() + " | Codigo " + getCodigo() +
               "\nInformacoes adicionais do paciente: " + 
               "\nIdade: "  +  getIdade()    +
               "\nAltura: " +  getAltura()   +
               "\nPeso: "   +  getPeso();    
   }
}