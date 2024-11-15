package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    // Autowired - para traer ya inyeccion de dependecia de otras clases


    // READ
    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable String id) {

        //  1º Compruebo que el id no es null
        if (id == null || id.isBlank()) {
            // LANZO LA EXCEPCION PROPIA
            /*
            a) Qué código de estado devolverías -> BAD_REQUEST  (400)

            b) Qué información daríais al cliente
                -> mensaje: "id no válido"
                -> mensaje: "el id no puede ser nulo"
                -> URI: "localhost:8080/seguros/" + id

             c) Nombre a nuestra excepcion: BadRequesException
             */
            throw new BadRequestException("id no válido");
        }
        return null;
    }


}


