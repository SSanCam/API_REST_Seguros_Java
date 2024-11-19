package com.es.segurosinseguros.service;


import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.GeneralException;
import com.es.segurosinseguros.exception.InternalServerErrorException;
import com.es.segurosinseguros.exception.InvalidFormatException;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.repository.AsistenciaMedicaRepository;
import com.es.segurosinseguros.util.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que maneja la lógica de negocio relacionada con las asistencias médicas.
 * Proporciona métodos para realizar operaciones CRUD sobre las asistencias médicas.
 */
@Service
public class AsistenciaMedicaService {

    @Autowired
    private AsistenciaMedicaRepository repository;

    /**
     * CREATE
     * Inserta un nuevo registro de Asistencia Médica en la base de datos.
     *
     * @param asistenciaMedicaDTO el objeto DTO de Asistencia Médica que contiene los datos a guardar.
     * @return el objeto DTO de Asistencia Médica con los datos almacenados,
     * incluyendo el identificador generado, o {@code null} si el DTO proporcionado es {@code null}.
     */
    public AsistenciaMedicaDTO insert(AsistenciaMedicaDTO asistenciaMedicaDTO) {
        if (asistenciaMedicaDTO != null) {
            AsistenciaMedica asMed = Mapper.DtoToEntity(asistenciaMedicaDTO);
            repository.save(asMed);
            return Mapper.entityToDTO(asMed);
        }
        return null;
    }

    /**
     * READ
     * Recupera una asistencia médica por su identificador.
     *
     * @param id Identificador de la asistencia médica.
     * @return Objeto DTO de Asistencia Médica correspondiente al ID proporcionado.
     * @throws InvalidFormatException Si el formato del ID es inválido.
     * @throws EntityNotFoundException Si no se encuentra la asistencia médica con el ID dado.
     * @throws GeneralException Si ocurre un error inesperado en la base de datos.
     */
    public AsistenciaMedicaDTO getById(String id) throws GeneralException {
        try {
            Long idL = Long.parseLong(id);

            AsistenciaMedica asistenciaMedica = repository
                    .findById(idL)
                    .orElseThrow(() -> new EntityNotFoundException("La Asistencia Médica con id " + id + " no existe."));

            return Mapper.entityToDTO(asistenciaMedica);

        } catch (NumberFormatException e) {
            throw new InvalidFormatException("El formato id es inválido: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No se encontró la entidad solicitada: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralException("Error inesperado en la base de datos: " + e.getMessage());
        }
    }

    /**
     * UPDATE
     * Actualiza una asistencia médica existente en la base de datos.
     *
     * @param id Identificador de la asistencia médica a actualizar.
     * @param asistenciaMedicaDTO Objeto DTO de Asistencia Médica con los datos actualizados.
     * @return Objeto DTO de Asistencia Médica con los datos actualizados.
     * @throws InvalidFormatException Si el formato del ID es inválido.
     * @throws EntityNotFoundException Si no se encuentra la asistencia médica con el ID dado.
     * @throws IllegalArgumentException Si el DTO proporcionado es nulo.
     * @throws GeneralException Si ocurre un error inesperado en la base de datos.
     */
    public AsistenciaMedicaDTO modify(String id, AsistenciaMedicaDTO asistenciaMedicaDTO) {
        try {
            if (asistenciaMedicaDTO != null) {
                Long idL = Long.parseLong(id);

                AsistenciaMedica asMedExst = repository
                        .findById(idL)
                        .orElseThrow(() -> new EntityNotFoundException("No se encuentra la Asistencia Médica con id " + id));
                // Actualiza los campos de la entidad existente con los valores del DTO
                asMedExst.setBreveDescripcion(asistenciaMedicaDTO.getBreveDescripcion());
                asMedExst.setLugar(asistenciaMedicaDTO.getLugar());
                asMedExst.setExplicacion(asistenciaMedicaDTO.getExplicacion());
                asMedExst.setTipoAsistencia(asistenciaMedicaDTO.getTipoAsistencia());
                asMedExst.setImporte(asistenciaMedicaDTO.getImporte());

                repository.save(asMedExst);
                return Mapper.entityToDTO(asMedExst);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID no válido: " + id, e);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Error al actualizar en la base de datos: Asistencia Médica no encontrada", e);
        }
        return null;
    }

    /**
     * DELETE
     * Elimina una asistencia médica por su identificador.
     *
     * @param id Identificador de la asistencia médica a eliminar.
     * @throws InvalidFormatException Si el formato del ID es inválido.
     * @throws EntityNotFoundException Si no se encuentra la asistencia médica con el ID dado.
     */
    public void delete(String id)  {
        try {
            Long idL = Long.parseLong(id);
            if (!repository.existsById(idL)) {
                throw new EntityNotFoundException("Error al actualizar en la base de datos: Asistencia Médica no encontrada");
            }
            repository.deleteById(idL);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID no válido: " + id, e);
        }

    }


    /**
     * GET ALL
     * Recupera todas las asistencias médicas almacenadas en la base de datos.
     *
     * @return Lista de objetos DTO de Asistencia Médica.
     * @throws InternalServerErrorException Si ocurre un error inesperado al acceder a la base de datos.
     */    public List<AsistenciaMedicaDTO> listaAsistenciasMedicas() {
        try {

            List<AsistenciaMedica> listaAsistenciasMedicas = repository.findAll();
            List<AsistenciaMedicaDTO> listaAsistenciasMedicasDTO = new ArrayList<>();
            listaAsistenciasMedicas.forEach(asistenciaMedica -> listaAsistenciasMedicasDTO.add(Mapper.entityToDTO(asistenciaMedica)));
            return listaAsistenciasMedicasDTO;

        } catch (Exception e) {
            throw new InternalServerErrorException("Error al obtener la lista de asistencias médicas: " + e.getMessage());
        }
    }

}
