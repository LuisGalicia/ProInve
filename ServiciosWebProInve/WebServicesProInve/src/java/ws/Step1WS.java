/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.Step0DAO;
import dao.Step1DAO;
import dao.Step3DAO;
import dao.Step4DAO;
import dao.Step5DAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import pojos.Mensaje;
import pojos.Step0;
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
    @Path("step0")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarDatos(
        @FormParam("datosRecuperados") String datosRecuperados){        
        Gson gson = new Gson();        
        Step0 step0 = gson.fromJson(datosRecuperados, Step0.class);        
        Mensaje mensajeResultado = Step0DAO.guardarStep0(step0);       
        return mensajeResultado;
    }
    
    @POST
    @Path("step1")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarDatosInversionista(
        @FormParam("datosRecuperados") String datosRecuperados){
        Gson gson = new Gson();        
        Step1 step1 = gson.fromJson(datosRecuperados, Step1.class);        
        Mensaje mensajeResultado = Step1DAO.guardarStep1(step1);               
        return mensajeResultado;
    }     
    
    @POST
    @Path("step3")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarDatosDireccion(
        @FormParam("datosRecuperados") String datosRecuperados){
        Gson gson = new Gson();        
        Step3 step3 = gson.fromJson(datosRecuperados, Step3.class);        
        Mensaje mensajeResultado = Step3DAO.guardarStep3(step3);               
        return mensajeResultado;
    }
    
    @POST
    @Path("step4")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarDatosFinancieros(
        @FormParam("datosRecuperados") String datosRecuperados){
        Gson gson = new Gson();        
        Step4 step4 = gson.fromJson(datosRecuperados, Step4.class);        
        Mensaje mensajeResultado = Step4DAO.guardarStep4(step4);               
        return mensajeResultado;
    }
    
    @POST
    @Path("step5")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje guardarComprobantes(
        @FormParam("datosRecuperados") String datosRecuperados){
        Gson gson = new Gson();        
        Step5 step5 = gson.fromJson(datosRecuperados, Step5.class);        
        Mensaje mensajeResultado = Step5DAO.guardarStep5(step5);               
        return mensajeResultado;
    }
}
