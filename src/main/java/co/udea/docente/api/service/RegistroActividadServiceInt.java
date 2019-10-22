package co.udea.docente.api.service;

import co.udea.docente.api.DTO.RegistroActividadDTO;
import co.udea.docente.api.model.RegistroActividad;

import java.util.List;

public interface RegistroActividadServiceInt {
    //public List<RegistroActividad> getRegistros(int idDocente);
    public List<RegistroActividadDTO>getRegistros(int idDocente);
    public List<RegistroActividadDTO>getDatoRegistroDocenteGrupo(String nombreDocente, String nombreGrupo);
    public int getSuma(int idDocente);
    public void addRegistro(RegistroActividadDTO registroActividadDTO);
    public void updateRegistro(RegistroActividadDTO registroActividadDTO);
    public void deleteRegistro(int id);
    public RegistroActividadDTO getRegistro(int id);
}
