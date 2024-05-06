package practica.bingo.hugo.ahorcado;

import practica.bingo.hugo.utiles_juegos.Juego;
import practica.bingo.hugo.utiles_juegos.Jugador;
import practica.bingo.hugo.utiles_juegos.Jugadores;

import java.io.*;
import java.util.*;

/**
 * Esta clase representa el juego del ahorcado.
 * Extiende la clase Juego y sobrescribe sus métodos para proporcionar la funcionalidad del juego del ahorcado.
 *
 * @author Hugo Almodovar
 * @version 1.1
 */
public class JuegoAhorcado extends Juego {

    private final List<Incognita> LISTA_INCOGNITAS = new ArrayList<>();
    private String palabraAdivinar;
    private static final int PISTA = 6;
    private static final int NUMERO_PALABRAS = 7;
    //private static final Logger LOGGER = LogManager.getLogger(JuegoAhorcado.class.getSimpleName());

    /**
     * Constructor para la clase JuegoAhorcado.
     *
     * @param jugadores Los jugadores del juego.
     */
    public JuegoAhorcado(Jugadores jugadores) {
        super(jugadores);
    }

    /**
     * Este método se utiliza para ejecutar el juego del ahorcado.
     * Inicializa las palabras, llena el vector de palabras y luego inicia el bucle del juego.
     *
     * @param sc El escáner para leer la entrada del usuario.
     */
    @Override
    public void ejecutarJuego(Scanner sc) {

        inicializarPalabras();
        rellenarVectorPalabras();

        for (Incognita incognita : LISTA_INCOGNITAS) {
            jugarTurno(sc, incognita);
        }

        System.out.println(respuestasCorrectas());
    }
    
    private void jugarTurno(Scanner sc, Incognita incognita) {

        StringBuilder letrasUsadas = new StringBuilder();
        StringBuilder sb = new StringBuilder(incognita.getTexto().length());
        palabraAdivinar = incognita.getTexto();
        iniciarPalabraResolver(sb);
        jugadores.restablecerVidas();
        boolean palabraAcertada = Boolean.FALSE;

        do {
            for (Jugador jugador : jugadores.jugadores) {
                imprimirEstadisitcas(jugador, sb);
                System.out.println("Las letras usadas son: " + letrasUsadas);

                char opcion = seleccionarIntroducir(sc);
                if (opcion == '1') {
                    char letra = pedirLetra(sc, letrasUsadas);
                    comprobarLetraAcertada(letra, sb, jugador);

                    if (sb.toString().contains("_")) {
                        System.out.println("La palabra no ha sido adivinada");
                    } else {
                        palabraAcertada = esPalabraAcertada(sb, jugador);
                    }

                    letrasUsadas.append("|").append(letra).append("|");
                } else {
                    String palabraSupuesta = pedirPalabra(sc);
                    if (comprobarPalabra(palabraSupuesta, jugador)) {
                        palabraAcertada = true;
                    }
                }

                if (jugador.getVidas() == PISTA) {
                    imprimirTipo();
                }
            }
        } while (!palabraAcertada && !jugadores.estanMuertos());
    }

    private char pedirLetra(Scanner sc, StringBuilder letrasUsadas) {

        char letra;
        do {
            System.out.println("Introduzca una letra:");
            try {
                letra = sc.next().toLowerCase().charAt(0);
            } catch (NoSuchElementException | IllegalStateException | IndexOutOfBoundsException e) {
                System.err.println("Error al introducir la letra");
                //LOGGER.error(e.getStackTrace());
                letra = ' ';
            }
            if (letrasUsadas.toString().contains(Character.toString(letra))) {
                System.out.println("La letra ya ha sido usada");
            }
        } while (!Character.isLetter(letra) || letrasUsadas.toString().contains(Character.toString(letra)));
        return letra;
    }

    private String pedirPalabra(Scanner sc) {

        try {
            sc.nextLine();
            System.out.println("Introduzca la palabra:");
            return sc.nextLine();
        } catch (NoSuchElementException | IllegalStateException e) {
            System.err.println("Error al introducir la palabra");
            //LOGGER.error(e.getStackTrace());
            return null;
        }
    }

