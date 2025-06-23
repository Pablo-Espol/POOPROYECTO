
package modelo;
import java.util.*;
/**
 *
 * @author Fmalu
 */
public class Insumo {
    
    private String descripcion;
    private Date fechaRegistro;


    public Insumo() {
    }


    public Insumo(String descripcion, Date fechaRegistro) {
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }



    @Override
    public String toString() {
        return "{" +
            " descripcion='" + getDescripcion() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            "}";
    }

}
