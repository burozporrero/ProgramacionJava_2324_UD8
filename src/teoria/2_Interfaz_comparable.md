# INTERFACES COMPARABLE y COMPARATOR. CLASE COLLATOR

<!-- TOC -->
* [INTERFACES COMPARABLE y COMPARATOR. CLASE COLLATOR](#interfaces-comparable-y-comparator-clase-collator)
  * [INTERFAZ COMPARABLE](#interfaz-comparable)
  * [INTERFAZ COMPARATOR](#interfaz-comparator)
  * [Comparación entre Comparable y Comparator](#comparación-entre-comparable-y-comparator)
  * [CLASE COLLATOR](#clase-collator)
<!-- TOC -->
## INTERFAZ COMPARABLE

[Ir a Oracle](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html)

Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://www.youtube.com/watch?v=R_gV5wpBwNQ&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=147)

Las interfaces que tratamos en este punto, son herramientas para ordenar objetos en Java. En concreto, la interfaz 
`Comparable` se utiliza para definir el orden natural de los objetos de una clase. Esta interfaz contiene un único 
método llamado `compareTo()`, que compara el objeto actual con otro objeto y devuelve un valor entero que indica si el objeto es menor, igual o mayor que el objeto comparado.

En concreto, devuelve 1 si el objeto actual es mayor que el que pasamos como parámetro. Devuelve 0 si en la 
comparación se produce una relación de igualdad y devuelve -1 si es menor.

Supongamos que tenemos una clase `Persona` que queremos ordenar por su edad usando `Comparable`:

```java
public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        return Integer.compare(this.edad, otraPersona.edad);
    }
}
```

Ahora podemos ordenar una lista de personas por edad utilizando el método `Collections.sort()` de Java:

```java
List<Persona> personas = new ArrayList<>();
personas.add(new Persona("Juan", 25));
personas.add(new Persona("María", 30));
personas.add(new Persona("Pedro", 20));

Collections.sort(personas);

```

## INTERFAZ COMPARATOR

[Ir a Oracle](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Comparator.html)

Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://www.youtube.com/watch?v=5ch7D89vpL0&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=148)

La interfaz `Comparator` en Java se utiliza para definir múltiples criterios de ordenación para objetos de una clase que no implementa `Comparable`. Esta interfaz contiene un método llamado `compare()`, que toma dos objetos y devuelve un valor entero que indica si el primer objeto es menor, igual o mayor que el segundo objeto según el criterio de ordenación definido.

Supongamos que queremos ordenar la clase `Persona`, del ejemplo por nombre:

````java
public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
````

```java
public class NombreComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona persona1, Persona persona2) {
        return persona1.getNombre().compareTo(persona2.getNombre());
    }
}
```

Ahora podemos ordenar una lista de personas por nombre utilizando este comparador:

```java
List<Persona> personas = new ArrayList<>();
personas.add(new Persona("Juan", 25));
personas.add(new Persona("María", 30));
personas.add(new Persona("Pedro", 20));

Collections.sort(personas, new NombreComparator());
```

Ahora imaginemos un ejemplo en el que ordenamos personas por más de un criterio de ordenación:

````java
import java.util.Comparator;

public class PersonaComparator implements Comparator<Persona> {
    
    @Override
    public int compare(Persona persona1, Persona persona2) {
        // Comparación por edad
        int resultado = Integer.compare(persona1.getEdad(), persona2.getEdad());
        
        // Si las edades son iguales, comparar por nombre
        if (resultado == 0) {
            resultado = persona1.getNombre().compareTo(persona2.getNombre());
        }
        
        return resultado;
    }
}

````
También podemos utilizar esta interfaz, para comparar y ordenar, elementos de una lista que no sean del mismo tipo.

Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://www.youtube.com/watch?v=dRvRFNWk1sw&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=149)

Un ejemplo simple sería el siguiente:

````java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Object> lista = new ArrayList<>();
        lista.add("hola");
        lista.add(3);
        lista.add(1);
        lista.add("adios");
        lista.add(2);

        Collections.sort(lista, new MiComparator());

        System.out.println("Lista ordenada:");
        for (Object elemento : lista) {
            System.out.println(elemento);
        }
    }
}

class MiComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Integer && o2 instanceof Integer) {
            return Integer.compare((Integer) o1, (Integer) o2);
        } else if (o1 instanceof String && o2 instanceof String) {
            return ((String) o1).compareTo((String) o2);
        } else if (o1 instanceof Integer) {
            return -1; // Enteros primero
        } else {
            return 1; // Cadenas después
        }
    }
}

````

Ahora bien, en el ejemplo anterior, la realidad es que se complica mucho la comparación de objetos diferentes: 
Tenemos que tener cada tipo a comparar en cuenta y hacerlo a través del operador instanceOf. 

A continuación, vamos a mostrar un ejemplo, que aunque a priori no tenga mucho sentido, ya que, ordenamos personas y 
productos, nos mostrará toda la potencia que podemos extraer del Comparator, si utilizamos una interfaz intermedia, 
que obligue a todos los tipos de objetos diferentes que quieren ser comparados, a implementar un método que genere 
un campo de comparación común:

````java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<ComparableComun> lista = new ArrayList<>();
        lista.add(new Persona("Juan", 25));
        lista.add(new Producto("Lápiz", 1.5));
        lista.add(new Persona("María", 30));
        lista.add(new Producto("Libro", 15.99));

        Collections.sort(lista, new MiComparator());

        System.out.println("Lista ordenada:");
        for (ComparableComun elemento : lista) {
            System.out.println(elemento);
        }
    }
}

interface ComparableComun {
    double obtenerValorComparativo();
}

class Persona implements ComparableComun {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public double obtenerValorComparativo() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }
}

class Producto implements ComparableComun {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double obtenerValorComparativo() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
    }
}

class MiComparator implements Comparator<ComparableComun> {
    @Override
    public int compare(ComparableComun o1, ComparableComun o2) {
        double valor1 = o1.obtenerValorComparativo();
        double valor2 = o2.obtenerValorComparativo();

        return Double.compare(valor1, valor2);
    }
}

````

## Comparación entre Comparable y Comparator

La interfaz `Comparable`, es más simple de implementar, ya que solo se necesita implementar el método `compareTo()` en 
la propia clase. 

Por otro lado, la interfaz `Comparator`, es útil cuando no tenemos acceso al código fuente de la clase que queremos 
ordenar, ya que podemos definir el criterio de ordenación en una clase separada, siempre y cuando no tratemos de 
hacer una ordenación de tipos de elementos diferentes.

## CLASE COLLATOR

[Ir a Oracle](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/text/Collator.html)

En este caso nos vamos a remitir a la documentación del [profesor Eduard Silvestre](documents/tv08a_collator.pdf)
