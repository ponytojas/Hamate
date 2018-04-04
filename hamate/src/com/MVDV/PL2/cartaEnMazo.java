package com.MVDV.PL2;

public class cartaEnMazo extends carta {

    private boolean enMazo;

    public cartaEnMazo() {
    }

    public cartaEnMazo(int valorIzq, int valorDer, boolean enMazo) {
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
