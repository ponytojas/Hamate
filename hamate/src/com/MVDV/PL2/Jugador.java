package com.MVDV.PL2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;


/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v2.0.0
 */

public class Jugador implements Serializable{
    private boolean maquina;
    private ArrayList <CartaEnMano> mano = new ArrayList<>();
    private String nombre;
    private String nif;
    private int edad;
    private boolean facilAvanzado;
    private int puntos;
    
    /**
     * Constructor utilizado en la GUI
     * @param nombreInput Nombre del jugador
     * @param nifInput Identificador del jugador
     * @param edad Edad del jugador
     * @param esMaquinaInput Variable de control sobre si es o no usuario jugable
     */


    public Jugador(String nombreInput, String nifInput, int edad, boolean esMaquinaInput){
        this.nombre = nombreInput;
        this.nif = nifInput;
        this.edad = edad;
        this.maquina = esMaquinaInput;
    }


    /**
     * Constructor
     * @param maquinaInput Crea un jugador que puede sera maquina o usuario segun el parametro de entrada
     */
    public Jugador(boolean maquinaInput, boolean interfaz) { //Throws java.util.InputMismatchException
        if (maquinaInput) {
            this.nombre = "R2D2";
            this.edad = 42;
            this.nif = "01101000 01110101 01101100 01101001 01101111";
            this.maquina = true;


            int dificultad = 0;
            Scanner entrada = new Scanner(System.in);
            if (!interfaz){
                System.out.println("Elige modalidad de juego");
                System.out.println("1) Facil \t2) Dificil");
                try {
                    dificultad = entrada.nextInt();
                }
                 catch (Exception e) {
                    System.out.println("Algo no ha ido bien, se selecciona FACIL de forma automatica");
                } finally {
                    switch (dificultad) {
                        case 1:
                            facilAvanzado = false;
                            break;
                        case 2:
                            facilAvanzado = true;
                            break;
                        default:
                            facilAvanzado = false;
                            break;
                    }
                }
            }
        }
    }

    /**
     * Getter
     * @return Devuelve si el usuario es jugador o maquina
     */

    public boolean getisMaquina() {
        return this.maquina;
    }

    /**
     * Getter
     * @return Comprueba si la mano esta llena o no
     */
    public boolean getisLlena(){
       return (mano.size() == 5);
    }

    /**
     *
     * @param cartaRobada Convierte la carta que se ha recibido del mazo, en una carta de la mano, si la mano no esta llena
     */

    public void recibirCarta(CartaEnMazo cartaRobada){
        if (!getisLlena()) {
            CartaEnMano cartaAux = new CartaEnMano(cartaRobada.getValorIzq(), cartaRobada.getValorDer(), cartaRobada.getvaleDoble());
            mano.add(cartaAux);
        }
    }

    /**
     * Funcion que elimina de la mano la carta de la posicion que se pasa como input
     * @param posicion Posicion de la mano donde esta la carta
     */

    public void soltarCarta(int posicion){
        this.mano.remove(posicion);
    }

    /**
     * Getter
     * @param posicion Posicion de la carta en la mano
     * @return Devuelve la carta
     */

    public CartaEnMano getcarta (int posicion){
        return this.mano.get(posicion);
    }

    /**
     * Mostramos la mano del jugador para que pueda seleccionar la carta
     */

    public void mostrarMano(){
        int contador = 0;
        for (CartaEnMano aux: mano) {
            contador += 1;
            if (aux.getValorIzq() < 10)
                System.out.println(contador+")   Valor Izq: " + aux.getValorIzq() + " | Valor Der: " + aux.getValorDer());
            else
                System.out.println(contador+")   Valor Izq: " + aux.getValorIzq() + "| Valor Der: " + aux.getValorDer());
        }
    }

    /**
     * Getter
     * @return Size de la mano
     */

    public int getManoSize(){
        return mano.size();
    }
    
    /**
     * Preguntas iniciales para la creacion de un nuevo usuario
     */

    public void preguntasInicioPartida(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un nombre: ");
        this.nombre = entrada.nextLine();
        try{
        if (this.nombre.equals(""))
            throw  new JugadorException(JugadorException.NOMBRE_INCORRECTO);
        }catch (JugadorException msg){
            preguntasInicioPartida();
        }

        try{
            System.out.println("Introduce tu nif: ");
            this.nif = entrada.nextLine();
            if (this.nif.equals(""))
                throw new JugadorException(JugadorException.NIF_INCORRECTO);
        }catch (JugadorException msg){
            System.out.println(msg);
            preguntasInicioPartida();
        }
        try {
            System.out.println("Introduce edad (en numero): ");
            this.edad = entrada.nextInt();
            if (this.edad < 18)
                throw new JugadorException(JugadorException.EDAD_INCORRECTA);
        }catch (JugadorException msg){
            System.out.println("Edad fuera de rango");
            System.exit(0);
            //Terminar partida
        }
    }

    /**
     * Setter
     * @param nombre Nombre del usuario
     */
    public void setNombre (String nombre){this.nombre = nombre; }

    /**
     * Getter
     * @return Nombre del usuario
     */
    public String getNombre(){return this.nombre; }
/**
     * Setter
     * @param edad Edad del usuario
     */
    public void setEdad (int edad){this.edad = edad; }

    /**
     * Setter
     * @param nif Identificador de usuario
     */
    public void setNif (String nif){this.nif = nif; }

    /**
     * Getter
     * @return Dificultad de la partida
     */
    public boolean getDificultad(){return  this.facilAvanzado;}
    
    /**
     * Setter
     * @param facilDificil Dificultad de usuario para la partida
     */
    public void setDificultad(boolean facilDificil){  this.facilAvanzado = facilDificil;}

    /**
     * Getter
     * @return Mano del jugador
     */
    public ArrayList <CartaEnMano> getMano(){return this.mano;}

    /**
     * Getter
     * @return Identificador usuario
     */
    public String getNif(){return this.nif;}

    /**
     * Getter
     * @return Edad del jugador
     */
    public int getEdad() { return edad; }

    public void setMaquina(boolean maquina) {
        this.maquina = maquina;
    }

    /**
     * Setter
     * @param puntosInput Puntos del jugador
     */
    public void setPuntos(int puntosInput){this.puntos += puntosInput;}

    /**
     * Getter
     * @return Objeto jugador
     */
    public Jugador getJugador (){return this;}

    /**
     * Getter 
     * @return Puntos 
     */
    public int getPuntos(){return  this.puntos;}

}
