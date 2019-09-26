package co.udea.docente.api.controller;


import co.udea.docente.api.DTO.RegistroActividadDTO;
import co.udea.docente.api.model.RegistroActividad;
import co.udea.docente.api.service.RegistroActividadServiceInt;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrosactividad")
public class RegistrosActividadController {

    private RegistroActividadServiceInt registrosService;

    public RegistrosActividadController(RegistroActividadServiceInt registrosService) {
        this.registrosService = registrosService;
    }


    @GetMapping("/registros/{idDocente}")
    @ApiOperation(value = "Trae los registros de las actividades", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los registros fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    //public ResponseEntity<List<RegistroActividad>> getRegistrosDocente(@PathVariable("idDocente") int idDocente) {
    public ResponseEntity<List<RegistroActividadDTO>> getRegistrosDocente(@PathVariable("idDocente") int idDocente) {
        return ResponseEntity.ok(registrosService.getRegistros(idDocente));}

    @GetMapping("/suma/{idDocente}")
    @ApiOperation(value = "Trae la suma de las actividades reportadas", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los registros fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public int getSuma(@PathVariable("idDocente") int idDocente) {
        return registrosService.getSuma(idDocente);}

    @PostMapping()
    public void addRegistro(@RequestBody RegistroActividadDTO registroActividadDTO){
         registrosService.addRegistro(registroActividadDTO);
    }

    @PutMapping()
    public void updateRegistro(@RequestBody RegistroActividadDTO registroActividadDTO){
        registrosService.updateRegistro(registroActividadDTO);
    }

    @DeleteMapping("borrar/{id}")
    public void deleteRegistro(@PathVariable("id") int id) {
        registrosService.deleteRegistro(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroActividadDTO> getRegistro(@PathVariable("id") int id) {
        return ResponseEntity.ok(registrosService.getRegistro(id));
    }

}
