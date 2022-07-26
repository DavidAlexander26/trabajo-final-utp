package utp.edu.pe.reports;

import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.model.Generador;
import utp.edu.pe.report.ReportHTML;

public class ReportHtml {
    public static void outReport(Generador generador){

        Disponibilidad[] newDisponibilidad= generador.getDisponibilidadCorrecto();
        for (int n = 0; n < newDisponibilidad.length; n++) {

            if(n==0){
                ReportHTML.generarReporte(newDisponibilidad[n]," ",newDisponibilidad[n+1].getCodigo());

            } else if (n+1==newDisponibilidad.length) {
                ReportHTML.generarReporte(newDisponibilidad[n],newDisponibilidad[n-1].getCodigo()," ");

            } else {
                ReportHTML.generarReporte(newDisponibilidad[n],newDisponibilidad[n-1].getCodigo(),newDisponibilidad[n+1].getCodigo());
            }
        }
    }
}
