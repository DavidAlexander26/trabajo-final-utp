import utp.edu.pe.Prueba;
import utp.edu.pe.gui.Capturador;
import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.report.ReportHTML;
import utp.edu.pe.utils.Path;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Capturador window = new Capturador();
        // window.mostrar();
        String[] semana = {"ALL", "M", "T", "N", "X", "X", "M"};
        Disponibilidad item = new Disponibilidad();
        item.setCodigo("A19590");
        item.setNombre("FERNANDO DIAZ");
        item.setDisponibilidadSemanal(semana);

       // ReportHTML.generarReporte(item);

        // System.out.println(prueva.substring(prueva.length()-1));
        //String entrada =  "A19590:FERNANDO DIAZ:{LUN:ALL, MAR:M, MIE:T, JUE:X, VIE:ALL, SAB:X, DOM:X}";
        //String response = ValidationFormat.validacionFormato(entrada);
        //if(response.equals(Constantes.RESPONSE_FORMATO_OK)){
        //   Disponibilidad responseService = ValidationInit.separacionCodNombreAndHorarios(entrada);
        //  System.out.println(responseService);
        //}
    }

    public static void generarHTML(Disponibilidad item) {

    }
}
