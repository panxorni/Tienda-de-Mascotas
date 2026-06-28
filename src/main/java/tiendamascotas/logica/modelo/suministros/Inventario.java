package tiendamascotas.logica.modelo.suministros;

import java.util.EnumMap;
import java.util.Map;

public class Inventario {
    private Map<TipoSuministro, Integer> suministros;

    public Inventario(){
        suministros = new EnumMap<>(TipoSuministro.class);

        for (TipoSuministro tipo: TipoSuministro.values()){
            suministros.put(tipo, 0);
        }
    }

    public int consultarCantidad(TipoSuministro tipo){
        return suministros.getOrDefault(tipo, 0);
    }

    public void agregarSuministro(TipoSuministro tipo, int cantidad){
        if(cantidad<=0){
            throw new IllegalArgumentException("La cantidad de suministro agregada debe ser mayor que 0 ");
        }
        int cantidadActual= consultarCantidad(tipo);
        int cantidadFinal= cantidadActual+ cantidad;
        suministros.put(tipo, cantidadFinal);
    }

    public void usarSuministro(TipoSuministro tipo, int cantidad){
        if(cantidad <=0){
            throw  new IllegalArgumentException("La cantidad de suministro usada debe ser mayor que 0");
        }
        int cantidadActual= consultarCantidad(tipo);

        if(cantidadActual < cantidad){
            throw  new IllegalStateException("No hay esa cantidad de "+ tipo);
        }
        int cantidadFinal= cantidadActual- cantidad;
        suministros.put(tipo, cantidadFinal);
    }

    public Map<TipoSuministro, Integer> getSuministros(){
        return new EnumMap<>(suministros);
    }
}