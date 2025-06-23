package modelo;

import java.util.*;


public class OrdenServicio {
    private Cliente cliente;
    private Tecnico tecnico;
    private Date fechaServicio;
    private String placaVehiculo;
    private double totalOrden;


    public OrdenServicio(){}


    public OrdenServicio(Cliente cliente, Tecnico tecnico, Date fechaServicio, String placaVehiculo, double totalOrden) {
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.fechaServicio = fechaServicio;
        this.placaVehiculo = placaVehiculo;
        this.totalOrden = totalOrden;
    }


    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return this.tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Date getFechaServicio() {
        return this.fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getPlacaVehiculo() {
        return this.placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public double getTotalOrden() {
        return this.totalOrden;
    }

    public void setTotalOrden(double totalOrden) {
        this.totalOrden = totalOrden;
    }



    @Override
    public String toString() {
        return "{" +
            " cliente='" + getCliente() + "'" +
            ", tecnico='" + getTecnico() + "'" +
            ", fechaServicio='" + getFechaServicio() + "'" +
            ", placaVehiculo='" + getPlacaVehiculo() + "'" +
            ", totalOrden='" + getTotalOrden() + "'" +
            "}";
    }


}
