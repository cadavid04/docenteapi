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


}
