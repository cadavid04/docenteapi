package co.udea.docente.api.model;

import javax.persistence.*;
@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    public Docente(){

    }

    public Docente(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
