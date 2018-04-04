package com.MVDV.PL2;

public class cartaEnJuego extends cartaEnMano {

    private int posicion; //del 0 al 9 la posición que ocupa la carta

    public cartaEnJuego() {
    }

    public cartaEnJuego(int valorIzq, int valorDer, boolean maquina, int posicion) {
        super(valorIzq, valorDer, maquina);
        this.posicion = posicion;
    }
}
