package conteúdo;

import java.util.ArrayList;

/**
 *
 * @author João Eduardo Vasconcellos da Silva
 * LinkedIn: https://www.linkedin.com/in/jo%C3%A3o-eduardo-vasconcellos-da-silva-39394a18a/
 * GitHub: https://github.com/JevsJevs
 */
public class Conteúdo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       /*
        Bom dia zuppers!Realizei o desafio inteiramente na linguagem Java, as funções seguem
        a ordem das questões. Agradeço a oportunidade recebida e espero fazer parte de seu
        quadro de estagiários! Meus comprimentos ao Guilherme que foi até Limeira para falar
        com a gente! :)
        
        Estarei colocando apenas esta classe no repositório Git, sem os outros arquivos da IDE 
        para atrapalhar.
        
        -João Eduardo Vasconcellos da Silva
        */


        //Aplicação das funções
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        System.out.println("1 - A palavra é um palíndromo? "+palindromo("ArAra"));
        
        System.out.println("2 - O espaço binário retornado é: "+espacoBin(1041));
        
        System.out.println("3 - A sequência é uma permutação? "+permutacao(new int[]{3,4,6,2,5,1,8,7,10}));
        
        System.out.println("4 - O número de elementos é: "+repeticao(new int[]{3,4,3,3,5,2,8,5,7,7,7,7,7,9,8,8,8}));
        
        System.out.println("5 - O maior lucro que pode ser obtido é: "+mercado(new float[]{23171,21011,21123,21366,21013,21367}));
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        
    }
    
    public static boolean palindromo(String palavra)
    {
        //crio e inicializo a variável de retorno
        boolean isPalindrome = false; 
        
        //transformo o input para letras minúsculas para evitar falsos negativos. Ex: Reviver, Ana, ArArA
        palavra = palavra.toLowerCase();
        
        // crio um array do mesmo tamanho do input
        char[] inverso = new char[palavra.length()]; 
        
        //contador que acompanha o indice do array 'inverso'
        int count = 0;
           
        // laço de repetição que insere no array 'inverso' o input ao contrário
        for(int i = palavra.length()-1; i>=0 ; i--)
        {
            //atribui o elemento da palavra recebida à posição oposta no array inverso
            inverso[count] = palavra.charAt(i);
            count ++;
        }  
        
        // compara o inverso da palavra com ela na ordem normal e caso haja igualdade o retorno se torna true
        if(palavra.equals(new String(inverso))) 
            isPalindrome = true;

        return isPalindrome;
    }
    
    public static int espacoBin(Integer num)
    {
        
        //crio um arrayList que conterá o valor binário do numero recebido, separando cada elemento em uma posição
        ArrayList<Integer> bin = new ArrayList();
        
        //transformação do número em binário: OBS: ele estará inverso, mas não afetará o problema
        while(num>0)
        {
            bin.add(num%2);
            num = num/2;
        }
        
        /*criação das variáveis 'sequencia', que será o contador de 0's geral,
        e 'maiorSequencia', cujo valor armazenado é o maior espaço binário*/
        int sequencia =0;
        int maiorSequencia=0;
        
        //for que percorre o arrayList do fim para o começo, ou do começo do numero. 
        for(int i = bin.size()-1; i>=0 ; i--)
        {
            //condicional que verifica se o elemento no índice i é 0, incrementando 'sequencia'
            if(bin.get(i)== 0)
            {
                sequencia++;
            }
            /*se o elemento do índice não for 0, logo, é 1.
            Então é verificado se a sequencia que foi fechada é maior que a existente e
            caso seja, 'maiorSequencia' é substituido além de resetar 'sequencia'*/
            else
            {
                if((sequencia>maiorSequencia))
                {
                    maiorSequencia=sequencia;
                    sequencia=0;
                }
            }
        }
        
        /*como maiorSequencia é inicializado com o valor 0, caso não haja espaços binários o 0 é retornado,
        senão o maior espaço binário é devolvido*/
        return maiorSequencia;
    }
    
    public static boolean permutacao(int[] arr)
    {
        //crio variável de retorno
        boolean isPermut = true;
        
        // variável auxiliar para copiar valores
        int aux = 0;
        
        //for duplo for que ordena o array recebido
        for(int i = 0; i<arr.length; i++ )
        {
            for(int j = 0; j<arr.length; j++ )
            {
                //se arr[i] for menor que arr[j] eles trocam de posição
                if(arr[i]<arr[j])
                {
                    aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
        
        /*for que faz a verificação da permutação até o penúltimo elemento. 
        obs: Para nao sair do limite do array, visto que o número anterior é verificado*/
        
        for(int i = arr.length-1;i>0 ; i--)
        {
            // se o número antecedente for igual ao atual não é uma permutação
            // se o número antecedente não for o antecessor do atual não é uma permutação
            if((arr[i-1]== arr[i])||(arr[i-1] != arr[i]-1 ))
                isPermut = false;
        }
        
        return isPermut;
    }
    
    public static int repeticao(int[] A)
    {
        ArrayList<Integer> aux = new ArrayList(); // crio um arrayList no qual só inserirei os elementos de A uma vez, sem repetição
        
        boolean existe;//crio uma variável que contém a informação da presença do elemento no arrayList aux;
        
        for(int i = 0; i< A.length; i++) // for que percorre o array A sendo i o índice de cada elemento
        {
            // reseta a variável 'existe' *fará nova verificação*
            existe = false; 
            
            //no primeiro ciclo insere o primeiro elemento de A ao arrayList aux
            if(i==0) 
                aux.add(A[0]);
            
            //percorre o arrayList aux e verifica se o elemento de A[i] está presente
            for(int j = 0; j<aux.size(); j++)
            {
                //caso esteja presente a variável 'existe' se torna true
                if(A[i] == aux.get(j))
                    existe = true;
            }
            
            //se NÃO existir o elemento em 'aux',ele é adicionado
            if(!existe)
                aux.add(A[i]);
        }
        
   
        //retorna o tamanho do arrayList aux, que totaliza o número de todos os elementos distintos
        return aux.size();
    }
    
    public static float mercado(float[] arr)
    {
        //postulando: não é possivel vender a ação em um momento que ela não foi comprada.
        float ganhos = 0; // inicializo a variável ganhos com o valor 0
        
        //for que percorre o array para o valor de compra
        for(int i = 0; i<arr.length; i++) 
        {
            /*for que percorre o array para o valor de venda,
            lembrando que ele só verifica para os dias a partir da compra*/
            for(int j = i ;j<arr.length; j++)
            {
                /*se o valor de venda menos o valor de compra for maior que o valor dos ganhos,
                este o substituirá, pois indica maior lucro*/
                if(ganhos < arr[j]-arr[i])
                    // se o valor for negativo não será substituído, pois 'ganhos' será 0 e portanto maior, mantendo o retorno 0 caso não haja lucro */
                    ganhos = arr[j]-arr[i];          
            }
        }
        
        return ganhos;
    }
}
