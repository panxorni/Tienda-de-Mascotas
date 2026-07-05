package tiendamascotas.logica.modelo.mascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TipoMascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

/**
 * Representa un pez dentro de la tienda
 */
public class Pez extends Mascota {
    public Pez(String nombre){
        super(nombre);
    }
    @Override
    public TipoSuministro getTipoComida(){
        return TipoSuministro.COMIDA_PEZ;
    }
    @Override
    public TipoMascota getTipo(){
        return TipoMascota.PEZ;
    }
}
