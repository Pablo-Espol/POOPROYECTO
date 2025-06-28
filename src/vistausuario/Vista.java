package vistausuario;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import controlador.ControlTecno;
import modelo.*;


public class Vista {

    ArrayList<DetalleServicio> ordenACalcular;

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
              System.out.print("Ingrese el telefono: ");
              String telefono = scanner.nextLine();
              System.out.print("Ingrese la dirección: ");
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
            System.out.println("<-----LISTA DE CLIENTES ACTUALIZADA----->");
            for (Cliente cadaCliente : controlador.getListClient()) {
                System.out.println(cadaCliente.toString());
            }
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
        System.out.print("Ingrese el telefono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();
         

        Proveedor proveedor =controlador.agregarProveedor(id,nombre,telefono,descripcion);

        if (proveedor == null) {
            System.out.println("El proveedor se agregó exitosamente");
        } else {
            System.out.println("El proveedor ya existe");
        }
        
        System.out.println("<-----LISTA DE PROVEEDORES ACTUALIZADA----->");
        for (Proveedor cadaProveedor : controlador.getListSuplier()) {
            System.out.println(cadaProveedor.toString());
        }
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
        System.out.println("<-----LISTA DE TECNICOS ACTUALIZADA----->");
        for (Tecnico cadaTecnico : controlador.getListTecni()) {
            System.out.println(cadaTecnico.toString());
        }
        System.out.println();
    
    }
    public void eliminarTecnico(Scanner scanner) {
    System.out.println("Eliminar Técnico");
    scanner.nextLine(); // limpiar buffer
    System.out.print("Ingrese la identificación del técnico a eliminar: ");
    String id = scanner.nextLine();

    controlador.eliminarTecnico(id, scanner);
}

