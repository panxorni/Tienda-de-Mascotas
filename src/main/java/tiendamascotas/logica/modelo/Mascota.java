package tiendamascotas.logica.modelo;
import tiendamascotas.logica.patrones.observer.SujetoObservable;
import tiendamascotas.logica.patrones.state.EstadoMascota;

public abstract class Mascota extends SujetoObservable {
    private String nombre;
    private EstadoMascota estado;
    private int felicidad;
    private int salud;
    private int hambre;

    public Mascota(String nombre){
        this.nombre=nombre;
    }

    public void alimentar(){
        estado.alimentar(this);
    }

    public void jugar(){
        estado.jugar(this);
    }

    public void setEstado(EstadoMascota estado){
        this.estado=estado;
    }

    public EstadoMascota getEstado(){
        return estado;
    }

    public String getNombre(){
        return nombre;
    }

    public int getFelicidad(){
        return felicidad;
    }

    public void setFelicidad(int felicidad){
        this.felicidad=felicidad;
    }

    public int getSalud(){
        return salud;
    }

    public void setSalud(int salud){
        this.salud=salud;
    }

    public int getHambre(){
        return hambre;
    }

    public void setHambre(int hambre){
        this.hambre=hambre;
    }
}
