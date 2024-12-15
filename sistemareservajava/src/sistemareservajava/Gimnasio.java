/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

/**
 *
 * @author handel enriquez
 */

public class Gimnasio {
//Vector entrenador
        private Entrenador[] entrenadores;
        
        //Constructor inicializa los entrenadores con datos simples
        public Gimnasio() {
            entrenadores = new Entrenador[3];
            entrenadores[0] = new Entrenador("Carlos", "402700348");
            entrenadores[1] = new Entrenador("Ana", "119510334");
            entrenadores[2] = new Entrenador("Luis", "402300459");
        }
        //Método
        public void verEntrenadores() {
            for (int i = 0; i < entrenadores.length; i++) {
                System.out.println("Nombre: " + entrenadores[i].getNombre() + " (ID: " + entrenadores[i].getId() + ")");
            }
        }
        //Método ver el horario de un entrenador específico por ID
        public void verHorarioEntrenador(String idEntrenador) {
            for (int i = 0; i < entrenadores.length; i++) {
                if (entrenadores[i].getId() == idEntrenador) {
                    entrenadores[i].verHorario();
                    return;
                }
            }
            System.out.println("Entrenador con ID " + idEntrenador + " no encontrado.");
        }
        
    //Método reservar una hora con un entrenador específico por ID
    public boolean reservarConEntrenador(String idEntrenador, int hora, String idEmpleado) {
        for (int i = 0; i < entrenadores.length; i++) {
            if (entrenadores[i].getId().equals(idEntrenador)) { 
               return entrenadores[i].reservarHora(hora, idEmpleado); 
            }
        }
        System.out.println("Entrenador con ID " + idEntrenador + " no encontrado.");
        return false;
    }
        
        //Método liberar una hora con un entrenador específico por ID
        public void liberarConEntrenador(String idEntrenador, int hora) {
            for (int i = 0; i < entrenadores.length; i++) {
                if (entrenadores[i].getId().equals(idEntrenador)) {
                    entrenadores[i].liberarHora(hora);
                    return;
                }
            }
            System.out.println("Entrenador con ID " + idEntrenador + " no encontrado.");
        }
        
        //Método consultar disponibilidad de una hora con un entrenador específico por ID
        public void consultarDisponibilidad(String idEntrenador, int hora) {
            for (int i = 0; i < entrenadores.length; i++) {
                if (entrenadores[i].getId() == idEntrenador) {
                    boolean disponible = entrenadores[i].consultarDisponibilidad(hora);
                    if (disponible) {
                        System.out.println("La hora " + hora + ":00 está disponible con " + entrenadores[i].getNombre() + ".");
                    } else {
                        System.out.println("La hora " + hora + ":00 ya está reservada con " + entrenadores[i].getNombre() + ".");
                    }
                    return;
                }
            }
            System.out.println("Entrenador con ID " + idEntrenador + " no encontrado.");
        }
    //Método 
    public void verHorarioEntrenador2() {
            for (int i = 0; i < entrenadores.length; i++) {           
                    entrenadores[i].verHorario();               
            }
        }
    //Setter y Getter
    public Entrenador[] getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(Entrenador[] entrenadores) {
        this.entrenadores = entrenadores;
    }
    
}