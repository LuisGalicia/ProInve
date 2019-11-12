
package pojos;

/**
 * Esta clase se encarga de mostrar un mensaje en caso de un error.
 * @author Eduardo Rosas Rivera y Jahir Landa Valdivieso
 */
public class Mensaje {
    private boolean error;
    private String mensaje;

    public Mensaje(boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    public Mensaje() {}
    
    /**
     * @return the error
     */
    public boolean isError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
