package utp.edu.pe.gui;

import utp.edu.pe.utils.*;
import utp.edu.pe.validation.ValidationFile;

import javax.swing.*;
import java.io.IOException;

public class GeneradorGui {

    // 1. Declarar controles y variables globales
    JLabel lblTitulo;
    JLabel lblDisponibilidad;
    JLabel lblRutaArchivo;
    JTextField txtRutaArchivo;
    JLabel lblRutaReport;
    JTextField txtRutaReport;
    JButton btnRutaReport;
    JLabel lblReportAsci;
    JTextField txtReportAsci;
    JButton btnReportAsci;
    JLabel lblReportAsciPlot;
    JTextField txtReportAsciPlot;
    JButton btnReportAsciPlot;
    JLabel lblReportHTML;
    JTextField txtReportHTML;
    JButton btnReportHTML;
    JLabel lblInformativo;
    JTextField txtInformativo;
    JLabel lblInformativoError;
    JTextField txtInformativoError;
    JLabel lblRutaErrores;
    JTextField txtRutaErrores;
    JButton btnRutaError;
    public void prepararControles(){
        // 2. Crear controles
        lblTitulo         = new JLabel("PROGRAMA GENERADOR");
        lblDisponibilidad = new JLabel("------Disponibilidad horaria----");

        lblRutaArchivo = new JLabel("Ruta del archivo:");
        txtRutaArchivo = new JTextField(30);

        lblRutaReport    = new JLabel("Ruta de reporte:");
        txtRutaReport = new JTextField(30);
        btnRutaReport    = new JButton("Cargar");

        lblReportAsci    = new JLabel("Reporte ASCI:");
        txtReportAsci      = new JTextField(30);
        btnReportAsci  = new JButton("Generar Reporte ASCI");

        lblReportAsciPlot    = new JLabel("Reporte ASCI PLOT:");
        txtReportAsciPlot    = new JTextField(30);
        btnReportAsciPlot= new JButton("Generar Reporte ASCI PLOT");

        lblReportHTML    = new JLabel("Reporte HTML:");
        txtReportHTML     = new JTextField(30);
        btnReportHTML = new JButton("Generar Reporte HTML");

        ///
        lblRutaErrores = new JLabel("Ruta de Error:");
        txtRutaErrores  = new JTextField(30);
        btnRutaError = new JButton("Cargar");

        lblInformativo = new JLabel("Datos Registrados en el programa:");
        txtInformativo = new JTextField(30);
        txtInformativo.setText("0");
        txtInformativo.setEditable(false);
        lblInformativoError = new JLabel("Datos Registrados con Error:");
        txtInformativoError = new JTextField(30);
        txtInformativoError.setText("0");
        txtInformativoError.setEditable(false);

        // 3. Agregar controles al formulario
        SwingUTP.addControl(200 ,10, 800, 20, lblTitulo);
        SwingUTP.addControl(10 ,40, 1000, 20, lblRutaArchivo);
        SwingUTP.addControl(120,40, 400, 20, txtRutaArchivo);
        SwingUTP.addControl(10, 70, 100, 20, lblRutaReport);
        SwingUTP.addControl(120,70, 200, 20, txtRutaReport);
        SwingUTP.addControl(400,70, 100, 20, btnRutaReport);

        SwingUTP.addControl(10, 100, 800, 10, new JLabel("-------------------------------------------------------------------------------------------------------------------------"));

        SwingUTP.addControl(10, 110, 300, 20, lblReportAsci);
        //SwingUTP.addControl(120,110, 370, 20, txtReportAsci);
        SwingUTP.addControl(130, 110, 200, 22, btnReportAsci);

        SwingUTP.addControl(10, 150, 300, 20, lblReportAsciPlot);
       // SwingUTP.addControl(120,280, 370, 20, txtReportAsciPlot);
        SwingUTP.addControl(130, 150, 200, 22, btnReportAsciPlot);

        SwingUTP.addControl(10, 190, 300, 20, lblReportHTML);
        //SwingUTP.addControl(120,320, 370, 20, txtReportHTML);
        SwingUTP.addControl(130, 190, 200, 22, btnReportHTML);

        SwingUTP.addControl(10, 220, 800, 22, lblInformativo);
        SwingUTP.addControl(300, 220, 80, 22, txtInformativo);

        SwingUTP.addControl(10, 260, 800, 22, lblInformativoError);
        SwingUTP.addControl(300, 260, 80, 22, txtInformativoError);

        /////
        SwingUTP.addControl(10, 300, 100, 20, lblRutaErrores);
        SwingUTP.addControl(120,300, 370, 20, txtRutaErrores);
        SwingUTP.addControl(280, 320, 80, 20, btnRutaError);

        // 4. Agregar eventos
        SwingUTP.addClickEvent(btnReportAsci, this::clickBtnReportAsci);
        SwingUTP.addClickEvent(btnReportAsciPlot, this::clickBtnReportAsciPlot);
        SwingUTP.addClickEvent(btnRutaReport, this::clickBtnRutaReporte);
        SwingUTP.addClickEvent(btnReportHTML, this::clickBtnReporthtml);
        SwingUTP.addClickEvent(btnRutaError, this::clickBtnRutaError);
    }
    private void clickBtnReportAsci(Object o) {
        String inputRutaArchivo  = validarRuta(txtRutaArchivo.getText().trim());
        String inputRutaReporte = validarRuta(txtRutaReport.getText().trim());
        try {
            ValidationFile.validacionFile(inputRutaArchivo,"ASCI");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void clickBtnReportAsciPlot(Object o) {
        String inputRutaArchivo  = validarRuta(txtRutaArchivo.getText().trim());
        String inputRutaReporte = validarRuta(txtRutaReport.getText().trim());
        try {
            ValidationFile.validacionFile(inputRutaArchivo,"ASCIPLOT");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void clickBtnReporthtml(Object o) {
        String inputRutaArchivo  = validarRuta(txtRutaArchivo.getText().trim());
        String inputRutaReporte = validarRuta(txtRutaReport.getText().trim());
        try {
            ValidationFile.validacionFile(inputRutaArchivo,"HTML");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void clickBtnRutaError(Object o) {
        String input  = txtRutaErrores.getText().trim();
        String ruta = "";
        if(!input.isBlank()){
            if(input.substring(input.length()-1).equals("\\")){
                ruta = input;
            }
            else {
                ruta = input.concat("\\");
            }
            Path.setPathError(ruta);
            Path.generarFileError();
            JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ingrese ruta valida");
        }

    }
    private void clickBtnRutaReporte(Object o) {
        String input  = txtRutaReport.getText().trim();
        String ruta = "";
        if(!input.isBlank()){
            if(input.substring(input.length()-1).equals("\\")){
                ruta = input;
            }
            else {
                ruta = input.concat("\\");
            }
            Path.generarCarpetaReportes(ruta);
            Path.setPathReport(ruta);
            JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ingrese ruta valida");
        }

    }

    private String validarRuta(String ruta){
        if(!ruta.isBlank()){
            ruta = ruta.trim();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ingrese ruta valida");
        }
        return ruta;
    }
    public void mostrar(){
        prepararControles();
        SwingUTP.runWindow("UTP - Taller de Programacion",
                600, 400);
    }
}
