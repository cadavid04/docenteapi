package co.udea.docente.api.model;
import javax.persistence.*;

@Entity
@Table(name = "grupos")
public class Grupo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(name = "id_curso")
    private String idCurso;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "horas_totales")
    private int horasTotales;
    @Column(name = "estado")
    private String estado;
    @Column(name = "periodo")
    private String periodo;

    public Grupo(String idCurso, String nombre, int horasTotales, String estado, String periodo) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.horasTotales = horasTotales;
        this.estado = estado;
        this.periodo = periodo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
