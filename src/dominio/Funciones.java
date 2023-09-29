package dominio;

import javax.swing.*;
import java.util.Arrays;

public class Funciones {

    private static final Calculadora calculadora = new Calculadora();
    static JCheckBox redondear = new JCheckBox("redondear");
    private static final Object[] OPCIONES = Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir", redondear).toArray();
    private static final int SUMAR = 0;
    private static final int RESTAR = 1;
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;

    public static int preguntarCantidadNumeros() {
        int cantidad = 0;
        boolean cantidadValida = false;

        do {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de números que desea operar"));
                if (cantidad > 0) {
                    cantidadValida = true;
                } else {
                    mostrarError("La cantidad debe ser un número positivo");
                }
            } catch (NumberFormatException e) {
                mostrarError("La entrada no es válida. Ingrese un número entero positivo.");
            }
        } while (!cantidadValida);

        return cantidad;
    }

    public static double[] obtenerNumeros(int cantidadNumeros) {
        double[] numeros = new double[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = recibirNumero("Ingrese el número " + (i + 1));
        }
        return numeros;
    }

    public static void realizarOperacionYMostrarResultado(int opcion, Calculadora calculadora, double[] numeros) {
        double resultado = numeros[0];
        try {
            for (int i = 1; i < numeros.length; i++) {
                switch (opcion) {
                    case SUMAR -> resultado = calculadora.sumar(resultado, numeros[i]);
                    case RESTAR -> resultado = calculadora.restar(resultado, numeros[i]);
                    case MULTIPLICAR -> resultado = calculadora.multiplicacion(resultado, numeros[i]);
                    case DIVIDIR -> {
                        if (numeros[i] != 0) {
                            resultado = calculadora.division(resultado, numeros[i]);
                        } else {
                            throw new ArithmeticException("No se puede dividir entre cero");
                        }
                    }
                }
            }
            mostrarMensaje("El resultado es ", resultado);
        } catch (ArithmeticException e) {
            mostrarError("Error: " + e.getMessage());
        }
    }

    public static void realizarOperacion(int opcion, double num1, double num2) {
        switch (opcion) {
            case SUMAR -> mostrarMensaje("La suma es ", calculadora.sumar(num1, num2));
            case RESTAR -> mostrarMensaje("La resta es ", calculadora.restar(num1, num2));
            case MULTIPLICAR -> mostrarMensaje("La multiplicación es ", calculadora.multiplicacion(num1, num2));
            case DIVIDIR -> {
                if (num2 != 0) {
                    mostrarMensaje("La división es ", calculadora.division(num1, num2));
                } else {
                    mostrarError("No se puede dividir entre cero");
                }
            }
        }
    }

    public static void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Calculadora", JOptionPane.ERROR_MESSAGE);
    }

    public static void mostrarMensaje(String mensaje, double numero) {
        if (redondear.isSelected()) {
            numero = Double.parseDouble(calculadora.redondear(numero));
        }
        JOptionPane.showMessageDialog(null, mensaje + numero, "Calculadora", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int mostrarMenu() {
        int opcion = JOptionPane.showOptionDialog(null, "¿Qué operación desea realizar?", "Calculadora", 0, JOptionPane.QUESTION_MESSAGE, null, OPCIONES, null);

        if (opcion == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
        return opcion;
    }

    public static double recibirNumero(String mensaje) {
        double numeroARetornar = 0;
        boolean numeroValido = false;

        do {
            try {
                numeroARetornar = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                numeroValido = true;
            } catch (NumberFormatException e) {
                mostrarError("El número no es válido. Ingréselo nuevamente.");
            }
        } while (!numeroValido);

        return numeroARetornar;
    }
}
