package dominio;

import java.text.DecimalFormat;

public class Calculadora {
    private static final int decimales = 2;

    public double sumar(double numero1, double numero2) {
        return numero1 + numero2;
    }

    public double restar(double numero1, double numero2) {
        return numero1 - numero2;
    }

    public double multiplicacion(double numero1, double numero2) {
        return numero1 * numero2;
    }

    public double division(double numero1, double numero2) {
        try {
            if (numero2 == 0) {
                throw new ArithmeticException("No se puede dividir entre cero");
            }

            return numero1 / numero2;
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
            return Double.NaN;
        }
    }

    public String redondear(double numero) {
        DecimalFormat formato = new DecimalFormat("#.##");
        return formato.format(numero);
    }
}
