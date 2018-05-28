package com.MVDV.PL2;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Marcos Vicente - Daniel Villalobos
 * @version 2.0.0
 */
public class datosJugadorClasificacion implements Serializable{

    private Jugador jugador;

    
    /**
     * Datp un ArrayList con el formato especifico, crea un objeto Gson que guardara en un archivo tipo Json
     * @param datosJson ArrayList con formato especifico
     */

    public void convertirDatosEnJson(ArrayList<ArrayList<ArrayList<String>>> datosJson) {
        String json = new Gson().toJson(datosJson);
        Gson gson = new Gson();
        try (Writer fileWriter = new FileWriter(fileWithDirectoryAssurance("datosJugadores", "jugadores"))) {
            fileWriter.write(json);
        } catch (java.io.IOException e) {
        }

        leerDatosDeJson();
    }

    /**
     * Metodo que abre el archivo json, lo convierte a objeto ArrayList con el formato especifico y lo devuelve para usarlo
     * @return Objeto con los datos del fichero Json
     */
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

    /**
     * Metodo que dado un directorio, crea la carpeta del directorio si no existe y devuelve la ruta relativa al fichero
     * @param directory Directorio al fichero
     * @param filename Nombre del fichero
     * @return Ruta relativa al fichero
     */
    private static String fileWithDirectoryAssurance(String directory, String filename) {
        File dir = new File(directory);
        if (!dir.exists()) dir.mkdirs();
        return (directory + "/" + filename + ".json");
    }
    
    /**
     * Metodo principal que comprueba si el usaurio esta registrado y carga sus datos o si debe ser registrado el usuario
     * @return Variable de control si es ususario es o no registrado
     */
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
        dibujarClasificacion();
        return devolucion;
    }
    
    /**
     * Metodo que pinta la clasificación
     */
    private void dibujarClasificacion(){
        ArrayList<ArrayList<ArrayList<String>>> archivoJSon = leerDatosDeJson();
        ArrayList<ArrayList<String>> arrayAuxiliar = new ArrayList<>();
        int posicionDelMayor = 0;
        int contador = 0;
        for (ArrayList<ArrayList<String>> arrayAuxiliarQueRecorreElJson : archivoJSon)
            arrayAuxiliar.add(arrayAuxiliarQueRecorreElJson.get(0));
        arrayAuxiliar.remove(0);
        while (arrayAuxiliar.size() != 0) {
            posicionDelMayor = getJugadorConMasPuntos(arrayAuxiliar);
            System.out.println("Puesto " + (contador + 1) + ") \tNombre: "+arrayAuxiliar.get(posicionDelMayor).get(1)
                    +" \t\t\tPuntos: "+arrayAuxiliar.get(posicionDelMayor).get(3)
                    +"\tPartidas Ganadas: "+ arrayAuxiliar.get(posicionDelMayor).get(6));
            arrayAuxiliar.remove(posicionDelMayor);
            contador += 1;
        }
    }
    
   /**
    * Metodo que guarda la clasificacion en un String para mostrarlo en la GUI
    * @return String con la clasificacion
    */
    public String dibujarClasificacionInterfaz(){
        ArrayList<ArrayList<ArrayList<String>>> archivoJSon = leerDatosDeJson();
        ArrayList<ArrayList<String>> arrayAuxiliar = new ArrayList<>();
        int posicionDelMayor = 0;
        String devolucion="";
        int contador = 0;
        for (ArrayList<ArrayList<String>> arrayAuxiliarQueRecorreElJson : archivoJSon)
            arrayAuxiliar.add(arrayAuxiliarQueRecorreElJson.get(0));
        arrayAuxiliar.remove(0);
        while (arrayAuxiliar.size() != 0) {
            posicionDelMayor = getJugadorConMasPuntos(arrayAuxiliar);
            devolucion = devolucion.concat("Puesto " + (contador + 1) + ") \tNombre: "+arrayAuxiliar.get(posicionDelMayor).get(1)
                    +" \t\t\t\tPuntos: "+arrayAuxiliar.get(posicionDelMayor).get(3)
                    +"\tPartidas Ganadas: "+ arrayAuxiliar.get(posicionDelMayor).get(6)+"\n\n");
            arrayAuxiliar.remove(posicionDelMayor);
            contador += 1;
        }
        return devolucion;
    }
    
    /**
     * Getter
     * Auxiliar de la clasificacion
     * @param arrayConDatosDeJugadores Array Con los datos de los jugadores
     * @return Posicion del array del jugador de mayor puntuacion
     */
    private int getJugadorConMasPuntos(ArrayList<ArrayList<String>> arrayConDatosDeJugadores){
        ArrayList<String> maximoTemporal = arrayConDatosDeJugadores.get(0);
        int tamaño = arrayConDatosDeJugadores.size();
        int posicionArray = 0;
        int contador = 0;
        while (contador < tamaño){
            if (Integer.valueOf(maximoTemporal.get(3)) < Integer.valueOf(arrayConDatosDeJugadores.get(contador).get(3))) {
                maximoTemporal = arrayConDatosDeJugadores.get(0);
                posicionArray = contador;
            }
            contador++;
        }
        return posicionArray;
    }

