package tp02.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp02.ArbolGeneral;

public class RecorridosAG {
    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden
            (ArbolGeneral<Integer> a, Integer n) {
    /*Metodo que retorna una lista con los elementos impares del árbol “a” que sean
    mayores al valor “n” pasados como parámetros, recorrido en preorden.*/
        ListaGenerica<Integer> impares = new ListaEnlazadaGenerica<>();
        preOrden(a, n, impares);
        return impares;
    }

    private void preOrden(ArbolGeneral<Integer> arbol, Integer n, ListaGenerica<Integer> impares) {
        if (arbol == null || arbol.esVacio()) {
            return;
        }
        Integer dato = arbol.getDato();
        if (esImpar(dato) && dato > n) {
            impares.agregarFinal(dato);
        }
        ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
        hijos.comenzar();
        while (!hijos.fin()) {
            ArbolGeneral<Integer> hijo = hijos.proximo();
            preOrden(hijo, n, impares);
        }
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden
            (ArbolGeneral<Integer> a, Integer n) {
    /*Metodo que retorna una lista con los elementos impares del árbol “a” que sean
    mayores al valor “n” pasados como parámetros, recorrido en inorden.*/
        ListaGenerica<Integer> impares = new ListaEnlazadaGenerica<>();
        inOrden(a, n, impares);
        return impares;
    }

    private void inOrden(ArbolGeneral<Integer> arbol, Integer n, ListaGenerica<Integer> impares) {
        if (arbol == null || arbol.esVacio()) {
            return;
        }
        ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
        hijos.comenzar();
        if (!hijos.fin()) {
            ArbolGeneral<Integer> hijo = hijos.proximo();
            inOrden(hijo, n, impares);
        }
        Integer dato = arbol.getDato();
        if (esImpar(dato) && dato > n) {
            impares.agregarFinal(dato);
        }
        while (!hijos.fin()) {
            ArbolGeneral<Integer> hijo = hijos.proximo();
            inOrden(hijo, n, impares);
        }
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden
            (ArbolGeneral<Integer> a, Integer n) {
    /*Metodo que retorna una lista con los elementos impares del árbol “a” que sean
    mayores al valor “n” pasados como parámetros recorrido en postorden.*/
        ListaGenerica<Integer> impares = new ListaEnlazadaGenerica<>();
        postOrden(a, n, impares);
        return impares;
    }

    private void postOrden(ArbolGeneral<Integer> arbol, Integer n, ListaGenerica<Integer> impares) {
        if (arbol == null || arbol.esVacio()) {
            return;
        }
        ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
        hijos.comenzar();
        while (!hijos.fin()) {
            ArbolGeneral<Integer> hijo = hijos.proximo();
            postOrden(hijo, n, impares);
        }
        Integer dato = arbol.getDato();
        if (esImpar(dato) && dato > n) {
            impares.agregarFinal(dato);
        }
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles
            (ArbolGeneral<Integer> a, Integer n) {
    /*Metodo que retorna una lista con los elementos impares del árbol “a” que sean
    mayores al valor “n” pasados como parámetros, recorrido por niveles.*/
        ListaGenerica<Integer> impares = new ListaEnlazadaGenerica<>();
        if (a == null || a.esVacio()) {
            return impares;
        }
        ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<>();
        cola.encolar(a);
        while (!cola.esVacia()) {
            ArbolGeneral<Integer> actual = cola.desencolar();
            Integer dato = actual.getDato();
            if (esImpar(dato) && dato > n) {
                impares.agregarFinal(dato);
            }
            ListaGenerica<ArbolGeneral<Integer>> hijos = actual.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                ArbolGeneral<Integer> hijo = hijos.proximo();
                cola.encolar(hijo);
            }
        }
        return impares;
    }

    boolean esImpar(Integer n) {
        if (n % 2 == 0) {
            return false;
        }
        return true;
    }
}
