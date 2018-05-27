package com.MVDV.PL2;

import java.io.Serializable;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v2.0.0
 * Clase basica de las cartas, se utiliza de clase padre para el resto de clases referentes a las cartas
 */
public class Carta implements Serializable{
    private int valorIzq;
    private int valorDer;

    /**
     * Constructor basico
     */
    public Carta () {
    }

    /**
     * @param valorIzq valor por la izquierda de la carta
     * @param valorDer  valor por la derecha de la carta
     * Constructor que incluye los valores de izquierda y derecha
     */
    public Carta(int valorIzq, int valorDer) {
        this.valorIzq = valorIzq;
        this.valorDer = valorDer;
    }

    /**
     * Getter
     * @return Valor izquierdo de la carta
     */
    public int getValorIzq() {
        return valorIzq;
    }

    /**
     * Getter
     * @return Valor derecho de la carta
     */

    public int getValorDer() {
        return valorDer;
    }
}
