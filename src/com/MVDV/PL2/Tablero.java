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
            HuecoDelTablero hueco = new HuecoDelTablero (contador+1 );
            cartasYaBajadas.add(hueco);
            contador++;
        }
    }

    public boolean estaElTableroLleno (){
        boolean devolucion = true;
        for (HuecoDelTablero huecoAux : cartasYaBajadas){
            if (!huecoAux.isHayUnaCarta()) {
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
            if (!encontrarElHuecoVacio.isHayUnaCarta())
                return posicionVacia;
            posicionVacia++;
        }
        return posicionVacia;
    }
    public void ponerLaCartaEnElTablero (CartaEnJuego nuevaCartaEnTablero, int posicionDelTablero) {
        int indexArrayList = comprobarHuecoVacio();
        cartasYaBajadas.get(indexArrayList).setCartaEnElHueco(nuevaCartaEnTablero, posicionDelTablero);
        cartasYaBajadas.get(indexArrayList).setHayUnaCarta(true);
    }

    public boolean comprobarPosicion (int posicion){
        return this.cartasYaBajadas.get(posicion).isHayUnaCarta();
    }
}
