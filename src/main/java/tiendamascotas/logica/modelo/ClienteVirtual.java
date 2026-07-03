package tiendamascotas.logica.modelo;

public class ClienteVirtual {
    private String nombre;
    private TipoMascota tipoMascotaNecesitada;
    private int presupuesto;
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