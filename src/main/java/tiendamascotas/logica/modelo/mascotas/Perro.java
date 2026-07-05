package tiendamascotas.logica.modelo.mascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TipoMascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

/**
 * Representa un perro dentro de la tienda
 */
public class Perro extends Mascota {
    public Perro(String nombre){
        super(nombre);
    }
    @Override
    public TipoSuministro getTipoComida(){
        return TipoSuministro.COMIDA_PERRO;
    }
    @Override
    public TipoMascota getTipo(){
        return TipoMascota.PERRO;
    }
}
