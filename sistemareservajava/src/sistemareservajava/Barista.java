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
    private String baristaNuevo = "";
    private String empleado = "";
    private int numEmpleado = 0;
    private EnumMenu menu;
    private int numBebida;
    
    public void ingresarEmpleados(){
        /*
        Ingreso de Empleados
        */
        this.numEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados"));
        for (int i = 0; i < this.numEmpleado; i++) {
            this.empleado = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        }
    }    
    
    /*
    Constructores empiezan aca 
    */
    public Barista() {
    
    }
    
    public Barista(String baristaNuevo, String empleado, int numEmpleado, EnumMenu menu) {
        this.baristaNuevo = baristaNuevo;
        this.empleado = empleado;
        this.numEmpleado = numEmpleado;
        this.menu = menu;
    }

    /*
    Terminan Constructores 
    */
    
    /*
    Getters y Setters para la extraccion 
    */
    
    public int getNumBebida() {
        return numBebida;
    }
    
    public EnumMenu getMenu() {
        return menu;
    }

    public void setMenu(EnumMenu menu) {
        this.menu = menu;
    }  

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }     
        
    public String getBaristaNuevo() {
        return baristaNuevo;
    }

    public void setBaristaNuevo() {
        this.baristaNuevo = JOptionPane.showInputDialog("Ingrese el nombre del Barista");
    }

    public String getEmpleado() {   
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    
    /*  
    Terminan Getters y Setters para la extraccion 
    */

    
}