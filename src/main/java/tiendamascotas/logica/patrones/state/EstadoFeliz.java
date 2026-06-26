package tiendamascotas.logica.patrones.state;

import tiendamascotas.logica.modelo.Mascota;

public class EstadoFeliz implements EstadoMascota{
    @Override
    public void alimentar(Mascota mascota){
        System.out.println(mascota.getNombre()+ " no tiene hambre.");
    }

    @Override
    public void jugar(Mascota mascota){
        System.out.println(mascota.getNombre()+ " juega.");
    }

    @Override
    public String getNombre(){
        return "Feliz";
    }

    @Override
    public boolean puedeVenderse() {
        return true;
    }

    @Override
    public String getDescripcion() {
        return "La mascota esta feliz";
    }

    @Override
    public boolean puedeJugar() {
        return true;
    }
}