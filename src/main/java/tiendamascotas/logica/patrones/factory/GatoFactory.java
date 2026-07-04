package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Gato;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

public class GatoFactory extends MascotaFactory {
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel) {
        Mascota gato = new Gato(nombre);

        //se conecta la mascota altiro con el panel
        if (panel != null) {
            gato.agregarObservador(panel);
        }

        return gato;
    }
}
