/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MVDV.PL2;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version v2.0.0
 */
public class TableroForm extends javax.swing.JFrame {
    private Jugador jugador;
    private Jugador maquina;
    private int posicionManoJugador = -1;
    private int posicionManoMaquina = -1 ;
    private int posicionTableroJugador = -1;
    private int posicionTableroMaquina = -1;
    ArrayList <JLabel> arrayCartasTablero = new ArrayList<>();
  
    private ArrayList <String> arrayRutasImagenesTablero = new ArrayList<>();
    private ArrayList <JLabel> arrayCartasManoJugador = new ArrayList<>();
    private ArrayList <JLabel> arrayCartasManoMaquina = new ArrayList<>();
    private ArrayList <String> pertenenciaCartasTablero = new ArrayList <>();
    private ArrayList<ArrayList<JLabel>> valoresIzqDerManoJugador = new ArrayList<>();
    private ArrayList<ArrayList<JLabel>> valoresIzqDerTablero = new ArrayList<>();
    private ArrayList<ArrayList<String>> arrayPosicionesCartasJugador = new ArrayList <>();
    private datosJugadorClasificacion clasificacion = new datosJugadorClasificacion();
    private ArrayList <String> arrayRutasImagenesJugador = new ArrayList<>();
    private ArrayList <String> arrayRutasImagenesMaquina = new ArrayList<>();
    
    /**
     * Funcion que crea el tablero, sus elementos e inicializa los elementos auxiliares (ArrayList) que se utilizan
     */
    public TableroForm(Jugador jugador, Jugador maquina) {
        //get imagenes de las cartas
        this.jugador = jugador;
        this.maquina = maquina;
        ArrayList <String> arrayImagenesJugador = getImagenesCartas(true);
        ArrayList <String> arrayImagenesMaquina = getImagenesCartas(false);
        initComponents();
        meterManosEnArray();
        meterPosicionesTablero();
        meterValoresIzqDerManoJugador();
        meterValoresIzqDerTablero();
        meterPosicionesCartasEnArray();
        setValorDerIzq();
        iniciarPertenenciasTablero();
        generarArrayImagenesJugadorMaquina();
        int contador = 0;
        for (String arrayAuxiliar : arrayImagenesJugador){
            contador += 1;
            setImagenMano(arrayAuxiliar,String.valueOf(contador) );
        }
    }
    
    /**
     * Genera dos arrays con las rutas de las imagenes tanto del jugador como de la maquina
     */
    
    private void generarArrayImagenesJugadorMaquina(){
    for (int recorrerMano = 0; recorrerMano < 5; recorrerMano++)
        this.arrayRutasImagenesJugador.add(this.jugador.getMano().get(recorrerMano).getnombreImagen());
    for (int recorrerMano = 0; recorrerMano < 5; recorrerMano++)
        this.arrayRutasImagenesMaquina.add(this.maquina.getMano().get(recorrerMano).getnombreImagen());
    }
    
    /**
     * Genera un array Con las 10 posiciones del tablero y sus pertenencias
     * En un momento de la partida, tendría la siguiente forma (J=jugador, N=nadie, M=Maquina)
     * [J][M][J][J][N][N][N][M][N][N]
     * Es un elemento auxiliar que se utiliza en diferentes metodos
     */
    
    private void iniciarPertenenciasTablero(){
        for (int i = 0; i < 10; i++)
            pertenenciaCartasTablero.add("Nadie");
    }
    
    /**
     * Generamos un array con las posiciones del tablero para facilitar el acceder a ellas
     */
    
    private void meterPosicionesTablero(){
        this.arrayCartasTablero.add(cartaTablero1);
        this.arrayCartasTablero.add(cartaTablero2);
        this.arrayCartasTablero.add(cartaTablero3);
        this.arrayCartasTablero.add(cartaTablero4);
        this.arrayCartasTablero.add(cartaTablero5);
        this.arrayCartasTablero.add(cartaTablero6);
        this.arrayCartasTablero.add(cartaTablero7);
        this.arrayCartasTablero.add(cartaTablero8);
        this.arrayCartasTablero.add(cartaTablero9);
        this.arrayCartasTablero.add(cartaTablero10);
    }
    
    /**
     * Generamos un array de los label de valores izquierdos y derechos de las cartas del jugador para facilitar el acceder a ellas
     */
    
