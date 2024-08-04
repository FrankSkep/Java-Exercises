package Servicio;

import Utils.Lib;
import Utils.Menu;
import Modelos.CitaMedica;
import Modelos.Medico;
import Modelos.Paciente;

public class Gestion_Citas {

    // Programar una cita para un paciente con un medico especifico
    public static void programarCita(Hospital hospital) {
        hospital.listarPacientes();
        int idPac = Lib.getInt("> Ingresa ID paciente a citar: ");
        System.out.println();

        hospital.listarMedicos();
        int idMed = Lib.getInt("> Ingresa ID del medico: ");
        System.out.println();

        String fecha = Lib.getString("> Ingresa fecha de cita (DD/MM/AAAA): ");
        String hora = Lib.getString("> Ingresa hora de cita (HH:MM): ");

        // Verificar si existe el medico y paciente
        Medico medico = hospital.buscarMedico(idMed);
        Paciente paciente = hospital.buscarPaciente(idPac);

        if (medico != null && paciente != null) {
            medico.agregarPaciente(paciente); // Se asigna el paciente al medico
            hospital.registrarCita(new CitaMedica(fecha, hora, paciente, medico)); // Se agrega la cita
        } else {
            System.out.println("* No se encontro el medico o paciente");
        }
    }

    // Editar cita
    public static void editarCita(Hospital hospital) {

        int id = Lib.getInt("> Ingrese ID del paciente de la cita: ");
        CitaMedica cita = hospital.consultarCita(id);

        if (cita != null) {

            System.out.println("+- Editar Cita -+");
            System.out.println("1. Fecha");
            System.out.println("2. Hora");
            System.out.println("0. Cancelar");

            int opcion = Lib.getInt("> Ingrese campo a editar: ");

            switch (opcion) {
                case 1 ->
                    cita.setFecha(Lib.getString("> Ingrese nueva fecha (DD/MM/AAAA): "));

                case 2 ->
                    cita.setHora(Lib.getString("> Ingrese nueva hora (HH:MM): "));

                case 0 -> {
                    return;
                }
                default ->
                    System.out.println("Opcion no valida.");
            }

            System.out.println("Cita actualizada.");

        } else {
            System.out.println("No se encontro cita para el paciente con ID " + id);
        }
    }

    // Menu de acciones para gestionar citas
    public static void gestionarCitas(Hospital hospital) {
        int accion;
        do {
            Lib.clear();
            accion = Menu.menuCitas();
            Lib.clear();
            switch (accion) {
                case 1 -> {
                    Gestion_Citas.programarCita(hospital);
                    System.out.println("* Cita programada. *");
                }
                case 2 -> {
                    int id = Lib.getInt("> Ingrese ID de paciente a consultar cita: ");
                    CitaMedica cita = hospital.consultarCita(id);
                    if (cita != null) {
                        cita.mostrarDetallesCita();
                    } else {
                        System.out.println("* Cita no encontrada. *");
                    }
                }
                case 3 ->
                    Gestion_Citas.editarCita(hospital);
                case 4 ->
                    hospital.listarCitas();
                case 0 ->
                    System.out.println("Has salido.");
                default ->
                    System.out.println("Opcion no valida.");
            }
            if (accion != 0) {
                Lib.pause();
            }
        } while (accion != 0);
    }
}
