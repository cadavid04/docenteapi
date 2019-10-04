package co.udea.docente.api.model;
import javax.persistence.*;

@Entity
@Table(name = "actividades")
public class Actividad {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "descripcion")
    private String name;

    public Actividad(String name) {
        this.name = name;
    }

    public Actividad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
