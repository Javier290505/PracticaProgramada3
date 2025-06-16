/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author jareg
 */
public class CalculadoraBasica extends JFrame {
    
     private JTextField pantalla;
    private int numero1 = 0;
    private String operador = "";
    private boolean nuevoNumero = true;

    public CalculadoraBasica() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Pantalla de la calculadora
        pantalla = new JTextField("0");
        pantalla.setEditable(false);
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setFont(new Font("Arial", Font.BOLD, 30));
        add(pantalla, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5));
        String[] botones = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "C", "=", "/"
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            boton.addActionListener(new BotonListener());
            panelBotones.add(boton);
        }

        add(panelBotones, BorderLayout.CENTER);
    }

    // Manejador de eventos
    private class BotonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String texto = e.getActionCommand();

            if (texto.matches("\\d")) { // Si es número
                if (nuevoNumero || pantalla.getText().equals("0")) {
                    pantalla.setText(texto);
                    nuevoNumero = false;
                } else {
                    pantalla.setText(pantalla.getText() + texto);
                }
            } else if (texto.matches("[+\\-*/]")) { // Si es operador
                numero1 = Integer.parseInt(pantalla.getText());
                operador = texto;
                nuevoNumero = true;
            } else if (texto.equals("=")) {
                int numero2 = Integer.parseInt(pantalla.getText());
                int resultado = 0;

                switch (operador) {
                    case "+": resultado = numero1 + numero2; break;
                    case "-": resultado = numero1 - numero2; break;
                    case "*": resultado = numero1 * numero2; break;
                    case "/":
                        if (numero2 == 0) {
                            pantalla.setText("Error");
                            return;
                        } else {
                            resultado = numero1 / numero2;
                        }
                        break;
                }

                pantalla.setText(String.valueOf(resultado));
                nuevoNumero = true;
            } else if (texto.equals("C")) {
                pantalla.setText("0");
                numero1 = 0;
                operador = "";
                nuevoNumero = true;
            }
        }
    }
}
