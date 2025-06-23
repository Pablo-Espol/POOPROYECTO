package controlador;

import java.util.*;
import modelo.*;

public class ControlTecno {
    private ArrayList<Cliente> listClient;
    private ArrayList<Tecnico> listTecni;
    private ArrayList<Proveedor> listSuplier;
    private ArrayList<Servicio> listService;
    private ArrayList<OrdenServicio> listOrden;
    Scanner sc =new Scanner(System.in);

    public ControlTecno() {
        listClient=new ArrayList<>();
        listTecni= new ArrayList<>();
        listSuplier= new ArrayList<>();
        listService= new ArrayList<>();
        listOrden= new ArrayList<>();    
    }
    public ArrayList<Cliente> getListClient() {
        return listClient;
    }

    public void setListClient(ArrayList<Cliente> listClient) {
        this.listClient = listClient;
    }
    public ArrayList<Tecnico> getListTecni() {
        return listTecni;
    } 
    public void setListTecni(ArrayList<Tecnico> listTecni) {
        this.listTecni = listTecni;
    }

    public ArrayList<Proveedor> getListSuplier() {
        return listSuplier;
    }
    public void setListSuplier(ArrayList<Proveedor> listSuplier) {
        this.listSuplier = listSuplier;
    }
    public ArrayList<Servicio> getListService() {
        return listService;
    }
    public void setListService(ArrayList<Servicio> listService) {
        this.listService = listService;
    }
    public ArrayList<OrdenServicio> getListOrden() {
        return listOrden;
    }
    public void setListOrden(ArrayList<OrdenServicio> listOrden) {
        this.listOrden = listOrden;
    }
       //Creación metodo inicializarApp()


    public void inicializarApp(){
        //Inicializa con los  clientes
        listClient.add(new Cliente("0988514745", "Pablo Zambrano", "0998997700", "Guasmo", TipoCliente.PERSONAL));
        listClient.add(new Cliente("0947254193", "Jose Molina", "0909852147", "Luis Urdeneta y Cordova", TipoCliente.PERSONAL));
        listClient.add(new Cliente("0900224455", "Pedro Alvarado", "0999910741", "9 de Octubre y Boyaca", TipoCliente.EMPRESARIAL));
        listClient.add(new Cliente("0999007845", "Miguel Rodriguez", "0910203040", "Rumichaca y Aguirre", TipoCliente.EMPRESARIAL));

        //Inicializa con los  tecnicos
        listTecni.add(new Tecnico("0987654321", "Carlos Perez", "0998765432", "Mecanica"));
        listTecni.add(new Tecnico("0987654322", "Ana Gomez", "0998765433", "Electronica"));
        

         //Inicializa con los  proveedores
        listSuplier.add(new Proveedor("0987654323", "Proveedor A", "0998765434", "Suministros de herramientas"));
        listSuplier.add(new Proveedor("0987654324", "Proveedor B", "0998765435", "Repuestos de computadoras"));

        //Inicializa con los servicios
        listService.add(new Servicio("001", "Reparación de motores", 90.0));
        listService.add(new Servicio("002", "Instalación de software", 80.0));
        listService.add(new Servicio("003", "Mantenimiento preventivo", 40.0));
        listService.add(new Servicio("004", "Balanceo y alineación", 70.0));
        listService.add(new Servicio("005", "Cambio de neumaticos", 60.0));     
        listService.add(new Servicio("006", "Cambio de aceite", 30.0));

        //Inicializa con las ordenes de servicio// dd-mm-yyyy

    

    }


    
    



    //Metodos para administrar clientes
     public  Cliente agregarCliente(String identificacion,String nombre,String telefono,String direccion,TipoCliente tipoCliente){
        for (Cliente cliente: listClient){
            if(cliente.getIdentificacion().equals(identificacion)){    
                return cliente;// retorna esto y sale el metodo
            }
        }
        listClient.add(new Cliente(identificacion,nombre, telefono,direccion,tipoCliente));
        return null;//todo bien no necesito enviar algún mensaje
        
}

    //Metodos para administrar proveedores 

    public Proveedor agregarProveedor(String identificacion,String nombre,String telefono,String direccion){
        for (Proveedor proveedor: listSuplier){
            if(proveedor.getIdentificacion().equals(identificacion)){    
                return proveedor;// retorna esto y sale el metodo
            }
        }
        listSuplier.add(new Proveedor(identificacion,nombre, telefono,direccion));
        return null;//todo bien no necesito enviar algún mensaje
        
        
    }

    //Metodos para administrar tecnicos
    public Tecnico agregartTecnico(String identificacion,String nombre, String telefono){
        for (Tecnico tecnico:listTecni){
            if (tecnico.getIdentificacion().equals(identificacion)){
                return tecnico; // retorna esto y sale el metodo
            }
        }
        listTecni.add(new Tecnico(identificacion, nombre, telefono));
        return null;
    }

    //Metodos para administrar servicios
    //Agregar
    public Servicio agregarServicio(String nombre, double precio){
        Servicio ultimo = listService.get(listService.size()-1);
        String code= ultimo.getCodigo();
        int coidgo= Integer.parseInt(code);
        int nuevoCodigo = coidgo + 1;
        String codeLista= String.format("%03d", nuevoCodigo);
        Servicio nuevoServicio= new Servicio( codeLista, nombre, precio);
        listService.add(nuevoServicio);
        return null;

    }

    public Servicio editarServicio(String codigo){
        


    }

}
    
