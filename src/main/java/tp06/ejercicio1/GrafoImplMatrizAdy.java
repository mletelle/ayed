package tp06.ejercicio1;

import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp06.Grafo;
import tp06.Vertice;
import tp06.Arista;

public class GrafoImplMatrizAdy<T> implements Grafo<T> {
    private static final int SIN_ARISTA = -1;
    private int maxVertices;
    private ListaGenerica<Vertice<T>> vertices;
    private int[][] matrizAdy;

    public GrafoImplMatrizAdy(int maxVertices) {
        if (maxVertices < 0) {
            throw new IllegalArgumentException("La capacidad no puede ser negativa");
        }
        this.maxVertices = maxVertices;
        this.vertices = new ListaEnlazadaGenerica<>();
        this.matrizAdy = new int[maxVertices][maxVertices];
        for (int fila = 0; fila < maxVertices; fila++) {
            for (int columna = 0; columna < maxVertices; columna++) {
                this.matrizAdy[fila][columna] = SIN_ARISTA;
            }
        }
    }

    private VerticeImplMatrizAdy<T> buscarVertice(Vertice<T> v) {
        if (v == null) {
            return null;
        }
        this.vertices.comenzar();
        while (!this.vertices.fin()) {
            Vertice<T> actual = this.vertices.proximo();
            if (actual == v) {
                return (VerticeImplMatrizAdy<T>) actual;
            }
        }
        return null;
    }

    @Override
    public void agregarVertice(Vertice<T> v) {
        if (!(v instanceof VerticeImplMatrizAdy<?>)) {
            return;
        }
        if (this.buscarVertice(v) != null) {
            return;
        }
        int posicion = this.vertices.tamanio();
        if (posicion >= this.maxVertices) {
            return;
        }
        if (v.getPosicion() != -1) {
            throw new IllegalArgumentException("El vertice ya tiene una posicion asignada");
        }
        if (this.vertices.agregarFinal(v)) {
            ((VerticeImplMatrizAdy<T>) v).setPosicion(posicion);
        }
    }

    @Override
    public void eliminarVertice(Vertice<T> v) {
        VerticeImplMatrizAdy<T> eliminado = this.buscarVertice(v);
        if (eliminado == null) {
            return;
        }

        int posicion = eliminado.getPosicion();
        int cantidad = this.vertices.tamanio();

        for (int fila = posicion; fila < cantidad - 1; fila++) {
            for (int columna = 0; columna < cantidad; columna++) {
                this.matrizAdy[fila][columna] =
                        this.matrizAdy[fila + 1][columna];
            }
        }
        for (int columna = posicion; columna < cantidad - 1; columna++) {
            for (int fila = 0; fila < cantidad - 1; fila++) {
                this.matrizAdy[fila][columna] =
                        this.matrizAdy[fila][columna + 1];
            }
        }

        int libre = cantidad - 1;
        for (int i = 0; i < this.maxVertices; i++) {
            this.matrizAdy[libre][i] = SIN_ARISTA;
            this.matrizAdy[i][libre] = SIN_ARISTA;
        }

        ListaGenerica<Vertice<T>> restantes = new ListaEnlazadaGenerica<>();
        this.vertices.comenzar();
        int nuevaPosicion = 0;
        while (!this.vertices.fin()) {
            Vertice<T> actual = this.vertices.proximo();
            if (actual != eliminado) {
                restantes.agregarFinal(actual);
                ((VerticeImplMatrizAdy<T>) actual).setPosicion(nuevaPosicion);
                nuevaPosicion++;
            }
        }
        this.vertices = restantes;
        eliminado.setPosicion(-1);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino) {
        this.conectar(origen, destino, 1);
    }

    @Override
    public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
        VerticeImplMatrizAdy<T> o = this.buscarVertice(origen);
        VerticeImplMatrizAdy<T> d = this.buscarVertice(destino);
        if (o == null || d == null) {
            return;
        }
        if (peso == SIN_ARISTA) {
            throw new IllegalArgumentException("El peso -1 esta reservado para ausencia");
        }
        int fila = o.getPosicion();
        int columna = d.getPosicion();
        this.matrizAdy[fila][columna] = peso;
    }

    @Override
    public void desConectar(Vertice<T> origen, Vertice<T> destino) {
        VerticeImplMatrizAdy<T> o = this.buscarVertice(origen);
        VerticeImplMatrizAdy<T> d = this.buscarVertice(destino);

        if (o == null || d == null) {
            return;
        }

        this.matrizAdy[o.getPosicion()][d.getPosicion()] = SIN_ARISTA;
    }

    @Override
    public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
        VerticeImplMatrizAdy<T> o = this.buscarVertice(origen);
        VerticeImplMatrizAdy<T> d = this.buscarVertice(destino);

        if (o == null || d == null) {
            return false;
        }

        return this.matrizAdy[o.getPosicion()][d.getPosicion()] != SIN_ARISTA;
    }

    @Override
    public int peso(Vertice<T> origen, Vertice<T> destino) {
        VerticeImplMatrizAdy<T> o = this.buscarVertice(origen);
        VerticeImplMatrizAdy<T> d = this.buscarVertice(destino);
        if (o == null || d == null) {
            return 0;
        }
        int valor = this.matrizAdy[o.getPosicion()][d.getPosicion()];
        return valor == SIN_ARISTA ? 0 : valor;
    }

    @Override
    public boolean esVacio() {
        return this.vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return this.vertices.clonar();
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v) {
        ListaGenerica<Arista<T>> resultado = new ListaEnlazadaGenerica<>();
        VerticeImplMatrizAdy<T> origen = this.buscarVertice(v);
        if (origen == null) {
            return resultado;
        }
        int fila = origen.getPosicion();
        this.vertices.comenzar();
        while (!this.vertices.fin()) {
            Vertice<T> destino = this.vertices.proximo();
            int columna = destino.getPosicion();
            int peso = this.matrizAdy[fila][columna];
            if (peso != SIN_ARISTA) {
                resultado.agregarFinal(new AristaImpl<>(destino, peso));
            }
        }
        return resultado;
    }

    @Override
    public Vertice<T> vertice(int posicion) {
        if (posicion < 0 || posicion >= this.vertices.tamanio()) {
            return null;
        }
        this.vertices.comenzar();
        int indice = 0;
        while (!this.vertices.fin()) {
            Vertice<T> actual = this.vertices.proximo();

            if (indice == posicion) {
                return actual;
            }

            indice++;
        }

        return null;
    }
}
