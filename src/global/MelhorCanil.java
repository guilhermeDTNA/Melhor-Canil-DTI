package global;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class MelhorCanil {

    private static int dia, mes, ano;

    public static int getDia() {
        return dia;
    }

    public static void setDia(int dia) {
        MelhorCanil.dia = dia;
    }

    public static int getMes() {
        return mes;
    }

    public static void setMes(int mes) {
        MelhorCanil.mes = mes;
    }

    public static int getAno() {
        return ano;
    }

    public static void setAno(int ano) {
        MelhorCanil.ano = ano;
    }

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


        //Além de separar a data, vai pegar o dia da semana
        dia_semana = weekDay(data);

        float meuCanino = meuCaninoFeliz(dia_semana, pequenos, grandes);
        float rex = vaiRex(dia_semana, pequenos, grandes);
        float chow = chowChawgas(dia_semana, pequenos, grandes);

        System.out.println("Melhor canil: " + comparar(meuCanino, rex, chow));

    }

    public static String[] separarData(String data) {
        String dataFinal[] = new String[3];

        dataFinal = data.split("/");

        return dataFinal;
    }

    //Método que contabiliza o valor na Meu Canino Feliz
    public static float meuCaninoFeliz(String dia_semana, int nPequenos, int nGrandes) {
        float total = 0;

        //Tem que calcular 20% do valor total do banho em fins de semana
        if (dia_semana.equalsIgnoreCase("Sábado") || dia_semana.equalsIgnoreCase("Domingo")) {
            total = ((20 * nPequenos) + (40 * nGrandes)) + ((20 * nPequenos) + (40 * nGrandes)) * 20 / 100;
        } else {
            total = (20 * nPequenos) + (40 * nGrandes);
        }

        return total;
    }

    //Método que contabiliza o valor na Vai Rex
    public static float vaiRex(String dia_semana, int nPequenos, int nGrandes) {
        float total = 0;

        //Para fins de semana o valor é diferente
        if (dia_semana.equalsIgnoreCase("Sábado") || dia_semana.equalsIgnoreCase("Domingo")) {
            total = (20 * nPequenos) + (55 * nGrandes);
        } else {
            total = (15 * nPequenos) + (50 * nGrandes);
        }

        return total;
    }

    //Método que contabiliza o valor na ChowChagas
    public static float chowChawgas(String dia_semana, int nPequenos, int nGrandes) {
        float total = 0;

        total = (30 * nPequenos) + (45 * nGrandes);

        return total;
    }

    public static String comparar(float meuCaninoFeliz, float vaiRex, float chowChawgas) {
        final int distMeuCaninoFeliz = 2000;
        final int distVaiRex = 1700;
        final int distChowChawgas = 800;

        String melhor = "";

        //Cria uma lista de valores para cada petshop
        List<Float> lista = new ArrayList<Float>();

        lista.add(meuCaninoFeliz);
        lista.add(vaiRex);
        lista.add(chowChawgas);

        float menorValor = lista.get(0);

        //Atualiza o menor valor percorrendo a lista
        for (float valor : lista) {
            if (valor < menorValor) {
                menorValor = valor;
            }
        }
        //Se os valores forem iguais, o melhor é o mais perto
        if (menorValor == meuCaninoFeliz && menorValor == vaiRex && menorValor == chowChawgas) {
            melhor = "ChowChawgas";
        } else if (menorValor == meuCaninoFeliz && menorValor == vaiRex) {
            melhor = "Vai Rex";
        } else if (menorValor == meuCaninoFeliz && menorValor == chowChawgas) {
            melhor = "ChowChawgas";
        } else if (menorValor == vaiRex && menorValor == chowChawgas) {
            melhor = "ChowChawgas";
        } else if (menorValor == meuCaninoFeliz) {
            melhor = "Meu Canino Feliz";
        } else if (menorValor == vaiRex) {
            melhor = "Vai Rex";
        } else if (menorValor == chowChawgas) {
            melhor = "chowChawgas";
        }

        //System.out.println("Meu Canino Feliz: "+meuCaninoFeliz+" Vai Rex: "+vaiRex+" ChowChawgas: "+chowChawgas);
        System.out.println("Valor total dos banhos: " + menorValor);
        return melhor;
    }

    public static String weekDay(String data) {

        //Atribui a data aos atributos da classe 
        setDia(Integer.parseInt(separarData(data)[0]));
        setMes(Integer.parseInt(separarData(data)[1]) - 1);
        setAno(Integer.parseInt(separarData(data)[2]));

        //Obtém o dia da semana relacionado à data enviada
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        String nome = "";
        c.set(Calendar.DAY_OF_MONTH, getDia());
        c.set(Calendar.MONTH, getMes());
        c.set(Calendar.YEAR, getAno());

        int dia = c.get(c.DAY_OF_WEEK);

        //Renomeia o dia da semana
        switch (dia) {
            case Calendar.MONDAY:
                nome = "Segunda";
                break;
            case Calendar.TUESDAY:
                nome = "Terça";
                break;
            case Calendar.WEDNESDAY:
                nome = "Quarta";
                break;
            case Calendar.THURSDAY:
                nome = "Quinta";
                break;
            case Calendar.FRIDAY:
                nome = "Sexta";
                break;
            case Calendar.SATURDAY:
                nome = "Sábado";
                break;
            case Calendar.SUNDAY:
                nome = "Domingo";
                break;
        }
        return nome;
    }

}