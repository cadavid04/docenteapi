package co.udea.docente.api.service;

import co.udea.docente.api.model.RegistroActividad;
import co.udea.docente.api.repository.RegistroActividadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroActividadService implements RegistroActividadServiceInt {

    public RegistroActividadService(RegistroActividadRepository registroActividadRepository){
        this.registroActividadRepository = registroActividadRepository;}

    private RegistroActividadRepository registroActividadRepository;

    private final Logger log = LoggerFactory.getLogger(RegistroActividadService.class);

    @Override
    public List<RegistroActividad> getRegistros(int idDocente){
        return registroActividadRepository.findAllByIdDocenteOrderByFecha(idDocente);
    };

    @Override
    public int getSuma(int idDocente){
        return registroActividadRepository.getSumaTiempo(idDocente);
    }
}
