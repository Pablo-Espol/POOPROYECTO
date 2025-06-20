package modelo;

import java.util.*;


public class HistorialPrecios {
    private Date fechaCambio;
    private double precioAntiguo,precioNuevo;
    private ArrayList<HistorialPrecios> listHistorialPrecios;       //declarada de momento

    public HistorialPrecios() {
    }

    public HistorialPrecios(Date fechaCambio, double precioAntiguo, double precioNuevo) {
        this.fechaCambio = fechaCambio;
        this.precioAntiguo = precioAntiguo;
        this.precioNuevo = precioNuevo;
    }

    public Date getFechaCambio() {
        return this.fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public double getPrecioAntiguo() {
        return this.precioAntiguo;
    }

    public void setPrecioAntiguo(double precioAntiguo) {
        this.precioAntiguo = precioAntiguo;
    }

    public double getPrecioNuevo() {
        return this.precioNuevo;
    }

    public void setPrecioNuevo(double precioNuevo) {
        this.precioNuevo = precioNuevo;
    }


    @Override
    public String toString() {
        return "{" +
            " fechaCambio='" + getFechaCambio() + "'" +
            ", precioAntiguo='" + getPrecioAntiguo() + "'" +
            ", precioNuevo='" + getPrecioNuevo() + "'" +
            "}";
    }
    
   
}

