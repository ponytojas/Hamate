package com.MVDV.PL2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

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
