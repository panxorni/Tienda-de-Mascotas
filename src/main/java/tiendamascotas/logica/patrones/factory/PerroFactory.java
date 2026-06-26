package tiendamascotas.logica.patrones.factory;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.mascotas.Perro;

public class PerroFactory extends MascotaFactory {
    @Override
    public Mascota crearMascota(String nombre){
        Mascota perro=new Perro(nombre);
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
