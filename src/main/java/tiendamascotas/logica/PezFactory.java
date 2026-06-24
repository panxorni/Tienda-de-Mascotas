package tiendamascotas.logica;

public class PezFactory extends MascotaFactory{
    @Override
    public Mascota crearMascota(String nombre){
        Mascota pez=new Pez(nombre);
        /*Inicializar estados de la mascota aquí cuando este implementado el patron state
        Por ejemplo:
        pez.setState(new ...)
        pez.setFelicidad(...)
        pez.setSalud
        entre otros
        * */
        return pez;
    }
}
