/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.CodigoPostal;
import pojos.Simulacion;
import pojos.TipoInversion;

/**
 *
 * @author lugad
 */
public class GraficaDAO {
    public static List<Simulacion> guardarDatos(Integer plazo,Integer importe,
            String tipo){        
        List<Simulacion> listaSimulados = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Simulacion simulado = new Simulacion();
            float value;
            float tasaRetorno = tasaInversion(tipo);
            
            if(plazo == i) {
                simulado.setSeleccion("Plazo Seleccionado");
            } else {
                simulado.setSeleccion("Otros Plazos");
            }
            if(i == 1) {
               value = (importe*tasaRetorno) + importe; 
               simulado.setValue(value);
            } else {
                value = listaSimulados.get(i-2).getValue();
                simulado.setValue((value*tasaRetorno) + value);
            }
            simulado.setPlazo(i);
            listaSimulados.add(simulado);  
        }
        return listaSimulados;
    }
    
    public static float tasaInversion(String tipoInversion) {
        TipoInversion devuelto = new TipoInversion();
        SqlSession conn = MyBatisUtil.getSession();
        
        if(conn != null) {
            try {
                devuelto = conn.selectOne("graficas.getTasaRetornoByTipoInversion");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return devuelto.getTasa_retorno();
    }
    
    public static List<TipoInversion> getAllTiposInversion() {
        List<TipoInversion> listaTiposInv = null;
        SqlSession conn = MyBatisUtil.getSession();
        
        if(conn != null) {
            try {
                listaTiposInv = conn.selectList("graficas.getAllTiposInv");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        return listaTiposInv;
    }
}
