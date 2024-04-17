package teoria.enums;

import java.util.Scanner;

// Enum Planeta que implementa la interfaz InformacionPlanetaria
public enum Planeta implements InformacionPlanetaria {
    // Constantes Enum
    MERCURIO(3.285E+23, 2.4397E6),
    VENUS(4.867E+24, 6.0518E6),
    TIERRA(5.972E+24, 6.371E6),
    MARTE(6.39E+23, 3.3895E6),
    JUPITER(1.898E+27, 7.1492E7),
    SATURNO(5.683E+26, 6.0268E7),
    URANO(8.681E+25, 2.5559E7),
    NEPTUNO(1.024E+26, 2.4746E7);

    // Campos adicionales
    private final double masa; // en kg
    private final double radio; // en metros

    // Constructor
    private Planeta(double masa, double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    // Métodos
    public double getMasa() {
        return masa;
    }

    public double getRadio() {
        return radio;
    }

    // Método para calcular la gravedad superficial
    public double calcularGravedadSuperficial() {
        final double G = 6.67300E-11;
        return G * masa / (radio * radio);
    }

    // Implementación del método de la interfaz para mostrar información
    @Override
    public void mostrarInformacion() {
        System.out.println("Planeta: " + this.name());
        System.out.println("Masa: " + masa + " kg");
        System.out.println("Radio: " + radio + " m");
        System.out.println("Gravedad superficial: " + calcularGravedadSuperficial() + " m/s^2");
    }

    // Método estático para buscar un planeta por su nombre
    public static Planeta buscarPorNombre(String nombre) {
        for (Planeta planeta : Planeta.values()) {
            if (planeta.name().equalsIgnoreCase(nombre)) {
                return planeta;
            }
        }
        return null;
    }

    // Método main para probar el Enum
    public static void main(String[] args) {
        for (Planeta planeta : Planeta.values()) {
            planeta.mostrarInformacion();
            System.out.println("-------------------------");
        }

        // Ejemplo de uso del método estático buscarPorNombre
        System.out.println("Buscando planeta por nombre:");
        Planeta planetaBuscado = Planeta.buscarPorNombre("tierra");
        if (planetaBuscado != null) {
            System.out.println("Planeta encontrado:");
            planetaBuscado.mostrarInformacion();
        } else {
            System.out.println("No se encontró ningún planeta con ese nombre.");
        }

        System.out.println("-------------------------");
        // Entrada por teclado y conversión a Enum Planeta con valueOf()
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre de un planeta:");
        String nombrePlaneta = scanner.nextLine().toUpperCase(); // Convertimos a mayúsculas para comparar con los nombres de los Enum
        try {
            Planeta planetaIntroducido = Planeta.valueOf(nombrePlaneta);
            System.out.println("El planeta introducido se encuentra en la lista y su información es:");
            planetaIntroducido.mostrarInformacion();
        } catch (IllegalArgumentException e) {
            System.out.println("No se encontró ningún planeta con ese nombre.");
        }
        scanner.close();
    }
}
