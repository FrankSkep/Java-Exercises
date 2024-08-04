package Modelos;

public class Empleado extends Persona {

    protected double salario;
    protected int horarioTrabajo;

    public Empleado(String nombre, String apellido, int edad, int id, double salario, int horario) {
        super(nombre, apellido, edad, id);
        this.salario = salario;
        this.horarioTrabajo = horario;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Salario : " + salario);
        System.out.println("Horario trabajo : " + horarioTrabajo);
    }

}
