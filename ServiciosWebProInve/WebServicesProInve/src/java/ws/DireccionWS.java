/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.CodigoPostalDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pojos.CodigoPostal;
import pojos.Mensaje;

/**
 * REST Web Service
 *
 * @author lugad
 */
@Path("direcciones")
public class DireccionWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DireccionWS
     */
    public DireccionWS() {
    }
        
    @POST
    @Path("recuperarColonias")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje recuperarColonias(
        @FormParam("datosRecuperados") String datosRecuperados){        
        Gson gson = new Gson();        
        CodigoPostal codigoPostal = gson.fromJson(datosRecuperados, CodigoPostal.class);        
        Mensaje mensaje = CodigoPostalDAO.buscarColonias(codigoPostal);   
        return mensaje;
    }
    
    @GET
    @Path("getallcp")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CodigoPostal> getAllCP() {
        return CodigoPostalDAO.getAllCodigosPostales();
    }
    
    @GET
    @Path("getcpBycp/{codigoPostal}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CodigoPostal> getCodigosPostalesByCodigoPostal(
    @PathParam("codigoPostal") Integer codigoPostal) {
        return CodigoPostalDAO.getCodigoPostalByCodigoPostal(codigoPostal);
    }    
    
}
