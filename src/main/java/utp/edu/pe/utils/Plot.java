package utp.edu.pe.utils;

import java.util.Arrays;

public class Plot {
    public static String[][] makePlotData(int row, int col){
        String[][] plot = new String [row][col];
        //Interamos para inicializar a x
        for (int f = 0; f < plot.length; f++) {
            for (int c = 0; c < plot[0].length; c++) {
                plot[f][c] = "   ";
            }
        }
        return plot;
    }

    public static void setPlotData(String[][] data, int[] info, int tamanoEjeX, int tamanoY){
        int ejeX=0;
        for (int i = 0; i < info.length; i++){
            //System.out.print("Ela valor de i es:"+i);
            ejeX=i;
            int ejeY = switch (info[i]){
                case 100 -> 0;
                case 80 -> 2; case 90 ->1;
                case 60 -> 4; case 70 ->3;
                case 50 -> 5; case 40 ->6;
                case 30 -> 7; case 20 -> 8;
                case 10 -> 9; case 0 -> 10;
                default -> 10;
            };
            for (int k = 0; k <tamanoY ; k++) {
                //data[k][i] = "   ";
                if(k==ejeY){
                    System.out.print(i);
                    data[ejeY][i]="***";
                   while (ejeY>0){
                        System.out.print("--"+i);
                        data[ejeY][i]="***";
                        ejeY=ejeY-1;
                   }
                }
            }

            /*for (int j=ejeY; j >0 ; j--) {
                System.out.print(j+"-"+ejeX+"--");
                data[j][ejeX] = "***";
            }*/

        }
    }


}
