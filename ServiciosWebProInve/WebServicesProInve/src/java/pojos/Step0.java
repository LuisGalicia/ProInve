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
public class Step0 {
    Integer id_step;
    Integer id_tipo_inversion;
    Integer id_origen;
    Integer monto_inversion;
    Integer plazo;

    public Step0() {
    }

    public Step0(Integer id_step, Integer id_tipo_inversion, Integer id_origen, Integer monto_inversion, Integer plazo) {
        this.id_step = id_step;
        this.id_tipo_inversion = id_tipo_inversion;
        this.id_origen = id_origen;
        this.monto_inversion = monto_inversion;
        this.plazo = plazo;
    }        

    public Integer getId_step() {
        return id_step;
    }

    public void setId_step(Integer id_step) {
        this.id_step = id_step;
    }

    public Integer getId_tipo_inversion() {
        return id_tipo_inversion;
    }

    public void setId_tipo_inversion(Integer id_tipo_inversion) {
        this.id_tipo_inversion = id_tipo_inversion;
    }

    public Integer getId_origen() {
        return id_origen;
    }

    public void setId_origen(Integer id_origen) {
        this.id_origen = id_origen;
    }

    public Integer getMonto_inversion() {
        return monto_inversion;
    }

    public void setMonto_inversion(Integer monto_inversion) {
        this.monto_inversion = monto_inversion;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }       
}
