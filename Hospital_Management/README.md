# Hospital Management System

Sistema de gestión hospitalaria simple implementado en Java. El sistema permite la gestión de pacientes, médicos, enfermeras y citas médicas.
El proposito de este programa fue practicar conceptos de Programación Orientada a Objetos (POO) en Java.

## Estructura del Proyecto

```
src/main/java
│
├── frank/hm
│ └── Main.java
│
├── Modelos/
│ ├── Persona.java
│ ├── Paciente.java
│ ├── Empleado.java
│ ├── Medico.java
│ ├── Enfermera.java
│ └── CitaMedica.java
│
├── Servicio/
│ ├── Gestion_Registros.java
│ ├── Gestion_Citas.java
│ └── Hospital.java
│
├── Utils/
│ ├── Lib.java
│ └── Menu.java
```

### Descripción de las Clases

- **Main.java**: Contiene el método principal para iniciar la aplicación.
- **Persona.java**: Clase base para representar a una persona con atributos comunes como nombre, apellido, edad e ID.
- **Paciente.java**: Hereda de Persona, incluye atributos adicionales como historial médico y número de habitación.
- **Empleado.java**: Hereda de Persona, incluye atributos adicionales como salario y horario de trabajo.
- **Medico.java**: Hereda de Empleado, incluye la especialidad y la lista de pacientes asignados.
- **Enfermera.java**: Hereda de Empleado, incluye el área de trabajo.
- **CitaMedica.java**: Representa una cita médica con atributos como fecha, hora, paciente y médico.
- **Gestion_Registros.java**: Maneja la gestión de registros de pacientes, médicos y enfermeras.
- **Gestion_Citas.java**: Maneja la gestión de citas médicas.
- **Hospital.java**: Administra la gestión de pacientes, médicos, enfermeras y citas médicas.
- **Lib.java**: Contiene funciones utiles para validacion de entrada de datos etc.
- **Menu.java**: Contiene todos los menu de las diferentes secciones

## Funcionalidades del Sistema

### Menú Principal
Desde el menú principal, los usuarios pueden acceder a diferentes secciones del sistema:
- Gestión de Pacientes
- Gestión de Médicos
- Gestión de Enfermeras
- Gestión de Citas Médicas
- Salir de la aplicación

### Gestión de Pacientes
Operaciones disponibles:
- **Registrar nuevo paciente**: Añadir un nuevo paciente al sistema.
- **Buscar paciente**: Buscar un paciente específico utilizando su ID.
- **Listar todos los pacientes**: Mostrar una lista de todos los pacientes registrados.

### Gestión de Médicos
Operaciones disponibles:
- **Registrar nuevo médico**: Añadir un nuevo médico al sistema.
- **Buscar médico**: Buscar un médico específico utilizando su ID.
- **Listar todos los médicos**: Mostrar una lista de todos los médicos registrados.
- **Asignar paciente a un médico**: Asignar un paciente existente a un médico específico.
- **Ver pacientes de un médico**: Ver la lista de pacientes asignados a un médico específico.

### Gestión de Enfermeras
Operaciones disponibles:
- **Registrar nueva enfermera**: Añadir una nueva enfermera al sistema.
- **Buscar enfermera**: Buscar una enfermera específica utilizando su ID.
- **Listar todas las enfermeras**: Mostrar una lista de todas las enfermeras registradas.

### Gestión de Citas Médicas
Operaciones disponibles:
- **Programar nueva cita**: Agendar una nueva cita médica.
- **Mostrar detalles de una cita**: Consultar los detalles de una cita específica.
- **Editar fecha de una cita**: Modificar la fecha y/o la hora de una cita existente.
- **Listar todas las citas**: Mostrar una lista de todas las citas programadas.
