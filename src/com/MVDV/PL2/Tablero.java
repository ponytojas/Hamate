package com.MVDV.PL2;

public class Tablero {
    private CartaEnJuego[] huecos;
    private int currentIndex;

    public Tablero() {
        this.currentIndex = 0;
        this.huecos = new CartaEnJuego[10];
    }

    private int getCurrentIndex(){
        return currentIndex;
    }

    public boolean isLleno (){
        return (currentIndex == huecos.length-1);
    }

    public void recibirCarta (CartaEnMano cartaBajada, int posicion){
        if (!this.isLleno()){
            CartaEnJuego cartaAux = new CartaEnJuego(cartaBajada.getValorIzq(), cartaBajada.getValorDer(), cartaBajada.isMaquina(), posicion);
            this.huecos[currentIndex] = cartaAux;
            this.currentIndex++;
        }
    }
}
