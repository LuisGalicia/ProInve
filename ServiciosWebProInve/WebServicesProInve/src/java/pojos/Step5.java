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
public class Step5 {
    Integer id_documento;
    Integer id_step1;
    String documento;
    
    public Step5(){        
    }

    public Step5(Integer id_documento, Integer id_step1, String documento) {
        this.id_documento = id_documento;
        this.id_step1 = id_step1;
        this.documento = documento;
    }

    
    public Integer getId_documento() {
        return id_documento;
    }

    public void setId_documento(Integer id_documento) {
        this.id_documento = id_documento;
    }

    public Integer getId_step1() {
        return id_step1;
    }

    public void setId_step1(Integer id_step1) {
        this.id_step1 = id_step1;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
        
}
