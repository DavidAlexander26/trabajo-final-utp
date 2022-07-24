package utp.edu.pe.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Functions {
    public static void addFormatoError(String error) throws IOException {
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

        String[] data = { String.valueOf(formato)};
        TextUTP.append(data,"C:\\Users\\ALEXIS\\Documents\\ProyectoUTP\\trabajo-final-utp\\src\\main\\resources\\error.log",true);
    }
}
