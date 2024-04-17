# TIPOS DE DATOS GENÉRICOS

<!-- TOC -->
* [TIPOS DE DATOS GENÉRICOS](#tipos-de-datos-genéricos)
  * [Uso de genéricos en métodos](#uso-de-genéricos-en-métodos)
  * [Uso de genéricos en clases](#uso-de-genéricos-en-clases)
  * [Uso de múltiples parámetros genéricos](#uso-de-múltiples-parámetros-genéricos)
<!-- TOC -->

## Uso de genéricos en métodos

Imaginemos el siguiente código:

```java
Integer [] numerosEnteros = new Integer [] {1,2,3,4,5};
Float [] numerosFlotantesSimples = new Float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
Double [] numerosFlotantes = new Double[] {1.0, 2.0, 3.0, 4.0, 5.0};
````

Ahora supongamos que queremos crear una función que nos permita convertir estos Arrays en un ArrayList:
```java
//Para Integers
public static ArrayList<Integer> convertToArrayList(Integer [] array){
    ArrayList<Integer> miLista = new ArrayList<Integer>();

    for (Integer numero: array) {
        miLista.add(numero);
    }
    return miLista;
}

//Para Float's
public static ArrayList<Float> convertToArrayList(Float [] array){
    ArrayList<Float> miLista = new ArrayList<Float>();

    for (Float numero: array) {
        miLista.add(numero);
    }
    return miLista;
}

//Para Doubles
public static ArrayList<Double> convertToArrayList(Double [] array){
    ArrayList<Double> miLista = new ArrayList<Double>();

    for (Double numero: array) {
        miLista.add(numero);
    }
    return miLista;
}
```

He tenido que crear un método para cada tipo de dato, pero si utilizamos genéricos, podemos hacerlo de la siguiente manera:

```java
static <T> ArrayList<T> arrayToArrayList(T[] array) {
    ArrayList<T> arrayList = new ArrayList<>();
    for (T elemento : array) {
        arrayList.add(elemento);
    }
    return arrayList;
}
```

En este ejemplo:
- `<T>`: Así parametrizamos que T puede ser un Objeto de cualquier tipo.
- `ArrayList<T>`: es el tipo de datos que devuelve el método.
- `T[] array`: es el Array estático que entra como parámetro.
- `T elemento`: para iterar sobre el Array con elementos de tipo `T`.

De esta manera, podemos utilizar el método `arrayToArrayList` para cualquier tipo de dato, de forma que en tiempo 
de compilación Java sustituirá `T` por el tipo de dato que le pasemos.

En resumen, los tipos de datos genéricos nos permiten crear clases, interfaces y métodos que operan sobre un tipo de 
dato que se especifica en el momento de la creación de la instancia.

## Uso de genéricos en clases

Supongamos el siguiente código:

```java
public class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}
```

La clase `Box` es un contenedor que puede almacenar un objeto de cualquier tipo. Donde:

- `public class Box<T>`: Así indicamos que el tipo de datos `T` es un genérico.
- `private T t`: El único atributo de la clase será de tipo `T`.
- `public void set(V t)`: El «setter» recibe como parámetro el atributo de tipo de datos `T`.
- `public V get()`: El «getter» devuelve el atributo con el tipo de datos `T`.


Ahora veamos el siguiente ejemplo de su uso:

```java
public static void main(String[] args) {
       Box<String> stringBox = new Box<>();

       stringBox.set("Old String");
       System.out.println(stringBox.get());
       stringBox.set("New String");

       System.out.println(stringBox.get());

       stringBox.set(12345); // Compilation error!
}
```

La última línea produce un error de compilación, debido a que una vez hemos asignado el tipo de dato `String` a la 
clase `Box`, no podemos asignar otro tipo de dato diferente.

Otro ejemplo de clase, con más parámetros además del genérico:

```java
public class Persona <T>{
    private String nombre;
    private String apellidos;
    private T edad;
     
    public Persona(String nombre, String apellidos, T edad) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getApellidos() {
        return apellidos;
    }
 
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
 
    public T getEdad() {
        return edad;
    }
 
    public void setEdad(T edad) {
        this.edad = edad;
    }
}
````

Y su uso:

```java
public static void main(String[] args) {
    //Instanciamos una clase Persona con la edad en Integer
    Persona<Integer> persona1 = new Persona<Integer>("Pepito", "Grillo", 32);
    //Instanciamos una clase Persona con la edad en Double
    Persona<Double> persona2 = new Persona<Double>("Pablito", "Membrillo", 32.3);

}
```

## Uso de múltiples parámetros genéricos

En el caso de que necesitemos más de un parámetro genérico, podemos hacerlo de la siguiente manera:

```java
public class Pareja<T, V> {
    private T primero;
    private V segundo;

    public Pareja(T primero, V segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public T getPrimero() {
        return primero;
    }

    public V getSegundo() {
        return segundo;
    }

    // Ejemplo de método que recibe dos tipos de datos genéricos
    public static  <T, V> void printTwoTypes(T t, V v) {
      System.out.println("T: " + t + ", U: " + v);
    }

    @Override
    public String toString() {
      return "Pareja{" +
              "primero=" + primero +
              ", segundo=" + segundo +
              '}';
    }
}
```

Ejemplo de uso de la clase y su método estático:

```java
public static void main(String[] args) {
        
    Pareja<String, Integer> p1 = new Pareja<>("Juan", 20);
    
    System.out.println(p1.toString());
    Pareja.printTwoTypes(7, "Puedo permitirme incluso cambiar los tipos, al ser estático");
}
```

[DEMO del ejemplo anterior funcionando](datos_genericos/Main.java)

## Convenciones de nombres

Existen una serie de convenciones para nombrar a los genéricos:

- `E`: Element (usado bastante por Java Collections Framework)
- `K`: Key (Llave, usado en mapas)
- `N`: Number (para números)
- `T`: Type (Representa un tipo, es decir, una clase)
- `V`: Value (representa el valor, también se usa en mapas)

Nota:

Ejemplos extraídos de https://somoshackersdelaprogramacion.es/ y https://codegym.cc/
