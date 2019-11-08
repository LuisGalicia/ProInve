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
public class CodigoPostal {
    Integer id_codigo_postal;
    Integer id_municipio;
    Integer codigo_postal;
    String colonia; 

    public CodigoPostal() {
    }

    public Integer getId_codigo_postal() {
        return id_codigo_postal;
    }

    public void setId_codigo_postal(Integer id_codigo_postal) {
        this.id_codigo_postal = id_codigo_postal;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(Integer codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }        
}
