package global;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class MelhorCanil {

    /*Variáveis*/
    //Proximidade dos petshops: Meu Canino Feliz, Vai Rex e ChowChawgas
    //Dia da semana
    //Tamanho dos cães: Pequenos e grandes
    //Meu canino feliz:
    //2km;
    //Na semana: pequenos: R$20,00 e grandes: R$40,00
    //Fim de semana: 20% a mais
    //Vai Rex:
    //1,7km;
    //Na semana: pequenos: R$15,00 e grandes: R$50,00
    //Fim de semana: pequenos: R$20,00 e grandes: R$55,00
    //ChowChawgas:
    //800km
    //Na semana: pequenos: R$30,00 e grandes: R$45,00
    //Fim de semana: pequenos: R$30,00 e grandes: R$45,00
    /*Entrada do programa:*/
    //<data> <quantidade de cães pequenos> <quantidade cães grandes>
    //Exemplo: 03/08/2018 3 5
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        String data, dia_semana, completo;
        int pequenos, grandes;

        System.out.println("Digite a data do banho (dd/mm/yyyy), a quantidade de cães pequenos e a quantidade de cães grandes. \nExemplo: 03/08/2018 3 5\n");
        completo = teclado.nextLine();

        //Separa todas as informações da resposta (data, qtd de cães pequenos e de grandes)
        String partes[] = new String[3];

        partes = completo.split(" ");

        data = partes[0];
        pequenos = Integer.parseInt(partes[1]);
        grandes = Integer.parseInt(partes[2]);

        VerificaDia.weekDay(data);

        MeuCaninoFeliz meuCaninoFeliz = new MeuCaninoFeliz(VerificaDia.diaSemana, grandes, pequenos);
        VaiRex vaiRex = new VaiRex(VerificaDia.diaSemana, grandes, pequenos);
        ChowChawgas chowChawgas = new ChowChawgas(VerificaDia.diaSemana, grandes, pequenos);

        comparar(meuCaninoFeliz, vaiRex, chowChawgas);
        //System.out.println("Melhor canil: " + comparar(meuCanino, rex, chow));

    }

    public static String comparar(MeuCaninoFeliz meuCaninoFeliz, VaiRex vaiRex, ChowChawgas chowChawgas) {

        float mcf = meuCaninoFeliz.calcular();
        float vr = vaiRex.calcular();
        float cc = chowChawgas.calcular();

        String melhor = "";

        //Cria uma lista de valores para cada petshop
        List<Float> valores = new ArrayList<Float>();

        valores.add(mcf);
        valores.add(vr);
        valores.add(cc);

        float menorValor = valores.get(0);

        //Atualiza o menor valor percorrendo a lista
        for (float valor : valores) {
            if (valor < menorValor) {
                menorValor = valor;
            }
        }

        //Ordena os valores
        Collections.sort(valores);

        
        //Valores iguais para todos
        if (valores.get(0).equals(valores.get(1)) && valores.get(0).equals(valores.get(2))) {
            System.out.println("O melhor petshop é: ChowChawgas");
        } 
        //Somente os dois menores iguais
        else if (valores.get(0).equals(valores.get(1))) {
            if (valores.get(0).equals(cc) || valores.get(1).equals(cc)) {
                System.out.println("O melhor petshop é: ChowChawgas");
            } else {
                System.out.println("O melhor petshop é: Vai Rex");
            }

        }
        //Verifica separadamente
        else{
            if(valores.get(0).equals(vr)){
                System.out.println("O melhor petshop é: Vai Rex");
            } else if(valores.get(0).equals(cc)){
                System.out.println("O melhor petshop é: ChowChawgas");
            } else{
                System.out.println("O melhor petshop é: Meu Canino Feliz");
            }
        }

        System.out.println("Valor total dos banhos: " + menorValor);

        //System.out.println("Meu Canino Feliz: "+meuCaninoFeliz+" Vai Rex: "+vaiRex+" ChowChawgas: "+chowChawgas);
        return melhor;
    }

}
