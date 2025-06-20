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

        


    }


    
}
