package com.es.segurosinseguros.controller;


import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.service.AsistenciaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para la gestión de asistencias médicas.
 * Proporciona endpoints para realizar operaciones CRUD sobre las asistencias médicas.
 */
@RestController
@RequestMapping("/asistenciasmedicas")
public class AsistenciaMedicaController {
    @Autowired
    private AsistenciaMedicaService service;

    //create
    @PostMapping("/")
    public ResponseEntity<AsistenciaMedicaDTO> create(@RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO) {


        return null;
    }

    //read


    //update


    //delete


    //getall


}
