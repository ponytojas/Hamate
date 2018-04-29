package com.MVDV.PL2;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Tablero {
    private ArrayList<HuecoDelTablero> cartasYaBajadas = new ArrayList<>();


    public Tablero() {
        int contador = 0;
        while (contador < 10) {
            HuecoDelTablero hueco = new HuecoDelTablero();
            cartasYaBajadas.add(hueco);
            contador++;
        }
    }

    public boolean estaElTableroLleno() {
        boolean devolucion = true;
        for (HuecoDelTablero huecoAux : cartasYaBajadas) {
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

    public int comprobarHuecoVacio() {
        int posicionVacia = 0;
        for (HuecoDelTablero encontrarElHuecoVacio : cartasYaBajadas) {
            if (!encontrarElHuecoVacio.getHayUnaCarta())
                return posicionVacia;
            posicionVacia++;
        }
        return posicionVacia;
    }

    public void ponerLaCartaEnElTablero(CartaEnJuego nuevaCartaEnTablero, int posicionDelTablero, boolean isMaquina) {
        this.cartasYaBajadas.get(posicionDelTablero).setcartaEnElHueco(nuevaCartaEnTablero, posicionDelTablero, isMaquina);
        reto(posicionDelTablero);
    }

    public boolean comprobarPosicion(int posicion) {
        return this.cartasYaBajadas.get(posicion).getHayUnaCarta();
    }


    public int getCartasYaBajadasSize() {
        return cartasYaBajadas.size() - 1;
    }

    public int getHuecosVacios() {
        return 0;
    }

    public int getLastPlace() {
        int indexLastPlace = 0;
        for (HuecoDelTablero huecoAux : cartasYaBajadas) {
            if (!huecoAux.getHayUnaCarta()) {
                return indexLastPlace;
            }
            indexLastPlace++;
        }
        return indexLastPlace;
    }


    private void reto(int posicionDelTablero) {
        switch (posicionDelTablero) {
            case 0:
                compararValoresEspecial(true, posicionDelTablero);
                break;

            case 9:
                compararValoresEspecial(false, posicionDelTablero);
                break;

            default:
                compararValoresNormal(posicionDelTablero);
        }
    }

    private void compararValoresEspecial(boolean retaDerecha, int posicionDelTablero) {
        if (retaDerecha) {
            if (!sonMismoColor(posicionDelTablero, posicionDelTablero++))
                if ( this.cartasYaBajadas.get(posicionDelTablero).getcartaEnElHueco().getValorDer() > this.cartasYaBajadas.get(posicionDelTablero+1).getcartaEnElHueco().getValorIzq())
                    this.cartasYaBajadas.get(posicionDelTablero+1).getcartaEnElHueco().cambiarColor();
        }
        else {
            if (!sonMismoColor(posicionDelTablero, posicionDelTablero--))
                if (this.cartasYaBajadas.get(posicionDelTablero).getcartaEnElHueco().getValorIzq() > this.cartasYaBajadas.get(posicionDelTablero-1).getcartaEnElHueco().getValorDer())
                    this.cartasYaBajadas.get(posicionDelTablero-1).getcartaEnElHueco().cambiarColor();
        }
    }

    private void compararValoresNormal(int posicionDelTablero){
        if (!sonMismoColor(posicionDelTablero, posicionDelTablero++))
            if ( this.cartasYaBajadas.get(posicionDelTablero).getcartaEnElHueco().getValorDer() > this.cartasYaBajadas.get(posicionDelTablero+1).getcartaEnElHueco().getValorIzq())
                this.cartasYaBajadas.get(posicionDelTablero+1).getcartaEnElHueco().cambiarColor();
        if (!sonMismoColor(posicionDelTablero, posicionDelTablero--))
            if (this.cartasYaBajadas.get(posicionDelTablero).getcartaEnElHueco().getValorIzq() > this.cartasYaBajadas.get(posicionDelTablero-1).getcartaEnElHueco().getValorDer())
                this.cartasYaBajadas.get(posicionDelTablero - 1).getcartaEnElHueco().cambiarColor();
    }

    private boolean sonMismoColor (int posicion1, int posicion2){
    if (this.cartasYaBajadas.get(posicion1).getesRoja() != this.cartasYaBajadas.get(posicion2).getesRoja())
        return false;
    else
        return true;
    }
}
