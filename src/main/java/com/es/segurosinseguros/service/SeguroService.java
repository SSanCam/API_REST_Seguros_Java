package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.GeneralException;
import com.es.segurosinseguros.exception.InternalServerErrorException;
import com.es.segurosinseguros.exception.InvalidArgumentException;
import com.es.segurosinseguros.exception.InvalidFormatException;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SeguroRepository;
import com.es.segurosinseguros.util.Mapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio que maneja la lógica de negocio relacionada con los seguros médicos.
 * Proporciona métodos para realizar operaciones CRUD sobre los seguros.
 */
@Service
public class SeguroService {

    @Autowired
    private SeguroRepository repository;

    /**
     * CREATE
     * Inserta un nuevo registro de Seguro en la base de datos.
     *
     * @param seguroDTO el objeto DTO de Seguro que contiene los datos a guardar.
     * @return el objeto DTO de Seguro con los datos almacenados, incluyendo el identificador generado.
     * @throws InvalidArgumentException Si el DTO proporcionado es nulo.
     * @throws GeneralException         Si ocurre un error inesperado en la base de datos.
     */
    public SeguroDTO insert(SeguroDTO seguroDTO) throws GeneralException {
        if (seguroDTO == null) {
            throw new InvalidArgumentException("El DTO proporcionado no puede ser nulo.");
        }
        try {
            Seguro seguro = Mapper.DtoToEntity(seguroDTO);
            repository.save(seguro);
            return Mapper.entityToDTO(seguro);
        } catch (Exception e) {
            throw new GeneralException("Error al guardar el seguro en la base de datos: " + e.getMessage());
        }
    }

    /**
     * READ
     * Recupera un seguro por su identificador.
     *
     * @param id Identificador del seguro.
     * @return Objeto DTO de Seguro correspondiente al ID proporcionado.
     * @throws InvalidFormatException  Si el formato del ID es inválido.
     * @throws EntityNotFoundException Si no se encuentra el seguro con el ID dado.
     * @throws GeneralException        Si ocurre un error inesperado en la base de datos.
     */
    public SeguroDTO getById(String id) throws GeneralException {
        try {
            Long idL = Long.parseLong(id);

            Seguro seguro = repository
                    .findById(idL)
                    .orElseThrow(() -> new EntityNotFoundException("El seguro con id " + id + " no existe."));

            return Mapper.entityToDTO(seguro);

        } catch (NumberFormatException e) {
            throw new InvalidFormatException("El formato del ID es inválido: " + e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No se encontró el seguro con ID: " + id);
        } catch (Exception e) {
            throw new GeneralException("Error inesperado al buscar el seguro: " + e.getMessage());
        }
    }

    /**
     * UPDATE
     * Actualiza un seguro existente en la base de datos.
     *
     * @param id        Identificador del seguro a actualizar.
     * @param seguroDTO Objeto DTO de Seguro con los datos actualizados.
     * @return Objeto DTO de Seguro con los datos actualizados.
     * @throws InvalidFormatException   Si el formato del ID es inválido.
     * @throws EntityNotFoundException  Si no se encuentra el seguro con el ID dado.
     * @throws InvalidArgumentException Si el DTO proporcionado es nulo.
     * @throws GeneralException         Si ocurre un error inesperado en la base de datos.
     */
    public SeguroDTO update(String id, SeguroDTO seguroDTO) throws GeneralException, InvalidFormatException {
        if (seguroDTO == null) {
            throw new InvalidArgumentException("El DTO proporcionado no puede ser nulo.");
        }
        try {
            Long idL = Long.parseLong(id);

            Seguro seguro = repository
                    .findById(idL)
                    .orElseThrow(() -> new EntityNotFoundException("No se encuentra el seguro con ID " + id));

            // Actualiza los campos de la entidad existentes con los valores del DTO
            seguro.setNif(seguroDTO.getNif());
            seguro.setNombre(seguroDTO.getNombre());
            seguro.setApe1(seguroDTO.getApe1());
            seguro.setApe2(seguroDTO.getApe2());
            seguro.setEdad(seguroDTO.getEdad());
            seguro.setNumHijos(seguroDTO.getNumHijos());
            seguro.setSexo(seguroDTO.getSexo());
            seguro.setCasado(seguroDTO.isCasado());
            seguro.setEmbarazada(seguroDTO.isEmbarazada());

            repository.save(seguro);
            return Mapper.entityToDTO(seguro);

        } catch (NumberFormatException e) {
            throw new InvalidFormatException("El formato del ID es inválido.");
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No se encontró el seguro con ID: " + id);
        } catch (Exception e) {
            throw new GeneralException("Error inesperado al actualizar el seguro.");
        }
    }

    /**
     * DELETE
     * Elimina un seguro por su identificador.
     *
     * @param id Identificador del seguro a eliminar.
     * @throws InvalidFormatException  Si el formato del ID es inválido.
     * @throws EntityNotFoundException Si no se encuentra el seguro con el ID dado.
     * @throws GeneralException        Si ocurre un error inesperado en la base de datos.
     */
    public void delete(String id) throws GeneralException, InvalidFormatException {
        try {
            Long idL = Long.parseLong(id);
            if (!repository.existsById(idL)) {
                throw new EntityNotFoundException("El seguro con ID " + id + " no existe.");
            }
            repository.deleteById(idL);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException("El formato del ID es inválido.");
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No se encontró el seguro con ID: " + id);
        } catch (Exception e) {
            throw new GeneralException("Error inesperado al eliminar el seguro.");
        }
    }

    /**
     * GET ALL
     * Recupera todos los seguros almacenados en la base de datos.
     *
     * @return Lista de objetos DTO de Seguro.
     * @throws InternalServerErrorException Si ocurre un error inesperado al acceder a la base de datos.
     */
    public List<SeguroDTO> getAll() {
        try {
            List<Seguro> listaSeguros = repository.findAll();
            List<SeguroDTO> listaSegurosDTO = new ArrayList<>();
            listaSeguros.forEach(seguro -> listaSegurosDTO.add(Mapper.entityToDTO(seguro)));
            return listaSegurosDTO;
        } catch (Exception e) {
            throw new InternalServerErrorException("Error al obtener la lista de seguros: " + e.getMessage());
        }
    }
}
