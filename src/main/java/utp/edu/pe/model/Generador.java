package utp.edu.pe.model;

import java.io.File;
import java.lang.reflect.Array;

public class Generador {
    private String archivoDisponibilidad;
    private String tipoDereport;
    private Disponibilidad[] disponibilidadCorrecto;
    private int numErrors;
    private int numTotal;

    private int[] totalHorasDiarias;
    private int[] totalHorasPorBloque;
    private int horasTotalesDisponibles;
    private double promedioHorasDisponibles;
    private Disponibilidad docenteMayorCantidadHoras;
    private Disponibilidad docenteMenorCantidadHoras;


    public Generador(String archivoDisponibilidad, String tipoDereport) {
        this.archivoDisponibilidad = archivoDisponibilidad;
        this.tipoDereport = tipoDereport;
    }

    public Generador(Disponibilidad[] disponibilidadCorrecto) {
        this.disponibilidadCorrecto = disponibilidadCorrecto;
    }

    public Generador(Disponibilidad[] disponibilidadCorrecto, int numErrors, int numTotal) {
        this.disponibilidadCorrecto = disponibilidadCorrecto;
        this.numErrors = numErrors;
        this.numTotal = numTotal;
    }

    public String getArchivoDisponibilidad() {
        return archivoDisponibilidad;
    }

    public void setArchivoDisponibilidad(String archivoDisponibilidad) {
        this.archivoDisponibilidad = archivoDisponibilidad;
    }

    public String getTipoDereport() {
        return tipoDereport;
    }

    public void setTipoDereport(String tipoDereport) {
        this.tipoDereport = tipoDereport;
    }

    public Disponibilidad[] getDisponibilidadCorrecto() {
        return disponibilidadCorrecto;
    }

    public void setDisponibilidadCorrecto(Disponibilidad[] disponibilidadCorrecto) {
        this.disponibilidadCorrecto = disponibilidadCorrecto;
    }
    public int getNumErrors() {
        return numErrors;
    }

    public void setNumErrors(int numErrors) {
        this.numErrors = numErrors;
    }

    public int getNumTotal() {
        return numTotal;
    }

    public void setNumTotal(int numTotal) {
        this.numTotal = numTotal;
    }

    public int[] getTotalHorasDiarias() {
        return totalHorasDiarias;
    }

    public void setTotalHorasDiarias(int[] totalHorasDiarias) {
        this.totalHorasDiarias = totalHorasDiarias;
    }

    public int[] getTotalHorasPorBloque() {
        return totalHorasPorBloque;
    }

    public void setTotalHorasPorBloque(int[] totalHorasPorBloque) {
        this.totalHorasPorBloque = totalHorasPorBloque;
    }

    public int getHorasTotalesDisponibles() {
        return horasTotalesDisponibles;
    }

    public void setHorasTotalesDisponibles(int horasTotalesDisponibles) {
        this.horasTotalesDisponibles = horasTotalesDisponibles;
    }

    public double getPromedioHorasDisponibles() {
        return promedioHorasDisponibles;
    }

    public void setPromedioHorasDisponibles(double promedioHorasDisponibles) {
        this.promedioHorasDisponibles = promedioHorasDisponibles;
    }

    public Disponibilidad getDocenteMayorCantidadHoras() {
        return docenteMayorCantidadHoras;
    }

    public void setDocenteMayorCantidadHoras(Disponibilidad docenteMayorCantidadHoras) {
        this.docenteMayorCantidadHoras = docenteMayorCantidadHoras;
    }

    public Disponibilidad getDocenteMenorCantidadHoras() {
        return docenteMenorCantidadHoras;
    }

    public void setDocenteMenorCantidadHoras(Disponibilidad docenteMenorCantidadHoras) {
        this.docenteMenorCantidadHoras = docenteMenorCantidadHoras;
    }
}
