
package Modelo;


public class TareaUsuario {
    String IdUsuario;
    String NombreTarea;

    public TareaUsuario(String IdUsuario, String NombreTarea) {
        this.IdUsuario = IdUsuario;
        this.NombreTarea = NombreTarea;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombreTarea() {
        return NombreTarea;
    }

    public void setNombreTarea(String NombreTarea) {
        this.NombreTarea = NombreTarea;
    }
    
    public String getString(){
        return IdUsuario + " - " + NombreTarea;
    }
}
