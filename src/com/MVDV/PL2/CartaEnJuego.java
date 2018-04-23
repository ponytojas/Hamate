package com.MVDV.PL2;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class CartaEnJuego extends CartaEnMano {

    private int posicion;
    private boolean isMaquina;

    /**
     * Constructor por defecto
     */
    public CartaEnJuego() {
    }

    /**
     * Crea una instancia del objeto con los valores que obtiene por parametros
     * @param valorIzq: valor por la izquierda que tiene la carta
     * @param valorDer: valor por la derecha que tiene la carta
     * @param maquina: si tenemos la variable a true, la carta sera roja, sino azul. Una aproximacion mas sencilla en el futuro que utilizar variables tipo String
     * @param posicion: la posicion numerica del 1 al 10 de la carta en juego
     */
    public CartaEnJuego(int valorIzq, int valorDer, boolean maquina, int posicion) {
        super(valorIzq, valorDer);
        this.isMaquina = maquina;
        this.posicion = posicion;
    }

    /**
     * Getter
     * @return la posicion de la carta. Utilizado para referenciar a la hora de comparar valores
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Getter
     * @return de este modo sabemos que color tiene cada carta
     */
    public boolean getisMaquina(){return this.isMaquina;}

    /**
     * Cambiamos el color de la carta al cambiar el booleano de si pertenece o no a la maquina
     */
    public void cambiarColor(){
        this.isMaquina = !this.isMaquina;
    }
}
