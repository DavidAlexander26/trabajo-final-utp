package utp.edu.pe.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TextUTP {

    public enum OS {WINDOWS, LINUX};

    public static String read(String filename) throws IOException {
        try(BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(filename))
        ){
            String data = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            return data;
        } catch (IOException e) {
            throw e;
        }
    }

    public static List<String> readlines(String filename, OS os) throws IOException {
        String delim = (os == OS.WINDOWS) ? "\r\n" : "\n";
        String data = read(filename);
        List<String> res = new LinkedList<>();
        if (data.length() > 0){
            res = Arrays.asList(data.split(delim));
        }
        return res;
    }

    public static List<String> readlines(String filename) throws IOException {
        return readlines(filename, OS.LINUX);
    }

    public static String[] readlinesAsArray(String filename, OS os) throws IOException {
        String delim = (os == OS.WINDOWS) ? "\r\n" : "\n";
        String data = read(filename);
        String[] res = new String[]{};
        if (data.length() > 0){
            res = data.split(delim);
        }
        return res;
    }

    public static String[] readlinesAsArray(String filename) throws IOException {
        return readlinesAsArray(filename, OS.LINUX);
    }

    private static void writeText(byte[] data, String filename)
            throws IOException{
        try(BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(filename,true))
        ){
            out.write(data);
        } catch (IOException e) {
            throw e;
        }
    }

    public static void append(String data, String filename) throws IOException {
        writeText(data.getBytes(), filename);
    }

    public static void append(String[] data, String filename, boolean withNewLine, OS os) throws IOException {
        String delim = (os == OS.WINDOWS) ? "\r\n" : "\n";
        StringBuilder sb = new StringBuilder();
        for (String item : data) {
            if (withNewLine == true) {
                sb.append(item + delim);
            }else{
                sb.append(item);
            }
        }
        writeText(sb.toString().getBytes(), filename);
    }

    public static void append(String[] data, String filename, boolean withNewLine) throws IOException {
        append(data, filename, withNewLine, OS.LINUX);
    }

    public static void append(String[] data, String filename) throws IOException {
        append(data, filename, true);
    }

    public static void append(List<String> data, String filename, boolean withNewLine, OS os) throws IOException {
        String delim = (os == OS.WINDOWS) ? "\r\n" : "\n";
        StringBuilder sb = new StringBuilder();
        for (String item : data) {
            if (withNewLine == true) {
                sb.append(item + delim);
            }else{
                sb.append(item);
            }
        }
        writeText(sb.toString().getBytes(), filename);
    }

    public static void append(List<String> data, String filename, boolean withNewLine) throws IOException {
        append(data, filename, withNewLine, OS.LINUX);
    }

    public static void append(List<String> data, String filename) throws IOException {
        append(data, filename, true);
    }
    public static void  generarFileHTML(String path, String nameFile, String content){
        try {
            String pathComplete = path.concat(nameFile).concat(".html");
            File file = new File(pathComplete);
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void generarFile(String path){
        try {
            File file = new File(path);
            if(file.exists()){
                file.delete();
            }
            if(!file.exists()){
                file.createNewFile();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void generarDirectorio(String path){
        String pathComplete = path.concat(Constantes.ARCHIVES_HTML);
        try {
            File directorio = new File(pathComplete);
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                    System.out.println("Directorio creado");
                } else {
                    System.out.println("Error al crear directorio");
                }
            }
            else{
                directorio.delete();
            }
        }
        catch (Exception e){

        }
    }
}
