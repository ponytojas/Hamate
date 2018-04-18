package com.MVDV.PL2;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {

    private ArrayList <CartaEnMazo> mazo = new ArrayList <>();
    private Tablero tableroPartida = new Tablero();
    private Jugador maquina = new Jugador(true);
    private Jugador jugador = new Jugador(false);


    public String jugarJuego (){
        int contador = 0;

        do{
            int izq = (int)(Math.random() * ((12) + 1));
            int der = (int)(Math.random() * ((12) + 1));

            Carta nuevaCarta = new Carta(izq, der);
            CartaEnMazo cartaMazo = new CartaEnMazo(nuevaCarta.getValorIzq(),nuevaCarta.getValorDer(),true);
            this.mazo.add(cartaMazo);
            contador+=1;
        }while (contador < 110);

        while(!maquina.isLlena()){
            maquina.recibirCarta(this.mazo.get(0));
            this.mazo.remove(0);
        }
        while (!jugador.isLlena()){
            jugador.recibirCarta(this.mazo.get(0));
            this.mazo.remove(0);
        }

        while (!tableroPartida.isLleno()){
            turnoJugador();
            turnoMaquina();
        }

        return "SI";
    }

    private void turnoJugador(){
        if (tableroPartida.getCurrentIndex() != 0)
            tableroPartida.mostrarPosicionesOcupadas();


        Scanner entrada = new Scanner(System.in);
        this.jugador.mostrarMano();
        System.out.println("Elige una carta a bajar: ");
        int posicionMano = (entrada.nextInt()) - 1;
        this.tableroPartida.mostrarPosicionesLibres();
        System.out.println("\nElige una posición para bajar");
        int posicionTablero = (entrada.nextInt()) - 1;
        reto(posicionMano, posicionTablero, this.jugador.isMaquina());

    }

    private void turnoMaquina(){

    }

    private void reto(int posicionCartaMano, int huecoTablero, boolean isMaquina){

    }

}
