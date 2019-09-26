package co.udea.docente.api.DTO;
import java.util.Date;

public class RegistroActividadDTO {
    private int id;
    private String docente;
    private String grupo;
    private String actividad;
    private Date fecha;
    private int tiempo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public RegistroActividadDTO(int id, String docente, String grupo, String actividad, Date fecha, int tiempo) {
        this.id = id;
        this.docente = docente;
        this.grupo = grupo;
        this.actividad = actividad;
        this.fecha = fecha;
        this.tiempo = tiempo;
    }

    public RegistroActividadDTO(String docente, String grupo, String actividad, Date fecha, int tiempo) {
        this.docente = docente;
        this.grupo = grupo;
        this.actividad = actividad;
        this.fecha = fecha;
        this.tiempo = tiempo;
    }

    public RegistroActividadDTO() {
    }
}


