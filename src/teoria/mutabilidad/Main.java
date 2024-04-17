package teoria.mutabilidad;

import java.util.*;

public class Main {

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

        MeuClas nou = new MeuClas(3, "Granada");

        for (MeuClas ref :  conjuntDemo1) {
            if (ref.equals(nou)){ ref.setNum(33); }
        }

        System.out.println("\nConjunt modificable modificado Granada: \n" +conjuntDemo1);

        nou = new MeuClas(33, "Granada");

        System.out.println("\nconté "+nou+"? >>>" + conjuntDemo1.contains(nou));

        for (MeuClas ref :  conjuntDemo1) {
            if (ref.equals(nou)){
                System.out.println("\n1. ref hashCode = " + ref.hashCode() + " nou hashCode = " + nou.hashCode());
            }
            if (Objects.equals(ref, nou)){
                System.out.println("2. ref hashCode = " + ref.hashCode() + " nou hashCode = " + nou.hashCode());
            }
        }
    }

}
