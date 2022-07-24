package utp.edu.pe.gui;

import utp.edu.pe.loand.LoandData;
import utp.edu.pe.utils.*;
import utp.edu.pe.validation.ValidatioName;
import utp.edu.pe.validation.ValidationCode;
import utp.edu.pe.validation.ValidationWeek;

import javax.swing.*;
import java.io.IOException;

public class Capturador {
    // 1. Declarar controles y variables globales
    JLabel lblTitulo;
    JLabel lblCodDocente;JTextField txtCodDocente;
    JLabel lblNombre    ;JTextField txtNombre;

    JLabel lblDisponibilidad;
    JLabel lblLunes     ;JTextField txtLunes;
    JLabel lblMartes    ;JTextField txtMartes;
    JLabel lblMiercoles ;JTextField txtMiercoles;
    JLabel lblJueves    ;JTextField txtJueves;
    JLabel lblViernes   ;JTextField txtViernes;
    JLabel lblSabado    ;JTextField txtSabado;
    JLabel lblDomingo   ;JTextField txtDomingo;

    JLabel lblCargarArchivo  ;JTextField txtCargarArchivo;
    JLabel lblRutaArchivo    ;JTextField txtRutaArchivo;
    JLabel lblRutaErrores    ;JTextField txtRutaErrores;

    JButton btnRegistrar;

    JButton btnCargarDatos;JButton btnRutaArchivo;JButton btnRutaError;
    JLabel lblInformativo; JTextField txtInformativo;

