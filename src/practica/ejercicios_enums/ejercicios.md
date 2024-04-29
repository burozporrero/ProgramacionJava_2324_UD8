# ENUM

## Ejercicio: Niveles de juego
Crea un enum llamado NivelJuego que represente los niveles de un videojuego: Principiante, Intermedio, Avanzado.

Crea un enum llamado EstadoJuego que represente los diferentes estados de un juego: INICIADO, EN_PROGRESO, PAUSADO, 
TERMINADO.  

Crea los siguientes métodos:

- esAvanzado() que devuelva true si el nivel es Avanzado, y false en caso contrario. 
- mostrarEstado() que muestre por consola información del estado actual del juego. Por ejemplo, si el estado es 
  INICIADO, el método podría imprimir "El juego se ha iniciado". 
 
Crea un programa básico que verifique que las clases generadas y sus métodos funcionan correctamente.

## Ejercicio: Valor de cartas

Imagina que estás desarrollando un juego de cartas en Java. Define un Enum llamado `ValorCarta` que represente los
valores de las cartas (As, 2, 3, ..., 10, J, Q, K). Luego, escribe un método `obtenerPuntos()` que tome un valor de
carta como argumento y devuelva la cantidad de puntos que vale esa carta en el juego.

Por ejemplo, As vale 1 punto, 2 vale 2 puntos, 3 vale 3 puntos, ..., 10 vale 10 puntos, J vale 10 puntos, etc.

Una vez que hayas definido el Enum y escrito el método `obtenerPuntos()`, utiliza un par de casos de prueba para verificar que funciona correctamente.
