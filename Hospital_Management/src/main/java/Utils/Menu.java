package Utils;

public class Menu {

    public static int menuPrincipal() {
        System.out.println("+---- Hospital ----+");
        System.out.println("1. Gestion de Pacientes");
        System.out.println("2. Gestion de Medicos");
        System.out.println("3. Gestion de Enfermeras");
        System.out.println("4. Gestion de Citas");
        System.out.println("0. Salir");
        return Lib.getInt("> Elije una opcion: ");
    }

    public static int menuPacientes() {
        System.out.println("+---- Gestion de Pacientes ----+");
        System.out.println("1. Registrar nuevo paciente");
        System.out.println("2. Buscar paciente");
        System.out.println("3. Listar todos los pacientes");
        System.out.println("0. Volver al menu anterior");
        return Lib.getInt("Elije una opcion: ");
    }

    public static int menuMedicos() {
        System.out.println("+---- Gestion de Medicos ----+");
        System.out.println("1. Registrar nuevo medico");
        System.out.println("2. Buscar un medico");
        System.out.println("3. Listar todos los medicos");
        System.out.println("4. Asignar paciente a un medico");
        System.out.println("5. Ver pacientes de un medico");
        System.out.println("0. Volver al menu anterior");
        return Lib.getInt("Elije una opcion: ");
    }

    public static int menuEnfermeras() {
        System.out.println("+---- Gestion de Enfermeras ----+");
        System.out.println("1. Registrar nueva enfermera");
        System.out.println("2. Buscar una enfermera");
        System.out.println("3. Listar todas las enfermeras");
        System.out.println("0. Volver al menu anterior");
        return Lib.getInt("Elije una opcion: ");
    }

    public static int menuCitas() {
        System.out.println("+---- Gestion de Citas ----+");
        System.out.println("1. Programar nueva cita");
        System.out.println("2. Mostrar detalles de una cita");
        System.out.println("3. Editar fecha de una cita");
        System.out.println("4. Listar todas las citas");
        System.out.println("0. Volver al menu anterior");
        return Lib.getInt("Elije una opcion: ");
    }
}
