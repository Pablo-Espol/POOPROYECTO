import java.util.*;

import controladores.*;
import vistas.*;

public class TecnicentroRP {
public static void main(String[] args) {

//Instacias de controlador
//ControlTecno controlador = new ControlTecno();
ControladorBase controladorBase = new ControladorBase();
ControladorCliente controladorCliente = new ControladorCliente(controladorBase);
ControladorProveedor controladorProveedor = new ControladorProveedor(controladorBase);
ControladorTecnico controladorTecnico = new ControladorTecnico(controladorBase);
ControladorServicio controladorServicio = new ControladorServicio(controladorBase);
ControladorOrden controladorOrden = new ControladorOrden(controladorBase);
ControladorInsumo controladorInsumo = new ControladorInsumo(controladorBase);
ControladorFactura controladorFactura = new ControladorFactura(controladorBase);
ControladorReporte controladorReporte = new ControladorReporte(controladorBase);


//Instancias de vistausuario
VistaMenu vista = new VistaMenu();
VistaCliente vistaCliente = new VistaCliente(controladorCliente);
VistaProveedor vistaProveedor = new VistaProveedor(controladorProveedor);
VistaTecnicos vistaTecnicos = new VistaTecnicos(controlador);
VistaServicios vistaServicios = new VistaServicios(controlador);
VistaFacturaEmpresa vistaFacturaEmpresas = new VistaFacturaEmpresa(controlador);
VistaFaltaInsumos vistaInsumosFaltantes = new VistaFaltaInsumos(controlador);
VistaGenerarOrden vistaGenerarOrden = new VistaGenerarOrden(controlador);
VistaReporteServicio vistaReporteServicio = new VistaReporteServicio(controlador);
VistaReporteTecnico vistaReporteTecnico = new VistaReporteTecnico(controlador);

controladorBase.inicializarApp();

Scanner sc = new Scanner(System.in);

   int opcion=0;
    do {
        vista.mostrarMenu();
        System.out.print("Seleccione una opción: ");
        opcion = sc.nextInt();

      switch (opcion){
       
        case 1:
         vistaCliente.administrarClientes(sc);          
          break;
        case 2:
          vistaProveedor.administrarProveeddores(sc);
          break;
        case 3:
          vistaTecnicos.administrarTecnico(sc);
          break;
        case 4: 
          vistaServicios.administrarServicios(sc);
          break;
        case 5:
          vistaGenerarOrden.generarOrdenServicio(sc);
          break;
        case 6: 
          vistaInsumosFaltantes.registrarInsumosFaltantes(sc);
          break;
        case 7:
          vistaFacturaEmpresas.facturasParaEmpresas(sc);
        break;
          case 8: 
          vistaReporteServicio.reporteIngresosPorServicio(sc);
          break;
        case 9:
          vistaReporteTecnico.reporteAtencionesporTecnico(sc);
        break;
        case 10:
          System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
          break;

      }

    } while (opcion != 10);


sc.close();

    }
}
