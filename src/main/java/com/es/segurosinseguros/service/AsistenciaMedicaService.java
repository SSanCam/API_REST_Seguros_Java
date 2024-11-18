package com.es.segurosinseguros.service;


import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.exception.GeneralException;
import com.es.segurosinseguros.exception.InvalidFormatException;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.repository.AsistenciaMedicaRepository;
import com.es.segurosinseguros.util.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.prefs.BackingStoreException;

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

    // READ
    public AsistenciaMedicaDTO getById(String id) throws BackingStoreException, GeneralException {
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

    // UPDATE
    public AsistenciaMedicaDTO modify(String id, AsistenciaMedicaDTO asistenciaMedicaDTO) {
        try {
            if (asistenciaMedicaDTO != null) {
                Long idL = Long.parseLong(id);

                AsistenciaMedica asMedExst = repository
                        .findById(idL)
                        .orElseThrow(() -> new EntityNotFoundException("No se encuentra la Asistencia Médica con id " + id));
                asMedExst.setSeguro(asistenciaMedicaDTO.getSeguro());
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
    // DELETE

    // GETALL

}
