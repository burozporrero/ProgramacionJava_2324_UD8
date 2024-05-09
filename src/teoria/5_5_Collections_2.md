# DETALLES A TENER EN CUENTA SOBRE LAS COLECCIONES

Os dejo un enlace a una página que detalla en profundidad cada tipo de colección

[www.geeksforgeeks.org](https://www.geeksforgeeks.org/collections-in-java-2/)

También es muy interesante la información del propio Oracle

[Tutorial Java](https://docs.oracle.com/javase%2Ftutorial%2F/collections/implementations/index.html)

Os dejo un enlace a una página que analiza la complejidad temporal de las colecciones de Java para aquel que tenga 
curiosidad

[Bikash Dubey](https://bikashdubey42.medium.com/time-complexity-of-java-collections-api-c65baa784e21)

## Declaración de interfaces

Es recomendable declarar las colecciones a través de una interfaz por las siguientes razones:

1. **Flexibilidad**: Al declarar una colección como su tipo de interfaz (por ejemplo, `List`, `Set`, `Map`), puedes cambiar fácilmente la implementación real de la colección (por ejemplo, de `ArrayList` a `LinkedList`) sin tener que cambiar el tipo de la variable. Esto puede ser útil si necesitas cambiar la implementación para optimizar el rendimiento o para utilizar características específicas de una implementación.

2. **Principio de programación para interfaces**: Este es un principio de diseño de software que sugiere que las variables deben ser declaradas como el tipo de interfaz en lugar del tipo de clase cuando sea posible. Esto permite que el código sea más flexible y adaptable a cambios.

3. **Encapsulamiento**: Al usar el tipo de interfaz, estás ocultando los detalles de la implementación de la colección. Esto es una forma de encapsulamiento, que es un principio fundamental de la programación orientada a objetos.

4. **Polimorfismo**: Las interfaces permiten el polimorfismo, que es la capacidad de una variable de referirse a objetos de diferentes clases. Esto puede ser útil en muchos contextos, como cuando se pasan colecciones a métodos o se devuelven de ellos.

Por lo tanto, aunque hay situaciones en las que puede ser necesario o útil utilizar el tipo de clase específico 
(TreeSet y TreeMap, cuando se necesitan métodos específicos de una implementación), en general es una buena 
práctica en Java declarar las colecciones a través de una interfaz.

```java
List arrayList = new ArrayList();
List vecList = new Vector();
List stackList = new Stack();

arrayList.add(1);
vecList.add(1.2f);
stackList.add("Paul");
```

## Colecciones hash, hashCode y mutabilidad

En este punto os dejo el material del profesor Eduard Silvestre, que detalla perfectamente la problemática a la que nos 
enfrentamos:

[PDF profesor Eduard Silvestre](documents/tv08x_Colleccions_i_HashCode.pdf)

[DEMO en código](mutabilidad/Main.java)

## Colecciones no modificables

Esta vez vamos a acceder al propio Oracle que tratan en profundidad este punto:

[Teoría de Oracle](https://docs.oracle.com/en/java/javase/17/core/creating-immutable-lists-sets-and-maps.html#GUID-DD066F67-9C9B-444E-A3CB-820503735951)

[DEMO en código](mutabilidad/Main2.java)
