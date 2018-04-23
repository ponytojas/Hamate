package com.MVDV.PL2;
import java.util.Locale;
import java.util.Scanner;

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
        Scanner entrada = new Scanner(System.in);
        Partida nuevaPartida = new Partida();
        String res = "SI";
        nuevaPartida = null; //Permite que la clase no tenga referencias y sea recogia por el garbage collector

        do{
            res=nuevaPartida.jugarJuego();


        }while (res.equals("NO"));
    }
}
