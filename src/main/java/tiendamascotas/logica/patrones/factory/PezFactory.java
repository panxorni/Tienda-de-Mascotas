package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Pez;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

public class PezFactory extends MascotaFactory {
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel){

        Mascota pez=new Pez(nombre);
        //se conecta la mascota al tiro con el panel
        if (panel != null) {
            pez.agregarObservador(panel);
        }
        /*Inicializar estados de la mascota aquí cuando este implementado el patron state
        Por ejemplo:
        pez.setState(new ...)
        pez.setFelicidad(...)
        pez.setSalud
        entre otros
        * */
        return pez;
    }
}
