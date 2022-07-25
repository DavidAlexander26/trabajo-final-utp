package utp.edu.pe.reports;

import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.model.Generador;

public class ReportHtml {
    public static void outReport(Generador generador){
        Disponibilidad[] newDisponibilidad= generador.getDisponibilidadCorrecto();
        for (int n = 0; n < newDisponibilidad.length; n++) {
            
        }
    }
}
