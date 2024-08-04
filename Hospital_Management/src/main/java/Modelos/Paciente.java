package Modelos;

public class Paciente extends Persona {

    private String historialMedico;
    private int numHab;

    public Paciente(String nombre, String apellido, int edad, int id, String historialMedico, int numHabitacion) {
        super(nombre, apellido, edad, id);
        this.historialMedico = historialMedico;
        this.numHab = numHabitacion;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Num habitacion : " + numHab);
        System.out.println("Historial Medico : " + historialMedico);
    }

    public int getNumHab() {
        return numHab;
    }
}
