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
public class VaiRex extends Petshop {
    //static final int distancia = 1700;
    
    public VaiRex(boolean dia, int cGrandes, int cPequenos) {
        super(dia, cGrandes, cPequenos);
    }
    
    //Método que contabiliza o valor na Vai Rex
    @Override
    public float calcular(){
        float total = 0;

        //Para fins de semana o valor é diferente
         if (VerificaDia.diaSemana == false) {
            total = (20 * this.getcPequenos()) + (55 * this.getcGrandes());
        } else {
            total = (15 * this.getcPequenos()) + (50 * this.getcGrandes());
        }

        return total;
    }
}
