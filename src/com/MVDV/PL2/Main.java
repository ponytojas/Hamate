package com.MVDV.PL2;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Partida nuevaPartida = new Partida();
        String res = "SI";

        do{
            res=nuevaPartida.jugarJuego();


        }while (res.equals("NO"));
    }
}
