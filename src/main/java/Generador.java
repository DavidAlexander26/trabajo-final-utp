import utp.edu.pe.gui.GeneradorGui;
import utp.edu.pe.model.Disponibilidad;
import utp.edu.pe.utils.Constantes;
import utp.edu.pe.validation.ValidationFile;
import utp.edu.pe.validation.ValidationFormat;
import utp.edu.pe.validation.ValidationInit;

import java.io.File;
import java.io.IOException;

public class Generador {
    public static void main(String[] args) throws IOException {
        GeneradorGui windows = new GeneradorGui();
        windows.mostrar();
    }
}
