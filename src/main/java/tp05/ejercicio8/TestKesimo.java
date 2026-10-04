package tp05.ejercicio8;

import tp01.ejercicio2.ListaEnlazadaGenerica;

public class TestKesimo {

    public static void main(String[] args) {
        ListaEnlazadaGenerica<Integer> numeros = new ListaEnlazadaGenerica<>();
        numeros.agregarFinal(4);
        numeros.agregarFinal(9);
        numeros.agregarFinal(2);
        numeros.agregarFinal(9);
        numeros.agregarFinal(7);
        System.out.println("2do mayor: " + Kesimo.encontrarKesimoMayor(numeros, 2)); // 9
        ListaEnlazadaGenerica<Integer> otrosNumeros = new ListaEnlazadaGenerica<>();
        otrosNumeros.agregarFinal(6);
        otrosNumeros.agregarFinal(1);
        otrosNumeros.agregarFinal(8);
        otrosNumeros.agregarFinal(3);
        System.out.println("3er mayor: " + Kesimo.encontrarKesimoMayor(otrosNumeros, 3)); // 3
    }
}
