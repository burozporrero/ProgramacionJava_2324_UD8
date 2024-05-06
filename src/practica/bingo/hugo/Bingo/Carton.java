package practica.bingo.hugo.Bingo;

import java.io.Serializable;
import java.util.*;

public class Carton implements Serializable {

   
    private static final int NUMERO_FILAS = 3;
    private static final int NUMERO_COLUMNAS = 9;
    private static final int NUMERO_VACIAR = 4;
    private static final long serialVersionUID = -6834003849700462040L;
    private String[][] carton = new String[NUMERO_FILAS][NUMERO_COLUMNAS];

    public Carton() {
        this.carton = creacionCarton();
    }

    private String[][] creacionCarton() {

        Random random = new Random();

        for (int i = 0; i < NUMERO_COLUMNAS; i++) {
            List<String> numeros = new ArrayList<>();
            do {
                int numeroAleatorio = random.nextInt(10) + i * 10;
                if (numeroAleatorio != 0 && !numeros.contains(String.valueOf(numeroAleatorio))) {
                    numeros.add(String.valueOf(numeroAleatorio));
                }
            } while (numeros.size() < NUMERO_FILAS);
            Collections.sort(numeros);
            for (int j = 0; j < NUMERO_FILAS; j++) {
                carton[j][i] = numeros.get(j);
            }
        }
        ajustarCarton();
        return carton;
    }

    private void ajustarCarton() {
        Random random = new Random();
        int numAletorio;

        for (int i = 0; i < NUMERO_FILAS; i++) {
            for (int j = 0; j < NUMERO_VACIAR; j++) {
                do {
                    numAletorio = random.nextInt(9);
                } while (carton[i][numAletorio].isEmpty());
                carton[i][numAletorio] = "";
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMERO_FILAS; i++) {
            for (int j = 0; j < NUMERO_COLUMNAS; j++) {
                if (carton[i][j].isEmpty()) {
                    sb.append(String.format("%4s", ""));
                } else {
                    sb.append(String.format("%4s", carton[i][j]));
                }
                sb.append(" |");
            }
            sb.append("\n");
            sb.append("-".repeat(54));
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isCartonVacio() {

        for (int i = 0; i < NUMERO_FILAS; i++) {
            for (int j = 0; j < NUMERO_COLUMNAS; j++) {
                if (!carton[i][j].isEmpty()) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    public boolean comprobarNumero(int numero) {

        for (int i = 0; i < NUMERO_FILAS; i++) {
            for (int j = 0; j < NUMERO_COLUMNAS; j++) {
                if (carton[i][j].equals(String.valueOf(numero))) {
                    carton[i][j] = "";
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }
}
