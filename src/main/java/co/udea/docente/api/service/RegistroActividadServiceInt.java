package co.udea.docente.api.service;

import co.udea.docente.api.model.RegistroActividad;

import java.util.List;

public interface RegistroActividadServiceInt {
    public List<RegistroActividad> getRegistros(int idDocente);
    public int getSuma(int idDocente);
}
