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
    Scanner entrada = new Scanner(System.in);

    /**
     * Funcion principal que genera la partida
     * Primeramente genera las cartas y las pone en el mazo
     * @return
     */

    public String jugarJuego (){
        Scanner entrada = new Scanner(System.in);
        int contador = 0;
        do{
            Random rand = new Random();
            this.mazo.add(new CartaEnMazo(rand.nextInt(7)+1, rand.nextInt(7) +1));
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
        return preguntarJugador();
    }

    private void turnoJugador(){
        try {

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

           int posicionTablero;
           int posicionMano;

           if(this.maquina.getManoSize() > 1) {
               Random rand = new Random();
               posicionMano = rand.nextInt(this.maquina.getManoSize());
               posicionTablero = rand.nextInt(tableroPartida.getCartasYaBajadasSize());
           }else{
               posicionMano = 0;
               posicionTablero = tableroPartida.getLastPlace();
           }

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
        this.tableroPartida.ponerLaCartaEnElTablero(nuevaCartaEnTablero, huecoTablero, isMaquina);
    }



    class HuecoOcupado extends Exception {

        public HuecoOcupado() {
        }
        public HuecoOcupado(String msg) {
            super("Excepcion definida por el usuario: " + msg);
        }
    }

    private String preguntarJugador(){
        ganoJugador();
        String respuestaJugador;
        System.out.println("¿Quieres jugar otra partida?");
        System.out.println("SI / NO");
        respuestaJugador = this.entrada.nextLine();
        respuestaJugador = respuestaJugador.toUpperCase();
        if (respuestaJugador.equals("SI") || respuestaJugador.equals("NO")){
            return respuestaJugador;
        }
        else
            System.out.println("La respuesta no es correcta");
           return respuestaJugador = preguntarJugador();
    }

    private void ganoJugador(){
        int cantidadJugador = tableroPartida.getcantidadCartas(true);
        int cantidadMaquina = tableroPartida.getcantidadCartas(false);
        int ganaJugador = 0;
        if (cantidadJugador > cantidadMaquina) ganaJugador = 1;
        if (cantidadJugador == cantidadMaquina) ganaJugador = 3;
        switch (ganaJugador){
            case 0:
                System.out.println("Gana la maquina con "+cantidadMaquina+" cartas de su color");
                break;
            case 1:
                System.out.println("Gana el jugador con "+cantidadJugador+" cartas de su color");
                break;
            default:
                System.out.println("Ha habido un empate");
        }
    }
}
