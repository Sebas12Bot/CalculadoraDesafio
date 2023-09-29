package dominio;

import javax.swing.*;
import java.util.Arrays;

public class Funciones {

    static JCheckBox redondear = new JCheckBox("redondear");
    private static final Object[] OPCIONES = Arrays.asList("Sumar", "Restar", "Multiplicar", "Dividir", redondear).toArray();
    private static final int SUMAR = 0;
    private static final int RESTAR = 1;
    private static final int MULTIPLICAR = 2;
    private static final int DIVIDIR = 3;

    public static void realizarOperacion(int opcion, double num1, double num2) {
        switch (opcion) {
            case SUMAR -> mostrarMensaje("La suma es ", Calculadora.sumar(num1, num2));
            case RESTAR -> mostrarMensaje("La resta es ", Calculadora.restar(num1, num2));
            case MULTIPLICAR -> mostrarMensaje("La multiplicación es ", Calculadora.multiplicacion(num1, num2));
            case DIVIDIR -> {
                if (num2 != 0) {
                    mostrarMensaje("La división es ", Calculadora.division(num1, num2));
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
        String numeroRedondeadoyString = String.valueOf(numero);
        if (redondear.isSelected()) {
            numeroRedondeadoyString = Calculadora.redondear(numero);
        }
        JOptionPane.showMessageDialog(null, mensaje + numeroRedondeadoyString, "Calculadora", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int mostrarMenu() {
        int opcion = JOptionPane.showOptionDialog(null, "¿Qué operación desea realizar?", "Calculadora", 0, JOptionPane.QUESTION_MESSAGE, null, OPCIONES, null);

        if (opcion == JOptionPane.CLOSED_OPTION) {
            System.exit(opcion);
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
                e.printStackTrace();
            }
        } while (!numeroValido);

        return numeroARetornar;
    }
}
