package tiendamascotas.logica.modelo.mascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TipoMascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

/**
 * Representa un perro dentro de la tienda.
 * Define el tipo de comida y el tipo de mascota que corresponden a esta clase concreta.
 */
public class Perro extends Mascota {

    /**
     * Se inicializa un perro con el nombre indicado.
     * @param nombre El nombre asignado al perro.
     */
    public Perro(String nombre){
        super(nombre);
    }

    /**
     * Se obtiene el tipo de comida que consume el perro.
     * @return El suministro de comida para perro.
     */
    @Override
    public TipoSuministro getTipoComida(){
        return TipoSuministro.COMIDA_PERRO;
    }

    /**
     * Se obtiene el tipo de mascota correspondiente a esta clase.
     * @return El tipo de mascota PERRO.
     */
    @Override
    public TipoMascota getTipo(){
        return TipoMascota.PERRO;
    }
}
