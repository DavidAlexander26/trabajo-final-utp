package utp.edu.pe.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Functions {
    public static void addFormatoError(String error) {
        try {
            LocalDate fecha = LocalDate.now();
            StringBuilder formato = new StringBuilder();
            formato.append(fecha.getYear()).append("-")
                    .append(fecha.getMonthValue()).append("-")
                    .append(fecha.getDayOfMonth()).append(" ");
            LocalTime hora = LocalTime.now();
            formato.append(hora.getHour()).append(":")
                    .append(hora.getMinute()).append(":")
                    .append(hora.getSecond()).append(" - ");
            formato.append("ERROR: ").append(error);

            String[] data = {String.valueOf(formato)};
            TextUTP.append(data, Path.getPathError(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addFormatoDisponibilidad(String code, String name, String[] semana) {
        try {
            String formato = code.concat(":")
                    .concat(name).concat(":{")
                    .concat(Constantes.LUNES).concat(":")
                    .concat(semana[0]).concat(",")
                    .concat(Constantes.MARTES).concat(":")
                    .concat(semana[1]).concat(",")
                    .concat(Constantes.MIERCOLES).concat(":")
                    .concat(semana[2]).concat(",")
                    .concat(Constantes.JUEVES).concat(":")
                    .concat(semana[3]).concat(",")
                    .concat(Constantes.VIERNES).concat(":")
                    .concat(semana[4]).concat(",")
                    .concat(Constantes.SABADO).concat(":")
                    .concat(semana[5]).concat(",")
                    .concat(Constantes.DOMINGO).concat(":")
                    .concat(semana[6]).concat("}");

            String[] data = {formato};
            TextUTP.append(data, Path.getPathArchivoDisponibilidad(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addSinFormatoDisponibilidad(String input) {
        try {
            String[] data = {input};
            TextUTP.append(data, Path.getPathArchivoDisponibilidad(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarHTMLCodigo(String code, String content) {
        String path = "D:\\Proyectos\\trabajo-final-utp\\src\\main\\resources\\reports\\";
        TextUTP.generarFileHTML(path, code, content);
    }
}
