package teoria.datos_genericos;

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
