package com.MVDV.PL2;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class CartaEnMazo extends Carta {

    /**
     * Constructor por defecto
     */

    public CartaEnMazo() {
    }

    /**
     *
     * @param valorIzq: Valor por la izquierda de la carta
     * @param valorDer: Valor por la derecha de la carta
     */
    public CartaEnMazo(int valorIzq, int valorDer) {
        super(valorIzq, valorDer);
    }

}
