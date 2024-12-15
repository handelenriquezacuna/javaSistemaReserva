/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemareservajava;

import sistemareservajava.Cine;

/**
 *
 * @author hande
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        /*
        Menu Para desplegar beta
         */

        ventanaPrincipal venta = new ventanaPrincipal("Sistema de Reservas");
        venta.mostrarVentana();

        MenuGimnasio menu = new MenuGimnasio();
        menu.mostrarMenu();

        // Punto de entrada del programa
        Cine cine = new Cine(); //objeto de la clase Cine
        cine.iniciarGestion();  // Llama al mtodo para iniciar la gestion
    }
}
