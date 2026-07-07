package tiendamascotas.logica.modelo.suministros;

import java.util.EnumMap;
import java.util.Map;

/**
 * Clase que representa el inventario de suministros de la tienda.
 * Guarda la cantidad disponible de cada TipoSuministro y permite
 * consultar, agregar o consumir unidades del stock.
 */
public class Inventario {
    private Map<TipoSuministro, Integer> suministros;

    /**
     * Se inicializa el inventario con todos los tipos de suministro registrados
     * y con cantidad inicial igual a cero.
     */
    public Inventario(){
        suministros = new EnumMap<>(TipoSuministro.class);

        for (TipoSuministro tipo: TipoSuministro.values()){
            suministros.put(tipo, 0);
        }
    }

    /**
     * Se consulta la cantidad disponible de un tipo de suministro.
     * @param tipo El tipo de suministro que se desea consultar.
     * @return La cantidad disponible del suministro indicado.
     */
    public int consultarCantidad(TipoSuministro tipo){
        return suministros.getOrDefault(tipo, 0);
    }

    /**
     * Se agregan unidades de un suministro al inventario.
     * @param tipo El tipo de suministro que se agregará.
     * @param cantidad La cantidad de unidades que se sumará al stock.
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
     * Se consumen unidades de un suministro y se descuentan del inventario.
     * @param tipo El tipo de suministro que se usará.
     * @param cantidad La cantidad de unidades que se descontará del stock.
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
     * Se obtiene una copia del inventario actual.
     * De esta forma, el stock interno no puede modificarse directamente desde fuera.
     * @return Un mapa con los tipos de suministro y sus cantidades disponibles.
     */
    public Map<TipoSuministro, Integer> getSuministros(){
        return new EnumMap<>(suministros);
    }
}
