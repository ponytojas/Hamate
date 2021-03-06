package com.MVDV.PL2;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version 2.0.0
 */
public class JugadorException extends Exception {
    public static final String NIF_INCORRECTO = "El NIF proporcionado es incorrecto.";
    public static final String EDAD_INCORRECTA = "El jugador debe ser mayor de edad para poder jugar";
    public static final String CARTA_NO_SELECCIONADA = "No se ha seleccionado ninguna carta para jugar.";
    public static final String RETO_INCORRECTO = "No se ha seleccionado la direccion del reto";
    public static final String NOMBRE_INCORRECTO = "Nombre incorrecto";
    public JugadorException() {
        super("Se ha producido una excepcion en la aplicacion.");
    }
    public JugadorException(String txt) {
        super(txt);
    }
}
