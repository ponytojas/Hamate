package com.MVDV.PL2;
import java.util.Locale;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Main {
    /**
     * Funcion principal del programa.
     * Realiza la llamada al constructor de la partida y comienza la partida
     * Si el jugador quiere volver a jugar otra partida elimina la primera y crea otra
     */

    public static void main(String[] args) {
        String res = "SI";
        do{
            Partida nuevaPartida = new Partida();
<<<<<<< HEAD
            //res=nuevaPartida.jugarJuego();
            res = nuevaPartida.preguntarJugador();
=======
            res=nuevaPartida.jugarJuego();
>>>>>>> 4e19e8f1aac7590372de9ab955d3f7cbafa8233f
            nuevaPartida = null; //Permite que la clase no tenga referencias y sea recogia por el garbage collector
        }while (res.equals("SI"));
    }
}
