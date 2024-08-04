package com.frank.calculadora;

public class Calculadora {

    private double num1, num2;
    private char operador;

    // Constructor
    public Calculadora() {
        this.num1 = 0;
        this.num2 = 0;
    }

    // Reiniciar atributos
    public void reiniciarCalc() {
        this.num1 = 0;
        this.num2 = 0;
        this.operador = '\u0000';
    }

    // Realizar la operacion
    public double calcular() {
        switch (operador) {
            case '+' -> {
                return num1 + num2;
            }

            case '-' -> {
                return num1 - num2;
            }

            case '*' -> {
                return num1 * num2;
            }

            case '/' -> {
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return Double.NaN;
                }
            }
        }
        return Double.NaN;
    }

    // Setters, Getters
    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void setOperador(char c) {
        this.operador = c;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public char getOperador() {
        return operador;
    }

    // Main
    public static void main(String[] args) {

        Gui gui = new Gui(); // Instancia de Gui
        gui.setVisible(true);

    }
}
