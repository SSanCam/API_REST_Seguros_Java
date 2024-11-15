package com.es.segurosinseguros.util;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;

public class Mapper {

    // 1. Metodo estático de seguroDTO recibiendo Seguro
    public static SeguroDTO entityToDTO(Seguro s) {
        SeguroDTO sDto = new SeguroDTO();
        return null;
    }

    // 2. DTO-to-ENTITY
    public static Seguro DtoToEntity(SeguroDTO sDto) {
        return null;
    }

    // 3. AsistenciaMedicaDTO -> AsistenciaMedica
    public static AsistenciaMedica DtoToEntity(AsistenciaMedicaDTO asMedDto) {
        return null,
    }

    // 4. DTO-to-ENTITY
    public static AsistenciaMedicaDTO entityToDTO(AsistenciaMedica asMed) {
        return null;
    }
}
