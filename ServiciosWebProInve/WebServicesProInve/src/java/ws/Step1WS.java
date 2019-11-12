/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Mensaje;
import pojos.Step1;

/**
 * REST Web Service
 *
 * @author Jahir
 */
@Path("steps")
public class Step1WS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Step1Resource
     */
    public Step1WS() {
    }

    
    @POST
    @Path("step1")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarDatosInversionista(
        @FormParam("step1") String step1){
        Gson gson = new Gson();
        Mensaje mensajeResultado = new Mensaje();
        Step1 inversionista = gson.fromJson(step1, Step1.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step1.guardarStep1", inversionista);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente");
        }catch(Exception ex){
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }        
        return mensajeResultado;
    }        
}
