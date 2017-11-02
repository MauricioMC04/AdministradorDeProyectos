
package Modelo;

/**
 *
 * @author Ricardo
 */
public class Proyecto {
    private String Nombre;
    private int Supervisor;
    private String Tareas;
    private String Departamento;
    private String FI;
    private String FF;
    private int Administrador;
    
    
    public Proyecto(String Nombre,String Tareas, String Departamento, String FI, String FF, int Administrador,int Supervisor){
        this.Nombre=Nombre;
        this.Tareas=Tareas;
        this.Departamento=Departamento;
        this.FI=FI;
        this.FF=FF;
        this.Administrador=Administrador;
        this.Supervisor=Supervisor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(int Supervisor) {
        this.Supervisor = Supervisor;
    }

    public int getAdministrador() {
        return Administrador;
    }

    public void setAdministrador(int Administrador) {
        this.Administrador = Administrador;
    }

   

    public String getTareas() {
        return Tareas;
    }

    public void setTareas(String Tareas) {
        this.Tareas = Tareas;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getFI() {
        return FI;
    }

    public void setFI(String FI) {
        this.FI = FI;
    }

    public String getFF() {
        return FF;
    }

    public void setFF(String FF) {
        this.FF = FF;
    }
    
}
