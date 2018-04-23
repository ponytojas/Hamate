package com.MVDV.PL2;

public class HuecoDelTablero {

    private boolean hayUnaCarta;
    private CartaEnJuego cartaEnElHueco;
    private boolean esRoja;
    private int posicion;

    public HuecoDelTablero( int posicion) {
        this.hayUnaCarta = false;
        this.posicion = posicion;
    }

    public void bajarCartaAlHueco (CartaEnJuego cartaQueSePoneEnElHueco){
        this.cartaEnElHueco = cartaQueSePoneEnElHueco;
        this.setEsRoja(cartaQueSePoneEnElHueco.getisMaquina());
    }

    public void setEsRoja(boolean laCartaEsRoja){
        this.esRoja = laCartaEsRoja;
    }

    public boolean isHayUnaCarta() {
        return hayUnaCarta;
    }

    public void setHayUnaCarta(boolean hayUnaCarta) {
        this.hayUnaCarta = hayUnaCarta;
    }

    public CartaEnJuego getCartaEnElHueco() {
        return cartaEnElHueco;
    }

    public void setCartaEnElHueco(CartaEnJuego cartaEnElHueco, int posicion) {
        this.cartaEnElHueco = cartaEnElHueco;
        setPosicion(posicion);
    }

    public boolean isEsRoja() {
        return esRoja;
    }

    public int getPosicion() {
        return posicion;
    }

    private void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void dibujarHueco(){
        String color = "red";

        if (this.hayUnaCarta){
            if (!this.esRoja){
                color = "blue";
            }
            System.out.print("["+this.cartaEnElHueco.getValorIzq()+" | "+ color+" | "+this.cartaEnElHueco.getValorDer()+"]");
        }
        else{
            System.out.print("[ "+this.getPosicion()+" ]");
        }
    }
}
