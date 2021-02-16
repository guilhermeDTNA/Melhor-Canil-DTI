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
public abstract class Petshop {
    
    //dia = true -> dia de semana
    //dia = false -> fim de semana
    private boolean dia;
    private int cGrandes, cPequenos;
    
    public Petshop(boolean dia, int cGrandes, int cPequenos){
        this.dia = dia;
        this.cGrandes = cGrandes;
        this.cPequenos = cPequenos;
    }

    public boolean isDia() {
        return dia;
    }

    public void setDia(boolean dia) {
        this.dia = dia;
    }

    public int getcGrandes() {
        return cGrandes;
    }

    public void setcGrandes(int cGrandes) {
        this.cGrandes = cGrandes;
    }

    public int getcPequenos() {
        return cPequenos;
    }

    public void setcPequenos(int cPequenos) {
        this.cPequenos = cPequenos;
    }
    
    public abstract float calcular();
}
