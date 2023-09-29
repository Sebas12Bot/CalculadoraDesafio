package dominio;

import java.text.DecimalFormat;

public class Calculadora {
    private static final int decimales= 2;
    public static Double sumar(Double numero1,Double numero2){
        return numero1 + numero2;
    }
    public static Double restar(Double numero1,Double numero2){
        return numero1 - numero2;
    }
    public static Double multiplicacion(Double numero1,Double numero2){
        return numero1 * numero2;
    }
    public static Double division(Double numero1,Double numero2){
        return numero1/numero2;
    }
    public static String redondear(double numero){
        DecimalFormat formato = new DecimalFormat("#.##"); // Dos decimales
        return formato.format(numero);
    }

}
