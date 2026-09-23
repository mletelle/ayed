package tp03.ejercicio4;

import tp03ab.ArbolBinario;

public class RedBinariaLlena {
    private ArbolBinario<Integer> arbol;    // precondicion: se asume ab lleno

    public RedBinariaLlena(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio() {
        return calcularRetardo(this.arbol);
    }

    private int calcularRetardo(ArbolBinario<Integer> arbol) {
        if (arbol == null || arbol.esVacio()) return 0;
        if (arbol.esHoja()) return arbol.getDato();
        int retIzquierdo = 0;
        int retDerecho = 0;
        if (arbol.tieneHijoIzquierdo()) retIzquierdo = calcularRetardo(arbol.getHijoIzquierdo());
        if (arbol.tieneHijoDerecho()) retDerecho = calcularRetardo(arbol.getHijoDerecho());
        return arbol.getDato() + Math.max(retIzquierdo, retDerecho);
    }
}
