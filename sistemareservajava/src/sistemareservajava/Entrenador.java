/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

/**
 *
 * @author krist
 */
public class Entrenador {
    //Atributos
    private String nombre;
    private String idEntrenador; // ID único del entrenador
    private Horario horario; //instancia de horario

    //Constructor con parametros
    public Entrenador(String nombre, String idEntrenador) {
        this.nombre = nombre;
        this.idEntrenador = idEntrenador;
        this.horario = new Horario(); 
    }
    //Setter y Getter
    public String getId() {
        return idEntrenador;
    }

    public void setId(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }
    
    //Método mostrar el horario del entrenador
    public void verHorario() {
        System.out.println("Horario del entrenador " + nombre + ":");
        horario.verDisponibilidad(); //Método para listar todas las horas y su disponibilidad
    }

    //Método reservar una hora para un empleado
    public boolean reservarHora(int hora, String idEmpleado) {
        boolean resultado = horario.reservarHora(hora, idEmpleado);
        if (resultado) {
            System.out.println("Hora " + hora + ":00 reservada con exito para " + idEmpleado + ".");
        } else {
            System.out.println("No se pudo reservar la hora " + hora + ":00. Verifique la disponibilidad.");
        }
        return resultado;
    }

    //Método liberar una hora previamente reservada
    public void liberarHora(int hora) {
        horario.liberarHora(hora);
        System.out.println("Hora " + hora + ":00 liberada con exito.");
    }

    //Método verificar disponibilidad de una hora específica
    public boolean consultarDisponibilidad(int hora) {
        return horario.verDisponibilidadHora(hora); 
    }
}
