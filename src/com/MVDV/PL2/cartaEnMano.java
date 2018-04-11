package com.MVDV.PL2;

import java.util.ArrayList;

public class cartaEnMano extends  cartaEnMazo {
    private boolean maquina; //esto ayuda a representar el color
    private boolean enMano;

    public cartaEnMano() {
    }

    public cartaEnMano(int valorIzq, int valorDer, boolean maquina) {
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
