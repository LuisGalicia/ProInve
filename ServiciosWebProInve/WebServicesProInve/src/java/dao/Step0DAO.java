/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.IdRecuperados;
import pojos.Mensaje;
import pojos.Step0;

/**
 *
 * @author Jahir
 */
public class Step0DAO {    
    public static List<IdRecuperados> guardarStep0(Step0 step0){
        List<IdRecuperados> idRecuperado = null;
        SqlSession conn = null;
        try {
            conn = MyBatisUtil.getSession();
            conn.insert("Step0.proAlmGuardarStep0", step0);
            conn.commit();
            idRecuperado = conn.selectList("Step0.getLastSelect");
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            conn.close();
        }
        return idRecuperado;
    }    
}
