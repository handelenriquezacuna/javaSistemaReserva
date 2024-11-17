/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

import javax.swing.JOptionPane;

/**
 *
 * @author handel enriquez
 */

public class Barista {
    private String baristaNom;
    private String baristaId;
    
    public static void crear_Barista(){
    /* 
    Metodo para crear un barista manejando errores
    */
        try {
            int matrixSize = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos baristas va a ingresar?"));
            Barista[] baristaNuevo = new Barista[matrixSize];

            for (int i = 0; i < baristaNuevo.length; i++) {
                String baristaNom = JOptionPane.showInputDialog("Ingrese el nombre del barista:");
                String baristaId = JOptionPane.showInputDialog("Ingrese la cédula del barista:");
                baristaNuevo[i] = new Barista(baristaNom, baristaId);
                System.out.println(baristaNuevo[i].toString());
            }
        } 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número.");
        } 
    }
    /*
    Constructors para la aplicacion
    */
    public Barista() {
    }
    
    public Barista(String baristaNom, String baristaId) {
        this.baristaNom = baristaNom;
        this.baristaId = baristaId;
    }
       
    
    @Override
    public String toString() {
        return "Barista{" + "baristaNom=" + baristaNom + ", baristaId=" + baristaId + '}';
    }

    public String getBaristaNuevo() {
        return baristaNom;
    }

    public void setBaristaNuevo(String baristaNuevo) {
        this.baristaNom = baristaNuevo;
    }

    public String getBaristaId() {
        return baristaId;
    }

    public void setBaristaId(String baristaId) {
        this.baristaId = baristaId;
    }
}