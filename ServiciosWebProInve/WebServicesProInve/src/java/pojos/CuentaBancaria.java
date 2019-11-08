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
public class CuentaBancaria {
    Integer id_cuenta;
    Integer id_inversionista;
    Integer id_banco;
    Integer clabe;
    Integer no_cuenta;
    
    public CuentaBancaria(){        
    }

    public Integer getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public Integer getId_inversionista() {
        return id_inversionista;
    }

    public void setId_inversionista(Integer id_inversionista) {
        this.id_inversionista = id_inversionista;
    }

    public Integer getId_banco() {
        return id_banco;
    }

    public void setId_banco(Integer id_banco) {
        this.id_banco = id_banco;
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
}
