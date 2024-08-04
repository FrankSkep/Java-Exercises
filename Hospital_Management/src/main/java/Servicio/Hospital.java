package Servicio;

import Modelos.Medico;
import Modelos.Enfermera;
import Modelos.CitaMedica;
import Modelos.Paciente;
import java.util.ArrayList;

public class Hospital {

    /*--------- LISTAS DE LAS ENTIDADES DEL SISTEMA ---------*/
    private static ArrayList<Medico> medicos;
    private static ArrayList<Enfermera> enfermeras;
    private static ArrayList<Paciente> pacientes;
    private static ArrayList<CitaMedica> citas;

    // Constructor
    public Hospital() {
        medicos = new ArrayList<>();
        enfermeras = new ArrayList<>();
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();
    }

    /*--------- REGISTROS ---------*/
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agregarEnfermera(Enfermera enfer) {
        enfermeras.add(enfer);
    }

    public void registrarCita(CitaMedica cita) {
        citas.add(cita); // Se agrega la cita
    }

    /*--------- BUSQUEDA ---------*/
    public Paciente buscarPaciente(int id) {
        for (Paciente pac : pacientes) {
            if (pac.getID() == id) {
                return pac;
            }
        }
        return null;
    }

    public Medico buscarMedico(int id) {
        for (Medico med : medicos) {
            if (med.getID() == id) {
                return med;
            }
        }
        return null;
    }

    public Enfermera buscarEnfermera(int id) {
        for (Enfermera enf : enfermeras) {
            if (enf.getID() == id) {
                return enf;
            }
        }
        return null;
    }

    public CitaMedica consultarCita(int id) {
        for (CitaMedica cita : citas) {
            if (cita.getIdCita() == id) {
                return cita;
            }
        }
        return null;
    }

    /*--------- LISTADO DE ENTIDADES ---------*/
    public void listarPacientes() {
        if (!pacientes.isEmpty()) {
            for (Paciente pac : pacientes) {
                System.out.println("Nombre: " + pac.getName() + " - ID: " + pac.getID());
            }
        } else {
            System.out.println("No hay pacientes registrados.");
        }
    }

    public void listarMedicos() {
        if (!medicos.isEmpty()) {
            for (Medico med : medicos) {
                System.out.println("Nombre: " + med.getName() + " - ID: " + med.getID());
            }
        } else {
            System.out.println("No hay pacientes registrados.");
        }
    }

    public void listarEnfermeras() {
        if (!enfermeras.isEmpty()) {
            for (Enfermera enf : enfermeras) {
                System.out.println("Enfermera: " + enf.getName() + " - ID: " + enf.getID());
            }
        } else {
            System.out.println("No hay pacientes registrados.");
        }
    }

    public void listarCitas() {
        if (!citas.isEmpty()) {
            for (CitaMedica cita : citas) {
                cita.mostrarDetallesCita();
            }
        }
    }
}
