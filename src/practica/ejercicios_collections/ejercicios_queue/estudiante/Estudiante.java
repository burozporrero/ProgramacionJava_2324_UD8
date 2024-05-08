package practica.ejercicios_collections.ejercicios_queue.estudiante;

import java.text.Collator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Estudiante implements Comparable<Estudiante> {
    private static Collator collator = Collator.getInstance(new Locale("es", "ES"));
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private double notaMedia;

    public Estudiante(String nombre, String apellidos, LocalDate fechaNacimiento, double notaMedia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.notaMedia = notaMedia;
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estudiante persona = (Estudiante) o;
        return Double.compare(notaMedia, persona.notaMedia) == 0 && nombre.equals(persona.nombre) && apellidos.equals(persona.apellidos) && fechaNacimiento.equals(persona.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + apellidos.hashCode();
        result = 31 * result + fechaNacimiento.hashCode();
        result = 31 * result + Double.hashCode(notaMedia);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(getNombre()).append('\'');
        sb.append(", apellidos='").append(getApellidos()).append('\'');
        sb.append(", fechaNacimiento=").append(getFechaNacimiento());
        sb.append(", notaMedia=").append(getNotaMedia());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Estudiante otra) {

        int comparacion = Double.compare(this.getNotaMedia(), otra.getNotaMedia());
        if (comparacion == 0) {
            comparacion = collator.compare(this.nombre, otra.getNombre());
            if (comparacion == 0) {
                comparacion = collator.compare(this.apellidos, otra.getApellidos());
            }
        }
        return comparacion;
    }

    public static Estudiante crearEstudiante(String line) {
        String[] parts = line.split(";");
        String nombre = parts[0];
        String apellidos = parts[1];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate fechaNacimiento = LocalDate.parse(parts[2], formatter);
        double notaMedia = Double.parseDouble(parts[3]);
        return new Estudiante(nombre, apellidos, fechaNacimiento, notaMedia);
    }
}
