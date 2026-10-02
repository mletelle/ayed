package tp05.ejercicio1;

public interface ColaPrioridades<T> {
    // indica si la cola esta vacia, retorna true si no tiene elementos
    boolean esVacia();

    // agrega el elemento que se desea incorporar respetando el orden,recibe el elemento, retorna true si se cumplio la operacion
    boolean agregar(T e);

    // elimina el tope y reordena
    void eliminar();

    // devuelve el elemento del tope sin eliminarlo, retorna elemento de mayor prioridad
    T tope();

}
