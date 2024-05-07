package practica.ejercicios_collections.ejercicios_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvierteArray {


    public static void main(String[] args) {

        arrayToList();
        listToArray();
    }

    public static void arrayToList() {
        // Creating Array
        String[] colors = {"blue", "green", "red", "yellow"};
        System.out.println("Array: " + Arrays.toString(colors));

        //Converting Array to List
        List<String> list = new ArrayList<>();


        // Opción 1
        list = Arrays.asList(colors);
        List<String> lista = new ArrayList<>(Arrays.asList(colors));

        list.add("black");
        // Opción 2
        Collections.addAll(list, colors);

        // Opcion3


        list.add("black");
        System.out.println("List: " + list);
    }

    public static void listToArray() {

        List<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Converting ArrayList to Array
        String[] array = days.toArray(new String[days.size()]);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("List: " + days);
    }
}
