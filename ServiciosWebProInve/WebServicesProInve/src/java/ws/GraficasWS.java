/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.GraficaDAO;
import java.sql.DatabaseMetaData;
import pojos.Simulacion;
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
    public List<Simulacion> guardarDatos( @FormParam("plazo") Integer plazo,
            @FormParam("importe") Integer importe,
            @FormParam("tipoinversion") String tipo){        

        return GraficaDAO.guardarDatos(plazo, importe, tipo);
    }
    
}
