package teoria.datos_genericos;


public class Main {
    public static void main(String[] args) {

        Pareja<String, Integer> p1 = new Pareja<>("Juan", 20);

        System.out.println(p1.toString());
        Pareja.printTwoTypes(7, "Puedo permitirme incluso cambiar los tipos, al ser estático");
    }
}
