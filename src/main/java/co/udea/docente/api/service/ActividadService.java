package co.udea.docente.api.service;

import co.udea.docente.api.model.Actividad;
import co.udea.docente.api.model.Grupo;
import co.udea.docente.api.repository.ActividadRepository;
import co.udea.docente.api.repository.GrupoRepository;

import java.util.List;

public class ActividadService implements ActividadServiceInt {
 private GrupoRepository grupoRepository;
 private ActividadRepository actividadRepository;

    @Override
    public List<Grupo> getGrupos(int idDocente){
        return grupoRepository.findAllByIdDocente(idDocente);
    }

    @Override
    public List<Actividad> getActividad(int idActividad){
            return actividadRepository.findAllById(idActividad);
    }
}
