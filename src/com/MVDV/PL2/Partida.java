package com.MVDV.PL2;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Collections;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Partida {

    private ArrayList <CartaEnMazo> mazo = new ArrayList <>();
    private Tablero tableroPartida = new Tablero();
    private Jugador jugador = new Jugador(false);
    private Jugador maquina = new Jugador(true);
    Scanner entrada = new Scanner(System.in);
    //private TableroForm tableroInterface;

    public Partida(String nombre, String nif, int edad){
        this.jugador.setNombre(nombre);
        this.jugador.setEdad(edad);
        this.jugador.setNif(nif);
    }
    
    public Partida(){
    }
    
    /**
     * Funcion principal que genera la partida
     * Primeramente genera el mazo
     * Despues reparte las cartas a la maquian y al jugador
     * Por ultimo hace las llamadas a las funciones de los turnos y pregunta al jugador
     * @return Respuesta del jugador a si quiere o no jugar otra partida
     */

    public String jugarJuego (){
        Scanner entrada = new Scanner(System.in);
        do{
            Random rand = new Random();
            this.mazo.add(new CartaEnMazo(rand.nextInt(7)+1, rand.nextInt(7) +1));
        }while (this.mazo.size() < 110);

        while(!maquina.getisLlena()){
            maquina.recibirCarta(this.mazo.get(0));
            this.mazo.remove(0);
        }
        while (!jugador.getisLlena()){
            jugador.recibirCarta(this.mazo.get(0));
            this.mazo.remove(0);
        }
         //lanzarInterfaz();
        while (!this.tableroPartida.estaElTableroLleno()){
            //turnoInterface(); /*Si se descomenta esta línea y se comentan las dos siguientes, se podría jugar sin modo gráfico*/
            turnoJugador();
            if (!this.maquina.getDificultad())
                turnoMaquina();
            else
                turnoMaquinaAvanzado();
        }
        return this.preguntarJugador();
    }
    
    /*private void turnoInterface(){
        int posicionElegidaMano;
        int posicionElegidaTablero;
        
        while(this.tableroInterface.getposicionMano() == -1 || this.tableroInterface.getposicionTablero() == -1){
             try{
                    Thread.sleep(250);
                }catch(InterruptedException e){}   
        }
        posicionElegidaMano = this.tableroInterface.getposicionMano();
        posicionElegidaTablero = this.tableroInterface.getposicionTablero();
        this.tableroInterface.setposicionMano(-1);
        this.tableroInterface.setposicionTablero(-1);
        this.tableroInterface.pasarCartaManoAlTablero(posicionElegidaMano, posicionElegidaTablero, 0);
        jugar(posicionElegidaMano, posicionElegidaTablero, this.jugador.getisMaquina());
        turnoMaquina();
    }*/

    /**
     * Funcion del turno del jugador
     * Se le mostrara la situacion del tablero, y su mano
     * Se le preguntara por la carta que quiere bajar y la posicion
     * Tenemos una excepcion que controla si la posicion donde se quiere bajar es correcta o no
     * Por ultimo se juega la carta a la posicion donde se ha elegido
     */
    private void turnoJugador(){
        try {
            for (HuecoDelTablero huecoAux : this.tableroPartida.getCartasYaBajadas())
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

    /**
     * Funcion del turno del jugador
     * Elegimos con un elemento random la carta de la mano que se baja y la posicion
     */
    private void turnoMaquina(){
       try{
           int posicionTablero;
           int posicionMano;
           Random rand = new Random();
           try {
               posicionMano = ThreadLocalRandom.current().nextInt(0, this.maquina.getManoSize());
           }catch (java.lang.IllegalArgumentException e){
               posicionMano = 0;
           }
           try {
               posicionTablero = ThreadLocalRandom.current().nextInt(0, this.tableroPartida.getCantidadCartasVacias());
               posicionTablero = this.tableroPartida.getPosicionDelArrayVacio(posicionTablero);
           }catch (java.lang.IllegalArgumentException e){
               posicionTablero = this.tableroPartida.getPosicionDelArrayVacio(0);
           }
            if (this.tableroPartida.comprobarPosicion(posicionTablero))
                throw new HuecoOcupado("El hueco esta ocupado, elige una posicion vacia\\n\\n\\n\\n\"");
            else
                //this.tableroInterface.pasarCartaManoAlTablero(posicionMano, posicionTablero, 1);
                jugar(posicionMano, posicionTablero, this.maquina.getisMaquina());
       }catch (HuecoOcupado msg){
            turnoMaquina();}
    }

    /**
     * Esta funcion quita la carta de la mano al jugador o la maquina
     * Hacemos esto aqui y no antes porque ya sabemos que la carta elegida es correcta y no se ha lanzado ninguna excepcion
     * Por ultimo se coloca la carta en el tablero
     * @param posicionCartaMano Posicion de la carta en la mano
     * @param huecoTablero Posicion donde se quiere bajar la carta
     * @param isMaquina Es el jugador o la maquina
     */
    private void jugar(int posicionCartaMano, int huecoTablero, boolean isMaquina){
        CartaEnMano cartaAux;
        if (!isMaquina){
            cartaAux = this.jugador.getcarta(posicionCartaMano);
            this.jugador.soltarCarta(posicionCartaMano);
        }else{
            cartaAux = this.maquina.getcarta(posicionCartaMano);
            this.maquina.soltarCarta(posicionCartaMano);
        }
        this.tableroPartida.ponerLaCartaEnElTablero(new CartaEnJuego(cartaAux.getValorIzq(), cartaAux.getValorDer(), isMaquina), huecoTablero, isMaquina);
    }


    /**
     * Excepcion
     * Excepcion de control
     */
    class HuecoOcupado extends Exception {

        public HuecoOcupado() {
        }
        public HuecoOcupado(String msg) {
            super("Excepcion definida por el usuario: " + msg);
        }
    }

    /**
     * Metodo que pregunta al jugador si quiere jugar otra partida o no
     * @return La respuesta del jugador
     */
    private String preguntarJugador(){
        Scanner entrada = new Scanner(System.in);
        ganoJugador();
        String respuestaJugador;
        System.out.println("Jugar otra partida");
        System.out.println("SI / NO");
        respuestaJugador = entrada.nextLine();
        respuestaJugador = respuestaJugador.toUpperCase();
        if (respuestaJugador.equals("SI") || respuestaJugador.equals("NO")){
            return respuestaJugador;
        }
        else
            System.out.println("La respuesta no es correcta");
           return respuestaJugador = preguntarJugador();
    }

    /**
     * Metodo que comprueba que jugador gana
     */
    private void ganoJugador(){
        for (HuecoDelTablero huecoAux : this.tableroPartida.getCartasYaBajadas())
                huecoAux.dibujarHueco();
        int cantidadJugador = this.tableroPartida.getcantidadCartas(true);
        int cantidadMaquina = tableroPartida.getcantidadCartas(false);
        int ganaJugador = 0;
        if (cantidadJugador > cantidadMaquina) ganaJugador = 1;
        if (cantidadJugador == cantidadMaquina) ganaJugador = 3;
        switch (ganaJugador){
            case 0:
                System.out.println("\n\n\nGana la maquina con "+cantidadMaquina+" cartas de su color");
                break;
            case 1:
                System.out.println("\n\n\nGana el jugador "+this.jugador.getNombre()+" con "+cantidadJugador+" cartas de su color");
                break;
            default:
                System.out.println("\n\n\nHa habido un empate");
        }
    }
 
    /*private void lanzarInterfaz (){
        this.tableroInterface = new TableroForm(this.jugador, this.maquina);     
        this.tableroInterface.setVisible(true);
    }*/


    private void turnoMaquinaAvanzado(){
        try{
            int posicionTablero;
            int posicionMano;
            Random rand = new Random();
            ArrayList <ArrayList<Integer>> posicionesBajadas = new ArrayList<>();

            ArrayList <Integer> valoresIzqCartasBajadas = cogerValoresIzquierdaDeCartasBajadas();
            ArrayList <Integer> valoresDerCartasBajadas = cogerValoresDerechaDeCartasBajadas();
            HashMap <Integer, ArrayList> valoresIzqDerPorPosicion = new HashMap<Integer, ArrayList>();
            for (int addValoresToMap = 0; addValoresToMap < valoresIzqCartasBajadas.size(); addValoresToMap++) {
                ArrayList<Integer> arrayAuxiliar = new ArrayList<>();
                arrayAuxiliar.add(addValoresToMap);
                arrayAuxiliar.add(valoresIzqCartasBajadas.get(addValoresToMap));
                arrayAuxiliar.add(valoresDerCartasBajadas.get(addValoresToMap));
                posicionesBajadas.add(arrayAuxiliar);
            }
            ArrayList <ArrayList<Integer>> posicionesPonderadas = ponderarPosicionesPorLosValores(posicionesBajadas);


            try {
                posicionMano = ThreadLocalRandom.current().nextInt(0, this.maquina.getManoSize());
            }catch (java.lang.IllegalArgumentException e){
                posicionMano = 0;
            }
            try {
                posicionTablero = ThreadLocalRandom.current().nextInt(0, this.tableroPartida.getCantidadCartasVacias());
                posicionTablero = this.tableroPartida.getPosicionDelArrayVacio(posicionTablero);
            }catch (java.lang.IllegalArgumentException e){
                posicionTablero = this.tableroPartida.getPosicionDelArrayVacio(0);
            }
            if (this.tableroPartida.comprobarPosicion(posicionTablero))
                throw new HuecoOcupado("El hueco esta ocupado, elige una posicion vacia\\n\\n\\n\\n\"");
            else
                //this.tableroInterface.pasarCartaManoAlTablero(posicionMano, posicionTablero, 1);
                jugar(posicionMano, posicionTablero, this.maquina.getisMaquina());
        }catch (HuecoOcupado msg){
            turnoMaquina();}
    }

    private ArrayList cogerValoresIzquierdaDeCartasBajadas(){
        ArrayList <Integer> posicionesOcupadas = new ArrayList<>();
        ArrayList<HuecoDelTablero> arrayAuxilar;
        ArrayList <Integer> valoresIzqDeLasCartasEnJuego = new ArrayList<>();
        int sizeArrayLleno = this.tableroPartida.getCantidadCartasLlenas();
        for (int recorrerArrayLleno = 0; recorrerArrayLleno < sizeArrayLleno; recorrerArrayLleno++)
            posicionesOcupadas.add(this.tableroPartida.getPosicionDelArrayLleno(recorrerArrayLleno));
        arrayAuxilar = this.tableroPartida.getArrayCartasYaBajadas();
        for (int recorrerPosicionOcupadas = 0; recorrerPosicionOcupadas < posicionesOcupadas.size(); recorrerPosicionOcupadas++){
            if (!arrayAuxilar.get(posicionesOcupadas.get(recorrerPosicionOcupadas)).getesRoja())
                valoresIzqDeLasCartasEnJuego.add(arrayAuxilar.get(posicionesOcupadas.get(recorrerPosicionOcupadas)).getcartaEnElHueco().getValorIzq());
        }
        return valoresIzqDeLasCartasEnJuego;
    }

    private ArrayList cogerValoresDerechaDeCartasBajadas(){
        ArrayList <Integer> posicionesOcupadas = new ArrayList<>();
        ArrayList<HuecoDelTablero> arrayAuxilar;
        ArrayList <Integer> valoresDerDeLasCartasEnJuego = new ArrayList<>();
        int sizeArrayLleno = this.tableroPartida.getCantidadCartasLlenas();
        for (int recorrerArrayLleno = 0; recorrerArrayLleno < sizeArrayLleno; recorrerArrayLleno++)
            posicionesOcupadas.add(this.tableroPartida.getPosicionDelArrayLleno(recorrerArrayLleno));
        arrayAuxilar = this.tableroPartida.getArrayCartasYaBajadas();
        for (int recorrerPosicionOcupadas = 0; recorrerPosicionOcupadas < posicionesOcupadas.size(); recorrerPosicionOcupadas++){
            if (! arrayAuxilar.get(posicionesOcupadas.get(recorrerPosicionOcupadas)).getcartaEnElHueco().getisMaquina())
                valoresDerDeLasCartasEnJuego.add(arrayAuxilar.get(posicionesOcupadas.get(recorrerPosicionOcupadas)).getcartaEnElHueco().getValorDer());
        }
        return valoresDerDeLasCartasEnJuego;
    }

    private  ArrayList ponderarPosicionesPorLosValores(ArrayList<ArrayList<Integer>> cartasBajadas){
        ArrayList <Integer> ponderacionesIzq = new ArrayList <> ();
        ArrayList <Integer> ponderacionesDer = new ArrayList <> ();
        ArrayList <ArrayList<Integer>> ponderacionesTotal = new ArrayList <> ();
        ArrayList <Integer> sumaPonderaciones = new ArrayList <> ();
        ArrayList <Integer> valoresDerechaMano = new ArrayList<>();
        ArrayList <Integer> valoresIzquierdaMano = new ArrayList<>();

        for (int recorrerMano = 0; recorrerMano <= this.maquina.getManoSize(); recorrerMano++)
            valoresDerechaMano.add(this.maquina.getMano().get(recorrerMano).getValorDer());
        for (int recorrerMano = 0; recorrerMano <= this.maquina.getManoSize(); recorrerMano++)
            valoresIzquierdaMano.add(this.maquina.getMano().get(recorrerMano).getValorIzq());

        for (int recorrerInputArray = 0; recorrerInputArray < cartasBajadas.size(); recorrerInputArray++) {
            ponderacionesDer = new ArrayList <> ();
            ponderacionesIzq = new ArrayList <> ();
            sumaPonderaciones = new ArrayList<>();
            switch (this.tableroPartida.getPosicionDelArrayLleno(cartasBajadas.get(recorrerInputArray).get(0))) {
                case 0:
                    //Solo comprobar el valor de la derecha
                    for (int recorrerArrayMano : valoresDerechaMano)
                        ponderacionesDer.add(ponderacionValores(cartasBajadas.get(recorrerInputArray).get(2), recorrerArrayMano));
                    break;
                case 9:
                    //Solo comprobar el valor de la izquierda
                    for (int recorrerArrayMano : valoresIzquierdaMano)
                        ponderacionesIzq.add(ponderacionValores(cartasBajadas.get(recorrerInputArray).get(1), recorrerArrayMano));
                    break;
                default:
                    //Comprobar todos los valores
                    for (int recorrerArrayMano : valoresIzquierdaMano) {
                        ponderacionesDer.add(ponderacionValores(cartasBajadas.get(recorrerInputArray).get(2), recorrerArrayMano));
                        ponderacionesIzq.add(ponderacionValores(cartasBajadas.get(recorrerInputArray).get(1), recorrerArrayMano));
                    }
                    break;
            }
            if (ponderacionesDer.size() == 0)
                sumaPonderaciones.addAll(ponderacionesIzq);
            else if (ponderacionesIzq.size() == 0)
                sumaPonderaciones.addAll(ponderacionesDer);
            else
                for (int recorrerPonderacionesIzqDer = 0; recorrerPonderacionesIzqDer < ponderacionesDer.size(); recorrerPonderacionesIzqDer++)
                    sumaPonderaciones.add((ponderacionesDer.get(recorrerPonderacionesIzqDer))+(ponderacionesIzq.get(recorrerPonderacionesIzqDer)));
            ponderacionesTotal.add(sumaPonderaciones);
        }
        return ponderacionesTotal;
    }

    private int ponderacionValores(int valorCartaBajada, int valorCartaMano){
        int value = 0;
        if ( valorCartaBajada < valorCartaMano)
            value = 1;
        switch (value){
            case 0:
                return 0;
            case 1:
                return 1;
        }
        return 0;
    }

    private int getPosicionMasPonderada (ArrayList<Integer>posicionesPonderadas){
        int valorMaximo = Collections.max(posicionesPonderadas);
        ArrayList <Integer> posicionesMasPonderadas = new ArrayList<>();

        for (int recorrerPosicionesPonderadas = 0; recorrerPosicionesPonderadas < posicionesPonderadas.size(); recorrerPosicionesPonderadas++)
            if (posicionesPonderadas.get(recorrerPosicionesPonderadas) == valorMaximo)
                posicionesMasPonderadas.add(recorrerPosicionesPonderadas);
        if (posicionesMasPonderadas.size() == 1)
            return posicionesMasPonderadas.get(0);
        else
            return posicionesMasPonderadas.get(ThreadLocalRandom.current().nextInt(0, posicionesMasPonderadas.size()));
    }

}
