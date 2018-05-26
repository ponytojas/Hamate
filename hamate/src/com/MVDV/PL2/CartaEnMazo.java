package com.MVDV.PL2;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class CartaEnMazo extends Carta {

<<<<<<< HEAD
    private String nombreImagen;
    private boolean valeDoble;

=======
>>>>>>> 4e19e8f1aac7590372de9ab955d3f7cbafa8233f
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

        Random rand = new Random();
       this.nombreImagen = "Images/"+ String.valueOf(rand.nextInt(110)+1)+".png";
    }

    public String getnombreImagen(){return this.nombreImagen;}
=======
    }
>>>>>>> 4e19e8f1aac7590372de9ab955d3f7cbafa8233f

    public boolean getvaleDoble(){return valeDoble;}


}
