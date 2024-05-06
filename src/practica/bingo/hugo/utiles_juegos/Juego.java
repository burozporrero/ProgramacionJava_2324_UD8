package practica.bingo.hugo.utiles_juegos;

import java.util.Scanner;

/**
 * Esta es la clase abstracta.
 * Con esta clase se comparten atributos y metodos para ambos juegos.
 */
public abstract class Juego {
    /**
     * Los jugadores que van a jugar
     */
    protected Jugadores jugadores;

    /**
     * Este metodo es el cosntructor, que se una al crear un {@code new Juego()}.
     *
     * @param jugadores Los jugadores que van a jugar.
     */
    public Juego(Jugadores jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Este metodo abstracto ejecuta el juego dependiendo de cual se elija
     *
     * @param sc El Scanner que se va a utilizar
     */
    public abstract void ejecutarJuego(Scanner sc);
}
