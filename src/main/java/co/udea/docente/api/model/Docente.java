package co.udea.docente.api.model;

import javax.persistence.*;
@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    public Docente(){

    }
    public void bug (){
     boolean varia = true;   
        if(varia){
        
        }
    }

    public Docente(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
