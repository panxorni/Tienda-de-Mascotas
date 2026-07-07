package tiendamascotas.logica.modelo.mascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TipoMascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

/**
 * Representa un gato dentro de la tienda.
 * Define el tipo de comida y el tipo de mascota que corresponden a esta clase concreta.
 */
public class Gato extends Mascota {

    /**
     * Se inicializa un gato con el nombre indicado.
     * @param nombre El nombre asignado al gato.
     */
    public Gato(String nombre){
        super(nombre);
    }

    /**
     * Se obtiene el tipo de comida que consume el gato.
     * @return El suministro de comida para gato.
     */
    @Override
    public TipoSuministro getTipoComida(){
        return TipoSuministro.COMIDA_GATO;
    }

    /**
     * Se obtiene el tipo de mascota correspondiente a esta clase.
     * @return El tipo de mascota GATO.
     */
    @Override
    public TipoMascota getTipo(){
        return TipoMascota.GATO;
    }
}
