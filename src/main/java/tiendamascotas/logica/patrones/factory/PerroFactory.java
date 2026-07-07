package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Perro;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

/**
 * Fábrica concreta encargada de crear mascotas de tipo perro.
 */
public class PerroFactory extends MascotaFactory {

    /**
     * Se crea un perro con el nombre indicado y se registra el observador
     * de alertas cuando se recibe uno válido.
     * @param nombre El nombre asignado al perro.
     * @param panel El observador que recibirá las alertas del perro.
     * @return Una nueva instancia de Perro como objeto Mascota.
     */
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel){
        Mascota perro=new Perro(nombre);

        if (panel != null) {
            perro.agregarObservador(panel);
        }

        return perro;
    }
}
