package co.udea.docente.api.controller;

import co.udea.docente.api.model.Grupo;
import co.udea.docente.api.service.ActividadServiceInt;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/actividades")
public class ActividadController {

    private ActividadServiceInt actividadService;
    public ActividadController(ActividadServiceInt actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping("/grupos/{idDocente}")
    @ApiOperation(value = "Trae Grupos del docente", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los grupos fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Grupo>> getGrupos(@PathVariable("idDocente") int idDocente) {
        return ResponseEntity.ok(actividadService.getGrupos(idDocente, "Activo"));}
}

