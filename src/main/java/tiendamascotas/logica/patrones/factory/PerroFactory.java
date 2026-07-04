package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Perro;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

public class PerroFactory extends MascotaFactory {
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel){
        Mascota perro=new Perro(nombre);

        if (panel != null) {
            perro.agregarObservador(panel);
        }

        return perro;
    }
}
