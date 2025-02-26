package org.example.controller;

public class CalculatorController {
    private String operation;
    private double num1;

    private double executeOperation(double num1, double num2, String operation) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "x" -> num1 * num2;
            case "/" -> (num1 != 0) ? num1 / num2 : 0;
            default -> 0;
        };
    }

    private String calculateResult(String text) {
        double num2 = Double.parseDouble(text);
        double result = executeOperation(num1,num2, operation);
        return String.valueOf(result);
    }

    private String cleanDisplay() {
        num1 = 0;
        return "";
    }

    private void store(String command, String text) {
        num1 = Double.parseDouble(text);
        operation = command;
    }

    public String processCommand(String command, String text) {
        if (command.matches("\\d"))
            return text + command;
        else if ("C".equals(command))
            return cleanDisplay();
        else if ("=".equals(command))
            return calculateResult(text);
        else {
            store(command, text);
            return "";
        }


    }
}
