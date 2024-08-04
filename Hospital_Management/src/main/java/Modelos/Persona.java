package Modelos;

public class Persona {

    protected String nombre, apellido;
    protected int edad, id;

    public Persona(String nombre, String apellido, int edad, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id = id;
    }

    public void mostrarInfo() {
        System.out.println("Nombre : " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad : " + edad);
        System.out.println("ID : " + id);
    }

    public String getName() {
        return this.nombre;
    }

    public int getID() {
        return this.id;
    }

}
