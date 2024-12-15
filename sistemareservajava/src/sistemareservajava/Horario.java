/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

/**
 *
 * @author krist
 */
class Horario {
 //Atributos
    private Hora[] horas;

    //Constructor sin parametros **
    public Horario() {
        horas = new Hora[6];
        for (int i = 0; i < 6; i++) { //para hacerlo 24horas lo de abajo
            horas[i] = new Hora(14 + i); //Inicializa desde las 14:00 hasta las 19:00
        }
    }
    //Setter y Getter
    public Hora[] getHoras() {
        return horas;
    }

    public void setHoras(Hora[] horas) {
        this.horas = horas;
    }

    //Metodos
    public void verDisponibilidad() {
        for (int i = 0; i < horas.length; i++) {
            System.out.println(horas[i]); // Imprime la hora usando el método toString() de Hora.
        }
    }

    public boolean reservarHora(int hora, String idEmpleado) { //va recorriendo todo el horario para comparar y rreservar la hora que es
        for (int i = 0; i < horas.length; i++) {
            if (horas[i].getHora() == hora) { //Compara directamente con la hora.
                if (horas[i].reservar(idEmpleado)) {
                    return true; //Reserva exitosa.
                } else { //si no encuentra la hora es porque ya esta reservada 
                    System.out.println("La hora ya esta reservada.");
                    return false;
                }
            }
        }
        System.out.println("Hora no encontrada.");
        return false; //Retorna false si no encuentra la hora.
    }

    public void liberarHora(int hora) {
        for (int i = 0; i < horas.length; i++) {
            if (horas[i].getHora() == hora) { //Compara directamente con la hora.
                horas[i].liberar(); //Libera la reserva.
                System.out.println("Hora liberada con exito.");
                return; //Termina después de liberar la hora(for)
            }
        }
        System.out.println("Hora no encontrada."); //si no lo encuentra 
    }
    public boolean verDisponibilidadHora(int hora) {
        for (int i = 0; i < horas.length; i++) {
            if (horas[i].getHora() == hora) { //Encuentra la hora específica.
                return horas[i].isDisponible(); //Devuelve true si está disponible.
            }
        }
        return false; //Hora no encontrada.
    }
}
