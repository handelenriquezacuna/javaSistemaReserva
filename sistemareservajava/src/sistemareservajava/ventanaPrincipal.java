/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemareservajava;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author handel enriquez
 */
public class ventanaPrincipal extends JFrame {

    public ventanaPrincipal(String titulo) {
        super(titulo);

        // Configuración de la ventana principal
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Panel principal con diseño moderno
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 20, 20));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelBotones.setBackground(new Color(240, 240, 240));

        // Crear botones con estilo
        JButton botonCine = crearBoton("Cine", new Color(52, 152, 219));
        JButton botonGimnasio = crearBoton("Gimnasio", new Color(46, 204, 113));
        JButton botonActividad = crearBoton("Baile/Yoga", new Color(241, 196, 15));
        JButton botonBebidas = crearBoton("Bebidas", new Color(231, 76, 60));

        // Agregar ActionListeners a los botones
        botonCine.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de Cine aún no implementada."));
        botonGimnasio.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de Gimnasio aún no implementada."));
        botonActividad.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de Actividades aún no implementada."));
        botonBebidas.addActionListener(e -> openNewWindow("Bebidas"));

        // Agregar botones al panel
        panelBotones.add(botonCine);
        panelBotones.add(botonGimnasio);
        panelBotones.add(botonActividad);
        panelBotones.add(botonBebidas);

        // Agregar el panel principal a la ventana
        this.add(panelBotones, BorderLayout.CENTER);

        // Barra superior con título estilizado
        JLabel tituloLabel = new JLabel("Sistema de Reservas", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        tituloLabel.setOpaque(true);
        tituloLabel.setBackground(new Color(41, 128, 185));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setPreferredSize(new Dimension(this.getWidth(), 60));
        this.add(tituloLabel, BorderLayout.NORTH);
    }

    // Método para crear botones con estilo
    private JButton crearBoton(String texto, Color colorFondo) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.BOLD, 18));
        boton.setFocusPainted(false);
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createLineBorder(colorFondo.darker(), 2));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    private void openNewWindow(String title) {
        JFrame newWindow = new JFrame(title);
        newWindow.setSize(800, 600);
        newWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newWindow.setLayout(new BorderLayout());

        /*
        Contenido de la nueva ventana
         */
        JLabel label = new JLabel("Bienvenido a la sección de " + title, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 20));
        label.setForeground(new Color(231, 76, 60));
        newWindow.add(label, BorderLayout.CENTER);

        /*
        Botón para regresar
         */
        JButton backButton = new JButton("Volver al Menú Principal");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        backButton.setFocusPainted(false);
        backButton.setBackground(new Color(52, 152, 219));
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(e -> {
            newWindow.dispose();
            this.setVisible(true);
        });

        JButton actionButton = new JButton("Activar");
        actionButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        actionButton.setFocusPainted(false);
        actionButton.setBackground(new Color(52, 152, 219));
        actionButton.setForeground(Color.WHITE);
        actionButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        actionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        actionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newWindow.setVisible(false); // Hide the new window

                ReservasBarista nuevaReserva = new ReservasBarista();
                boolean continueMenu = true; // Flag to control the menu loop

                while (continueMenu) {
                    /* Lista Opciones de menu facil manejo */
                    String[] opciones = {"Realizar Reserva", "Modificar Reserva", "Listar Reservas", "Volver al Menú Principal"};
                    int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Barista",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                    switch (opcion) {
                        case 0 ->
                            nuevaReserva.ingresarReserva();
                        case 1 ->
                            nuevaReserva.modificarReserva();
                        case 2 ->
                            nuevaReserva.listarReservas();
                        case 3 ->
                            continueMenu = false; 
                        default ->
                            JOptionPane.showMessageDialog(null, "Opción inválida.");
                    }
                }
                newWindow.setVisible(true); 
            }
        });
        newWindow.add(actionButton, BorderLayout.CENTER);
        newWindow.add(backButton, BorderLayout.SOUTH);

        newWindow.setVisible(true);
        this.setVisible(false);
    }

    public void mostrarVentana() {
        this.setVisible(true);
    }

}
