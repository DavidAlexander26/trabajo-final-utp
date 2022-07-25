package utp.edu.pe.reports;

import utp.edu.pe.calculos.Calculos;
import utp.edu.pe.model.Generador;
import utp.edu.pe.utils.ArrayPush;
import utp.edu.pe.utils.Plot;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReportAsciiPlot {
    public static void outReport(Generador generador) throws IOException {
        int[] eje = {100,90,80,70,60,50,40,30,20,10,0};
        int [] info =  new int[]{};
        String[] diasSemana = {"LUN","MAR","MIE","JUE","VIE","SAB","DOM"};
       double[] porcentaje= Calculos.porcentajes(generador);
        for (int i = 0; i <porcentaje.length ; i++) {
                porcentaje[i]=(int) (porcentaje[i]*100);
                    if(porcentaje[i]>90 && porcentaje[i]<=100) {
                        porcentaje[i]=100;
                    } else if (porcentaje[i]>80 && porcentaje[i]<=90) {
                        porcentaje[i]=90;
                    } else if (porcentaje[i]>70 && porcentaje[i]<=80) {
                        porcentaje[i]=80;
                    }else if (porcentaje[i]>60 && porcentaje[i]<=70) {
                        porcentaje[i]=70;
                    }else if (porcentaje[i]>50 && porcentaje[i]<=60) {
                        porcentaje[i]=60;
                    }else if (porcentaje[i]>40 && porcentaje[i]<=50) {
                        porcentaje[i]=50;
                    }else if (porcentaje[i]>30 && porcentaje[i]<=40) {
                        porcentaje[i]=40;
                    }else if (porcentaje[i]>20 && porcentaje[i]<=30) {
                        porcentaje[i]=30;
                    }else if (porcentaje[i]>10 && porcentaje[i]<=20) {
                        porcentaje[i]=20;
                    }
                    else if (porcentaje[i]>0 && porcentaje[i]<=10) {
                        porcentaje[i]=10;
                    }
            info= ArrayPush.push(info,(int) (porcentaje[i]));
        }
        String[][] plot = Plot.makePlotData(eje.length,info.length);
        Plot.setPlotData(plot, info, eje.length);
        //Dibujar plot
        for (int f = 0; f < plot.length; f++){
            System.out.printf("%3d|", eje[f]);
            if(eje[f]==0){
                System.out.print("---------------------------");
            }
            for (int c = 0; c < plot[0].length; c++){
                System.out.printf(plot[f][c]+" ");
            }
            System.out.printf("\n");
        }
        System.out.print("    ");
        for (int i = 0; i < diasSemana.length; i++) {
            System.out.print(""+diasSemana[i]+" ");
        }
    }
}
