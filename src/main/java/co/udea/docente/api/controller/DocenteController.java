package co.udea.docente.api.controller;

import co.udea.docente.api.service.DocenteServiceInt;
import org.springframework.web.bind.annotation.*;


public class DocenteController {

    private DocenteServiceInt docenteService;

    public DocenteController(DocenteServiceInt docenteService) {
        this.docenteService = docenteService;
    }


}
