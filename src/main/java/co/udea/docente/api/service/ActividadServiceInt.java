package co.udea.docente.api.service;

import co.udea.docente.api.model.Actividad;
import co.udea.docente.api.model.Grupo;

import java.util.List;

public interface ActividadServiceInt {
    public List<Grupo> getGrupos(int id, String estado);
    public List<Actividad> getActividades();
}
