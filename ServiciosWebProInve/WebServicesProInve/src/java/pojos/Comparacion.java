/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author Jahir
 */
public class Comparacion {
    int importe;
    int[] tiposInversion;
    int plazo;

    public Comparacion() {
    }

    public Comparacion(int importe, int[] tiposInversion, int plazo) {
        this.importe = importe;
        this.tiposInversion = tiposInversion;
        this.plazo = plazo;
    }

    
    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public int[] getTiposInversion() {
        return tiposInversion;
    }

    public void setTiposInversion(int[] tiposInversion) {
        this.tiposInversion = tiposInversion;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }


}
