package teoria.mutabilidad;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main2 {

    public static void main(String[] args){

        Set<MeuClas> conjuntDemo1 = new HashSet<>(); // crea el conjuntDemo1 de MeuClas
        conjuntDemo1.add(new MeuClas(1, "Murcia")); // afegeix l’objecte amb num = 1
        conjuntDemo1.add(new MeuClas(3, "Granada"));
        conjuntDemo1.add(new MeuClas(1, "Segovia")); // 1 està repetit, equals depén de num, no s'afig l’objecte
        conjuntDemo1.add(new MeuClas(11, "Vigo"));
        conjuntDemo1.add(new MeuClas(10, "Sevilla"));
        conjuntDemo1.add(new MeuClas(1, "Murcia")); // 1 està repetit, no s'afig l’objecte
        conjuntDemo1.add(new MeuClas(12, "València"));
        System.out.println("Conjunt modificable: \n" + conjuntDemo1); // visualitza [Vigo>>11, València

        // Como hacer una colección inmutable
        Set<MeuClas> conjuntInmutableDemo1 = Set.of(new MeuClas(1, "Murcia"), new MeuClas(3, "Granada"), new MeuClas(11, "Vigo"));
        System.out.println("\nConjunt inmutable Set.of: \n" + conjuntInmutableDemo1);
        //conjuntInmutableDemo1.add(new MeuClas(2, "Segovia"));

        Set<MeuClas> conjuntUnmodSetDemo1 = Collections.unmodifiableSet(conjuntDemo1);
        System.out.println("\nConjunt inmutable unmodifiableSet: \n" + conjuntUnmodSetDemo1);
        //conjuntUnmodSetDemo1.add(new MeuClas(20, "Alacant"));

        // Diferencia entre Set.of y unmodifiableSet
        conjuntDemo1.add(new MeuClas(20, "Alacant"));
        System.out.println("\nDiferencia entre Set.of y unmodifiableSet: \n" + conjuntUnmodSetDemo1);


        // Para ir un poco más allá vamos a ver que ocurre si modificamos los objetos de esas Colecciones
        MeuClas cordoba = new MeuClas(1, "Córdoba");
        MeuClas almeria = new MeuClas(5, "Almería");
        MeuClas malaga = new MeuClas(10, "Málaga");

        Set<MeuClas> conjuntDemo2 = new HashSet<>();
        conjuntDemo2.add(cordoba);
        conjuntDemo2.add(almeria);
        conjuntDemo2.add(malaga);

        Set<MeuClas> conjuntInmutableDemo2 = Set.of(cordoba, almeria, malaga);
        System.out.println("\nDEMO 2: Conjunt inmutable Set.of: \n" + conjuntInmutableDemo2);

        Set<MeuClas> conjuntUnmodSetDemo2 = Collections.unmodifiableSet(conjuntDemo2);
        System.out.println("\nDEMO 2: Conjunt inmutable unmodifiableSet: \n" + conjuntUnmodSetDemo2);

        cordoba.setTxt("Crdb");

        System.out.println("\nDEMO 2 CRBD: Conjunt inmutable Set.of: \n" + conjuntInmutableDemo2);
        System.out.println("\nDEMO 2 CRBD: Conjunt inmutable unmodifiableSet: \n" + conjuntUnmodSetDemo2);

    }

}
