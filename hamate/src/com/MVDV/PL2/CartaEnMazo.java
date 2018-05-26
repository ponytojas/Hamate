package com.MVDV.PL2;

import java.util.Random;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class CartaEnMazo extends Carta {

    private String nombreImagen;
    private boolean valeDoble;

    /**
     * Constructor por defecto
     */

    public CartaEnMazo() {
    }

    /**
     * @param valorIzq Valor por la izquierda de la carta
     * @param valorDer Valor por la derecha de la carta
     */
    public CartaEnMazo(int valorIzq, int valorDer, boolean valeDobleInput) {
        super(valorIzq, valorDer);
        this.valeDoble = valeDobleInput;

        Random rand = new Random();
       this.nombreImagen = "Images/"+ String.valueOf(rand.nextInt(110)+1)+".png";
    }

    public String getnombreImagen(){return this.nombreImagen;}

    public boolean getvaleDoble(){return valeDoble;}


}
