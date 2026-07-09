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
Problemas encontrados

# Problemas durante el proyecto
Durante el desarrollo del diagrama de casos de uso surgieron algunos problemas principalmente relacionados con la forma de representar las funcionalidades del sistema desde el punto de vista de los actores.

Uno de los primeros problemas fue definir correctamente las relaciones include y extend. Algunas funcionalidades ocurren siempre como parte de otra acción, mientras que otras solamente ocurren bajo una condición determinada. Nos ocurrió este problema al no tener claridad cuando ocupar una o la otra. Por ejemplo, al adquirir una mascota o comprar suministros siempre debe actualizarse el presupuesto, por lo que se utilizó una relación include. En cambio, la notificación de falta de alimento o medicamentos solamente ocurre cuando no existe stock suficiente, por lo que se ocupó una relación extend.

También fue necesario decidir cómo representar al cliente virtual. Como este cliente no es controlado directamente por una persona, inicialmente existieron dudas sobre como crearlo, pero al final se decidió incluirlo de manera que llegara entre un rango de tiempo aleatorio.
# Autocrítica
Como autocrítica, consideramos que el diagrama de casos de uso podría haberse definido con mayor detalle ya que al momento de crearlo no fuimos  lo suficientemente  acertados. 
También otro aspecto de mejoraes el nivel de diseño dentro del proyecto debido a que puede ser implementado de una manera mucho más visual de como la hicimos. Además hacer los actos de salud y comida más utiles a la hora de jugar, puesto que las implementaciones quedaron un poco obsoletas a la hora de que llega un cliente.
# Propuesta de mejora
Como algunas de las propuesta para una experiencia más buena y disfrutable podria ser:
## La creación de razas 
Para que así haya más diversidad de opciones y sea más enteretenido.
## Creación de horarios
Al crear horarios de compra y otros de descanso podrias organizar el stock en almácen mientras la tienda esta cerrada.
## Comportamientos diferentes de los clientes
Ampliar el sistema para que permita tipos de comportamientos distintos del cliente, quizas buscando dos animales o al implementar la creación de razas, dos animales de distinta raza.
