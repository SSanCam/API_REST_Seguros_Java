package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.EntityNotFoundException;
import com.es.segurosinseguros.exception.GeneralException;
import com.es.segurosinseguros.service.SeguroService;
import org.hibernate.annotations.processing.Pattern;
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
     * CREATE - Crear un nuevo seguro.
     *
     * @param seguroDTO Objeto {@link SeguroDTO} con los datos del seguro a crear.
     * @return Objeto {@link SeguroDTO} con los datos del seguro creado.
     * @throws BadRequestException Si los datos proporcionados son nulos o inválidos.
     * @throws GeneralException    Si ocurre un error inesperado en la capa de servicio.
     */
    @PostMapping("/")
    public ResponseEntity<SeguroDTO> create(@RequestBody SeguroDTO seguroDTO) throws GeneralException {
        if (seguroDTO == null) {
            throw new BadRequestException("Los datos del seguro no pueden ser nulos.");
        }
        // Validación de NIF
        if (!seguroDTO.getNif().matches("^[0-9]{8}[A-Z]$")) {
            throw new BadRequestException("El campo NIF no tiene un formato válido.");
        }
        // Validación del nombre
        if (seguroDTO.getNombre() == null || seguroDTO.getNombre().isBlank()) {
            throw new BadRequestException("El campo 'nombre' no puede estar vacío.");
        }
        // Validación ape1
        if (seguroDTO.getNombre() == null || seguroDTO.getApe1().isBlank()) {
            throw new BadRequestException("El campo 'ape1' no puede estar vacío.");
        }
        // Validación edad
        if (seguroDTO.getEdad() < 0 || seguroDTO.getEdad() < 18) {
            throw new BadRequestException("No es posible ser menor de edad para hacer un seguro");
        }
        // Validación número de hijos y estado vicil
        if (seguroDTO.getNumHijos() < 0) {
            throw new BadRequestException("El campo 'numHijos' no puede ser menor a 0.");
        }
        if (seguroDTO.getNumHijos() > 0 && !seguroDTO.isCasado()) {
            throw new BadRequestException("Un seguro no puede registrar hijos si no está casado.");
        }
        // Validación embarazada
        if ("Hombre".equalsIgnoreCase(seguroDTO.getSexo()) && seguroDTO.isEmbarazada()) {
            throw new BadRequestException("El campo 'embarazada' no puede ser true si el asegurado es hombre.");
        }

        // Creación del seguro.
        SeguroDTO seguroCreado = service.insert(seguroDTO);
        return ResponseEntity.status(201).body(seguroCreado);
    }

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
        // Validación de NIF
        if (!seguroDTO.getNif().matches("^[0-9]{8}[A-Z]$")) {
            throw new BadRequestException("El campo NIF no tiene un formato válido.");
        }
        // Validación del nombre
        if (seguroDTO.getNombre() == null || seguroDTO.getNombre().isBlank()) {
            throw new BadRequestException("El campo 'nombre' no puede estar vacío.");
        }
        // Validación ape1
        if (seguroDTO.getNombre() == null || seguroDTO.getApe1().isBlank()) {
            throw new BadRequestException("El campo 'ape1' no puede estar vacío.");
        }
        // Validación edad
        if (seguroDTO.getEdad() < 0 || seguroDTO.getEdad() < 18) {
            throw new BadRequestException("No es posible ser menor de edad para hacer un seguro");
        }
        // Validación número de hijos y estado vicil
        if (seguroDTO.getNumHijos() < 0) {
            throw new BadRequestException("El campo 'numHijos' no puede ser menor a 0.");
        }
        if (seguroDTO.getNumHijos() > 0 && !seguroDTO.isCasado()) {
            throw new BadRequestException("Un seguro no puede registrar hijos si no está casado.");
        }
        // Validación embarazada
        if ("Hombre".equalsIgnoreCase(seguroDTO.getSexo()) && seguroDTO.isEmbarazada()) {
            throw new BadRequestException("El campo 'embarazada' no puede ser true si el asegurado es hombre.");
        }

        SeguroDTO seguroModificado = service.modify(id, seguroDTO);
        return ResponseEntity.status(201).body(seguroModificado);
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
