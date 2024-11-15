package com.es.segurosinseguros.service;


import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
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

    //CRUD

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
    public AsistenciaMedicaDTO getById(String id) throws BackingStoreException {
        try {
            Long idL = Long.parseLong(id);

            AsistenciaMedica asistenciaMedica = repository
                    .findById(idL)
                    .orElseThrow(() -> new EntityNotFoundException("La Asistencia Médica con id " + id + " no existe."));

            return Mapper.entityToDTO(asistenciaMedica);

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new BaseDeDatosException("Error inesperado en la base de datos", e);
        }
    }

    // UPDATE

    // DELETE

    // GETALL

}
