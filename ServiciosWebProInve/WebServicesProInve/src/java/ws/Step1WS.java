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
        @FormParam("nombre") String nombre,
        @FormParam ("apellido_paterno") String apellido_paterno,
        @FormParam ("apellido_materno") String apellido_materno,
        @FormParam ("rfc") String rfc,
        @FormParam ("fecha_nacimiento") Date fecha_nacimiento,
        @FormParam ("profesion") String profesion,
        @FormParam ("nombre_empresa") String nombre_empresa,
        @FormParam ("correo") String correo,
        @FormParam ("telefono") String telefono){
        Gson gson = new Gson();
        Step1 stepOrigen = new Step1(nombre, apellido_paterno, apellido_materno, rfc,
        fecha_nacimiento, profesion, nombre_empresa, correo, telefono);
        Mensaje mensajeResultado = new Mensaje();
        //Step1 inversionista = gson.fromJson(stepOrigen, Step1.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step1.guardarStep1", stepOrigen);
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
        @FormParam("id_direccion") Integer id_direccion,
        @FormParam ("calle") String calle,
        @FormParam ("numero") Integer numero,
        @FormParam ("id_codigo_postal") Integer id_codigo_postal,
        @FormParam ("id_step1") Integer id_step1
    ){
        //aquí no me pidió la misma excepción que en el método guardarDatosInversionista
        Gson gson = new Gson();
        Step3 stepOrigen = new Step3(id_direccion, calle, numero, 
                id_codigo_postal, id_step1);
        Mensaje mensajeResultado = new Mensaje();
        //Step1 inversionista = gson.fromJson(stepOrigen, Step1.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step3.guardarStep3", stepOrigen);
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
        @FormParam("id_cuenta") Integer id_cuenta,
        @FormParam ("clabe") Integer clabe,
        @FormParam ("no_cuenta") Integer no_cuenta,
        @FormParam ("id_step1") Integer id_step1,
        @FormParam ("id_banco") Integer id_banco,
        @FormParam ("id_origen_inversion") Integer id_origen_inversion,
        @FormParam ("id_tipo_inversion") Integer id_tipo_inversion,
        @FormParam ("monto_inversion") Integer monto_inversion,
        @FormParam ("plazo_inversion") Integer plazo_inversion){
        Gson gson = new Gson();
        Step4 stepOrigen = new Step4(id_cuenta, clabe, no_cuenta, id_step1, id_banco, 
                id_origen_inversion, id_tipo_inversion, monto_inversion, plazo_inversion);
        Mensaje mensajeResultado = new Mensaje();
        //Step1 inversionista = gson.fromJson(stepOrigen, Step1.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step4.guardarStep4", stepOrigen);
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
        @FormParam("id_documento") Integer id_documento,
        @FormParam ("id_step1") Integer id_step1,
        @FormParam ("documento") String documento
    ){
        //aquí no me pidió la misma excepción que en el método guardarDatosInversionista
        Gson gson = new Gson();
        Step5 stepOrigen = new Step5(id_documento, id_step1, documento);
        Mensaje mensajeResultado = new Mensaje();
        //Step1 inversionista = gson.fromJson(stepOrigen, Step1.class);
        
        SqlSession conn = MyBatisUtil.getSession();
        try{
            conn.insert("Step5.guardarStep5", stepOrigen);
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
