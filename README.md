# Tienda-de-Mascotas
Para este proyecto se eligieron tres patrones de diseños que entraban bien en la estructura del proyecto, los cuales son:

-Factory
-State
-Observer

## 1.- Factory
Primero se eligio este patron de diseño para crear diferentes tipos de mascotas, en este caso: perros, gatos, pajaros y peces.
Gracias a este patron nos ahorramos la creación de los "new Perro()".
Este patron se utiliza cuando un usuario compra una mascota desde el mercado.
Asi se logra que la creación de mascotas quede fuera de la logica del controlador

## 2.- State
Este patron se eligio para verificar el estado de los animales dependiendo de las necesidades, hambre, salud o felicidad.
State se utiliza para que cada mascota tenga una referencia a su estaado actual.
Implementamos este patron de diseño en "EstadoSaludable", "EstadoFeliz" y "EStadoHambriento".
Y las que clases que participan son: "EstadoMascota" que define el comportamiento general de los estados, "EstadoSaludable", "EstadoFeliz" y "EStadoHambriento" que son los estados concretos y "Mascota" que tiene una referencia a su estado actual.

## 3.- Observer
El último patron fue elegido para crear notificaciones hacia el usuario sobre como esta la mascota, las mascotas actuan como el objeto observable.
Cuando algun atributo tiene un cambio de valor, se hace la notificación.
Participan clases como: "sujeto observable" que administra y notifica a los observadores, "Mascota" la cual es el objeto observable que da las alertas, "ObservadorMascotas" que define el metodo que reciben los observadores y "panelAlertas" el que recibe y muestra notificacioces en la interfaz.
