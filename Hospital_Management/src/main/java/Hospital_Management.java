
import Modelos.CitaMedica;
import Modelos.Enfermera;
import Servicio.Hospital;
import Modelos.Medico;
import Modelos.Paciente;
import Servicio.Gestion_Registros;
import Servicio.Gestion_Citas;
import Utils.Menu;
import Utils.Lib;

public class Hospital_Management {

    /*--------- MAIN ---------*/
    public static void main(String[] args) {
        Lib.startUTF();
        Lib.clear();

        // Instancia Hospital
        Hospital hospital = new Hospital();

        agregarDatosAleatorios(hospital);

        int opcion;

        do {
            opcion = Menu.menuPrincipal();
            Lib.clear();

            switch (opcion) {
                case 1 -> // GESTION PACIENTES
                    Gestion_Registros.gestionarPacientes(hospital);
                case 2 -> // GESTION MEDICOS
                    Gestion_Registros.gestionarMedicos(hospital);
                case 3 -> // GESTION ENFERMERAS
                    Gestion_Registros.gestionarEnfermeras(hospital);
                case 4 -> // GESTION CITAS
                    Gestion_Citas.gestionarCitas(hospital);
                case 0 ->
                    System.out.println("Has salido.");
                default ->
                    System.out.println("Opcion no valida.");
            }
            Lib.clear();
        } while (opcion != 0);
        Lib.closeScan();
    }

    private static void agregarDatosAleatorios(Hospital hospital) {
        Medico medico1 = new Medico("Pedro", "Farias", 30, 666, 35034.2, 9, "Cirujano");
        Paciente paciente1 = new Paciente("Jose", "Juarez", 21, 3567, "bueno", 8);
        Enfermera enfer1 = new Enfermera("Rosa", "Marquez", 18, 7212, 15000, 8, "Cirujia");
        medico1.agregarPaciente(paciente1);

        hospital.agregarMedico(medico1);
        hospital.agregarPaciente(paciente1);
        hospital.agregarEnfermera(enfer1);

        CitaMedica cita = new CitaMedica("19/07/2002", "12:00", paciente1, medico1);
        cita.setHora("15:00");
        hospital.registrarCita(cita);
        Lib.clear();
    }
}
