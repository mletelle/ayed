package tp06.ejercicio1;

import tp06.Arista;
import tp06.Vertice;

public class AristaImpl<T> implements Arista<T> {
    private final Vertice<T> destino;
    private final int peso;

    public AristaImpl(Vertice<T> destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public Vertice<T> verticeDestino() {
        return this.destino;
    }

    @Override
    public int peso() {
        return this.peso;
    }
}
