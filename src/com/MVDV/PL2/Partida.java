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

        while (!this.tableroPartida.estaElTableroLleno()){
            turnoJugador();
            turnoMaquina();
        }
        return "SI";
    }

    private void turnoJugador(){
        try {
            Scanner entrada = new Scanner(System.in);
            for (HuecoDelTablero huecoAux : this.tableroPartida.getCartasYaBajadas())
                huecoAux.dibujarHueco();
            System.out.println("\n\n*************MANO*************\n");
            this.jugador.mostrarMano();
            System.out.println("Elige una carta a bajar: ");
            int posicionMano = (entrada.nextInt()) - 1;
            System.out.println("\nElige una posición para bajar");
            int posicionTablero = (entrada.nextInt()) - 1;
            if (this.tableroPartida.comprobarPosicion(posicionTablero))
                throw new HuecoOcupado("El hueco esta ocupado, elige una posicion vacia\\n\\n\\n\\n\"");

            else
                jugar(posicionMano, posicionTablero, this.jugador.isMaquina());
        }catch (HuecoOcupado msg){
            System.out.println("\n\n\n\n\nEl hueco esta ocupado, elige una posicion vacia\n\n\n\n\n");
            turnoJugador();
        }
    }

    private void turnoMaquina(){

    }

    private void jugar(int posicionCartaMano, int huecoTablero, boolean isMaquina){
        CartaEnMano cartaAux;
        if (!isMaquina){
            cartaAux = this.jugador.getCarta(posicionCartaMano);
            this.jugador.soltarCarta(posicionCartaMano);
        }else{
            cartaAux = this.maquina.getCarta(posicionCartaMano);
            this.maquina.soltarCarta(posicionCartaMano);
        }
        CartaEnJuego nuevaCartaEnTablero = new CartaEnJuego(cartaAux.getValorIzq(), cartaAux.getValorDer(), isMaquina, huecoTablero);
        tableroPartida.ponerLaCartaEnElTablero(nuevaCartaEnTablero, huecoTablero);
    }


    class HuecoOcupado extends Exception {

        public HuecoOcupado() {
        }
        public HuecoOcupado(String msg) {
            super("Excepción definida por el usuario: " + msg);
        }
    }
}
