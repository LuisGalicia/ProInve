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
public class Step4 {
    Integer id_cuenta;
    Integer clabe;
    Integer no_cuenta;
    Integer id_step1;
    Integer id_banco;
    Integer id_origen_inversion;
    Integer id_tipo_inversion;
    Integer monto_inversion;
    Integer plazo_inversion;
    byte[] firma;
    
    public Step4(){        
    }

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Integer getClabe() {
        return clabe;
    }

    public void setClabe(Integer clabe) {
        this.clabe = clabe;
    }

    public Integer getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(Integer no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public Integer getId_step1() {
        return id_step1;
    }

    public void setId_step1(Integer id_step1) {
        this.id_step1 = id_step1;
    }

    public Integer getId_banco() {
        return id_banco;
    }

    public void setId_banco(Integer id_banco) {
        this.id_banco = id_banco;
    }

    public Integer getId_origen_inversion() {
        return id_origen_inversion;
    }

    public void setId_origen_inversion(Integer id_origen_inversion) {
        this.id_origen_inversion = id_origen_inversion;
    }

    public Integer getId_tipo_inversion() {
        return id_tipo_inversion;
    }

    public void setId_tipo_inversion(Integer id_tipo_inversion) {
        this.id_tipo_inversion = id_tipo_inversion;
    }

    public Integer getMonto_inversion() {
        return monto_inversion;
    }

    public void setMonto_inversion(Integer monto_inversion) {
        this.monto_inversion = monto_inversion;
    }

    public Integer getPlazo_inversion() {
        return plazo_inversion;
    }

    public void setPlazo_inversion(Integer plazo_inversion) {
        this.plazo_inversion = plazo_inversion;
    }

    public byte[] getFirma() {
        return firma;
    }

    public void setFirma(byte[] firma) {
        this.firma = firma;
    }
        
}
