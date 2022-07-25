package utp.edu.pe.reports;

import utp.edu.pe.calculos.Calculos;
import utp.edu.pe.model.Generador;

import java.io.IOException;

public class ReportAsci {
    public static void outReport(Generador generador) throws IOException {
        System.out.println("-----------------------------------");
        System.out.println("---- REPORTE DE DISPONIBILIDAD DE HORARIOS ----");
        System.out.printf("     Cantidad de registros cargados:  %s%n", generador.getNumTotal());
        System.out.printf("     Cantidad de registros con errores:  %s%n", generador.getNumErrors());
        System.out.println("---- HORAS DISPONIBLES POR CADA DIA ----");
        System.out.printf("     LUNES:  %s%n", Calculos.totalHorasDisponiblePorDia(generador).getTotalHorasDiarias()[0]);
        System.out.printf("     MARTES:  %s%n", Calculos.totalHorasDisponiblePorDia(generador).getTotalHorasDiarias()[1]);
        System.out.printf("     MIERCOLES:  %s%n", Calculos.totalHorasDisponiblePorDia(generador).getTotalHorasDiarias()[2]);
        System.out.printf("     JUEVES:  %s%n", Calculos.totalHorasDisponiblePorDia(generador).getTotalHorasDiarias()[3]);
        System.out.printf("     VIERNES:  %s%n", Calculos.totalHorasDisponiblePorDia(generador).getTotalHorasDiarias()[4]);
        System.out.printf("     SABADO:  %s%n", Calculos.totalHorasDisponiblePorDia(generador).getTotalHorasDiarias()[5]);
        System.out.printf("     DOMINGO:  %s%n", Calculos.totalHorasDisponiblePorDia(generador).getTotalHorasDiarias()[6]);
        System.out.println("---- HORAS DISPONIBLES POR CADA BLOQUE ----");
        System.out.printf("     MAÑANA:  %s%n", Calculos.totalHorasDisponiblePorBloque(generador).getTotalHorasPorBloque()[0]);
        System.out.printf("     TARDE:  %s%n", Calculos.totalHorasDisponiblePorBloque(generador).getTotalHorasPorBloque()[1]);
        System.out.printf("     NOCHE:  %s%n", Calculos.totalHorasDisponiblePorBloque(generador).getTotalHorasPorBloque()[2]);
        System.out.println("-----------------------------------");
        System.out.printf("     DISPONIBILIDAD GENERAL:  %s%n", Calculos.totalHorasDisponible(generador).getHorasTotalesDisponibles());
        System.out.printf("     PROMEDIO DE HORAS DISPONIBLES:  %s%n", Calculos.promedio(generador).getPromedioHorasDisponibles());
        System.out.printf("     DOCENTE CON MAYOR CANTIDAD DE HORAS DISPONIBLES:  %s%n", Calculos.getDocenteMayorCantidadHoras(generador).getDocenteMayorCantidadHoras().getNombre());
        System.out.printf("     DOCENTE CON MENOR CANTIDAD DE HORAS DISPONIBLES:  %s%n", Calculos.getDocenteMenorCantidadHoras(generador).getDocenteMenorCantidadHoras().getNombre());
    }
}
