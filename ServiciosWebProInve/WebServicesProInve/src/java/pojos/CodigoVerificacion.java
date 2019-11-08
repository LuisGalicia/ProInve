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
public class CodigoVerificacion {
    Integer id_codigo_verificacion;
    Integer codigo_verificacion;
    boolean estado;

    public CodigoVerificacion() {
    }

    public Integer getId_codigo_verificacion() {
        return id_codigo_verificacion;
    }

    public void setId_codigo_verificacion(Integer id_codigo_verificacion) {
        this.id_codigo_verificacion = id_codigo_verificacion;
    }

    public Integer getCodigo_verificacion() {
        return codigo_verificacion;
    }

    public void setCodigo_verificacion(Integer codigo_verificacion) {
        this.codigo_verificacion = codigo_verificacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }        
}
