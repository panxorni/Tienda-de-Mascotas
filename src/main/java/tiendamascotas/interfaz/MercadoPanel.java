package tiendamascotas.interfaz;

import javax.swing.*;
import java.awt.*;

public class MercadoPanel extends JPanel {

    // 1. Se declaran los botones de las Mascotas
    private JButton btnComprarPerro;
    private JButton btnComprarGato;
    private JButton btnComprarPajaro;
    private JButton btnComprarPez;

    // 2. Se declaran los botones de los Suministros
    private JButton btnComprarComidaPerro;
    private JButton btnComprarComidaGato;
    private JButton btnComprarComidaPajaro;
    private JButton btnComprarComidaPez;
    private JButton btnComprarMedicina;

    public MercadoPanel() {
        // Se configura el panel principal del mercado
        setLayout(new BorderLayout(0, 10));
        setBorder(BorderFactory.createTitledBorder("Mercado Proveedor"));

        // Se construyen las dos mitades del mercado
        crearSeccionMascotas();
        crearSeccionSuministros();
    }

    private void crearSeccionMascotas() {
        JPanel panelMascotas = new JPanel(new GridLayout(2, 2, 5, 5));
        panelMascotas.setBorder(BorderFactory.createTitledBorder("Catálogo de Animales"));

        btnComprarPerro = new JButton("Perro ($500)");
        btnComprarGato = new JButton("Gato ($450)");
        btnComprarPajaro = new JButton("Pájaro ($300)");
        btnComprarPez = new JButton("Pez ($150)");

        panelMascotas.add(btnComprarPerro);
        panelMascotas.add(btnComprarGato);
        panelMascotas.add(btnComprarPajaro);
        panelMascotas.add(btnComprarPez);

        // Se agrega esta sección a la parte superior (Norte) del MercadoPanel
        add(panelMascotas, BorderLayout.NORTH);
    }

    private void crearSeccionSuministros() {
        JPanel panelSuministros = new JPanel(new GridLayout(3, 2, 5, 5));
        panelSuministros.setBorder(BorderFactory.createTitledBorder("Catálogo de Suministros"));

        btnComprarComidaPerro = new JButton("Comida Perro");
        btnComprarComidaGato = new JButton("Comida Gato");
        btnComprarComidaPajaro = new JButton("Comida Pájaro");
        btnComprarComidaPez = new JButton("Comida Pez");
        btnComprarMedicina = new JButton("Medicamento");

        panelSuministros.add(btnComprarComidaPerro);
        panelSuministros.add(btnComprarComidaGato);
        panelSuministros.add(btnComprarComidaPajaro);
        panelSuministros.add(btnComprarComidaPez);
        panelSuministros.add(btnComprarMedicina);

        // Se agrega esta sección al Centro del MercadoPanel
        add(panelSuministros, BorderLayout.CENTER);
    }

    // --- GETTERS ---
    // Se utilizan para que la ventana principal exponga estos botones al Controlador

    public JButton getBtnComprarPerro() { return btnComprarPerro; }
    public JButton getBtnComprarGato() { return btnComprarGato; }
    public JButton getBtnComprarPajaro() { return btnComprarPajaro; }
    public JButton getBtnComprarPez() { return btnComprarPez; }

    public JButton getBtnComprarComidaPerro() { return btnComprarComidaPerro; }
    public JButton getBtnComprarComidaGato() { return btnComprarComidaGato; }
    public JButton getBtnComprarComidaPajaro() { return btnComprarComidaPajaro; }
    public JButton getBtnComprarComidaPez() { return btnComprarComidaPez; }
    public JButton getBtnComprarMedicina() { return btnComprarMedicina; }
}