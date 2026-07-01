package tiendamascotas.logica.modelo;
import tiendamascotas.logica.patrones.observer.SujetoObservable;
import tiendamascotas.logica.patrones.state.EstadoFeliz;
import tiendamascotas.logica.patrones.state.EstadoHambriento;
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
//Metodo para alimentar
    public void alimentar(){
        setHambre(hambre - 30);
        setFelicidad(felicidad + 10);
    }
//Metodo de juego, si no puede jugar notifica al observer, de lo contrario actualiza los atributos correspondientes
    public void jugar(){
        if (!estado.puedeJugar()){
            notificarObservadores(nombre, "Juego", nombre + "no quiere jugar ahora.");
            return;
        }
        setFelicidad(felicidad + 15);
        setHambre(hambre + 10);
    }
//Metodo para limpiar el habitat de una mascota
    public void limpiarHabitat(){
        setSalud(salud + 10);
        setFelicidad(felicidad + 5);
    }
//Metodo para dar medicina
    public void darMedicina(){
        setSalud(salud + 25);
        setFelicidad(felicidad - 5);
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
        this.felicidad = limitar(felicidad);
        // Detonante de aburrimiento/tristeza
        if (this.felicidad < 30) {
            notificarObservadores(this.nombre, "Aburrimiento", "¡" + this.nombre + " está muy triste y necesita jugar!");
        }
    }

    public void setSalud(int salud){
        this.salud = limitar(salud);
        // Detonante de enfermedad
        if (this.salud < 40) {
            notificarObservadores(this.nombre, "Enfermedad", "¡La salud de " + this.nombre + " está bajando! Necesita medicina.");
        }
    }

    public void setHambre(int hambre){
        this.hambre = limitar(hambre);
        // Detonante de hambre
        if (this.hambre > 80) {
            notificarObservadores(this.nombre, "Hambre", "¡" + this.nombre + " tiene mucha hambre!");
        }
    }
    //Metodo para actualizar el estado despues de cada accion
    private void actualizarEstado(){
        if(hambre>70){
            estado = new EstadoHambriento();
        } else if (felicidad > 75 && salud > 60) {
            estado = new EstadoFeliz();
        } else {
            estado = new EstadoSaludable();
        }
    }
    //Metodo para limitar valores de atributos entre 0 a 100
    private int limitar(int valor) {
        if (valor < 0){
            return 0;
        }
        if (valor > 100){
            return 100;
        }
        return valor;
    }
}
