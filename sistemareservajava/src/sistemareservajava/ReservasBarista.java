/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author hande
 */
public class ReservasBarista {

    private String empleado;
    private String idEmpleado;
    private String bebidaReservada;
    private String ifBebidaReservada;
    private int numBebidasReserva;
    public ReservasBarista[] reservasRealizadas;

    /*
    Metodos de la clase 
     */
    public void desplegarMenu() {
        /*
        El objetivo de este metodo es capturar opciones del menu y presentarlas al cliente
         */
        EnumMenu[] opciones = EnumMenu.values();
        StringBuilder opcionesTexto = new StringBuilder();
        for (int i = 0; i < opciones.length; i++) {
            opcionesTexto.append(opciones[i].ordinal() + 1);
            opcionesTexto.append("-" + opciones[i].name() + "\n");
            if (i < opciones.length - 1) {
                opcionesTexto.append(", ");
            }
        }
        JOptionPane.showMessageDialog(null, "Opciones de bebida disponibles: " + "\n" + opcionesTexto.toString().replaceAll(",", ""));
    }

    public String seleccionBebida() {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor del 1-7"));
        LocalDateTime locaDate = LocalDateTime.now();
        String resultado = "";
        switch (x) {
            case 1:
                resultado = EnumMenu.getCAFE_NORMAL().name();
                break;

            case 2:
                resultado = EnumMenu.getCAPUCHINO().name();
                break;
            case 3:
                resultado = EnumMenu.getCAPUCHINO_VAINILLA().name();
                break;
            case 4:
                resultado = EnumMenu.getCHOCOLATE().name();
                break;
            case 5:
                resultado = EnumMenu.getMOKA().name();
                break;
            case 6:
                resultado = EnumMenu.getTE_CHAI().name();
                break;
            case 7:
                resultado = EnumMenu.getCAFE_FRIO().name();
                break;
            default:
                throw new AssertionError("Numero no valido");
        }
        return resultado;
    }

    public ReservasBarista[] iniciarMetodos(){
        int matrixSize = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas reservas va a ingresar?"));
        ReservasBarista[] reservaNueva = new ReservasBarista[matrixSize];
        return reservaNueva;
    }   
    
    public void ingresarReserva() {
        ReservasBarista[] reservaNueva = iniciarMetodos();
        for (int i = 0; i < reservaNueva.length; i++) {
            String empleado = JOptionPane.showInputDialog("Ingrese nombre de Empleado:");
            String idEmpleado = JOptionPane.showInputDialog("Ingrese la cédula del Empleado:");
            /*
            Verificar si el idEmpleado ya está registrado
             */
            boolean existeReserva = false;
            for (int j = 0; j < i; j++) {
                if (reservaNueva[j].getEmpleado().equals(empleado)|| reservaNueva[j].getIdEmpleado().equals(idEmpleado)) {
                    existeReserva = true;
                    break;
                }
            }

            if (existeReserva) {
                JOptionPane.showMessageDialog(null, "Error: Usuario con reserva existente.");
                i--; // Tolerancia al fallo de usuario
                continue;
            }
            /*
                Enseña el menu al usuario
             */
            desplegarMenu();
            String bebidaReservada = seleccionBebida();
            String ifBebidaReservada = "Y";
            int numBebidasReserva = 1;
            reservaNueva[i] = new ReservasBarista(empleado, idEmpleado, bebidaReservada, ifBebidaReservada, numBebidasReserva);
            System.out.println(reservaNueva[i].toString());
        }
        this.reservasRealizadas = reservaNueva;
    }
    
    
    public void modificarReserva(){
    
       System.out.println("Se usara para modificar reservas!");
       String idEmpleado = JOptionPane.showInputDialog("Ingrese la cédula del empleado a modificar:");
       boolean reservaEncontrada = false;

        // Buscar la reserva por idEmpleado
        for (int i = 0; i < reservasRealizadas.length; i++) {
            if (reservasRealizadas[i] != null && reservasRealizadas[i].getIdEmpleado().equals(idEmpleado)) {
                reservaEncontrada = true;
                JOptionPane.showMessageDialog(null, "Reserva encontrada: " + reservasRealizadas[i].toString());

                // Modificar la bebida y el número de bebidas
                String nuevaBebida = seleccionBebida();
                reservasRealizadas[i].setBebidaReservada(nuevaBebida);

                JOptionPane.showMessageDialog(null, "Reserva modificada: " + reservasRealizadas[i].toString());
                break;
            }
        }

        // Si no se encuentra la reserva
        if (!reservaEncontrada) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna reserva para el empleado con cédula: " + idEmpleado);
        }
    
    }
    
    public void listarReservas(){
        StringBuilder reservasLista = new StringBuilder();
        for (int i = 0; i < reservasRealizadas.length; i++) {
             System.out.println("Se va usar para dar lista de reservas");
             reservasLista.append(reservasRealizadas[i].toString() + "\n");
         }
        JOptionPane.showMessageDialog(null, "Reserva modificada: " + reservasLista.toString());
    }
    
    
    /*
    Constructores 
     */

    @Override
    public String toString() {
        return "ReservasBarista{" + "empleado=" + empleado + ", idEmpleado=" + idEmpleado + ", bebidaReservada=" + bebidaReservada + ", ifBebidaReservada=" + ifBebidaReservada + ", numBebidasReserva=" + numBebidasReserva + '}';
    }

    public ReservasBarista() {
    }

    public ReservasBarista(String empleado, String idEmpleado, String bebidaReservada, String ifBebidaReservada, int numBebidasReserva) {
        this.empleado = empleado;
        this.idEmpleado = idEmpleado;
        this.bebidaReservada = bebidaReservada;
        this.ifBebidaReservada = ifBebidaReservada;
        this.numBebidasReserva = numBebidasReserva;
    }



    /*
    Getter & Setters para la applicacion
     */

    public ReservasBarista[] getReservasRealizadas() {
        return reservasRealizadas;
    }

    public void setReservasRealizadas(ReservasBarista[] reservasRealizadas) {    
        this.reservasRealizadas = reservasRealizadas;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getBebidaReservada() {
        return bebidaReservada;
    }

    public void setBebidaReservada(String bebidaReservada) {
        this.bebidaReservada = bebidaReservada;
    }

    public String getIfBebidaReservada() {
        return ifBebidaReservada;
    }

    public void setIfBebidaReservada(String ifBebidaReservada) {
        this.ifBebidaReservada = ifBebidaReservada;
    }

    public int getNumBebidasReserva() {
        return numBebidasReserva;
    }

    public void setNumBebidasReserva(int numBebidasReserva) {
        this.numBebidasReserva = numBebidasReserva;
    }

}
