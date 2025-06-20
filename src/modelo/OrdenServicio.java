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

}