    public void prepararControles(){
        // 2. Crear controles
        lblTitulo         = new JLabel("PROGRAMA CAPTURADOR");
        lblDisponibilidad = new JLabel("------Disponibilidad horaria----");

        lblCodDocente = new JLabel("Codigo Docente:");
        txtCodDocente = new JTextField(30);
        lblNombre    = new JLabel("Nombre:");
        txtNombre    = new JTextField(30);
        lblLunes     = new JLabel("LUNES:");
        txtLunes     = new JTextField(30);
        lblMartes    = new JLabel("MARTES:");
        txtMartes    = new JTextField(30);
        lblMiercoles = new JLabel("MIERCOLES:");
        txtMiercoles = new JTextField(30);
        lblJueves    = new JLabel("JUEVES:");
        txtJueves    = new JTextField(30);
        lblViernes   = new JLabel("VIERNES:");
        txtViernes   = new JTextField(30);
        lblSabado    = new JLabel("SABADO:");
        txtSabado    = new JTextField(30);
        lblDomingo   = new JLabel("DOMINGO:");
        txtDomingo   = new JTextField(30);
        btnRegistrar = new JButton("Registrar");

        lblCargarArchivo    = new JLabel("Cargar datos:");
        txtCargarArchivo    = new JTextField(30);
        btnCargarDatos = new JButton("Cargar");

        lblRutaArchivo    = new JLabel("Ruta Disponibilidad:");
        txtRutaArchivo    = new JTextField(30);
        btnRutaArchivo = new JButton("Guardar");

        lblRutaErrores   = new JLabel("Ruta Errores:");
        txtRutaErrores   = new JTextField(30);
        btnRutaError = new JButton("Guardar");

        lblInformativo = new JLabel("Datos Registrados en el programa:");
        txtInformativo = new JTextField(30);
        txtInformativo.setText("0");
        txtInformativo.setEditable(false);

        // 3. Agregar controles al formulario
        SwingUTP.addControl(200 ,10, 800, 20, lblTitulo);
        SwingUTP.addControl(10 ,40, 100, 20, lblCodDocente);
        SwingUTP.addControl(120,40, 100, 20, txtCodDocente);
        SwingUTP.addControl(10, 60, 100, 20, lblNombre);
        SwingUTP.addControl(120,60, 400, 20, txtNombre);
        SwingUTP.addControl(50, 90, 800, 20, lblDisponibilidad);

        SwingUTP.addControl(10, 120, 100, 20, lblLunes);
        SwingUTP.addControl(120,120, 30,  20, txtLunes);
        SwingUTP.addControl(200,120, 100, 20, lblMartes);
        SwingUTP.addControl(310,120, 30,  20, txtMartes);
        SwingUTP.addControl(390, 120, 100, 20, lblMiercoles);
        SwingUTP.addControl(500,120, 30,  20, txtMiercoles);

        SwingUTP.addControl(10, 140, 100, 20, lblJueves);
        SwingUTP.addControl(120,140, 30,  20, txtJueves);
        SwingUTP.addControl(200, 140, 100, 20, lblViernes);
        SwingUTP.addControl(310,140, 30,  20, txtViernes);
        SwingUTP.addControl(390, 140, 100, 20, lblSabado);
        SwingUTP.addControl(500,140, 30,  20, txtSabado);

        SwingUTP.addControl(200, 160, 100, 20, lblDomingo);
        SwingUTP.addControl(310,160, 30,  20, txtDomingo);

        SwingUTP.addControl(120, 190, 310, 22, btnRegistrar);

        SwingUTP.addControl(10, 220, 800, 10, new JLabel("-------------------------------------------------------------------------------------------------------------------------"));

        SwingUTP.addControl(10, 240, 100, 20, lblCargarArchivo);
        SwingUTP.addControl(120,240, 370, 20, txtCargarArchivo);
        SwingUTP.addControl(500, 240, 80, 22, btnCargarDatos);

        SwingUTP.addControl(10, 280, 100, 20, lblRutaArchivo);
        SwingUTP.addControl(120,280, 370, 20, txtRutaArchivo);
        SwingUTP.addControl(500, 280, 80, 22, btnRutaArchivo);

        SwingUTP.addControl(10, 320, 100, 20, lblRutaErrores);
        SwingUTP.addControl(120,320, 370, 20, txtRutaErrores);
        SwingUTP.addControl(500, 320, 80, 22, btnRutaError);

        SwingUTP.addControl(10, 340, 800, 22, lblInformativo);
        SwingUTP.addControl(300, 340, 80, 22, txtInformativo);
        // 4. Agregar eventos
        SwingUTP.addClickEvent(btnRutaArchivo, this::clickBtnRutaArchivo);
        SwingUTP.addClickEvent(btnRutaError, this::clickBtnRutaError);
        SwingUTP.addClickEvent(btnRegistrar, this::clickBtnRegistrar);
        SwingUTP.addClickEvent(btnCargarDatos, this::clickCargarData);
    }
    private void clickBtnRegistrar(Object o){

            String codigo = txtCodDocente.getText().trim();
            String nombre = txtNombre.getText().trim();

            String lunes     = Constantes.LUNES.concat(":").concat(txtLunes.getText().trim());
            String martes    = Constantes.MARTES.concat(":").concat(txtMartes.getText().trim());
            String miercoles = Constantes.MIERCOLES.concat(":").concat(txtMiercoles.getText().trim());
            String jueves    = Constantes.JUEVES.concat(":").concat(txtJueves.getText().trim());
            String viernes   = Constantes.VIERNES.concat(":").concat(txtViernes.getText().trim());
            String sabado    = Constantes.SABADO.concat(":").concat(txtSabado.getText().trim());
            String domingo   = Constantes.DOMINGO.concat(":").concat(txtDomingo.getText().trim());

            String [] semana = {lunes,martes,miercoles,jueves,viernes,sabado,domingo};

            String [] response = ValidationWeek.validation(semana);
            if(ValidationCode.validationCode(codigo)
                    && ValidatioName.validacionLongitud(nombre)
                    && (response != null)){
                Functions.addFormatoDisponibilidad(codigo,nombre,response);
                JOptionPane.showMessageDialog(null, "Registro exitoso");
                clear();
                actualizarLblInformativo();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se pudieron registrar los datos, revise si el formato es valido");
            }
    }
    private void clickCargarData(Object o){
        String input = txtCargarArchivo.getText().trim();

        if(!input.isBlank()){
            int [] response = LoandData.cargarData(input);

            JOptionPane.showMessageDialog(null, "Total Registros: ".concat(String.valueOf(response[0]))
                    .concat(", Registros Correctos:").concat(String.valueOf(response[1]))
                    .concat(", Registros Incorrectos:").concat(String.valueOf(response[2]))
            );
            txtCargarArchivo.setText("");
            actualizarLblInformativo();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ingrese ruta valida");
        }
    }
    private void clickBtnRutaArchivo(Object o) {
        String input  = txtRutaArchivo.getText().trim();
        String ruta = "";
        if(!input.isBlank()){
            if(input.substring(input.length()-1).equals("\\")){
                ruta = input;
            }
            else {
                ruta = input.concat("\\");
            }
            Path.setPathArchivoDisponibilidad(ruta);
            Path.generarFileDisponibilidad();
            JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "ingrese ruta valida");
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
    private void actualizarLblInformativo(){
        try {
            String[] lineas = TextUTP.readlinesAsArray(Path.getPathArchivoDisponibilidad());
            txtInformativo.setText(String.valueOf(lineas.length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private  void clear(){
        txtCodDocente.setText("");
        txtNombre.setText("");

        txtLunes.setText("");
        txtMartes.setText("");
        txtMiercoles.setText("");
        txtJueves.setText("");
        txtViernes.setText("");
        txtSabado.setText("");
        txtDomingo.setText("");
    }
    public void mostrar(){
        prepararControles();
        SwingUTP.runWindow("UTP - Taller de Programacion",
                600, 400);
    }
}
