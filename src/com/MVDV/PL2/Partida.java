package com.MVDV.PL2;
import java.util.*;
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
<<<<<<< HEAD
    private datosJugadorClasificacion clasificacion = new datosJugadorClasificacion();

    //private TableroForm tableroInterface;

=======

    //private TableroForm tableroInterface;

>>>>>>> 3c573f891f5ba942bdad3d392f1ba71c3176a721
    public Partida(String nombre, String nif, int edad){
        this.jugador.setNombre(nombre);
        this.jugador.setEdad(edad);
        this.jugador.setNif(nif);
    }
    
    public Partida(){
<<<<<<< HEAD
        boolean datosCorrectos = false;
        while (!datosCorrectos)
            datosCorrectos = this.clasificacion.comenzarPartida();
        this.jugador = this.clasificacion.getJugador();
        this.jugador.setPuntos(this.clasificacion.getPuntosAnteDeComenzarPartida(this.jugador.getNif()));
        this.maquina.setPuntos(this.clasificacion.getPuntosAnteDeComenzarPartida(this.maquina.getNif()));

=======
>>>>>>> 3c573f891f5ba942bdad3d392f1ba71c3176a721
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
            if (this.mazo.size() % 10 == 0)
                this.mazo.add(new CartaEnMazo(rand.nextInt(7)+1, rand.nextInt(7) +1, true));
            else
                this.mazo.add(new CartaEnMazo(rand.nextInt(7)+1, rand.nextInt(7) +1, false));
        }while (this.mazo.size() < 110);

        Collections.shuffle(this.mazo);

        while(!this.maquina.getisLlena()){
            this.maquina.recibirCarta(this.mazo.get(0));
            this.mazo.remove(0);
        }
        while (!this.jugador.getisLlena()){
            this.jugador.recibirCarta(this.mazo.get(0));
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
        int posicionMano = -1;
        Scanner entrada = new Scanner(System.in);
        try {
            for (HuecoDelTablero huecoAux : this.tableroPartida.getCartasYaBajadas())
                huecoAux.dibujarHueco();
            System.out.println("\n\n*************MANO JUGADOR*************\n");
            this.jugador.mostrarMano();
            System.out.println("Elige una carta a bajar: ");
            posicionMano = (entrada.nextInt()) - 1;
            try {
<<<<<<< HEAD
                if (posicionMano+1 > this.jugador.getManoSize() || posicionMano < 0)
=======
                if (posicionMano+1 >= this.jugador.getManoSize() || posicionMano < 0)
>>>>>>> 3c573f891f5ba942bdad3d392f1ba71c3176a721
                    throw new fueraDelRangoDeLaMano("La carta selecciona no existe, elige otra");
            }catch (fueraDelRangoDeLaMano msg){
                System.out.println("\n\n\n\n\nLa carta selecciona no existe, elige otra\n\n\n\n\n");
                turnoJugador();
            }
            System.out.println("\nElige una posicion para bajar");
            int posicionTablero = (entrada.nextInt()) - 1;

            if (this.tableroPartida.comprobarPosicion(posicionTablero))
                throw new HuecoOcupado("El hueco esta ocupado, elige una posicion vacia\n\n\n\n");

            else
                jugar(posicionMano, posicionTablero, this.jugador.getisMaquina());
        }catch (HuecoOcupado msg){
            System.out.println("\n\n\n\n\nEl hueco esta ocupado, elige una posicion vacia\n\n\n\n\n");
            turnoJugador();
        }catch (java.util.InputMismatchException e){
            System.out.println("\n\n\n\n\nSolo se aceptan numeros\n\n\n\n\n");
            posicionMano = -1;
            turnoJugador();
        }
    }

    /**
     * Funcion del turno de la maquina
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
        this.tableroPartida.ponerLaCartaEnElTablero(new CartaEnJuego(cartaAux.getValorIzq(), cartaAux.getValorDer(), isMaquina, cartaAux.getvaleDoble()), huecoTablero, isMaquina);
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

    class fueraDelRangoDeLaMano extends Exception {

        public fueraDelRangoDeLaMano() {
        }
        public fueraDelRangoDeLaMano(String msg) {
            super("Excepcion definida por el usuario: " + msg);
        }
    }


    class noPonderacion extends Exception {

        public noPonderacion() {
        }
        public noPonderacion(String msg) {
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
        int puntosJugador = this.tableroPartida.calcularPuntos(true);
        int puntosMaquina = this.tableroPartida.calcularPuntos(false);
        int ganaJugador = 0;
        this.clasificacion.actualizarDatosPartida(this.jugador.getNif(), this.maquina.getNif(), cantidadJugador, cantidadMaquina, puntosJugador, puntosMaquina);
        if (cantidadJugador > cantidadMaquina) ganaJugador = 1;
        else if (cantidadJugador == cantidadMaquina) ganaJugador = 3;
        switch (ganaJugador){
            case 0:
<<<<<<< HEAD
                System.out.println("\n\n\nGana la maquina con "+puntosMaquina+" puntos");
                break;
            case 1:
                System.out.println("\n\n\nGana el jugador "+this.jugador.getNombre()+" con "+puntosJugador+" puntos");
=======
                System.out.println("\n\n\nGana la maquina con "+cantidadMaquina+" cartas de su color");
                break;
            case 1:
                System.out.println("\n\n\nGana el jugador "+this.jugador.getNombre()+" con "+cantidadJugador+" cartas de su color");
>>>>>>> 3c573f891f5ba942bdad3d392f1ba71c3176a721
                break;
            default:
                System.out.println("\n\n\nHa habido un empate");
        }
    }
 
    /*private void lanzarInterfaz (){
        this.tableroInterface = new TableroForm(this.jugador, this.maquina);     
        this.tableroInterface.setVisible(true);
    }*/


    /**
     * Funcion de turno avanzada de la maquina
     * tl;dr
     * Se cogen los valores de las cartas de la mano y de las que hay en juego del jugador
     * Se comparan y se dan unas ponderaciones por posicion a todas las cartas de la mano
     * Se elige una de las cartas mas ponderadas
     * Si no se pudiera bajar ninguna carta usando el sistema de ponderaciones y por cualquier otra razon, se utiliza el modo automatico facil de maquina
     */

    private void turnoMaquinaAvanzado() {
        ArrayList<Integer> posicionesLlenasDelContrario = this.tableroPartida.getPosicionesLlenas();

        ArrayList<ArrayList<Integer>> arrayConPosicionesValoresIzqDerDeCartasEnTableroOponente = cogerPosicionesIzqDerOponenteTablero(posicionesLlenasDelContrario);
        ArrayList<ArrayList<Integer>> posicionesPonderadas = ponderarPosicionesPorLosValores(arrayConPosicionesValoresIzqDerDeCartasEnTableroOponente);
        if (posicionesPonderadas.size() > 0) {
            try {
                int posicionTablero = getPosicionMasPonderada(posicionesPonderadas);
                if (posicionTablero == -1 || Collections.max(posicionesPonderadas.get(posicionTablero)) == 0)
                    throw new noPonderacion("No hay ninguna ponderacion correcta, se selecciona carta aleatoria");
                ArrayList<Integer> cartaElegida = seleccionarCartaABajar(
                        this.tableroPartida.getCartasYaBajadas().get(arrayConPosicionesValoresIzqDerDeCartasEnTableroOponente.get(0).get(posicionTablero)).getcartaEnElHueco().getValorIzq(),
                        this.tableroPartida.getCartasYaBajadas().get(arrayConPosicionesValoresIzqDerDeCartasEnTableroOponente.get(0).get(posicionTablero)).getcartaEnElHueco().getValorDer(),
                       posicionesPonderadas.get(posicionTablero), arrayConPosicionesValoresIzqDerDeCartasEnTableroOponente.get(0).get(posicionTablero));
                if (cartaElegida.size() != 0) {
                    posicionTablero = Integer.valueOf(arrayConPosicionesValoresIzqDerDeCartasEnTableroOponente.get(0).get(posicionTablero));
                    try {
                        if (cartaElegida.get(1) == 1)
                            posicionTablero += 1;
                        else if (cartaElegida.get(1) == 2)
                            posicionTablero -= 1;
                        if (this.tableroPartida.comprobarPosicion(posicionTablero))
                            throw new HuecoOcupado("El hueco esta ocupado, elige una posicion vacia\\n\\n\\n\\n\"");
                        else
                            //this.tableroInterface.pasarCartaManoAlTablero(cartaElegidaAvanz.get(0), posicionTablero, 1);
                            jugar(cartaElegida.get(0), posicionTablero, this.maquina.getisMaquina());
                    } catch (HuecoOcupado msg) {
                        turnoMaquina();
                    }
                } else
                    turnoMaquina();
            }catch (noPonderacion msg){
                turnoMaquina();
            }catch (java.util.NoSuchElementException e){
                turnoMaquina();
            }
        }
    }

    /**
     * Se cogen los valores de la izquierda y derecha de las cartas den juego y las posiciones
     * @param posicionesLlenasDelContrario
     * @return ArrayList con ArrayList de  posiciones, los valores izquierdo y las posiciones de las cartas. Están en orden. La posicion 0 de cada Array esta relacionado
     */

    private ArrayList cogerPosicionesIzqDerOponenteTablero(ArrayList <Integer> posicionesLlenasDelContrario){
        ArrayList <ArrayList> arrayConPosicionesValoresIzqDerDelOponente = new ArrayList<>();

        ArrayList <Integer> valoresIzqDeLasCartasEnJuego = new ArrayList<>();
        ArrayList <Integer> valoresDerDeLasCartasEnJuego = new ArrayList<>();
        ArrayList <Integer> PosicionesDeLasCartasEnJuego = new ArrayList<>();

        for (int recorrerPosicionOcupadas = 0; recorrerPosicionOcupadas < posicionesLlenasDelContrario.size(); recorrerPosicionOcupadas++)
            if (!this.tableroPartida.getCartasYaBajadas().get(posicionesLlenasDelContrario.get(recorrerPosicionOcupadas)).getesRoja()) {
                valoresIzqDeLasCartasEnJuego.add(this.tableroPartida.getCartasYaBajadas().get(posicionesLlenasDelContrario.get(recorrerPosicionOcupadas)).getcartaEnElHueco().getValorIzq());
                valoresDerDeLasCartasEnJuego.add(this.tableroPartida.getCartasYaBajadas().get(posicionesLlenasDelContrario.get(recorrerPosicionOcupadas)).getcartaEnElHueco().getValorDer());
                PosicionesDeLasCartasEnJuego.add(posicionesLlenasDelContrario.get(recorrerPosicionOcupadas));
            }

        arrayConPosicionesValoresIzqDerDelOponente.add(PosicionesDeLasCartasEnJuego);
        arrayConPosicionesValoresIzqDerDelOponente.add(valoresIzqDeLasCartasEnJuego);
        arrayConPosicionesValoresIzqDerDelOponente.add(valoresDerDeLasCartasEnJuego);
        return arrayConPosicionesValoresIzqDerDelOponente;
    }

    /**
     * Funcion que ponder las cartas bajadas en funcion de la mano
     * @param cartasBajadas ArrayList con los valores de las cartas ya bajadas
     * @return ArrayList con las ponderaciones
     */

    private  ArrayList ponderarPosicionesPorLosValores(ArrayList<ArrayList<Integer>> cartasBajadas){
        ArrayList <Integer> ponderacionesAtacandoPorIzq;
        ArrayList <Integer> ponderacionesAtacandoPorDer;
        ArrayList <Integer> sumaPonderaciones;
        ArrayList <ArrayList<Integer>> ponderacionesTotal = new ArrayList <> ();
        ArrayList <Integer> valoresDerechaManoMaquina = new ArrayList<>();
        ArrayList <Integer> valoresIzquierdaManoMaquina = new ArrayList<>();

<<<<<<< HEAD
        for (int recorrerMano = 0; recorrerMano <= this.maquina.getManoSize()-1; recorrerMano++) {
=======
        for (int recorrerMano = 0; recorrerMano <= this.maquina.getManoSize(); recorrerMano++) {
>>>>>>> 3c573f891f5ba942bdad3d392f1ba71c3176a721
            valoresDerechaManoMaquina.add(this.maquina.getMano().get(recorrerMano).getValorDer());
            valoresIzquierdaManoMaquina.add(this.maquina.getMano().get(recorrerMano).getValorIzq());
        }

        for (int recorrerInputArray = 0; recorrerInputArray < cartasBajadas.get(0).size(); recorrerInputArray++) {
            ponderacionesAtacandoPorDer = new ArrayList <> ();
            ponderacionesAtacandoPorIzq = new ArrayList <> ();
            sumaPonderaciones = new ArrayList<>();

            switch (cartasBajadas.get(0).get(recorrerInputArray)) {
                case 0:
                    //Solo comprobar el valor de la derecha
                    for (int recorrerArrayMano : valoresIzquierdaManoMaquina)
                        if (checkNextOrPreviousPosition((cartasBajadas.get(0).get(recorrerInputArray)+1)))
                            ponderacionesAtacandoPorDer.add(ponderacionValores(cartasBajadas.get(2).get(recorrerInputArray), recorrerArrayMano));
                    break;
                case 9:
                    //Solo comprobar el valor de la izquierda
                    for (int recorrerArrayMano : valoresDerechaManoMaquina)
                        if (checkNextOrPreviousPosition((cartasBajadas.get(0).get(recorrerInputArray))-1))
                        ponderacionesAtacandoPorIzq.add(ponderacionValores(cartasBajadas.get(1).get(recorrerInputArray), recorrerArrayMano));
                    break;
                default:
                    //Comprobar todos los valores
                    for (int recorrerArrayDeValoresIzqDerManoMaquina = 0; recorrerArrayDeValoresIzqDerManoMaquina < valoresDerechaManoMaquina.size() || recorrerArrayDeValoresIzqDerManoMaquina < valoresDerechaManoMaquina.size(); recorrerArrayDeValoresIzqDerManoMaquina++){
                        try{
                            if (checkNextOrPreviousPosition((cartasBajadas.get(0).get(recorrerInputArray)+1)))
                                ponderacionesAtacandoPorDer.add(ponderacionValores(cartasBajadas.get(2).get(recorrerInputArray), valoresIzquierdaManoMaquina.get(recorrerArrayDeValoresIzqDerManoMaquina)));
                            if (checkNextOrPreviousPosition((cartasBajadas.get(0).get(recorrerInputArray))-1))
                                ponderacionesAtacandoPorIzq.add(ponderacionValores(cartasBajadas.get(1).get(recorrerInputArray), valoresDerechaManoMaquina.get(recorrerArrayDeValoresIzqDerManoMaquina)));
                        }catch (Exception e){
                            continue;
                        }
                    }
                    break;
            }
            if (ponderacionesAtacandoPorDer.size() == 0)
                sumaPonderaciones.addAll(ponderacionesAtacandoPorIzq);
            else if (ponderacionesAtacandoPorIzq.size() == 0)
                sumaPonderaciones.addAll(ponderacionesAtacandoPorDer);
            else
                for (int recorrerPonderacionesIzqDer = 0; recorrerPonderacionesIzqDer < ponderacionesAtacandoPorDer.size(); recorrerPonderacionesIzqDer++)
                    sumaPonderaciones.add((ponderacionesAtacandoPorDer.get(recorrerPonderacionesIzqDer))+(ponderacionesAtacandoPorIzq.get(recorrerPonderacionesIzqDer)));
            ponderacionesTotal.add(sumaPonderaciones);
        }
        return ponderacionesTotal;
    }

    /**
     * Funcion que asigna las ponderaciones
     * @param valorCartaBajada valor de la carta en el tablero
     * @param valorCartaMano valor de la carta en la mano
     * @return El valor de la ponderacion
     */
    private int ponderacionValores(int valorCartaBajada, int valorCartaMano){
        if ( valorCartaBajada < valorCartaMano)
            return 1;
        return 0;
    }

    /**
     * Funcion que suma las ponderaciones
     * @param posicionesPonderadas ArrayList con las posiciones ya ponderadas
     * @return
     */

    private int getPosicionMasPonderada (ArrayList <ArrayList<Integer>> posicionesPonderadas ){
        ArrayList <Integer> ponderacionesDeCartas = new ArrayList<>();
        int sumaTemporal = 0;

        for (int recorrerPrimerArray = 0; recorrerPrimerArray < posicionesPonderadas.size(); recorrerPrimerArray++) {
            for (int recorrerSegundoArray = 0; recorrerSegundoArray < posicionesPonderadas.get(recorrerPrimerArray).size(); recorrerSegundoArray++)
                sumaTemporal += posicionesPonderadas.get(recorrerPrimerArray).get(recorrerSegundoArray);
            ponderacionesDeCartas.add(sumaTemporal);
            sumaTemporal = 0;
        }
        int maximoTemporal = Collections.max(ponderacionesDeCartas);

        for (int recorrerArrayPonderaciones = 0; recorrerArrayPonderaciones < ponderacionesDeCartas.size(); recorrerArrayPonderaciones++)
            if (maximoTemporal == ponderacionesDeCartas.get(recorrerArrayPonderaciones))
                return recorrerArrayPonderaciones;
        return -1;
    }

    /**
     * Se escoge la carta mas ponderada y se comprueba si debe bajarse por la izquierda o derecha.
     * Si ocurriese la situacion de que la carta no se pudiera colocar en la posicon que corresponde, se bsucaria la siguiente carta
     *
     * @param ponderaciones ArrayList con las ponderaciones
     * @param posicion Posicion donde se va a bajar la carta
     * @return un ArrayList con la posicion de la mano de la carta que se va a bajar y si es a la izquierda o derecha
     */

    private ArrayList <Integer> seleccionarCartaABajar(int valorIzqCartaSeleccionada, int valorDerCartaSeleccionada, ArrayList <Integer> ponderaciones, int posicion){
        ArrayList <Integer> posicionManoyDeroIzq = new ArrayList<>();
        if (ponderaciones.size() != 0){
            int maximoPonderadoTemporal = Collections.max(ponderaciones);
            int posicionMasPonderadaTemporal = -1;
            for (int recorrerPonderaciones = 0; recorrerPonderaciones < ponderaciones.size(); recorrerPonderaciones++)
                if (ponderaciones.get(recorrerPonderaciones) == maximoPonderadoTemporal) {
                    posicionMasPonderadaTemporal = recorrerPonderaciones;
                    break;
                }
            if (posicionMasPonderadaTemporal != -1) {
                posicionManoyDeroIzq.add(posicionMasPonderadaTemporal);
                int valorIzqTempo = this.maquina.getMano().get(posicionMasPonderadaTemporal).getValorIzq();
                int valorDerTempo = this.maquina.getMano().get(posicionMasPonderadaTemporal).getValorDer();

                switch (posicion) {
                    case 0:
                        if (valorDerCartaSeleccionada < valorIzqTempo)
                            posicionManoyDeroIzq.add(1);
                        else{
                            ponderaciones.remove(posicionMasPonderadaTemporal);
                            posicionManoyDeroIzq = new ArrayList<>();
                            posicionManoyDeroIzq = seleccionarCartaABajar(valorIzqCartaSeleccionada, valorDerCartaSeleccionada, ponderaciones, posicion);
                        }
                        break;
                    case 9:
                        if (valorIzqCartaSeleccionada < valorDerTempo)
                            posicionManoyDeroIzq.add(2);
                        else{
                            ponderaciones.remove(posicionMasPonderadaTemporal);
                            posicionManoyDeroIzq = new ArrayList<>();
                            posicionManoyDeroIzq = seleccionarCartaABajar(valorIzqCartaSeleccionada, valorDerCartaSeleccionada, ponderaciones, posicion);
                        }
                        break;
                    default:
                        if (valorDerCartaSeleccionada < valorIzqTempo && ((valorIzqTempo - valorDerCartaSeleccionada) > (valorDerTempo - valorIzqCartaSeleccionada))
                                && checkNextOrPreviousPosition(posicion+1)){
                            posicionManoyDeroIzq.add(1);
                        }else if (valorIzqCartaSeleccionada < valorDerTempo && ((valorDerTempo - valorIzqCartaSeleccionada) > (valorIzqTempo - valorDerCartaSeleccionada))
                                && checkNextOrPreviousPosition(posicion-1)) {
                            posicionManoyDeroIzq.add(0);
                        }else if ((valorDerTempo - valorIzqCartaSeleccionada) == (valorIzqTempo - valorDerCartaSeleccionada)){
                            if(checkNextOrPreviousPosition(posicion+1)){
                                posicionManoyDeroIzq.add(1);
                            }else if (checkNextOrPreviousPosition(posicion-1)) {
                                posicionManoyDeroIzq.add(2);
                            }else{
                                ponderaciones.remove(posicionMasPonderadaTemporal);
                                posicionManoyDeroIzq = new ArrayList<>();
                                posicionManoyDeroIzq = seleccionarCartaABajar(valorIzqCartaSeleccionada, valorDerCartaSeleccionada, ponderaciones, posicion);
                            }
                        }else{
                            ponderaciones.remove(posicionMasPonderadaTemporal);
                            posicionManoyDeroIzq = new ArrayList<>();
                            posicionManoyDeroIzq = seleccionarCartaABajar(valorIzqCartaSeleccionada, valorDerCartaSeleccionada, ponderaciones, posicion);
                        }
                        break;
                }
            }
        }
        return posicionManoyDeroIzq;
    }

    /**
     * Funcion que comprueba si hay una carta en una posicion
     * @param posicion Posicion donde se va a bajar la carta
     * @return si es posible o no bajar la carta
     */

    private boolean checkNextOrPreviousPosition(int posicion){
        if (posicion < 0)
            return false;
        else if (posicion > 9)
            return false;
        return !this.tableroPartida.getCartasYaBajadas().get(posicion).getHayUnaCarta();
    }

}
