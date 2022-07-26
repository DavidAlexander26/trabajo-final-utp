package utp.edu.pe.utils;

import utp.edu.pe.model.Disponibilidad;

import java.io.IOException;

public class ArrayPush {
    public static Disponibilidad[] push(Disponibilidad[] array, Disponibilidad push) throws IOException {
       Disponibilidad[] longer = new Disponibilidad[array.length + 1];
        for (int i = 0; i < array.length; i++)
            longer[i] = array[i];
        longer[array.length] = push;
        return longer;
    }

    public static int[] push(int[] array, int push) throws IOException {
        int[] longer = new int[array.length + 1];
        for (int i = 0; i < array.length; i++)
            longer[i] = array[i];
        longer[array.length] = push;
        return longer;
    }
}
