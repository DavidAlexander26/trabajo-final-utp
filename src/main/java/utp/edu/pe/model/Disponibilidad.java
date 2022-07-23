package utp.edu.pe.model;

import java.util.Arrays;

public class Disponibilidad {
    private String codigo;
    private String nombre;
    private String horarioSemanal;
    private String[] disponibilidadSemanal;

    @Override
    public String toString() {
        return "Disponibilidad{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horarioSemanal='" + horarioSemanal + '\'' +
                ", disponibilidadSemanal=" + Arrays.toString(disponibilidadSemanal) +
                '}';
    }

    public String[] getDisponibilidadSemanal() {
        return disponibilidadSemanal;
    }

    public void setDisponibilidadSemanal(String[] disponibilidadSemanal) {
        this.disponibilidadSemanal = disponibilidadSemanal;
    }

    public Disponibilidad() {
    }

    public Disponibilidad(String codigo, String nombre, String horarioSemanal, String[] disponibilidadSemanal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horarioSemanal = horarioSemanal;
        this.disponibilidadSemanal = disponibilidadSemanal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorarioSemanal() {
        return horarioSemanal;
    }

    public void setHorarioSemanal(String horarioSemanal) {
        this.horarioSemanal = horarioSemanal;
    }
}
