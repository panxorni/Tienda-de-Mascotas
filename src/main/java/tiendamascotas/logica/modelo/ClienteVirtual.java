package tiendamascotas.logica.modelo;

/*
Esta clase representa un cliente consultando por algun animal de la tienda
 */

public class ClienteVirtual {
    private String nombre;
    private TipoMascota tipoMascotaNecesitada;
    private int presupuesto;

    /**
     * Aquí crea el cliente con su nombre,
     * tipo de mascota que busca y presupuesto para comprar
     */

    public ClienteVirtual(String nombre, TipoMascota tipoMascotaNecesitada, int presupuesto){
        if(nombre== null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("el nombre no puede ser vacio");
        }
        if (tipoMascotaNecesitada == null) {
            throw new IllegalArgumentException("debe existir un tipo de mascota que se requiere");
        }
        if (presupuesto < 0) {
            throw  new IllegalArgumentException("el presupuesto no puede ser negativo");
        }
        this.nombre= nombre;
        this.tipoMascotaNecesitada= tipoMascotaNecesitada;
        this.presupuesto= presupuesto;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public TipoMascota getTipoMascotaNecesitada() {
        return tipoMascotaNecesitada;
    }

    public String getNombre() {
        return nombre;
    }
}