# EJERCICIOS SET

## Ejercicio Estudiantes

### Parte 1
Coge el ejercicio de estudiantes EXTRA realizado con LinkedList.
Guárdalo en un Set de cada tipo y comprueba si se permiten elementos repetidos.
Fíjate bien y deduce, en base a que criterio, se han eliminado los estudiantes.

[Demo](comparador_personas/Main.java)

### Parte 2
Ahora, vamos a modificar el método equals de la clase Estudiante, para que dos estudiantes sean iguales únicamente si 
tienen el mismo nombre y apellidos.
Ejecuta el main anterior sobre la nueva clase.
¿Qué ha pasado? ¿Por qué?

[Demo](comparador_personas/Main_parte2.java)

### Parte 3
Por último, vamos a reutilizar el main anterior eliminando el código relacionado con LinkedHashSet y con HashSet.
Vamos a probar los métodos que solo están disponibles en la clase TreeSet para conocerlos un poco mejor ¿Funciona? 
¿Cómo has declarado el TreeSet?

[Demo](comparador_personas/Main_parte3.java)

## Lista de números aleatorios
Implementa un programa que genere una lista de 50 números aleatorios con valores comprendidos entre 1 y 10 y luego 
utilice un conjunto para eliminar los duplicados, manteniendo solo los valores únicos.
Elige y argumenta cuál crees que será la mejor implementación de las disponibles de Set.

La salida del programa debe ser igual a la siguiente, exceptuando la primera línea de números aleatorios que será 
diferente cada vez que se ejecute el programa:

Lista de números original: [10, 5, 9, 8, 1, 1, 1, 2, 4, 9, 6, 10, 5, 9, 4, 3, 10, 8, 2, 2, 7, 9, 8, 3, 3, 3, 4, 9, 5, 1, 4, 3, 10, 10, 4, 8, 8, 6, 9, 6, 9, 7, 3, 2, 3, 8, 9, 6, 3, 3]
Vamos a mostrar un conjunto de 10 números únicos
Conjunto de números: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
La lista contiene el número 5? true
Conjunto de números: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 25]
Conjunto de números: [0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 15, 25]

[Demo](UniqueRandomNumbers.java)

## Ejercicio: Lista de reproducción

Vamos a desarrollar una aplicación de música donde los usuarios pueden crear su propia lista de reproducción. 
La lista de reproducción no debe contener canciones que se repitan y debe mantener el orden en el que el usuario las 
almacenó, ya que el orden indica su prioridad.
Será necesario que argumentes la colección de datos escogida en Java para implementar esta solución. 

El programa principal probará automáticamente las funcionalidades que se pueden realizar con la lista de reproducción:

- añadir canciones
- eliminar canciones
- mostrar por pantalla la lista de reproducción

[Demo](lista_reproduccion/Main.java)

## Ejercicio: Gestión de una biblioteca

Vamos a simular la gestión de una biblioteca.

La biblioteca tiene una colección de libros, donde cada libro es representado por su título.
Un título de libro no puede aparecer más de una vez en la biblioteca.

**Requisitos:**

1. Crea una clase `Library` y una clase `Book`.
2. Implementa un método `addBook(String title)` en la clase `Library` que permita agregar un libro a la biblioteca. Si el libro ya existe en la biblioteca, el método debe imprimir un mensaje indicando que el libro ya existe y no debe agregarlo al `HashSet`.
3. Implementa un método `removeBook(String title)` que permita eliminar un libro de la biblioteca. Si el libro no existe en la biblioteca, el método debe imprimir un mensaje indicando que el libro no se encuentra en la biblioteca.
4. Implementa un método `findBook(String title)` que verifique si un libro está en la biblioteca. El método debe imprimir un mensaje indicando si el libro se encuentra o no en la biblioteca.
5. Implementa un método `printLibrary()` que imprima todos los libros en la biblioteca.

Crear un main que pruebe automáticamente la funcionalidad de la biblioteca.
