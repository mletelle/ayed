package tp03.ejercicio2;

import tp03ab.ArbolBinario;

public class TestArbolBinario {
    public static void main(String[] args) {
        ArbolBinario<Integer> raiz = new ArbolBinario<>(1);
        ArbolBinario<Integer> nodo1 = new ArbolBinario<>(2);
        ArbolBinario<Integer> nodo2 = new ArbolBinario<>(3);
        ArbolBinario<Integer> nodo3 = new ArbolBinario<>(4);
        ArbolBinario<Integer> nodo4 = new ArbolBinario<>(5);
        ArbolBinario<Integer> nodo5 = new ArbolBinario<>(6);
        ArbolBinario<Integer> nodo6 = new ArbolBinario<>(7);
        ArbolBinario<Integer> nodo7 = new ArbolBinario<>(8);
        raiz.agregarHijoIzquierdo(nodo1);
        raiz.agregarHijoDerecho(nodo2);
        nodo1.agregarHijoIzquierdo(nodo3);
        nodo1.agregarHijoDerecho(nodo4);
        nodo2.agregarHijoIzquierdo(nodo5);
        nodo2.agregarHijoDerecho(nodo6);
        nodo3.agregarHijoIzquierdo(nodo6);
        nodo3.agregarHijoDerecho(nodo7);
        System.out.println("-----");
        System.out.println(raiz.contarHojas());
        System.out.println("-----");
        raiz.entreNiveles(1, 2);
        System.out.println("-----");
        ArbolBinario<Integer> espejo = raiz.espejo();
        espejo.entreNiveles(0, 3);
        System.out.println("-----");
        raiz.entreNiveles(0, 3);

    }
}
