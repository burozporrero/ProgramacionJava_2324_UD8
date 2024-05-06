package practica.bingo.hugo;

import practica.bingo.hugo.Bingo.BingoException;
import practica.bingo.hugo.Bingo.JuegoBingo;
import practica.bingo.hugo.Multiplicacion.JuegoMultiplicar;
import practica.bingo.hugo.ahorcado.JuegoAhorcado;
import practica.bingo.hugo.utiles_juegos.DosJugadores;
import practica.bingo.hugo.utiles_juegos.Juego;
import practica.bingo.hugo.utiles_juegos.Jugadores;
import practica.bingo.hugo.utiles_juegos.TresJugadores;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Clase principal de un programa con varios juegos.
 * Permite elegir cuantos jugadores quieren jugar, además de elegir entre 2 juegos
 *
 * @author Hugo Almodóvar Fuster
 * @version 1.1
 */

public class Principal {

    //private static final Logger LOG = LogManager.getLogger(Principal.class);
    static Scanner sc = new Scanner(System.in);

    /**
     * Este metodo es el punto de entrada de la aplicacion</br>
     * En el cual se gestiona la cantidad de jugadores y el juego y se ejecuta
     */
    public static void main(String[] args){

        Juego juego = null;
        Jugadores jugadores = null;
        char cantidadJugadores;
        char juegoSeleccionado;

        cantidadJugadores = pedirCantidadJugadores();

        if (cantidadJugadores == '2') {

            jugadores = new DosJugadores(sc);

        } else jugadores = new TresJugadores(sc);

        juegoSeleccionado = seleccionarJuego();

        if (juegoSeleccionado == '1') {

            juego = new JuegoMultiplicar(jugadores);

        } else if (juegoSeleccionado == '2') {
            juego = new JuegoAhorcado(jugadores);

        } else {
            try {
                juego = new JuegoBingo(jugadores, sc);
            }catch (BingoException e){
                System.err.println(e.getMessage());
                //LOG.error(e.getMessage());
                System.exit(0);
            }
        }

        juego.ejecutarJuego(sc);
        sc.close();
    }

    /**
     * Este metodo pide la cantidad de jugadores.
     * Solo será valido 2 o 3 jugadores.
     *
     * @return Devuelve el valor introducido en char.
     */
    public static char pedirCantidadJugadores() {

        char opcion = ' ';

        do {
            System.out.println("""
                    --Bienvenido al arcade el Bicho--
                    Esto es un beta, por lo tanto solo disponemos de 2 modos
                    Tenemos el modo de 2 jugadores o de 3 jugadores
                    Despues de seleccionar los jugadores selccionara el juego
                    En estos momentos solo disponemos de 2 juegos distintos
                    Cuantos van a jugar:""");
            try {
                opcion = sc.nextLine().charAt(0);
            } catch (NoSuchElementException | IllegalStateException | IndexOutOfBoundsException e) {
                System.err.println("Ha ocurrido un error inesperado\nReseteando programa...");
                System.exit(0);
            }

            if (opcion != '2' && opcion != '3') {
                System.out.println("Valor incorrecto...\nReseteando programa...");
            }

        } while (opcion != '2' && opcion != '3');
        return opcion;
    }

    /**
     * Este metodo permite seleccionar el juego.
     * Solo admite 2 numeros el 1 y el 2
     *
     * @return Devuelve el valor introducido en char
     */
    public static char seleccionarJuego() {

        char opcion = ' ';

        do {
            System.out.println("""
                    --Seleccione que juego quiere porbar--
                    1. Multiplication Game
                    2. Ahorcado
                    3. Bingo""");

            try {
                opcion = sc.next().charAt(0);
            } catch (NoSuchElementException | IllegalStateException | IndexOutOfBoundsException e) {
                System.err.println("Ha ocurrido un error inesperado\nReseteando programa...");
                System.exit(0);
            }

            if (opcion != '1' && opcion != '2' && opcion != '3') {
                System.out.println("Se ha introducido un valor incorrecto\nIntentelo de nuevo");
            }

        } while (opcion != '1' && opcion != '2' && opcion != '3');
        sc.nextLine();
        return opcion;
    }
}
