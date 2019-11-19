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
public class Step3 {
    String calle;
    Integer numero;
    Integer id_codigo_postal;
    Integer id_step1;
    
    public Step3(){        
    }

    public Step3(String calle, Integer numero, Integer id_codigo_postal, Integer id_step1) {
        this.calle = calle;
        this.numero = numero;
        this.id_codigo_postal = id_codigo_postal;
        this.id_step1 = id_step1;
    }      

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getId_codigo_postal() {
        return id_codigo_postal;
    }

    public void setId_codigo_postal(Integer id_codigo_postal) {
        this.id_codigo_postal = id_codigo_postal;
    }

    public Integer getId_step1() {
        return id_step1;
    }

    public void setId_step1(Integer id_step1) {
        this.id_step1 = id_step1;
    }    
    
}
