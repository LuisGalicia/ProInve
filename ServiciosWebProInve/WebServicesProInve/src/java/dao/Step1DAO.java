/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.CodigoPostal;
import pojos.ComparaCodigo;
import pojos.IdRecuperados;
import pojos.Mensaje;
import pojos.Step1;
import pojos.VerificacionTelefono;

/**
 *
 * @author Jahir
 */
public class Step1DAO {
    public static List<IdRecuperados> guardarStep1(Step1 step1){
        List<IdRecuperados> idRecuperado = null;
        SqlSession conn = null; 
        VerificacionTelefono ver = new VerificacionTelefono();
        int codVer = ver.verificaNumero(step1.getTelefono());
        step1.setCodigo_verificacion(codVer);
        System.out.println("el código de verificación es: " + codVer);
        try {
            conn = MyBatisUtil.getSession();
            conn.insert("Step1.guardarStep1", step1);
            conn.commit();
            idRecuperado = conn.selectList("Step1.getLastSelectStep1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            conn.close();
        }
        return idRecuperado;
    }
    
    public static List<IdRecuperados> validacionCodigo(ComparaCodigo compara) {
        List<ComparaCodigo> listaRecuperado = new ArrayList<>();
        List<IdRecuperados> idRecu = new ArrayList<>();
        IdRecuperados devuelto = new IdRecuperados();
        SqlSession conn = MyBatisUtil.getSession();
        devuelto.setId_recuperado(0); 
        if(conn != null) {
            try {
                listaRecuperado = conn.selectList("Step1.getValidaCodigoTelefono", compara.getId_step());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        System.out.println("Codigo: " + listaRecuperado.get(0).getCodigo() + ", codigo comparado: " + compara.getCodigo());
        if (listaRecuperado.get(0).getCodigo() == compara.getCodigo()) {
            System.out.println("entró a if de validación");
            devuelto.setId_recuperado(1);
        }
        idRecu.add(devuelto);
        return idRecu;   
    }
}
