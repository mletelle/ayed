package tp01.ejercicio1;

import tp01.ejercicio1.*;

public class TestListaDeEnterosEnlazada {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        lista.comenzar();
        lista.agregarFinal(1);
        lista.agregarFinal(2);
        lista.agregarFinal(3);
        lista.agregarFinal(4);
        lista.agregarFinal(5);
        lista.agregarFinal(6);
        lista.agregarFinal(7);
        lista.agregarFinal(8);
        lista.agregarFinal(9);
        for (int i = 1; i <= lista.tamanio(); i++) {
            System.out.println(lista.elemento(i));
        }
    }
}
