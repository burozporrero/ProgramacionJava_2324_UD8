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
