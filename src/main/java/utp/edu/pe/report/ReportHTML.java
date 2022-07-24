package utp.edu.pe.report;

import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.utils.Constantes;
import utp.edu.pe.utils.Functions;
import utp.edu.pe.utils.Path;

public class ReportHTML {
    public static void generarReporte(Disponibilidad disponibilidad,String anterior, String siguiente){

        String anteriorHTML = "";
        String siguienteHTML = "";
        if(!anterior.isBlank()){
            anteriorHTML = "<a href=\"".concat(Path.getPathReport()).concat("\\").concat(anterior)
                    .concat(".html").concat("\">ATRAS</a> &nbsp  &nbsp");
        }
        if(!siguiente.isBlank()){
            siguienteHTML = "<a href=\"".concat(Path.getPathReport()).concat("\\").concat(siguiente)
                    .concat(".html").concat("\">SIGUIENTE</a>");
        }
        String tituloHTML = "Reporte -".concat(disponibilidad.getCodigo());
        String codigoHTML = "CODIGO: ".concat(disponibilidad.getCodigo());
        String nombreHTML = "DOCENTE: ".concat(disponibilidad.getNombre());

        String [] responseLunes = pintarCeldas(disponibilidad.getDisponibilidadSemanal()[0]);
        String lunesMañanaHTML = responseLunes[0];
        String lunesTardeHTML  = responseLunes[1];
        String lunesNocheHTML  = responseLunes[2];

        String [] responseMartes = pintarCeldas(disponibilidad.getDisponibilidadSemanal()[1]);
        String martesMañanaHTML = responseMartes[0];
        String martesTardeHTML  = responseMartes[1];
        String martesNocheHTML  = responseMartes[2];

        String [] responseMiercoles = pintarCeldas(disponibilidad.getDisponibilidadSemanal()[2]);
        String miercolesMañanaHTML = responseMiercoles[0];
        String miercolesTardeHTML  = responseMiercoles[1];
        String miercolesNocheHTML  = responseMiercoles[2];

        String [] responseJueves = pintarCeldas(disponibilidad.getDisponibilidadSemanal()[3]);
        String juevesMañanaHTML = responseJueves[0];
        String juevesTardeHTML  = responseJueves[1];
        String juevesNocheHTML  = responseJueves[2];

        String [] responseViernes = pintarCeldas(disponibilidad.getDisponibilidadSemanal()[4]);
        String viernesMañanaHTML = responseViernes[0];
        String viernesTardeHTML  = responseViernes[1];
        String viernesNocheHTML  = responseViernes[2];

        String [] responseSabado = pintarCeldas(disponibilidad.getDisponibilidadSemanal()[5]);
        String sabadoMañanaHTML = responseSabado[0];
        String sabadoTardeHTML  = responseSabado[1];
        String sabadoNocheHTML  = responseSabado[2];

        String domingoMañanaHTML = pintarCeldaDomingo(disponibilidad.getDisponibilidadSemanal()[6]);

        String responseFormato = formatoHTML(tituloHTML,codigoHTML,nombreHTML,lunesMañanaHTML,
                martesMañanaHTML,miercolesMañanaHTML,juevesMañanaHTML,viernesMañanaHTML,sabadoMañanaHTML,domingoMañanaHTML,
                lunesTardeHTML,martesTardeHTML,miercolesTardeHTML,juevesTardeHTML,viernesTardeHTML,sabadoTardeHTML,
                lunesNocheHTML,martesNocheHTML,miercolesNocheHTML,juevesNocheHTML,viernesNocheHTML,sabadoNocheHTML,
                anteriorHTML,siguienteHTML);

        Functions.generarHTMLCodigo(disponibilidad.getCodigo(),responseFormato);
    }
    private static String[] pintarCeldas(String item){
        String[] response = null;
        if(item.equals(Constantes.ALL)){
            response = new String[]{Constantes.PINTAR_CELDA, Constantes.PINTAR_CELDA, Constantes.PINTAR_CELDA};
        }
        if(item.equals(Constantes.M)){
            response = new String[]{Constantes.PINTAR_CELDA, Constantes.NO_PINTAR_CELDA, Constantes.NO_PINTAR_CELDA};
        }
        if(item.equals(Constantes.T)){
            response = new String[]{Constantes.NO_PINTAR_CELDA, Constantes.PINTAR_CELDA, Constantes.NO_PINTAR_CELDA};
        }
        if(item.equals(Constantes.N)){
            response = new String[]{Constantes.NO_PINTAR_CELDA, Constantes.NO_PINTAR_CELDA, Constantes.PINTAR_CELDA};
        }
        if(item.equals(Constantes.X)){
            response = new String[]{Constantes.NO_PINTAR_CELDA, Constantes.NO_PINTAR_CELDA, Constantes.NO_PINTAR_CELDA};
        }
        return response;
    }
    private static String pintarCeldaDomingo(String item){
        String response = "";
        if(item.equals(Constantes.M)){
            response = Constantes.PINTAR_CELDA;
        }
        if(item.equals(Constantes.X)){
            response = Constantes.NO_PINTAR_CELDA;
        }
        return response;
    }
    private static String formatoHTML(String tituloHTML,String codigoHTML,String docenteHTML
    ,String lunM,String marM, String mieM,String jueM,String vieM,String sabM, String domM
            ,String lunT,String marT, String mieT,String jueT,String vieT,String sabT
            ,String lunN,String marN, String mieN,String jueN,String vieN,String sabN,
                                      String anterior, String siguiente){
        String formato = String.format(
                "<!DOCTYPE HTML >\n" +
                        "<html>\n" +
                        "\n" +
                        "<head>\n" +
                        "    <title>"+tituloHTML+
                "</title>\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "\n" +
                        "        <h2 align=\"center\" style=\"margin: 0px;\">Disponibilidad Presencial 2022</h2>\n" +
                        "        <h4 align=\"center\" style=\"margin: 5px;\">"+codigoHTML+
                "</h4>\n" +
                        "        <h4 align=\"center\" style=\"margin: 10px;\">"+docenteHTML+
                "</h4>\n" +
                        "\n" +
                        "    <table align=\"center\" bordercolor=\"purple\" cellpadding=\"3\" cellspacing=\"3\" border=\"1\">\n" +
                        "        <tr>\n" +
                        "            <th>Hora</th>\n" +
                        "            <th>LUNES</th>\n" +
                        "            <th>MARTES</th>\n" +
                        "            <th>MIERCOLES</th>\n" +
                        "            <th>JUEVES</th>\n" +
                        "            <th>VIERNES</th>\n" +
                        "            <th>SABADO</th>\n" +
                        "            <th>DOMINGO</th>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>08:00-08:45</td>\n" +
                        "            <td rowspan=\"8\" "+lunM+
                "></td>\n" +
                        "            <td rowspan=\"8\""+marM+
                "></td>\n" +
                        "            <td rowspan=\"8\""+mieM+
                "></td>\n" +
                        "            <td rowspan=\"8\""+jueM+
                "></td>\n" +
                        "            <td rowspan=\"8\""+vieM+
                "></td>\n" +
                        "            <td rowspan=\"8\""+sabM+
                "></td>\n" +
                        "            <td rowspan=\"8\""+domM+
                "></td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>08:45-09:30</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>09:30-09:45</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>09:45-10:30</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>10:30-11:15</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>11:15-11:30</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>11:30-12:15</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>12:15-01:00</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <th bgcolor=\"gray\"></th>\n" +
                        "            <th bgcolor=\"gray\"></th>\n" +
                        "            <th bgcolor=\"gray\"></th>\n" +
                        "            <th bgcolor=\"gray\"></th>\n" +
                        "            <th bgcolor=\"gray\"></th>\n" +
                        "            <th bgcolor=\"gray\"></th>\n" +
                        "            <th bgcolor=\"gray\"></th>\n" +
                        "            <th bgcolor=\"gray\"></th>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>02:00-02:45</td>\n" +
                        "            <td rowspan=\"8\""+lunT+
                "></td>\n" +
                        "            <td rowspan=\"8\""+marT+
                "></td>\n" +
                        "            <td rowspan=\"8\""+mieT+
                "></td>\n" +
                        "            <td rowspan=\"8\""+jueT+
                "></td>\n" +
                        "            <td rowspan=\"8\""+vieT+
                "></td>\n" +
                        "            <td rowspan=\"8\""+sabT+
                "></td>\n" +
                        "            <td rowspan=\"8\" bgcolor=\"gray\"></td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>02:45-03:30</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>03:30-03:45</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>03:45-04:30</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>04:30-05:15</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>05:15-05:30</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>05:30-06:15</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>06:15-07:00</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>07:00-07:15</td>\n" +
                        "            <td rowspan=\"6\""+lunN+
                "></td>\n" +
                        "            <td rowspan=\"6\""+marN+
                "></td>\n" +
                        "            <td rowspan=\"6\""+mieN+
                "></td>\n" +
                        "            <td rowspan=\"6\""+jueN+
                "></td>\n" +
                        "            <td rowspan=\"6\""+vieN+
                "></td>\n" +
                        "            <td rowspan=\"6\""+sabN+
                "></td>\n" +
                        "            <td rowspan=\"6\" bgcolor=\"gray\"></td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>07:15-08:00</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>08:00-08:45</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>08:45-09:00</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>09:00-09:45</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td>09:45-10:30</td>\n" +
                        "        </tr>\n" +
                        "    </table>\n" +
                        "    <br>\n" +
                        "    <br>\n" +
                        "    <div  align=\"center\">\n" +anterior+siguiente+
                        "</div>    \n" +
                        "</body>\n" +
                        "\n" +
                        "</html>"

        );

        return formato;
    }
}
