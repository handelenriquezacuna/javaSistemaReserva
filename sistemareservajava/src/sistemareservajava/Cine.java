/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

import javax.swing.JOptionPane;

/**
 *
 * @author issac
 */
public class Cine {

    public void iniciarGestion() {
        // Crear salas
        int numSalas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de salas:"));
        SalaCine[] salas = new SalaCine[numSalas];

        // Configurar salas
        for (int i = 0; i < numSalas; i++) {
            String pelicula = JOptionPane.showInputDialog("Ingrese el nombre de la película para la sala " + (i + 1) + ":");
            int tamanoSala = (i % 2 == 0) ? 30 : 25; // Alterna entre 30 y 25 asientos
            salas[i] = new SalaCine(tamanoSala, pelicula, i + 1);
        }

        // Menú interactivo
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "1. Ver salas y películas\n2. Ver asientos\n3. Reservar asiento\n4. Liberar asiento\n5. Salir"));

            switch (opcion) {
                case 1: // Muestra las salas y sus películas
                    for (SalaCine sala : salas) {
                        System.out.println("Sala " + sala.getNumeroSala() + ": " + sala.getNombrePelicula());
                    }
                    break;

                case 2: // Muestra los asientos de una sala seleccionada
                    int salaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Elija sala (1-" + numSalas + "):")) - 1;
                    salas[salaSeleccionada].mostrarSala();
                    break;

                case 3: // Reservar un asiento
                    salaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Elija sala (1-" + numSalas + "):")) - 1;
                    int fila = Integer.parseInt(JOptionPane.showInputDialog("Fila (0-4):"));
                    int columna = Integer.parseInt(JOptionPane.showInputDialog("Columna (0-" + (salas[salaSeleccionada].getTamanoSala() / 5 - 1) + "):"));
                    salas[salaSeleccionada].reservarAsiento(fila, columna);
                    break;

                case 4: // Liberar un asiento
                    salaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Elija sala (1-" + numSalas + "):")) - 1;
                    fila = Integer.parseInt(JOptionPane.showInputDialog("Fila (0-4):"));
                    columna = Integer.parseInt(JOptionPane.showInputDialog("Columna (0-" + (salas[salaSeleccionada].getTamanoSala() / 5 - 1) + "):"));
                    salas[salaSeleccionada].liberarAsiento(fila, columna);
                    break;

                case 5: // Salir
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }
}
