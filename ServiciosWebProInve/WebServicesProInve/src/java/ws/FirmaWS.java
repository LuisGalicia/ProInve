/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import pojos.Mensaje;
import org.glassfish.jersey.media.multipart.FormDataParam;
/**
 * REST Web Service
 *
 * @author Frost
 */
@Path("firma")
public class FirmaWS {
    
    private final String PATH = "C:/tmp_fotos/";

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FirmaWS
     */
    public FirmaWS() {
    }

    @POST
    @Path("/guardar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Mensaje uploadFirma(
            @FormDataParam("id") Integer id,
            @FormDataParam("signature") InputStream signature) {

        Mensaje res = new Mensaje();
        if(id==null){
            res.setError(true);
            res.setMensaje("El id de la firma no puede estar vacio");
            return res;
        }
        if (signature == null) {
            res.setError(true);
            res.setMensaje("La firma no puede estar vacia");
            return res;
        }
        byte[] bytes = null;
        try {
            bytes = toByteArray(signature);
            String filename = String.format("%s_%s_firma.png",id,new Date().getTime());
            String filepath = PATH + "/" + filename;
            if(guardarFirma(filepath, bytes)){
                res.setError(false);
                res.setMensaje("Firma guardada correctamente...");
            }else{
                res.setError(true);
                res.setMensaje("No se puede guardar la firma...");
            }
        } catch (Exception se) {
            res.setError(true);
            res.setMensaje("No se puede guardar la firma...");
        }
        return res;
    }
    
    private byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        // read bytes from the input stream and store them in buffer
        while ((len = in.read(buffer)) != -1) {
                // write bytes from the buffer into output stream
                os.write(buffer, 0, len);
        }
        return os.toByteArray();
    }
    
    private boolean guardarFirma(String firmafullpath, byte[] bytes){
        InputStream in = new ByteArrayInputStream(bytes);
        try {
            BufferedImage buffImage = ImageIO.read(in);
            ImageIO.write(buffImage, "png", new File(firmafullpath));
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }
}
