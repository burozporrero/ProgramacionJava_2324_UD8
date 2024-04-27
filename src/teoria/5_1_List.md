# INTERFAZ LIST

Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://www.youtube.com/watch?v=3K1_lj2CABU&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=150)

## ¿Qué es una lista?

[Ir a Oracle: Lista](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html)

Una lista en Java es una colección ordenada de elementos donde cada elemento tiene un índice asociado que indica su 
posición en la lista (están indexados).

## Clases principales que implementan List

### ArrayList 

[Ir a Oracle: ArrayList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html)

- Implementa una lista respaldada por un array dinámico que se redimensiona automáticamente según sea necesario. 
- Proporciona un acceso rápido a los elementos mediante índices, pero puede ser costoso en términos de inserción y 
  eliminación en posiciones intermedias.

### LinkedList

[Ir a Oracle: LinkedList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedList.html)
 
- Implementa una lista doblemente enlazada que permite un acceso rápido a los elementos de inicio y fin de la lista, 
así como inserciones y eliminaciones eficientes en cualquier posición.
- Cada elemento de la lista tiene que llevar un enlace al elemento siguiente y al anterior.
- El acceso aleatorio es más lento que en un ArrayList.

### Stack: Obsoleta

Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://youtu.be/3K1_lj2CABU?list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&t=420)

La clase `Stack` representa una estructura de datos de tipo pila (stack) que sigue el principio LIFO (Last In, First 
Out), es decir, el último elemento que se inserta en la pila es el primero en ser eliminado. En Java, `Stack` es una 
clase que extiende a `Vector`, que a su vez, implementa a List. 

Es una **clase ya obsoleta**, mejorada por la clase DEQUE que veremos en el punto 2_3.

Algunas características importantes de la clase `Stack` son:

1. **Métodos de pila estándar:** Ofrece métodos típicos de una pila, como `push()` para agregar elementos en la parte superior de la pila, `pop()` para eliminar y devolver el elemento superior de la pila, `peek()` para obtener el elemento superior sin eliminarlo, y `empty()` para verificar si la pila está vacía.

2. **Hereda de Vector:** Al ser una subclase de `Vector`, `Stack` también puede utilizar los métodos de `Vector`, como `elementAt()`, `size()`, `isEmpty()`, entre otros.

3. **Uso común en aplicaciones:** Las pilas son utilizadas en muchas aplicaciones informáticas, como la implementación de algoritmos de reversión, el manejo de llamadas de funciones en la pila de llamadas de un programa, la evaluación de expresiones matemáticas, entre otros.

Ejemplo básico:

```java
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> pila = new Stack<>();

        // Agregar elementos a la pila
        pila.push("A");
        pila.push("B");
        pila.push("C");

        // Eliminar y obtener el elemento superior de la pila
        String elementoSuperior = pila.pop();
        System.out.println("Elemento superior: " + elementoSuperior);

        // Obtener el elemento superior de la pila sin eliminarlo
        String elementoSuperiorActual = pila.peek();
        System.out.println("Elemento superior actual: " + elementoSuperiorActual);

        // Verificar si la pila está vacía
        boolean estaVacia = pila.isEmpty();
        System.out.println("¿La pila está vacía?: " + estaVacia);
    }
}
```
