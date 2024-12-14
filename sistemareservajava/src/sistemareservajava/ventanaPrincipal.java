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

    ReservasBarista nueva = new ReservasBarista();
    // Atributos de clase para los campos de entrada
    private JTextField empleadoField;
    private JTextField idEmpleadoField;
    private JTextField bebidaReservadaField;
    private JButton seleccionBebidaButton;
    private boolean[] bebidaSeleccionada = {false};
    private String path = "{Modificar con path de images}";
    public ventanaPrincipal(String titulo) {
        super(titulo);
        // Configuración de la ventana principal
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Panel principal 
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 20, 20));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelBotones.setBackground(new Color(240, 240, 240));

        // Crear botones con estilo
        // Recuerda localizar el lugar donde este la imagen
        JButton botonCine = crearBotonConIcono("Cine", new Color(52, 152, 219), path+"film-reel.png");
        JButton botonGimnasio = crearBotonConIcono("Gimnasio", new Color(46, 204, 113), path+"muscle.png");
        JButton botonActividad = crearBotonConIcono("Baile/Yoga", new Color(241, 196, 15), path+"yoga-pose.png");
        JButton botonBebidas = crearBotonConIcono("Bebidas", new Color(231, 76, 60), path+"juicer.png");

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

    private JButton crearBotonConIcono(String texto, Color colorFondo, String rutaImagen) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.BOLD, 18));
        boton.setFocusPainted(false);
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createLineBorder(colorFondo.darker(), 2));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Cargar la imagen desde la ruta
        try {
            ImageIcon icon = new ImageIcon(new ImageIcon(rutaImagen).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            boton.setIcon(icon);
            boton.setHorizontalTextPosition(SwingConstants.CENTER);
            boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen para el botón: " + texto);
        }

        return boton;
    }

    private void openNewWindow(String title) {
        // Crear la nueva ventana
        JFrame newWindow = new JFrame(title);
        newWindow.setSize(800, 600);
        newWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newWindow.setLayout(new BorderLayout());

        // Configuración del título
        JLabel titleLabel = createTitleLabel("Sección: " + title);
        newWindow.add(titleLabel, BorderLayout.NORTH);

        // Panel central con los campos de entrada
        JPanel inputPanel = createInputPanel();
        newWindow.add(inputPanel, BorderLayout.CENTER);

        // Panel inferior con los botones
        JPanel buttonPanel = createButtonPanel(newWindow);
        newWindow.add(buttonPanel, BorderLayout.SOUTH);

        // Mostrar la nueva ventana
        newWindow.setVisible(true);
        this.setVisible(false); // Ocultar la ventana principal
    }

    /*
     Crear el JLabel para el título de la ventana.
     */
    private JLabel createTitleLabel(String text) {
        JLabel titleLabel = new JLabel(text, SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(231, 76, 60));
        return titleLabel;
    }

    /*
     Crear el panel de entrada con los campos de texto.
     */
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 rows, 2 columns
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Fields for input
        inputPanel.add(new JLabel("Empleado:"));
        empleadoField = new JTextField(); // Inicializar como atributo de clase
        inputPanel.add(empleadoField);

        inputPanel.add(new JLabel("ID Empleado:"));
        idEmpleadoField = new JTextField(); // Inicializar como atributo de clase
        inputPanel.add(idEmpleadoField);

        inputPanel.add(new JLabel("Bebida Reservada:"));
        bebidaReservadaField = new JTextField(); // Inicializar como atributo de clase
        bebidaReservadaField.setEditable(false);
        inputPanel.add(bebidaReservadaField);

        inputPanel.add(new JLabel("ID Bebida Reservada:"));
        seleccionBebidaButton = new JButton("Seleccionar Bebida"); // Asignar al atributo de clase

        seleccionBebidaButton.addActionListener(e -> {
            if (!bebidaSeleccionada[0]) {
                String seleccion = nueva.seleccionBebida();
                bebidaReservadaField.setText(seleccion);
                bebidaSeleccionada[0] = true;  // Marcar como seleccionada
                seleccionBebidaButton.setEnabled(false); // Deshabilitar el botón después de la selección
            } else {
                JOptionPane.showMessageDialog(inputPanel, "Ya has seleccionado una bebida.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        inputPanel.add(seleccionBebidaButton);

        return inputPanel;
    }

    // Método para limpiar los campos
    private void limpiarCampos() {
        empleadoField.setText(""); // Limpia caja de texto
        idEmpleadoField.setText(""); // Limpia caja de texto
        bebidaReservadaField.setText(""); // Limpia caja de texto
        bebidaReservadaField.setEditable(false); // Asegurar que no sea editable después de limpiar
        seleccionBebidaButton.setEnabled(true); // Vuelve disponible el boton de bebidas 
        bebidaSeleccionada[0] = false; // Limpia bebidas a default 
    }

    private JPanel createButtonPanel(JFrame newWindow) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Botón para ingresar una nueva reserva
        JButton ingresarReservaButton = createButton("Hacer Reserva", new Color(231, 76, 60), e -> {
            // Capturar valores desde los campos de entrada
            String empleado = empleadoField.getText();
            String idEmpleado = idEmpleadoField.getText();
            String bebidaReservada = bebidaReservadaField.getText();

            // Validar que los campos no estén vacíos
            if (empleado.isEmpty() || idEmpleado.isEmpty() || bebidaReservada.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Llamar al método con los valores ingresados
            nueva.ingresarReservaV2(empleado, idEmpleado, bebidaReservada);
            JOptionPane.showMessageDialog(null, "Reserva realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            /*
            Limpiar los campos
             */
            limpiarCampos();
        });

        // Botón para listar reservas
        JButton listarReservaButton = createButton("Listar Reservas", new Color(231, 76, 60), e -> {
            nueva.listarReservas(); // Llama al método para listar reservas
        });

        // Botón para modificar reservas
        JButton modifyButton = createButton("Modificar Reserva", new Color(231, 76, 60), e -> {
            nueva.modificarReserva();
        });

        // Botón para regresar al menú principal
        JButton backButton = createButton("Volver al Menú Principal", new Color(231, 76, 60), e -> {
            newWindow.dispose(); // Cerrar la ventana actual
            this.setVisible(true); // Volver a mostrar la ventana principal
        });

        // Agregar botones al panel
        buttonPanel.add(ingresarReservaButton);
        buttonPanel.add(listarReservaButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(backButton);

        return buttonPanel;
    }

    /*
  Método auxiliar para crear un botón con estilo uniforme.
     */
    private JButton createButton(String text, Color backgroundColor, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(actionListener);
        return button;
    }

    public void mostrarVentana() {
        this.setVisible(true);
    }

}