    /**
     * Este método se utiliza para inicializar las palabras para el juego.
     * Crea listas de libros, películas y grupos musicales, y los añade a un archivo .dat.
     */
    private void inicializarPalabras() {

        List<Incognita> libros = Arrays.asList(
                new Libro("a traves de mi ventana"),
                new Libro("antes de diciembre"),
                new Libro("culpa mia"),
                new Libro("la zapatera prodigiosa"),
                new Libro("boulevard"),
                new Libro("a dos metros de ti"),
                new Libro("de la planidad a la cuarta dimension"),
                new Libro("entrevisillos"),
                new Libro("la casa de bernarda alba"),
                new Libro("la dama boba"));

        List<Incognita> peliculas = Arrays.asList(
                new Pelicula("dando la nota"),
                new Pelicula("ratatouille"),
                new Pelicula("cars"),
                new Pelicula("el club de los rompe huesos"),
                new Pelicula("niños grandes"),
                new Pelicula("el rey leon"),
                new Pelicula("matrix"),
                new Pelicula("el señor de los anillos"),
                new Pelicula("el hobbit"),
                new Pelicula("cazafantasmas"));

        List<Incognita> gruposMusicales = Arrays.asList(
                new GrupoMusical("vetusta morla"),
                new GrupoMusical("el canto del loco"),
                new GrupoMusical("estopa"),
                new GrupoMusical("fito y fitipaldis"),
                new GrupoMusical("queen"),
                new GrupoMusical("the beatles"),
                new GrupoMusical("rolling stones"),
                new GrupoMusical("jarabe de palo"),
                new GrupoMusical("nirvana"),
                new GrupoMusical("ac dc"));

        agregarPalabrasFichero(libros, "FicheroLibro.dat");
        agregarPalabrasFichero(peliculas, "FicheroPelicula.dat");
        agregarPalabrasFichero(gruposMusicales, "FicheroGrupoMusical.dat");
    }

    /**
     * Este método se utiliza para llenar el vector de palabras con palabras de los archivos .dat.
     * Asegura que las palabras sean diferentes.
     */
    private void rellenarVectorPalabras() {
        Random random = new Random();
        int tipo;

        do {
            LISTA_INCOGNITAS.clear();
            for (int i = 0; i < NUMERO_PALABRAS; i++) {

                tipo = random.nextInt(3);

                switch (tipo) {
                    case 0:
                        LISTA_INCOGNITAS.add(new Libro(agregarIncoginitas("FicheroLibro.dat").getTexto()));
                        break;
                    case 1:
                        LISTA_INCOGNITAS.add(new Pelicula(agregarIncoginitas("FicheroPelicula.dat").getTexto()));
                        break;
                    default:
                        LISTA_INCOGNITAS.add(new GrupoMusical(agregarIncoginitas("FicheroGrupoMusical.dat").getTexto()));
                }
            }
        } while (verificarPalabraRepetida());
    }

    /**
     * Este método se utiliza para añadir palabras del archivo .dat a la lista de incognitas.
     *
     * @param nombreFichero El nombre del archivo .dat.
     * @return Un objeto Incognita con la palabra del archivo .dat.
     */
    private Incognita agregarIncoginitas(String nombreFichero) {

        Random random = new Random();
        List<Incognita> listadoIncognitas = new ArrayList<>();

        try {
            FileInputStream file = new FileInputStream("src/juegos/ahorcado/" + nombreFichero);
            ObjectInputStream ois = new ObjectInputStream(file);

            Incognita incognita;
            while ((incognita = (Incognita) ois.readObject()) != null) {
                listadoIncognitas.add(incognita);
            }

            ois.close();
        } catch (EOFException e) {
            //LOGGER.info("Fin de fichero");
        } catch (ClassNotFoundException | IOException e) {

            System.err.println("Error al leer el fichero");
            //LOGGER.error(e.getStackTrace());
        }

        int indiceAleatorio = random.nextInt(listadoIncognitas.size());
        return listadoIncognitas.get(indiceAleatorio);

    }

    /**
     * Este método se utiliza para reiniciar el contador para el juego.
     *
     * @param sb El objeto StringBuilder que representa la palabra a adivinar.
     */
    private void iniciarPalabraResolver(StringBuilder sb) {

        char[] palabraSeparada = palabraAdivinar.toCharArray();

        for (int i = 0; i < palabraSeparada.length; i++) {

            sb.append('_');
            if (palabraSeparada[i] == ' ') {

                sb.setCharAt(i, ' ');
            }
        }
    }

