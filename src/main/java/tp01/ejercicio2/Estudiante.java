package tp01.ejercicio2;

public class Estudiante {
    private String legajo;
    private String nombre;
    private String apellido;

    public Estudiante(String legajo, String nombre, String apellido) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String tusDatos() {
        return "Nombre: " + this.nombre + "\nApellido:" + this.apellido + "\nLegajo:" + this.legajo + "\n";
    }
}
