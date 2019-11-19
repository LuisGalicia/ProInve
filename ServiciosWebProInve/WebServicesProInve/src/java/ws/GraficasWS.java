/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import entidades.Simulacion;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Mensaje;
import pojos.Step0;

/**
 * REST Web Service
 *
 * @author Jahir
 */
@Path("graficas")
public class GraficasWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GraficasWS
     */
    public GraficasWS() {
    }

    @POST
    @Path("simulacion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Simulacion> guardarDatos(
        @FormParam("datosRecuperados") String datosRecuperados){        
        Gson gson = new Gson();
        Simulacion simulacion = gson.fromJson(datosRecuperados, Simulacion.class);
        int importe = simulacion.getImporte();
        int plazo = simulacion.getPlazo();
        float valorInversion = valorInversion(simulacion.getTipoinversion());
        List<Simulacion> listaSimulados = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Simulacion simulado = new Simulacion();
            float value;
            
            if(plazo == i) {
                simulado.setSeleccion("Plazo Seleccionado");
            } else {
                simulado.setSeleccion("Otros Plazos");
            }
            if(i == 1) {
               value = (importe*valorInversion) + importe; 
               simulado.setValue(value);
            } else {
                value = listaSimulados.get(i-2).getValue();
                simulado.setValue((value*valorInversion) + value);
            }
            simulado.setPlazo(plazo);
            listaSimulados.add(simulado);  
        }
        return listaSimulados;
    }
    
    public float valorInversion(String tipoInversion){        
        switch(tipoInversion){            
            case "yisus":
                return (float) 0.105;
            case "wacha":
                return (float) 0.65;
            default:
                return 0;
        }    
    }
}
