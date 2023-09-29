package app;

import dominio.Calculadora;
import dominio.Funciones;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int cantidadNumeros = Funciones.preguntarCantidadNumeros();

        while (true) {
            int opcionElegida = Funciones.mostrarMenu();
            double[] numeros = Funciones.obtenerNumeros(cantidadNumeros);
            Funciones.realizarOperacionYMostrarResultado(opcionElegida, calculadora, numeros);
        }
    }
}
