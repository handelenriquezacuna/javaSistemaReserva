/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

/**
 *
 * @author krist
 */
public class Hora {
      //Atributos
    private int hora;
    private boolean disponible;
    private String idEmpleado;
   
    //Constructor con parametros
    public Hora(int hora) {
        this.hora = hora;
        this.disponible = true;
        this.idEmpleado = "";
    }
    //Sett y Gett
    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getHora() {
        return hora;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }
    
    //Metodos
    public boolean reservar(String idEmpleado) {
        if (disponible == true ) {
            this.disponible = false;
            this.idEmpleado = idEmpleado;
            return true;
        }
        return false;
    }

    public void liberar() {
        this.disponible = true;
        this.idEmpleado = null;
    }
    
    //to String
    @Override
    public String toString() {
        if (disponible) {
            return hora + ":00 - Disponible";
        } else {
            return hora + ":00 - Reservado por " + idEmpleado;
        }
    }
    
}
