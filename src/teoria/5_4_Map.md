# INTERFAZ MAP

Para ver esta información de forma más amena podéis acceder a:
[AULA EN LA NUBE](https://www.youtube.com/watch?v=PQcBEX5M23c&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=157)
[AULA EN LA NUBE](https://www.youtube.com/watch?v=eplBXJarh1A&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=158)
[AULA EN LA NUBE](https://www.youtube.com/watch?v=unbN9nF-ifE&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=159)
[AULA EN LA NUBE](https://www.youtube.com/watch?v=H3_Wuis_Ipg&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=160)
[AULA EN LA NUBE](https://www.youtube.com/watch?v=Q4s1RMSXzX8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=161)

## ¿Qué es un map?

[Ir a Oracle: Map](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Map.html)

Los mapas representan una colección de pares clave-valor únicos, a diferencia de las colecciones que representan 
grupos de elementos.

Cada clave es única y se utiliza para recuperar su correspondiente valor. Los mapas no permiten claves duplicadas y 
cada clave puede estar asociada a un solo valor.

La interfaz `Map`, aunque pertenece al paquete `java.util`, no extiende la interfaz `Collection`. Por lo tanto, 
tampoco implementa la interfaz `Iterable`, lo que significa que no se puede recorrer directamente con un bucle.

## Clases principales que implementan Map

### **HashMap**
Implementación de la interfaz Map que utiliza una tabla hash para almacenar los elementos.
- No garantiza un orden específico de las claves.
- Permite claves y valores nulos.
- Es muy eficiente en búsqueda, inserción y eliminación, pero no mantiene el orden de inserción de los elementos.
- Necesita que tengamos creados los métodos hashCode y equals en la clase que se va a guardar en el HashSet.

**Ejemplo de uso:**
```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> mapa = new HashMap<>();

        mapa.put("Juan", 25);
        mapa.put("María", 30);
        mapa.put("Pedro", 28);

        System.out.println(mapa.get("María")); // Imprimirá 30
    }
}
```

### **LinkedHashMap**
Implementación de la interfaz Map que utiliza las características de HashMap, manteniendo el orden de inserción de 
los elementos.
- Permite claves y valores nulos.
- Necesita que tengamos creados los métodos hashCode y equals en la clase que se va a guardar en el LinkedHashSet.

### **TreeMap**
Implementación de la interfaz Set que utiliza un árbol rojo-negro para almacenar los elementos.
- Las claves se almacenan en orden ascendente.
- No permite claves nulas, pero permite valores nulos.
- Proporciona un rendimiento eficiente con grandes cantidades de datos.
- Necesita que implementemos la interfaz Comparable en la clase que se va a guardar en el TreeSet o proporcionar un
  Comparator.

`TreeMap` en Java implementa la interfaz `NavigableMap`, que extiende `SortedMap` , lo cual proporciona varios
métodos adicionales que no están disponibles para las clases de arriba y son los siguientes:

- `lowerKey(K key)`: Devuelve la clave más grande en este mapa que es menor que `key`, o `null` si no hay tal clave.
- `lowerEntry(K key)`: Devuelve un par clave-valor asociado con la clave más grande en este mapa que es menor que `key`, o `null` si no hay tal clave.
- `floorKey(K key)`: Devuelve la clave más grande en este mapa menor o igual a `key`, o `null` si no hay tal clave.
- `floorEntry(K key)`: Devuelve un par clave-valor asociado con la clave más grande en este mapa menor o igual a `key`, o `null` si no hay tal clave.
- `ceilingKey(K key)`: Devuelve la clave más pequeña en este mapa mayor o igual a `key`, o `null` si no hay tal clave.
- `ceilingEntry(K key)`: Devuelve un par clave-valor asociado con la clave más pequeña en este mapa mayor o igual a `key`, o `null` si no hay tal clave.
- `higherKey(K key)`: Devuelve la clave más pequeña en este mapa mayor que `key`, o `null` si no hay tal clave.
- `higherEntry(K key)`: Devuelve un par clave-valor asociado con la clave más pequeña en este mapa mayor que `key`, o `null` si no hay tal clave.
- `firstEntry()`: Devuelve un par clave-valor asociado con la clave más pequeña en este mapa, o `null` si el mapa está vacío.
- `lastEntry()`: Devuelve un par clave-valor asociado con la clave más grande en este mapa, o `null` si el mapa está vacío.
- `pollFirstEntry()`: Elimina y devuelve un par clave-valor asociado con la clave más pequeña en este mapa, o `null` si el mapa está vacío.
- `pollLastEntry()`: Elimina y devuelve un par clave-valor asociado con la clave más grande en este mapa, o `null` si el mapa está vacío.
- `descendingMap()`: Devuelve un mapa en orden descendente.
- `descendingKeySet()`: Devuelve un conjunto de claves en orden descendente.
- `navigableKeySet()`: Devuelve un conjunto de claves en orden ascendente.
- `subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)`: Devuelve una vista del mapa cuyas claves van desde `fromKey` a `toKey`.
- `headMap(K toKey, boolean inclusive)`: Devuelve una vista del mapa cuyas claves son menores que (o iguales a, si `inclusive` es verdadero) `toKey`.
- `tailMap(K fromKey, boolean inclusive)`: Devuelve una vista del mapa cuyas claves son mayores que (o iguales a, si `inclusive` es verdadero) `fromKey`.


Para el uso de estos métodos, que implican una manipulación más precisa y flexible, será necesario que la variable
declarada sea de tipo TreeMap, ya que, la interfaz `Map` estándar no nos permitirá acceder a ellos.

```java
 import java.util.TreeMap;// Mejor declarar la variable como TreeMap
TreeMap<Integer, Estudiante> treeEstudiantes = new TreeSet<>();

// que como Map
Map<Integer, Estudiante> treeEstudiantes = new TreeMap<>();
``` 
