package com.MVDV.PL2;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class CartaEnMano extends CartaEnMazo {
    private boolean maquina; //esto ayuda a representar el color
    private boolean enMano;
    /*TODO imagen*/

    public CartaEnMano() {
    }

    public CartaEnMano(int valorIzq, int valorDer, boolean maquina) {
        super(valorIzq, valorDer, false);
        this.maquina = maquina;
        this.enMano = true;
    }

    public boolean isMaquina() {
        return maquina;
    }

    public void setMaquina(boolean maquina) {
        this.maquina = maquina;
    }

    public boolean isEnMano() {
        return enMano;
    }

    public void setEnMano(boolean enMano) {
        this.enMano = enMano;
    }

}
