package co.udea.docente.api.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registroactividades")
public class RegistroActividad {
    @Id
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "id_docente", nullable = false)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Docente docente;
    @JoinColumn(name = "id_grupo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Grupo grupo;
    @JoinColumn(name = "id_actividad", nullable = false)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Actividad actividad;
    @Column(name = "tiempo")
    private int tiempo;
    @Column(name = "fecha")
    private Date fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public RegistroActividad(Docente docente, Grupo grupo, Actividad actividad, int tiempo, Date fecha) {
        this.docente = docente;
        this.grupo = grupo;
        this.actividad = actividad;
        this.tiempo = tiempo;
        this.fecha = fecha;
    }

    public RegistroActividad() {
        super();
    }
}
