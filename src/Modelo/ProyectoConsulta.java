package Modelo;


public class ProyectoConsulta {
    String Nombre;
    String Departamento; 
    String FechaInicio;
    String FechaFinal;
    String Administrador;
    String Supervisor;
    String Estado;

    public ProyectoConsulta(String Nombre, String Departamento, String FechaInicio, String FechaFinal, String Administrador, String Supervisor, String Estado) {
        this.Nombre = Nombre;
        this.Departamento = Departamento;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
        this.Administrador = Administrador;
        this.Supervisor = Supervisor;
        this.Estado = Estado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public String getAdministrador() {
        return Administrador;
    }

    public void setAdministrador(String Administrador) {
        this.Administrador = Administrador;
    }

    public String getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(String Supervisor) {
        this.Supervisor = Supervisor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    





    
}