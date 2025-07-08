import java.util.*;
import vistausuario.*;
import controlador.*;

public class TecnicentroRP {
public static void main(String[] args) {


ControlTecno controlador = new ControlTecno();

Vista vista = new Vista(controlador);
VistaCliente vistaCliente = new VistaCliente(controlador);

controlador.inicializarApp();

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
          vista.administrarProveeddores(sc);
          break;
        case 3:
          vista.administrarTecnico(sc);
          break;
        case 4: 
          vista.administrarServicios(sc);
          break;
        case 5:
          vista.generarOrdenServicio(sc);
          break;
        case 6: 
          vista.registrarInsumosFaltantes(sc);
          break;
        case 7:
          vista.facturasParaEmpresas(sc);
        break;
          case 8: 
          vista.reporteIngresosPorServicio(sc);
          break;
        case 9:
          vista.reporteAtencionesporTecnico(sc);
        break;
        case 10:
          System.out.println("Gracias por usar nuestro sistema. ¡Hasta luego!");
          break;

      }

    } while (opcion != 10);


sc.close();

    }
}
