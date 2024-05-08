package practica.ejercicios_collections.ejercicios_queue.estudiante;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    public static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        String file = "Personas_extra.csv";

        List<Estudiante> estudiantes = cargarEstudiantes(file);
        Queue<Estudiante> colaEstudiantes = cargarEstudiantesCola(file);

        // Mostrar lista sin ordenar
        System.out.println("Lista origen: " + estudiantes.size() + " elementos.");
        estudiantes.forEach(System.out::println);

        System.out.println("---- PRIORITYQUEUE ----");
        System.out.println("\n\nCola de estudiantes cargada: " + colaEstudiantes.size() + " elementos.");
        colaEstudiantes.forEach(System.out::println);

        Queue<Estudiante> colaPrioridad = new PriorityQueue<>(estudiantes);
        System.out.println("\n\nCola de estudiantes de origen lista: " + colaPrioridad.size() + " elementos.");
        colaPrioridad.forEach(System.out::println);

        // Sacar los estudiantes de la cola en orden de prioridad (nota media)
        System.out.println("\n\nExtraigo los estudiantes en orden de cola: ");
        while (!colaPrioridad.isEmpty()) {
            Estudiante estudiante = colaPrioridad.poll();
            System.out.println(estudiante.getNombre() + " " + estudiante.getApellidos() + ": " + estudiante.getNotaMedia());
        }

        System.out.println("---- ARRAYDEQUE ----");
        Deque<Estudiante> pilaEstudiantes = new ArrayDeque<>(estudiantes);
        System.out.println("\n\nPila de estudiantes de origen lista: " + pilaEstudiantes.size() + " elementos" +
                ".");
        pilaEstudiantes.forEach(System.out::println);

        // Sacar los estudiantes de la cola en orden de prioridad (nota media)
        System.out.println("\n\nExtraigo los estudiantes en orden de pila: ");
        while (!pilaEstudiantes.isEmpty()) {
            Estudiante estudiante = pilaEstudiantes.poll();
            System.out.println(estudiante.getNombre() + " " + estudiante.getApellidos() + ": " + estudiante.getNotaMedia());
        }

        System.out.println("---- LINKEDBLOCKINGDEQUE ----");
        System.out.println("\n\nProbando linkedBlockingDeque: ");
        Deque<Estudiante> pilaEstudiantesFija = new LinkedBlockingDeque<>(4);
        while (estudiantes.size() > 0) {
            pilaEstudiantesFija.push(estudiantes.remove(0));
            if (pilaEstudiantesFija.size() == 4) {
                break;
            }
        }
        pilaEstudiantesFija.forEach(System.out::println);

        System.out.println("\n\nExtraigo los estudiantes linkedBlockingDeque: ");
        while (!pilaEstudiantesFija.isEmpty()) {
            Estudiante estudiante = pilaEstudiantesFija.pollLast();
            System.out.println(estudiante.getNombre() + " " + estudiante.getApellidos() + ": " + estudiante.getNotaMedia());
        }
    }

    public static ArrayList<Estudiante> cargarEstudiantes(String fichero) {

        // Leer datos de personas desde un archivo y agregarlos a la lista
        System.out.print("\n\nLeyendo datos de personas desde archivo...\n");

        ArrayList<Estudiante> estudiantes = null;
        File demo = new File("src/practica/ejercicios_collections/ejercicios_set/comparador_personas", fichero);

        try (BufferedReader br = new BufferedReader(new FileReader(demo));) {
            String line;
            estudiantes = new ArrayList<>();

            int contador = 0;
            while((line = br.readLine()) != null) {
                if (contador != 0) {
                    estudiantes.add(Estudiante.crearEstudiante(line));
                }
                contador++;
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }

        return estudiantes;
    }

    public static Queue<Estudiante> cargarEstudiantesCola(String fichero) {

        // Leer datos de personas desde un archivo y agregarlos a la lista
        System.out.print("\n\nLeyendo datos de personas desde archivo...\n");

        Queue<Estudiante> estudiantes = null;
        File demo = new File("src/practica/ejercicios_collections/ejercicios_set/comparador_personas", fichero);

        try (BufferedReader br = new BufferedReader(new FileReader(demo));) {
            String line;
            estudiantes = new PriorityQueue<>();

            int contador = 0;
            while((line = br.readLine()) != null) {
                if (contador != 0) {
                    estudiantes.add(Estudiante.crearEstudiante(line));
                }
                contador++;
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }

        return estudiantes;
    }


}
