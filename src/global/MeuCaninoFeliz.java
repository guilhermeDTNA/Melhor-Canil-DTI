/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

/**
 *
 * @author guilherme
 */
public class MeuCaninoFeliz extends Petshop {

    //static final int distancia = 2000;
    
    public MeuCaninoFeliz(boolean dia, int cGrandes, int cPequenos) {
        super(dia, cGrandes, cPequenos);
    }
    
    //Método que contabiliza o valor na Meu Canino Feliz
    @Override
    public float calcular(){
        float total = 0;

        //Tem que calcular 20% do valor total do banho em fins de semana
        if (VerificaDia.diaSemana == false) {
            total = ((20 * this.getcPequenos()) + (40 * this.getcGrandes())) + ((20 * this.getcPequenos()) + (40 * this.getcGrandes())) * 20 / 100;
        } else {
            total = (20 * this.getcPequenos()) + (40 * this.getcGrandes());
        }

        return total;
    }
}
