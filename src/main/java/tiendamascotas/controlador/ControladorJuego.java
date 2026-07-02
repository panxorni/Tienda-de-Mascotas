package tiendamascotas.controlador;

import tiendamascotas.interfaz.VentanaPrincipal;
import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TiendaMascotas;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;
import tiendamascotas.logica.patrones.factory.*;

import javax.swing.*;

//Esta Clase conecta la interfaz con la logica.
public class ControladorJuego {
    private TiendaMascotas tienda;
    private VentanaPrincipal ventana;

    public ControladorJuego(TiendaMascotas tienda, VentanaPrincipal ventana){
        this.tienda=tienda;
        this.ventana=ventana;

        conectarEventos();
        refrescarPantalla();
    }

    private void conectarEventos(){
        ventana.getMercadoPanel().getBtnComprarPerro().addActionListener(e ->
                comprarMascotaConFactory(new PerroFactory(), "Perro", 500));

        ventana.getMercadoPanel().getBtnComprarGato().addActionListener(e ->
                comprarMascotaConFactory(new GatoFactory(), "Gato", 450));

        ventana.getMercadoPanel().getBtnComprarPajaro().addActionListener(e ->
                comprarMascotaConFactory(new PajaroFactory(), "Pajaro", 300));

        ventana.getMercadoPanel().getBtnComprarPez().addActionListener(e ->
                comprarMascotaConFactory(new PezFactory(), "Pez", 150));

        ventana.getMercadoPanel().getBtnComprarComidaPerro().addActionListener(e ->
                comprarSuministro(TipoSuministro.COMIDA_PERRO, 1, 100));

        ventana.getMercadoPanel().getBtnComprarComidaGato().addActionListener(e ->
                comprarSuministro(TipoSuministro.COMIDA_GATO, 1, 100));

        ventana.getMercadoPanel().getBtnComprarComidaPajaro().addActionListener(e ->
                comprarSuministro(TipoSuministro.COMIDA_PAJARO, 1, 80));

        ventana.getMercadoPanel().getBtnComprarComidaPez().addActionListener(e ->
                comprarSuministro(TipoSuministro.COMIDA_PEZ, 1, 50));

        ventana.getMercadoPanel().getBtnComprarMedicina().addActionListener(e ->
                comprarSuministro(TipoSuministro.MEDICAMENTOS, 1, 200));
    }

    private void comprarMascotaConFactory(MascotaFactory factory, String tipoMascota, int precio){
        try{
            String nombre = JOptionPane.showInputDialog(
                    ventana,
                    "Ingrese el nombre del " + tipoMascota + ":"
            );

            if (nombre ==null || nombre.trim().isEmpty()){
                return;
            }

            Mascota mascota = factory.crearMascota(nombre.trim(), ventana.getPanelAlertas());

            tienda.comprarMascota(mascota, precio);

            refrescarPantalla();
        }catch (Exception e){
            mostrarError(e.getMessage());
        }
    }

    private void comprarSuministro(TipoSuministro tipoSuministro, int cantidad, int precioPorUnidad){
        try{
            tienda.comprarSuministro(tipoSuministro, cantidad, precioPorUnidad);

            refrescarPantalla();
        }catch (Exception e){
            mostrarError(e.getMessage());
        }
    }

    private void refrescarPantalla(){
        ventana.actualizarPresupuesto(tienda.getPresupuesto());

        ventana.getInventarioPanel().actualizarStockSuministros(tienda.getInventario().getSuministros());

        ventana.getInventarioPanel().refrescarListaMascotas(tienda.getMascotas());
    }

    private void mostrarError(String mensaje){
        JOptionPane.showMessageDialog(
                ventana,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
