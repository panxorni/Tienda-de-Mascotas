package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Gato;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

/**
 * Fábrica concreta encargada de crear mascotas de tipo gato.
 */
public class GatoFactory extends MascotaFactory {

    /**
     * Se crea un gato con el nombre indicado y se registra el observador
     * de alertas cuando se recibe uno válido.
     * @param nombre El nombre asignado al gato.
     * @param panel El observador que recibirá las alertas del gato.
     * @return Una nueva instancia de Gato como objeto Mascota.
     */
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel) {
        Mascota gato = new Gato(nombre);

        if (panel != null) {
            gato.agregarObservador(panel);
        }

        return gato;
    }
}
