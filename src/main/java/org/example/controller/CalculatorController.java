package org.example.controller;

public class CalculatorController {
    private String operation;
    private double num1;
    private boolean display = false;

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
        try {
            String[] parts = text.split(" ");
            if (parts.length < 3) return text;

            double num1 = Double.parseDouble(parts[0]);
            String operation = parts[1];
            double num2 = Double.parseDouble(parts[2]);
            double result = executeOperation(num1, num2, operation);

            return String.valueOf(result);
        } catch (Exception e) {
            return "Error" + e;
        }
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
        if (command.matches("\\d")) {
            if (display) {
                display = false;
                return command;
            }
            return text + command;
        }
        else if ("C".equals(command))
            return cleanDisplay();
        else if ("=".equals(command)) {
            display = true;
            return calculateResult(text);
        }

        else {
            if (!text.isEmpty() && !text.endsWith(" "))
                return text + " " + command + " ";
            return text;
        }


    }
}
