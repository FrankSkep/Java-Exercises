package Modelos;

public class Enfermera extends Empleado {

    private String area;

    public Enfermera(String nombre, String apellido, int edad, int id, double salario, int horario, String area) {
        super(nombre, apellido, edad, id, salario, horario);
        this.area = area;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Area : " + area);
    }

}