     public void administrarTecnico(Scanner scanner){
        int opcion=0;

        do{
            System.out.println("1. Agregar Tecnico");
            System.out.println("2. Eliminar Tecnico");
            System.out.println("3. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarTecnico(scanner);
                    break;
                case 2:
                    eliminarTecnico(scanner);
                    break;
                case 3: 
                    System.out.println("Saliendo del menu de servicios");
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
            
        }while (opcion != 3);
        
           

    }


    //Administrar servicios

    public void agregarServicio(Scanner scanner){
        System.out.println("Agregar Servicio ");
        scanner.nextLine();
        System.out.println("Ingrese el nombre del servicio:");
        String nombre= scanner.nextLine();
        System.out.println("Ingrese el precio del servicio:");
        double precio = scanner.nextDouble();
        controlador.agregarServicio(nombre, precio);
        System.out.println("El servicio fue agregado exitosamente");
        System.out.println("<-----LISTA DE SERVICIOS ACTUALIZADA----->");
        for (Servicio cadaServicio : controlador.getListService()) {
            System.out.println(cadaServicio.toString());
        }





    }

    public void editarServicio(Scanner scanner){
        System.out.println("Editar Servicio");
        scanner.nextLine();
        System.out.println("Ingrese el codigo del servicio a editar");
        String codigo = scanner.nextLine();
        Servicio servicio = controlador.editarServicio(codigo);

        if (servicio != null) {
            System.out.println("El servicio fue editado exitosamente");
            System.out.println("<-----LISTA DE SERVICIOS ACTUALIZADA----->");
            for (Servicio cadaServicio : controlador.getListService()) {
            System.out.println(cadaServicio.toString());
            }
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



     
    //Genera la orden
    protected void generarOrden(Scanner scanner){
        ordenACalcular = new ArrayList<>();
        
        scanner.nextLine(); //limpia buffer
        System.out.print("Ingrese ID del Cliente:");
        String id= scanner.nextLine();

        Cliente clienteSeleccionado = null;
        for (Cliente cliente : controlador.getListClient()){
            if (cliente.getIdentificacion().equals(id)){
                clienteSeleccionado = cliente;
                break;
            }
        }

        if (clienteSeleccionado == null){
            System.out.println("Cliente no encontrado. Operacion cancelada.");
            return;
        }

        System.out.print("Ingrese la fecha del Servicio dd/MM/yyyy: ");
        String fechaServicio= scanner.nextLine();  //fecha en formato texto
       
        LocalDate fechaDate;
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaDate = LocalDate.parse(fechaServicio.trim(),formato);
            
        } catch (Exception e){
            System.out.println("Formato de fehca invalido. Use dd/MM/yyyy. Operacion cancelada.");
            return;
        }

         TipoVehiculo tipoVehiculo = null;
        while(tipoVehiculo == null){
            System.out.println("Ingrese el tipo de vehiculo:"+ 
            "\n1.Automovil"+  
            "\n2.Motocicleta " +
            "\n3.Bus");
            System.out.print("Ingrese el tipo:");
            int tipoV = scanner.nextInt();
            scanner.nextLine();
            switch (tipoV) {
                case 1 :tipoVehiculo = TipoVehiculo.VEHICULO;
                break;
                case 2: tipoVehiculo = TipoVehiculo.MOTOCICLETA;
                break;
                case 3: tipoVehiculo = TipoVehiculo.BUS;
                break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente");
            }
        }
        
        System.out.print("Ingrese Placa de vehiculo: ");
        String placaVehiculo = scanner.nextLine(); // No se donde enviar esto, esta sin usar

        System.out.println("--------LISTA DE SERVICIOS--------");
        for (Servicio cadaServicio : controlador.getListService()) {
        System.out.println("Código: " + cadaServicio.getCodigo() + ", Precio: " + cadaServicio.getPrecio());        
    }

        System.out.print("Ingrese el código del servicio: ");

        String codigoString = scanner.nextLine();

        int cantidad;
        while (!codigoString.equals("-1")) {

            System.out.print("Cantidad: ");
            cantidad = scanner.nextInt();

            Servicio servicio = controlador.servicioPorCodigo(codigoString);
            if (servicio == null) {
                    System.out.println("Servicio no encontrado. Verifique el código ingresado.");
                    return;
            }


            double subtotal = cantidad* servicio.getPrecio();

            ordenACalcular.add(new DetalleServicio(cantidad,servicio,subtotal));

            //evitar bucle infinito
            System.out.print("Ingrese código del servicio: ");
            scanner.nextLine(); // limpia buffer
            codigoString = scanner.nextLine();
        }
            //AQUI VA CODIGO QUE COMUNICA CON EL CONTROLADOR
            System.out.println("Total a pagar:");
            System.out.println(controlador.calcularTotalOrden(ordenACalcular));

            //Tecnico

            Tecnico tecnicoAletorio= controlador.seleccionarTecnicoAleatorio();
            if (tecnicoAletorio == null) {
                System.out.println("No hay técnicos disponibles. Debe agregar un nuevo técnico.");
                administrarTecnico(scanner);
                tecnicoAletorio = controlador.seleccionarTecnicoAleatorio();
                if (tecnicoAletorio == null) {
                    System.out.println("No se pudo agregar un técnico. Operación cancelada.");
                    return;
                }
            }
            //Guardando datos en sistema
            controlador.listaOrdenEnSistema(clienteSeleccionado,tecnicoAletorio,fechaDate,tipoVehiculo,placaVehiculo,ordenACalcular);
            System.out.println("Se agregó la orden al sistema exitosamente!");

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

    //Registrar insumos faltantes
    public void registrarInsumosFaltantes(Scanner scanner){
    System.out.println(" REGISTRO DE INSUMOS FALTANTES ");
    scanner.nextLine(); 
    System.out.print("Ingrese la descripción del insumo: ");
    String descripcion = scanner.nextLine();

    ArrayList<Proveedor> proveedores = controlador.getListSuplier();

    if (proveedores.isEmpty()) {
        System.out.println("No hay proveedores registrados. Registre uno primero.");
        agregarProveedor(scanner);
        proveedores = controlador.getListSuplier();
    }

    System.out.println("Seleccione un proveedor:");
    for (int i = 0; i < proveedores.size(); i++) {
        System.out.println((i + 1) + ". " + proveedores.get(i).getNombre() + " - " + proveedores.get(i).getDescripcion());
    }
    System.out.println((proveedores.size() + 1) + ". Agregar nuevo proveedor");

    int opcion = scanner.nextInt();
    Proveedor proveedorSeleccionado = null;

    if (opcion >= 1 && opcion <= proveedores.size()) {
        proveedorSeleccionado = proveedores.get(opcion - 1);
    } else if (opcion == proveedores.size() + 1) {
        agregarProveedor(scanner);
        proveedorSeleccionado = controlador.getListSuplier().get(controlador.getListSuplier().size() - 1);
    } else {
        System.out.println("Opción inválida. Operación cancelada.");
        return;
    }

    
    controlador.registroInsumo(descripcion, proveedorSeleccionado);

    System.out.println(" Insumo registrado correctamente.");
    System.out.println("Debe contactar al proveedor: " + proveedorSeleccionado.getNombre());

    // Mostrar todos los insumos faltantes
    System.out.println("\n Lista de Insumos Faltantes:");
    for (Insumo insumo : controlador.getListInsumosFaltantes()) {
        System.out.println( "Descripcion: "  + insumo.getDescripcion() + "--------- Fecha: " + insumo.getFechaRegistro());
    }
    }

    //Metodo generar facturas de empresas

    protected void generarFacturasEmpresas(Scanner scanner){

        System.out.print("Ingrese el codigo de la Empresa (ID): ");
        scanner.nextLine();
        String codigoEmpresa = scanner.nextLine();

        OrdenServicio clienteOrdenPorID = controlador.clientePorId(codigoEmpresa);  //retorna el Cliente por el ID
        
        if (clienteOrdenPorID.getCliente().getTipoCliente().equals(TipoCliente.EMPRESARIAL)) {
            System.out.print("Ingrese el año:");
            String ano= scanner.nextLine();
            System.out.println("Ingrese el mes: ");
            
            String mes = scanner.nextLine();

            System.out.println("Empresa: " + clienteOrdenPorID.getCliente().getNombre());
            System.out.println("Perido de facturación: " + mes + "-"+ ano );
            System.out.println("Detalle de servicios:");
            System.out.println("#Placa      Fecha       Tipo        Servicio        Cantidad        Total");
            controlador.panelDeFacturas(clienteOrdenPorID);
        }
    }

    //Mini Menu

    public void facturasParaEmpresas(Scanner scanner){
    int opcion;
        do {    
            System.out.println("1. Generar Factura");
            System.out.println("2. Regresar al menu principal");
            System.out.print("Ingrese una opción: ");

            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    generarFacturasEmpresas(scanner);
                    break;
            
                case 2:
                    System.out.println("Volviendo al menu principal");
                    break;
            }
            
        } while (opcion !=2);

    }

    


    
    // Metodo reporte de atenciones por tecnico
    
    public void reporteAtencionesporTecnico(Scanner scanner){
        System.out.println("Ingrese el año que desea consultar: ");
        int anio = scanner.nextInt();
        System.out.println("Ingrese el mes que desea consultar (ingrese un número del 1 - 12): ");
        int mess = scanner.nextInt();

        Map<String, Double> totalPorTecnico = new HashMap<>();
        
        for (OrdenServicio orden : controlador.getListOrden()){
            
            LocalDate fecha = orden.getFechaServicio();
            int ordenAnio = fecha.getYear();
            int ordenMes = fecha.getMonthValue();

            if (ordenAnio == anio && ordenMes == mess){
                String tecnicoNombre = orden.getTecnico().getNombre();
                double ordenTotal = orden.getTotalOrden();

                totalPorTecnico.put(tecnicoNombre, totalPorTecnico.getOrDefault(tecnicoNombre,0.0)+ordenTotal);
            }
        System.out.println("\n Reporte de Atenciones por Tecnico ");
        System.out.printf("%-25s %10s\n", "Tecnico", "Total");
    
        if (totalPorTecnico.isEmpty()){
            System.out.println("No se encontraron ordenes del periodo ingresado.");
        }



        }
        
        
        
        

        



    }

    public void reporteIngresosPorServicio(Scanner scanner){
        System.out.println("Ingrese el año del servicio a consultar: ");
        int año= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el mes para el reporte 1--12: ");
        int mes= scanner.nextInt();
        scanner.nextLine();

        controlador.freporteIngresosxServicio(año,mes);

    }

}
