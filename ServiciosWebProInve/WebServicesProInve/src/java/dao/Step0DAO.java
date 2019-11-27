/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Mensaje;
import pojos.Step0;

/**
 *
 * @author Jahir
 */
public class Step0DAO {    
    public static Mensaje guardarStep0(Step0 step0){
        Mensaje mensajeResultado = new Mensaje();
        SqlSession conn = null;
        try {
            conn = MyBatisUtil.getSession();
            conn.insert("Step0.proAlmGuardarStep0", step0);
            conn.commit();
            mensajeResultado = new Mensaje
                (false, "Datos registrados correctamente step cero like");            
        } catch (Exception ex) {
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }
        return mensajeResultado;
    }    
}
