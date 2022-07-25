package utp.edu.pe.validation;

import utp.edu.pe.utils.Functions;

import java.io.IOException;

public class ValidatioName {
    /**
     * Se valida, que el nombre tenga un maximo de 50 caracteres
     * @param input -> recibe el nombre a validar
     * @return boolean -> retorna TRUE  o FALSE
     */
    public static boolean validacionLongitud(String input){
        boolean response = false;
        if(!input.isBlank()){
            if(input.length()<51){
                response =true;
            }
            else {
                Functions.addFormatoError("ERROR Longitud del nombre");
            }
        }
        return response;
    }
}
