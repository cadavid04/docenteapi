package co.udea.docente.api.controller;

import co.udea.docente.api.model.Grupo;
import co.udea.docente.api.service.ActividadServiceInt;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/actividades")
public class ActividadController {

    private final Logger log = LoggerFactory.getLogger(ActividadController.class);


    private ActividadServiceInt actividadService;

    public ActividadController(ActividadServiceInt actividadService) {
        this.actividadService = actividadService;
    }

    public ActividadController() {
    }

    @GetMapping("/grupos/{idDocente}")
    @ApiOperation(value = "Trae Grupos del docente", response = Page.class)
    public ResponseEntity<List<Grupo>> getGrupos(@PathVariable("idDocente") int idDocente){
        log.debug("REST request buscar grupos");
        try {
            return ResponseEntity.ok(actividadService.getGrupos(idDocente));
        }catch(Exception e){
            System.out.println("el error es " + e.toString());
            return null;
        }
    }
}
