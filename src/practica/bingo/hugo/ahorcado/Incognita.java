package practica.bingo.hugo.ahorcado;

import java.io.Serializable;
import java.util.Objects;

public class Incognita implements Serializable {

    private String texto;

    public Incognita(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incognita incognita = (Incognita) o;
        return Objects.equals(texto, incognita.texto);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Incognita{");
        sb.append("texto='").append(texto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
