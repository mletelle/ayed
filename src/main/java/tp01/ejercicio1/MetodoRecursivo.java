package tp01.ejercicio1;

public class MetodoRecursivo {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
        lista.agregarFinal(1);
        lista.agregarFinal(2);
        lista.agregarFinal(3);
        lista.agregarFinal(4);
        lista.agregarFinal(5);
        lista.agregarFinal(6);
        lista.agregarFinal(7);
        lista.agregarFinal(8);
        lista.agregarFinal(9);
        lista.comenzar();
        imprimirRecursivo(lista);
    }

    private static void imprimirRecursivo(ListaDeEnteros lista) {
        if (!lista.fin()) {
            int elemActual = lista.proximo();
            imprimirRecursivo(lista);
            System.out.println(elemActual);
        }
    }
}
