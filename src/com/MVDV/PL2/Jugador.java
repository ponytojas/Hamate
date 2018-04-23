package com.MVDV.PL2;
import java.util.ArrayList;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Jugador {
    private boolean maquina;
    private ArrayList <CartaEnMano> mano = new ArrayList<>();

    /**
     * Constructor
     * @param maquina Crea un jugador que puede sera maquina o usuario segun el parametro de entrada
     */
    public Jugador(boolean maquina) {
        this.maquina = maquina;
    }

    /**
     * Getter
     * @return Devuelve si el usuario es jugador o maquina
     */

    public boolean getisMaquina() {
        return maquina;
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
            CartaEnMano cartaAux = new CartaEnMano(cartaRobada.getValorIzq(), cartaRobada.getValorDer());
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



}
