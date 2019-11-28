/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.CodigoPostalDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pojos.CodigoPostal;

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
