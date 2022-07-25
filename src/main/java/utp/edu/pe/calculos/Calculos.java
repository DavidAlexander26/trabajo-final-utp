package utp.edu.pe.calculos;

import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.model.Generador;
import utp.edu.pe.utils.ArrayPush;
import utp.edu.pe.utils.Constantes;

import java.io.IOException;
import java.security.CodeSigner;
import java.util.Arrays;

public class Calculos {

    public static Generador totalHorasDisponiblePorDia(Generador generador) {
        int[] horasDisponibleDiarias= new int[]{0,0,0,0,0,0,0};
        for (int i = 0; i < generador.getDisponibilidadCorrecto().length; i++) {
            for (int j = 0; j < generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal().length; j++) {
                if(generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.ALL){
                    horasDisponibleDiarias[j]+=Constantes.HORAS_M+Constantes.HORAS_T+Constantes.HORAS_N;

                } else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.M) {
                    horasDisponibleDiarias[j]+=Constantes.HORAS_M;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.T && j!=6) {
                    horasDisponibleDiarias[j]+=Constantes.HORAS_T;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.N && j!=6) {
                    horasDisponibleDiarias[j]+=Constantes.HORAS_N;
                }
            }

        }
        generador.setTotalHorasDiarias(horasDisponibleDiarias);
        return generador;
    }

    //**
    // Calculo de las horas por bloque
    // *//
    public static Generador totalHorasDisponiblePorBloque(Generador generador) {
        int[] horasDisponiblePorBloque= new int[]{0,0,0};
        for (int i = 0; i < generador.getDisponibilidadCorrecto().length; i++) {
            for (int j = 0; j < generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal().length; j++) {
                if(generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.ALL){
                    horasDisponiblePorBloque[0]+=Constantes.HORAS_M;
                    horasDisponiblePorBloque[1]+=Constantes.HORAS_T;
                    horasDisponiblePorBloque[2]+=Constantes.HORAS_N;

                } else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.M) {
                    horasDisponiblePorBloque[0]+=Constantes.HORAS_M;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.T && j!=6) {
                    horasDisponiblePorBloque[1]+=Constantes.HORAS_T;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.N && j!=6) {
                    horasDisponiblePorBloque[2]+=Constantes.HORAS_N;
                }
            }

        }
        generador.setTotalHorasPorBloque(horasDisponiblePorBloque);
        return generador;
    }

    public static Generador totalHorasDisponible(Generador generador) {
        int horasDisponibleTotal= 0;
        totalHorasDisponiblePorBloque(generador);
        for (int i = 0; i <generador.getTotalHorasPorBloque().length ; i++) {
            horasDisponibleTotal+=generador.getTotalHorasPorBloque()[i];
        }
        generador.setHorasTotalesDisponibles(horasDisponibleTotal);
        return generador;
    }

    public static Generador promedio(Generador generador) throws IOException {
        int horasTotalesDisponibles=0;
        int[] horasDisponiblesPorPersona= new int[]{};
        int suma=0;
        double promedio=0.0;
        for (int i = 0; i < generador.getDisponibilidadCorrecto().length; i++) {
            for (int j = 0; j < generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal().length; j++) {
                if(generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.ALL){
                    horasTotalesDisponibles+=Constantes.HORAS_M+Constantes.HORAS_T+Constantes.HORAS_N;

                } else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.M) {
                    horasTotalesDisponibles+=Constantes.HORAS_M;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.T && j!=6) {
                    horasTotalesDisponibles+=Constantes.HORAS_T;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.N && j!=6) {
                    horasTotalesDisponibles+=Constantes.HORAS_N;
                }
            }
            horasDisponiblesPorPersona= ArrayPush.push(horasDisponiblesPorPersona,horasTotalesDisponibles);
            horasTotalesDisponibles=0;
        }
        for (int i = 0; i < horasDisponiblesPorPersona.length; i++) {
            suma+=horasDisponiblesPorPersona[i];
        }
        promedio= suma/(horasDisponiblesPorPersona.length);
        generador.setPromedioHorasDisponibles(promedio);
        return generador;
    }

    public static Generador getDocenteMayorCantidadHoras(Generador generador) throws IOException {
        int horasTotalesDisponibles=0;
        int[] horasDisponiblesPorPersona= new int[]{};
        int indiceDelMayor=0;
        for (int i = 0; i < generador.getDisponibilidadCorrecto().length; i++) {
            for (int j = 0; j < generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal().length; j++) {

                if(generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.ALL){
                    horasTotalesDisponibles+=Constantes.HORAS_M+Constantes.HORAS_T+Constantes.HORAS_N;

                } else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.M) {
                    horasTotalesDisponibles+=Constantes.HORAS_M;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.T && j!=6) {
                    horasTotalesDisponibles+=Constantes.HORAS_T;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.N && j!=6) {
                    horasTotalesDisponibles+=Constantes.HORAS_N;
                }
            }
            horasDisponiblesPorPersona= ArrayPush.push(horasDisponiblesPorPersona,horasTotalesDisponibles);
            horasTotalesDisponibles=0;

        }
        for (int x = 1; x < horasDisponiblesPorPersona.length; x++) {
            if (horasDisponiblesPorPersona[x] > horasDisponiblesPorPersona[indiceDelMayor]) {
                indiceDelMayor = x;
            }
        }
        Disponibilidad personDisponible= generador.getDisponibilidadCorrecto()[indiceDelMayor];
        generador.setDocenteMayorCantidadHoras(personDisponible);
        return generador;
    }
    public static Generador getDocenteMenorCantidadHoras(Generador generador) throws IOException {
        int horasTotalesDisponibles=0;
        int[] horasDisponiblesPorPersona= new int[]{};
        int indiceDelMenor=0;
        for (int i = 0; i < generador.getDisponibilidadCorrecto().length; i++) {
            for (int j = 0; j < generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal().length; j++) {

                if(generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.ALL){
                    horasTotalesDisponibles+=Constantes.HORAS_M+Constantes.HORAS_T+Constantes.HORAS_N;

                } else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.M) {
                    horasTotalesDisponibles+=Constantes.HORAS_M;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.T && j!=6) {
                    horasTotalesDisponibles+=Constantes.HORAS_T;
                }
                else if (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.N && j!=6) {
                    horasTotalesDisponibles+=Constantes.HORAS_N;
                }
            }
            horasDisponiblesPorPersona= ArrayPush.push(horasDisponiblesPorPersona,horasTotalesDisponibles);
            horasTotalesDisponibles=0;
        }
        for (int x = 1; x < horasDisponiblesPorPersona.length; x++) {
            if (horasDisponiblesPorPersona[x] < horasDisponiblesPorPersona[indiceDelMenor]) {
                indiceDelMenor = x;
            }
        }
        Disponibilidad personDisponible= generador.getDisponibilidadCorrecto()[indiceDelMenor];
        generador.setDocenteMenorCantidadHoras(personDisponible);
        return generador;
    }

    public static double[] porcentajes(Generador generador){
        double[] arrayPorcentajesDouble = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        for (int i = 0; i < generador.getDisponibilidadCorrecto().length; i++) {
            for (int j = 0; j < generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal().length; j++) {
                if((generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.ALL && j!=6)
                || (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.M)
                || (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.N  && j!=6)
                || (generador.getDisponibilidadCorrecto()[i].getDisponibilidadSemanal()[j] == Constantes.T  && j!=6)
                ) {
                    arrayPorcentajesDouble[j] += 1;
                }
            }
        }
        for (int i = 0; i < arrayPorcentajesDouble.length; i++) {
            arrayPorcentajesDouble[i]=arrayPorcentajesDouble[i]/generador.getDisponibilidadCorrecto().length;
        }
        System.out.println(".."+Arrays.toString(arrayPorcentajesDouble));
        return arrayPorcentajesDouble;
    }
}
