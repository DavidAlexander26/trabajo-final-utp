
import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.utils.Constantes;
import utp.edu.pe.validation.ValidationFile;
import utp.edu.pe.validation.ValidationFormat;
import utp.edu.pe.validation.ValidationInit;

import java.io.File;
import java.io.IOException;

public class Generador {
    public static void main(String[] args) throws IOException {
        String archivoDisponibilidad="C:\\Users\\ALEXIS\\Documents\\ProyectoUTP\\trabajo-final-utp\\src\\main\\resources\\disponibilidad.txt";
        //validacionFormato(entrada)
        ValidationFile.validacionFile(archivoDisponibilidad);
        //System.out.println(ValidationFormat.validacionFormato(entrada));
       /* String response = ValidationFormat.validacionFormato(entrada);
        if(response.equals(Constantes.RESPONSE_FORMATO_OK)){
            Disponibilidad responseService = ValidationInit.separacionCodNombreAndHorarios(entrada);
            System.out.println(responseService);
        }*/
        //PantallaPrincipal window = new PantallaPrincipal();
        //window.mostrar();
    }
}
