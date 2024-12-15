/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

import javax.swing.JOptionPane;

/**
 *
 * @author krist
 */
public class MenuGimnasio {
     //Instancia de gimnasio
    private Gimnasio gimnasio;
    
    //Constructor sin parametros
    public MenuGimnasio() {
        gimnasio = new Gimnasio(); // Crear el gimnasio con entrenadores
    }
    
   //Método menú
   public void mostrarMenu() {
        int opcion = 0;

        while (opcion != 4) {
            String input = JOptionPane.showInputDialog(
                    "--- Menu del Gimnasio ---\n"
                    + "1. Ver entrenadores y horarios\n"
                    + "2. Reservar una sesion\n"
                    + "3. Cancelar una reserva\n"
                    + "4. Salir\n"
                    + "Seleccione una opcion:"
            );

            if (input != null) {
                opcion = Integer.parseInt(input);
                if (opcion == 1) {
                    mostrarHorarios();
                } else if (opcion == 2) {
                    realizarReserva();
                } else if (opcion == 3) {
                    cancelarReserva();
                } else if (opcion == 4) {
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema! Hasta luego.");
                } else {
                    JOptionPane.showMessageDialog(null, "Opción no valida.");
                }
            } else {
                opcion = 4; 
            }
        }
    }
   //Método mostrar entrenadores y sus horarios
   private void mostrarHorarios() {
    String horarios = "--- Entrenadores y Horarios ---\n";
    Entrenador[] entrenadores = gimnasio.getEntrenadores();
    for (int i = 0; i < entrenadores.length; i++) {
        horarios += "Entrenador: " + entrenadores[i].getNombre()
                  + " (ID: " + entrenadores[i].getId() + ")\n";
        entrenadores[i].verHorario(); 
    }
    JOptionPane.showMessageDialog(null, horarios); 
}
   //Método
    private void realizarReserva() {
        // Pedir datos para realizar una reserva
        String idEntrenador = JOptionPane.showInputDialog("Ingrese el ID del entrenador:");
        int hora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora a reservar (14-19):"));
        String idEmpleado = JOptionPane.showInputDialog("Ingrese el ID del empleado:");

        //Intentar realizar la reserva
        boolean exito = gimnasio.reservarConEntrenador(idEntrenador, hora, idEmpleado);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Reserva realizada con exito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la reserva. Verifique la disponibilidad.");
        }
    }
    //Método
    private void cancelarReserva() {
        //Pedir los datos para cancelar una reserva
        String idEntrenador = JOptionPane.showInputDialog("Ingrese el ID del entrenador:");
        int hora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora a liberar (14-19):"));

        //Cancelar la reserva
        gimnasio.liberarConEntrenador(idEntrenador, hora);
        JOptionPane.showMessageDialog(null, "Reserva cancelada con exito.");
    }
}
