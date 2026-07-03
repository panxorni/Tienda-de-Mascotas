package tiendamascotas.logica.modelo.mascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TipoMascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

public class Gato extends Mascota {
    public Gato(String nombre){
        super(nombre);
    }
    @Override
    public TipoSuministro getTipoComida(){
        return TipoSuministro.COMIDA_GATO;
    }
    @Override
    public TipoMascota getTipo(){
        return TipoMascota.GATO;
    }
}
