package com.MVDV.PL2;

import java.util.ArrayList;

public class Tablero {
    private ArrayList <CartaEnJuego> cartasYaBajadas = new ArrayList<>();
    private int currentIndex;
    private ArrayList <Integer> posiciones = new ArrayList<>();

    public Tablero() {
    }

    public int getCurrentIndex(){
        return currentIndex;
    }

    public boolean isLleno (){
        return (currentIndex == 10);
    }

    public void recibirCarta (CartaEnJuego cartaBajada, int posicion){
        if (!this.isLleno()){
            cartasYaBajadas.add(cartaBajada);
            this.currentIndex++;
            //this.posiciones.remove(posicion);
            reto(posicion);
        }

    }

    public int compararPosiciones(int carta1, int carta2){
        if (carta1-- == carta2 || carta1++ == carta2)
            return 1;
        else
            return 2;
    }

    public void mostrarPosicionesLibres(){
        System.out.println("Posiciones libres: ");
        for (Integer posicionAux : this.posiciones){
            System.out.print("["+posicionAux+"]\t");
        }
    }


    public boolean hayCarta(int posicion){
        int aux = 0;
        boolean devolucion = true;
        while (10 - currentIndex > aux && devolucion){
            if (posicion == posiciones.get(aux))
                devolucion = false;
            aux++;
        }
        return devolucion;
    }

    public boolean compararValorCartas(int posicion, int posicionCartaBajando){
        for (CartaEnJuego cartaEnTablero : cartasYaBajadas){
            if (cartaEnTablero.getPosicion() == posicion)
                for (CartaEnJuego cartaQueSeEstaBajando : cartasYaBajadas){
                if (cartaEnTablero.getPosicion() == posicionCartaBajando){
                    if (cartaEnTablero.getPosicion() < cartaQueSeEstaBajando.getPosicion()){
                        if (cartaEnTablero.getValorDer() < cartaQueSeEstaBajando.getValorIzq())
                            return true;
                        else
                            return false;
                    }else{
                        if(cartaEnTablero.getValorIzq() < cartaQueSeEstaBajando.getValorDer())
                            return true;
                        else
                            return false;
                    }
                }
            }
        }
        return false;
    }

    public void cambiarColorCartaEnJuego(int posicion){
        for (CartaEnJuego cartaEnTablero : cartasYaBajadas) {
            if (cartaEnTablero.getPosicion() == posicion)
                cartaEnTablero.cambiarColor();
        }
    }

    public void compararCartas(int posicionIzq, int posicionDer ){
        boolean hayQueCambiarColor = false;
        switch (posicionIzq){
            case -1: //primera posición
                break;
            default:
                if (hayCarta(posicionIzq))
                    hayQueCambiarColor = compararValorCartas(posicionIzq, posicionIzq-1);
                if (hayQueCambiarColor)
                    cambiarColorCartaEnJuego(posicionIzq);
                break;
        }
        switch (posicionDer){
            case -1: //última posición
                break;
            default:
                if (hayCarta(posicionDer))
                    hayQueCambiarColor = compararValorCartas(posicionDer, posicionDer-1);
                if (hayQueCambiarColor)
                    cambiarColorCartaEnJuego(posicionDer);
                break;
        }
    }

    public void reto(int posicion){
        switch (posicion){
            case 0:
                compararCartas(-1, posicion+1);
                break;
            case 9:
                compararCartas(posicion-1, -1);
                break;
            default:
                compararCartas(posicion-1, posicion+1);
                break;
        }

    }
}
