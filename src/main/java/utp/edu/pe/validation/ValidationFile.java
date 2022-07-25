package utp.edu.pe.validation;

import utp.edu.pe.calculos.Calculos;
import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.model.Generador;
import utp.edu.pe.reports.ReportAsci;
import utp.edu.pe.reports.ReportAsciiPlot;
import utp.edu.pe.reports.ReportHtml;
import utp.edu.pe.utils.ArrayPush;
import utp.edu.pe.utils.Constantes;
import utp.edu.pe.utils.TextUTP;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ValidationFile {

    public static void validacionFile(String archivoDisponibilidad, String tipoReport) throws IOException {
        String response="";
        Disponibilidad responseService;
        int counterTotal=0;
        int counterErrors=0;
        Disponibilidad[] disponibilidadCorrecta= new Disponibilidad[]{};
        String[] content = TextUTP.readlinesAsArray(archivoDisponibilidad, TextUTP.OS.WINDOWS
        );
        if(content.length>0){
            for (int i = 0; i <content.length; i++) {
                counterTotal+=1;
                response = ValidationFormat.validacionFormato(content[i]);
                if(response.equals(Constantes.RESPONSE_FORMATO_OK)){
                    responseService = ValidationInit.separacionCodNombreAndHorarios(content[i]);
                    if(responseService != null){
                        disponibilidadCorrecta = ArrayPush.push(disponibilidadCorrecta,responseService);
                    }
                    else{
                        counterErrors+=1;
                    }
                }
                else{
                    counterErrors+=1;
                }
            }
            Generador variables= new Generador(disponibilidadCorrecta,counterErrors,counterTotal);
            ///ReportAsci.outReport(variables);
            switch (tipoReport){
                case "ASCI":
                    ReportAsci.outReport(variables);
                    break;
                case "ASCIPLOT":
                    ReportAsciiPlot.outReport(variables);
                    break;
                case "HTML":
                    ReportHtml.outReport(variables);
                    break;
                default:
                    throw new IOException("Este tipo de reporte no existe");
            }

            //ReportAsciiPlot.outReport(variables);
            //variables.getDisponibilidadCorrecto();
            //Calculos.porcentajes(variables);
        }
        else{
            throw new IOException("El contenido del archivo es vacio..");
        }
    }
}
