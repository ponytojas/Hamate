package com.MVDV.PL2;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Partida {

    private ArrayList <CartaEnMazo> mazo = new ArrayList <>();
    private Tablero tableroPartida = new Tablero();
    private Jugador maquina = new Jugador(true);
    private Jugador jugador = new Jugador(false);


    public String jugarJuego (){
        int contador = 0;
        do{
            Random rand = new Random();
            int izq = rand.nextInt(7)+1;
            int der = rand.nextInt(7) +1;

            Carta nuevaCarta = new Carta(izq, der);
            CartaEnMazo cartaMazo = new CartaEnMazo(nuevaCarta.getValorIzq(),nuevaCarta.getValorDer());
            this.mazo.add(cartaMazo);
            contador+=1;
        }while (contador < 110);

        while(!maquina.getisLlena()){
            maquina.recibirCarta(this.mazo.get(0));
            this.mazo.remove(0);
        }
        while (!jugador.getisLlena()){
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
            for (HuecoDelTablero huecoAux : this.tableroPartida.getCartasYaBajadas())  //PREGUNTAR COMO FUNCIONABA EL BUCLE
                huecoAux.dibujarHueco();
            System.out.println("\n\n*************MANO JUGADOR*************\n");
            this.jugador.mostrarMano();
            System.out.println("Elige una carta a bajar: ");
            int posicionMano = (entrada.nextInt()) - 1;
            System.out.println("\nElige una posicion para bajar");
            int posicionTablero = (entrada.nextInt()) - 1;

            if (this.tableroPartida.comprobarPosicion(posicionTablero))
                throw new HuecoOcupado("El hueco esta ocupado, elige una posicion vacia\\n\\n\\n\\n\"");

            else
                jugar(posicionMano, posicionTablero, this.jugador.getisMaquina());
        }catch (HuecoOcupado msg){
            System.out.println("\n\n\n\n\nEl hueco esta ocupado, elige una posicion vacia\n\n\n\n\n");
            turnoJugador();
        }
    }

    private void turnoMaquina(){
       try{
        Random rand = new Random();
        int posicionMano = rand.nextInt(maquina.getManoSize());
        int posicionTablero = rand.nextInt(tableroPartida.getCartasYaBajadasSize());

        if (this.tableroPartida.comprobarPosicion(posicionTablero))
            throw new HuecoOcupado("El hueco esta ocupado, elige una posicion vacia\\n\\n\\n\\n\"");

        else
            jugar(posicionMano, posicionTablero, this.maquina.getisMaquina());

        }catch (HuecoOcupado msg){
            turnoMaquina();}

    }

    private void jugar(int posicionCartaMano, int huecoTablero, boolean isMaquina){
        CartaEnMano cartaAux;
        if (!isMaquina){
            cartaAux = this.jugador.getcarta(posicionCartaMano);
            this.jugador.soltarCarta(posicionCartaMano);
        }else{
            cartaAux = this.maquina.getcarta(posicionCartaMano);
            this.maquina.soltarCarta(posicionCartaMano);
        }
        CartaEnJuego nuevaCartaEnTablero = new CartaEnJuego(cartaAux.getValorIzq(), cartaAux.getValorDer(), isMaquina);
        this.tableroPartida.ponerLaCartaEnElTablero(nuevaCartaEnTablero, huecoTablero);
    }


    class HuecoOcupado extends Exception {

        public HuecoOcupado() {
        }
        public HuecoOcupado(String msg) {
            super("Excepcion definida por el usuario: " + msg);
        }
    }
}
