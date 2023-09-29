package app;

import dominio.Calculadora;
import dominio.Funciones;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int cantidadNumeros = Funciones.preguntarCantidadNumeros();

        while (true) {
            int opcionElegida = Funciones.mostrarMenu();
            double[] numeros = obtenerNumeros(cantidadNumeros);
            realizarOperacionYMostrarResultado(opcionElegida, calculadora, numeros);
        }
    }

    private static double[] obtenerNumeros(int cantidadNumeros) {
        double[] numeros = new double[cantidadNumeros];
        for (int i = 0; i < cantidadNumeros; i++) {
            numeros[i] = Funciones.recibirNumero("Ingrese el número " + (i + 1));
        }
        return numeros;
    }

    private static void realizarOperacionYMostrarResultado(int opcion, Calculadora calculadora, double[] numeros) {
        double resultado = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            switch (opcion) {
                case 0 -> resultado = calculadora.sumar(resultado, numeros[i]);
                case 1 -> resultado = calculadora.restar(resultado, numeros[i]);
                case 2 -> resultado = calculadora.multiplicacion(resultado, numeros[i]);
                case 3 -> {
                    if (numeros[i] != 0) {
                        resultado = calculadora.division(resultado, numeros[i]);
                    } else {
                        Funciones.mostrarError("No se puede dividir entre cero");
                        return;
                    }
                }
            }
        }
        Funciones.mostrarMensaje("El resultado es ", resultado);
    }
}
