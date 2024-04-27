# DETALLES A TENER EN CUENTA SOBRE LAS COLECCIONES

Os dejo un enlace a una página que detalla en profundidad cada tipo de colección

[www.geeksforgeeks.org](https://www.geeksforgeeks.org/collections-in-java-2/)

También es muy interesante la información del propio Oracle

[Tutorial Java](https://docs.oracle.com/javase%2Ftutorial%2F/collections/implementations/index.html)

Os dejo un enlace a una página que analiza la complejidad temporal de las colecciones de Java para aquel que tenga 
curiosidad

[Bikash Dubey](https://bikashdubey42.medium.com/time-complexity-of-java-collections-api-c65baa784e21)

## Declaración de interfaces

Declarar las colecciones a través de una interfaz, de esta manera, el tipo de datos de los elementos de dichas 
listas se determina durante la inicialización de la lista, es decir, cuando se agregan elementos allí.

```java
List arrayList = new ArrayList();
List vecList = new Vector();
List stackList = new Stack();

// Cuidado con la siguiente, probemos que ocurre con cada una
LinkedList linkedList = new LinkedList();
List linkedList = new LinkedList();

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
