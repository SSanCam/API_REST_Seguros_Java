package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.EntityNotFoundException;
import com.es.segurosinseguros.exception.GeneralException;
import com.es.segurosinseguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de seguros médicos.
 * Proporciona endpoints para realizar operaciones CRUD sobre los seguros.
 */
@RestController
@RequestMapping("/seguros")
public class SeguroController {

    @Autowired
    private SeguroService service;

    /**
     * READ - Obtener un seguro por su identificador.
     *
     * @param id Identificador del seguro.
     * @return Objeto {@link SeguroDTO} si el seguro es encontrado.
     * @throws BadRequestException Si el ID proporcionado es nulo o está vacío.
     * @throws GeneralException    Si ocurre un error inesperado en la capa de servicio.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable String id) throws GeneralException {

        if (id == null || id.isBlank()) {
            throw new BadRequestException("El ID no puede ser nulo o vacío.");
        }
        SeguroDTO seguroDTO = service.getById(id);
        return ResponseEntity.ok(seguroDTO);
    }

    /**
     * UPDATE - Actualizar un seguro existente.
     *
     * @param id        Identificador del seguro a actualizar.
     * @param seguroDTO Objeto {@link SeguroDTO} con los datos actualizados.
     * @return Objeto {@link SeguroDTO} actualizado.
     * @throws BadRequestException     Si el ID es nulo o los datos proporcionados son inválidos.
     * @throws EntityNotFoundException Si no se encuentra el seguro con el ID proporcionado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<SeguroDTO> update(@PathVariable String id, @RequestBody SeguroDTO seguroDTO) throws EntityNotFoundException, GeneralException {
        if (id == null || id.isBlank()) {
            throw new BadRequestException("El ID no puede ser nulo o vacío.");
        }
        SeguroDTO seguroModificado = service.modify(id, seguroDTO);
        return ResponseEntity.ok(seguroModificado);
    }

    /**
     * DELETE - Eliminar un seguro por su identificador.
     *
     * @param id Identificador del seguro a eliminar.
     * @throws BadRequestException     Si el ID es nulo o vacío.
     * @throws EntityNotFoundException Si no se encuentra el seguro con el ID proporcionado.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws GeneralException {
        if (id == null || id.isBlank()) {
            throw new BadRequestException("ID inválido");
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * GET ALL - Obtener todos los seguros almacenados.
     *
     * @return Lista de objetos {@link SeguroDTO}.
     */
    @GetMapping("/")
    public ResponseEntity<List<SeguroDTO>> getAll() {
        List<SeguroDTO> listaSeguros = service.getAll();
        return ResponseEntity.ok(listaSeguros);
    }
}
