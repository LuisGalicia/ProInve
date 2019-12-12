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
public class ComparaCodigo {
    int Id_Step1;
    int Codigo_Verificacion;

    public ComparaCodigo(int id_step, int codigo) {
        this.Id_Step1 = id_step;
        this.Codigo_Verificacion = codigo;
    }

    public ComparaCodigo() {
        
    }
    
    public int getId_step() {
        return Id_Step1;
    }

    public void setId_step(int id_step) {
        this.Id_Step1 = id_step;
    }

    public int getCodigo() {
        return Codigo_Verificacion;
    }

    public void setCodigo(int codigo) {
        this.Codigo_Verificacion = codigo;
    }
    
    
}
