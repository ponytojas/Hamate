package com.MVDV.PL2;

import java.io.Serializable;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v2.0.0
 */

public class CartaEnMano extends CartaEnMazo implements Serializable{

    /**
     * Constructor por defecto
     */
    public CartaEnMano() {
    }

    /**
     * @param valorIzq Valor por la izquierda de la carta
     * @param valorDer Valor por la derecha de la carta
     */

    public CartaEnMano(int valorIzq, int valorDer, boolean valeDoble) {
        super(valorIzq, valorDer, valeDoble);
    }
    
}
