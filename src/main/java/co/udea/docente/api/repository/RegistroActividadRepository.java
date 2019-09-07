package co.udea.docente.api.repository;


import co.udea.docente.api.model.RegistroActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroActividadRepository extends JpaRepository<RegistroActividad, String> {
    public List<RegistroActividad> findAllByIdDocenteOrderByFecha (int idDocente);

    @Query("SELECT SUM (tiempo) FROM RegistroActividad  WHERE id_docente =?1")
    int getSumaTiempo(@Param("id") int id);

    public Optional<RegistroActividad> findById(int id);
}
