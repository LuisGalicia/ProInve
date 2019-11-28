/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import pojos.CodigoPostal;

/**
 *
 * @author lugad
 */
public class CodigoPostalDAO {
    public static List<CodigoPostal> getAllCodigosPostales() {
        List<CodigoPostal> listaCP = null;
        SqlSession conn = MyBatisUtil.getSession();
        
        if(conn != null) {
            try {
                listaCP = conn.selectList("direccion.getAllCP");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return listaCP;
    }
    
    public static List<CodigoPostal> getCodigoPostalByCodigoPostal
         (int codigoPostal) {
        List<CodigoPostal> listaCP = null;
        SqlSession conn = MyBatisUtil.getSession();
        
        if(conn != null) {
            try {
                listaCP = conn.selectList("direccion.getCodigoPostalByCP", 
                        codigoPostal);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return listaCP;
    }
}
