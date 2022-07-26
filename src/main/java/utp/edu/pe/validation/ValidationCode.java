package utp.edu.pe.validation;

import utp.edu.pe.utils.Constantes;
import utp.edu.pe.utils.Functions;

import java.io.IOException;

public class ValidationCode {
    public static boolean validationCode(String code){
        boolean response = false;
        if(validacionTamanoCodigo(code.length())){
            if(validacionCodigo(code)){
                response = true;
            }
            else {
                Functions.addFormatoError("ERROR FORMATO CODIGO");
            }
        }else {
            Functions.addFormatoError("ERROR TAMAÑO CODIGO");
        }
        return  response;
    }
    private static boolean validacionTamanoCodigo(int tamano) {
        return tamano == 6;
    }
    private static boolean validacionCodigo(String code ){
        boolean response = true;
        if(validacionLetra(String.valueOf(code.charAt(0)))){
            for (int i = 1; i < code.length(); i++) {
                if(!validacionNumero(String.valueOf(code.charAt(i)))){
                    response = false;
                    break;
                }
            }
        }
        else {
            response = false;
        }
        return response;
    }
    public static boolean validacionLetra( String letra){
        return letra.equals(Constantes.CODIGO);
    }
    public static boolean validacionNumero( String number){
        boolean response = false;
        String[] numberList = {"1","2","3","4","5","6","7","8","9","0"};
        for (int i = 0; i < numberList.length; i++) {
            if(number.equals(numberList[i])){
                response = true;
                break;
            }
        }
        return response;
    }
}
