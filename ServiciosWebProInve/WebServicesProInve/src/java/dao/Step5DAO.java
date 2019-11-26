/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Mensaje;
import pojos.Step5;
/**
 *
 * @author Jahir
 */
public class Step5DAO {
    public static Mensaje guardarStep5(Step5 step5){
        Mensaje mensajeResultado = new Mensaje();
        SqlSession conn = null;
        try {
            conn = MyBatisUtil.getSession();
            conn.insert("Step5.proAlmGuardarStep5", step5);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente step cinco");            
        } catch (Exception ex) {
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }
        return mensajeResultado;
    }
}
