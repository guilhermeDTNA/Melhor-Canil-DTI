/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author guilherme
 */
public class VerificaDia {

    private static int dia, mes, ano;
    protected static boolean diaSemana; 
    
    public static String weekDay(String data) {

        //Atribui a data aos atributos da classe 
        VerificaDia.dia = Integer.parseInt(separarData(data)[0]);
        VerificaDia.mes = Integer.parseInt(separarData(data)[1]) - 1;
        VerificaDia.ano = Integer.parseInt(separarData(data)[2]);

        //Obtém o dia da semana relacionado à data enviada
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        String nome = "";
        c.set(Calendar.DAY_OF_MONTH, VerificaDia.dia);
        c.set(Calendar.MONTH, VerificaDia.mes);
        c.set(Calendar.YEAR, VerificaDia.ano);

        int dia = c.get(c.DAY_OF_WEEK);

        //Renomeia o dia da semana
        switch (dia) {
            case Calendar.MONDAY:
                nome = "Segunda";
                VerificaDia.diaSemana = true;
                break;
            case Calendar.TUESDAY:
                nome = "Terça";
                VerificaDia.diaSemana = true;
                break;
            case Calendar.WEDNESDAY:
                nome = "Quarta";
                VerificaDia.diaSemana = true;
                break;
            case Calendar.THURSDAY:
                nome = "Quinta";
                VerificaDia.diaSemana = true;
                break;
            case Calendar.FRIDAY:
                nome = "Sexta";
                VerificaDia.diaSemana = true;
                break;
            case Calendar.SATURDAY:
                nome = "Sábado";
                VerificaDia.diaSemana = false;
                break;
            case Calendar.SUNDAY:
                nome = "Domingo";
                VerificaDia.diaSemana = false;
                break;
        }
        return nome;
    }

    public static String[] separarData(String data) {
        String dataFinal[] = new String[3];

        dataFinal = data.split("/");

        return dataFinal;
    }
}
