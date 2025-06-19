/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Fmalu
 */
public class Cliente extends Personal {
    private TipoCliente tipoCliente;

    public Cliente(String identificacion,String nombre,String telefono,String direccion,TipoCliente tipoCliente) {
        super(identificacion,nombre,telefono,direccion);
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

   @Override
    public String toString() {
        return super.toString() + String.format(", Tipo: %s", tipoCliente);
    }
    
}
