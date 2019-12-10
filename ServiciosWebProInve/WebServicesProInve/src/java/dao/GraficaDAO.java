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
import pojos.Comparacion;
import pojos.Simulacion;
import pojos.TipoInversion;

/**
 *
 * @author lugad
 */
public class GraficaDAO {

    public static List<Simulacion> guardarDatos(Integer plazo, Integer importe,
            String tipo) {
        List<Simulacion> listaSimulados = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Simulacion simulado = new Simulacion();
            float value;
            float tasaRetorno = tasaInversion(tipo);

            if (plazo == i) {
                simulado.setSeleccion("Plazo Seleccionado");
            } else {
                simulado.setSeleccion("Otros Plazos");
            }
            if (i == 1) {
                value = (importe * tasaRetorno) + importe;
                simulado.setValue(value);
            } else {
                value = listaSimulados.get(i - 2).getValue();
                simulado.setValue((value * tasaRetorno) + value);
            }
            simulado.setPlazo(i);
            listaSimulados.add(simulado);
        }
        return listaSimulados;
    }

    public static float tasaInversion(String tipoInversion) {
        List<TipoInversion> listaTiposInv = null;
        SqlSession conn = MyBatisUtil.getSession();
        float tasa = 0;

        if (conn != null) {
            try {
                listaTiposInv = conn.selectList("graficas.getAllTiposInv");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
        for (int i = 0; i < listaTiposInv.size(); i++) {
            if(listaTiposInv.get(i).getTipo_inversion().equals(tipoInversion)) {
                tasa = listaTiposInv.get(i).getTasa_retorno();
                System.out.println("la tasa para " + listaTiposInv.get(i).getTipo_inversion() + " es: " + listaTiposInv.get(i).getTasa_retorno());
            }   
        }
        return tasa;
    }

    public static List<TipoInversion> getAllTiposInversion() {
        List<TipoInversion> listaTiposInv = null;
        SqlSession conn = MyBatisUtil.getSession();

        if (conn != null) {
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

    public static List<Simulacion> getValoresComparacion(Comparacion compara) {
        List<Simulacion> objetosComparados = new ArrayList<>();
        String[] tiposInversion = compara.getTiposInversion();

        System.out.println("el largo del arreglo es: " +compara.getTiposInversion().length);
        for (int i = 0; i < compara.getTiposInversion().length; i++) {
            System.out.println("entra a for con valores: " +
                    compara.getPlazo() + "--" +
                    tiposInversion[i] + "--" +
                    inversionDeRetorno(compara.getPlazo(), compara.getImporte(), tasaInversion(tiposInversion[i])) + "--");
           Simulacion inversion = new Simulacion(); 
           inversion.setPlazo(compara.getPlazo());
           inversion.setTipoinversion(tiposInversion[i]);
           //se envían los parámetros para retornar el valor de retorno
           inversion.setValue(inversionDeRetorno(compara.getPlazo(), compara.getImporte(), tasaInversion(tiposInversion[i])));
           objetosComparados.add(inversion);
            
        }
        System.out.println("Manda un mensaje antes");
        System.out.println("La inversión del primer objeto es: "+objetosComparados.get(0).getValue());
        System.out.println("Manda un mensaje después");
        return objetosComparados;
    }

    public static float inversionDeRetorno(int plazo, int importe, float tasaRetorno) {
        float inversion = 1;
        for (int i = 0; i < plazo; i++) {
            if (i == 0) {
                inversion = (importe * tasaRetorno) + importe;
            } else {
                inversion = (inversion * tasaRetorno) + inversion;
            }
        }
        return inversion;
    }
}
