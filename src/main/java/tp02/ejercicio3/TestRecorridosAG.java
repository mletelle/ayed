package tp02.ejercicio3;

import tp01.ejercicio2.ListaGenerica;
import tp02.ArbolGeneral;

public class TestRecorridosAG {
    public static void main(String[] args) {
        ArbolGeneral<Integer> raiz = new ArbolGeneral<>(10);
        ArbolGeneral<Integer> h1 = new ArbolGeneral<>(7);
        ArbolGeneral<Integer> h2 = new ArbolGeneral<>(12);
        ArbolGeneral<Integer> h3 = new ArbolGeneral<>(15);
        raiz.agregarHijo(h1);
        raiz.agregarHijo(h2);
        raiz.agregarHijo(h3);
        ArbolGeneral<Integer> h4 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> h5 = new ArbolGeneral<>(21);
        ArbolGeneral<Integer> h6 = new ArbolGeneral<>(11);
        h2.agregarHijo(h4);
        h2.agregarHijo(h5);
        h3.agregarHijo(h6);
        RecorridosAG recorridos = new RecorridosAG();
        ListaGenerica<Integer> preorden = recorridos.numerosImparesMayoresQuePreOrden(raiz, 6);
        while (!preorden.fin()) {
            System.out.println(preorden.proximo());
        }
        System.out.println("-----");
        ListaGenerica<Integer> inorden = recorridos.numerosImparesMayoresQueInOrden(raiz, 6);
        while (!inorden.fin()) {
            System.out.println(inorden.proximo());
        }
        System.out.println("-----");
        ListaGenerica<Integer> postorden = recorridos.numerosImparesMayoresQuePostOrden(raiz, 6);
        while (!postorden.fin()) {
            System.out.println(postorden.proximo());
        }
        System.out.println("-----");
        ListaGenerica<Integer> niveles = recorridos.numerosImparesMayoresQuePorNiveles(raiz, 6);
        while (!niveles.fin()) {
            System.out.println(niveles.proximo());
        }
    }
}
