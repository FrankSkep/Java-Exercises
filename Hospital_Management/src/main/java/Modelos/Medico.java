package Modelos;

import java.util.ArrayList;

public class Medico extends Empleado {

    private String especialidad;
    private ArrayList<Paciente> listaPacientes;

    // Constructor
    public Medico(String nombre, String apellido, int edad, int id, double salario, int horario,
            String especialidad) {
        super(nombre, apellido, edad, id, salario, horario);
        this.especialidad = especialidad;
        listaPacientes = new ArrayList<>();
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Especialidad : " + especialidad);
    }

    // Agrega un paciente a la lista de pacientes del medico
    public void agregarPaciente(Paciente paciente) {
        if (!existePaciente(paciente)) {
            listaPacientes.add(paciente);
        } else {
            System.out.println("El paciente ya esta asignado a dicho medico.");
        }
    }

    // Verifica si el paciente ya esta asignado al medico
    public Boolean existePaciente(Paciente paciente) {
        return listaPacientes.contains(paciente);
    }

    // Muestra la lista de pacientes del medico
    public void mostrarListaPacientes() {

        if (!listaPacientes.isEmpty()) {
            for (int i = 0; i < listaPacientes.size(); i++) {
                System.out.println("+-- Paciente #" + (i + 1) + " --+");
                listaPacientes.get(i).mostrarInfo();
                System.out.println();
            }
        } else {
            System.out.println("El medico " + this.nombre + " no tiene pacientes asignados.");
        }
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
