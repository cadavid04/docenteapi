package co.udea.docente.api.service;

import co.udea.docente.api.DTO.RegistroActividadDTO;
import co.udea.docente.api.exception.DataNotFoundException;
import co.udea.docente.api.model.RegistroActividad;
import co.udea.docente.api.repository.RegistroActividadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroActividadService implements RegistroActividadServiceInt {

    public RegistroActividadService(RegistroActividadRepository registroActividadRepository){
        this.registroActividadRepository = registroActividadRepository;}

    private RegistroActividadRepository registroActividadRepository;

    private final Logger log = LoggerFactory.getLogger(RegistroActividadService.class);

    public List<RegistroActividadDTO> getRegistros(int idDocente){
        return registroActividadRepository.getDatosRegistro(idDocente);
    };

    @Override
    public int getSuma(int idDocente){
        return registroActividadRepository.getSumaTiempo(idDocente);
    }

    @Override
    public RegistroActividad addRegistro(RegistroActividad registroActividad) {
        return registroActividadRepository.save(registroActividad);
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
    public RegistroActividadDTO getRegistro(int id) {
        Optional<RegistroActividadDTO> posibleRegistro = registroActividadRepository.getDatoRegistro(id);
        if(posibleRegistro.isPresent()){
            return posibleRegistro.get();
        }else {
            log.error("No existe un heroe con ese id");
            throw new DataNotFoundException("No existe un heroe con id: "+ id);}
    }
}
