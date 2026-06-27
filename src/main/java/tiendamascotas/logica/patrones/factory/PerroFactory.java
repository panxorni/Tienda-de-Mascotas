package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Perro;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

public class PerroFactory extends MascotaFactory {
    @Override
    public Mascota crearMascota(String nombre, ObservadorMascotas panel){
        Mascota perro=new Perro(nombre);
        //se conecta la mascota al tiro con el panel
        if (panel != null) {
            perro.agregarObservador(panel);
        }
        /*Inicializar estados de la mascota aquí cuando este implementado el patron state
        Por ejemplo:
        perro.setState(new ...)
        perro.setFelicidad(...)
        perro.setSalud
        entre otros
        * */
        return perro;
    }
}
