package vistas;

import java.util.ArrayList;
import java.util.Scanner;

import controladores.ControlTecno;
import modelo.Insumo;
import modelo.Proveedor;


public class VistaFaltaInsumos {

    ControlTecno controlador;

    VistaProveedor vistaProveedor;

    public VistaFaltaInsumos(ControlTecno controlador){
        this.controlador= controlador;
        this.vistaProveedor= new VistaProveedor(controlador);
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
        
        vistaProveedor.agregarProveedor(scanner);
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
        vistaProveedor.agregarProveedor(scanner);
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
}