/**
 * Getter
 * @param nifInput Identificador
 * @return Devuelve los datos del jugador registrado para la GUI
 */
    public ArrayList <String> getDatosRegistradoInterface (String nifInput){
        ArrayList <String> datosJugador = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> archivoJSon = leerDatosDeJson();
        for (ArrayList<ArrayList<String>> arrayQueRecorreElPrimerArrayDelJSON : archivoJSon) {
            for (ArrayList<String> arrayQueRecorreLosArrayDelJSON : arrayQueRecorreElPrimerArrayDelJSON) {
                if (arrayQueRecorreLosArrayDelJSON.contains(nifInput)) {
                    datosJugador.add(arrayQueRecorreLosArrayDelJSON.get(0));
                    datosJugador.add(arrayQueRecorreLosArrayDelJSON.get(1));
                    datosJugador.add(arrayQueRecorreLosArrayDelJSON.get(2));
                    break;
                }
            }
        }
        return datosJugador;
    }

    /**
     * Dado un nif comprueba si esta o no registrado y obtiene sus datos
     * @param nifInput Identificador del jugador
     * @return Usuario registrado o no registrado
     */
    public boolean comprobarNIF(String nifInput) {
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
    
    /**
     * Metodo anterior aplicado a la GUI
     * @param nifInput Identificiacion de usuario
     * @return Datos del jugador
     */
    
    public String comprobarNIFInterfaz(String nifInput) {
        boolean devolucion = false;
        boolean maquinaTemp = false;
        String textoDevolucion = "";
        ArrayList<ArrayList<ArrayList<String>>> archivoJSon = leerDatosDeJson();
        for (ArrayList<ArrayList<String>> arrayQueRecorreElPrimerArrayDelJSON : archivoJSon) {
            for (ArrayList<String> arrayQueRecorreLosArrayDelJSON : arrayQueRecorreElPrimerArrayDelJSON) {
                if (arrayQueRecorreLosArrayDelJSON.contains(nifInput)) {
                    textoDevolucion = ("Usuario registrado, cargando datos\n\n\n\n");
                    textoDevolucion = textoDevolucion.concat("NIF: " + arrayQueRecorreLosArrayDelJSON.get(0) + "\t Nombre: "
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
        return textoDevolucion;
    }
    
   
    /**
     * Metodo auxiliar de la GUI que genera los datos de un usuario nuevo
     * @param nifInput Identificacion del usuario
     * @param nombreInput Nombre del jugador
     * @param edadInput Edad del jugador
     */
    public void registrarUsuarioInterface(String nifInput, String nombreInput, String edadInput){
        ArrayList <String> datosPartidas = new ArrayList<>();
        ArrayList <String> datosJugador = new ArrayList<>();
        ArrayList <ArrayList<String>> devolucion = new ArrayList<>();
        
        this.jugador = new Jugador(nombreInput, nifInput, Integer.valueOf(edadInput), false);
        datosJugador.add(nifInput);
        datosJugador.add(nombreInput);
        datosJugador.add(edadInput);
        datosJugador.add("0");
        datosJugador.add("No");
        datosJugador.add("0");
        datosJugador.add("0");
        datosJugador.add("0");
        devolucion.add(datosJugador);
        devolucion.add(datosPartidas);
        ArrayList<ArrayList<ArrayList<String>>> datosAntiguosAndJugadorRecienCreado = leerDatosDeJson();
        datosAntiguosAndJugadorRecienCreado.add(devolucion);
        convertirDatosEnJson(datosAntiguosAndJugadorRecienCreado);
    }
    
    

    /**
     * Metodo que genera los datos de un usuario nuevo
     * @param nifInput Identificacion del usuario
     * @param nombreInput Nombre del jugador
     * @param edadInput Edad del jugador
     * */
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
    
    /**
     * Getter
     * @param nifInput Identificador del usuario
     * @return Cantidad de puntos antes de comenzar la partida
     */

    public int getPuntosAnteDeComenzarPartida(String nifInput){
        ArrayList<ArrayList<ArrayList<String>>> archivoJSon = leerDatosDeJson();
        for (ArrayList<String> arrayQueRecorreLosArrayDelJSON : archivoJSon.get(0)) {
            if (arrayQueRecorreLosArrayDelJSON.contains(nifInput))
                return Integer.valueOf(arrayQueRecorreLosArrayDelJSON.get(3));
        }
        return 0;
    }


    /**
     * Metodo que actualiza los datos de un jugador
     * @param nifJugador Identificador de un jugador
     * @param nifMaquina Identificador de la maquina
     * @param cartasJugador Cartas ganadas por el jugador
     * @param cartasMaquina Cartas ganadas por la maquina
     * @param puntosPartidaJugador Puntos obtenidos por el jugador
     * @param puntosPartidaMaquina Puntos obtenidos por la maquina
     */
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

    /**
     * Getter
     * @return Jugador
     */
    public Jugador getJugador (){return this.jugador;}
}
