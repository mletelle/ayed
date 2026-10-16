package tp06.ejercicio1;

import tp06.*;

public class VerticeImplMatrizAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T dato) {
        this.dato = dato;
        this.posicion = -1;
    }

    public T dato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}