# TIPOS ENUM

Para ver esta información de forma más amena podéis acceder a [AULA EN LA NUBE](https://www.youtube.com/watch?v=AkjbCun5kA8&list=PLG1qdjD__qH6ULjW5iN8E45m5nkaCNbUu&index=131)

<!-- TOC -->
* [TIPOS ENUM](#tipos-enum)
  * [Qué son](#qué-son)
  * [Características](#características)
    * [Constantes Enum](#constantes-enum)
    * [Constructores](#constructores)
    * [Métodos](#métodos)
    * [Atributos adicionales](#atributos-adicionales)
    * [Ejemplo](#ejemplo)
  * [Implementación de interfaces](#implementación-de-interfaces)
    * [Comparaciones](#comparaciones)
    * [Iteración sobre Valores](#iteración-sobre-valores)
    * [ValueOf](#valueof)
    * [Métodos Estáticos](#métodos-estáticos)
    * [EJEMPLO COMPLETO](#ejemplo-completo)
<!-- TOC -->

## Qué son

Un Enum (abreviatura de enumeración) es un tipo de dato especial que se utiliza para definir conjuntos fijos de 
constantes. Esto significa que puedes definir un conjunto predefinido de valores que una variable de tipo Enum puede tomar. 

Ejemplo:

```java
// Definición de un Enum llamado DíaSemana
public enum DíaSemana {
    LUNES,
    MARTES,
    MIÉRCOLES,
    JUEVES,
    VIERNES,
    SÁBADO,
    DOMINGO
}

public class EjemploEnum {
    public static void main(String[] args) {
        // Uso del Enum
        DíaSemana hoy = DíaSemana.MARTES;
        
        // Switch con Enum
        switch (hoy) {
            case LUNES:
                System.out.println("Es lunes, ánimo!");
                break;
            case MARTES:
                System.out.println("Es martes, aún queda mucho por delante.");
                break;
            default:
                System.out.println("Es otro día de la semana.");
        }
    }
}
```

## Características

### Constantes Enum

Son los valores fijos que define el Enum, una vez que se definen, no pueden ser modificados en tiempo de
ejecución y por ello, se escriben en mayúsculas. Cada constante representa una instancia única 
de la clase Enum. Por ejemplo, para la clase del ejemplo anterior DíaSemana, las constantes serían LUNES, MARTES, etc.

Como hemos visto arriba, puedes acceder a las constantes Enum de forma estática, utilizando el nombre del Enum seguido 
de un punto y el nombre de la constante. Por ejemplo: `DiaSemana.LUNES`.

### Constructores

Un Enum puede tener un constructor, que se utiliza para inicializar cada constante con valores 
específicos. El constructor se invoca automáticamente al crear cada instancia de la constante.

Cuando creas una instancia de una constante Enum, el constructor correspondiente se invoca automáticamente para inicializar la constante con los valores especificados.

### Métodos

Los Enums pueden contener métodos, los cuales pueden ser útiles para realizar operaciones específicas 
relacionadas con las constantes Enum. Estos métodos pueden ser públicos y se pueden invocar desde cualquier parte del código donde se utilice el Enum.

Puedes invocar métodos definidos en el Enum para realizar operaciones específicas relacionadas con las constantes. Por ejemplo, puedes llamar a un método `getSimbolo()` para obtener el símbolo asociado con una constante Moneda.

### Atributos adicionales

Además del constructor, puedes definir campos atributos en un Enum para almacenar 
información adicional asociada con cada constante. Estos campos pueden ser privados y se pueden acceder mediante métodos públicos definidos en el Enum.

Puedes acceder a los valores asociados con cada constante Enum utilizando métodos definidos en el Enum. Por ejemplo: `DiaSemana.LUNES.getNumeroOrden()` devolverá el número de orden asociado al día LUNES.

### Ejemplo

```java
public enum Moneda {
    // Constantes
    EURO("€"),
    DOLAR("$"),
    LIBRA("£"),
    YEN("¥");
    
    // Atributos adicionales
    private String simbolo;
    
    // Constructor
    private Moneda(String simbolo) {
        this.simbolo = simbolo;
    }
    
    // Getter del atributo adicional
    public String getSimbolo() {
        return simbolo;
    }
}
```

## Implementación de interfaces

Los Enums pueden implementar interfaces, lo que los hace más flexibles y permite
que las constantes Enum proporcionen implementaciones específicas de métodos de interfaz.

### Comparaciones

Puedes comparar constantes Enum utilizando operadores de comparación estándar (`==`, `!=`, etc.) o utilizar métodos como `equals()` para realizar comparaciones.

### Iteración sobre Valores

Puedes iterar sobre todos los valores de un Enum utilizando el método `values()`. Esto es útil cuando necesitas 
realizar operaciones en todos los valores de un conjunto Enum.

### ValueOf

Puedes utilizar el método valueOf, que se encuentra en todas las clases de tipo Enum, para crear una instancia a 
partir de un String con un posible valor de un Enum. Para ello será necesario que el formato sea exactamente el 
mismo que tenemos definido, si no lo encuentra, se producirá un error en tiempo de ejecución.

### Métodos Estáticos

Puedes definir métodos estáticos en un Enum y llamar a estos métodos en cualquier lugar donde se use el Enum.

### EJEMPLO COMPLETO

[Demo Ejemplo extendido](/teoria/enums/Planeta.java)
