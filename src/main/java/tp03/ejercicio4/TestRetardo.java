package tp03.ejercicio4;

import tp03ab.ArbolBinario;
import tp03ab.ArbolBinario;

public class TestRetardo {
    public static void main(String[] args) {
        ArbolBinario<Integer> raiz = new ArbolBinario<>(1);
        ArbolBinario<Integer> nodo1 = new ArbolBinario<>(2);
        ArbolBinario<Integer> nodo2 = new ArbolBinario<>(3);
        ArbolBinario<Integer> nodo3 = new ArbolBinario<>(4);
        ArbolBinario<Integer> nodo4 = new ArbolBinario<>(5);
        ArbolBinario<Integer> nodo5 = new ArbolBinario<>(6);
        ArbolBinario<Integer> nodo6 = new ArbolBinario<>(7);
        raiz.agregarHijoIzquierdo(nodo1);
        raiz.agregarHijoDerecho(nodo2);
        nodo1.agregarHijoIzquierdo(nodo3);
        nodo1.agregarHijoDerecho(nodo4);
        nodo2.agregarHijoIzquierdo(nodo5);
        nodo2.agregarHijoDerecho(nodo6);
        RedBinariaLlena retardo = new RedBinariaLlena(raiz);
        System.out.println(retardo.retardoReenvio());
    }
}

/*           1
 *       2       3
 *   4   5       6   7(11)
 * */