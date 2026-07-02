package tiendamascotas;

import tiendamascotas.controlador.ControladorJuego;
import tiendamascotas.interfaz.VentanaPrincipal;
import tiendamascotas.logica.modelo.TiendaMascotas;
import javax.swing.*;


public  class Main {
     public static void main (String[] args){
         SwingUtilities.invokeLater(() -> {
             TiendaMascotas tienda = new TiendaMascotas(100000);
             VentanaPrincipal ventana = new VentanaPrincipal();

             //new ControladorJuego(tienda, ventana);

             ventana.setVisible(true);
         });
     }
}