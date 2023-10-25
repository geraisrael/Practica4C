/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package gerardo.gonzalez.uabc.tecladografico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TecladoGrafico extends JFrame {
    private JTextField textField;
    private String enteredText = "";

    public TecladoGrafico() {
        setTitle("Teclado Gráfico");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel keyboardPanel = new JPanel(new GridLayout(3, 9)); // Usamos GridLayout para organizar los botones en una matriz 3x9

        // Definir las letras que estarán en el teclado
        String[][] letters = {
            {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"},
            {"A", "S", "D", "F", "G", "H", "J", "K", "L"},
            {"Z", "X", "C", "V", "B", "N", "M"}
        };
        
        // Crear botones para cada letra y agregarlos a la matriz
        for (String[] row : letters) {
            for (String letter : row) {
                JButton button = new JButton(letter);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedLetter = button.getText();
                        enteredText += selectedLetter;
                        textField.setText(textField.getText() + selectedLetter);
                    }
                });
                keyboardPanel.add(button);
            }
        }

        // Botón "Enter"
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestra la palabra o letra en alguna posición de la ventana gráfica
                JOptionPane.showMessageDialog(null, "Texto ingresado: " + enteredText);
            }
        });

        // Botón "Borrar"
        JButton clearButton = new JButton("Borrar");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Borra las letras del JTextField
                enteredText = "";
                textField.setText("");
            }
        });

        textField = new JTextField(5);

        add(keyboardPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);

        // Agregar los botones "Enter" y "Borrar"
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(enterButton);
        buttonPanel.add(clearButton);
        add(buttonPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TecladoGrafico teclado = new TecladoGrafico();
            teclado.setVisible(true);
        });
    }
}

