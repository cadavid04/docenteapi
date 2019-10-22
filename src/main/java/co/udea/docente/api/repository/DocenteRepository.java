package co.udea.docente.api.repository;

import co.udea.docente.api.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, String>{
    public Docente findByNameEquals(String nombre);
}
