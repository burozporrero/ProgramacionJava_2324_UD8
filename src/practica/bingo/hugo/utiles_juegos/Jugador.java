package practica.bingo.hugo.utiles_juegos;

import practica.bingo.hugo.Bingo.BingoException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Scanner;

public class Jugador implements Serializable {

    @Serial
    private static final long serialVersionUID = 3310268640373528788L;
    private String nombre;
    private int vidas;
    private int contadorCorrectas;
    private int edad;
    private String ciudad;
    

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.vidas = 12;
        this.contadorCorrectas = 0;

    }

    public void agregarDatos(Scanner sc) {

        String edadStr;
        do {
            System.out.print("Ingrese la edad de " + nombre + ": ");
            edadStr = sc.nextLine();
        } while (!esNumero(edadStr));
        edad = Integer.parseInt(edadStr);
        System.out.print("Ingrese la ciudad de " + nombre + ": ");
        this.ciudad = sc.nextLine();
    }

    private boolean esNumero(String edadStr) {
        try {
            edad = Integer.parseInt(edadStr);
            return Boolean.TRUE;
        } catch (NumberFormatException e) {
            System.out.println("Por favor, introduce un número");
            return Boolean.FALSE;
        }
    }

    public void comprobarEdad() throws BingoException {
        if (edad < 18) {
            throw new BingoException("El jugador " + nombre + " es menor de edad y por lo tanto no podra jugar al Bingo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidas() {
        return vidas;
    }

    public void disminuirVida() {
        vidas--;
    }

    public int getContadorCorrectas() {
        return contadorCorrectas;
    }

    public void aumentarContadorCorrectas() {
        contadorCorrectas++;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public String datosCompletos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Edad: ").append(edad).append("\n");
        sb.append("Ciudad: ").append(ciudad).append("\n");
        return sb.toString();
    }
}
