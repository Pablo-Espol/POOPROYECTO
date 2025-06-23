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
        
        opcion = sc.nextInt();

      switch (opcion){
       
        case 1:
        vista.agregarCliente(sc);
        break;
        case 2:
        vista.agregarProveedor(sc);
        break;
        case 3:
        vista.agregarTecnico(sc);
        break;
        case 4: 
        vista.administrarServicios(sc);
        
      }

    } while (opcion != 10);


sc.close();

    }
}
