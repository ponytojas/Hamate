package com.MVDV.PL2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version 1.0.0
 */
public class datosJugadorClasificacion {

    private Jugador jugador;


    public void convertirDatosEnJson(ArrayList<ArrayList<ArrayList<String>>> datosJson) {
        String json = new Gson().toJson(datosJson);
        Gson gson = new Gson();
        try (Writer fileWriter = new FileWriter(fileWithDirectoryAssurance("datosJugadores", "jugadores"))) {
            fileWriter.write(json);
        } catch (java.io.IOException e) {
        }

        leerDatosDeJson();
    }

    public ArrayList<ArrayList<ArrayList<String>>> leerDatosDeJson() {
        ArrayList<ArrayList<ArrayList<String>>>  none = new ArrayList<ArrayList<ArrayList<String>>> ();
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(fileWithDirectoryAssurance("datosJugadores", "jugadores")));
            ArrayList<ArrayList<ArrayList<String>>>  arrayArchivoJson;
            arrayArchivoJson = gson.fromJson(br, ArrayList.class);
            return arrayArchivoJson;
        } catch (java.io.IOException e) {
        }
        return none;
    }

    private static String fileWithDirectoryAssurance(String directory, String filename) {
        File dir = new File(directory);
        if (!dir.exists()) dir.mkdirs();
        return (directory + "/" + filename + ".json");
    }

    protected void mostrarClasificacion() {

    }

    public boolean comenzarPartida() {
        Scanner entrada = new Scanner(System.in);
        boolean devolucion = false;
        try {
            System.out.println("Introduce tu nif: ");
            String nif = entrada.nextLine();
            if (nif.equals(""))
                throw new JugadorException(JugadorException.NIF_INCORRECTO);
            devolucion = !devolucion;
            boolean registrado = comprobarNIF(nif);
            if (!registrado) {
                ArrayList<ArrayList<ArrayList<String>>> datosAntiguosAndJugadorRecienCreado = leerDatosDeJson();
                datosAntiguosAndJugadorRecienCreado.add(registrarUsuario(nif));
                convertirDatosEnJson(datosAntiguosAndJugadorRecienCreado);
            }

        } catch (JugadorException msg) {
            System.out.println(msg);
            return devolucion;
        }
        return devolucion;
    }


    private boolean comprobarNIF(String nifInput) {
        boolean devolucion = false;
        boolean maquinaTemp = false;
        ArrayList<ArrayList<ArrayList<String>>> archivoJSon = leerDatosDeJson();
        for (ArrayList<ArrayList<String>> arrayQueRecorreElPrimerArrayDelJSON : archivoJSon) {
            for (ArrayList<String> arrayQueRecorreLosArrayDelJSON : arrayQueRecorreElPrimerArrayDelJSON) {
                if (arrayQueRecorreLosArrayDelJSON.contains(nifInput)) {
                    System.out.println("Usuario registrado, cargando datos");
                    System.out.println("NIF: " + arrayQueRecorreLosArrayDelJSON.get(0) + "\t Nombre: "
                            + arrayQueRecorreLosArrayDelJSON.get(1) + "\tEdad: " + arrayQueRecorreLosArrayDelJSON.get(2) + "" +
                            "\t Puntos: " + arrayQueRecorreLosArrayDelJSON.get(3) + "\t Partidas Jugadas: " + arrayQueRecorreLosArrayDelJSON.get(5)
                            + "\t Partidas Ganadas: " + arrayQueRecorreLosArrayDelJSON.get(6));
                    devolucion = true;
                    if (arrayQueRecorreLosArrayDelJSON.get(4).equals("Si"))
                        maquinaTemp = !maquinaTemp;
                    this.jugador = new Jugador(arrayQueRecorreLosArrayDelJSON.get(1), arrayQueRecorreLosArrayDelJSON.get(0),
                            Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(2)), maquinaTemp);
                    break;
                }
            }
        }
        return devolucion;
    }


    private ArrayList<ArrayList<String>> registrarUsuario(String nifInput) {
        Scanner entrada = new Scanner(System.in);
        ArrayList <String> datosPartidas = new ArrayList<>();
        ArrayList <String> datosJugador = new ArrayList<>();
        ArrayList <ArrayList<String>> devolucion = new ArrayList<>();

        System.out.println("Introduce un nombre: ");
        String nombreTemp = entrada.nextLine();
        try {
            if (nombreTemp.equals(""))
                throw new JugadorException(JugadorException.NOMBRE_INCORRECTO);
        } catch (JugadorException msg) {
            registrarUsuario(nifInput);
        }
        int edadTemporal = 0;
        try {
            System.out.println("Introduce edad (en numero): ");
            edadTemporal = entrada.nextInt();
            if (edadTemporal < 18)
                throw new JugadorException(JugadorException.EDAD_INCORRECTA);
        } catch (JugadorException msg) {
            System.out.println("Edad fuera de rango");
            System.exit(0);
        }
        this.jugador = new Jugador(nombreTemp, nifInput, edadTemporal, false);
        datosJugador.add(nifInput);
        datosJugador.add(nombreTemp);
        datosJugador.add(String.valueOf(edadTemporal));
        datosJugador.add("0");
        datosJugador.add("No");
        datosJugador.add("0");
        datosJugador.add("0");
        datosJugador.add("0");
        devolucion.add(datosJugador);
        devolucion.add(datosPartidas);
        return devolucion;
    }

    public int getPuntosAnteDeComenzarPartida(String nifInput){
        ArrayList<ArrayList<ArrayList<String>>> archivoJSon = leerDatosDeJson();
        for (ArrayList<String> arrayQueRecorreLosArrayDelJSON : archivoJSon.get(0)) {
            if (arrayQueRecorreLosArrayDelJSON.contains(nifInput))
                return Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(3));
        }
        return 0;
    }



    public void actualizarDatosPartida(String nifJugador, String nifMaquina, int cartasJugador, int cartasMaquina, int puntosPartidaJugador, int puntosPartidaMaquina) {
        boolean ganaJugador = (puntosPartidaJugador > puntosPartidaMaquina);

        ArrayList<ArrayList<ArrayList<String>>> archivoJSon = leerDatosDeJson();
        for (ArrayList<ArrayList<String>> arrayQueRecorreLosArrayDelJSON : archivoJSon)
            if (arrayQueRecorreLosArrayDelJSON.get(0).contains(nifJugador)) {
                int puntosTemp = Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(0).get(3));
                puntosTemp += puntosPartidaJugador;
                arrayQueRecorreLosArrayDelJSON.get(0).set(3, String.valueOf(puntosTemp));
                int partidasTemp = Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(0).get(5));
                partidasTemp += 1;
                arrayQueRecorreLosArrayDelJSON.get(0).set(5, String.valueOf(partidasTemp));
                int partidasGanadasTemp = Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(0).get(6));
                partidasGanadasTemp += 1;
                if (ganaJugador)
                    arrayQueRecorreLosArrayDelJSON.get(0).set(6, String.valueOf(partidasGanadasTemp));
                int cartasGanadasTemp = Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(0).get(7));
                cartasGanadasTemp += cartasJugador;
                arrayQueRecorreLosArrayDelJSON.get(0).set(7, String.valueOf(cartasGanadasTemp));
                arrayQueRecorreLosArrayDelJSON.get(1).add(String.valueOf(cartasJugador));
            }

        for (ArrayList<ArrayList<String>> arrayQueRecorreLosArrayDelJSON : archivoJSon)
            if (arrayQueRecorreLosArrayDelJSON.get(0).contains(nifMaquina)) {
                int puntosTemp = Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(0).get(3));
                puntosTemp += puntosPartidaMaquina;
                arrayQueRecorreLosArrayDelJSON.get(0).set(3, String.valueOf(puntosTemp));
                int partidasTemp = Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(0).get(5));
                partidasTemp += 1;
                arrayQueRecorreLosArrayDelJSON.get(0).set(5, String.valueOf(partidasTemp));
                int partidasGanadasTemp = Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(0).get(6));
                partidasGanadasTemp += 1;
                if (!ganaJugador)
                    arrayQueRecorreLosArrayDelJSON.get(0).set(6, String.valueOf(partidasGanadasTemp));
                int cartasGanadasTemp = Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(0).get(7));
                cartasGanadasTemp += cartasMaquina;
                arrayQueRecorreLosArrayDelJSON.get(0).set(7, String.valueOf(cartasGanadasTemp));
                arrayQueRecorreLosArrayDelJSON.get(1).add(String.valueOf(cartasMaquina));
                convertirDatosEnJson(archivoJSon);
            }
    }

    public Jugador getJugador (){return this.jugador;}
}
