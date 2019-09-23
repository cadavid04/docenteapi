package co.udea.docente.api.repository;


import co.udea.docente.api.DTO.RegistroActividadDTO;
import co.udea.docente.api.model.RegistroActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroActividadRepository extends JpaRepository<RegistroActividad, String> {
    //public List<RegistroActividad> findAllByIdDocenteOrderByFecha (int idDocente);


    @Query("SELECT SUM (tiempo) FROM RegistroActividad  WHERE id_docente =?1")
    int getSumaTiempo(@Param("id") int id);

    @Query("SELECT new co.udea.docente.api.DTO.RegistroActividadDTO(r.id, r.docente.name, r.grupo.nombre, r.actividad.name, r.fecha, r.tiempo) "+ "FROM RegistroActividad r WHERE r.docente.id =?1")
    List<RegistroActividadDTO>getDatosRegistro(@Param("id") int id_docente);

    @Transactional
    @Modifying
    @Query("UPDATE RegistroActividad  SET actividad.id = (SELECT id from Actividad where descripcion=?2) WHERE id =?1" )
    void updateDatosRegistro(@Param("registroAcividad") int id_registro, @Param("registroAcividad") String descripcion);

    public Optional<RegistroActividad> findById(int id);
}
