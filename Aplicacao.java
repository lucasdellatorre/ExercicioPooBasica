import java.util.Scanner;
public class Aplicacao
{
    private Scanner in;
    private ListaDePacientes ficha;
    public void inicializar()
    {
        in = new Scanner(System.in);
        ficha = new ListaDePacientes(100);
    }

    public void processar()
    {
        int op;
        do{
            System.out.println("1 - Lista todos os pacientes");
            System.out.println("2 - Insere paciente");
            System.out.println("3 - Busca paciente por codigo");
            System.out.println("4 - Busca paciente por nome");
            System.out.println("5 - Altera os dados de um paciente");
            System.out.println("6 - Exclui paciente");
            System.out.println("7 - Lista os pacientes de um determinado genero ");
            System.out.println("8 - Lista pacientes por risco definido pelo IMC");
            System.out.println("9 - Quantidade de pacientes acima do peso ideal");
            System.out.println("0 - Fim do Programa!");
            op = in.nextInt();
            switch(op)
            {
                case 0: System.out.println("Fim do programa!"); break;
                case 1: System.out.println(ficha.toString()); break;
                case 2: insere(ficha); break;
                case 3: buscaPorCodigo(ficha); break;
                case 4: buscaPorNome(ficha); break;
                case 5: alteraDados(ficha); break;
                case 6: exclui(ficha); break;
                case 7: listaGenero(ficha); break;
                case 8: listaImc(ficha); break;
                case 9: listaPeso(ficha); break;
                default: System.out.println("Informe uma opcao valida!"); break;
            }
        }while(op != 0);
    }
    private static void listaPeso(ListaDePacientes ficha)
    {
        Scanner in = new Scanner(System.in);
        int qtd = ficha.qtdAcimaP();
        if(qtd == 0) System.out.println("Nao ha pacientes acima do peso ideal");
        else
        if(qtd == 1) System.out.println("Existe 1 paciente acima do peso ideal");
        else System.out.println("Existem " + qtd + " pacientes a cima do peso");
    }
    private static void listaImc(ListaDePacientes ficha)
    {
        Scanner in = new Scanner(System.in);
        int op;
        do{
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Pacientes abaixo do normal");
            System.out.println("2 - Pacientes com peso normal");
            System.out.println("3 - Pacientes com excesso de peso");
            System.out.println("4 - Pacientes com obesidade");
            System.out.println("5 - Pacientes com obesidade morbida");
            op = in.nextInt();
            switch(op)
            {
                case 0 : break;
                case 1:
                    String risco = "abaixo do normal";
                    if(ficha.listaRisco(risco) != null)
                    {
                        Paciente[] temp = ficha.listaRisco(risco);
                        for(int i = 0; i < temp.length ; i++)
                        {
                            System.out.println(temp[i].toString());
                        }
                    }
                    else System.out.println("Nao ha pacientes com esse risco");
                    break;
                case 2:
                    risco = "normal";
                    if(ficha.listaRisco(risco) != null)
                    {
                        Paciente[] temp = ficha.listaRisco(risco);
                        for(int i = 0; i < temp.length ; i++)
                        {
                            System.out.println(temp[i].toString());
                        }
                    }
                    else System.out.println("Nao ha pacientes com esse risco");
                    break;
                case 3:
                    risco = "excesso de peso";
                    if(ficha.listaRisco(risco) != null)
                    {
                        Paciente[] temp = ficha.listaRisco(risco);
                        for(int i = 0; i < temp.length ; i++)
                        {
                            System.out.println(temp[i].toString());
                        }
                    }
                    else System.out.println("Nao ha pacientes com esse risco");
                    break;
                case 4:
                    risco = "obesidade";
                    if(ficha.listaRisco(risco) != null)
                    {
                        Paciente[] temp = ficha.listaRisco(risco);
                        for(int i = 0; i < temp.length ; i++)
                        {
                            System.out.println(temp[i].toString());
                        }
                    }
                    else System.out.println("Nao ha pacientes com esse risco");
                    break;
                case 5:
                    risco = "obesidade morbida";
                    if(ficha.listaRisco(risco) != null)
                    {
                        Paciente[] temp = ficha.listaRisco(risco);
                        for(int i = 0; i < temp.length ; i++)
                        {
                            System.out.println(temp[i].toString());
                        }
                    }
                    else System.out.println("Nao ha pacientes com esse risco");
                    break;
                default: System.out.println("Informe uma opcao valida!");
                    break;
            }
        }while(op != 0);
    }
    private static void listaGenero(ListaDePacientes ficha)
    {
        Scanner in = new Scanner(System.in);
        char sexo;
        do{
            System.out.println("Informe o sexo do paciente: (M ou F)");
            sexo = in.next().charAt(0);
            sexo = Character.toUpperCase(sexo);
        }while(sexo != 'M' && sexo != 'F');
        if(ficha.listaGenero(sexo) != null)
        {
            Paciente[] temp = ficha.listaGenero(sexo);
            for(int i = 0; i < temp.length ; i++)
            {
                System.out.println(temp[i].toString());
            }
        }
        else System.out.println("Nao ha pacientes com esse sexo");
    }
    private static void exclui(ListaDePacientes ficha)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o codigo do paciente a ser alterado: ");
        int codigo = in.nextInt();
        while(ficha.buscaPorCodigo(codigo) == null)
        {
            System.out.println("Codigo invalido ou nao existente");
            System.out.println("Informe o codigo do paciente a ser alterado: ");
            codigo = in.nextInt();
        }
        if(ficha.excluiPorCodigo(codigo)) System.out.println("Conta excluida com sucesso");
        else System.out.println("Erro ao excluir conta");
    }
    private static void insere(ListaDePacientes ficha)
    {
        Scanner in = new Scanner(System.in);
        String nome;
        char sexo;
        System.out.println("Informe o nome do paciente: ");
        nome = in.nextLine();
        do{
            System.out.println("Informe o sexo do paciente: (M ou F)");
            sexo = in.next().charAt(0);
            sexo = Character.toUpperCase(sexo);
        }while(sexo != 'M' && sexo != 'F');
        System.out.println("Criando ficha do paciente...");
        if(ficha.inserePaciente(nome,sexo))System.out.println("Paciente inserido com sucesso");
        else System.out.println("Erro ao inserir paciente");
    }
    private static void buscaPorCodigo(ListaDePacientes ficha)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o codigo do paciente para ser buscado: ");
        int codigo = in.nextInt();
        if(ficha.buscaPorCodigo(codigo) != null) System.out.println(ficha.buscaPorCodigo(codigo));
        else System.out.println("Codigo nao encontrado");
    }
    private static void buscaPorNome(ListaDePacientes ficha)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o nome do paciente a ser procurado: ");
        String nome = in.nextLine();
        if(ficha.buscaPorNome(nome) != null) System.out.println(ficha.buscaPorNome(nome));
        else System.out.println("Nao existe paciente com esse nome!");
    }
    private static void alteraDados(ListaDePacientes ficha)
    {
        Scanner in = new Scanner(System.in);
        int op = 0;
        System.out.println("Informe o codigo do paciente a ser alterado: ");
        int codigo = in.nextInt();
        while(ficha.buscaPorCodigo(codigo) == null)
        {
            System.out.println("Codigo invalido ou nao existente");
            System.out.println("Informe o codigo do paciente a ser alterado: ");
            codigo = in.nextInt();
        }
        System.out.println(ficha.buscaPorCodigo(codigo));
        do{
            if(op == 6)
            {
                System.out.println("Informe o codigo do paciente a ser alterado: ");
                codigo = in.nextInt();
                while(ficha.buscaPorCodigo(codigo) == null)
                {
                    System.out.println("Codigo invalido ou nao existente");
                    System.out.println("Informe o codigo do paciente a ser alterado: ");
                    codigo = in.nextInt();
                }
            }
            System.out.println("Informe o que voce deseja mudar dos dados do paciente");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Alterar Nome");
            System.out.println("2 - Alterar Sexo");
            System.out.println("3 - Alterar Idade");
            System.out.println("4 - Alterar Altura");
            System.out.println("5 - Alterar Peso");
            System.out.println("6 - Alterar dados de outro paciente");
            op = in.nextInt();
            switch(op)
            {
                case 0 : break;
                case 1:
                    alteraNome(ficha, codigo);
                    break;
                case 2:
                    char sexo;
                    do{
                        System.out.println("Informe o novo sexo do paciente: (M ou F)");
                        sexo = in.next().charAt(0);
                        sexo = Character.toUpperCase(sexo);
                    }while(sexo != 'M' && sexo != 'F');
                    ficha.buscaPorCodigo(codigo).setSexo(sexo);
                    break;
                case 3:
                    System.out.println("Informe a nova idade do paciente: ");
                    int idade = in.nextInt();
                    while(idade < 0 || idade > 120)
                    {
                        System.out.println("Informe uma idade menor que 120 anos");
                        System.out.println("Informe a idade do paciente: ");
                        idade = in.nextInt();
                    }
                    ficha.buscaPorCodigo(codigo).setIdade(idade);
                    break;
                case 4:
                    System.out.println("Informe a nova altura do paciente: ");
                    System.out.println("Obs: Se sua altura eh 180 cm, por exemplo, informe 1.80");
                    double altura = in.nextDouble();
                    while(altura < 0 || altura > 2.5)
                    {
                        System.out.println("Informe uma altura menor que 2.5m");
                        System.out.println("Informe a altura do paciente: ");
                        System.out.println("Obs: Se sua altura eh 180 cm, por exemplo, informe 1.80m");
                        altura = in.nextDouble();
                    }
                    ficha.buscaPorCodigo(codigo).setAltura(altura);
                    break;
                case 5:
                    System.out.println("Informe o novo peso do paciente: ");
                    double peso = in.nextDouble();
                    while(peso < 0 || peso > 150)
                    {
                        System.out.println("Peso invalido, informe um peso menor que 150");
                        System.out.println("Informe o peso do paciente: ");
                        peso = in.nextDouble();
                    }
                    ficha.buscaPorCodigo(codigo).setPeso(peso);
                    break;
                case 6:
                    continue;
                default: System.out.println("Informe uma opcao valida!");
                    break;
            }
        }while(op != 0);
    }
    private static void alteraNome(ListaDePacientes ficha, int codigo)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o novo nome do paciente: ");
        String nome1 = in.nextLine();
        ficha.buscaPorCodigo(codigo).setNome(nome1);
    }
}
