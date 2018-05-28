package com.MVDV.PL2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v2.0.0
 */

public class Tablero implements Serializable{
    private ArrayList<HuecoDelTablero> cartasYaBajadas = new ArrayList<>();
    private ArrayList <Integer> posicionesVacias = new ArrayList<>();
    private ArrayList <Integer> posicionesLLenas = new ArrayList<>();

    /**
     * Constructor por defecto
     * Creamos 10 posiciones por defecto vacias
     */

    public Tablero() {
        int contador = 0;
        while (contador < 10) {
            HuecoDelTablero hueco = new HuecoDelTablero();
            hueco.setPosicion(contador+1);
            this.cartasYaBajadas.add(hueco);
            posicionesVacias.add(contador);
            contador++;
        }
        
    }

    /**
     * Getter
     * @return Comprueba y devuelve si el trablero esta lleno o no
     */

    public boolean estaElTableroLleno() {
        boolean devolucion = true;
        for (HuecoDelTablero huecoAux : this.cartasYaBajadas) {
            if (!huecoAux.getHayUnaCarta()) {
                devolucion = false;
                break;
            }
        }
        return devolucion;
    }

    /**
     * Getter
     * @return El array de cartas que estan en el tablero
     */

    public ArrayList<HuecoDelTablero> getCartasYaBajadas() {
        return cartasYaBajadas;
    }

    /**
     * Metodo que comprueba una posicion vacia en el tablero
     * @return Posicion vacia
     */
    public int comprobarHuecoVacio() {
        int posicionVacia = 0;
        for (HuecoDelTablero encontrarElHuecoVacio : cartasYaBajadas) {
            if (!encontrarElHuecoVacio.getHayUnaCarta())
                return posicionVacia;
            posicionVacia++;
        }
        return posicionVacia;
    }

    /**
     * Coloca la carta que estamos bajando al hueco y genera el reto
     * @param nuevaCartaEnTablero La carta que estamos jugando
     * @param posicionDelTablero Posicion del tablero donde se baja la carta
     * @param isMaquina Si la carta pertenece a la maquina o el jugador
     */

    public void ponerLaCartaEnElTablero(CartaEnJuego nuevaCartaEnTablero, int posicionDelTablero, boolean isMaquina) {
        this.quitarPosicionDelArrayDeHuecosVacios(posicionDelTablero);
        this.posicionesLLenas.add(posicionDelTablero);
        this.cartasYaBajadas.get(posicionDelTablero).setcartaEnElHueco(nuevaCartaEnTablero, posicionDelTablero, isMaquina);
        reto(posicionDelTablero);
    }
/**
 * Una vez se coloca una carta, la posicion se elimina del array de elementos vacios
 * @param posicionDondeSeQuiereBajarLaCarta Posicion a eliminar
 */
    private void quitarPosicionDelArrayDeHuecosVacios(int posicionDondeSeQuiereBajarLaCarta){
        for (int i = 0; i < this.posicionesVacias.size(); i++){
            if (this.posicionesVacias.get(i) == posicionDondeSeQuiereBajarLaCarta){
                this.posicionesVacias.remove(i);
                break;
            }
        }
    }

    /**
     * Comprueba si ya hay una carta en la posicion
     * @param posicion Posicion que comprobamos
     * @return Variable booleana si esta llena o no
     */
    public boolean comprobarPosicion(int posicion) {
        return this.cartasYaBajadas.get(posicion).getHayUnaCarta();
    }

    /**
     * Devuelve la posicion del ultimo hueco vacio
     * Metodo auxiliar para la maquina
     * @return La posicion del ultimo hueco
     */

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

    /**
     * Metodo que compara los valores de izquierda y derecha de la posicion donde bajamos la carta
     * Existen dos casos especiales, que son la primera y ultima posicion del tablero
     * @param posicionDelTablero Posicion donde estamos bajando la carta
     */


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

    /**
     * Comprobamos si la carta que bajamos es la ultima y la primera y solo comparamos con esa
     * Primeramente comprobamos si son o no del mismo color
     * @param retaDerecha Variable boolean que comprueba si reta a la izquierda o la derecha
     * @param posicionDelTablero Posicion donde bajamos la carta
     */

    private void compararValoresEspecial(boolean retaDerecha, int posicionDelTablero) {
        if (retaDerecha) {
            if (!sonMismoColor(posicionDelTablero, posicionDelTablero+1))
                if ( this.cartasYaBajadas.get(posicionDelTablero).getcartaEnElHueco().getValorDer() > this.cartasYaBajadas.get(posicionDelTablero+1).getcartaEnElHueco().getValorIzq())
                    this.cartasYaBajadas.get(posicionDelTablero+1).cambiarColor();
        }
        else {
            if (!sonMismoColor(posicionDelTablero, posicionDelTablero-1))
                if (this.cartasYaBajadas.get(posicionDelTablero).getcartaEnElHueco().getValorIzq() > this.cartasYaBajadas.get(posicionDelTablero-1).getcartaEnElHueco().getValorDer())
                    this.cartasYaBajadas.get(posicionDelTablero-1).cambiarColor();
        }
    }

