package com.MVDV.PL2;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class CartaEnMazo extends Carta {

    private boolean enMazo;

    public CartaEnMazo() {
    }

    public CartaEnMazo(int valorIzq, int valorDer, boolean enMazo) {
        super(valorIzq, valorDer);
        this.enMazo = true;
    }

    public boolean isEnMazo() {
        return enMazo;
    }

    public void setEnMazo(boolean enMazo) {
        this.enMazo = enMazo;
    }

}
