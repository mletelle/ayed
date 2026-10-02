package tp05.ejercicio1;

public class MinHeap<T extends Comparable<T>> implements ColaPrioridades {
    private T[] datos;
    private int cantEltos;

    @Override
    public boolean esVacia() {
        return cantEltos == 0;
    }

    @Override
    public boolean agregar(Object e) {
        return false;
    }

    @Override
    public void eliminar() {

    }

    @Override
    public Object tope() {
        return null;
    }
}
