package utp.edu.pe.gui;

import utp.edu.pe.utils.SwingUTP;

import javax.swing.*;
import java.io.IOException;

public class PantallaPrincipal {
    // 1. Declarar controles
    JLabel lblDisponibilidad;
    JTextField txtDisponibilidad;
    JButton btnDisponibilidad;

    public void prepararControles(){
        // 2. Crear controles
        lblDisponibilidad = new JLabel("Ingrese disponibilidad");
        txtDisponibilidad = new JTextField(30);
        btnDisponibilidad = new JButton("INGRESAR");

        // 3. Agregar controles al formulario
        SwingUTP.addControl(0,0, lblDisponibilidad);
        SwingUTP.addControl(1,0, txtDisponibilidad);
        SwingUTP.addControl(2,0, btnDisponibilidad);
        // 4. Agregar eventos
        SwingUTP.addClickEvent(btnDisponibilidad, this::btnDisnibilidadDocente);

    }

    private void btnDisnibilidadDocente(Object o) {


    }

    public void mostrar(){
        prepararControles();
        SwingUTP.runWindow("Load Data - Alumnos",
                400, 250);
    }
}
