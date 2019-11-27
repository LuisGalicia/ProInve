/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Mensaje;
import pojos.Step3;
/**
 *
 * @author Jahir
 */
public class Step3DAO {
    public static Mensaje guardarStep3(Step3 step3){
        Mensaje mensajeResultado = new Mensaje();
        SqlSession conn = null;
        try {
            conn = MyBatisUtil.getSession();
            conn.insert("Step3.proAlmGuardarStep3", step3);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente step tres");            
        } catch (Exception ex) {
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }
        return mensajeResultado;
    }
}
