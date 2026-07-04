package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Pajaro;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

public class PajaroFactory extends MascotaFactory {
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel){
        Mascota pajaro=new Pajaro(nombre);
        //se conecta la mascota altiro con el panel
        if (panel != null) {
            pajaro.agregarObservador(panel);
        }

        return pajaro;
    }
}
