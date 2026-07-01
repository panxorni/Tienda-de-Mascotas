package tiendamascotas.logica.modelo.mascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;

public class Pajaro extends Mascota {
    public Pajaro(String nombre){
        super(nombre);
    }
    @Override
    public TipoSuministro getTipoComida(){
        return TipoSuministro.COMIDA_PAJARO;
    }
}
