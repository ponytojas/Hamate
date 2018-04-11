package com.MVDV.PL2;

import java.util.ArrayList;

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

    private boolean isLlena(){
       return (mano.size() == 5);
    }

    public void recibirCarta(CartaEnMazo cartaRobada){
        if (!isLlena()) {
            CartaEnMano cartaAux = new CartaEnMano(cartaRobada.getValorIzq(), cartaRobada.getValorDer(), this.isMaquina());
            mano.add(cartaAux);
        }
    }

}
