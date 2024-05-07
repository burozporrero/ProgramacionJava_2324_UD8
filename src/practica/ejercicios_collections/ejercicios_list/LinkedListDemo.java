package practica.ejercicios_collections.ejercicios_list;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args){
        // IMPORTANTE: El tipo de colección se indica al declarar la variable, ya que si no, perdemos potencia
        LinkedList<Alumno> dam = new LinkedList<>();

        // Añadir elementos
        System.out.println("**AÑADIR ELEMENTOS**");
        dam.add(new Alumno("Pep","222A", 25)); //Añade al final de la lista, pero es el primer elemento
        System.out.println("add " + dam);
        dam.addFirst(new Alumno("Tom","111A", 20)); //Añade al principio de la lista
        System.out.println("addFirst " + dam);
        dam.add(new Alumno("Jon","444A", 21)); // Añade al final de la lista
        System.out.println("add " + dam);
        dam.add(new Alumno("Jimmy","777A", 21)); // Añade al final de la lista
        System.out.println("add " + dam);
        dam.addLast(new Alumno("Tim","333A", 19)); // Añade al final de la lista
        System.out.println("addLast " + dam);
        dam.push(new Alumno("Ada","555A", 18)); // Añade al principio de la lista
        System.out.println("push " + dam);
        dam.add(3, new Alumno("Sam","666A", 18));  // Añade en la posición 3
        System.out.println("add(3) " + dam);
        dam.offerFirst(new Alumno("Jud", "888A", 24));
        System.out.println("offerFirst " + dam);
        dam.offerLast(new Alumno("Kim", "999A", 24));
        System.out.println("offerLast " + dam);

        // Modificar y obtener elementos
        System.out.println("\n**MODIFICAR Y OBTENER ELEMENTOS**");
        dam.set(6, new Alumno("Ana", "777A", 20)); // Modifica el elemento en la posición 2
        System.out.println("set(6) " + dam);
        Alumno n = dam.get(1);
        System.out.println("get(1) " + n );
        n = dam.element();
        System.out.println("element " + n );
        n = dam.peekFirst();
        System.out.println("peekFirst " + n );
        n = dam.peekLast();
        System.out.println("peekLast " + n );
        System.out.println("Lista " + dam);

        // Eliminar elementos
        System.out.println("\n**BORRAR ELEMENTOS**");
        dam.remove(); // Elimina el primer elemento
        System.out.println("remove: " + dam);
        dam.removeFirst(); // Elimina el primer elemento
        System.out.println("removeFirst: " + dam);
        dam.removeLast(); // Elimina el último elemento
        System.out.println("removeLast: " + dam);
        dam.pop(); // Elimina el primer elemento
        System.out.println("pop: " + dam);
        dam.remove(2); // Elimina el elemento en la posición 2
        System.out.println("remove(2): " + dam);
        dam.pollFirst();// Elimina el primer elemento
        System.out.println("pollFirst " + dam);
        dam.pollLast(); // Elimina el último elemento
        System.out.println("pollLast " + dam);

        Object[] damArray = dam.toArray();

    }
}
