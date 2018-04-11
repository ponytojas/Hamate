package com.MVDV.PL2;

import java.util.ArrayList;

public class Tablero {
    private CartaEnJuego[] huecos;
    private int currentIndex;
    private ArrayList <Integer> posiciones = new ArrayList<>();

    public Tablero() {
        this.currentIndex = 0;
        this.huecos = new CartaEnJuego[10];
        for (int i = 0; i < 11; i++)
            posiciones.add(i);
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
            this.posiciones.remove(posicion);
        }
    }

    public int compararPosiciones(int carta1, int carta2){
        if (carta1-- == carta2 || carta1++ == carta2)
            return 1;
        else
            return 2;
    }

    public void mostrarPosicionesOcupadas(){
        System.out.println("Posiciones libres: ");
        for (Integer posicionAux : this.posiciones){
            System.out.print(posicionAux+"\t");
        }
    }

    public void compararCartas(CartaEnMano cartaBajada, int posicion){
        if (!this.isLleno()){
            recibirCarta(cartaBajada, posicion);
            if (currentIndex > 1){
                //comparar
                for (CartaEnJuego aux : huecos){
                    switch (compararPosiciones(aux.getPosicion(), posicion)){
                        case 1:
                            //compararValores
                            break;
                        case 2:
                            break;
                    }
                }
            }
        }
    }
}
