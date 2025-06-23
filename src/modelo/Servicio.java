
package modelo;
import java.util.*;

/**
 *
 * @author Fmalu
 */
public class Servicio {
    
    private String codigo,nombre;
    private double precio;
    private ArrayList<HistorialPrecios> listHistorialPrecios=new ArrayList<>();


    public Servicio() {
    }
    

    public Servicio(String codigo, String nombre, double precio, ArrayList<HistorialPrecios> listHistorialPrecios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.listHistorialPrecios = listHistorialPrecios;
    }


    public Servicio(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

  

    @Override
    public String toString() {
        return "{" +
            " codigo='" + getCodigo() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }
    

}
  
