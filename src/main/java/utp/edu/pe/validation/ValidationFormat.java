package utp.edu.pe.validation;

import utp.edu.pe.utils.Constantes;
import utp.edu.pe.utils.Functions;

import java.io.IOException;

public class ValidationFormat {
    public static String validacionFormato(String input) throws IOException {
        String response = Constantes.RESPONSE_FORMATO_ERROR;
        int cantDosPuntos = 0;
        int cantComa = 0;
        int indiceAbreLlave = -1;
        int indiceCierraLlave = -1;
        String indicesComas = "";
        String indicesDosPuntos = "";

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)==':'){
                cantDosPuntos++;
                indicesDosPuntos += i + ";";
            }
            if(input.charAt(i)==','){
                cantComa++;
                indicesComas += i + ";";
            }
            if(input.charAt(i)=='{'){
                indiceAbreLlave=i;
            }
            if(input.charAt(i)=='}') {
                indiceCierraLlave = i;
            }
        }

        int [] indicesComasInt = convetirArrayStringToInt(indicesComas.split(";"));
        int [] indicesDosPuntosInt = convetirArrayStringToInt(indicesDosPuntos.split(";"));

        if(validacionCantDosPuntos(cantDosPuntos) &&
                validacionCantComa(cantComa) &&
                validacionLlaves(indiceAbreLlave,indiceCierraLlave)
        ){
            if(validacionPosicionLlaveComa(indiceAbreLlave,indiceCierraLlave,indicesComasInt) &&
                    validacionLlaveDosPuntos(indiceAbreLlave,indicesDosPuntosInt) &&
                    validacionLlaveAlFinal(indiceCierraLlave,input.length())
            ){
                response = Constantes.RESPONSE_FORMATO_OK;
            }
        }
        else {
            Functions.addFormatoError(Constantes.RESPONSE_FORMATO_ERROR);
        }

        return response;
    }
    private static int [] convetirArrayStringToInt (String[] items ){
        int [] indicesComasInt = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            indicesComasInt[i]= Integer.parseInt(items[i]);
        }
        return indicesComasInt;
    }
    private static boolean validacionCantDosPuntos(int cantDosPuntos){
        return cantDosPuntos == Constantes.CANTIDAD_CORRECTA_DOS_PUNTOS;
    }
    private static boolean validacionCantComa(int cantComa){
        return cantComa == Constantes.CANTIDAD_CORRECTA_COMA;
    }
    private static boolean validacionLlaves(int indiceAbreLlave,int indiceCierraLlave){
        return indiceCierraLlave > indiceAbreLlave;
    }
    private static boolean validacionPosicionLlaveComa(int indiceAbreLlave,int indiceCierraLlave,int [] comas){
        return comas[0] > indiceAbreLlave && comas[comas.length-1] < indiceCierraLlave;
    }
    private static boolean validacionLlaveAlFinal(int indiceCierraLlave, int longitudCadena){
        return indiceCierraLlave+1 == longitudCadena;
    }
    private static boolean validacionLlaveDosPuntos (int indiceAbreLlave, int [] dosPuntos){
        return indiceAbreLlave-1 == dosPuntos[1];
    }
}