    private void meterValoresIzqDerManoJugador(){
        ArrayList <JLabel> labelsMano;
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel1);
        labelsMano.add(this.jLabel2);
        this.valoresIzqDerManoJugador.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel3);
        labelsMano.add(this.jLabel4);
        this.valoresIzqDerManoJugador.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel5);
        labelsMano.add(this.jLabel6);
        this.valoresIzqDerManoJugador.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel7);
        labelsMano.add(this.jLabel8);
        this.valoresIzqDerManoJugador.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel9);
        labelsMano.add(this.jLabel10);
        this.valoresIzqDerManoJugador.add(labelsMano);
    }
    
    /**
     * Generamos un array de los label de valores izquierdos y derechos de las cartas del tablero para facilitar el acceder a ellas
     */
    
    private void meterValoresIzqDerTablero(){
        ArrayList <JLabel> labelsMano;
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel11);
        labelsMano.add(this.jLabel12);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel13);
        labelsMano.add(this.jLabel14);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel15);
        labelsMano.add(this.jLabel16);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel17);
        labelsMano.add(this.jLabel18);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel19);
        labelsMano.add(this.jLabel20);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel21);
        labelsMano.add(this.jLabel22);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel23);
        labelsMano.add(this.jLabel24);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel25);
        labelsMano.add(this.jLabel26);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel27);
        labelsMano.add(this.jLabel28);
        this.valoresIzqDerTablero.add(labelsMano);
        
        labelsMano = new ArrayList<>();
        labelsMano.add(this.jLabel29);
        labelsMano.add(this.jLabel30);
        this.valoresIzqDerTablero.add(labelsMano);
    }
    
    /**
     * Generamos dos arrays con los jFrame de las manos de maquina y jugador para facilitar el acceso
     */
    
    private void meterManosEnArray(){
        this.arrayCartasManoJugador.add(cartaManoJugador1);
        this.arrayCartasManoJugador.add(cartaManoJugador2);
        this.arrayCartasManoJugador.add(cartaManoJugador3);
        this.arrayCartasManoJugador.add(cartaManoJugador4);
        this.arrayCartasManoJugador.add(cartaManoJugador5);
        
        this.arrayCartasManoMaquina.add(cartaManoMaquina1);
        this.arrayCartasManoMaquina.add(cartaManoMaquina2);
        this.arrayCartasManoMaquina.add(cartaManoMaquina3);
        this.arrayCartasManoMaquina.add(cartaManoMaquina4);
        this.arrayCartasManoMaquina.add(cartaManoMaquina5);
    }
    
    /**
     * Generamos un array con las posiciones originales de cada carta en la mano, y si sufre alguna modificacion como posicion nueva
     */
    
    private void meterPosicionesCartasEnArray(){
        ArrayList <String> posicionNueva = new ArrayList();
        for (int i = 0; i < 5; i ++){
            posicionNueva = new ArrayList();
            posicionNueva.add("Posicion Original");
            posicionNueva.add(String.valueOf(i));
            posicionNueva.add("Posicion Nueva");
            posicionNueva.add(String.valueOf(i));
            posicionNueva.add("Hay Carta");
            posicionNueva.add("Si");
            posicionNueva.add("Jugador o Maquina");
            posicionNueva.add("Jugador");
            this.arrayPosicionesCartasJugador.add(posicionNueva);
        }
    }
    
    /**
     * Actualiza las posiciones del array modificando la posicion nueva de la carta en la mano
     */
    
    public void actualizarPosiciones(){
        int posicionTemporalAuxiliar = 0;
        int auxiliarValorArray;
        
        posicionTemporalAuxiliar = Integer.valueOf(this.arrayPosicionesCartasJugador.get(this.posicionManoJugador).get(3));
        for (int auxiliar = 0; auxiliar < 5; auxiliar++)
            if(this.posicionManoJugador == Integer.valueOf(this.arrayPosicionesCartasJugador.get(auxiliar).get(3)) 
                    && this.arrayPosicionesCartasJugador.get(auxiliar).get(5).equals("Si"))
                this.arrayPosicionesCartasJugador.get(auxiliar).set(5, "No");
            else if (Integer.valueOf(this.arrayPosicionesCartasJugador.get(auxiliar).get(3)) >= this.posicionManoJugador 
                    && this.arrayPosicionesCartasJugador.get(auxiliar).get(5).equals("Si")){
                int valorTemporal = Integer.valueOf(this.arrayPosicionesCartasJugador.get(auxiliar).get(3));
                valorTemporal -= 1;
                this.arrayPosicionesCartasJugador.get(auxiliar).set(3, String.valueOf(valorTemporal));
            }
        }
    
    /**
     * Getter
     * @return Posicion de la mano seleccionada por el jugador
     */
    public int getPosicionManoJugador(){return this.posicionManoJugador;}
    
    /**
     * Getter
     * @return Posicion seleccionada del tablero
     */
    public int getPosicionTablero(){return this.posicionTableroJugador;}
    
     /**
     * Setter
     */
    public void setPosicionManoMaquina(int posicion){this.posicionManoMaquina = posicion;}
    
    /**
     * Setter
     */
    public void setPosicionTableroMaquina(int posicion){this.posicionTableroMaquina = posicion;}
    
    /**
     * Setter
     */
    public void setPosicionManoJugador(int posicion){this.posicionManoJugador = posicion;}
    
    /**
     * Setter
     */
    public void setPosicionTableroJugador(int posicion){this.posicionTableroJugador = posicion;}
    
    
    /**
     * Funcion principal que gestiona la bajada de cartas desde la mano al tablero
     * Primeramente cogemos la imagen de la carta de la mano y la ponemos en el hueco del tablero correspondiente
     * Despues, ocultamos los valores de izquierda y derecha de la carta de la mano si es el jugador, y ponemos los que correspondan en el tablero
     * Seguidamente, ocultamos el icono de la carta de la mano
     * Actualizamos la pertenencia de la carta que corresponda, asi como los colores de las adyacentes
     * Por ultimo, actualizamos las posiciones del array (posicion nueva referida anterioremente)
     * @param esMaquina Variable para comprobar si el turno es de la maquina o jugador
     */
    public void pasarCartaManoAlTablero(boolean esMaquina){
        try{
        String rutaImagenAColocarEnTablero;
        if (!esMaquina)
            rutaImagenAColocarEnTablero = this.arrayRutasImagenesJugador.get(posicionManoJugador);
        else
            rutaImagenAColocarEnTablero = this.arrayRutasImagenesMaquina.get(posicionManoMaquina);
        
        setImagenTablero(rutaImagenAColocarEnTablero, !esMaquina); 
        ocultarCartaValoresIzqDerAndsetValoresIzqDerTablero(!esMaquina);
        ocultarCartaMano(!esMaquina);
        this.actualizarPertenencia(!esMaquina);
        if (!esMaquina){
            this.arrayRutasImagenesJugador.remove(this.posicionManoJugador);
            actualizarPosiciones();
        }
        else
            this.arrayRutasImagenesMaquina.remove(this.posicionManoMaquina);
        
    } catch (Exception e){
        String methodName;
           methodName = e.getStackTrace()[0].getMethodName();
           e.getMessage();
           String message = String.valueOf(Thread.currentThread().getStackTrace()[2].getLineNumber());
           JFrame frame = new JFrame();
           JOptionPane.showMessageDialog(frame, e + methodName + message, "Error tableroForm", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Setter 
     * Si la carta bajada es del jugador o la maquina dejamos referencia de ello
     * @param esJugador Variable de control sobre si es carta del jugador o la maquina
     */
    
    private void actualizarPertenencia(boolean esJugador){
        if (esJugador)
            this.pertenenciaCartasTablero.set(this.posicionTableroJugador, "Jugador");
        else
            this.pertenenciaCartasTablero.set(this.posicionTableroMaquina, "Maquina");
    }
    
    /**
     * Funcion para obtener el valor de la posicion de la carta real que tiene en ese momento en la mano
     * @param posicion
     * @return La posicion real actual de la carta
     */
    private int getValorRealPosicion(int posicion){
        return Integer.valueOf(this.arrayPosicionesCartasJugador.get(posicion).get(3));
    }
    
    
     /**
     * Funcion para obtener el valor de la posicion de la carta original que tiene en ese momento en la mano
     * @param posicion
     * @return La posicion original de la carta
     */
    private int getValorOriginalPosicion (){
        int devolucion = -1;
        for (ArrayList <String> arrayAuxiliar : arrayPosicionesCartasJugador)
            if(this.posicionManoJugador == Integer.valueOf(arrayAuxiliar.get(3)) && arrayAuxiliar.get(5).equals("Si")){
                devolucion = Integer.valueOf(arrayAuxiliar.get(1));
                break;
            }
        return devolucion;
    }
    
    
    /**
     * Metodo que oculta los valores en la mano y los coloca en el tablero
     * @param esJugador Variable de control si es jugador o maquina
     */
    private void ocultarCartaValoresIzqDerAndsetValoresIzqDerTablero(boolean esJugador){
        if (esJugador){
            String textAux = String.valueOf(this.jugador.getMano().get(this.posicionManoJugador).getValorIzq());
            String textAux2 = String.valueOf(this.jugador.getMano().get(this.posicionManoJugador).getValorDer());
            this.valoresIzqDerTablero.get(this.posicionTableroJugador).get(0).setText(textAux);
            this.valoresIzqDerTablero.get(this.posicionTableroJugador).get(0).setVisible(true);
            this.valoresIzqDerTablero.get(this.posicionTableroJugador).get(1).setText(textAux2);
            this.valoresIzqDerTablero.get(this.posicionTableroJugador).get(1).setVisible(true);
            this.valoresIzqDerManoJugador.get(getValorOriginalPosicion()).get(0).setVisible(false);
            this.valoresIzqDerManoJugador.get(getValorOriginalPosicion()).get(1).setVisible(false);
        }else{
            String textAux = String.valueOf(this.maquina.getMano().get(this.posicionManoMaquina).getValorIzq());
            String textAux2 = String.valueOf(this.maquina.getMano().get(this.posicionManoMaquina).getValorDer());
            this.valoresIzqDerTablero.get(this.posicionTableroMaquina).get(0).setText(textAux);
            this.valoresIzqDerTablero.get(this.posicionTableroMaquina).get(0).setVisible(true);
            this.valoresIzqDerTablero.get(this.posicionTableroMaquina).get(1).setText(textAux2);
            this.valoresIzqDerTablero.get(this.posicionTableroMaquina).get(1).setVisible(true);
        }
        
    }
    
    /**
     * Metodo que oculta la carta de la mano
     * @param esJugador Variable de control sobre si es jugador o maquina
     */
    private void ocultarCartaMano(boolean esJugador){
        if (esJugador){
            this.arrayCartasManoJugador.get(getValorOriginalPosicion()).setVisible(false);
            
        }else{
            this.arrayCartasManoMaquina.get(this.posicionManoMaquina).setVisible(false);
            this.arrayCartasManoMaquina.remove(this.posicionManoMaquina);
        }
    }
    
    
    /**
     * Setter
     * Aplica la imagen correspondiente a la posicion del tablero
     * @param rutaImagen Ruta de la imagen a colocar
     * @param esJugador Variable de control
     */
    private void setImagenTablero(String rutaImagen, boolean esJugador){
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        
        int posicionTableroAuxiliar;
        if (esJugador)
            posicionTableroAuxiliar = this.posicionTableroJugador;
        else
            posicionTableroAuxiliar = this.posicionTableroMaquina;
        
        JLabel auxiliarCarta = new JLabel();
        auxiliarCarta = this.arrayCartasTablero.get(posicionTableroAuxiliar);
        auxiliarCarta.setSize(105, 150);
        ImageIcon imagenTablero = new ImageIcon(rutaImagen);
        ImageIcon imgRedimensionada1 = new ImageIcon(imagenTablero.getImage()
                .getScaledInstance(auxiliarCarta.getWidth(), auxiliarCarta.getHeight(), 1));
        auxiliarCarta.setIcon(imgRedimensionada1);
        if (esJugador)
            auxiliarCarta.setBackground(new java.awt.Color(33, 150, 243));
        else
            auxiliarCarta.setBackground(new java.awt.Color(210, 9, 40));
        auxiliarCarta.setOpaque(true);
        auxiliarCarta.setBorder(none);
        this.arrayCartasTablero.set(posicionTableroAuxiliar, auxiliarCarta);
    }
    
    
    /**
     * Funcion del reto adaptada a GUI
     * Comprobamos los valores izquierda o derecha que correspondan y cambiamos los colores
     * @param esJugador 
     */
    public void actualizarColores(boolean esJugador){
        int posicionAuxiliarTablero;
        if (esJugador)
            posicionAuxiliarTablero = this.posicionTableroJugador;
        else
            posicionAuxiliarTablero = this.posicionTableroMaquina;
        
        switch (posicionAuxiliarTablero){
            case 0:
                if (!this.pertenenciaCartasTablero.get(posicionAuxiliarTablero).equals(this.pertenenciaCartasTablero.get((posicionAuxiliarTablero+1)))
                        && !this.pertenenciaCartasTablero.get((posicionAuxiliarTablero+1)).equals("Nadie")){
                    int valorDerCartaBajada = Integer.valueOf(this.valoresIzqDerTablero.get(posicionAuxiliarTablero).get(1).getText());
                    int ValorIzqCartaYaEnJuego = Integer.valueOf(this.valoresIzqDerTablero.get((posicionAuxiliarTablero+1)).get(0).getText());
                    if (esElValorBajadoMayor(valorDerCartaBajada, ValorIzqCartaYaEnJuego))
                        ponerColor(esJugador, (posicionAuxiliarTablero+1));
                }
                break;
            case 9:
                if (!this.pertenenciaCartasTablero.get(posicionAuxiliarTablero).equals(this.pertenenciaCartasTablero.get((posicionAuxiliarTablero-1)))
                        && !this.pertenenciaCartasTablero.get((posicionAuxiliarTablero-1)).equals("Nadie")){
                    int valorDerCartaBajada = Integer.valueOf(this.valoresIzqDerTablero.get(posicionAuxiliarTablero).get(0).getText());
                    int ValorIzqCartaYaEnJuego = Integer.valueOf(this.valoresIzqDerTablero.get((posicionAuxiliarTablero-1)).get(1).getText());
                    if (esElValorBajadoMayor(valorDerCartaBajada, ValorIzqCartaYaEnJuego))
                        ponerColor(esJugador, (posicionAuxiliarTablero-1));
                }
                break;
            default:
                if (!this.pertenenciaCartasTablero.get(posicionAuxiliarTablero).equals(this.pertenenciaCartasTablero.get((posicionAuxiliarTablero+1)))
                        && !this.pertenenciaCartasTablero.get((posicionAuxiliarTablero+1)).equals("Nadie")){
                    int valorDerCartaBajada = Integer.valueOf(this.valoresIzqDerTablero.get(posicionAuxiliarTablero).get(1).getText());
                    int ValorIzqCartaYaEnJuego = Integer.valueOf(this.valoresIzqDerTablero.get((posicionAuxiliarTablero+1)).get(0).getText());
                    if (esElValorBajadoMayor(valorDerCartaBajada, ValorIzqCartaYaEnJuego))
                        ponerColor(esJugador, (posicionAuxiliarTablero+1));
                }
                if (!this.pertenenciaCartasTablero.get(posicionAuxiliarTablero).equals(this.pertenenciaCartasTablero.get((posicionAuxiliarTablero-1)))
                        && !this.pertenenciaCartasTablero.get((posicionAuxiliarTablero-1)).equals("Nadie")){
                    int valorDerCartaBajada = Integer.valueOf(this.valoresIzqDerTablero.get(posicionAuxiliarTablero).get(0).getText());
                    int ValorIzqCartaYaEnJuego = Integer.valueOf(this.valoresIzqDerTablero.get(posicionAuxiliarTablero-1).get(1).getText());
                    if (esElValorBajadoMayor(valorDerCartaBajada, ValorIzqCartaYaEnJuego))
                        ponerColor(esJugador, (posicionAuxiliarTablero-1));
                }
                break;
        }
        
    }
    
    /**
     * Establece el color
     * @param esJugador Variable de control
     * @param posicion  Posicion donde se cambiara el color
     */
    
    private void ponerColor(boolean esJugador, int posicion){
        if (esJugador)
            this.arrayCartasTablero.get(posicion).setBackground(new java.awt.Color(33, 150, 243));
        else
            this.arrayCartasTablero.get(posicion).setBackground(new java.awt.Color(210, 9, 40));
    }
    
    
    /**
     * Variable auxiliar que compara dos valores
     * @param valorCartaBajada
     * @param valorCartaEnJuego
     * @return Si el valor de la carta que se baja es mayor
     */
    private boolean esElValorBajadoMayor(int valorCartaBajada, int valorCartaEnJuego){
        return (valorCartaBajada > valorCartaEnJuego);
    }
    
    /**
     * Establece la imagen en las cartas del jugador
     * @param rutaImagen Ruta a la imagen
     * @param posicionMano Posicion de la carta de la mano que se establece
     */
    private void setImagenMano(String rutaImagen, String posicionMano){
        switch (posicionMano){
            case "1":
                this.cartaManoJugador1.setSize(105, 150);
                ImageIcon imagenManoJugador1 = new ImageIcon(rutaImagen);
                ImageIcon imgRedimensionada1 = new ImageIcon(imagenManoJugador1.getImage()
                        .getScaledInstance(cartaManoJugador1.getWidth(), cartaManoJugador1.getHeight(), 1));
                this.cartaManoJugador1.setIcon(imgRedimensionada1);
                break;
                
            case "2":
                this.cartaManoJugador2.setSize(105, 150);
                ImageIcon imagenManoJugador2 = new ImageIcon(rutaImagen);
                ImageIcon imgRedimensionada2 = new ImageIcon(imagenManoJugador2.getImage()
                        .getScaledInstance(cartaManoJugador2.getWidth(), cartaManoJugador2.getHeight(), 1));
                this.cartaManoJugador2.setIcon(imgRedimensionada2);
                break;
                
            case "3":
                this.cartaManoJugador3.setSize(105, 150);
                ImageIcon imagenManoJugador3 = new ImageIcon(rutaImagen);
                ImageIcon imgRedimensionada3 = new ImageIcon(imagenManoJugador3.getImage()
                        .getScaledInstance(cartaManoJugador3.getWidth(), cartaManoJugador3.getHeight(), 1));
                this.cartaManoJugador3.setIcon(imgRedimensionada3);
                break;
                
            case "4":
                this.cartaManoJugador4.setSize(105, 150);
                ImageIcon imagenManoJugador4 = new ImageIcon(rutaImagen);
                ImageIcon imgRedimensionada4 = new ImageIcon(imagenManoJugador4.getImage()
                        .getScaledInstance(cartaManoJugador4.getWidth(), cartaManoJugador4.getHeight(), 1));
                this.cartaManoJugador4.setIcon(imgRedimensionada4);
                break;
                
            case "5":
                this.cartaManoJugador5.setSize(105, 150);
                ImageIcon imagenManoJugador5 = new ImageIcon(rutaImagen);
                ImageIcon imgRedimensionada5 = new ImageIcon(imagenManoJugador5.getImage()
                        .getScaledInstance(cartaManoJugador5.getWidth(), cartaManoJugador5.getHeight(), 1));
                this.cartaManoJugador5.setIcon(imgRedimensionada5);
                break;
        }
    }
    
    /**
     * Establece el valor de los valores izq y der en las cartas de la mano del jugador
     */
    
    private void setValorDerIzq (){
        this.jLabel1.setText(String.valueOf(this.jugador.getMano().get(0).getValorIzq()));
        this.jLabel2.setText(String.valueOf(this.jugador.getMano().get(0).getValorDer()));
        this.jLabel3.setText(String.valueOf(this.jugador.getMano().get(1).getValorIzq()));
        this.jLabel4.setText(String.valueOf(this.jugador.getMano().get(1).getValorDer()));
        this.jLabel5.setText(String.valueOf(this.jugador.getMano().get(2).getValorIzq()));
        this.jLabel6.setText(String.valueOf(this.jugador.getMano().get(2).getValorDer()));
        this.jLabel7.setText(String.valueOf(this.jugador.getMano().get(3).getValorIzq()));
        this.jLabel8.setText(String.valueOf(this.jugador.getMano().get(3).getValorDer()));
        this.jLabel9.setText(String.valueOf(this.jugador.getMano().get(4).getValorIzq()));
        this.jLabel10.setText(String.valueOf(this.jugador.getMano().get(4).getValorDer()));
    }
    
    private TableroForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Genera un array con las imagenes de las cartas de la mano
     * @param esJugador Variable de control
     * @return ArrayList con las rutas de las imagenes
     */
    private ArrayList <String> getImagenesCartas(boolean esJugador){
        ArrayList <String> arrayImagenes = new ArrayList<>();
        if (esJugador)
            for (CartaEnMano variableAuxiliarQueRecorreLaMano : this.jugador.getMano())
                arrayImagenes.add(variableAuxiliarQueRecorreLaMano.getnombreImagen());
        else
        for (CartaEnMano variableAuxiliarQueRecorreLaMano : this.maquina.getMano())
                arrayImagenes.add(variableAuxiliarQueRecorreLaMano.getnombreImagen());
        return arrayImagenes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cartaManoJugador1 = new javax.swing.JLabel();
        cartaManoJugador2 = new javax.swing.JLabel();
        cartaManoJugador3 = new javax.swing.JLabel();
        cartaManoJugador4 = new javax.swing.JLabel();
        cartaManoJugador5 = new javax.swing.JLabel();
        cartaTablero1 = new javax.swing.JLabel();
        cartaTablero2 = new javax.swing.JLabel();
        cartaTablero3 = new javax.swing.JLabel();
        cartaTablero4 = new javax.swing.JLabel();
        cartaTablero7 = new javax.swing.JLabel();
        cartaTablero8 = new javax.swing.JLabel();
        cartaTablero6 = new javax.swing.JLabel();
        cartaTablero5 = new javax.swing.JLabel();
        cartaTablero10 = new javax.swing.JLabel();
        cartaTablero9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cartaManoMaquina1 = new javax.swing.JLabel();
        cartaManoMaquina2 = new javax.swing.JLabel();
        cartaManoMaquina3 = new javax.swing.JLabel();
        cartaManoMaquina4 = new javax.swing.JLabel();
        cartaManoMaquina5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 87, 68));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 87, 68));
        jPanel1.setForeground(new java.awt.Color(0, 87, 68));
        jPanel1.setSize(new java.awt.Dimension(1410, 890));

        cartaManoJugador1.setBackground(new java.awt.Color(33, 150, 243));
        cartaManoJugador1.setForeground(new java.awt.Color(210, 9, 40));
        cartaManoJugador1.setOpaque(true);
        cartaManoJugador1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaManoJugador1MouseMoved(evt);
            }
        });
        cartaManoJugador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaManoJugador1MouseClicked(evt);
            }
        });

        cartaManoJugador2.setBackground(new java.awt.Color(33, 150, 243));
        cartaManoJugador2.setForeground(new java.awt.Color(210, 9, 40));
        cartaManoJugador2.setOpaque(true);
        cartaManoJugador2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaManoJugador2MouseMoved(evt);
            }
        });
        cartaManoJugador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaManoJugador2MouseClicked(evt);
            }
        });

        cartaManoJugador3.setBackground(new java.awt.Color(33, 150, 243));
        cartaManoJugador3.setForeground(new java.awt.Color(210, 9, 40));
        cartaManoJugador3.setOpaque(true);
        cartaManoJugador3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaManoJugador3MouseMoved(evt);
            }
        });
        cartaManoJugador3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaManoJugador3MouseClicked(evt);
            }
        });

        cartaManoJugador4.setBackground(new java.awt.Color(33, 150, 243));
        cartaManoJugador4.setForeground(new java.awt.Color(210, 9, 40));
        cartaManoJugador4.setOpaque(true);
        cartaManoJugador4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaManoJugador4MouseMoved(evt);
            }
        });
        cartaManoJugador4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaManoJugador4MouseClicked(evt);
            }
        });

        cartaManoJugador5.setBackground(new java.awt.Color(33, 150, 243));
        cartaManoJugador5.setForeground(new java.awt.Color(210, 9, 40));
        cartaManoJugador5.setOpaque(true);
        cartaManoJugador5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaManoJugador5MouseMoved(evt);
            }
        });
        cartaManoJugador5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaManoJugador5MouseClicked(evt);
            }
        });

        cartaTablero1.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero1.setOpaque(true);
        cartaTablero1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero1MouseMoved(evt);
            }
        });
        cartaTablero1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero1MouseClicked(evt);
            }
        });

        cartaTablero2.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero2.setOpaque(true);
        cartaTablero2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero2MouseMoved(evt);
            }
        });
        cartaTablero2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero2MouseClicked(evt);
            }
        });

        cartaTablero3.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero3.setOpaque(true);
        cartaTablero3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero3MouseMoved(evt);
            }
        });
        cartaTablero3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero3MouseClicked(evt);
            }
        });

        cartaTablero4.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero4.setOpaque(true);
        cartaTablero4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero4MouseMoved(evt);
            }
        });
        cartaTablero4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero4MouseClicked(evt);
            }
        });

        cartaTablero7.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero7.setOpaque(true);
        cartaTablero7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero7MouseMoved(evt);
            }
        });
        cartaTablero7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero7MouseClicked(evt);
            }
        });

        cartaTablero8.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero8.setOpaque(true);
        cartaTablero8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero8MouseMoved(evt);
            }
        });
        cartaTablero8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero8MouseClicked(evt);
            }
        });

        cartaTablero6.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero6.setOpaque(true);
        cartaTablero6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero6MouseMoved(evt);
            }
        });
        cartaTablero6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero6MouseClicked(evt);
            }
        });

        cartaTablero5.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero5.setOpaque(true);
        cartaTablero5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero5MouseMoved(evt);
            }
        });
        cartaTablero5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero5MouseClicked(evt);
            }
        });

        cartaTablero10.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero10.setOpaque(true);
        cartaTablero10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero10MouseMoved(evt);
            }
        });
        cartaTablero10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero10MouseClicked(evt);
            }
        });

        cartaTablero9.setBackground(new java.awt.Color(72, 72, 85));
        cartaTablero9.setOpaque(true);
        cartaTablero9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cartaTablero9MouseMoved(evt);
            }
        });
        cartaTablero9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartaTablero9MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 250, 250));
        jLabel1.setText("1");

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("2");

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 250, 250));
        jLabel3.setText("3");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 250, 250));
        jLabel4.setText("4");

        jLabel5.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(250, 250, 250));
        jLabel5.setText("5");

        jLabel6.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 250, 250));
        jLabel6.setText("6");

        jLabel7.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(250, 250, 250));
        jLabel7.setText("7");

        jLabel8.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(250, 250, 250));
        jLabel8.setText("8");

        jLabel9.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(250, 250, 250));
        jLabel9.setText("9");

        jLabel10.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(250, 250, 250));
        jLabel10.setText("10");

        jButton1.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jButton2.setText("Clasificacion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        jButton3.setText("Reiniciar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(250, 250, 250));
        jLabel11.setText("11");
        jLabel11.setVisible(false);

        jLabel12.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(250, 250, 250));
        jLabel12.setText("11");
        jLabel12.setVisible(false);

        jLabel13.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(250, 250, 250));
        jLabel13.setText("11");
        jLabel13.setVisible(false);

        jLabel14.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(250, 250, 250));
        jLabel14.setText("11");
        jLabel14.setVisible(false);

        jLabel15.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(250, 250, 250));
        jLabel15.setText("11");
        jLabel15.setVisible(false);

        jLabel16.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(250, 250, 250));
        jLabel16.setText("11");
        jLabel16.setVisible(false);

        jLabel17.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(250, 250, 250));
        jLabel17.setText("11");
        jLabel17.setVisible(false);

        jLabel18.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(250, 250, 250));
        jLabel18.setText("11");
        jLabel18.setVisible(false);

        jLabel19.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(250, 250, 250));
        jLabel19.setText("11");
        jLabel19.setVisible(false);

        jLabel20.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(250, 250, 250));
        jLabel20.setText("11");
        jLabel20.setVisible(false);

        jLabel21.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(250, 250, 250));
        jLabel21.setText("11");
        jLabel21.setVisible(false);

        jLabel22.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(250, 250, 250));
        jLabel22.setText("11");
        jLabel22.setVisible(false);

        jLabel23.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(250, 250, 250));
        jLabel23.setText("11");
        jLabel23.setVisible(false);

        jLabel24.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(250, 250, 250));
        jLabel24.setText("11");
        jLabel24.setVisible(false);

        jLabel25.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(250, 250, 250));
        jLabel25.setText("11");
        jLabel25.setVisible(false);

        jLabel26.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(250, 250, 250));
        jLabel26.setText("11");
        jLabel26.setVisible(false);

        jLabel27.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(250, 250, 250));
        jLabel27.setText("11");
        jLabel27.setVisible(false);

        jLabel28.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(250, 250, 250));
        jLabel28.setText("11");
        jLabel28.setVisible(false);

        jLabel29.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(250, 250, 250));
        jLabel29.setText("11");
        jLabel29.setVisible(false);

        jLabel30.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(250, 250, 250));
        jLabel30.setText("11");
        jLabel30.setVisible(false);

        cartaManoMaquina1.setBackground(new java.awt.Color(210, 9, 40));
        cartaManoMaquina1.setOpaque(true);

        cartaManoMaquina2.setBackground(new java.awt.Color(210, 9, 40));
        cartaManoMaquina2.setOpaque(true);

        cartaManoMaquina3.setBackground(new java.awt.Color(210, 9, 40));
        cartaManoMaquina3.setOpaque(true);

        cartaManoMaquina4.setBackground(new java.awt.Color(210, 9, 40));
        cartaManoMaquina4.setOpaque(true);

        cartaManoMaquina5.setBackground(new java.awt.Color(210, 9, 40));
        cartaManoMaquina5.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(83, 83, 83))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel12))
                                            .addComponent(cartaTablero1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14))
                                            .addComponent(cartaTablero2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel16))
                                            .addComponent(cartaTablero3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel18))
                                            .addComponent(cartaTablero4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(224, 224, 224)
                                        .addComponent(cartaManoMaquina1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cartaManoMaquina2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel20))
                                            .addComponent(cartaTablero5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(cartaManoMaquina3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel22))
                                            .addComponent(cartaTablero6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel24))
                                            .addComponent(cartaTablero7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel25)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel26))
                                            .addComponent(cartaTablero8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel28))
                                            .addComponent(cartaTablero9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cartaTablero10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel29)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel30))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(cartaManoMaquina4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(cartaManoMaquina5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(cartaManoJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(cartaManoJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(cartaManoJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addComponent(cartaManoJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cartaManoJugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartaManoMaquina2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaManoMaquina1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaManoMaquina3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaManoMaquina4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaManoMaquina5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartaTablero3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cartaTablero2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartaTablero4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartaTablero5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartaTablero6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartaTablero7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartaTablero8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartaTablero9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartaTablero10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cartaTablero1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cartaManoJugador5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaManoJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaManoJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaManoJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartaManoJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cartaManoJugador1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador1MouseMoved
        // TODO add your handling code here:
        this.cartaManoJugador1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaManoJugador1MouseMoved

    private void cartaManoJugador2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador2MouseMoved
        // TODO add your handling code here:
        this.cartaManoJugador2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaManoJugador2MouseMoved

    private void cartaManoJugador3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador3MouseMoved
        // TODO add your handling code here:
        this.cartaManoJugador3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaManoJugador3MouseMoved

    private void cartaManoJugador4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador4MouseMoved
        // TODO add your handling code here:
        this.cartaManoJugador4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaManoJugador4MouseMoved

    private void cartaTablero1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero1MouseMoved
        // TODO add your handling code here:
        this.cartaTablero1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero1MouseMoved

    private void cartaManoJugador5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador5MouseMoved
        // TODO add your handling code here:
        this.cartaManoJugador5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaManoJugador5MouseMoved

    private void cartaTablero2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero2MouseMoved
        // TODO add your handling code here:
        this.cartaTablero2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero2MouseMoved

    private void cartaTablero3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero3MouseMoved
        // TODO add your handling code here:
        this.cartaTablero3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero3MouseMoved

    private void cartaTablero4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero4MouseMoved
        // TODO add your handling code here:
        this.cartaTablero4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero4MouseMoved

    private void cartaTablero5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero5MouseMoved
        // TODO add your handling code here:
        this.cartaTablero7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero5MouseMoved

    private void cartaTablero6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero6MouseMoved
        // TODO add your handling code here:
        this.cartaTablero8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero6MouseMoved

    private void cartaTablero7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero7MouseMoved
        // TODO add your handling code here:
        this.cartaTablero6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero7MouseMoved

    private void cartaTablero8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero8MouseMoved
        // TODO add your handling code here:
        this.cartaTablero5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero8MouseMoved

    private void cartaTablero9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero9MouseMoved
        // TODO add your handling code here:
        this.cartaTablero9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero9MouseMoved

    private void cartaTablero10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero10MouseMoved
        // TODO add your handling code here:
        this.cartaTablero10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_cartaTablero10MouseMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, this.clasificacion.dibujarClasificacionInterfaz(), "Clasificacion", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cartaManoJugador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador1MouseClicked
        // TODO add your handling code here:
        Border red = BorderFactory.createLineBorder(Color.RED,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaManoJugador1.setBorder(red);
        this.cartaManoJugador2.setBorder(none);
        this.cartaManoJugador3.setBorder(none);
        this.cartaManoJugador4.setBorder(none);
        this.cartaManoJugador5.setBorder(none);
        this.posicionManoJugador = this.getValorRealPosicion(0);
    }//GEN-LAST:event_cartaManoJugador1MouseClicked

    private void cartaManoJugador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador2MouseClicked
        // TODO add your handling code here:
        Border red = BorderFactory.createLineBorder(Color.RED,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaManoJugador1.setBorder(none);
        this.cartaManoJugador2.setBorder(red);
        this.cartaManoJugador3.setBorder(none);
        this.cartaManoJugador4.setBorder(none);
        this.cartaManoJugador5.setBorder(none);
        this.posicionManoJugador = this.getValorRealPosicion(1);
    }//GEN-LAST:event_cartaManoJugador2MouseClicked

    private void cartaManoJugador3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador3MouseClicked
        // TODO add your handling code here:
       Border red = BorderFactory.createLineBorder(Color.RED,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaManoJugador1.setBorder(none);
        this.cartaManoJugador2.setBorder(none);
        this.cartaManoJugador3.setBorder(red);
        this.cartaManoJugador4.setBorder(none);
        this.cartaManoJugador5.setBorder(none);
        this.posicionManoJugador = this.getValorRealPosicion(2);
    }//GEN-LAST:event_cartaManoJugador3MouseClicked

    private void cartaManoJugador4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador4MouseClicked
        // TODO add your handling code here:
        Border red = BorderFactory.createLineBorder(Color.RED,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaManoJugador1.setBorder(none);
        this.cartaManoJugador2.setBorder(none);
        this.cartaManoJugador3.setBorder(none);
        this.cartaManoJugador4.setBorder(red);
        this.cartaManoJugador5.setBorder(none);
        this.posicionManoJugador = this.getValorRealPosicion(3);
    }//GEN-LAST:event_cartaManoJugador4MouseClicked

    private void cartaManoJugador5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaManoJugador5MouseClicked
        // TODO add your handling code here:
        Border red = BorderFactory.createLineBorder(Color.RED,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaManoJugador1.setBorder(none);
        this.cartaManoJugador2.setBorder(none);
        this.cartaManoJugador3.setBorder(none);
        this.cartaManoJugador4.setBorder(none);
        this.cartaManoJugador5.setBorder(red);
        this.posicionManoJugador = this.getValorRealPosicion(4);
    }//GEN-LAST:event_cartaManoJugador5MouseClicked

    private void cartaTablero1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero1MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(yellow);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 0;
    }//GEN-LAST:event_cartaTablero1MouseClicked

    private void cartaTablero2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero2MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(yellow);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 1;
    }//GEN-LAST:event_cartaTablero2MouseClicked

    private void cartaTablero3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero3MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(yellow);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 2;
    }//GEN-LAST:event_cartaTablero3MouseClicked

    private void cartaTablero4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero4MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(yellow);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 3;
    }//GEN-LAST:event_cartaTablero4MouseClicked

    private void cartaTablero5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero5MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(yellow);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 4;
    }//GEN-LAST:event_cartaTablero5MouseClicked

    private void cartaTablero6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero6MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(yellow);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 5;
    }//GEN-LAST:event_cartaTablero6MouseClicked

    private void cartaTablero7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero7MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(yellow);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 6;
    }//GEN-LAST:event_cartaTablero7MouseClicked

    private void cartaTablero8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero8MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(yellow);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 7;
    }//GEN-LAST:event_cartaTablero8MouseClicked

    private void cartaTablero9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero9MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(none);
        this.cartaTablero9.setBorder(yellow);
        this.posicionTableroJugador = 8;
    }//GEN-LAST:event_cartaTablero9MouseClicked

    private void cartaTablero10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartaTablero10MouseClicked
        // TODO add your handling code here:
        Border yellow = BorderFactory.createLineBorder(Color.yellow,2);
        Border none = BorderFactory.createLineBorder(Color.RED,0);
        this.cartaTablero1.setBorder(none);
        this.cartaTablero2.setBorder(none);
        this.cartaTablero3.setBorder(none);
        this.cartaTablero4.setBorder(none);
        this.cartaTablero7.setBorder(none);
        this.cartaTablero8.setBorder(none);
        this.cartaTablero6.setBorder(none);
        this.cartaTablero5.setBorder(none);
        this.cartaTablero10.setBorder(yellow);
        this.cartaTablero9.setBorder(none);
        this.posicionTableroJugador = 9;
    }//GEN-LAST:event_cartaTablero10MouseClicked
                                         

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableroForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cartaManoJugador1;
    private javax.swing.JLabel cartaManoJugador2;
    private javax.swing.JLabel cartaManoJugador3;
    private javax.swing.JLabel cartaManoJugador4;
    private javax.swing.JLabel cartaManoJugador5;
    private javax.swing.JLabel cartaManoMaquina1;
    private javax.swing.JLabel cartaManoMaquina2;
    private javax.swing.JLabel cartaManoMaquina3;
    private javax.swing.JLabel cartaManoMaquina4;
    private javax.swing.JLabel cartaManoMaquina5;
    private javax.swing.JLabel cartaTablero1;
    private javax.swing.JLabel cartaTablero10;
    private javax.swing.JLabel cartaTablero2;
    private javax.swing.JLabel cartaTablero3;
    private javax.swing.JLabel cartaTablero4;
    private javax.swing.JLabel cartaTablero5;
    private javax.swing.JLabel cartaTablero6;
    private javax.swing.JLabel cartaTablero7;
    private javax.swing.JLabel cartaTablero8;
    private javax.swing.JLabel cartaTablero9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
