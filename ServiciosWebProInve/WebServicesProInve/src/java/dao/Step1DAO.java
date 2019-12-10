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
import pojos.Step1;

/**
 *
 * @author Jahir
 */
public class Step1DAO {
    public static List<IdRecuperados> guardarStep1(Step1 step1){
        List<IdRecuperados> idRecuperado = null;
        SqlSession conn = null;
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
}
