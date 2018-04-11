package com.MVDV.PL2;

public class CartaEnJuego extends CartaEnMano {

    private int posicion; //del 0 al 9 la posición que ocupa la Carta

    public CartaEnJuego() {
    }

    public CartaEnJuego(int valorIzq, int valorDer, boolean maquina, int posicion) {
        super(valorIzq, valorDer, maquina);
        this.posicion = posicion;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
