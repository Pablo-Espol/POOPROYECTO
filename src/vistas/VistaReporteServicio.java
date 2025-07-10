package vistas;

import java.util.Scanner;

//import javax.naming.ldap.ControlFactory;

import controladores.ControlTecno;

public class VistaReporteServicio {

    ControlTecno controlador;

    public VistaReporteServicio(ControlTecno controlador){
        this.controlador= controlador;
    }


//metodos para reporte de Ingresos por servicio
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
