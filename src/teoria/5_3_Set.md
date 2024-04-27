# INTERFAZ SET

Para ver esta información de forma más amena podéis acceder a:
[AULA EN LA NUBE](https://www.youtube.com/watch?v=Yzs5MGu_lJY&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=153)
[AULA EN LA NUBE](https://www.youtube.com/watch?v=8Vq04jsVaRo&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=154)
[AULA EN LA NUBE](https://www.youtube.com/watch?v=tfeQrUH7L4k&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=155)
[AULA EN LA NUBE](https://www.youtube.com/watch?v=UPYECuGiePc&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=155)

## ¿Qué es un conjunto?

[Ir a Oracle: Conjunto](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Set.html)

Un conjunto en Java es una colección que no permite elementos duplicados. Se basa en la teoría matemática de 
conjuntos y proporciona operaciones eficientes para agregar, eliminar y verificar la presencia de elementos. 

Los conjuntos no garantizan un orden específico de los elementos.

Los objetos que forman el Set, deben implementar el método hasCode y equals, ya que se usan 
para comparar los elementos para gestionar la colección y si no, en su lugar, se usará los de Object. 

## Clases principales que implementan Set

### **HashSet** 
Implementación de la interfaz Set que utiliza una tabla hash para almacenar los elementos.
- No garantiza el orden de los elementos.
- Permite elementos nulos.
- Es muy eficiente en búsqueda, inserción y eliminación, pero no mantiene el orden de inserción de los elementos.
- Necesita que tengamos creados los métodos hashCode y equals en la clase que se va a guardar en el HashSet. 

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Este no se agregará, ya que "Apple" está duplicado

        System.out.println(hashSet); // Imprimirá algo como [Apple, Banana, Cherry]
    }
}
```

### **LinkedHashSet** 
Implementación de la interfaz Set que combina las características de HashSet y LinkedList.
- Mantiene el orden de inserción de los elementos.
- Permite elementos nulos.
- Usa más memoria que cualquier otro Set para mantener el enlace al siguiente elemento.
- Necesita que tengamos creados los métodos hashCode y equals en la clase que se va a guardar en el LinkedHashSet.

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Apple"); // Este no se agregará, ya que "Apple" está duplicado

        System.out.println(linkedHashSet); // Imprimirá [Apple, Banana, Cherry]
    }
}
```

### **TreeSet** 
Implementación de la interfaz Set que utiliza un árbol rojo-negro para almacenar los elementos.
- Almacena sus elementos en un árbol rojo-negro, que es una forma de árbol binario de búsqueda balanceado.
- Los elementos se almacenan en orden ascendente.
- No permite valores nulos.
- Proporciona un rendimiento eficiente con grandes cantidades de datos.
- Necesita que implementemos la interfaz Comparable en la clase que se va a guardar en el TreeSet o proporcionar un 
  Comparator.

```java
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();

        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Cherry");
        treeSet.add("Apple"); // Este no se agregará, ya que "Apple" está duplicado

        System.out.println(treeSet); // Imprimirá [Apple, Banana, Cherry]
    }
}
```

`TreeSet` también implementa la interfaz `NavigableSet`, que extiende `SortedSet`, lo cual proporciona varios 
métodos adicionales que no están disponibles para las clases de arriba y son los siguientes:

- `first()`: Devuelve el primer (menor) elemento actualmente en este conjunto.
- `last()`: Devuelve el último (mayor) elemento actualmente en este conjunto.
- `lower(E e)`: Devuelve el elemento más grande en este conjunto que es menor que `e`, o `null` si no hay tal elemento.
- `floor(E e)`: Devuelve el elemento más grande en este conjunto menor o igual a `e`, o `null` si no hay tal elemento.
- `ceiling(E e)`: Devuelve el elemento más pequeño en este conjunto mayor o igual a `e`, o `null` si no hay tal elemento.
- `higher(E e)`: Devuelve el elemento más pequeño en este conjunto mayor que `e`, o `null` if no hay tal elemento.
- `pollFirst()`: Recupera y elimina el primer (más bajo) elemento, o devuelve `null` si este conjunto está vacío.
- `pollLast()`: Recupera y elimina el último (más alto) elemento, o devuelve `null` si este conjunto está vacío.
- `descendingSet()`: Devuelve un conjunto en orden descendente.
- `descendingIterator()`: Devuelve un iterador sobre los elementos en este conjunto en orden descendente.
- `subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)`: Devuelve una vista del conjunto cuyos elementos van desde `fromElement` a `toElement`.
- `headSet(E toElement, boolean inclusive)`: Devuelve una vista del conjunto cuyos elementos son menores que (o iguales a, si `inclusive` es verdadero) `toElement`.
- `tailSet(E fromElement, boolean inclusive)`: Devuelve una vista del conjunto cuyos elementos son mayores que (o iguales a, si `inclusive` es verdadero) `fromElement`.

Para el uso de estos métodos, que implican una manipulación más precisa y flexible, será necesario que la variable 
declarada sea de tipo TreeSet, ya que, la interfaz `Set` estándar no nos permitirá acceder a ellos.

```java
 // Mejor declarar la variable como TreeSet
TreeSet<Estudiante_parte2> treeConjuntoEstudiantes = new TreeSet<>(estudiantes);

// que como Set
Set<Estudiante_parte2> treeConjuntoEstudiantes = new TreeSet<>(estudiantes);
``` 
