package teoria.mutabilidad;

public class MeuClas {

    private int num;
    private String txt;

    public MeuClas(int num, String id) { // constructor
        this.num = num;
        this.txt = id;
    }

    public void setTxt(String txt) { // pot canviar el camp txt després de la construcció
        this.txt = txt;
    }

    public void setNum(int num) { // pot canviar el camp num després de la construcció
        this.num = num;
    }

    @Override
    public String toString() {
        return txt + ">>" + num;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.num; // el HashCode de l’objecte depén de num
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MeuClas other = (MeuClas) obj;
        return this.num == other.num;
    }

}
