/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author lugad
 */
public class Direccion {
    Integer id_direccion;
    Integer id_codigo_postal;
    Integer numero;
    String calle;

    public Direccion () {
        
    }
    
    public Integer getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Integer id_direccion) {
        this.id_direccion = id_direccion;
    }

    public Integer getId_codigo_postal() {
        return id_codigo_postal;
    }

    public void setId_codigo_postal(Integer id_codigo_postal) {
        this.id_codigo_postal = id_codigo_postal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    
    
}
