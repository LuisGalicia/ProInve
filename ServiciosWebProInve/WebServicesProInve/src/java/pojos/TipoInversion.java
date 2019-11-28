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
public class TipoInversion {
    int id_tipo_inversion;
    String tipo_inversion;
    float tasa_retorno;

    public TipoInversion() {
        
    }
    
    public TipoInversion(int id_tipo_inversion, String tipo_inversion, float tasa_retorno) {
        this.id_tipo_inversion = id_tipo_inversion;
        this.tipo_inversion = tipo_inversion;
        this.tasa_retorno = tasa_retorno;
    }

    public int getId_tipo_inversion() {
        return id_tipo_inversion;
    }

    public void setId_tipo_inversion(int id_tipo_inversion) {
        this.id_tipo_inversion = id_tipo_inversion;
    }

    public String getTipo_inversion() {
        return tipo_inversion;
    }

    public void setTipo_inversion(String tipo_inversion) {
        this.tipo_inversion = tipo_inversion;
    }

    public float getTasa_retorno() {
        return tasa_retorno;
    }

    public void setTasa_retorno(float tasa_retorno) {
        this.tasa_retorno = tasa_retorno;
    }
    
    
}
