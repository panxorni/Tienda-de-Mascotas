package tiendamascotas;

import tiendamascotas.logica.modelo.Mascota;
import tiendamascotas.logica.modelo.TiendaMascotas;
import tiendamascotas.logica.modelo.suministros.Inventario;
import tiendamascotas.logica.modelo.suministros.TipoSuministro;
import tiendamascotas.logica.patrones.factory.MascotaFactory;
import tiendamascotas.logica.patrones.factory.PerroFactory;
import tiendamascotas.logica.patrones.observer.ObservadorMascotas;

public  class Main {
     public static void main (String[] args){
         TiendaMascotas tienda= new TiendaMascotas(100000);
         MascotaFactory perroFactory= new PerroFactory();
         Mascota perro= perroFactory.crearMascota("kota ", null);
         tienda.comprarMascota(perro, 20000);
         tienda.comprarSuministro(TipoSuministro.COMIDA_PERRO ,5, 2500 );
         System.out.println("Presupuesto después de compras: " + tienda.getPresupuesto());
         System.out.println("cantidad de mascotas: " + tienda.getMascotas().size());
         System.out.println("cantidad de alimento: " + tienda.getInventario().consultarCantidad(TipoSuministro.COMIDA_PERRO));

         /* Antes de los cambios se tenia que hacer esto, pero ahora se puede hacer lo siguiente
         tienda.usarSuministro(TipoSuministro.COMIDA_PERRO, 1);
         perro.alimentar();
          */
         tienda.alimentarMascota(perro, TipoSuministro.COMIDA_PERRO);

        System.out.println();
        System.out.println();

        System.out.println("Después de alimentar a la mascota:");
        System.out.println("Comida sobrante: "+ tienda.getInventario().consultarCantidad(TipoSuministro.COMIDA_PERRO));
        System.out.println("nombre del pug: " + perro.getNombre());
        System.out.println("estado de mascota: " + perro.getEstado().getNombre());
        System.out.println("hambre: " + perro.getHambre());
        System.out.println("salud: " + perro.getSalud());
        System.out.println("felicidad: " + perro.getFelicidad());
     }
}