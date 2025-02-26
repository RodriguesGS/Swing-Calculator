package org.example;

import org.example.controller.CalculatorController;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    private static JTextField display;
    private static CalculatorController controller;

    public Calculator() {
        controller = new CalculatorController();
        windowConfiguration();
        display = configureDisplay();
        add(display, BorderLayout.NORTH);
        add(buttonPanel(), BorderLayout.CENTER);
        setVisible(true);
    }

    private void windowConfiguration() {
        setTitle("Calculadora");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    }

    private JTextField configureDisplay() {
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        return display;
    }

    private JPanel buttonPanel() {
        JPanel panel = new JPanel(new GridLayout(4,4));
        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", "0", "C", "=", "+"};

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(e -> processInput(e.getActionCommand()));
            panel.add(button);
        }

        return panel;
    }

    private void processInput(String command) {
        display.setText(controller.processCommand(command, display.getText()));
    }
}
