package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Gato;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

public class GatoFactory extends MascotaFactory {
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel) {
        Mascota gato = new Gato(nombre);

        //se conecta la mascota al tiro con el panel
        if (panel != null) {
            gato.agregarObservador(panel);
        }
        /*Inicializar estados de la mascota aquí cuando este implementado el patron state
        Por ejemplo:
        gato.setState(new ...)

        gato.setSalud
        entre otros
        * */
        return gato;
    }
}
