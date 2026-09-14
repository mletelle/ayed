package tp03ab;

import tp01.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
    private T dato;
    private ArbolBinario<T> hijoIzquierdo;
    private ArbolBinario<T> hijoDerecho;


    public ArbolBinario() {
        super();
    }

    public ArbolBinario(T dato) {
        this.dato = dato;
    }

    /*
     * getters y setters
     *
     */
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Preguntar antes de invocar si tieneHijoIzquierdo()
     *
     * @return
     */
    public ArbolBinario<T> getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public ArbolBinario<T> getHijoDerecho() {
        return this.hijoDerecho;

    }

    public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
        this.hijoIzquierdo = hijo;
    }

    public void agregarHijoDerecho(ArbolBinario<T> hijo) {
        this.hijoDerecho = hijo;
    }

    public void eliminarHijoIzquierdo() {
        this.hijoIzquierdo = null;
    }

    public void eliminarHijoDerecho() {
        this.hijoDerecho = null;
    }

    public boolean esVacio() {
        return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
    }

    public boolean esHoja() {
        return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

    }

    @Override
    public String toString() {
        return this.getDato().toString();
    }


    public boolean tieneHijoIzquierdo() {
        return this.hijoIzquierdo != null;
    }


    public boolean tieneHijoDerecho() {
        return this.hijoDerecho != null;
    }

    public int contarHojas() {
        if (this.esVacio()) {
            return 0;
        }
        if (this.esHoja()) {
            return 1;
        }
        int qHojas = 0;
        if (this.tieneHijoIzquierdo()) {
            qHojas += this.getHijoIzquierdo().contarHojas();
        }
        if (this.tieneHijoDerecho()) {
            qHojas += this.getHijoDerecho().contarHojas();
        }
        return qHojas;
    }


    public ArbolBinario<T> espejo() {
        if (this.esVacio()) {
            return new ArbolBinario<T>();
        }
        ArbolBinario<T> arbolEspejo = new ArbolBinario<T>(this.getDato());
        if (this.tieneHijoDerecho()) {
            arbolEspejo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
        }
        if (this.tieneHijoIzquierdo()) {
            arbolEspejo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
        }
        return arbolEspejo;
    }


    public void entreNiveles(int n, int m) {
        if (this.esVacio()) {
            return;
        }
        ColaGenerica<ArbolBinario<T>> colaArboles = new ColaGenerica<>();
        ColaGenerica<Integer> colaNivel = new ColaGenerica<>();
        colaArboles.encolar(this);
        colaNivel.encolar(0);
        while (!colaArboles.esVacia()) {
            ArbolBinario<T> actual = colaArboles.desencolar();
            int nivel = colaNivel.desencolar();
            if (nivel >= n && nivel <= m) System.out.println(actual.getDato());
            if (nivel < m) {
                if (actual.tieneHijoIzquierdo()) {
                    colaArboles.encolar(actual.getHijoIzquierdo());
                    colaNivel.encolar(nivel + 1);
                }
                if (actual.tieneHijoDerecho()) {
                    colaArboles.encolar(actual.getHijoDerecho());
                    colaNivel.encolar(nivel + 1);
                }
            }
        }
    }
}
