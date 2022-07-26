package utp.edu.pe.model;

import java.util.Arrays;

public class Disponibilidad {
    private String codigo;
    private String nombre;
    private String[] disponibilidadSemanal;

    @Override
    public String toString() {
        return "Disponibilidad{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
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

    public Disponibilidad(String codigo, String nombre, String[] disponibilidadSemanal) {
        this.codigo = codigo;
        this.nombre = nombre;
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

}
