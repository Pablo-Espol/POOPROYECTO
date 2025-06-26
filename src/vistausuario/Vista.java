package vistausuario;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.ControlTecno;
import modelo.*;


public class Vista {

    ControlTecno controlador;

    public Vista(ControlTecno controlador){
        this.controlador= controlador;
    }

    public void mostrarMenu(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Administrar Clientes");
        System.out.println("2. Administrar Proveedores");
        System.out.println("3. Administrar Tecnicos");
        System.out.println("4. Administrar Servicios");
        System.out.println("5. Generar orden de servicios");
        System.out.println("6. Registrar falta de insumos");
        System.out.println("7. Generar facturas a empresas");
        System.out.println("8. Reporte de ingresos por servicio");
        System.out.println("9. Reporte de atenciones por tecnico");
        System.out.println("10. Salir");

    }
    //Metodo para agregar cliente

     public void agregarCliente(Scanner scanner){
              System.out.print("Ingrese la identificacion del cliente: ");
              scanner.nextLine(); //limpiar buffer
              String id = scanner.nextLine();
              System.out.print("Ingrese el nombre del cliente: ");
              String nombre = scanner.nextLine();
              System.out.println("Ingrese el telefono: ");
              String telefono = scanner.nextLine();
              System.out.println("Ingrese la dirección: ");
              String direccion = scanner.nextLine();

              //Asegurando que el tipo cliente sea válido
            TipoCliente tipoCliente = null;
            while (tipoCliente == null) {
                System.out.print("Ingrese el tipo de cliente (PERSONAL o EMPRESARIAL): ");
                String tipoTextoc = scanner.nextLine().toUpperCase(); 

                for (TipoCliente tipo : TipoCliente.values()) {// Recorre los valores del enum guardados en una lista
                    if (tipo.name().equals(tipoTextoc)) { // compara el nombre del enum con el texto ingresado y si coincide le asigna
                        tipoCliente = tipo;
                        break;
                    }
                }
                if (tipoCliente == null) {
                    System.out.println("Tipo inválido. Intente nuevamente.");
                }
            }

            //return cliente o null
           Cliente cliente =  controlador.agregarCliente(id,nombre,telefono,direccion,tipoCliente);
            
            if (cliente == null) {
                System.out.println("El cliente se agregó exitosamente");
            }
            else{
                System.out.println("El cliente ya existe");
            }

            System.out.println(controlador.getListClient());
    }

    public void administrarClientes(Scanner scanner){
        int opcion=0;

        do{
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarCliente(scanner);
                    break;
                case 2:
                    System.out.println("Saliendo del menu de clientes");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
            
        }while (opcion != 2);
        
           

    }

    //Metodo para Adminnistar proveedor

    //Agregar Proveedor
    public void agregarProveedor(Scanner scanner){
        System.out.print("Ingrese la identificacion del proveedor: ");
        scanner.nextLine(); 
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el telefono: ");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese la dirección: ");
        String direccion = scanner.nextLine();
         

        Proveedor proveedor =controlador.agregarProveedor(id,nombre,telefono,direccion);

        if (proveedor == null) {
            System.out.println("El proveedor se agregó exitosamente");
        } else {
            System.out.println("El proveedor ya existe");
        }
        
