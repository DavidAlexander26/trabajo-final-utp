import utp.edu.pe.gui.PantallaPrincipal;
import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.utils.Constantes;
import utp.edu.pe.utils.TextUTP;
import utp.edu.pe.validation.ValidationFormat;
import utp.edu.pe.validation.ValidationInit;

import java.io.IOException;

public class Main
{
    //public static void main(String[] args) {
      //  PantallaPrincipal window = new PantallaPrincipal();
        //window.mostrar();

        public static void main(String[] args) throws IOException {
            String entrada = "A19590:FERNANDO DIAZ:{LUN:ALL, MAR:M, MIE:T, JUE:X, VIE:ALL, SAB:X, DOM:X}";
            //validacionFormato(entrada);
            //System.out.println(ValidationFormat.validacionFormato(entrada));
            String response = ValidationFormat.validacionFormato(entrada);
            if(response.equals(Constantes.RESPONSE_FORMATO_OK)){
                Disponibilidad responseService = ValidationInit.separacionCodNombreAndHorarios(entrada);
                System.out.println(responseService);
            }
        }
   // }
}
