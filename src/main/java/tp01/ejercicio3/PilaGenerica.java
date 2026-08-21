package tp01.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class PilaGenerica<T> {
    private ListaGenerica<T> datos;

    public PilaGenerica() {
        datos = new ListaEnlazadaGenerica<>();
    }

    public void apilar(T t) {
        datos.agregarInicio(t);
    }

    public T desapilar() {
        if (!datos.esVacia()) {
            T dato = datos.elemento(1);
            datos.eliminarEn(1);
            return dato;
        }
        return null;
    }

    public T tope() {
        if (!datos.esVacia()) {
            return datos.elemento(1);
        }
        return null;
    }

    public boolean esVacia() {
        return datos.esVacia();
    }
}
