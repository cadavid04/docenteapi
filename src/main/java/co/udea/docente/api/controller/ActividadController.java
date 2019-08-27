package co.udea.docente.api.controller;

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


@RestController
@RequestMapping("/actividades")
public class ActividadController {

    private final Logger log = LoggerFactory.getLogger(ActividadController.class);


    private ActividadServiceInt actividadService;

    public ActividadController(ActividadServiceInt actividadService) {
        this.actividadService = actividadService;
    }


    @GetMapping("/grupos")
    @ApiOperation(value = "Trae Grupos del docente", response = Page.class)
    public ResponseEntity<Hero> getHero(@PathVariable("id") int id){
        log.debug("REST request buscar heroe");
        return ResponseEntity.ok(heroService.getHero(id));
    }
}
