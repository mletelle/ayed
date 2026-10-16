package tp06.ejercicio1;

import tp06.*;
import tp01.ejercicio2.*;

public class VerticeImplListAdy<T> implements Vertice<T> {
    private T dato;
    private int posicion;
    private ListaGenerica<Arista<T>> adyacentes;

    public VerticeImplListAdy(T dato) {
        this.dato = dato;
        this.posicion = -1;
        this.adyacentes = new ListaEnlazadaGenerica<>();
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

    public void setPosicion(int pos) {
        this.posicion = pos;
    }

    //public void conectar(){}
    //public void conectar(){}
    public void desconectar() {
    }
    //public ListaGenerica<Arista<T>>
}