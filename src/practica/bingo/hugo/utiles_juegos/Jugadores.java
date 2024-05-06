package practica.bingo.hugo.utiles_juegos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jugadores {

    public List<Jugador> jugadores = new ArrayList<>();

    public Jugadores(int cantidad, Scanner sc) {

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Agregue el nombre del jugador " + (i + 1) + ": ");

            jugadores.add(new Jugador(sc.nextLine()));
        }
    }

    public boolean estanMuertos() {

        for (Jugador jugador : jugadores) {

            if (jugador.getVidas() <= 0) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public void restablecerVidas() {

        for (Jugador jugador : jugadores) {
            jugador.setVidas(12);
        }
    }
}
