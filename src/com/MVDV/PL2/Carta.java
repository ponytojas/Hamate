package com.MVDV.PL2;

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
