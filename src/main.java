import java.util.*;
import modelo.*;
import vistausuario.*;
import controlador.*;

public class main{
public static void main(String[] args) {


ControlTecno controlador = new ControlTecno();

Vista vista = new Vista(controlador);

controlador.inicializarApp();

Scanner sc = new Scanner(System.in);

   int opcion=0;
    do {
        vista.mostrarMenu();
        System.out.print("Seleccione una opción: ");
        opcion = sc.nextInt();

      switch (opcion){
       
        case 1:
        vista.administrarClientes(sc);
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
      }

    } while (opcion != 10);


sc.close();

    }
}
