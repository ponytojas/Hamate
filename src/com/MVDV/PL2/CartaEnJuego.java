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
     * @param valorIzq Valor por la izquierda que tiene la carta
     * @param valorDer Valor por la derecha que tiene la carta
     * @param maquina Si tenemos la variable a true, la carta sera roja, sino azul. Una aproximacion mas sencilla en el futuro que utilizar variables tipo String
     * @param posicion La posicion numerica del 1 al 10 de la carta en juego
     */
    public CartaEnJuego(int valorIzq, int valorDer, boolean maquina, int posicion) {
        super(valorIzq, valorDer);
        this.isMaquina = maquina;
        this.posicion = posicion;
    }

    /**
     * Getter
     * @return La posicion de la carta. Utilizado para referenciar a la hora de comparar valores
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Getter
     * @return De este modo sabemos que color tiene cada carta
     */
    public boolean getisMaquina(){return this.isMaquina;}

    /**
     * Cambiamos el color de la carta al cambiar el booleano de si pertenece o no a la maquina
     */
    public void cambiarColor(){
        this.isMaquina = !this.isMaquina;
    }
}
