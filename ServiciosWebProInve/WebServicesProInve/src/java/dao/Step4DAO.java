/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Mensaje;
import pojos.Step4;

/**
 *
 * @author Jahir
 */
public class Step4DAO {
    public static Mensaje guardarStep4(Step4 step4){
        Mensaje mensajeResultado = new Mensaje();
        SqlSession conn = null;
        try {
            conn = MyBatisUtil.getSession();
            conn.insert("Step4.proAlmGuardarStep4", step4);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente step cuatro");            
        } catch (Exception ex) {
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }
        return mensajeResultado;
    }
}