        System.out.println(controlador.getListSuplier());
    }

     public void administrarProveeddores(Scanner scanner){
        int opcion=0;

        do{
            System.out.println("1. Agregar Proveedor");
            System.out.println("2. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarProveedor(scanner);
                    break;
                case 2:
                    System.out.println("Regresando al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
            
        }while (opcion != 2);
        
           

    }



    //Metodo para administrar tecnicos
    public void agregarTecnico(Scanner scanner){
        System.out.println("Agregar Tecnico");
        scanner.nextLine();
        System.out.println("Ingrese la identificacion del tecnico");
        String id= scanner.nextLine();
        System.out.println("Ingrese el nombre de Tecnico");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el telefono del tecnico");
        String telefono= scanner.nextLine();
        System.out.println("Ingrese la especialidad del tecnico");
        String especialidad = scanner.nextLine();

        Tecnico tecnico = controlador.agregartTecnico(id, nombre, telefono,especialidad);
        
        if (tecnico == null){
            System.out.println("El tecnico fue agregado exitosamente");

        }else{
            System.out.println("El tecnico ya existe");
        }
        System.out.println(controlador.getListTecni());
    
    }

     public void administrarTecnico(Scanner scanner){
        int opcion=0;

        do{
            System.out.println("1. Agregar Tecnico");
            System.out.println("2. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarTecnico(scanner);
                    break;
                case 2:
                    System.out.println("Regresando al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
            
        }while (opcion != 2);
        
           

    }


    //Administrar servicios

    public void agregarServicio(Scanner scanner){
        System.out.println("Agregar Servicio ");
        scanner.nextLine();
        System.out.println("Ingrese el nombre del servicio");
        String nombre= scanner.nextLine();
        System.out.println("Ingrese el precio del servicio");
        double precio = scanner.nextDouble();
        Servicio servicio= controlador.agregarServicio(nombre, precio);
        System.out.println("El servicio fue agregado exitosamente");
        System.out.println(controlador.getListService());





    }

    public void editarServicio(Scanner scanner){
        System.out.println("Editar Servicio");
        scanner.nextLine();
        System.out.println("Ingrese el codigo del servicio a editar");
        String codigo = scanner.nextLine();
        Servicio servicio = controlador.editarServicio(codigo);

        if (servicio != null) {
            System.out.println("El servicio fue editado exitosamente");
            System.out.println(controlador.getListService());
            System.out.println("Historial de precios del servicio:");
            for (HistorialPrecios historial : servicio.getListHistorialPrecios()) {
                System.out.println(historial);
            }
        } else {
            System.out.println("El servicio no existe");
        }
        
    }

    public void administrarServicios(Scanner scanner){
        int opcion;

        do{
            System.out.println("1. Agregar Servicio");
            System.out.println("2. Editar Servicio");
            System.out.println("3. Regresar al menu principal");
            System.out.println("Seleccione una opcion:");

            opcion= scanner.nextInt();
             
            switch (opcion) {
                case 1:
                agregarServicio(scanner);
                break;
                case 2:
                editarServicio(scanner);
                break;  
                case 3: 
                System.out.println("Saliendo del menu de servicios");}



          }  while (opcion != 3);  


        

        
    }

    //administrar Orden de servicios



     
    //genera la orden
    protected void generarOrden(Scanner scanner){
        ArrayList<DetalleServicio> ordenACalcular = new ArrayList<>();
        
        scanner.nextLine(); //limpia buffer
        System.out.print("Ingrese ID del Cliente:");
        String id= scanner.nextLine();
        System.out.print("Ingrese la fecha del Servicio dd/MM/yyyy: ");
        String fechaServicio= scanner.nextLine();  //hay que convertirlo a Tipo Date con metodos de paquete Date
        System.out.print("Ingrese el tipo de vehiculo: ");
        String tipoVehiculo= scanner.nextLine();
        System.out.print("Ingrese Placa de vehiculo: ");
        String placaVehiculo = scanner.nextLine();

        System.out.println("--------LISTA DE SERVICIOS--------");
        for (Servicio cadaServicio : controlador.getListService()) {
            System.out.println(cadaServicio);
        }

        System.out.print("Ingrese el código del servicio: ");
        String codigo = scanner.nextLine();
        while (codigo != ("-1")) {
            
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();

            double subtotal = cantidad* controlador.indexacionDePrecio(codigo);

            ordenACalcular.add(new DetalleServicio(cantidad, new Servicio(codigo),subtotal ));

            //evitar bucle infinito
            System.out.print("Ingrese código del servicio: ");
            codigo = scanner.nextLine();
        }
            //AQUI VA CODIGO QUE COMUNICA CON EL CONTROLADOR

            controlador.calcularTotalOrden(ordenACalcular);

            

    }
    public void generarOrdenServicio(Scanner scanner){
        int opcion;
        do {    
            System.out.println("1. Generar Orden");
            System.out.println("2. Regresar al menu principal");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    generarOrden(scanner);
                    break;
            
                case 2:
                    System.out.println("Volviendo al menu principal");
                    break;
            }
            
        } while (opcion !=2);

    }
    

    
}
