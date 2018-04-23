package com.MVDV.PL2;
import java.util.ArrayList;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Jugador {
    private boolean maquina;
    private ArrayList <CartaEnMano> mano = new ArrayList<>();

    public Jugador(boolean maquina) {
        this.maquina = maquina;
    }

    public boolean isMaquina() {
        return maquina;
    }

    public void setMaquina(boolean maquina) {
        this.maquina = maquina;
    }

    public boolean isLlena(){
       return (mano.size() == 5);
    }

    public void recibirCarta(CartaEnMazo cartaRobada){
        if (!isLlena()) {
            CartaEnMano cartaAux = new CartaEnMano(cartaRobada.getValorIzq(), cartaRobada.getValorDer(), this.isMaquina());
            cartaAux.setEnMazo(false);
            mano.add(cartaAux);
        }
    }

    public void soltarCarta(int posicion){
        this.mano.remove(posicion);
    }

    public CartaEnMano getCarta (int posicion){
        return this.mano.get(posicion);
    }

    public void mostrarMano(){
        int contador = 0;
        for (CartaEnMano aux: mano) {
            contador += 1;
            if (aux.getValorIzq() < 10)
                System.out.println(contador+")   Valor Izq: " + aux.getValorIzq() + " | Valor Der: " + aux.getValorDer());
            else
                System.out.println(contador+")   Valor Izq: " + aux.getValorIzq() + "| Valor Der: " + aux.getValorDer());
        }
    }



}
