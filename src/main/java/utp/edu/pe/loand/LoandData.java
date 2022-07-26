package utp.edu.pe.loand;

import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.utils.Constantes;
import utp.edu.pe.utils.Functions;
import utp.edu.pe.utils.TextUTP;
import utp.edu.pe.validation.ValidationFormat;
import utp.edu.pe.validation.ValidationInit;

import java.io.IOException;

public class LoandData {

    public static int[] cargarData(String path) {
        int[] response = {};
        try {
            //String[] lineas = TextUTP.readlinesAsArray(path);
            String[] lineas = TextUTP.readlinesAsArray(path, TextUTP.OS.WINDOWS);
            System.out.println();
            int nro_registros_total = lineas.length;
            int nro_registro_validos = 0;
            int nro_registro_invalidos = 0;
            for (int i = 0; i < lineas.length; i++) {
                System.out.println(lineas[i]);
                String responseService = ValidationFormat.validacionFormato(lineas[i]);

                if (responseService.equals(Constantes.RESPONSE_FORMATO_OK)) {
                    if (ValidationInit.separacionCodNombreAndHorarios(lineas[i]) != null) {
                        Functions.addSinFormatoDisponibilidad(lineas[i]);
                        nro_registro_validos++;
                    } else {
                        nro_registro_invalidos++;
                    }
                } else {
                    nro_registro_invalidos++;
                }
            }
            response = new int[]{nro_registros_total, nro_registro_validos, nro_registro_invalidos};

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
