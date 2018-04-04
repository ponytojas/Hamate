package com.MVDV.PL2;

import java.util.ArrayList;

public class jugador {
    private boolean maquina;
    private ArrayList <cartaEnMano> mano = new ArrayList<>();

    public jugador(boolean maquina) {
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

    public void recibirCarta(cartaEnMazo cartaRobada){
        if (!isLlena()) {
            cartaEnMano cartaAux = new cartaEnMano(cartaRobada.getValorIzq(), cartaRobada.getValorDer(), this.isMaquina());
            mano.add(cartaAux);
        }

    }
}
