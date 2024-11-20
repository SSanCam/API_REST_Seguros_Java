package com.es.segurosinseguros.controller;


import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.GeneralException;
import com.es.segurosinseguros.service.AsistenciaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de asistencias médicas.
 * Proporciona endpoints para realizar operaciones CRUD sobre las asistencias médicas.
 */
@RestController
@RequestMapping("/asistenciasmedicas")
public class AsistenciaMedicaController {
    @Autowired
    private AsistenciaMedicaService service;

    /**
     * CREATE - Crear una nueva asistencia médica.
     *
     * @param asistenciaMedicaDTO Objeto {@link AsistenciaMedicaDTO} con los datos de la nueva asistencia médica.
     * @return Objeto {@link AsistenciaMedicaDTO} creado.
     * @throws BadRequestException Si los datos proporcionados son inválidos.
     * @throws GeneralException    Si ocurre un error inesperado en la capa de servicio.
     */
    @PostMapping("/")
    public ResponseEntity<AsistenciaMedicaDTO> create(@RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO) throws GeneralException {

        if (asistenciaMedicaDTO == null) {
            throw new BadRequestException("Datos inválidos");
        }

        //Validaciones necesarias
        // Validación breveDescripcion
        if (asistenciaMedicaDTO.getBreveDescripcion().isBlank()){
            throw new BadRequestException("El campo 'breveDescripcion' no puede estar vacío.");
        }
        // Validación lugar
        if (asistenciaMedicaDTO.getLugar().isBlank()) {
            throw new BadRequestException("El campo 'lugar' no puede estar vacío.");
        }
        // Validación explicación
        if (asistenciaMedicaDTO.getExplicacion().isBlank()) {
            throw new BadRequestException("El campo 'explicacion' no puede estar vacío.");
        }
        // Validación tipoAsistencia
        if (asistenciaMedicaDTO.getTipoAsistencia() == null){
            throw new BadRequestException("El campo 'tipoAsistencia' no puede ser nulo.");
        }
        // Validación fecha
        if (asistenciaMedicaDTO.getFecha() == null) {
            throw new BadRequestException("El campo 'fecha' no puede ser nulo.");
        }
        // Validación hora
        if (asistenciaMedicaDTO.getHora() == null) {
            throw new BadRequestException("El campo 'hora' no puede ser nulo.");
        }
        // Validación importe
        if (asistenciaMedicaDTO.getImporte() <= 0) {
            throw new BadRequestException("El campo 'importe' debe ser mayor que 0.");
        }


        AsistenciaMedicaDTO asistenciaCreada = service.insert(asistenciaMedicaDTO);
        return ResponseEntity.status(201).body(asistenciaCreada);
    }

    /**
     * READ - Obtener una asistencia médica por su identificador.
     *
     * @param id Identificador de la asistencia médica.
     * @return Objeto {@link AsistenciaMedicaDTO} si se encuentra la asistencia médica.
     * @throws BadRequestException Si el ID proporcionado es nulo o está vacío.
     * @throws GeneralException    Si ocurre un error inesperado en la capa de servicio.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaMedicaDTO> getById(@PathVariable String id) throws GeneralException {
        if (id == null || id.isBlank()) {
            throw new BadRequestException("ID inválido.");
        }
        AsistenciaMedicaDTO asistenciaMedicaDTO = service.getById(id);
        return ResponseEntity.ok(asistenciaMedicaDTO);
    }

    /**
     * UPDATE - Actualizar una asistencia médica existente.
     *
     * @param id                  Identificador de la asistencia médica a actualizar.
     * @param asistenciaMedicaDTO Objeto {@link AsistenciaMedicaDTO} con los datos actualizados.
     * @return Objeto {@link AsistenciaMedicaDTO} actualizado.
     * @throws BadRequestException Si el ID proporcionado es nulo o está vacío.
     * @throws GeneralException    Si ocurre un error inesperado en la capa de servicio.
     */
    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaMedicaDTO> modify(@PathVariable String id, @RequestBody AsistenciaMedicaDTO asistenciaMedicaDTO) throws GeneralException {
        if (id == null || id.isBlank()) {
            throw new BadRequestException("ID inválido.");
        }
        //Validaciones necesarias
        // Validación breveDescripcion
        if (asistenciaMedicaDTO.getBreveDescripcion().isBlank()){
            throw new BadRequestException("El campo 'breveDescripcion' no puede estar vacío.");
        }
        // Validación lugar
        if (asistenciaMedicaDTO.getLugar().isBlank()) {
            throw new BadRequestException("El campo 'lugar' no puede estar vacío.");
        }
        // Validación explicación
        if (asistenciaMedicaDTO.getExplicacion().isBlank()) {
            throw new BadRequestException("El campo 'explicacion' no puede estar vacío.");
        }
        // Validación tipoAsistencia
        if (asistenciaMedicaDTO.getTipoAsistencia() == null){
            throw new BadRequestException("El campo 'tipoAsistencia' no puede ser nulo.");
        }
        // Validación fecha
        if (asistenciaMedicaDTO.getFecha() == null) {
            throw new BadRequestException("El campo 'fecha' no puede ser nulo.");
        }
        // Validación hora
        if (asistenciaMedicaDTO.getHora() == null) {
            throw new BadRequestException("El campo 'hora' no puede ser nulo.");
        }
        // Validación importe
        if (asistenciaMedicaDTO.getImporte() <= 0) {
            throw new BadRequestException("El campo 'importe' debe ser mayor que 0.");
        }


        AsistenciaMedicaDTO asistenciaModificada = service.modify(id, asistenciaMedicaDTO);
        return ResponseEntity.status(201).body(asistenciaModificada);
    }


    /**
     * DELETE - Eliminar una asistencia médica por su identificador.
     *
     * @param id Identificador de la asistencia médica a eliminar.
     * @return Respuesta HTTP 204 (No Content) si la eliminación es exitosa.
     * @throws BadRequestException Si el ID proporcionado es nulo o está vacío.
     * @throws GeneralException    Si ocurre un error inesperado en la capa de servicio.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws GeneralException {
        if (id == null || id.isBlank()) {
            throw new BadRequestException("ID inválido.");
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * GET ALL - Obtener todas las asistencias médicas almacenadas.
     *
     * @return Lista de objetos {@link AsistenciaMedicaDTO}.
     * @throws GeneralException Si ocurre un error inesperado en la capa de servicio.
     */
    @GetMapping("/")
    public ResponseEntity<List<AsistenciaMedicaDTO>> getAll() {
        List<AsistenciaMedicaDTO> listaAsistenciasMedicas = service.listaAsistenciasMedicas();
        return ResponseEntity.status(201).body(listaAsistenciasMedicas);
    }
}
