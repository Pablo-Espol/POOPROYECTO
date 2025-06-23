package vistausuario;

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

    //String identificacion,String nombre,String telefono,String direccion,TipoCliente tipoCliente
     public void agregarCliente(Scanner scanner){
              System.out.print("Ingrese la identificacion del cliente: ");
              scanner.nextLine(); //buffer
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

                for (TipoCliente tipo : TipoCliente.values()) {
                    if (tipo.name().equals(tipoTextoc)) {
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

    //Metodo para administrar tecnicos
    public void agregarTecnico(Scanner scanner){
        System.out.println("Agregar Tecnico");
        scanner.nextLine();
        System.out.println("Ingrese la identificacion del tecnico");
        String id= scanner.nextLine();
        System.out.println("Ingres el nombre de Tecnico");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el telefono del tecnico");
        String telefono= scanner.nextLine();

        Tecnico tecnico = controlador.agregartTecnico(id, nombre, telefono);
        
        if (tecnico == null){
            System.out.println("El tecnico fue agregado exitosamente");

        }else{
            System.out.println("El tecnico ya existe");
        }
        System.out.println(controlador.getListTecni());
    
    }
    

    
}
