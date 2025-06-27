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

        //Creando primero en detalles servicios para asignar los servicios a las ordenes de servicio ya que pide minimo 2 y 2 x tecnico
       ArrayList<DetalleServicio> listDetalle1= new ArrayList<>();
       listDetalle1.add(new DetalleServicio(2, listService.get(0), listService.get(0).getPrecio()*2)); // 2 * 90.0
       listDetalle1.add(new DetalleServicio(1, listService.get(1), listService.get(1).getPrecio())); // 1 * 80.0
       ArrayList<DetalleServicio> listDetalle2= new ArrayList<>();
       listDetalle2.add(new DetalleServicio(3, listService.get(2), listService.get(2).getPrecio()*3)); // 3 * 40.0
       listDetalle2.add(new DetalleServicio(4, listService.get(3), listService.get(3).getPrecio()*4)); // 4 * 70.0
       ArrayList<DetalleServicio> listDetalle3= new ArrayList<>();
       listDetalle3.add(new DetalleServicio(5, listService.get(4), listService.get(4).getPrecio()*5)); // 5 * 60.0
       listDetalle3.add(new DetalleServicio(1, listService.get(5), listService.get(5).getPrecio()*1)); // 1 * 30.0
       ArrayList<DetalleServicio> listDetalles4 = new ArrayList<>();
       listDetalles4.add(new DetalleServicio(3, listService.get(1), listService.get(1).getPrecio() * 3));//3*80
       listDetalles4.add(new DetalleServicio(1, listService.get(2), listService.get(2).getPrecio()));//1*80
        
       //Inicializa con las ordenes de servicio
       listOrden.add(new OrdenServicio(listClient.get(0), listTecni.get(0), new Date(), "ABB785", calcularTotalOrden(listDetalles4) ,TipoVehiculo.BUS,listDetalle1));
       listOrden.add(new OrdenServicio(listClient.get(1), listTecni.get(0), new Date(), "ABB786", calcularTotalOrden(listDetalle3) ,TipoVehiculo.MOTOCICLETA,listDetalle3));
       listOrden.add(new OrdenServicio(listClient.get(2), listTecni.get(1), new Date(), "ABB787", calcularTotalOrden(listDetalle2) ,TipoVehiculo.VEHICULO,listDetalle2));
       listOrden.add(new OrdenServicio(listClient.get(3), listTecni.get(1), new Date(), "ABB788", calcularTotalOrden(listDetalles4) ,TipoVehiculo.VEHICULO,listDetalles4));



       



        





    

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
    public Tecnico agregartTecnico(String identificacion,String nombre, String telefono,String especialidad){
        for (Tecnico tecnico:listTecni){
            if (tecnico.getIdentificacion().equals(identificacion)){
                return tecnico; // retorna esto y sale el metodo
            }
        }
        listTecni.add(new Tecnico(identificacion, nombre, telefono,especialidad));
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
        for (Servicio servicio: listService){
            if(servicio.getCodigo().equals(codigo)){
                double precioAntiguo= servicio.getPrecio();
                System.out.println("Ingrese el nuevo precio del servicio: ");
                double nuevoPrecio = sc.nextDouble();
                servicio.setPrecio(nuevoPrecio);
                servicio.getListHistorialPrecios().add(new HistorialPrecios(precioAntiguo, nuevoPrecio));
                
                return servicio; 
            }
        }
        return null;
    }

    public void mostrarHistorialPreciosDeTodos() {
    

    System.out.println("Historial de precios por servicio:");

    for (Servicio servicio : listService) {
        System.out.println("Servicio: " + servicio.getNombre() + " (Código: " + servicio.getCodigo() + ")");
        if (servicio.getListHistorialPrecios().isEmpty()) {
            System.out.println("  No hay historial de precios para este servicio.");
        } else {
            for (HistorialPrecios h : servicio.getListHistorialPrecios()) {
                System.out.println("  Precio anterior: " + h.getPrecioAntiguo() + ", Nuevo precio: " + h.getPrecioNuevo() + ", Fecha: " + h.getFechaCambio());
            }
        }
    }


}

//Metodo para calcular el total de una orden de servicio
public double calcularTotalOrden(ArrayList<DetalleServicio> detalles) {
    double total = 0.0;
    for (DetalleServicio detalle : detalles) {
        total += detalle.getSubtotal();
    }
    return total;

}

//metodos para generar Orden de Servicio
    // metodo para obtener el precio del servicio ingresado en base al codigo

  

    //metodo para indexar servicio
    // hay que arreglar

    public Servicio servicioPorCodigo(String codig){
            for (Servicio cadaServicio : listService) {
                if (cadaServicio.getCodigo().trim().equalsIgnoreCase(codig.trim())) {
            return cadaServicio;  
        }
    }
    return null;
    }
    /**
    public double servicioPorCodigo(String codig){
        for (int i = 0; i < listService.size(); i++) {
           Servicio cadaServicio = listService.get(i);
            if (cadaServicio.getCodigo().equals(codig.trim())) {
                return cadaServicio.getPrecio(); // Retorna el precio del servicio encontrado
            }
        }
          return 0.0; // Retorna 0 si no se encuentra el servicio 
    } */
    public OrdenServicio generarOrdenServicio(Cliente cliente, Tecnico tecnico, Date fecha, String codigo, TipoVehiculo tipoVehiculo, ArrayList<DetalleServicio> detalles) {
        OrdenServicio nuevaOrden = new OrdenServicio(cliente, tecnico, fecha, codigo, calcularTotalOrden(detalles), tipoVehiculo, detalles);
        listOrden.add(nuevaOrden);
        return nuevaOrden;
    }
}



    
