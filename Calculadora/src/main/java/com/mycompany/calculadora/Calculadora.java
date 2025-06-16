/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author jareg
 */
public class Calculadora {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> new CalculadoraBasica().setVisible(true));
    }
}
