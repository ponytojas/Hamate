package com.MVDV.PL2;

public class HuecoDelTablero {

    private boolean hayUnaCarta;
    private CartaEnJuego cartaEnElHueco;
    private boolean esRoja;
    private int posicion;

    /**
     * Constructor por defecto, donde no habra ninguna carta bajada
     */
    public HuecoDelTablero() {
        this.hayUnaCarta = false;
    }

    /**
     *
     * @param cartaQueSePoneEnElHueco Esta es la carta que se esta bajando, cogemos sus valores y la asignamos un color
     */
    public void bajarCartaAlHueco (CartaEnJuego cartaQueSePoneEnElHueco){
        this.cartaEnElHueco = cartaQueSePoneEnElHueco;
        this.setEsRoja(cartaQueSePoneEnElHueco.getisMaquina());
    }

    /**
     * Setter
     * @param laCartaEsRoja Comprobamos si la carta es roja o azul
     */
    public void setEsRoja(boolean laCartaEsRoja){
        this.esRoja = laCartaEsRoja;
    }

    /**
     * Getter
     * @return Nos devuelve si el hueco esta vacio o lleno
     */
    public boolean getHayUnaCarta() {
        return hayUnaCarta;
    }

    /**
     * Setter
     * @param hayUnaCarta Cambiamos el valor que utilizamos para comprobar si hay o no carta
     */
    public void sethayUnaCarta(boolean hayUnaCarta) {
        this.hayUnaCarta = hayUnaCarta;
    }

    /**
     * Getter
     * @return Devuelve la carta que hay para poder operar sobre ella
     */
    public CartaEnJuego getcartaEnElHueco() {
        return cartaEnElHueco;
    }

    /**
     * Setter
     * @param cartaEnElHueco Esta es la carta que bajamos al hueco
     * @param posicion Hemos ocupado el hueco, por lo que debemos indicarle la posicion donde se baja
     */
    public void setcartaEnElHueco(CartaEnJuego cartaEnElHueco, int posicion, boolean isMaquina) {
        this.cartaEnElHueco = cartaEnElHueco;
        this.esRoja = isMaquina;
        setposicion(posicion);
        sethayUnaCarta(true);
    }

    /**
     * Getter
     * @return Comprobamos si la carta es roja o azul
     */
    public boolean getesRoja() {
        return esRoja;
    }

    /**
     * Getter
     * @return Nos devuelve la posicion donde esta la carta
     */
    public int getposicion() {
        return posicion;
    }

    /**
     * Setter
     * @param posicion Indicamos la posicion de la carta
     */
    private void setposicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * Permite dibujar por terminal los huecos que hay en el tablero y las cartas que ya existan
     */
    public void dibujarHueco(){
        String color = "red";

        if (this.hayUnaCarta){
            if (!this.esRoja){
                color = "blue";
            }
            System.out.print("["+this.cartaEnElHueco.getValorIzq()+" | "+ color+" | "+this.cartaEnElHueco.getValorDer()+"]");
        }
        else{
            System.out.print("[ "+this.getposicion()+" ]");
        }
    }
}
