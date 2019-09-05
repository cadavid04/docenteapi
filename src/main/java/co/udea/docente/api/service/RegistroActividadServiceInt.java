package co.udea.docente.api.service;

import co.udea.docente.api.model.RegistroActividad;

import java.util.List;

public interface RegistroActividadServiceInt {
    public List<RegistroActividad> getRegistros(int idDocente);
    public int getSuma(int idDocente);
    public RegistroActividad addRegistro(RegistroActividad registroActividad);
    public RegistroActividad updateRegistro(RegistroActividad registroActividad);
    public void deleteRegistro(int id);
    public RegistroActividad getRegistro(int id);
}
