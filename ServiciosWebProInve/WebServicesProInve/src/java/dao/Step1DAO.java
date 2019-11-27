/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Mensaje;
import pojos.Step1;

/**
 *
 * @author Jahir
 */
public class Step1DAO {
    public static Mensaje guardarStep1(Step1 step1){
        Mensaje mensajeResultado = new Mensaje();
        SqlSession conn = null;
        try {
            conn = MyBatisUtil.getSession();
            conn.insert("Step1.proAlmGuardarStep1", step1);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente step uno");            
        } catch (Exception ex) {
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }
        return mensajeResultado;
    }
}
