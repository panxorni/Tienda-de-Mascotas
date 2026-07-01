package tiendamascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TiendaMascotas;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;
import tiendamascotas.logica.patrones.factory.MascotaFactory;
import tiendamascotas.logica.patrones.factory.PerroFactory;


public  class Main {
     public static void main (String[] args){
         TiendaMascotas tienda= new TiendaMascotas(100000);
         MascotaFactory perroFactory= new PerroFactory();
         Mascota perro= perroFactory.crearMascota("kota ", null);
         Mascota perro2= perroFactory.crearMascota("PruebaVenta", null);
         tienda.comprarMascota(perro, 20000);
         tienda.comprarMascota(perro2, 20000);
         tienda.comprarSuministro(TipoSuministro.COMIDA_PERRO ,5, 2500 );
         tienda.comprarSuministro(TipoSuministro.MEDICAMENTOS, 2, 5000);

         imprimirTienda(tienda);
         imprimirMascota(perro);

         System.out.println("\nJugando con la mascota...");
         tienda.jugarConMascota(perro);
         imprimirMascota(perro);

         System.out.println("\nAlimentando a la mascota...");
         tienda.alimentarMascota(perro);
         imprimirTienda(tienda);
         imprimirMascota(perro);

         System.out.println("\nLimpiando habitat...");
         tienda.limpiarHabitat(perro);
         imprimirMascota(perro);

         System.out.println("\nDando medicina...");
         tienda.darMedicina(perro);
         imprimirTienda(tienda);
         imprimirMascota(perro);

         System.out.println("\nVendiendo mascota...");
         tienda.venderMascota(perro2, 30000);
         imprimirTienda(tienda);
     }

    private static void imprimirTienda(TiendaMascotas tienda) {
        System.out.println("Presupuesto: " + tienda.getPresupuesto());
        System.out.println("Cantidad de mascotas: " + tienda.getMascotas().size());
        System.out.println("Comida perro: " + tienda.getInventario().consultarCantidad(TipoSuministro.COMIDA_PERRO));
        System.out.println("Medicamentos: " + tienda.getInventario().consultarCantidad(TipoSuministro.MEDICAMENTOS));
    }

    private static void imprimirMascota(Mascota mascota) {
        System.out.println("Mascota: " + mascota.getNombre());
        System.out.println("Estado: " + mascota.getEstado().getNombre());
        System.out.println("Hambre: " + mascota.getHambre());
        System.out.println("Salud: " + mascota.getSalud());
        System.out.println("Felicidad: " + mascota.getFelicidad());
    }
}