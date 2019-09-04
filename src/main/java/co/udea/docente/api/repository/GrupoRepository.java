package co.udea.docente.api.repository;

import co.udea.docente.api.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {
    public List<Grupo> findAllByIdDocenteAndEstadoEquals(int id, String estado);

}
