package utp.edu.pe.reports;

import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.model.Generador;

public class ReportHtml {
    public static void outReport(Generador generador){

        Disponibilidad[] newDisponibilidad= generador.getDisponibilidadCorrecto();
        for (int n = 0; n < newDisponibilidad.length; n++) {

            if(n==0){
                FormatReportHTML.generarReporte(newDisponibilidad[n]," ",newDisponibilidad[n+1].getCodigo());

            } else if (n+1==newDisponibilidad.length) {
                FormatReportHTML.generarReporte(newDisponibilidad[n],newDisponibilidad[n-1].getCodigo()," ");

            } else {
                FormatReportHTML.generarReporte(newDisponibilidad[n],newDisponibilidad[n-1].getCodigo(),newDisponibilidad[n+1].getCodigo());
            }
        }
    }
}
