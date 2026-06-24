package tiendamascotas.logica;

public abstract class Mascota {
    protected String nombre;
    protected int felicidad;
    protected int salud;
    protected int hambre;

    public Mascota(String nombre){
        this.nombre=nombre;
        //valores default, se puede cambiar la inicialización cuando se implemente state
        felicidad=100;
        salud=100;
        hambre=0;
    }
    public String getNombre(){
        return nombre;
    }
}
