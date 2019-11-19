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
    Integer id_codigo_verificacion;    
    byte[] firma;
    Integer id_step1;
    Integer id_step0;
    
    public Step1(){        
    }

    public Step1(String nombre, String apellido_paterno, String apellido_materno, String rfc, Date fecha_nacimiento, String profesion, String nombre_empresa, String correo, String telefono, Integer id_codigo_verificacion, byte[] firma, Integer id_step1, Integer id_step0) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.rfc = rfc;
        this.fecha_nacimiento = fecha_nacimiento;
        this.profesion = profesion;
        this.nombre_empresa = nombre_empresa;
        this.correo = correo;
        this.telefono = telefono;
        this.id_codigo_verificacion = id_codigo_verificacion;
        this.firma = firma;
        this.id_step1 = id_step1;
        this.id_step0 = id_step0;
    }        

    public Step1(String nombre, String apellido_paterno, String apellido_materno, String rfc, Date fecha_nacimiento, String profesion, String nombre_empresa, String correo, String telefono, Integer id_step1) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.rfc = rfc;
        this.fecha_nacimiento = fecha_nacimiento;
        this.profesion = profesion;
        this.nombre_empresa = nombre_empresa;
        this.correo = correo;
        this.telefono = telefono;
        this.id_step1 = id_step1;
    }        

    public Integer getId_codigo_verificacion() {
        return id_codigo_verificacion;
    }

    public void setId_codigo_verificacion(Integer id_codigo_verificacion) {
        this.id_codigo_verificacion = id_codigo_verificacion;
    }

    public Integer getId_step1() {
        return id_step1;
    }

    public void setId_step1(Integer id_step1) {
        this.id_step1 = id_step1;
    }

    public Integer getId_step0() {
        return id_step0;
    }

    public void setId_step0(Integer id_step0) {
        this.id_step0 = id_step0;
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
    
    public byte[] getFirma() {
        return firma;
    }

    public void setFirma(byte[] firma) {
        this.firma = firma;
    }
        
}
