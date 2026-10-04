package tp05.ejercicio8;

import tp01.ejercicio2.ListaGenerica;
import tp05.ejercicio1.MaxHeap;

public class Kesimo {

    public static int encontrarKesimoMayor(ListaGenerica<Integer> numeros, int k) {
        if (numeros == null || k < 1 || k > numeros.tamanio()) {
            throw new IllegalArgumentException("K no valido");
        }

        MaxHeap<Integer> heap = new MaxHeap<>(numeros);

        for (int i = 1; i < k; i++) {
            heap.eliminar();
        }

        return heap.tope();
    }
}
