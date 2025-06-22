/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Fmalu
 */
public class Tecnico extends Personal {
    private String especialidad;

    public Tecnico(String identificacion, String nombre, String telefono,String especialidad) {
        super(identificacion, nombre, telefono);
        this.especialidad=especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Especialidad: %s", especialidad);
    }
    
    
}
