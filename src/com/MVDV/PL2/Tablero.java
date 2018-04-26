package com.MVDV.PL2;
import java.util.ArrayList;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Tablero {
    private ArrayList <HuecoDelTablero> cartasYaBajadas = new ArrayList<>();


    public Tablero() {
        int contador = 0;
        while(contador < 10){
            HuecoDelTablero hueco = new HuecoDelTablero();
            cartasYaBajadas.add(hueco);
            contador++;
        }
    }

    public boolean estaElTableroLleno (){
        boolean devolucion = true;
        for (HuecoDelTablero huecoAux : cartasYaBajadas){
            if (!huecoAux.getHayUnaCarta()) {
                devolucion = false;
                break;
            }
        }
        return devolucion;
    }

    public ArrayList<HuecoDelTablero> getCartasYaBajadas() {
        return cartasYaBajadas;
    }

    public int comprobarHuecoVacio(){
        int posicionVacia = 0;
        for (HuecoDelTablero encontrarElHuecoVacio : cartasYaBajadas){
            if (!encontrarElHuecoVacio.getHayUnaCarta())
                return posicionVacia;
            posicionVacia++;
        }
        return posicionVacia;
    }
    public void ponerLaCartaEnElTablero (CartaEnJuego nuevaCartaEnTablero, int posicionDelTablero, boolean isMaquina) {
        cartasYaBajadas.get(posicionDelTablero).setcartaEnElHueco(nuevaCartaEnTablero, posicionDelTablero, isMaquina);

    }

    public boolean comprobarPosicion (int posicion){
        return this.cartasYaBajadas.get(posicion).getHayUnaCarta();
    }


    public int getCartasYaBajadasSize(){
        return cartasYaBajadas.size()-1;
    }

    public int getHuecosVacios(){
        return 0;
    }


    public void reto (int huecoTablero, boolean isMaquina){
        if (!isMaquina){
            if (this.cartasYaBajadas.);
        }

    }













}
