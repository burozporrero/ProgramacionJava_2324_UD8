package practica.bingo.hugo.Bingo;

import practica.bingo.hugo.utiles_juegos.*;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JuegoBingo extends Juego {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final File DIRECTORIO_PARTIDAS = new File("src/practica/bingo/hugo/Bingo/PartidasBingo");
    private static final int PARTIDAS_MAXIMAS = 10;
    private final List<Carton> CARTONES_GUARDADOS = new ArrayList<>();
    private final List<Integer> NUMEROS_SACADOS = new ArrayList<>();
    private File partidaGuardada;
    private int partidaSeleccionada;
    private int numRonda = 0;

    /**
     * Este metodo es el cosntructor, que se una al crear un {@code new Juego()}.
     *
     * @param jugadores Los jugadores que van a jugar.
     */
    public JuegoBingo(Jugadores jugadores, Scanner sc) throws BingoException {
        super(jugadores);
        this.partidaSeleccionada = preguntarCargarPartida(sc);
        if (partidaSeleccionada == 0) {

            for (Jugador jugador : jugadores.jugadores) {
                jugador.agregarDatos(sc);
                jugador.comprobarEdad();
            }
        }
    }

    @Override
    public void ejecutarJuego(Scanner sc) {

        if (partidaSeleccionada == 0) {
            for (int i = 0; i < jugadores.jugadores.size(); i++) {
                System.out.println("Carton del jugador: " + jugadores.jugadores.get(i).getNombre());
                CARTONES_GUARDADOS.add(new Carton());
                System.out.println(CARTONES_GUARDADOS.get(i).toString());
            }
        } else {
            cargarEstadoPartida();
            System.out.println(mostrarCartones());
        }

        if (preguntarListos(sc)) {
            System.out.println("EL bingo va a empezar");
            jugarBingo(sc);
        } else {
            System.out.println("Gracias por jugar");
        }
    }

    private boolean preguntarListos(Scanner sc) {

        System.out.println("¿Estáis listos para jugar al Bingo? (S/N)");
        char respuesta;
        do {
            try {
                respuesta = sc.next().toUpperCase().charAt(0);
            } catch (NoSuchElementException | IllegalStateException e) {
                System.err.println("Ha ocurrido un error inesperado.Se saldrá del programa");
                LOGGER.error("Hubo un error en el scanner en 'preguntarListos'" + e.getMessage());
                respuesta = 'N';
            }
            if (respuesta != 'S' && respuesta != 'N') {
                System.out.println("Por favor, introduce una respuesta válida (S/N)");
            }
        } while (respuesta != 'S' && respuesta != 'N');

        return respuesta == 'S';
    }

    private void jugarBingo(Scanner sc) {
        StringBuilder sb = new StringBuilder();
        boolean bingo = Boolean.FALSE;

        sb.append("Numeros sacados: ");
        while (!bingo) {
            bingo = jugarRonda(numRonda++, sb);
            if (NUMEROS_SACADOS.size() % 10 == 0) {
                if (preguntarSalir(sc)) {
                    partidaGuardada = guardarEstadoPartida();
                    if (partidaGuardada != null) {
                        System.out.println("La partida se ha guardado correctamente");
                        // LOGGER.info("Partida guardada con exito:" + partidaGuardada.getPath());
                    }
                    break;
                }
            }
        }
        if (partidaGuardada != null && bingo) {
            System.out.println("La partida se borro al ganar el bingo");
            //LOGGER.info("Partida guardada se borro con exito:" + partidaGuardada.delete());
        }
        System.out.println("Cartones finales: ");
        System.out.println(mostrarCartones());

    }

    private boolean jugarRonda(int numRonda, StringBuilder sb) {

        boolean seguir = Boolean.FALSE;

        int numeroAleatorio;

        System.out.println("Ronda: " + numRonda);
        numeroAleatorio = sacarNumero();
        System.out.println("Ha salido el número: " + numeroAleatorio);

        for (Carton carton : CARTONES_GUARDADOS) {
            String nombreJugador = jugadores.jugadores.get(CARTONES_GUARDADOS.indexOf(carton)).getNombre();

            if (carton.comprobarNumero(numeroAleatorio)) {
                System.out.println("El jugador " + nombreJugador + " ha tachado el número " + numeroAleatorio);
            }

            System.out.println("Carton del jugador: " + nombreJugador);
            System.out.println(carton);

            if (carton.isCartonVacio()) {
                System.out.println("Señoras y señores, el jugador " + nombreJugador + " ha cantado bingooooooooooo");
                System.out.println(jugadores.jugadores.get(CARTONES_GUARDADOS.indexOf(carton)).datosCompletos());
                seguir = Boolean.TRUE;
                break;
            }
        }
        sb.append(numeroAleatorio).append(" | ");
        System.out.println(sb);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Ha ocurrido un error inesperado");
            System.err.println("El bingo finalizara");
            //LOGGER.error("Error al dormir el hilo" + e.getMessage());
            return Boolean.TRUE;
        }
        return seguir;
    }

    private int sacarNumero() {

        Random random = new Random();
        int numeroAleatorio;
        do {
            numeroAleatorio = random.nextInt(90) + 1;
        } while (NUMEROS_SACADOS.contains(numeroAleatorio));
        NUMEROS_SACADOS.add(numeroAleatorio);
        return numeroAleatorio;
    }

    private String mostrarCartones() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CARTONES_GUARDADOS.size(); i++) {
            sb.append("Carton del jugador: ").append(jugadores.jugadores.get(i).getNombre()).append("\n");
            sb.append(CARTONES_GUARDADOS.get(i).toString());
        }
        return sb.toString();
    }

    private boolean preguntarSalir(Scanner sc) {

        char opcion;

        do {
            System.out.println("¿Se desea salir? S/N");
            try {
                opcion = sc.next().toUpperCase().charAt(0);
            } catch (NoSuchElementException | IllegalStateException e) {
                System.err.println("Ha ocurrido un error inesperado. Se saldrá del programa");
                LOGGER.error("Hubo un error en el scanner en 'preguntarSalir'" + e.getMessage());
                opcion = 'N';
                //TODO cuidado con poner la siguiente línea. Por el tipo de error, puede que el scanner se haya roto y
                // es posible que no se pueda continuar, así que le estamos metiendo en un bucle infinito de ser el caso
                //opcion = ' ';
            }

            if (opcion != 'S' && opcion != 'N') {
                System.out.println("Por favor, introduzca un valor correcto");
            }
        } while (opcion != 'S' && opcion != 'N');

        return opcion == 'S';
    }

    private File guardarEstadoPartida() {
        boolean esPartidaGuardada = Boolean.FALSE;
        if(!DIRECTORIO_PARTIDAS.exists()){
            DIRECTORIO_PARTIDAS.mkdirs();
        }

        if (DIRECTORIO_PARTIDAS.listFiles() != null) {

            for (int i = 1; i <= DIRECTORIO_PARTIDAS.listFiles().length || i <= PARTIDAS_MAXIMAS; i++) {
                File partida = new File(DIRECTORIO_PARTIDAS, "partida" + i + ".dat");

                if (!partida.exists()) {
                    esPartidaGuardada = serializarPartida(partida);
                    break;
                }

                if (i == PARTIDAS_MAXIMAS) {
                    System.out.println("Se ha llegado al limite de partidas guardadas");
                    break;
                }
            }
        } else {
            File partida = new File(DIRECTORIO_PARTIDAS, "partida1.dat");
            esPartidaGuardada = serializarPartida(partida);
        }

        return esPartidaGuardada? partidaGuardada : null;
    }

    private boolean serializarPartida(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(CARTONES_GUARDADOS);
            oos.writeObject(NUMEROS_SACADOS);
            oos.writeObject(jugadores.jugadores);
            oos.writeObject(numRonda);
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error inesperado al guardar la partida");
            LOGGER.error("Error al guardar la partida" + e.getMessage());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @SuppressWarnings("unchecked")
    private void cargarEstadoPartida() {

        partidaGuardada = new File(DIRECTORIO_PARTIDAS, "partida" + partidaSeleccionada + ".dat");
        if (partidaGuardada.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(partidaGuardada))) {

                CARTONES_GUARDADOS.addAll((List<Carton>) ois.readObject());
                NUMEROS_SACADOS.addAll((List<Integer>) ois.readObject());
                jugadores.jugadores.clear();
                jugadores.jugadores.addAll((List<Jugador>) ois.readObject());
                numRonda = (int) ois.readObject();
            } catch (Exception e) {
                System.err.println("Ha ocurrido un error inesperado al cargar la partida");
                LOGGER.error("Error al cargar la partida" + e.getMessage());
            }
        } else {
            System.out.println("No se ha encontrado la partida seleccionada");
        }
    }

    private int preguntarCargarPartida(Scanner sc) {

        char opcion;
        //Reseteo el valor de la partida seleccionada anterior si la hubiese
        int partidaSeleccionada = 0;
        do {
            System.out.println("¿Desea cargar una partida anterior? S/N");
            try {
                opcion = sc.next().toUpperCase().charAt(0);
            } catch (NoSuchElementException | IllegalStateException e) {
                // Cargo un valor no válido
                opcion = ' ';
            }
            if (opcion != 'S' && opcion != 'N') {
                System.out.println("Por favor, introduzca un valor correcto");
            }
        } while (opcion != 'S' && opcion != 'N');

        if (opcion == 'S') {
            partidaSeleccionada = seleccionarPartida(sc);
        }
        return partidaSeleccionada;
    }

    private int seleccionarPartida(Scanner sc) {

        int contador = DIRECTORIO_PARTIDAS.listFiles() != null ? DIRECTORIO_PARTIDAS.listFiles().length : 0;

        if (contador != 0) {
            do {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("Tenemos guardardas desde la partida 1 hasta la " + contador + "\nElija la que quiera");
                try {
                    partidaSeleccionada = sc.nextInt();
                } catch (RuntimeException e) {
                    //Reseteo el valor de la partida seleccionada y lo dejo en un valor no válido
                    partidaSeleccionada = 0;
                }

                if (partidaSeleccionada < 1 || partidaSeleccionada > contador) {
                    System.out.println("Por favor, introduzca un valor correcto");
                }
            } while (partidaSeleccionada < 1 || partidaSeleccionada > contador);
        } else {
            System.out.println("No hay partidas guardadas");
        }
        return partidaSeleccionada;
    }
}
