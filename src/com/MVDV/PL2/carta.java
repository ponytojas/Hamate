package com.MVDV.PL2;

public class carta {
    private int valorIzq;
    private int valorDer;
    /* TODO imagen */

    public carta() {
    }

    public carta(int valorIzq, int valorDer) {
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
