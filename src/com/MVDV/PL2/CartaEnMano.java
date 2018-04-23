package com.MVDV.PL2;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class CartaEnMano extends CartaEnMazo {
    /*TODO imagen*/

    /**
     * Constructor por defecto
     */
    public CartaEnMano() {
    }

    /**
     * @param valorIzq: Valor por la izquierda de la carta
     * @param valorDer: Valor por la derecha de la carta
     */

    public CartaEnMano(int valorIzq, int valorDer) {
        super(valorIzq, valorDer, false);
    }
}
