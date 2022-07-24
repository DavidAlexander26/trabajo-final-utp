package utp.edu.pe.validation;

import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.utils.Functions;

public class ValidationInit {

    public static Disponibilidad separacionCodNombreAndHorarios(String input){

        String[] items = input.split("\\{");
        Disponibilidad disponibilidad = new Disponibilidad();
        String [] responseService = null;
        boolean response = true;
        if(items.length==2){
            String codigoNombre = items[0].substring(0, items[0].length()-1).trim();
            String horarios = items[1].substring(0, items[1].length()-1).trim();

            String[] arrayCodigoNombre = codigoNombre.split(":");
            String[] arrayHorarios = horarios.split(",");
            if(arrayCodigoNombre.length==2){
                if(!ValidationCode.validationCode(arrayCodigoNombre[0])){
                    response = false;
                }
                if(!ValidatioName.validacionLongitud(arrayCodigoNombre[1])){
                    response = false;
                }
            }
            else{
                response = false;
                Functions.addFormatoError("FALTA EL CODIGO O NOMBRE");
            }

            if(arrayHorarios.length==7){
                responseService = ValidationWeek.validation(arrayHorarios);
                if(responseService ==null){
                    response = false;
                }
            }
            else{
                response = false;
                Functions.addFormatoError("FALTA UN/UNOS DIAS DE LA SEMANA EN EL FORMATO");
            }

            if(response){
                disponibilidad.setCodigo(arrayCodigoNombre[0]);
                disponibilidad.setNombre(arrayCodigoNombre[1]);
                disponibilidad.setDisponibilidadSemanal(responseService);
            }
            else {
                disponibilidad  = null;
            }
        }
        else {
            Functions.addFormatoError("ERROR EN LA SEPARACION DE CODIGO + NOMBRE Y HORARIO");
        }
        return disponibilidad;
    }

}
