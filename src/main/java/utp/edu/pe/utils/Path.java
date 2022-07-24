package utp.edu.pe.utils;

public class Path {
    private static String pathError ;
    private static String pathArchivoDisponibilidad;

    public Path() {
    }

    public static String getPathError() {
        return pathError;
    }

    public static void setPathError(String pathError) {
        Path.pathError = pathError.concat(Constantes.FILE_ERROR);
    }

    public static String getPathArchivoDisponibilidad() {
        return pathArchivoDisponibilidad;
    }

    public static void setPathArchivoDisponibilidad(String pathArchivoDisponibilidad) {
        Path.pathArchivoDisponibilidad = pathArchivoDisponibilidad.concat(Constantes.FILE_DATA_DISPONIBILIDAD);
    }

    public static void generarFileError(){
        TextUTP.generarFile(Path.getPathError());
    }
    public static void generarFileDisponibilidad(){
        TextUTP.generarFile(Path.getPathArchivoDisponibilidad());
    }
}
