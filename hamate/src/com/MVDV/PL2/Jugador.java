package com.MVDV.PL2;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v1.0.0
 */

public class Jugador {
    private boolean maquina;
    private ArrayList <CartaEnMano> mano = new ArrayList<>();
    private String nombre;
    private String nif;
    private int edad;

    /**
     * Constructor
     * @param maquina Crea un jugador que puede sera maquina o usuario segun el parametro de entrada
     */
    public Jugador(boolean maquina) {
        this.maquina = maquina;
        /*if (!this.maquina)
            preguntasInicioPartida();
        else{
            this.nombre = "R2D2";
            this.edad = 42;
            this.nif = "01101000 01110101 01101100 01101001 01101111";
        }*/
        if (this.maquina){
            this.nombre = "R2D2";
            this.edad = 42;
            this.nif = "01101000 01110101 01101100 01101001 01101111";
        }
            
    }

    /**
     * Getter
     * @return Devuelve si el usuario es jugador o maquina
     */

    public boolean getisMaquina() {
        return this.maquina;
    }

    /**
     * Getter
     * @return Comprueba si la mano esta llena o no
     */
    public boolean getisLlena(){
       return (mano.size() == 5);
    }

    /**
     *
     * @param cartaRobada Convierte la carta que se ha recibido del mazo, en una carta de la mano, si la mano no esta llena
     */

    public void recibirCarta(CartaEnMazo cartaRobada){
        if (!getisLlena()) {
            CartaEnMano cartaAux = new CartaEnMano(cartaRobada.getValorIzq(), cartaRobada.getValorDer());
            mano.add(cartaAux);
        }
    }

    /**
     * Funcion que elimina de la mano la carta de la posicion que se pasa como input
     * @param posicion Posicion de la mano donde esta la carta
     */

    public void soltarCarta(int posicion){
        this.mano.remove(posicion);
    }

    /**
     * Getter
     * @param posicion Posicion de la carta en la mano
     * @return Devuelve la carta
     */

    public CartaEnMano getcarta (int posicion){
        return this.mano.get(posicion);
    }

    /**
     * Mostramos la mano del jugador para que pueda seleccionar la carta
     */

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

    /**
     * Getter
     * @return Size de la mano
     */

    public int getManoSize(){
        return mano.size()-1;
    }


    public void preguntasInicioPartida(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un nombre: ");
        this.nombre = entrada.nextLine();

        try{
            System.out.println("Introduce tu nif: ");
            this.nif = entrada.nextLine();
            if (this.nif.equals(""))
                throw new JugadorException(JugadorException.NIF_INCORRECTO);
        }catch (JugadorException msg){
            System.out.println(msg);
        }
        try {
            System.out.println("Introduce edad (en numero): ");
            this.edad = entrada.nextInt();
            if (this.edad < 18)
                throw new JugadorException(JugadorException.EDAD_INCORRECTA);
        }catch (JugadorException msg){
            //Terminar partida
        }
    }
    
    public void setNombre (String nombre){this.nombre = nombre; }
    
    public String getNombre(){return this.nombre; }
    
    public void setEdad (int edad){this.edad = edad; }
    
    public void setNif (String nif){this.nif = nif; }
}
