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
public class ChowChawgas extends Petshop {

    
    //static final int distancia = 800;

    //dia = true -> dia de semana
    //dia = false -> fim de semana
    public ChowChawgas(boolean dia, int cGrandes, int cPequenos) {
        super(dia, cGrandes, cPequenos);
    }

    //Método que contabiliza o valor na ChowChagas
    @Override
    public float calcular() {
        float total = 0;

        total = (30 * this.getcPequenos()) + (45 * this.getcGrandes());

        return total;
    }
}
