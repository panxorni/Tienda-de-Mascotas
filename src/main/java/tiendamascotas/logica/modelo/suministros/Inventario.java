package tiendamascotas.logica.modelo.suministros;

import java.util.EnumMap;
import java.util.Map;

/**
 * Esta clase representa el inventario de la tienda, con sus suministros
 * y guarda la cantidad disponible de cada suministro
 */
public class Inventario {
    private Map<TipoSuministro, Integer> suministros;

    /**
     * Se crea el inventario
     */
    public Inventario(){
        suministros = new EnumMap<>(TipoSuministro.class);

        for (TipoSuministro tipo: TipoSuministro.values()){
            suministros.put(tipo, 0);
        }
    }

    /**
     * Consulta la cantidad de un tipo de suministros que hay
     */
    public int consultarCantidad(TipoSuministro tipo){
        return suministros.getOrDefault(tipo, 0);
    }

    /**
     * Agrega al inventario los suministros del tipo que se agreguen
     */
    public void agregarSuministro(TipoSuministro tipo, int cantidad){
        if(cantidad<=0){
            throw new IllegalArgumentException("La cantidad de suministro agregada debe ser mayor que 0 ");
        }
        int cantidadActual= consultarCantidad(tipo);
        int cantidadFinal= cantidadActual+ cantidad;
        suministros.put(tipo, cantidadFinal);
    }

    /**
     * Este metodo usa una cantidad de suministro y lo resta de lo que tenia inicialmente
     */
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

    /**
     * Devuelve una copia del inventario, hace que el stock interno no se cambie
     */
    public Map<TipoSuministro, Integer> getSuministros(){
        return new EnumMap<>(suministros);
    }
}