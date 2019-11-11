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
public class CatalogoOrigenInversion {
    Integer id_origen;
    String nombre;
    
    public CatalogoOrigenInversion(){        
    }

    public Integer getId_origen() {
        return id_origen;
    }

    public void setId_origen(Integer id_origen) {
        this.id_origen = id_origen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }        
}
