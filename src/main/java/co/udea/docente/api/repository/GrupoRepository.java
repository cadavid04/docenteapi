package co.udea.docente.api.repository;

import co.udea.docente.api.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {
public List<Grupo> findAllByIdDocente(int idDocente);

}