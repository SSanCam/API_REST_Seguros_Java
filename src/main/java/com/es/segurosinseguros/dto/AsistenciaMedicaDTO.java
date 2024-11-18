package com.es.segurosinseguros.dto;

import com.es.segurosinseguros.model.Seguro;

public class AsistenciaMedicaDTO {

    private Long id;
    private Seguro seguro;
    private String breveDescripcion;
    private String lugar;
    private String explicacion;
    private String tipoAsistencia;
    private Double importe;

    public AsistenciaMedicaDTO() {
    }

    public AsistenciaMedicaDTO(Seguro seguro, String breveDescripcion, String lugar, String explicacion, String tipoAsistencia, Double importe) {
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.importe = importe;
    }

    public AsistenciaMedicaDTO(Long id, Seguro seguro, String breveDescripcion, String lugar, String explicacion, String tipoAsistencia, Double importe) {
        this.id = id;
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.importe = importe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(String tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
