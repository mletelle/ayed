package tp01.ejercicio2;

public class TestListaEnlazadaGenerica {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("12345", "Juan", "Perez");
        Estudiante e2 = new Estudiante("67890", "Maria", "Gomez");
        Estudiante e3 = new Estudiante("54321", "Pedro", "Lopez");
        Estudiante e4 = new Estudiante("98765", "Ana", "Martinez");
        ListaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<>();
        lista.agregarFinal(e1);
        lista.agregarEn(e2, 1);
        lista.agregarInicio(e3);
        lista.agregarFinal(e4);
        for (int i = 1; i <= lista.tamanio(); i++) {
            Estudiante e = lista.elemento(i);
            System.out.println(e.tusDatos());
        }
    }
}
