
package pojos;

import java.util.List;

/**
 * Esta clase se encarga de mostrar un mensaje en caso de un error.
 * @author Eduardo Rosas Rivera y Jahir Landa Valdivieso
 */
public class Mensaje {
    private boolean error;
    private String mensaje;
    private List<CodigoPostal> codigoPostal;

    public Mensaje() {}
    
    public Mensaje(boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    public Mensaje(boolean error, String mensaje, List<CodigoPostal> codigoPostal) {
        this.error = error;
        this.mensaje = mensaje;
        this.codigoPostal = codigoPostal;
    }         
    
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<CodigoPostal> getListaObject() {
        return codigoPostal;
    }

    public void setListaObject(List<CodigoPostal> listaObject) {
        this.codigoPostal = listaObject;
    }              
}
