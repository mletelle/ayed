package tp05.ejercicio1;

import tp01.ejercicio2.ListaGenerica;

public class MaxHeap<T extends Comparable<T>> implements ColaPrioridades<T> {
    private T[] datos;
    private int cantEltos;

    public MaxHeap() {
        this.datos = (T[]) new Comparable[100];
        this.cantEltos = 0;
    }

    public MaxHeap(ListaGenerica<T> lista) {
        this.datos = (T[]) new Comparable[100];
        this.cantEltos = 0;
        lista.comenzar();
        while (!lista.fin()) {
            this.datos[this.cantEltos] = lista.proximo();
            cantEltos++;
        }
        for (int i = cantEltos / 2 - 1; i >= 0; i--) {
            percolate_down(i);
        }
    }

    private void percolate_down(int i) {
        int hijoIzq = 2 * i + 1;
        while (hijoIzq < cantEltos) {
            int hijoDer = hijoIzq + 1;
            int hijoMayor = hijoIzq;
            if (hijoDer < cantEltos && datos[hijoDer].compareTo(datos[hijoIzq]) > 0) {
                hijoMayor = hijoDer;
            }
            if (datos[i].compareTo(datos[hijoMayor]) >= 0) {
                break;
            }
            T auxiliar = datos[i];
            datos[i] = datos[hijoMayor];
            datos[hijoMayor] = auxiliar;
            i = hijoMayor;
            hijoIzq = 2 * i + 1;
        }
    }

    private void percolate_up() {
        int i = cantEltos - 1;
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (datos[i].compareTo(datos[padre]) <= 0) {
                break;
            }
            T auxiliar = datos[i];
            datos[i] = datos[padre];
            datos[padre] = auxiliar;
            i = padre;
        }
    }

    @Override
    public boolean agregar(T e) {
        if (e == null || cantEltos >= datos.length) {
            return false;
        }
        datos[cantEltos] = e;
        cantEltos++;
        percolate_up();
        return true;
    }

    public void imprimir() {
    }

    @Override
    public boolean esVacia() {
        return cantEltos == 0;
    }


    @Override
    public void eliminar() {

    }

    @Override
    public T tope() {
        return null;
    }


}
