package co.udea.docente.api.repository;

import co.udea.docente.api.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, String>{
    public List<Actividad>findAllById(int idActividad);

}
