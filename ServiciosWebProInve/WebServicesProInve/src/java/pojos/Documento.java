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
public class Documento {
    Integer id_documento;
    Integer id_inversionista;
    byte[] documento;
    
    public Documento(){        
    }

    public Integer getId_documento() {
        return id_documento;
    }

    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
    }

    public Integer getId_inversionista() {
        return id_inversionista;
    }

    public void setId_inversionista(Integer id_inversionista) {
        this.id_inversionista = id_inversionista;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }        
}
