package tiendamascotas.logica.modelo.mascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TipoMascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

/**
 * Representa un pájaro dentro de la tienda.
 * Define el tipo de comida y el tipo de mascota que corresponden a esta clase concreta.
 */
public class Pajaro extends Mascota {

    /**
     * Se inicializa un pájaro con el nombre indicado.
     * @param nombre El nombre asignado al pájaro.
     */
    public Pajaro(String nombre){
        super(nombre);
    }

    /**
     * Se obtiene el tipo de comida que consume el pájaro.
     * @return El suministro de comida para pájaro.
     */
    @Override
    public TipoSuministro getTipoComida(){
        return TipoSuministro.COMIDA_PAJARO;
    }

    /**
     * Se obtiene el tipo de mascota correspondiente a esta clase.
     * @return El tipo de mascota PAJARO.
     */
    @Override
    public TipoMascota getTipo(){
        return TipoMascota.PAJARO;
    }
}
