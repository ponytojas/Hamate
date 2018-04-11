package com.MVDV.PL2;

public class tablero {
    private cartaEnJuego [] huecos;
    private int currentIndex;

    public tablero() {
        this.currentIndex = 0;
        this.huecos = new cartaEnJuego[10];
    }

    private int getCurrentIndex(){
        return currentIndex;
    }

    public boolean isLleno (){
        return (currentIndex == huecos.length-1);
    }

    public void recibirCarta (cartaEnMano cartaBajada, int posicion){
        if (!this.isLleno()){
            cartaEnJuego cartaAux = new cartaEnJuego(cartaBajada.getValorIzq(), cartaBajada.getValorDer(), cartaBajada.isMaquina(), posicion);
            this.huecos[currentIndex] = cartaAux;
            this.currentIndex++;
        }
    }
}
