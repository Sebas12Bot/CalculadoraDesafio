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
        return numero1 / numero2;
    }

    public String redondear(double numero) {
        DecimalFormat formato = new DecimalFormat("#.##");
        return formato.format(numero);
    }
}
