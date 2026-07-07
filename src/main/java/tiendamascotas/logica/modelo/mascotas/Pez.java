package tiendamascotas.logica.modelo.mascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TipoMascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

/**
 * Representa un pez dentro de la tienda.
 * Define el tipo de comida y el tipo de mascota que corresponden a esta clase concreta.
 */
public class Pez extends Mascota {

    /**
     * Se inicializa un pez con el nombre indicado.
     * @param nombre El nombre asignado al pez.
     */
    public Pez(String nombre){
        super(nombre);
    }

    /**
     * Se obtiene el tipo de comida que consume el pez.
     * @return El suministro de comida para pez.
     */
    @Override
    public TipoSuministro getTipoComida(){
        return TipoSuministro.COMIDA_PEZ;
    }

    /**
     * Se obtiene el tipo de mascota correspondiente a esta clase.
     * @return El tipo de mascota PEZ.
     */
    @Override
    public TipoMascota getTipo(){
        return TipoMascota.PEZ;
    }
}
