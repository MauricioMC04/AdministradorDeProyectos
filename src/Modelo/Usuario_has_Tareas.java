
package Modelo;

public class Usuario_has_Tareas {

    String NombreProyecto;
    String Departamento;
    String Tarea;
    String Empleado;
    String Estado;
    String Iteraciones;

    public Usuario_has_Tareas(String NombreProyecto, String Departamento, String Tarea, String Empleado, String Estado, String Iteraciones) {
        this.NombreProyecto = NombreProyecto;
        this.Departamento = Departamento;
        this.Tarea = Tarea;
        this.Empleado = Empleado;
        this.Estado = Estado;
        this.Iteraciones = Iteraciones;
    }

    public String getNombreProyecto() {
        return NombreProyecto;
    }

    public void setNombreProyecto(String NombreProyecto) {
        this.NombreProyecto = NombreProyecto;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getTarea() {
        return Tarea;
    }

    public void setTarea(String Tarea) {
        this.Tarea = Tarea;
    }

    public String getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(String Empleado) {
        this.Empleado = Empleado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getIteraciones() {
        return Iteraciones;
    }

    public void setIteraciones(String Iteraciones) {
        this.Iteraciones = Iteraciones;
    }
    
}