    /**
     * Similar al metodo anterior, pero en este caso comparamos con la izquierda y la derecha
     * @param posicionDelTablero Posicion donde bajamos la carta
     */

    private void compararValoresNormal(int posicionDelTablero){
        if (!sonMismoColor(posicionDelTablero, posicionDelTablero+1))
            if ( this.cartasYaBajadas.get(posicionDelTablero).getcartaEnElHueco().getValorDer() > this.cartasYaBajadas.get(posicionDelTablero+1).getcartaEnElHueco().getValorIzq())
                this.cartasYaBajadas.get(posicionDelTablero+1).cambiarColor();
        if (!sonMismoColor(posicionDelTablero, posicionDelTablero-1))
            if (this.cartasYaBajadas.get(posicionDelTablero).getcartaEnElHueco().getValorIzq() > this.cartasYaBajadas.get(posicionDelTablero-1).getcartaEnElHueco().getValorDer())
                this.cartasYaBajadas.get(posicionDelTablero - 1).cambiarColor();
    }

    /**
     * Metodo que dadas dos posiciones comprueba si son del mismo color o no
     * Metodo auxiliar para el reto
     * @param posicion1 Primera posicion a bajar
     * @param posicion2 Segunda posicion a bajar
     * @return Comprueba si es o no del mismo color
     */

    private boolean sonMismoColor (int posicion1, int posicion2){
        if (comprobarPosicion(posicion2))
            return (this.cartasYaBajadas.get(posicion1).getesRoja() == this.cartasYaBajadas.get(posicion2).getesRoja());
        else
            return true;
    }

    /**
     *Metodo que devuelve la cantidad de cartas del jugador o de la maquina
     * Metodo auxiliar para comprobar quien ha ganado
     * @param jugadorMaquina Variable booleana para saber si nos referimos al jugador o la maquina
     * @return Cantidad de cartas que tiene el jugador o la maquina
     */
    public int getcantidadCartas(boolean jugadorMaquina) {
        int jugador = 0;
        int cantidad = 0;
        if (jugadorMaquina) jugador = 1 ;
        switch (jugador) {
            case 0:
                for (HuecoDelTablero variableAuxiliarParaContar : this.cartasYaBajadas)
                    if (variableAuxiliarParaContar.getesRoja())
                        cantidad++;

                break;

            case 1:
                for (HuecoDelTablero variableAuxiliarParaContar : this.cartasYaBajadas)
                    if (!variableAuxiliarParaContar.getesRoja())
                        cantidad++;
                break;
        }
        return cantidad;
    }

    /**
     * Metodo que calcula los puntos ganados por cada jugador, teniendo en cuenta si valen o no doble
     * @param jugadorMaquina Variable de control para saber si nos referimos a la maquina o jugador
     * @return 
     */
    public int calcularPuntos(boolean jugadorMaquina){
        int jugador = 0;
        int cantidad = 0;
        if (jugadorMaquina) jugador = 1 ;
        switch (jugador) {
            case 0:
                for (HuecoDelTablero variableAuxiliarParaContar : this.cartasYaBajadas)
                    if (variableAuxiliarParaContar.getesRoja()) {
                        if (variableAuxiliarParaContar.getcartaEnElHueco().getvaleDoble()) {
                            cantidad += 2;
                        } else
                            cantidad +=1;
                    }
                break;

            case 1:
                for (HuecoDelTablero variableAuxiliarParaContar : this.cartasYaBajadas)
                    if (!variableAuxiliarParaContar.getesRoja()) {
                        if (variableAuxiliarParaContar.getcartaEnElHueco().getvaleDoble()){
                            cantidad += 2;
                        }else
                            cantidad++;
                    }
                break;
        }
        return cantidad;
    }

    /**
     * Getter
     * @return tamaño del array de elementos vacios
     */
    public int getCantidadCartasVacias(){ return this.posicionesVacias.size(); }
    
    /**
     * Getter
     * @param posicion Dada una posicion devuelve el valor de la misma
     * @return 
     */
    public int getPosicionDelArrayVacio(int posicion){return this.posicionesVacias.get(posicion);}
    
    /**
     * Getter
     * @return Tamaño del array de posiciones llenas
     */
    public int getCantidadCartasLlenas(){return this.posicionesLLenas.size();}
    
    /**
     * Getter
     * @param posicion Posicion que solicitamos
     * @return Posicion del hueco lleno
     */
    public int getPosicionDelArrayLleno(int posicion){return this.posicionesLLenas.get(posicion);}
    
    /**
     * Getter
     * @return Array de todas las posiciones llenas
     */
    public ArrayList<Integer> getPosicionesLlenas(){return this.posicionesLLenas;}
    
    /**
     * Getter
     * @return Array de todas las cartas ya bajadas
     */
    public ArrayList getArrayCartasYaBajadas (){return this.cartasYaBajadas;}
}
