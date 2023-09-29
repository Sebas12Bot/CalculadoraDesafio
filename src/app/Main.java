package app;

import dominio.Calculadora;
import dominio.Funciones;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        while (true) {
            int opcionElegida = Funciones.mostrarMenu();
            double n1 = Funciones.recibirNumero("Ingrese el primer número");
            double n2 = Funciones.recibirNumero("Ingrese el segundo número");
            Funciones.realizarOperacion(opcionElegida, n1, n2);
        }
    }
}
