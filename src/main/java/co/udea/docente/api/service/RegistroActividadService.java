package co.udea.docente.api.service;

import co.udea.docente.api.DTO.RegistroActividadDTO;
import co.udea.docente.api.exception.DataNotFoundException;
import co.udea.docente.api.model.Actividad;
import co.udea.docente.api.model.Docente;
import co.udea.docente.api.model.Grupo;
import co.udea.docente.api.model.RegistroActividad;
import co.udea.docente.api.repository.ActividadRepository;
import co.udea.docente.api.repository.DocenteRepository;
import co.udea.docente.api.repository.GrupoRepository;
import co.udea.docente.api.repository.RegistroActividadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroActividadService implements RegistroActividadServiceInt {


    private RegistroActividadRepository registroActividadRepository;
    private GrupoRepository grupoRepository;
    private ActividadRepository actividadRepository;
    private DocenteRepository docenteRepository;

    public RegistroActividadService(RegistroActividadRepository registroActividadRepository,
                                    GrupoRepository grupoRepository,
                                    ActividadRepository actividadRepository,
                                    DocenteRepository docenteRepository)
    {
        this.registroActividadRepository = registroActividadRepository;
        this.grupoRepository = grupoRepository;
        this.actividadRepository = actividadRepository;
        this.docenteRepository = docenteRepository;
    }

    private final Logger log = LoggerFactory.getLogger(RegistroActividadService.class);

    public List<RegistroActividadDTO> getRegistros(int idDocente){
        return registroActividadRepository.getDatosRegistro(idDocente);
    };

    @Override
    public int getSuma(int idDocente){
        return registroActividadRepository.getSumaTiempo(idDocente);
    }

    @Override
    public void addRegistro(RegistroActividadDTO registroActividadDTO) {
        Grupo grupo = grupoRepository.findByNombreEquals(registroActividadDTO.getGrupo());
        Actividad actividad = actividadRepository.findByNameEquals(registroActividadDTO.getActividad());
        Docente docente = docenteRepository.findByNameEquals(registroActividadDTO.getDocente());
        RegistroActividad registroActividad = new RegistroActividad(
                docente,
                grupo,
                actividad,
                registroActividadDTO.getTiempo(),
                registroActividadDTO.getFecha());
        registroActividadRepository.save(registroActividad);
    }


    @Override
    public void updateRegistro(RegistroActividadDTO registroActividadDTO) {
        registroActividadRepository.updateDatosRegistro(registroActividadDTO.getId(),
                registroActividadDTO.getActividad(),
                registroActividadDTO.getGrupo(),
                registroActividadDTO.getTiempo(),
                registroActividadDTO.getFecha());
    }

    @Override
    public void deleteRegistro(int id) {
        Optional<RegistroActividad> posibleRegistro = registroActividadRepository.findById(id);
        if(posibleRegistro.isPresent()){
            registroActividadRepository.delete(posibleRegistro.get());
        }else {
            log.error("No existe un heroe con ese id");
            throw new DataNotFoundException("No existe un heroe con id: "+ id);}
    }

    @Override
    public List<RegistroActividadDTO> getDatoRegistroDocenteGrupo(String nombreDocente, String nombreGrupo) {
        List<RegistroActividadDTO> posibleRegistro = registroActividadRepository.getDatoRegistroDocenteGrupo(nombreDocente, nombreGrupo);
        if (!posibleRegistro.isEmpty()) {
            return posibleRegistro;
        } else {
            log.error("No existe un registro");
            throw new DataNotFoundException("No existe un registro para los datos suministrados");
        }
    }
    @Override
    public RegistroActividadDTO getRegistro(int id) {
        Optional<RegistroActividadDTO> posibleRegistro = registroActividadRepository.getDatoRegistro(id);
        if(posibleRegistro.isPresent()){
            return posibleRegistro.get();
        }else {
            log.error("No existe un registro con ese id");
            throw new DataNotFoundException("No existe un registro con id: "+ id);}
    }
}
