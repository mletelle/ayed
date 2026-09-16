package tp03.ejercicio3;

import tp03ab.ArbolBinario;
import tp01.ejercicio2.*;

public class ContadorArbol {
    private ArbolBinario<Integer> arbol;

    public ContadorArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public ListaGenerica<Integer> numerosPares() {
        ListaGenerica<Integer> pares = new ListaEnlazadaGenerica<>();
        numerosParesInOrden(this.arbol, pares);
        //numerosParesPostOrden(this.arbol, pares);
        return pares;
    }

    private void numerosParesInOrden(ArbolBinario<Integer> arbol, ListaGenerica<Integer> pares) {
        if (arbol == null || arbol.esVacio()) return;
        if (arbol.tieneHijoIzquierdo()) numerosParesInOrden(arbol.getHijoIzquierdo(), pares);
        if (esPar(arbol.getDato())) pares.agregarFinal(arbol.getDato());
        if (arbol.tieneHijoDerecho()) numerosParesInOrden(arbol.getHijoDerecho(), pares);
    }

    private void numerosParesPostOrden(ArbolBinario<Integer> arbol, ListaGenerica<Integer> pares) {
        if (arbol == null || arbol.esVacio()) return;
        if (arbol.tieneHijoIzquierdo()) numerosParesPostOrden(arbol.getHijoIzquierdo(), pares);
        if (arbol.tieneHijoDerecho()) numerosParesPostOrden(arbol.getHijoDerecho(), pares);
        if (esPar(arbol.getDato())) pares.agregarFinal(arbol.getDato());
    }

    private boolean esPar(Integer dato) {
        return dato % 2 == 0;
    }
}
