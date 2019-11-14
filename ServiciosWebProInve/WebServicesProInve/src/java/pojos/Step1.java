/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Date;

/**
 *
 * @author Jahir
 */
public class Step1 {
    String nombre;
    String apellido_paterno;
    String apellido_materno;
    String rfc;
    Date fecha_nacimiento;
    String profesion;
    String nombre_empresa;
    String correo;
    String telefono;
    Integer codigo_verificacion;
    Boolean estado_codigo;
    byte[] firma;
    
    public Step1(){        
    }

    public Step1(String nombre, String apellido_paterno, String apellido_materno,
            String rfc, Date fecha_nacimiento, String profesion, 
            String nombre_empresa, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido_materno = apellido_materno;
        this.rfc = rfc;
        this.fecha_nacimiento = fecha_nacimiento;
        this.profesion = profesion;
        this.nombre_empresa = nombre_empresa;
        this.correo = correo;
        this.telefono = telefono;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getCodigo_verificacion() {
        return codigo_verificacion;
    }

    public void setCodigo_verificacion(Integer codigo_verificacion) {
        this.codigo_verificacion = codigo_verificacion;
    }

    public Boolean getEstado_codigo() {
        return estado_codigo;
    }

    public void setEstado_codigo(Boolean estado_codigo) {
        this.estado_codigo = estado_codigo;
    }

    public byte[] getFirma() {
        return firma;
    }

    public void setFirma(byte[] firma) {
        this.firma = firma;
    }
        
}
