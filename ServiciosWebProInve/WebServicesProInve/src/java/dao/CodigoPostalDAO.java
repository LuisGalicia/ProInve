/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
import pojos.CodigoPostal;
import pojos.Mensaje;

/**
 *
 * @author lugad
 */
public class CodigoPostalDAO {
    
    public static Mensaje buscarColonias(CodigoPostal datosCodigoPostal){
        List<CodigoPostal> listaCodigoPostal = new ArrayList<>();        
        Mensaje mensaje = new Mensaje();
        SqlSession conn = null;
        try {
            conn = MyBatisUtil.getSession();
            listaCodigoPostal = conn.selectList("direccion.recuperarColonias", datosCodigoPostal);            
            if(listaCodigoPostal.isEmpty()){
                mensaje.setError(true);                                
                mensaje.setMensaje("Código postal no encontrado");
            }else{
                mensaje.setError(false);
                mensaje.setListaObject(listaCodigoPostal);
            }
        } catch (Exception ex) {            
            mensaje.setError(true);
            mensaje.setMensaje("Error de conexión con la base de datos");
            ex.printStackTrace();
        }finally{           
            conn.close();            
        }
        return mensaje;
    }
    
    
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
