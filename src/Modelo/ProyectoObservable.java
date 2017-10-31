/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Ricardo
 */
public class ProyectoObservable {

    private String Nombre;
    private String CreadoPor;
    private String Tareas;
    private String Departamento;
    private String FI;
    private String FF;
    
    
    public ProyectoObservable(String Nombre, String Creador, String Tareas, String Departamento, String FI, String FF){
        this.Nombre=Nombre;
        this.CreadoPor=Creador;
        this.Tareas=Tareas;
        this.Departamento=Departamento;
        this.FI=FI;
        this.FF=FF;
   
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCreadoPor() {
        return CreadoPor;
    }

    public void setCreadoPor(String CreadoPor) {
        this.CreadoPor = CreadoPor;
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
