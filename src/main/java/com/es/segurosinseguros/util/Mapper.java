package com.es.segurosinseguros.util;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;

public class Mapper {

    /**
     * Convierte una entidad {@link Seguro} a un DTO {@link SeguroDTO}.
     *
     * @param s La entidad {@link Seguro}.
     * @return El objeto {@link SeguroDTO} correspondiente.
     */
    public static SeguroDTO entityToDTO(Seguro s) {
        if (s == null) return null;

        SeguroDTO sDto = new SeguroDTO();
        sDto.setNif(s.getNif());
        sDto.setNombre(s.getNombre());
        sDto.setApe1(s.getApe1());
        sDto.setApe2(s.getApe2());
        sDto.setEdad(s.getEdad());
        sDto.setNumHijos(s.getNumHijos());
        sDto.setSexo(s.getSexo());
        sDto.setCasado(s.getCasado());
        sDto.setEmbarazada(s.getEmbarazada());

        return sDto;
    }

    /**
     * Convierte un DTO {@link SeguroDTO} a una entidad {@link Seguro}.
     *
     * @param sDto El objeto {@link SeguroDTO}.
     * @return La entidad {@link Seguro} correspondiente.
     */
    public static Seguro DtoToEntity(SeguroDTO sDto) {
        if (sDto == null) return null;

        Seguro seguro = new Seguro();
        seguro.setNif(sDto.getNif());
        seguro.setNombre(sDto.getNombre());
        seguro.setApe1(sDto.getApe1());
        seguro.setApe2(sDto.getApe2());
        seguro.setEdad(sDto.getEdad());
        seguro.setNumHijos(sDto.getNumHijos());
        seguro.setSexo(sDto.getSexo());
        seguro.setCasado(sDto.isCasado());
        seguro.setEmbarazada(sDto.isEmbarazada());

        return seguro;
    }

    /**
     * Convierte un DTO {@link AsistenciaMedicaDTO} a una entidad {@link AsistenciaMedica}.
     *
     * @param asMedDto El objeto {@link AsistenciaMedicaDTO}.
     * @return La entidad {@link AsistenciaMedica} correspondiente.
     */
    public static AsistenciaMedica DtoToEntity(AsistenciaMedicaDTO asMedDto) {
        if (asMedDto == null) return null;

        AsistenciaMedica asistenciaMedica = new AsistenciaMedica();
        asistenciaMedica.setBreveDescripcion(asMedDto.getBreveDescripcion());
        asistenciaMedica.setLugar(asMedDto.getLugar());
        asistenciaMedica.setExplicacion(asMedDto.getExplicacion());
        asistenciaMedica.setTipoAsistencia(asMedDto.getTipoAsistencia());
        asistenciaMedica.setFecha(asMedDto.getFecha());
        asistenciaMedica.setHora(asMedDto.getHora());
        asistenciaMedica.setImporte(asMedDto.getImporte());

        return asistenciaMedica;
    }

    /**
     * Convierte una entidad {@link AsistenciaMedica} a un DTO {@link AsistenciaMedicaDTO}.
     *
     * @param asMed La entidad {@link AsistenciaMedica}.
     * @return El objeto {@link AsistenciaMedicaDTO} correspondiente.
     */
    public static AsistenciaMedicaDTO entityToDTO(AsistenciaMedica asMed) {
        if (asMed == null) return null;

        AsistenciaMedicaDTO asMedDto = new AsistenciaMedicaDTO();
        asMedDto.setBreveDescripcion(asMed.getBreveDescripcion());
        asMedDto.setLugar(asMed.getLugar());
        asMedDto.setExplicacion(asMed.getExplicacion());
        asMedDto.setTipoAsistencia(asMed.getTipoAsistencia());
        asMedDto.setFecha(asMed.getFecha());
        asMedDto.setHora(asMed.getHora());
        asMedDto.setImporte(asMed.getImporte());

        return asMedDto;
    }
}
