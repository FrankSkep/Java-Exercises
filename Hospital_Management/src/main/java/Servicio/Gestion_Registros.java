package Servicio;

import Utils.Lib;
import Utils.Menu;
import Modelos.Enfermera;
import Modelos.Medico;
import Modelos.Paciente;

public class Gestion_Registros {

    // Pedir datos de paciente
    public static Paciente registrarPaciente() {
        String nombre = Lib.getString("> Ingrese nombre: ");
        String apellido = Lib.getString("> Ingrese apellidos: ");
        int edad = Lib.getInt("> Ingrese edad: ");
        int id = Lib.getInt("> Ingrese ID: ");
        String historial = Lib.getString("> Ingrese historial medico : ");
        int numHab = Lib.getInt("> Ingrese numero de habitacion: ");
        System.out.println("* Paciente registrado con exito. *");
        return new Paciente(nombre, apellido, edad, id, historial, numHab);
    }

    // Pedir datos de medico
    public static Medico registrarMedico() {
        String nombre = Lib.getString("> Ingrese nombre: ");
        String apellido = Lib.getString("> Ingrese apellidos: ");
        int edad = Lib.getInt("> Ingrese edad: ");
        int id = Lib.getInt("> Ingrese ID: ");
        double salario = Lib.getDouble("> Ingrese salario : ");
        int horario = Lib.getInt("> Ingrese horas de trabajo: ");
        String especialidad = Lib.getString("> Ingrese area: ");
        return new Medico(nombre, apellido, edad, id, salario, horario, especialidad);
    }

    // Pedir datos de enfermera
    public static Enfermera registrarEnfermera() {
        String nombre = Lib.getString("> Ingrese nombre: ");
        String apellido = Lib.getString("> Ingrese apellidos: ");
        int edad = Lib.getInt("> Ingrese edad: ");
        int id = Lib.getInt("> Ingrese ID: ");
        double salario = Lib.getDouble("> Ingrese salario : ");
        int horario = Lib.getInt("> Ingrese horas de trabajo: ");
        String area = Lib.getString("> Ingrese especialidad: ");
        System.out.println("* Enfermera registrada con exito. *");
        return new Enfermera(nombre, apellido, edad, id, salario, horario, area);
    }

    // Asignar paciente existente a un medico especifico
    public static void asignarPacienteMedico(Hospital hospital) {
        System.out.println("+-- Asignar paciente a medico: --+");
        int idMed = Lib.getInt("> Ingrese ID de medico: ");
        int idPac = Lib.getInt("> Ingrese ID paciente a asignar: ");

        Medico medico = hospital.buscarMedico(idMed);
        Paciente paciente = hospital.buscarPaciente(idPac);

        if (medico != null) {
            if (paciente != null) {
                medico.agregarPaciente(paciente);
                System.out.println(
                        "* Se asigno el paciente : " + paciente.getName() + " al medico : " + medico.getName() + " *");
            } else {
                System.out.println("El paciente no se encontro");
            }
        } else {
            System.out.println("El medico no se encontro");
        }
    }

    // Mostrar pacientes de un medico especifico
    public static void pacientesDeMedico(Hospital hospital) {
        int id = Lib.getInt("> Ingresa ID medico a consultar: ");

        Medico medico = hospital.buscarMedico(id);

        if (medico != null) {
            medico.mostrarListaPacientes();
        } else {
            System.out.println("No se encontro el medico con ID : " + id);
        }
    }

    /*---------- M E N U S ----------*/
    // Menu de acciones para gestionar pacientes
    public static void gestionarPacientes(Hospital hospital) {
        int accion;
        do {
            Lib.clear();
            accion = Menu.menuPacientes();
            Lib.clear();
            switch (accion) {
                case 1 -> {
                    hospital.agregarPaciente(Gestion_Registros.registrarPaciente());
                    System.out.println("* Medico registrado con exito. *");
                }
                case 2 -> {
                    Paciente pac = hospital.buscarPaciente(Lib.getInt("> Ingrese ID de paciente: "));
                    if (pac != null) {
                        pac.mostrarInfo();
                    } else {
                        System.out.println("No existe paciente con ese ID");
                    }
                }
                case 3 -> {
                    System.out.println("+-- Lista de Pacientes. --+");
                    hospital.listarPacientes();
                }
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

    // Menu de acciones para gestionar medicos
    public static void gestionarMedicos(Hospital hospital) {
        int accion;
        do {
            Lib.clear();
            accion = Menu.menuMedicos();
            Lib.clear();
            switch (accion) {
                case 1 -> {
                    hospital.agregarMedico(Gestion_Registros.registrarMedico());
                    System.out.println("* Medico agregado. *");
                }
                case 2 -> {
                    Medico medico = hospital.buscarMedico(Lib.getInt("> Ingrese ID de médico: "));
                    if (medico != null) {
                        medico.mostrarInfo();
                    } else {
                        System.out.println("* Medico no encontrado. *");
                    }
                }
                case 3 -> {
                    System.out.println("+- Lista de medicos -+");
                    hospital.listarMedicos();
                }
                case 4 ->
                    Gestion_Registros.asignarPacienteMedico(hospital);
                case 5 ->
                    Gestion_Registros.pacientesDeMedico(hospital);
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

    // Menu de acciones para gestionar enfermeras
    public static void gestionarEnfermeras(Hospital hospital) {
        int accion;
        do {
            Lib.clear();
            accion = Menu.menuEnfermeras();
            Lib.clear();
            switch (accion) {
                case 1 -> {
                    hospital.agregarEnfermera(Gestion_Registros.registrarEnfermera());
                    System.out.println("* Enfermera agregado. *");
                }
                case 2 -> {
                    Enfermera enf = hospital.buscarEnfermera(Lib.getInt("> Ingrese ID de enfermera: "));
                    if (enf != null) {
                        enf.mostrarInfo();
                    } else {
                        System.out.println("* Enfermera no encontrada. *");
                    }
                }
                case 3 -> {
                    System.out.println("+-- Lista de Enfermeras --+");
                    hospital.listarEnfermeras();
                }
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
