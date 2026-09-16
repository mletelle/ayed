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

    public static class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
        private T dato;
        private ArbolBinarioDeBusqueda<T> hijoIzquierdo;
        private ArbolBinarioDeBusqueda<T> hijoDerecho;


        public ArbolBinarioDeBusqueda() {
            super();
        }

        public ArbolBinarioDeBusqueda(T dato) {
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
        public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
            return this.hijoIzquierdo;
        }

        public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
            return this.hijoDerecho;

        }

        private void setHijoIzquierdo(ArbolBinarioDeBusqueda<T> hijo) {
            this.hijoIzquierdo = hijo;

        }


        private void setHijoDerecho(ArbolBinarioDeBusqueda<T> hijo) {
            this.hijoDerecho = hijo;

        }


        public boolean incluye(Comparable<T> dato) {
            return this.buscar(dato, this) != null;
        }


        public ArbolBinarioDeBusqueda<T> buscar(Comparable<T> x, ArbolBinarioDeBusqueda<T> arbol) {
            if (arbol != null) {
                if (x.compareTo(arbol.getDato()) < 0) {
                    arbol = this.buscar(x, arbol.getHijoIzquierdo());
                } else if (x.compareTo(arbol.getDato()) > 0) {
                    arbol = this.buscar(x, arbol.getHijoDerecho());
                } else
                    ; // Se encontro el dato, asi que es arbol
                return arbol;
            } else {
                return null;
            }
        }

        public void agregar(Comparable<T> dato) {
            // TO DO

        }

        private void agregar(Comparable<T> dato, ArbolBinarioDeBusqueda<T> arbol) {
            // TO DO

        }

        public ArbolBinarioDeBusqueda<T> buscarMayorDeLosMenores(ArbolBinarioDeBusqueda<T> arbol) {
            // TO DO
            return null;
        }

        public ArbolBinarioDeBusqueda<T> buscarMayor(ArbolBinarioDeBusqueda<T> arbol) {
            // TO DO
            return null;
        }

        public ArbolBinarioDeBusqueda<T> buscarMenorDeLosMayores(ArbolBinarioDeBusqueda<T> arbol) {
            // TO DO
            return null;
        }

        public ArbolBinarioDeBusqueda<T> buscarMenor(ArbolBinarioDeBusqueda<T> arbol) {
            // TO DO
            return null;
        }

        @Override
        public String toString() {
            return this.getDato().toString();
        }

        public boolean esVacio() {
            return this.dato == null && this.esHoja();
        }

        public boolean esHoja() {
            return this.hijoIzquierdo == null && this.hijoDerecho == null;
        }


    }
}
