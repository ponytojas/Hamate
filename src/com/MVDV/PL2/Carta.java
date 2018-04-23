package com.MVDV.PL2;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Carta {
    private int valorIzq;
    private int valorDer;

    public Carta() {
    }

    public Carta(int valorIzq, int valorDer) {
        this.valorIzq = valorIzq;
        this.valorDer = valorDer;
    }

    public int getValorIzq() {
        return valorIzq;
    }

    public int getValorDer() {
        return valorDer;
    }

    public void setValorIzq(int valorIzq) {
        this.valorIzq = valorIzq;
    }

    public void setValorDer(int valorDer) {
        this.valorDer = valorDer;
    }
}
