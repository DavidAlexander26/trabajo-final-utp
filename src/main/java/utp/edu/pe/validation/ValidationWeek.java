package utp.edu.pe.validation;

import utp.edu.pe.utils.Constantes;
import utp.edu.pe.utils.Functions;

public class ValidationWeek {

    public static  String[] validation(String[] arrayHorarios){
        boolean response = true;
        String[] resp = null;

        String[] diaLunes = arrayHorarios[0].split(":");
        if (diaLunes.length == 2) {
            if(!Constantes.LUNES.equals(diaLunes[0].trim())){
                response = response && false;
            }
            if(!validationDisponibilidadDia(diaLunes[1].trim())){
                response = response && false;
            }
        }
        else {
            response = response && false;
        }


        String[] diaMartes = arrayHorarios[1].split(":");
        if(diaMartes.length ==2){
            if(!Constantes.MARTES.equals(diaMartes[0].trim())){
                response = response && false;
            }
            if(!validationDisponibilidadDia(diaMartes[1].trim())){
                response = response && false;
            }
        }
        else {
            response = response && false;
        }


        String[] diaMiercoles = arrayHorarios[2].split(":");
        if(diaMiercoles.length==2){
            if(!Constantes.MIERCOLES.equals(diaMiercoles[0].trim())){
                response = response && false;
            }
            if(!validationDisponibilidadDia(diaMiercoles[1].trim())){
                response = response && false;
            }
        }
        else {
            response = response && false;
        }


        String[] diaJueves = arrayHorarios[3].split(":");
        if(diaJueves.length==2){
            if(!Constantes.JUEVES.equals(diaJueves[0].trim())){
                response = response && false;
            }
            if(!validationDisponibilidadDia(diaJueves[1].trim())){
                response = response && false;
            }
        }
        else {
            response = response && false;
        }


        String[] diaViernes = arrayHorarios[4].split(":");
        if(diaViernes.length==2){
            if(!Constantes.VIERNES.equals(diaViernes[0].trim())){
                response = response && false;
            }
            if(!validationDisponibilidadDia(diaViernes[1].trim())){
                response = response && false;
            }
        }
        else {
            response = response && false;
        }

        String[] diaSabado = arrayHorarios[5].split(":");
        if(diaSabado.length==2){
            if(!Constantes.SABADO.equals(diaSabado[0].trim())){
                response = response && false;
            }
            if(!validationDisponibilidadDia(diaSabado[1].trim())){
                response = response && false;
            }
        }
        else {
            response = response && false;
        }

        String[] diaDomingo = arrayHorarios[6].split(":");
        if(diaDomingo.length==2){
            if(!Constantes.DOMINGO.equals(diaDomingo[0].trim())){
                response = response && false;
            }
            if(!validationDisponibilidadDiaDomingo(diaDomingo[1].trim())){
                response = response && false;
            }
        }
        else {
            response = response && false;
        }

        if(response){
            resp = turnosCorrectos(diaLunes[1].trim(),diaMartes[1].trim(),
                    diaMiercoles[1].trim(),diaJueves[1].trim(),diaViernes[1].trim(),diaSabado[1].trim(),diaDomingo[1].trim());

        }
        else {
            Functions.addFormatoError("ERROR EN EL FORMATO DE DIAS Y HORARIOS");
        }
        return resp;

    }
    private static boolean validationDisponibilidadDia(String item){
        boolean response = false;

        if(Constantes.ALL.equals(item)){
            response = true;
        }
        if(Constantes.M.equals(item)){
            response = true;
        }
        if(Constantes.T.equals(item)){
            response = true;
        }
        if(Constantes.N.equals(item)){
            response = true;
        }
        if(Constantes.X.equals(item)){
            response = true;
        }
        return response;
    }
    private static boolean validationDisponibilidadDiaDomingo(String item){
        boolean response = false;

        if(Constantes.M.equals(item)){
            response = true;
        }
        if(Constantes.X.equals(item)){
            response = true;
        }
        return response;
    }
    private static String[] turnosCorrectos(String lunes, String martes, String miercoles,
                                            String jueves, String viernes, String sabado, String domingo){
        String[] turnos = new String[7];

        turnos[0] = turnoDelDia(lunes);
        turnos[1] = turnoDelDia(martes);
        turnos[2] = turnoDelDia(miercoles);
        turnos[3] = turnoDelDia(jueves);
        turnos[4] = turnoDelDia(viernes);
        turnos[5] = turnoDelDia(sabado);
        turnos[6] = turnoDelDia(domingo);

        return turnos;
    }
    private static String turnoDelDia(String item){
        String turno = "";
        if(Constantes.ALL.equals(item)){
            turno = Constantes.ALL;
        }
        if(Constantes.M.equals(item)){
            turno = Constantes.M;
        }
        if(Constantes.T.equals(item)){
            turno = Constantes.T;
        }
        if(Constantes.N.equals(item)){
            turno = Constantes.N;
        }
        if(Constantes.X.equals(item)){
            turno = Constantes.X;
        }
        return turno;
    }
}