    /**
     * Este método se utiliza para comprobar si la palabra adivinada es correcta.
     *
     * @param sb      El objeto StringBuilder que representa la palabra a adivinar.
     * @param jugador El jugador que está en turno.
     * @return Un valor booleano que indica si la palabra adivinada es correcta.
     */
    private boolean esPalabraAcertada(StringBuilder sb, Jugador jugador) {

        if (sb.toString().equalsIgnoreCase(palabraAdivinar)) {

            System.out.println("La palabra es correcta\nPasando a la siguiente\n----------------------------");
            jugador.aumentarContadorCorrectas();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Este método se utiliza para imprimir las estadísticas del juego.
     *
     * @param jugador El jugador que está en turno.
     * @param sb      El objeto StringBuilder que representa la palabra a adivinar.
     */
    private void imprimirEstadisitcas(Jugador jugador, StringBuilder sb) {
        System.out.println("Turno de " + jugador.getNombre());
        System.out.println("Contador de vidas: " + jugador.getVidas());
        System.out.println("Palabra a adivinar: " + sb.toString());
    }

    /**
     * Este método se utiliza para seleccionar si se quiere introducir una letra o resolver la palabra.
     *
     * @param sc El escáner para leer la entrada del usuario.
     * @return Un valor char que indica la opción seleccionada.
     */
    private char seleccionarIntroducir(Scanner sc) {

        char opcion = ' ';

        do {

            System.out.println("""
                    Seleccione si quiere agregar una letra o resolver la palabra
                    Introduzca el numero de delante de la palabra
                    1. Agregar letras
                    2. Resolver palabra""");
            try {
                opcion = sc.next().charAt(0);
            } catch (NoSuchElementException | IllegalStateException | IndexOutOfBoundsException e) {
                System.err.println("Ha ocurrido un error inesperado\n");
                //LOGGER.error(e.getStackTrace());
            }

            if (opcion != '1' && opcion != '2') {
                System.out.println("Valor incorrecto intentelo de nuevo");
            }

        } while (opcion != '1' && opcion != '2');
        return opcion;
    }

    /**
     * /**
     * Este método se utiliza para comprobar la letra adivinada.
     *
     * @param letra   La letra adivinada.
     * @param sb      El objeto StringBuilder que representa la palabra a adivinar.
     * @param jugador El jugador que está en turno.
     */
    private void comprobarLetraAcertada(char letra, StringBuilder sb, Jugador jugador) {

        char[] palabraSeparada = palabraAdivinar.toCharArray();

        if (palabraAdivinar.contains(Character.toString(letra))) {
            for (int i = 0; i < palabraSeparada.length; i++) {

                if (palabraSeparada[i] == letra) {

                    sb.setCharAt(i, letra);

                }
            }
        } else {
            jugador.disminuirVida();
        }
    }

    /**
     * Este método se utiliza para imprimir el tipo de la palabra cuando el jugador tiene 6 vidas.
     */
    private void imprimirTipo() {

        for (Incognita incognitaBuscar : LISTA_INCOGNITAS) {
            if (incognitaBuscar.getTexto().equalsIgnoreCase(palabraAdivinar)) {
                System.out.println("Al tener 6 vidas os damos una pista, el tipo de la palabra es: " + incognitaBuscar.getClass().getSimpleName());
            }
        }
    }

    /**
     * Este método se utiliza para verificar que las palabras sean diferentes.
     *
     * @return Un valor booleano que indica si las palabras son diferentes.
     */
    private boolean verificarPalabraRepetida() {

        HashSet<Incognita> incognitaHashSet = new HashSet<>();
        boolean seRepite = Boolean.FALSE;

        for (int i = 0; i < LISTA_INCOGNITAS.size(); i++) {
            if (!incognitaHashSet.add(LISTA_INCOGNITAS.get(i))) {
                LISTA_INCOGNITAS.remove(LISTA_INCOGNITAS.get(i));
                seRepite = Boolean.TRUE;
            }
        }
        return seRepite;
    }

    /**
     * Este método se utiliza para comprobar la palabra adivinada.
     *
     * @param palabra La palabra adivinada.
     * @param jugador El jugador que está en turno.
     * @return Un valor booleano que indica si la palabra adivinada es correcta.
     */
    private boolean comprobarPalabra(String palabra, Jugador jugador) {

        boolean esCorrecta = Boolean.FALSE;

        if (palabra != null && palabra.equalsIgnoreCase(palabraAdivinar)) {

            System.out.println("La palabra es correcta\nPasando a la siguiente\n----------------------------");
            jugador.aumentarContadorCorrectas();
            esCorrecta = Boolean.TRUE;

        } else {
            System.out.println("La palabra no es correcta");
            jugador.disminuirVida();
        }

        return esCorrecta;
    }

    /**
     * Este método se utiliza para añadir palabras al archivo .dat.
     *
     * @param listaPalabras La lista de palabras a añadir al archivo .dat.
     * @param nombreFichero El nombre del archivo .dat.
     */
    private void agregarPalabrasFichero(List<Incognita> listaPalabras, String nombreFichero) {

        try {
            File file = new File("src/juegos/ahorcado/" + nombreFichero);

            if (file.length() == 0) {

                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for (Incognita incognita : listaPalabras) {
                    oos.writeObject(incognita);
                }

                oos.close();
            }
        } catch (IOException e) {
            //LOGGER.error(e.getStackTrace());
            System.err.println("Error al escribir en el fichero");
        }
    }

    /**
     * Este método se utiliza para obtener las respuestas correctas para el juego.
     *
     * @return Una cadena que representa las respuestas correctas.
     */

    public String respuestasCorrectas() {
        StringBuilder sbRespuestasCorrectas = new StringBuilder();

        for (int i = 0; i < jugadores.jugadores.size(); i++) {
            sbRespuestasCorrectas.append("El jugador ")
                    .append(jugadores.jugadores.get(i).getNombre())
                    .append(" ha acertado ")
                    .append(jugadores.jugadores.get(i).getContadorCorrectas())
                    .append(" palabras correctas\n");
        }
        return String.valueOf(sbRespuestasCorrectas);
    }
}
