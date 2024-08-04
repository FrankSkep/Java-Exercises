package Modelos;

public class CitaMedica {

    private String fecha, hora;
    private Paciente paciente;
    private Medico medico;

    public CitaMedica(String fecha, String hora, Paciente paciente, Medico medico) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
    }

    public void mostrarDetallesCita() {
        System.out.println("Fecha : " + fecha + " - " + "Hora : " + hora);
        System.out.println("Paciente :" + paciente.getName() + " - ID : " + paciente.getID());
        System.out.println("Medico : " + medico.getName() + " - ID : " + " - Especialidad : " + medico.getEspecialidad());
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdCita() {
        return paciente.getID();
    }

}
