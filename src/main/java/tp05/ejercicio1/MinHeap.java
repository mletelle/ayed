package tp05.ejercicio1;

import tp01.ejercicio2.ListaGenerica;

public class MinHeap<T extends Comparable<T>> implements ColaPrioridades<T> {

    private T[] datos;
    private int cantEltos;

    public MinHeap() {
        this.datos = (T[]) new Comparable[100];
        this.cantEltos = 0;
    }

    public MinHeap(ListaGenerica<T> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("Lista null");
        }
        int capacidad = 100;
        if (lista.tamanio() > capacidad) {
            capacidad = lista.tamanio();
        }
        this.datos = (T[]) new Comparable[capacidad];
        this.cantEltos = 0;
        lista.comenzar();
        while (!lista.fin()) {
            T elemento = lista.proximo();
            if (elemento == null) {
                throw new IllegalArgumentException("Null");
            }
            this.datos[this.cantEltos] = elemento;
            cantEltos++;
        }
        for (int i = cantEltos / 2 - 1; i >= 0; i--) {
            percolate_down(i);
        }
    }

    @Override
    public boolean esVacia() {
        return cantEltos == 0;
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

    private void percolate_down(int i) {
        int hijoIzq = 2 * i + 1;
        while (hijoIzq < cantEltos) {
            int hijoDer = hijoIzq + 1;
            int hijoMenor = hijoIzq;
            if (hijoDer < cantEltos && datos[hijoDer].compareTo(datos[hijoIzq]) < 0) {
                hijoMenor = hijoDer;
            }
            if (datos[i].compareTo(datos[hijoMenor]) <= 0) {
                break;
            }
            T auxiliar = datos[i];
            datos[i] = datos[hijoMenor];
            datos[hijoMenor] = auxiliar;
            i = hijoMenor;
            hijoIzq = 2 * i + 1;
        }
    }

    private void percolate_up() {
        int i = cantEltos - 1;
        while (i > 0) {
            int padre = (i - 1) / 2;
            if (datos[i].compareTo(datos[padre]) >= 0) {
                break;
            }
            T auxiliar = datos[i];
            datos[i] = datos[padre];
            datos[padre] = auxiliar;
            i = padre;
        }
    }

    @Override
    public void eliminar() {
        if (this.esVacia())return;
        cantEltos--;
        datos[0] = datos[cantEltos];
        datos[cantEltos] = null;
        percolate_down(0);
    }

    @Override
    public T tope() {
        return datos[0];// si vacio null igualmente porque el arreglo esta inicializado
    }

    public void imprimir() {
        if (cantEltos > 0) {
            for (int i = 0; i < cantEltos; i++) {
                System.out.print(datos[i].toString() + ", ");
            }
        }
    }
}
