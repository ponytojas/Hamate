package com.MVDV.PL2;

import java.util.Random;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class CartaEnMazo extends Carta {
<<<<<<< HEAD
    private String nombreImagen;
    private boolean valeDoble;
=======
private String nombreImagen;
>>>>>>> 3c573f891f5ba942bdad3d392f1ba71c3176a721
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
<<<<<<< HEAD
        this.valeDoble = valeDobleInput;
=======
>>>>>>> 3c573f891f5ba942bdad3d392f1ba71c3176a721
        Random rand = new Random();
       this.nombreImagen = "Images/"+ String.valueOf(rand.nextInt(110)+1)+".png";
    }
    
    public String getnombreImagen(){return this.nombreImagen;}
<<<<<<< HEAD

    public boolean getvaleDoble(){return valeDoble;}
=======
>>>>>>> 3c573f891f5ba942bdad3d392f1ba71c3176a721

}
