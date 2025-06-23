package controlador;

import java.util.*;
import modelo.*;

public class ControlTecno {
    private ArrayList<Cliente> client;
    private ArrayList<Tecnico> tecni;
    private ArrayList<Proveedor> suplier;
    private ArrayList<Servicio> service;
    private ArrayList<OrdenServicio> orden;

    public ControlTecno() {
        client=new ArrayList<>();
        tecni= new ArrayList<>();
        suplier= new ArrayList<>();
        service= new ArrayList<>();
        orden= new ArrayList<>();

    
        
    }

    //Creación metodo inicializarApp()

    public void inicializarApp(){
        //Inicializa con los  clientes
        client.add(new Cliente("0988514745", "Pablo Zambrano", "0998997700", "Guasmo", TipoCliente.PERSONAL));
        client.add(new Cliente("0947254193", "Jose Molina", "0909852147", "Luis Urdeneta y Cordova", TipoCliente.PERSONAL));
        client.add(new Cliente("0900224455", "Pedro Alvarado", "0999910741", "9 de Octubre y Boyaca", TipoCliente.EMPRESARIAL));
        client.add(new Cliente("0999007845", "Miguel Rodriguez", "0910203040", "Rumichaca y Aguirre", TipoCliente.EMPRESARIAL));

        //Inicializa con los  clientes
        tecni.add(new Tecnico("0987654321", "Carlos Perez", "0998765432", "Mecanica"));
        tecni.add(new Tecnico("0987654322", "Ana Gomez", "0998765433", "Electronica"));
        

         //Inicializa con los  prveedores
        suplier.add(new Proveedor("0987654323", "Proveedor A", "0998765434", "Suministros de herramientas"));
        suplier.add(new Proveedor("0987654324", "Proveedor B", "0998765435", "Repuestos de computadoras"));

        //Inicializa con los servicios
        service.add(new Servicio("001", "Reparación de motores", 90.0));
        service.add(new Servicio("002", "Instalación de software", 80.0));
        service.add(new Servicio("003", "Mantenimiento preventivo", 40.0));
        service.add(new Servicio("004", "Balanceo y alineación", 70.0));
        service.add(new Servicio("005", "Cambio de neumaticos", 60.0));     
        service.add(new Servicio("006", "Cambio de aceite", 30.0));

        //Inicializa con las ordenes de servicio// dd-mm-yyyy

    }


    
}
