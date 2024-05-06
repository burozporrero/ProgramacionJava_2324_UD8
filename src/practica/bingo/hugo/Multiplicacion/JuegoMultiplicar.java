package practica.bingo.hugo.Multiplicacion;

import practica.bingo.hugo.utiles_juegos.Juego;
import practica.bingo.hugo.utiles_juegos.Jugadores;

import java.util.Random;
import java.util.Scanner;

public class JuegoMultiplicar extends Juego {

    public JuegoMultiplicar(Jugadores jugadores) {
        super(jugadores);
    }


    @Override
    public void ejecutarJuego(Scanner sc) {

        Random rand = new Random();
        boolean esCorrecto = Boolean.TRUE;

        while (esCorrecto) {

            for (int numJugador = 0; numJugador < jugadores.jugadores.size(); numJugador++) {

                int valorAleatorio1 = rand.nextInt(50) + 1;
                int valorAleatorio2 = rand.nextInt(50) + 1;
                int resultado = valorAleatorio1 * valorAleatorio2;

                System.out.println("Turno de  " + (jugadores.jugadores.get(numJugador).getNombre()));
                System.out.print(imprimirMultiplicacion(valorAleatorio1, valorAleatorio2));

                if (resultado != getRespuestaJugador(sc)) {

                    System.out.println("El jugador " + (jugadores.jugadores.get(numJugador).getNombre()) + " ha perdido");
                    System.out.println("El resultado era " + resultado);
                    esCorrecto = Boolean.FALSE;
                    System.out.println(respuestasCorrectas());
                    break;
                } else {
                    System.out.println("Multiplicacion acertada!!");
                    jugadores.jugadores.get(numJugador).aumentarContadorCorrectas();
                }
            }
        }
    }

    public String respuestasCorrectas() {
        StringBuilder sbRespuestasCorrectas = new StringBuilder();

        for (int i = 0; i < jugadores.jugadores.size(); i++) {

            sbRespuestasCorrectas.append("El jugador ")
                    .append(jugadores.jugadores.get(i).getNombre())
                    .append(" ha acertado ")
                    .append(jugadores.jugadores.get(i).getContadorCorrectas())
                    .append(" multiplicaciones\n");
        }
        return String.valueOf(sbRespuestasCorrectas);
    }

    public String imprimirMultiplicacion(int multiplicando1, int multiplicando2) {
        StringBuilder sb = new StringBuilder();
        sb.append(multiplicando1);
        sb.append(" * ");
        sb.append(multiplicando2);
        sb.append(" = ");

        return String.valueOf(sb);
    }

    public int getRespuestaJugador(Scanner sc) {
        return sc.nextInt();
    }
}
