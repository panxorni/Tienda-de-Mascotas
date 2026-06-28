package tiendamascotas.logica.modelo;
import tiendamascotas.logica.patrones.observer.SujetoObservable;
import tiendamascotas.logica.patrones.state.EstadoMascota;
import tiendamascotas.logica.patrones.state.EstadoSaludable;

public abstract class Mascota extends SujetoObservable {
    private String nombre;
    private EstadoMascota estado;
    private int felicidad;
    private int salud;
    private int hambre;

    public Mascota(String nombre){

        this.nombre=nombre;
        this.estado= new EstadoSaludable();
        this.felicidad = 100; // Nace feliz
        this.salud = 100;     // Nace con salud max
        this.hambre = 0;      // Nace sin hambre
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



    public int getSalud(){
        return salud;
    }



    public int getHambre(){
        return hambre;
    }


    public void setFelicidad(int felicidad){
        this.felicidad = felicidad;
        // Detonante de aburrimiento/tristeza
        if (this.felicidad < 30) {
            notificarObservadores(this.nombre, "Aburrimiento", "¡" + this.nombre + " está muy triste y necesita jugar!");
        }
    }

    public void setSalud(int salud){
        this.salud = salud;
        // Detonante de enfermedad
        if (this.salud < 40) {
            notificarObservadores(this.nombre, "Enfermedad", "¡La salud de " + this.nombre + " está bajando! Necesita medicina.");
        }
    }

    public void setHambre(int hambre){
        this.hambre = hambre;
        // Detonante de hambre
        if (this.hambre > 80) {
            notificarObservadores(this.nombre, "Hambre", "¡" + this.nombre + " tiene mucha hambre!");
        }
    }
}
