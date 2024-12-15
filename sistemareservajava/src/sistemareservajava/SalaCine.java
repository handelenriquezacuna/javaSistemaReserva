/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

/**
 *
 * @author handel enriquez
 */



public class SalaCine {
    
   

    private int tamanoSala; // Tamaño total de la sala (numero de asientos)
    private String nombrePelicula; // Nombre de la película
    private int numeroSala; // Número de la sala
    private String[][] asientos; // Matriz de asientos ("L" = libre, "R" = reservado)

    // Constructores
    public SalaCine() {
    }

    public SalaCine(int tamanoSala, String nombrePelicula, int numeroSala) {
        this.tamanoSala = tamanoSala;
        this.nombrePelicula = nombrePelicula;
        this.numeroSala = numeroSala;
        this.asientos = new String[5][tamanoSala / 5]; // con base en tamanoSala
        inicializarAsientos();
    }

    // Inicializa los asientos como "L" (libres)
    private void inicializarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = "L"; // Todos los asientos están libres de primeras
            }
        }
    }

    // Metodo para visualizar los asientos de la sala
    public void mostrarSala() {
        System.out.println("Sala: " + numeroSala + " | Pelicula: " + nombrePelicula);
        System.out.println("L: Libre | R: Reservado");
        System.out.println("\t_Pantalla_");

        // Generar etiquetas de asientos (A0, B1, etc)
        String[][] arrangement = new String[5][tamanoSala / 5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < tamanoSala / 5; j++) {
                // Generar etiquetas basadas en filas
                switch (i) {
                    case 0 ->
                        arrangement[i][j] = "A" + j;
                    case 1 ->
                        arrangement[i][j] = "B" + j;
                    case 2 ->
                        arrangement[i][j] = "C" + j;
                    case 3 ->
                        arrangement[i][j] = "D" + j;
                    case 4 ->
                        arrangement[i][j] = "E" + j;
                }
                // Mostrar la etiqueta del asiento junto con su estado (L o R)
                System.out.print(arrangement[i][j] + "(" + asientos[i][j] + ") ");
            }
            System.out.println();
        }
    }

    // Métodos de gestión de asientos
    public boolean reservarAsiento(int fila, int columna) {
        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[fila].length) {
            if (asientos[fila][columna].equals("L")) {
                asientos[fila][columna] = "R"; // Marca el asiento como reservado
                return true;
            } else {
                System.out.println("El asiento ya está reservado.");
                return false;
            }
        } else {
            System.out.println("Índice fuera de rango.");
            return false;
        }
    }

    public void liberarAsiento(int fila, int columna) {
        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[fila].length) {
            if (asientos[fila][columna].equals("R")) {
                asientos[fila][columna] = "L"; // Marca el asiento como libre
                System.out.println("Asiento liberado con exito.");
            } else {
                System.out.println("El asiento ya estaba libre.");
            }
        } else {
            System.out.println("indice fuera de rango.");
        }
    }

    // Getters y Setters
    public int getTamanoSala() {
        return tamanoSala;
    }

    public void setTamanoSala(int tamanoSala) {
        this.tamanoSala = tamanoSala;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
}

    
    

