package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Pajaro;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

/**
 * Fábrica concreta encargada de crear mascotas de tipo pájaro.
 */
public class PajaroFactory extends MascotaFactory {

    /**
     * Se crea un pájaro con el nombre indicado y se registra el observador
     * de alertas cuando se recibe uno válido.
     * @param nombre El nombre asignado al pájaro.
     * @param panel El observador que recibirá las alertas del pájaro.
     * @return Una nueva instancia de Pajaro como objeto Mascota.
     */
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel){
        Mascota pajaro=new Pajaro(nombre);

        if (panel != null) {
            pajaro.agregarObservador(panel);
        }

        return pajaro;
    }
}
