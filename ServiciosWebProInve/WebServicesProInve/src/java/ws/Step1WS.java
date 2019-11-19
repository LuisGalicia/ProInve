/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import java.util.Date;
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
import pojos.Step3;
import pojos.Step4;
import pojos.Step5;

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
        @FormParam("datosRecuperados") String datosRecuperados){
        Gson gson = new Gson();
        Mensaje mensajeResultado = new Mensaje();
        Step1 inversionista = gson.fromJson(datosRecuperados, Step1.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step1.guardarStep1", inversionista);
            //conn.insert("Step1.proAlmGuardarStep1", inversionista);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente Step 1");
        }catch(Exception ex){
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }        
        return mensajeResultado;
    }     
    
    @POST
    @Path("step3")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarDatosDireccion(
        @FormParam("datosRecuperados") String datosRecuperados){
        //aquí no me pidió la misma excepción que en el método guardarDatosInversionista
        Gson gson = new Gson();
        Mensaje mensajeResultado = new Mensaje();
        Step3 direccion = gson.fromJson(datosRecuperados, Step3.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step3.guardarStep3", direccion);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente Step 3");
        }catch(Exception ex){
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }        
        return mensajeResultado;
    }
    
    @POST
    @Path("step4")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarDatosFinancieros(
        @FormParam("datosRecuperados") String datosRecuperados){
        Gson gson = new Gson();
        Mensaje mensajeResultado = new Mensaje();
        Step4 inversion = gson.fromJson(datosRecuperados, Step4.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step4.guardarStep4", inversion);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente Step 4");
        }catch(Exception ex){
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }        
        return mensajeResultado;
    }
    
    @POST
    @Path("step5")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarComprobantes(
        @FormParam("datosRecuperados") String datosRecuperados){
        //aquí no me pidió la misma excepción que en el método guardarDatosInversionista
        Gson gson = new Gson();
        Mensaje mensajeResultado = new Mensaje();
        Step5 documento = gson.fromJson(datosRecuperados, Step5.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step5.guardarStep5", documento);
            conn.commit();
            mensajeResultado = new Mensaje(false, "Datos registrados correctamente Step 5");
        }catch(Exception ex){
            mensajeResultado = new Mensaje(true, ex.getMessage());
        }finally{
            conn.close();
        }        
        return mensajeResultado;
    }
}
