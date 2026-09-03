package tp02.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
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

    private void preOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> impares) {
        
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden
            (ArbolGeneral<Integer> a, Integer n) {
    /*Metodo que retorna una lista con los elementos impares del árbol “a” que sean
    mayores al valor “n” pasados como parámetros, recorrido en inorden.*/
        ListaGenerica<Integer> impares = new ListaEnlazadaGenerica<>();

        return impares;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden
            (ArbolGeneral<Integer> a, Integer n) {
    /*Metodo que retorna una lista con los elementos impares del árbol “a” que sean
    mayores al valor “n” pasados como parámetros recorrido en postorden.*/
        ListaGenerica<Integer> impares = new ListaEnlazadaGenerica<>();

        return impares;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles
            (ArbolGeneral<Integer> a, Integer n) {
    /*Metodo que retorna una lista con los elementos impares del árbol “a” que sean
    mayores al valor “n” pasados como parámetros, recorrido por niveles.*/
        ListaGenerica<Integer> impares = new ListaEnlazadaGenerica<>();

        return impares;
    }

    private boolean esImpar(Integer n) {
        if (n % 2 == 0) {
            return false;
        }
        return true;
    }
}
