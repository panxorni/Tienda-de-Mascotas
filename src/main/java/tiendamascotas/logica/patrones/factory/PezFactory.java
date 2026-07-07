package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Pez;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

/**
 * Fábrica concreta encargada de crear mascotas de tipo pez.
 */
public class PezFactory extends MascotaFactory {

    /**
     * Se crea un pez con el nombre indicado y se registra el observador
     * de alertas cuando se recibe uno válido.
     * @param nombre El nombre asignado al pez.
     * @param panel El observador que recibirá las alertas del pez.
     * @return Una nueva instancia de Pez como objeto Mascota.
     */
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel){

        Mascota pez=new Pez(nombre);

        if (panel != null) {
            pez.agregarObservador(panel);
        }

        return pez;
    }
}
